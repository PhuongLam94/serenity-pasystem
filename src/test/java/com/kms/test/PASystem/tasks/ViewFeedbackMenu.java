package com.kms.test.PASystem.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.*;

import com.kms.test.PASystem.ui.HomePage;

public class ViewFeedbackMenu implements Task{

	public static Performable go() {
		return instrumented(ViewFeedbackMenu.class);
	}

	@Step("{0} enters search feedback menu page")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(SelectMenuItem.withTargets(HomePage.VIEW_FEEDBACKS_MENU,
				HomePage.SEARCH_ALL_MENU));
	}

}
