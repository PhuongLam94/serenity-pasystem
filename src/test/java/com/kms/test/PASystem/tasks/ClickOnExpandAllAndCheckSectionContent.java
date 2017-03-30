package com.kms.test.PASystem.tasks;

import java.util.List;

import com.kms.test.PASystem.questions.NumberOfSection;
import com.kms.test.PASystem.questions.SectionContent;
import com.kms.test.PASystem.ui.FeedbackPage;
import com.kms.test.PASystem.ui.KMSCoreValueSection;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

public class ClickOnExpandAllAndCheckSectionContent implements Task{

	@Step("{0} clicks on Expand All in KMS Core Value tab and check for section content")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(KMSCoreValueSection.EXPAND_ALL_LINK));
		actor.should(seeThat(NumberOfSection.is(), equalTo(Global.NUMBER_OF_SECTIONS)));
		List<WebElementFacade> sections = KMSCoreValueSection.KMS_CORE_VAL_SECTION_FRAME
				.resolveAllFor(actor);
		for (int i = 0; i < sections.size(); i++){
			actor.should(seeThat(
					SectionContent.withFrame(sections.get(i)),
					containsInAnyOrder(Global.KMS_CORE_VALUE_SECTION_CONTENT
							.get(i).toArray())
			));
		}
	}

}
