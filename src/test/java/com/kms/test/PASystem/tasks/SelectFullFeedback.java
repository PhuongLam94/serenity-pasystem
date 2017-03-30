package com.kms.test.PASystem.tasks;

import com.kms.test.PASystem.questions.DefaultNumberOfTabsAndSelectedTab;
import com.kms.test.PASystem.questions.NumberOfTabsDipslayed;
import com.kms.test.PASystem.questions.SelectedTab;
import com.kms.test.PASystem.ui.CreateFeedbackPage;
import com.kms.test.PASystem.ui.FeedbackPage;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

public class SelectFullFeedback implements Task{

	@Step("{0} selects full feedback option")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(CreateFeedbackPage.FULL_FEEDBACK_CHECKBOX));
		actor.should(
				seeThat(DefaultNumberOfTabsAndSelectedTab.isTrue())
		);
	}

}
