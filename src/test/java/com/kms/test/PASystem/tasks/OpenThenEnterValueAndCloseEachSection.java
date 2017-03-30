package com.kms.test.PASystem.tasks;

import java.util.List;

import com.kms.test.PASystem.ui.FeedbackPage;
import com.kms.test.PASystem.ui.KMSCoreValueSection;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class OpenThenEnterValueAndCloseEachSection implements Task {

	@Step("{0} performs actions on each section of KMS Core Value tab")
	@Override
	public <T extends Actor> void performAs(T actor) {
		List<WebElementFacade> sections = KMSCoreValueSection.KMS_CORE_VAL_SECTION_FRAME
				.resolveAllFor(actor);
		for (int i=0; i<sections.size(); i++){
			actor.attemptsTo(ClickOnIcon.ofFrameWithPositionAndIsPlusIcon(sections.get(i), i, true));
			actor.attemptsTo(EnterValueInto.frame(sections.get(i)));
			actor.attemptsTo(ClickOnIcon.ofFrameWithPositionAndIsPlusIcon(sections.get(i), i, false));
			
		}
	}

}
