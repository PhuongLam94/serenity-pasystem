package com.kms.test.PASystem.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

import com.kms.test.PASystem.questions.TargetVisibility;
public class ClickATab implements Task{
	private WebElementFacade title;
	private WebElementFacade content;
	
	protected ClickATab(WebElementFacade title, WebElementFacade content) {
		super();
		this.title = title;
		this.content = content;
	}
	@Step("{0} clicks for a tab called #title")
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(title));
		actor.should(seeThat(TargetVisibility.of(content), equalTo(true)));
		
	}

	public static ClickATab withTitleAndContentElement(WebElementFacade title,
			WebElementFacade content) {
		// TODO Auto-generated method stub
		return Instrumented.instanceOf(ClickATab.class)
				.withProperties(title, content);
	}

}
