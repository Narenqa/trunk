package com.discovery.ui_tests;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utils {

	public static JSONObject readContentFromJson(String fileName, String data) {
		JSONParser parser = new JSONParser();
		JSONObject dataObject = null;
		try {
			JSONObject obj = (JSONObject) parser
					.parse(new FileReader(fileName));
			dataObject = (JSONObject) obj.get(data);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataObject;
	}

	public static String convertDateFormat(String formatFrom, String formatTo) {
		try {
			SimpleDateFormat dateformate = new SimpleDateFormat("dd-MMM-yyyy");
			Date excelDateFormate = dateformate.parse(formatFrom);
			SimpleDateFormat out = new SimpleDateFormat(formatTo);
			String transDate = out.format(excelDateFormate);
			return transDate;
		} catch (Exception e) {
			return null;
		}
	}
}
