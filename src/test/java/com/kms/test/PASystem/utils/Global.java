package com.kms.test.PASystem.utils;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Global {

	public static final String TITLE_PREFIX = " | PA Tool";
	public static final String VALID_USERNAME = "baopham";
	public static final String VALID_PASSWORD = "kms";
	public static final Object LOGIN_PAGE_TITLE = "Login"+TITLE_PREFIX;
	public static final Object HOME_PAGE_TITLE = "Home"+TITLE_PREFIX;
	public static final String LOGOUT_BUTTON_LOCATOR = "#header .user_cpanel a[href*=Logout]";
	public static final String USERNAME_FIELD_LOCATOR = "#username";
	public static final String PASSWORD_FIELD_LOCATOR = "#password";
	public static final String LOGIN_BUTTON_LOCATOR = "#btnSubmit";
	public static final String INVALID_USERNAME = "baoPham";
	public static final String INVALID_PASSWORD = "kmS";
	public static final Object LOGIN_ERR_MESSAGE = "Incorrect credentials, please try again.";
	public static final String PAGE_MESSAGE_LOCATOR = "#pageMessage";
	public static final String VIEW_FEEDBACKS_MENU_LOCATOR = "View Feedbacks";
	public static final String SEARCH_ALL_MENU_LOCATOR = "Search All";
	public static final String MY_FEEDBACK_FOR_OTHERS = "My feedbacks for Others";
	public static final String VIEW_OPTION_SELECT_LOCATOR = "#viewOption";
	public static final String FROM_DATE_FIELD_SELECTOR = "#datepickerFrom";
	public static final String FROM_DATE_IMG_SELECTOR = FROM_DATE_FIELD_SELECTOR+"+img";
	public static final String DATE_SELECT_DIV_ID = "ui-datepicker-div";
	public static final String YEAR_SELECT_LOCATOR = "#"+DATE_SELECT_DIV_ID+" .ui-datepicker-year";
	public static final String MONTH_SELECT_LOCATOR = "#"+DATE_SELECT_DIV_ID+" .ui-datepicker-month";
	public static final String DATE_LINKS_LOCATOR_FORMATTER = "//div[@id='"+DATE_SELECT_DIV_ID+"']//table[contains(@class,'ui-datepicker-calendar')]//a[text()=%1$d]";
	public static final String TO_DATE_FIELD_SELECTOR = "#datepickerTo";
	public static final String TO_DATE_IMG_SELECTOR = TO_DATE_FIELD_SELECTOR+"+img";
	public static final String EMPLOYEE_FIELD_SELECTOR = "#groupEmployee input";
	public static final String STATUS_CHECKBOXES_LOCATOR = ".StatusRow div input";
	public static final String SEARCH_BUTTON_SELECTOR = "#btnSearch";
	public static final String NOTI_MESSAGE_DIV_SELECTOR = ".noty_bar .noty_message";
	public static final String SEARCH_SUCCESSFULLLY_MESSAGE = "Search sucessfully.";
	
	
	public static final String PAGE_INFO_TD_SELECTOR = "#pager_center table tbody td[dir='ltr']";
	public static final String VIEW_INFO_DIV_SELECTOR = "#pager_right div";
	public static final List<Integer> AVAIL_HEADER_INDEXES = Arrays.asList(3, 4, 6, 7, 8);
	public static final String HEADERS_SELECTOR = "//tr[@role='rowheader']/th[position()="
			+StringUtils.join((Iterable<Integer>) AVAIL_HEADER_INDEXES, " or position()=")+"]/div";
	public static final String[] FEEDBACK_RESULT_HEADERS = {"Receiver", "Date (m/d/y)", "Status", "Is Shared", "Provider"};
	public static final String CURRENT_PAGE_FIELD_SELECTOR = PAGE_INFO_TD_SELECTOR + " input";
	
	public static final List<String> LIST_OF_BUTTON_IDS= Arrays.asList(
			Button.NEW, Button.APPROVE, Button.REJECT, Button.OPEN,
			Button.PREVIEW, Button.SUBMIT, Button.REMOVE
			);
	public static final String FEEDBACK_ROW_LOCATOR = "//table[@id='list']//tr[not(contains(@class,'jqgfirstrow'))]";
	
	public static final String FEEDBACK_CHECKBOX_SELECTOR_FORMATTER_ON_STATUS = 
			"//table[@id='list']//tr[not(contains(@class,'jqgfirstrow')) and td[6][text()='%1s']]/td[1]";
	public static final String PROVIDE_FEEDBACK_MENU_LOCATOR = "Provide Feedback";
	public static final String CREATE_FEEDBACK_PAGE_TITLE = "Create Feedback"+TITLE_PREFIX;
	public static final String SHORT_FEEDBACK = "Short feedback";
	public static final String FULL_FEEDBACK = "Full feedback";
	public static final String MYSELF = "Myself";
	public static final String SUBMIT_BUTTON_LOCATOR = "#btnSubmit";
	public static final String SHORT_FEEDBACK_CHECKBOX_LOCATOR = "#quickfeedback";
	public static final String CREATE_FB_PAGE_PROVIDE_FEEDBACK_FOR_SELECT_LOCATOR = "#Feedback_ProvideFBFor";
	public static final String CREATE_FB_PAGE_FOR_DATE_FIELD_LOCATOR = "#Feedback_CreatedDate";
	public static final String EDIT_FB_PAGE_PROVIDE_FEEDBACK_FOR_SELECT_LOCATOR = "#Feedback_ProviderFBFor";
	public static final String EDIT_FB_PAGE_FOR_DATE_FIELD_LOCATOR = "#Feedback_CreatedDate";
	
	public static final int NUMBER_OF_TABS_DISPLAYED = 4;
	
	public static final String TAB_DIV_LOCATOR = "#tabs";
	public static final String TAB_TITLE_LINK_LOCATOR = TAB_DIV_LOCATOR+
			">ul.ui-tabs-nav>li>a";
	public static final String TAB_CONTENT_DIV_LOCATOR = TAB_DIV_LOCATOR+
			">div";
	public static final String SELECTED_TAB_LINK_LOCATOR = 
			new StringBuilder(TAB_TITLE_LINK_LOCATOR)
			.insert(TAB_TITLE_LINK_LOCATOR.indexOf(">a"), ".ui-tabs-selected")
			.toString();
	public static final String KMS_CORE_VALUE = "KMS Core Values";
	public static final String FULL_FEEDBACK_CHECKBOX_LOCATOR = "#usingtemplate";
	public static final int NUMBER_OF_SECTIONS = 4;
	public static final List<List<String>> KMS_CORE_VALUE_SECTION_CONTENT = 
		Arrays.asList(
				Arrays.asList("Coaching Ability", "Knowledge Sharing",
						"More comments"),
				Arrays.asList("Commitment", "Being Open and Honest in all dealing",
						"More comments"),
				Arrays.asList("Initiative", "Adaptability and Flexibility",
						"Problem Analysis", "More comments"),
				Arrays.asList("Quality of Work", "Customer Service",
						"More comments")
		);
	public static final String EXPAND_ALL_LINK_LOCATOR = "[Expand All]";
	
	public static final String KMS_CORE_VAL_TAB_ID = "main-tab0";
	public static final String KMS_CORE_VAL_SECTION_FRAME_LOCATOR = 
			"#"+KMS_CORE_VAL_TAB_ID+" iframe";
	public static final String SECTION_PARAGRAPH_LOCATOR = "body p";
	public static final String COLLAPSE_ALL_LINK_LOCATOR = "[Collapse All]";
	public static final String PLUS_ICON = "plus";
	public static final String MINUS_ICON = "minus";
	public static final String BACKGROUND_IMAGE_CSS = "background-image";
	public static final String TEST_CONTENT = "Test test test";
	public static final String ICON_LOCATOR = "#"+KMS_CORE_VAL_TAB_ID+" h8 a";
	public static final String SECTION_BODY_LOCATOR = "//body";
	public static final String SECTION_UL_LOCATOR = SECTION_PARAGRAPH_LOCATOR+"+ul";
	public static final String SEARCH_FEEDBACK_TITLE = "Search Feedbacks"+TITLE_PREFIX;
	public static final String STATUS_CELL_OF_FEEDBACK_ROW_LOCATOR = FEEDBACK_ROW_LOCATOR+"/td[6]";
	public static final String FEEDBACK_FOR_ME = "Feedbacks for Me";
	public static final String SAVE_BUTTON_LOCATOR = "#btnSave";
	public static final String FEEDBACK_DETAILS_TITLE = "Feedback Details"+TITLE_PREFIX;
	public static final List<List<String>> OTHER_TABS_CONTENT = Arrays.asList(
			Arrays.asList(""),
			Arrays.asList("Technical skill", "Communication skill", "Team Working",
					"Dependability", "Self-Management skill", 
					"Decision Making ability", "More comments"),
			Arrays.asList("")
			);
	public static final String EDIT_BUTTON_LOCATOR = "#btnEdit";
	public static final String USER_FULLNAME = "Bao Tran Thai Pham";
	public static final String STATUS_FIELD_LOCATOR = "#Feedback_Status";
	public static final String EMPLOYEE_FIELD_LOCATOR = "#Feedback_EmployeeName";
	public static final String SAVE_BUTTON_NAME = "Save";
	public static final String SUBMIT_BUTTON_NAME = "Submit";
	
}
