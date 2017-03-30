package com.kms.test.PASystem.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Enabled;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class ButtonEnablity implements Question<Boolean>{

	private String buttonID;
	protected ButtonEnablity(String buttonID) {
		super();
		this.buttonID = buttonID;
	}

	@Step("#buttonID enablity")
	@Override
	public Boolean answeredBy(Actor arg0) {
		Target button = Target.the(buttonID+" button")
				.locatedBy("#"+buttonID);
		return Enabled.of(button).viewedBy(arg0).asBoolean() == true;
	}

	public static Question<? extends Boolean> is(String buttonID) {
		return new ButtonEnablity(buttonID);
	}

}
