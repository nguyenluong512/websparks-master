package com.websparks.core;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Mapper {

	private static JSONObject obj;

	public static JSONObject readData(String filePath) {
		JSONParser parser = new JSONParser();
		JSONObject value = null;
		try {
			Object obj = parser.parse(new FileReader(filePath));
			value = (JSONObject) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String map(String json, String key) {
		obj = readData(json);
		return obj.get(key).toString();
	}
}
