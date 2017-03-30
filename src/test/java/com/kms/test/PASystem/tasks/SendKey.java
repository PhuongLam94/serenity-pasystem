package com.kms.test.PASystem.tasks;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class SendKey implements Interaction{
	private Target target;
	private String content;

	protected SendKey(Target target, String content) {
		super();
		this.target = target;
		this.content = content;
	}
	@Step("{0} sends key with content of #content to #target")
	@Override
	public <T extends Actor> void performAs(T arg0) {
		WebElement element = target.resolveFor(arg0);
		element.sendKeys(content);
		
	}

	public static Performable toTargetWithContent(Target target, String content) {
		// TODO Auto-generated method stub
		return Instrumented.instanceOf(SendKey.class)
				.withProperties(target, content);
	}

}
