package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.LoginPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ThePageMessage implements Question<String>{

	LoginPage loginPage;
	@Override
	public String answeredBy(Actor actor) {
		// TODO Auto-generated method stub
		return Text.of(LoginPage.PAGE_MESSAGE).viewedBy(actor).asString();
	}

	public static Question<? extends Object> text() {
		return new ThePageMessage();
	}

}
