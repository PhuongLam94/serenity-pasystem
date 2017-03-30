package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.CreateFeedbackPage;
import com.kms.test.PASystem.ui.EditFeedbackPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Value;

public class DisplayedDate implements Question<String>{
	boolean isCreatePage;
	protected DisplayedDate(boolean isCreatePage) {
		super();
		this.isCreatePage = isCreatePage;
	}

	@Override
	public String answeredBy(Actor arg0) {
		return Value.of(isCreatePage? CreateFeedbackPage.FOR_DATE_FIELD:
			EditFeedbackPage.FOR_DATE_FIELD)
			.viewedBy(arg0).asString();
	}

	public static DisplayedDate ofCreateOrEditPageIs(boolean isCreatePage) {
		// TODO Auto-generated method stub
		return new DisplayedDate(isCreatePage);
	}

}
