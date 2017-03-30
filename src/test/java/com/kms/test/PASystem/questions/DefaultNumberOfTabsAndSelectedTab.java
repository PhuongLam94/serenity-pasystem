package com.kms.test.PASystem.questions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DefaultNumberOfTabsAndSelectedTab implements Question<Boolean>{

	@Override
	public Boolean answeredBy(Actor actor) {
		actor.should(
				seeThat(NumberOfTabsDipslayed.is(), equalTo(Global.NUMBER_OF_TABS_DISPLAYED)),
				seeThat(SelectedTab.is(), equalTo(Global.KMS_CORE_VALUE))
		);
		return true;
	}

	public static Question<Boolean> isTrue() {
		// TODO Auto-generated method stub
		return new DefaultNumberOfTabsAndSelectedTab();
	}

}
