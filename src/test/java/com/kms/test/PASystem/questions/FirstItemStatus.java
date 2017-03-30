package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.SearchFeedbackPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class FirstItemStatus implements Question<String>{

	public static FirstItemStatus is() {
		// TODO Auto-generated method stub
		return new FirstItemStatus();
	}

	@Override
	public String answeredBy(Actor arg0) {
		// TODO Auto-generated method stub
		return Text.of(SearchFeedbackPage.STATUS_CELL_OF_FEEDBACK_ROW)
				.viewedBy(arg0).asString();
	}

}
