package com.kms.test.PASystem.tasks;

import java.util.List;

import com.kms.test.PASystem.questions.TargetVisibility;
import com.kms.test.PASystem.ui.FeedbackPage;
import com.kms.test.PASystem.ui.KMSCoreValueSection;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

public class ClickOnCollapseAll implements Task{

	@Step("{0} clicks on Collapse All in KMS Core Value tab")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(KMSCoreValueSection.COLLAPSE_ALL_LINK));
		List<WebElementFacade> sections = KMSCoreValueSection.KMS_CORE_VAL_SECTION_FRAME
				.resolveAllFor(actor);
		for (WebElementFacade section : sections ){
			actor.should(seeThat(TargetVisibility.of(section), equalTo(false)));
		}
		
	}

}
