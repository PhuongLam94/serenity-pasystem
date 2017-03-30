package com.kms.test.PASystem.features;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.kms.test.PASystem.tasks.LoginWithInvalidInfo;
import com.kms.test.PASystem.tasks.LoginWithValidInfo;
import com.kms.test.PASystem.tasks.Logout;
import com.kms.test.PASystem.tasks.OpenTheApplication;
import com.kms.test.PASystem.utils.Utils;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;

@RunWith(SerenityRunner.class)
@WithTag("feature:login")
public class LoginStory {
	Actor john = Actor.named("John");
	
	@Managed(driver="chrome")
	public WebDriver hisDriver;

	@Steps
	OpenTheApplication openTheApplication;
	
	@Steps
	LoginWithInvalidInfo loginWithInvalidInfo;
	
	@Steps
	LoginWithValidInfo loginWithValidInfo;
	
	@Steps
	Logout logout;
	
	@Before
	public void john_can_browse_the_web(){
		Utils.clearReportFolder();
		john.can(BrowseTheWeb.with(hisDriver));
	}
	
	
	@Test
	public void john_should_be_able_to_login_and_logout_PA_system_successfully(){
		givenThat(john).wasAbleTo(openTheApplication);
		when(john).attemptsTo(loginWithValidInfo);
		then(john).wasAbleTo(logout);
	}
	
	@Test
	public void john_should_be_able_to_perform_several_login_scenarios(){
		givenThat(john).wasAbleTo(openTheApplication);
		when(john).attemptsTo(loginWithInvalidInfo);
		then(john).attemptsTo(loginWithValidInfo);
		then(john).wasAbleTo(logout);
		
	}
}
