package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.SearchFeedbackPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;

public class ThePagingInfo implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		String tdText = Text.of(SearchFeedbackPage.PAGE_INFO_TD)
			.viewedBy(actor).asString();
		int currentPage = Value.of(SearchFeedbackPage.CURRENT_PAGE_FIELD)
				.viewedBy(actor).asInteger();
		String pageInfoText = new StringBuilder(tdText)
				.insert(tdText.indexOf(" of"), currentPage).toString();
		return pageInfoText;
	}

	public static ThePagingInfo is() {
		return new ThePagingInfo();
	}
	
}
