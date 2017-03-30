package com.kms.test.PASystem.tasks;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.equalTo;

import com.kms.test.PASystem.questions.FirstItemStatus;
import com.kms.test.PASystem.utils.Global;
import com.kms.test.PASystem.utils.Paging;
import com.kms.test.PASystem.utils.SearchFilter;
import com.kms.test.PASystem.utils.Status;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.*;

public class CreateFullFeedback implements Task{
	private boolean pressSubmitButton;
	protected CreateFullFeedback(boolean pressSubmitButton) {
		super();
		this.pressSubmitButton = pressSubmitButton;
	}

	@Step("{0} creates full feedback")
	@Override
	public <T extends Actor> void performAs(T actor) {
		SearchFilter searchFilter = new SearchFilter
				(Global.FEEDBACK_FOR_ME, null, null, null, null);
		Paging paging = new Paging(1, 10, 91);
		givenThat(actor).wasAbleTo(
				instrumented(OpenTheApplication.class),
						instrumented(LoginWithValidInfo.class)
					);
			when(actor).attemptsTo(
					instrumented(EnterTheProvideFeedbackPage.class)
					,instrumented(SelectFullFeedback.class)
					,instrumented(ClickOnEachTabThenReturnToFirstTab.class)
					,instrumented(CheckForKMSCoreValueTab.class)
					,ClickOnButtonInFeedbackPage.isSubmitBtn(pressSubmitButton)
					,SearchForFeedback.withFilterAndPagingResult(searchFilter, null)
			);
			then(actor).should(
				seeThat(FirstItemStatus.is(), equalTo(pressSubmitButton?Status.APPROVED:Status.DRAFT))
			);
		
	}

	public static CreateFullFeedback submitIs(boolean b) {
		// TODO Auto-generated method stub
		return Instrumented.instanceOf(CreateFullFeedback.class)
				.withProperties(b);
	}

}
