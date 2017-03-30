package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.FeedbackPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class SelectedTab implements Question<String>{

	@Override
	public String answeredBy(Actor arg0) {
		return Text.of(FeedbackPage.SELECTED_TAB_LINK)
				.viewedBy(arg0).asString();
	}

	public static SelectedTab is() {
		// TODO Auto-generated method stub
		return new SelectedTab();
	}

}
