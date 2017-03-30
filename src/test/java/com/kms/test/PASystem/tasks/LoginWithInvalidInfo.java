package com.kms.test.PASystem.tasks;

import static net.serenitybdd.screenplay.GivenWhenThen.and;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import com.kms.test.PASystem.questions.ThePageMessage;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Step;

public class LoginWithInvalidInfo implements Task{
	
	
	@Step("{0} logs in unsuccessfully with username '#username' and password '#password'")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Login.with(Global.INVALID_USERNAME, Global.INVALID_PASSWORD));
		actor.should(seeThat(TheWebPage.title(), equalTo(Global.LOGIN_PAGE_TITLE)));
		and(actor).should(seeThat(ThePageMessage.text(), equalTo(Global.LOGIN_ERR_MESSAGE)));
		
	}

}
