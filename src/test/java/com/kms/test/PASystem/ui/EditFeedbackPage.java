package com.kms.test.PASystem.ui;

import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class EditFeedbackPage extends PageObject{

	public static final Target EDIT_BUTTON = Target.the("Edit button")
			.locatedBy(Global.EDIT_BUTTON_LOCATOR);
	public static final Target EMPLOYEE_FIELD = Target.the("Employee field")
			.locatedBy(Global.EMPLOYEE_FIELD_LOCATOR);
	public static final Target STATUS_FIELD = Target.the("Status field")
			.locatedBy(Global.STATUS_FIELD_LOCATOR);
	public static final Target PROVIDE_FEEDBACK_FOR_SELECT = Target.the("Provide feedback for select")
			.locatedBy(Global.EDIT_FB_PAGE_PROVIDE_FEEDBACK_FOR_SELECT_LOCATOR);
	public static final Target FOR_DATE_FIELD = Target.the("For date field")
			.locatedBy(Global.EDIT_FB_PAGE_FOR_DATE_FIELD_LOCATOR);
}
