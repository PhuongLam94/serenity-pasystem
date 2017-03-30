package com.kms.test.PASystem.tasks;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.List;

import org.openqa.selenium.By;

import com.kms.test.PASystem.questions.SectionContent;
import com.kms.test.PASystem.ui.FeedbackPage;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class CheckForOtherTabs implements Task{
	@Step("{0} checks for other tab than KMS Core Value tab")
	@Override
	public <T extends Actor> void performAs(T actor) {
		List<WebElementFacade> tabsContent = FeedbackPage.TAB_CONTENT_DIV.resolveAllFor(actor);
		List<WebElementFacade> tabsTitle = FeedbackPage.TAB_TITLE_LINK.resolveAllFor(actor);
		for (int i=1; i<tabsContent.size(); i++){
			actor.attemptsTo(Click.on(tabsTitle.get(i)));
			WebElementFacade frame = tabsContent.get(i).find(By.cssSelector("iframe"));
			actor.should(seeThat(
					SectionContent.withFrame(frame),
					containsInAnyOrder(Global.OTHER_TABS_CONTENT
							.get(i-1).toArray())
			));
			actor.attemptsTo(EnterValueInto.frame(frame));
			
		}
	}

}
