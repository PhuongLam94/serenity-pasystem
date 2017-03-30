package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.FeedbackPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ParagraphContent implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		// TODO Auto-generated method stub
		return Text.of(FeedbackPage.SECTION_PARAGRAPH)
				.viewedBy(actor).asString().trim();
	}

	public static ParagraphContent is() {
		// TODO Auto-generated method stub
		return new ParagraphContent();
	}

}
