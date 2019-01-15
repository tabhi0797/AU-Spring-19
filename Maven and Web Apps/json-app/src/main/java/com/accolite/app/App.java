package com.accolite.app;

import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App {
	public static void main(String[] args) {
//		App app = new App();
//		System.out.println(app.parseJSON("src/main/data.json","name"));
	}
	
	
	
	/*
	 * this method takes in the json file path and a key and returns the corresponding value as String
	 * if key is not found 'no field' is returned
	*/
	public String parseJSON(String path, String key) {
		try {
			JSONParser parser = new JSONParser();
			Reader reader = new FileReader(path);
			Object jsonObj = parser.parse(reader);
			JSONObject jsonObject = (JSONObject) jsonObj;

			String value = jsonObject.get(key).toString();
			System.out.println(key+ " = " + value);
			reader.close();
			return value;
		} catch (Exception e) {
			return "no field";
		}
	}
}
