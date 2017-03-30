package com.kms.test.PASystem.features;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.kms.test.PASystem.questions.FirstItemStatus;
import com.kms.test.PASystem.tasks.CheckForOtherTabs;
import com.kms.test.PASystem.tasks.ClickEditAndCheckForGeneralInfo;
import com.kms.test.PASystem.tasks.ClickOnButtonInFeedbackPage;
import com.kms.test.PASystem.tasks.ClickOnEachTabThenReturnToFirstTab;
import com.kms.test.PASystem.tasks.CreateFullFeedback;
import com.kms.test.PASystem.tasks.LoginWithValidInfo;
import com.kms.test.PASystem.tasks.OpenTheApplication;
import com.kms.test.PASystem.tasks.SearchForFeedback;
import com.kms.test.PASystem.tasks.SelectFirstItemAndClickOpen;
import com.kms.test.PASystem.utils.Global;
import com.kms.test.PASystem.utils.SearchFilter;
import com.kms.test.PASystem.utils.Status;
import com.kms.test.PASystem.utils.Utils;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;

@RunWith(SerenityRunner.class)
@WithTag("feature:feedback")
public class FeedbackStory {
	Actor baoPham = Actor.named("Bao Pham");
	
	@Managed(driver="chrome")
	WebDriver hisBrowser;

	@Steps
	private SelectFirstItemAndClickOpen selectFirstItemAndClickOpen;

	@Steps
	private ClickEditAndCheckForGeneralInfo clickEditAndCheckForGeneralInfo;

	@Steps
	private ClickOnEachTabThenReturnToFirstTab clickOnEachTabThenReturnToFirstTab;

	@Steps
	private CheckForOtherTabs checkForOtherTabs;

	@Steps
	private OpenTheApplication openTheApplication;

	@Steps
	private LoginWithValidInfo loginWithValidInfo;
	
	@Before
	public void bao_can_browse_the_web(){
		Utils.clearReportFolder();
		baoPham.can(BrowseTheWeb.with(hisBrowser));
	}
	
	
	@Test
	public void bao_can_create_full_feedback(){
		baoPham.attemptsTo(CreateFullFeedback.submitIs(true));
	}
	@WithTag("feedbackType:edit")
	@Test
	public void bao_should_be_able_to_view_and_edit_full_feedback(){
		SearchFilter searchFilter = new SearchFilter
				(Global.FEEDBACK_FOR_ME, null, null, null, null);
		givenThat(baoPham).wasAbleTo(
				CreateFullFeedback.submitIs(false)
				//openTheApplication,
				//loginWithValidInfo,
				//SearchForFeedback.withFilterAndPagingResult(searchFilter, null)
		);
		when(baoPham).attemptsTo(
				selectFirstItemAndClickOpen
				,clickEditAndCheckForGeneralInfo
				,clickOnEachTabThenReturnToFirstTab
				,checkForOtherTabs
				,ClickOnButtonInFeedbackPage.isSubmitBtn(true)
				,SearchForFeedback.withFilterAndPagingResult(searchFilter, null)
		);
//		then(baoPham).should(
//				seeThat(FirstItemStatus.is(), equalTo(Status.APPROVED))
//			);
		
		
	}
}
