package com.kms.test.PASystem.tasks;

import com.kms.test.PASystem.ui.LoginPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.*;
public class OpenTheApplication implements Task{
	LoginPage loginPage;
	
	@Step("Open the application")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Open.browserOn().the(loginPage));
	}

	public static Performable onLoginPage() {
		return instrumented(OpenTheApplication.class);
	}

}
