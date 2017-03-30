package com.kms.test.PASystem.tasks;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;

import com.kms.test.PASystem.questions.ParagraphContent;
import com.kms.test.PASystem.questions.LISize;
import com.kms.test.PASystem.ui.FeedbackPage;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*
;
public class EnterValueInto implements Task{

	private WebElementFacade frame;
	protected EnterValueInto(WebElementFacade frame) {
		super();
		this.frame = frame;
	}

	@Step("{0} enter value into #frame")
	@Override
	public <T extends Actor> void performAs(T actor) {
		WebDriver driver = BrowseTheWeb.as(actor).getDriver();
		driver.switchTo().frame(frame);
		List<WebElementFacade> ulNextP = FeedbackPage.SECTION_UL
				.resolveAllFor(actor);
		if (ulNextP.size() > 0){
			
			
			for (int i = 0 ; i<ulNextP.size(); i++){
				int previousSize;
				List<WebElementFacade> listOfLi = ulNextP.get(i).thenFindAll("li");
				if (ulIsEmpty(listOfLi)){
					previousSize = 0;
				} else {
					previousSize = listOfLi.size();
				}
				actor.attemptsTo(Click.on(ulNextP.get(i)));
				actor.attemptsTo(SendKey.toTargetWithContent(FeedbackPage.SECTION_BODY,
						Global.TEST_CONTENT));

				actor.should(seeThat(LISize.is(listOfLi), equalTo(previousSize+1)));
				
			}
		} else {
			actor.attemptsTo(Click.on(FeedbackPage.SECTION_PARAGRAPH));
			actor.attemptsTo(SendKey.toTargetWithContent(FeedbackPage.SECTION_BODY, 
					Global.TEST_CONTENT));
			actor.should(seeThat(ParagraphContent.is(), equalTo(Global.TEST_CONTENT)));
		}
		
		driver.switchTo().defaultContent();
	}

	private boolean ulIsEmpty(List<WebElementFacade> ulNextP) {
		// TODO Auto-generated method stub
		return (ulNextP.size() == 1) &&
				(ulNextP.get(0).getText().trim().equals(""));
	}

	public static EnterValueInto frame(WebElementFacade frame) {
		return Instrumented.instanceOf(EnterValueInto.class)
				.withProperties(frame);
	}

}
