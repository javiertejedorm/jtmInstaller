package com.jtmproject.task;

/**
 * This class stores both the welcome and copyright messages
 * @author Javier Tejedor
 */
public class TagMessages {

	private String welcome;
	private String copyright;
	
	/**
	 * constructor
	 * @param welcome
	 * @param copyright
	 */
	public TagMessages(String welcome, String copyright) {
		this.welcome = welcome;
		this.copyright = copyright;
	}
	
	/**
	 * returns the welcome message
	 * @return
	 */
	public String getWelcome() {
		return welcome;
	}
	
	/**
	 * returns the copyright message
	 * @return
	 */
	public String getCopyright() {
		return copyright;
	}
}
