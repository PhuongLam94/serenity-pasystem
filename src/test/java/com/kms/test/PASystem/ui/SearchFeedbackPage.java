package com.kms.test.PASystem.ui;

import java.util.List;

import com.kms.test.PASystem.utils.Global;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

public class SearchFeedbackPage extends PageObject{

	public static final Target VIEW_OPTION_SELECT = Target.the("View option select")
			.locatedBy(Global.VIEW_OPTION_SELECT_LOCATOR);
	
	public static final Target FROM_DATE_FIELD = Target.the("From date field")
			.locatedBy(Global.FROM_DATE_FIELD_SELECTOR);
	
	public static final Target FROM_DATE_IMG = Target.the("From date calendar")
			.locatedBy(Global.FROM_DATE_IMG_SELECTOR);
	
	public static final Target TO_DATE_FIELD = Target.the("To date field")
			.locatedBy(Global.TO_DATE_FIELD_SELECTOR);
	
	public static final Target TO_DATE_IMG = Target.the("To date calendar")
			.locatedBy(Global.TO_DATE_IMG_SELECTOR);
	
	public static final Target EMPLOYEE_FIELD = Target.the("Employee field")
			.locatedBy(Global.EMPLOYEE_FIELD_SELECTOR);
	
	public static final Target SEARCH_BUTTON = Target.the("Search feedback button")
			.locatedBy(Global.SEARCH_BUTTON_SELECTOR);
	
	public static final Target NOTI_MESSAGE_DIV = Target.the("Notification message div")
			.locatedBy(Global.NOTI_MESSAGE_DIV_SELECTOR);
	
	public static final Target PAGE_INFO_TD = Target.the("Paging information cell")
			.locatedBy(Global.PAGE_INFO_TD_SELECTOR);
	
	public static final Target VIEW_INFO_DIV = Target.the("View information div")
			.locatedBy(Global.VIEW_INFO_DIV_SELECTOR);
	
	public static final Target HEADERS = Target.the("Result table headers")
			.locatedBy(Global.HEADERS_SELECTOR);
	
	public static final Target CURRENT_PAGE_FIELD = Target.the("Current page field")
			.locatedBy(Global.CURRENT_PAGE_FIELD_SELECTOR);

	public static final Target STATUS_CELL_OF_FEEDBACK_ROW = Target.the("Status cell of feedback row")
			.locatedBy(Global.STATUS_CELL_OF_FEEDBACK_ROW_LOCATOR);

	public static final Target FEEDBACK_ROW = Target.the("Feedback row")
			.locatedBy(Global.FEEDBACK_ROW_LOCATOR);

	public static final Target GET_FEEDBACK_CHECKBOX_BY_STATUS(String status){
		return Target.the(status + " row")
				.locatedBy(String.format(
				Global.FEEDBACK_CHECKBOX_SELECTOR_FORMATTER_ON_STATUS, status));
	}
	
	public static final List<WebElementFacade> STATUS_CHECKBOXES(Actor actor){
		return Target.the("Status checkboxes")
		.locatedBy(Global.STATUS_CHECKBOXES_LOCATOR).resolveAllFor(actor);
	}
			
	
}
