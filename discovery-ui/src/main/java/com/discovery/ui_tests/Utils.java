package com.discovery.ui_tests;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opencsv.CSVWriter;
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

	public static void copyToCsv(String path, String[] headers, Map<String, String> map ){
		File file = new File(path);
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			// adding header to csv
			String[] header = headers;
			writer.writeNext(header);
			for (Map.Entry<String,String> entry : map.entrySet())
			{
				String[] data = { entry.getKey(), entry.getValue()};
				writer.writeNext(data);
			}

			writer.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
