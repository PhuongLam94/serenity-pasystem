package com.kms.test.PASystem.tasks;

import com.kms.test.PASystem.questions.ChosenFeedbackType;
import com.kms.test.PASystem.questions.ChosenProvideFeedbackFor;
import com.kms.test.PASystem.questions.DisplayedDate;
import com.kms.test.PASystem.questions.GeneralFeedbackInformation;
import com.kms.test.PASystem.ui.HomePage;
import com.kms.test.PASystem.utils.Global;
import com.kms.test.PASystem.utils.Utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

import java.util.Date;

public class EnterTheProvideFeedbackPage implements Task{

	@Step("{0} enters provide feedback page")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				SelectMenuItem.withTargets(
						HomePage.PROVIDE_FEEDBACK_MENU));
		actor.should(
				seeThat(TheWebPage.title(), equalTo(Global.CREATE_FEEDBACK_PAGE_TITLE))
				,seeThat(GeneralFeedbackInformation.forCreatePageIsTrue(Global.SHORT_FEEDBACK,
						Global.MYSELF, Utils.formatDate(new Date(), "MM/dd/yyyy")))
		);
	}

}
