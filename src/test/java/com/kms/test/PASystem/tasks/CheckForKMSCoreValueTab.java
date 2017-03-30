package com.kms.test.PASystem.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class CheckForKMSCoreValueTab implements Task{
	@Step("{0} checks for KMS Core Value tab")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
					instrumented(ClickOnExpandAllAndCheckSectionContent.class)
					,instrumented(ClickOnCollapseAll.class)
					,instrumented(OpenThenEnterValueAndCloseEachSection.class));
		
	}

}
