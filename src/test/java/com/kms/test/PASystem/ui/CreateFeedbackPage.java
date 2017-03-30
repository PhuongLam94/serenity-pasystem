package com.kms.test.PASystem.ui;

import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CreateFeedbackPage extends PageObject{
	public static final Target SHORT_FEEDBACK_CHECKBOX = Target.the("Short feedback checkbox")
			.locatedBy(Global.SHORT_FEEDBACK_CHECKBOX_LOCATOR);
	public static final Target PROVIDE_FEEDBACK_FOR_SELECT = Target.the("Provide feedback for select")
			.locatedBy(Global.CREATE_FB_PAGE_PROVIDE_FEEDBACK_FOR_SELECT_LOCATOR);
	public static final Target FOR_DATE_FIELD = Target.the("For date field")
			.locatedBy(Global.CREATE_FB_PAGE_FOR_DATE_FIELD_LOCATOR);
	public static final Target FULL_FEEDBACK_CHECKBOX = Target.the("Full feedback checkbox")
			.locatedBy(Global.FULL_FEEDBACK_CHECKBOX_LOCATOR);;
}
