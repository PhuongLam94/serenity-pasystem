package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.EditFeedbackPage;
import com.kms.test.PASystem.ui.FeedbackPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Value;

public class ChosenEmployee implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		// TODO Auto-generated method stub
		return Value.of(EditFeedbackPage.EMPLOYEE_FIELD)
				.viewedBy(actor).asString();
	}

	public static ChosenEmployee is() {
		return new ChosenEmployee();
	}

}
