package com.kms.test.PASystem.questions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Date;

import com.kms.test.PASystem.utils.Global;
import com.kms.test.PASystem.utils.Utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

public class GeneralFeedbackInformation implements Question<Boolean>{

	private boolean isCreatePage;
	private String feedbackType;
	private String provideFeedbackFor;
	private String displaypedDate;
	private String employeeName;
	private String status;
	protected GeneralFeedbackInformation(boolean isCreatePage, String feedbackType, String provideFeedbackFor, String displaypedDate) {
		super();
		this.isCreatePage = isCreatePage;
		this.feedbackType = feedbackType;
		this.provideFeedbackFor = provideFeedbackFor;
		this.displaypedDate = displaypedDate;
	}

	

	protected GeneralFeedbackInformation(boolean isCreatePage, String provideFeedbackFor, String displaypedDate,
			String employeeName, String status) {
		super();
		this.isCreatePage = isCreatePage;
		this.provideFeedbackFor = provideFeedbackFor;
		this.displaypedDate = displaypedDate;
		this.employeeName = employeeName;
		this.status = status;
	}



	@Override
	public Boolean answeredBy(Actor actor) {
		actor.should(			
				seeThat(ChosenProvideFeedbackFor.ofCreateOrEditPageIs(isCreatePage), equalTo(provideFeedbackFor)),
				seeThat(DisplayedDate.ofCreateOrEditPageIs(isCreatePage), equalTo(displaypedDate))
		);
		if (isCreatePage){
			actor.should(seeThat(ChosenFeedbackType.is(), equalTo(feedbackType)));
		} else {
			actor.should(
					seeThat(ChosenEmployee.is(), equalTo(employeeName)),
					seeThat(FeedbackStatus.is(), equalTo(status))
			);
		}
		return true;
	}

	public static Question<Boolean> forCreatePageIsTrue(String feedbackType, 
			String provideFeedbackFor, String displaypedDate) {
		return new GeneralFeedbackInformation(true,feedbackType, provideFeedbackFor, displaypedDate);
	}
	public static Question<Boolean> forEditPageIsTrue(String provideFeedbackFor, String displaypedDate,
			String employeeName, String status) {
		return new GeneralFeedbackInformation(false, provideFeedbackFor, displaypedDate,
				employeeName, status);
	}
}
