package com.jtmproject.task;

/**
 * This class stores the Operating System data.
 * @author Javier Tejedor
 */
public class TagOperatingSystem {
	
	private String name;
	private String rootDirectoryInstall;
	private String folder;

	/**
	 * constructor
	 * @param name
	 * @param defaultFolderInstall
	 */
	public TagOperatingSystem(String name, String rootDirectoryInstall, String folder) {
		this.name = name;
		
		if(rootDirectoryInstall.equals("Windir (C:)")){
			rootDirectoryInstall = "";
		}
		
		this.rootDirectoryInstall = rootDirectoryInstall;
		this.folder = folder;
	}

	/**
	 * this returns the name of the operating system
	 * @return
	 */
	public String getNameOfOperatingSystem() {
		return name;
	}
	
	/**
	 * this returns the default folder for install
	 * @return
	 */
	public String getRootDirectoryInstall() {
		return rootDirectoryInstall;
	}
	
	/**
	 * returns the folder to install
	 * @return
	 */
	public String getFolder() {
		return folder;
	}
	
	/**
	 * sets the root directory to install
	 * (this is for user changes)
	 * @param rootDirectoryInstall
	 */
	public void setRootDirectoryInstall(String rootDirectoryInstall) {
		this.rootDirectoryInstall = rootDirectoryInstall;
	}

	/**
	 * sets the folder to install
	 * (this is for user changes)
	 * @param folder
	 */
	public void setFolder(String folder) {
		this.folder = folder;
	}

}
