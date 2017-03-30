package com.kms.test.PASystem.tasks;

import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

public class Hover implements Task{
	private WebElementFacade elementFacade;
	private String elementName;
	protected Hover(WebElementFacade elementFacade, String elementName) {
		super();
		this.elementFacade = elementFacade;
		this.elementName = elementName;
		this.elementName = this.elementName+""; //silly statement to remove warning
	}
	@Override
	@Step("{0} hovers on element #elementName")
	public <T extends Actor> void performAs(T actor) {
		Actions action = new Actions(BrowseTheWeb.as(actor).getDriver());
		action.moveToElement(elementFacade).build().perform();
	}
	public static Performable element(WebElementFacade webElementFacade, String elementName) {
		// TODO Auto-generated method stub
		return Instrumented.instanceOf(Hover.class).withProperties(webElementFacade, elementName);
	}

}
