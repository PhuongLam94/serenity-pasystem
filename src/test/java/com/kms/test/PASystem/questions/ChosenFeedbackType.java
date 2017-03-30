package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.CreateFeedbackPage;
import com.kms.test.PASystem.ui.FeedbackPage;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.SelectedStatus;

public class ChosenFeedbackType implements Question<String>{

	@Override
	public String answeredBy(Actor arg0) {
		if (SelectedStatus.of(
			CreateFeedbackPage.SHORT_FEEDBACK_CHECKBOX)
				.viewedBy(arg0).asBoolean()
			){
			return Global.SHORT_FEEDBACK;
		} else {
			return Global.FULL_FEEDBACK;
		}
	}

	public static ChosenFeedbackType is() {
		// TODO Auto-generated method stub
		return new ChosenFeedbackType();
	}
	
}
