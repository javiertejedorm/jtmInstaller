package com.jtmproject.task;

/**
 * This class stores a shorcut into Start Menu
 * @author Javier Tejedor
 */
public class TagAddProgramsMenu {

	private String folder;
	private String name;
	private String file;
	
	/**
	 * constructor
	 * @param folder
	 * @param name
	 * @param file
	 */
	public TagAddProgramsMenu(String folder, String name, String file) {
		this.folder = folder;
		this.name = name;
		this.file = file;
	}
	
	/**
	 * this returns the folder
	 * @return
	 */
	public String getFolder() {
		return folder;
	}
	
	/**
	 * this returns the name of the file
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * this returns the path of the file
	 * @return
	 */
	public String getFile() {
		return file;
	}
	
}
