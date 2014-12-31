package com.jtmproject.server;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class does the treatment of the JSON data
 * @author Javier Tejedor
 * **/
public class DataJSON {


	/**
	 * returns an array with the values of the keyWord passed by parameters
	 * @param arrayJson
	 * @param keyWord
	 * @return
	 */
	public static List<String> getArrayDataJson(String arrayJson, String keyWord){
		List<String> array = null;
		array = new ArrayList<String>(); 

		if(!array.isEmpty()){array.clear();} 
		try {
			JSONArray json = null;
			json = new JSONArray(arrayJson);
			for(int i = 0; i < json.length(); ++i) { 
				JSONObject jsonObject = json.getJSONObject(i); 

				array.add(jsonObject.getString(keyWord)); 

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;

		}

		return array;
	}

	/**
	 * returns the reply of the server
	 * @param JSONArray json
	 * @return String
	 * **/
	public static String getReply(String json, String key){
		try {
			JSONArray arrayJson = null; 
			arrayJson = new JSONArray(json);

			JSONObject object = arrayJson.getJSONObject(0);
			return object.getString(key);
		} catch (JSONException e) {
			return null;
		} 
	}

	/**
	 * returns the comments of the server
	 * @param JSONArray json
	 * @return String
	 * **/
	public static String getComment(String json){
		try {
			JSONArray arrayJson = null; 
			arrayJson = new JSONArray(json);

			JSONObject object = arrayJson.getJSONObject(0);
			return object.getString(ServerConstants.getSc().getComments());
		} catch (JSONException e) {
			e.printStackTrace();
			return e.toString();
		} 
	}
}