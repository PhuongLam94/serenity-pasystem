package com.kms.test.PASystem.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class Utils {
	public static final String REPORT_FOLDER_PATH = "./target/site/serenity";
	public static boolean reportFolderIsCleared = false;

	public static void clearReportFolder() {
		try {
			File reportFolder = new File(REPORT_FOLDER_PATH);
			if (reportFolder.exists() && !reportFolderIsCleared) {
				FileUtils.deleteDirectory(reportFolder);
				reportFolderIsCleared = true;
			}
		} catch (IOException e) {
			System.out.println("Error while clearing report folder: " + e.getMessage());
		}
	}

	public static String getDate(int date) {
		String postFix;
		switch (date) {
			case 1:
				postFix = "st";
			case 2:
				postFix = "nd";
			case 3:
				postFix = "rd";
			default:
				postFix = "th";
		}
		return date + postFix;
	}

	public static String formatDate(Date date, String string) {
		DateFormat df = new SimpleDateFormat(string);
		return df.format(date);
	}
}
