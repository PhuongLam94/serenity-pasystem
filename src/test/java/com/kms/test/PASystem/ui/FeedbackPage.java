package com.kms.test.PASystem.ui;

import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.screenplay.targets.Target;

public class FeedbackPage {

	public static final Target SUBMIT_BUTTON = Target.the("Submit button")
			.locatedBy(Global.SUBMIT_BUTTON_LOCATOR);
	
	
	public static final Target TAB_TITLE_LINK = Target.the("Tab title link")
			.locatedBy(Global.TAB_TITLE_LINK_LOCATOR);
	public static final Target TAB_CONTENT_DIV = Target.the("Tab content div")
			.locatedBy(Global.TAB_CONTENT_DIV_LOCATOR);
	public static final Target SELECTED_TAB_LINK = Target.the("Selected tab link")
			.locatedBy(Global.SELECTED_TAB_LINK_LOCATOR);
	
	public static final Target SECTION_PARAGRAPH = Target.the("Section paragraph")
			.locatedBy(Global.SECTION_PARAGRAPH_LOCATOR);
	public static final Target SECTION_UL = Target.the("Section List in paragraph")
			.locatedBy(Global.SECTION_UL_LOCATOR);
	public static final Target SECTION_BODY = Target.the("Section body")
			.locatedBy(Global.SECTION_BODY_LOCATOR);
	public static final Target SAVE_BUTTON = Target.the("Save button")
			.locatedBy(Global.SAVE_BUTTON_LOCATOR);
	
}
