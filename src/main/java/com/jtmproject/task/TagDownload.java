package com.jtmproject.task;

/**
 * This class stores the data for download and save the files
 * @author Javier Tejedor
 */
public class TagDownload{
	
	private String url;
	private String folder;
	private String filename;
	private String size;
	
	/**
	 * constructor
	 * @param url
	 * @param folder
	 * @param filename
	 */
	public TagDownload(String url, String folder, String filename, String size) {
		this.url = url;
		this.folder = folder;
		this.filename = filename;
		this.size = size;
	}

	/**
	 * returns the url
	 * @return
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * return the folder
	 * @return
	 */
	public String getFolder() {
		return folder;
	}
	
	/**
	 * returns the filename
	 * @return
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * returns the size of the download
	 * @return
	 */
	public String getSize() {
		return size;
	}

	/**
	 * sets the size of the donwload
	 * @param size
	 */
	public void setSize(String size) {
		this.size = size;
	}
	
	
}

