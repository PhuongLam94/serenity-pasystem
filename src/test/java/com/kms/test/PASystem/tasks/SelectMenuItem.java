package com.kms.test.PASystem.tasks;

import java.util.Arrays;
import java.util.List;

import net.serenitybdd.screenplay.questions.CurrentVisibility;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class SelectMenuItem implements Task{
	List<Target> menuItems;
	protected SelectMenuItem(List<Target> menuItems) {
		super();
		this.menuItems = menuItems;
	}

	public static Performable withTargets(Target... menuItems) {
		return Instrumented.instanceOf(SelectMenuItem.class)
				.withProperties(Arrays.asList(menuItems));
	}
	@Step("{0} chooses a list of menu items: #menuItems")
	@Override
	public <T extends Actor> void performAs(T actor) {
		chooseMenuItems(actor, menuItems);
	}
	private void chooseMenuItems(Actor actor, List<Target> itemsToChoose){
		Target firstItemInList = itemsToChoose.get(0);
		if (itemsToChoose.size() == 1){
			actor.attemptsTo(Click.on(firstItemInList));
		} else {
			boolean childIsVisible = false;
			Target secondItemInList = itemsToChoose.get(1);
			while (!childIsVisible){
				actor.attemptsTo(Hover.element(firstItemInList.resolveFor(actor), 
						firstItemInList.getName()));
				if (CurrentVisibility.of(secondItemInList).viewedBy(actor)
						.asBoolean())
					childIsVisible = true;
			}
			chooseMenuItems(actor, itemsToChoose.subList(1, itemsToChoose.size()));
		}
	}

}
