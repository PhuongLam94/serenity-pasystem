package com.kms.test.PASystem.tasks;

import java.util.List;

import com.kms.test.PASystem.ui.SearchFeedbackPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class SelectStatus implements Task{
	private List<String> status;
	protected SelectStatus(List<String> status) {
		super();
		this.status = status;
	}

	@Step("{0} select status #status to filter")
	@Override
	public <T extends Actor> void performAs(T actor) {
		for(WebElementFacade element : SearchFeedbackPage.STATUS_CHECKBOXES(actor)){
			if (elementShouldBeClicked(element)){
				actor.attemptsTo(Click.on(element));
			}
			
		}
		
	}
	private boolean elementShouldBeClicked(WebElementFacade element){
		return (status.contains(element.getValue()) && !element.isSelected())
				|| (!status.contains(element.getValue()) && element.isSelected());
	}
	public static Performable withValues(List<String> status) {
		return Instrumented.instanceOf(SelectStatus.class)
				.withProperties(status);
	}

}
