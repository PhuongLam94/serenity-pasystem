package com.kms.test.PASystem.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.kms.test.PASystem.questions.TheNotiMessage;
import com.kms.test.PASystem.ui.SearchFeedbackPage;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

public class SearchButtonClick implements Task {

	public static SearchButtonClick go() {
		return instrumented(SearchButtonClick.class);
	}
	@Step("{0} clicks on Search button")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(SearchFeedbackPage.SEARCH_BUTTON));
		actor.should(seeThat(TheNotiMessage.is(), equalTo(Global.SEARCH_SUCCESSFULLLY_MESSAGE)));
	}

}
