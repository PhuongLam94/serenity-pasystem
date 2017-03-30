package com.kms.test.PASystem.tasks;

import java.util.List;

import com.kms.test.PASystem.questions.SearchButtonEnabled;
import com.kms.test.PASystem.ui.SearchFeedbackPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromTarget;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

public class FilterViewFeedback implements Task {

	String viewOptions;
	String fromDate;
	String toDate;
	String employee;
	List<String> status;

	protected FilterViewFeedback(String viewOptions, String fromDate, String toDate, String employee,
			List<String> status) {
		super();
		this.viewOptions = viewOptions;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.employee = employee;
		this.status = status;
	}

	public static Performable with(String viewOptions, String fromDate, String toDate, String employee,
			List<String> status) {
		return Instrumented.instanceOf(FilterViewFeedback.class).withProperties(viewOptions, fromDate, toDate, employee,
				status);
	}

	@Override
	@Step("{0} filters the feedback conditions")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Instrumented.instanceOf(SelectByVisibleTextFromTarget.class)
				.withProperties(SearchFeedbackPage.VIEW_OPTION_SELECT, viewOptions));
		if (fromDate != null)
			actor.attemptsTo(SelectDate.withInputImgAndValue(SearchFeedbackPage.FROM_DATE_FIELD,
					SearchFeedbackPage.FROM_DATE_IMG, fromDate));
		if (toDate != null)
			actor.attemptsTo(SelectDate.withInputImgAndValue(SearchFeedbackPage.TO_DATE_FIELD,
					SearchFeedbackPage.TO_DATE_IMG, toDate));
		if (employee != null)
			actor.attemptsTo(Enter.theValue(employee).into(SearchFeedbackPage.EMPLOYEE_FIELD));
		if (status != null) {
			actor.attemptsTo(SelectStatus.withValues(status));
		}
		actor.should(seeThat(SearchButtonEnabled.is(), is(true)));
	}

}
