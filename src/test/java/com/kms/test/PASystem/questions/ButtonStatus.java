package com.kms.test.PASystem.questions;

import java.util.Arrays;

import com.kms.test.PASystem.tasks.SelectRowsAndCheckBtnStatus;
import com.kms.test.PASystem.utils.Button;
import com.kms.test.PASystem.utils.Status;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ButtonStatus implements Question<Boolean>{

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.attemptsTo(SelectRowsAndCheckBtnStatus.
				withRowsAndEnabledButtons(Arrays.asList(Status.DRAFT),
						Arrays.asList(Button.SUBMIT, Button.OPEN, Button.REMOVE, 
								Button.PREVIEW, Button.NEW)));
		actor.attemptsTo(SelectRowsAndCheckBtnStatus.
				withRowsAndEnabledButtons(Arrays.asList(Status.APPROVED),
						Arrays.asList(Button.OPEN, Button.NEW, 
								Button.PREVIEW)));
		actor.attemptsTo(SelectRowsAndCheckBtnStatus.
				withRowsAndEnabledButtons(Arrays.asList(Status.DRAFT,Status.APPROVED),
						Arrays.asList(Button.NEW, Button.PREVIEW)));
		return true;
	}

	public static Question<Boolean> isRightWhenChoosingDifferentRow() {
		return new ButtonStatus();
	}

}
