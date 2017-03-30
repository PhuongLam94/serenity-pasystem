package com.kms.test.PASystem.utils;

public class Paging {
	public static final String PAGING_INFO_STATEMENT_FORMATTER = "Page %1$d of %2$d";
	public static final String VIEW_INFO_STATEMENT_FORMATTER = "View %1$d - %2$d of %3$d";
	
	public int theCurrentPage = 1;
	public int itemsPerPage = 10;
	public int totalItems = 12;
	
	public Paging(int theCurrentPage, int itemsPerPage, int totalItems) {
		super();
		this.theCurrentPage = theCurrentPage;
		this.itemsPerPage = itemsPerPage;
		this.totalItems = totalItems;
	}
	public String getPagingInfoStatement(){
		int totalPages = (totalItems-1)/itemsPerPage + 1;
		return String.format(PAGING_INFO_STATEMENT_FORMATTER, theCurrentPage, totalPages);
	}
	public String getViewInfoStatement() {
		int startItem = (theCurrentPage - 1)*itemsPerPage + 1;
		int endItem = getEndItem();
		return String.format(VIEW_INFO_STATEMENT_FORMATTER, startItem, endItem, totalItems);
	}
	private int getEndItem() {
		int endItem = theCurrentPage*itemsPerPage;
		if (endItem > totalItems){
			endItem = totalItems-(theCurrentPage-1)*itemsPerPage;
		}
		return endItem;
	}
	
	@Override
	public String toString(){
		return 
				this.getPagingInfoStatement()+
				", "+this.getViewInfoStatement();
	}
}