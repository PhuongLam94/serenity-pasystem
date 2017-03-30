package com.kms.test.PASystem.tasks;

import com.kms.test.PASystem.ui.LoginPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class Login implements Task{

	private String username;
	private String password;
	
	protected Login(String username, String password){
		this.username = username;
		this.password = password;
	}
	@Step("{0} enter authentication info with username '#username' and password '#password'")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(username).into(LoginPage.USERNAME_FIELD));
		actor.attemptsTo(Enter.theValue(password).into(LoginPage.PASSWORD_FIELD));
		actor.attemptsTo(Click.on(LoginPage.LOGIN_BUTTON));
	}

	public static Login with(String username, String password) {
		return Instrumented.instanceOf(Login.class).withProperties(username, password);
	}

}
