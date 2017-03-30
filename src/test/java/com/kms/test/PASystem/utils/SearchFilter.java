package com.kms.test.PASystem.utils;

import java.util.List;

public class SearchFilter {
	private String viewOptions = Global.MY_FEEDBACK_FOR_OTHERS;
	
	private String fromDate = null;
	private String toDate = null;
	private String employee = null;
	private List<String> status = null;
	
	public SearchFilter(String viewOptions, String fromDate, String toDate, String employee, List<String> status) {
		super();
		this.setViewOptions(viewOptions);
		this.setFromDate(fromDate);
		this.setToDate(toDate);
		this.setEmployee(employee);
		this.setStatus(status);
	}

	public SearchFilter() {
		super();
	}

	public String getViewOptions() {
		return viewOptions;
	}

	public void setViewOptions(String viewOptions) {
		this.viewOptions = viewOptions;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}
	
	@Override
	public String toString(){
		String result = "View options: "+this.getViewOptions();
		if (this.getFromDate() != null)
			result +=", from date: "+this.getFromDate();
		if (this.getToDate() != null)
			result +=", to date: "+this.getToDate();
		if (this.getEmployee() != null)
			result +=", employee: "+this.getEmployee();
		if (this.getStatus() != null)
			result +=", status: "+this.getStatus();
		return result;
	}
}
