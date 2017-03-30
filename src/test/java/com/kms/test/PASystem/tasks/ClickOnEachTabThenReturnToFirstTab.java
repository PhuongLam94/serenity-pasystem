package com.kms.test.PASystem.tasks;

import java.util.List;

import com.kms.test.PASystem.ui.FeedbackPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class ClickOnEachTabThenReturnToFirstTab implements Task{

	@Step("{0} clicks on each tab to check visibilit and then return to first tab")
	@Override
	public <T extends Actor> void performAs(T actor) {
		List<WebElementFacade> tabTitles = FeedbackPage.TAB_TITLE_LINK.resolveAllFor(actor);
		List<WebElementFacade> tabContents = FeedbackPage.TAB_CONTENT_DIV.resolveAllFor(actor);
		for (int i = 0; i < tabTitles.size(); i++){
			actor.attemptsTo(ClickATab.withTitleAndContentElement(tabTitles.get(i), tabContents.get(i)));
		}
		actor.attemptsTo(ClickATab.withTitleAndContentElement(tabTitles.get(0), tabContents.get(0)));
		
	}

}
