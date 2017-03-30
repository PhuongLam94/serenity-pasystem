package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.SearchFeedbackPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheNotiMessage implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		return Text.of(SearchFeedbackPage.NOTI_MESSAGE_DIV)
				.viewedBy(actor).asString();
	}

	public static TheNotiMessage is() {
		// TODO Auto-generated method stub
		return new TheNotiMessage();
	}

}
