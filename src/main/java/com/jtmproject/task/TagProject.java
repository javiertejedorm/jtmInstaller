package com.jtmproject.task;

/**
 * This class stores the name of the project
 * @author Javier Tejedor
 */
public class TagProject {

	private String name;
	private String url;
	private String size;
	private String executableFile;
	private String uninstallFile;
	private String idImage;
	private String totalFiles;
	
	/**
	 * constructor
	 * @param name
	 */
	public TagProject(String name, String url, String size, String executableFile, String uninstallFile, String idImage, String totalFiles) {
		this.name = name;
		this.url = url;
		this.size = size;
		this.executableFile = executableFile;
		this.uninstallFile = uninstallFile;
		this.idImage = idImage;
		this.totalFiles = totalFiles;
	}
	
	/**
	 * returns the path of the executable file
	 * @return
	 */
	public String getExecutableFile() {
		return executableFile;
	}

	/**
	 * returns the path of the uninstall file
	 * @return
	 */
	public String getUninstallFile() {
		return uninstallFile;
	}

	/**
	 * returns the name of the project
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns the url of the project
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * returns the size of the project
	 * @return
	 */
	public String getSize() {
		return size;
	}

	/**
	 * returns the icon-name of the project
	 * @return
	 */
	public String getIdImage() {
		return idImage;
	}

	
	/**
	 * returns the number of the total files
	 * @return
	 */
	public String getTotalFiles() {
		return totalFiles;
	}
	
	
}
