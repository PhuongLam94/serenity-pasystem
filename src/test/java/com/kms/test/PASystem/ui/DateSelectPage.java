package com.kms.test.PASystem.ui;

import com.kms.test.PASystem.utils.Global;
import com.kms.test.PASystem.utils.Utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class DateSelectPage extends PageObject{
	
	public static final Target YEAR_SELECT = Target			
			.the("Year select")
			.locatedBy(Global.YEAR_SELECT_LOCATOR);
	
	public static final Target MONTH_SELECT = Target			
			.the("Month select")
			.locatedBy(Global.MONTH_SELECT_LOCATOR);
	
	public static final Target GET_DATE_LINK(int date){
		return Target.the(Utils.getDate(date)+" link").locatedBy(
				String.format(Global.DATE_LINKS_LOCATOR_FORMATTER, date));
	}

}
