package com.kms.test.PASystem.tasks;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

import com.kms.test.PASystem.ui.HomePage;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Step;

public class Logout implements Task{

	public static Logout successfully() {
		return instrumented(Logout.class);
	}
	@Step("{0} logs out successfully")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(HomePage.LOGOUT_BUTTON));
		actor.should(seeThat(TheWebPage.title(), equalTo(Global.LOGIN_PAGE_TITLE)));
	}

}
