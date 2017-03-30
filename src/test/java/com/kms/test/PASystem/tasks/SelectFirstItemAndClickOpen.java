package com.kms.test.PASystem.tasks;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.kms.test.PASystem.ui.SearchFeedbackPage;
import com.kms.test.PASystem.utils.Button;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class SelectFirstItemAndClickOpen implements Task{

	@Step("{0} selects first item in feedback result table and click open button")
	@Override
	public <T extends Actor> void performAs(T actor) {
		WebDriver driver = BrowseTheWeb.as(actor).getDriver();
		actor.attemptsTo(Click.on(SearchFeedbackPage.FEEDBACK_ROW));
		actor.attemptsTo(Click.on("#"+Button.OPEN));
		Iterator<String> handles = driver.getWindowHandles().iterator();
		handles.next();
		driver.switchTo().window(handles.next());
		
	}

}
