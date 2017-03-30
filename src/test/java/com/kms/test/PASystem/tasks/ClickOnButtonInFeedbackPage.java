package com.kms.test.PASystem.tasks;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import com.kms.test.PASystem.ui.FeedbackPage;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Step;

public class ClickOnButtonInFeedbackPage implements Task{
	private boolean isSubmitButton;
	private String buttonName;
	protected ClickOnButtonInFeedbackPage(boolean isSubmitButton) {
		this.isSubmitButton = isSubmitButton;
		buttonName = (isSubmitButton)? Global.SUBMIT_BUTTON_NAME:
			Global.SAVE_BUTTON_NAME;
		buttonName = buttonName + "";
	}

	@Step("{0} click on button #buttonName in feedback page")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(isSubmitButton?FeedbackPage.SUBMIT_BUTTON
				:FeedbackPage.SAVE_BUTTON));
		actor.should(seeThat(TheWebPage.title(), equalTo(Global.SEARCH_FEEDBACK_TITLE)));
		
	}

	public static Performable isSubmitBtn(boolean isSubmitButton) {
		// TODO Auto-generated method stub
		return Instrumented.instanceOf(ClickOnButtonInFeedbackPage.class)
				.withProperties(isSubmitButton);
	}

}
