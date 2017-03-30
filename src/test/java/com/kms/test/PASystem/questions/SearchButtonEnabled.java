package com.kms.test.PASystem.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import com.kms.test.PASystem.ui.SearchFeedbackPage;
public class SearchButtonEnabled implements Question<Boolean>{

	@Override
	public Boolean answeredBy(Actor actor) {
		return SearchFeedbackPage.SEARCH_BUTTON.resolveFor(actor).isEnabled();
	}

	public static Question<? extends Boolean> is() {
		return new SearchButtonEnabled();
	}

}
