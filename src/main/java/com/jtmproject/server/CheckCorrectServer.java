package com.jtmproject.server;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * this class checks if the server is correct or not
 * @author Javier Tejedor
 */
public class CheckCorrectServer implements Runnable {

	private Connection connection;
	private String code;
	
	private static boolean checked = false;
	
	private  boolean loginCorrect = false;
	
	/**
	 * constructor
	 */
	public CheckCorrectServer(String code){
		connection = new Connection();
		this.code = code;
		this.loginCorrect = false;
	}

	/**
	 * checks if the user is registered
	 * @param user
	 * @return
	 */
	public boolean isCorrectServer(){
		ArrayList<NameValuePair> post= new ArrayList<NameValuePair>();
		
		post.add(new BasicNameValuePair(ServerConstants.getSc().getCheckServer(), code));
		
		String serverData = connection.getServerData(post, ServerConstants.getSc().getCheckServerOkUrl());
		if(serverData != null){
			if(DataJSON.getReply(serverData, ServerConstants.getSc().getReplay()).equals(ServerConstants.getSc().getOK())){
				return true;
				
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public void run() {
		loginCorrect = checked = isCorrectServer();
	}

	/**
	 * returns if the login is correct
	 * @return
	 */
	public boolean isCheckCorrect() {
		return loginCorrect;
	}

	/**
	 * returns if the server has been checked or not
	 * @return
	 */
	public static boolean isChecked() {
		return checked;
	}

	/**
	 * sets if the server has been checked or not
	 * @param checked
	 */
	public static void setChecked(boolean checked) {
		CheckCorrectServer.checked = checked;
	}
}
