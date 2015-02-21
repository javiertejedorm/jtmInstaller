package com.jtmproject.server;

import com.jtmproject.gui.JLabelLogin;
import com.jtmproject.user.MessagesUser;
import com.jtmproject.user.UserProperties;

/**
 * This class stores the user
 * @author Javier Tejedor
 */
public class LoginUser{

	public static LoginUser lu;
	
	private String email;
	private String password;
	private boolean connected;

	/**
	 * this returns an instance of LoginUser. (Singleton Class)
	 * @return
	 */
	private static LoginUser getLu(){
		if(lu == null){
			lu = new LoginUser();
		}
		return lu;
	}
	
	/**
	 * this sets the login
	 * @param email
	 * @param passoword
	 */
	public void login(String email, String passoword, boolean connected){
		this.email = email;
		this.password = passoword;
		this.connected = connected;
	}
	
	/**
	 * this configures the logout
	 */
	public void logout(){
		this.email = "";
		this.password = "";
		this.connected = false;
		JLabelLogin.getjLabel().setText(MessagesUser.getMU().getLogin());
		UserProperties.getUp().writeProperties();
	}

	/**
	 * returns the email
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * returns the password
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * returns if the user is connected with the server
	 * @return
	 */
	public boolean isConnected(){
		return connected;
	}
	
}
