package com.kms.test.PASystem.tasks;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.equalTo;

import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Step;

public class LoginWithValidInfo implements Task{
	
	@Step("{0} logs in successfully with username '#username' and password '#password'")
	@Override
	public <T extends Actor> void performAs(T actor) {
		when(actor).attemptsTo(Login.with(Global.VALID_USERNAME, Global.VALID_PASSWORD));
		then(actor).should(seeThat(TheWebPage.title(), equalTo(Global.HOME_PAGE_TITLE)));
	}

}
