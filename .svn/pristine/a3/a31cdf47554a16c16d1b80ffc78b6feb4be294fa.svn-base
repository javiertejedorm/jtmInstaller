package com.jtmproject.server;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * This class checks the user and the password
 * @author Javier Tejedor
 */
public class Login {

	private Connection connection;
	private String user;
	private String password;
	
	private  boolean loginCorrect = false;
	
	/**
	 * constructor
	 */
	public Login(String user, String password){
		connection = new Connection();
		this.user = user;
		this.password = password;
		this.loginCorrect = false;
		
		loginCorrect = isUserRegistered(false);
	}

	/**
	 * checks if the user is registered
	 * @param user
	 * @param password
	 * @param storePersistant
	 * @return
	 */
	public boolean isUserRegistered(boolean storePersistant){
		ArrayList<NameValuePair> post= new ArrayList<NameValuePair>();
 		
		post.add(new BasicNameValuePair(ServerConstants.getSc().getEmail(), user));
		post.add(new BasicNameValuePair(ServerConstants.getSc().getPassword(), password));
		
		String serverData = connection.getServerData(post, ServerConstants.getSc().getLoginUrl());
		if(DataJSON.getReply(serverData, ServerConstants.getSc().getReplay()).equals(ServerConstants.getSc().getOK())){
			if(storePersistant){
				LoginUser.getLu().login(user, password, true);
			}
				
			return true;
			
		}else{
			
			return false;
		}
	}


	/**
	 * returns if the login is correct
	 * @return
	 */
	public boolean isLoginCorrect() {
		return loginCorrect;
	}
}
