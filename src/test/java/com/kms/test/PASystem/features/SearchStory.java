package com.kms.test.PASystem.features;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.kms.test.PASystem.questions.ButtonStatus;
import com.kms.test.PASystem.tasks.LoginWithValidInfo;
import com.kms.test.PASystem.tasks.OpenTheApplication;
import com.kms.test.PASystem.tasks.SearchForFeedback;
import com.kms.test.PASystem.utils.Global;
import com.kms.test.PASystem.utils.Paging;
import com.kms.test.PASystem.utils.SearchFilter;
import com.kms.test.PASystem.utils.Status;
import com.kms.test.PASystem.utils.Utils;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;

@RunWith(SerenityRunner.class)
@WithTag("feature:search")
public class SearchStory {
	Actor sandra = Actor.named("Sandra");
	
	@Managed(driver="chrome")
	WebDriver herDriver;
	
	@Steps
	OpenTheApplication openTheApplication;
	
	@Steps
	LoginWithValidInfo loginWithValidInfo;
	
	
	@Before
	public void sandra_can_browse_the_web(){
		Utils.clearReportFolder();
		sandra.can(BrowseTheWeb.with(herDriver));
	}
	
	@Test
	public void the_buttons_should_be_on_right_state_when_choosing_rows(){
		SearchFilter searchFilter = new SearchFilter(
				Global.MY_FEEDBACK_FOR_OTHERS, null, null, null, 
				Arrays.asList(Status.DRAFT, Status.APPROVED, 
						Status.DISAPPROVED, Status.PENDING));
		Paging paging = new Paging(1, 10, 16);
		
		givenThat(sandra).wasAbleTo(
				openTheApplication,
				loginWithValidInfo);
		when(sandra).attemptsTo(SearchForFeedback.withFilterAndPagingResult(searchFilter, paging));
		then(sandra).should(seeThat(ButtonStatus.isRightWhenChoosingDifferentRow(), equalTo(true)));
		
	}
	@Test
	public void sandra_should_see_expected_result_when_filtering_date(){
		SearchFilter searchFilter = new SearchFilter(
				Global.MY_FEEDBACK_FOR_OTHERS, "03/16/2017", "03/17/2017",
				null, null);
		Paging paging = new Paging(1, 10, 7);
		
		givenThat(sandra).wasAbleTo(
				openTheApplication,
				loginWithValidInfo);
		when(sandra).attemptsTo(SearchForFeedback.withFilterAndPagingResult(searchFilter, paging));
		
	}
}
