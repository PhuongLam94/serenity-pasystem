package com.kms.test.PASystem.questions;

import java.util.List;

import com.kms.test.PASystem.ui.FeedbackPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LISize implements Question<Integer>{

	private List<WebElementFacade> listOfLi;
	protected LISize(List<WebElementFacade> listOfLi) {
		super();
		this.listOfLi = listOfLi;
	}

	@Override
	public Integer answeredBy(Actor arg0) {
		// TODO Auto-generated method stub
		return listOfLi.size();
	}

	public static LISize is(List<WebElementFacade> listOfLi) {
		// TODO Auto-generated method stub
		return new LISize(listOfLi);
	}

}
