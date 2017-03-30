package com.kms.test.PASystem.tasks;

import com.kms.test.PASystem.questions.DefaultNumberOfTabsAndSelectedTab;
import com.kms.test.PASystem.questions.GeneralFeedbackInformation;
import com.kms.test.PASystem.ui.EditFeedbackPage;
import com.kms.test.PASystem.ui.FeedbackPage;
import com.kms.test.PASystem.utils.Global;
import com.kms.test.PASystem.utils.Status;
import com.kms.test.PASystem.utils.Utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

import java.util.Date;
public class ClickEditAndCheckForGeneralInfo implements Task{

	@Step("{0} click Edit button on Feedback Detail page and check for general information")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(EditFeedbackPage.EDIT_BUTTON));
		actor.should(seeThat(GeneralFeedbackInformation.forEditPageIsTrue(
				Global.MYSELF, Utils.formatDate(new Date(), "MM/dd/yyyy"),
				Global.USER_FULLNAME, Status.DRAFT)));
		actor.should(
				seeThat(DefaultNumberOfTabsAndSelectedTab.isTrue())
		);
	
	}

}
