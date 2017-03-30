package com.kms.test.PASystem.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TargetVisibility implements Question<Boolean>{
	private WebElementFacade content;
	public TargetVisibility(WebElementFacade content) {
		this.content = content;
	}

	@Override
	public Boolean answeredBy(Actor arg0) {
		return content.isVisible();
	}

	public static TargetVisibility of(WebElementFacade content) {
		
		return new TargetVisibility(content);
	}

}
