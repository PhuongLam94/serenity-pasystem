package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.FeedbackPage;
import com.kms.test.PASystem.ui.KMSCoreValueSection;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class NumberOfSection implements Question<Integer> {

	@Override
	public Integer answeredBy(Actor arg0) {
		return KMSCoreValueSection.KMS_CORE_VAL_SECTION_FRAME.resolveAllFor(arg0)
				.size();
	}

	public static NumberOfSection is() {
		// TODO Auto-generated method stub
		return new NumberOfSection();
	}

}
