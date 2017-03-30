package com.kms.test.PASystem.tasks;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import com.kms.test.PASystem.questions.ButtonEnablity;
import com.kms.test.PASystem.ui.SearchFeedbackPage;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class SelectRowsAndCheckBtnStatus implements Task{
	List<String> chosenRowStatus;
	List<String> buttonShouldBeEnabled;
	protected SelectRowsAndCheckBtnStatus(List<String> chosenRowStatus, List<String> buttonShouldBeEnabled) {
		super();
		this.chosenRowStatus = chosenRowStatus;
		this.buttonShouldBeEnabled = buttonShouldBeEnabled;
	}

	@Step("{0} selects row(s) and checks for button state")
	@Override
	public <T extends Actor> void performAs(T actor) {
		clickOnRowsWithStatus(actor);
		for (String buttonID : Global.LIST_OF_BUTTON_IDS){
			actor.should(seeThat(ButtonEnablity.is(buttonID), equalTo(
					buttonShouldBeEnabled.indexOf(buttonID) != -1
			)));
		}
		clickOnRowsWithStatus(actor);
	}

	private void clickOnRowsWithStatus(Actor actor) {
		for (String status : chosenRowStatus){
			actor.attemptsTo(Click.on(
					SearchFeedbackPage.GET_FEEDBACK_CHECKBOX_BY_STATUS(status)
			));
		}
		
	}

	public static Performable withRowsAndEnabledButtons(List<String> chosenRowStatus, List<String> buttonShouldBeEnabled) {
		return Instrumented.instanceOf(SelectRowsAndCheckBtnStatus.class)
				.withProperties(chosenRowStatus, buttonShouldBeEnabled);
	}
	
}
