package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.FeedbackPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class NumberOfTabsDipslayed implements Question<Integer>{

	@Override
	public Integer answeredBy(Actor arg0) {
		int numOfTabTitles = FeedbackPage.TAB_TITLE_LINK
				.resolveAllFor(arg0).size();
		int numOfTabContents = FeedbackPage.TAB_CONTENT_DIV
				.resolveAllFor(arg0).size();
		
		return numOfTabTitles == numOfTabContents? numOfTabContents : -1;
	}

	public static NumberOfTabsDipslayed is() {
		// TODO Auto-generated method stub
		return new NumberOfTabsDipslayed();
	}

}
