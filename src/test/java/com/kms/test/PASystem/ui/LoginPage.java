package com.kms.test.PASystem.ui;

import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://192.168.74.25/patest/Home/Login")
public class LoginPage extends PageObject{

	public static final Target USERNAME_FIELD = Target.the("username field")
			.locatedBy(Global.USERNAME_FIELD_LOCATOR);
	public static final Target PASSWORD_FIELD = Target.the("password field")
			.locatedBy(Global.PASSWORD_FIELD_LOCATOR);
	public static final Target LOGIN_BUTTON = Target.the("login button")
			.locatedBy(Global.LOGIN_BUTTON_LOCATOR);
	public static final Target PAGE_MESSAGE = Target.the("page message")
			.locatedBy(Global.PAGE_MESSAGE_LOCATOR);

}
