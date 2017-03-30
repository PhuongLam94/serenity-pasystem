package com.kms.test.PASystem.questions;

import java.util.List;

import com.kms.test.PASystem.ui.SearchFeedbackPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class HeadersInfo implements Question<List<String>>{

	@Override
	public List<String> answeredBy(Actor actor) {
		return Text.of(SearchFeedbackPage.HEADERS)
				.viewedBy(actor).asList();
	}

	public static HeadersInfo all() {
		// TODO Auto-generated method stub
		return new HeadersInfo();
	}

}
