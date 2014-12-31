package com.jtmproject.task;

/**
 * This class stores the data for add the program to the WindowsStartup
 * @author Javier Tejedor
 */
public class TagAddStartup {

	private String name;
	private String file;
	
	/**
	 * constructor
	 * @param name
	 * @param file
	 */
	public TagAddStartup(String name, String file) {
		this.name = name;
		this.file = file;
	}
	
	/**
	 * this returns the name (key for Registry)
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * this returns the path of file
	 * @return
	 */
	public String getFile() {
		return file;
	}
}
