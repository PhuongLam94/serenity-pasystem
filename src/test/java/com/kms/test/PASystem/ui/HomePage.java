package com.kms.test.PASystem.ui;

import org.openqa.selenium.By;

import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage extends PageObject{

	public static final Target LOGOUT_BUTTON = Target.the("log out button")
			.locatedBy(Global.LOGOUT_BUTTON_LOCATOR);
	public static final Target VIEW_FEEDBACKS_MENU = Target.the("'View Feedbacks' menu")
			.located(By.linkText(Global.VIEW_FEEDBACKS_MENU_LOCATOR));
	public static final Target SEARCH_ALL_MENU = Target.the("'Search All' menu")
			.located(By.linkText(Global.SEARCH_ALL_MENU_LOCATOR));
	public static final Target PROVIDE_FEEDBACK_MENU = Target.the("'Provide Feedback' menu")
			.located(By.linkText(Global.PROVIDE_FEEDBACK_MENU_LOCATOR));;

}
