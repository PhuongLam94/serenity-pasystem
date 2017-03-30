package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.CreateFeedbackPage;
import com.kms.test.PASystem.ui.EditFeedbackPage;
import com.kms.test.PASystem.ui.FeedbackPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.SelectedVisibleTextValue;
import net.serenitybdd.screenplay.questions.Value;

public class ChosenProvideFeedbackFor implements Question<String>{

	boolean isCreatePage;
	protected ChosenProvideFeedbackFor(boolean isCreatePage) {
		super();
		this.isCreatePage = isCreatePage;
	}

	@Override
	public String answeredBy(Actor arg0) {
		if (isCreatePage)
			return SelectedVisibleTextValue.of(CreateFeedbackPage.PROVIDE_FEEDBACK_FOR_SELECT)
			.viewedBy(arg0).asString();
		else
			return Value.of(EditFeedbackPage.PROVIDE_FEEDBACK_FOR_SELECT)
				.viewedBy(arg0).asString();
	}

	public static ChosenProvideFeedbackFor ofCreateOrEditPageIs(boolean isCreatePage) {
		return new ChosenProvideFeedbackFor(isCreatePage);
	}

}
