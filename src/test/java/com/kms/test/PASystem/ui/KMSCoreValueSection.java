package com.kms.test.PASystem.ui;

import org.openqa.selenium.By;

import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class KMSCoreValueSection extends PageObject{
	public static final Target EXPAND_ALL_LINK = Target.the("'Expand All' link")
			.located(By.linkText(Global.EXPAND_ALL_LINK_LOCATOR));
	public static final Target KMS_CORE_VAL_SECTION_FRAME = Target.the("KMS Core Value section's frame")
			.locatedBy(Global.KMS_CORE_VAL_SECTION_FRAME_LOCATOR);
	public static final Target COLLAPSE_ALL_LINK = Target.the("'Collapse All' link")
			.located(By.linkText(Global.COLLAPSE_ALL_LINK_LOCATOR));
	public static final Target ICON = Target.the("Icon link in section")
			.locatedBy(Global.ICON_LOCATOR);
}
