package com.kms.test.PASystem.questions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.kms.test.PASystem.ui.FeedbackPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;

public class SectionContent implements Question<List<String>>{

	private WebElementFacade section;
	public SectionContent(WebElementFacade section) {
		this.section = section;
	}

	@Override
	public List<String> answeredBy(Actor actor) {
		WebDriver driver = BrowseTheWeb.as(actor).getDriver();
		driver.switchTo().frame(section);
		List<String> result =  Text.of(FeedbackPage.SECTION_PARAGRAPH)
				.viewedBy(actor)
				.asList();
		driver.switchTo().defaultContent();
		return result;
	}

	public static SectionContent withFrame(WebElementFacade section) {
		// TODO Auto-generated method stub
		return new SectionContent(section);
	}

}
