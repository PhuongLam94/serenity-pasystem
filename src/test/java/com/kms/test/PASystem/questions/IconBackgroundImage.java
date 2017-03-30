package com.kms.test.PASystem.questions;

import com.kms.test.PASystem.ui.KMSCoreValueSection;
import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class IconBackgroundImage implements Question<String>{
	private int index;
	public IconBackgroundImage(int index) {
		this.index = index;
	}

	@Override
	public String answeredBy(Actor arg0) {
		return KMSCoreValueSection.ICON.resolveAllFor(arg0)
				.get(index).getCssValue(Global.BACKGROUND_IMAGE_CSS);
	}

	public static IconBackgroundImage indexOf(int index) {
		// TODO Auto-generated method stub
		return new IconBackgroundImage(index);
	}

}
