package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.SearchFeedbackPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheViewInfo implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(SearchFeedbackPage.VIEW_INFO_DIV)
				.viewedBy(actor).asString();
	}

	public static TheViewInfo is() {
		// TODO Auto-generated method stub
		return new TheViewInfo();
	}

}
