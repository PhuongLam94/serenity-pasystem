package com.kms.test.PASystem.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Value;
import net.serenitybdd.screenplay.targets.Target;

public class DateString implements Question<String>{
	private Target input;
	public DateString(Target input) {
		this.input = input;
	}

	public static Question<? extends String> of(Target input) {
		return new DateString(input);
	}

	@Override
	public String answeredBy(Actor arg0) {
		return Value.of(input).viewedBy(arg0).asString();
	}

}
