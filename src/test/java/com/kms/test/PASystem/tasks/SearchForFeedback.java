package com.kms.test.PASystem.tasks;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import com.kms.test.PASystem.questions.HeadersInfo;
import com.kms.test.PASystem.questions.ThePagingInfo;
import com.kms.test.PASystem.questions.TheViewInfo;
import com.kms.test.PASystem.utils.Global;
import com.kms.test.PASystem.utils.Paging;
import com.kms.test.PASystem.utils.SearchFilter;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class SearchForFeedback implements Task{
	private SearchFilter searchFilter;
	private Paging paging;
	
	protected SearchForFeedback(SearchFilter searchFilter, Paging paging) {
		super();
		this.searchFilter = searchFilter;
		this.paging = paging;
	}
	@Step("{0} searches for feedback with filters #searchFilter and expected paging #paging")
	@Override
	public <T extends Actor> void performAs(T actor) {
		when(actor).attemptsTo(
				ViewFeedbackMenu.go(),
				FilterViewFeedback.with(searchFilter.getViewOptions(),
						searchFilter.getFromDate(), searchFilter.getToDate(),
						searchFilter.getEmployee(), searchFilter.getStatus()),
				SearchButtonClick.go()
		);
		if (paging!=null){
			then(actor).should(seeThat(ThePagingInfo.is(), equalTo(paging.getPagingInfoStatement())));
			then(actor).should(seeThat(TheViewInfo.is(), equalTo(paging.getViewInfoStatement())));
			
		}
		then(actor).should(seeThat(HeadersInfo.all(), containsInAnyOrder(Global.FEEDBACK_RESULT_HEADERS)));
		
	}

	public static Performable withFilterAndPagingResult(SearchFilter searchFilter, Paging paging) {
		return Instrumented.instanceOf(SearchForFeedback.class)
				.withProperties(searchFilter, paging);
	}

}
