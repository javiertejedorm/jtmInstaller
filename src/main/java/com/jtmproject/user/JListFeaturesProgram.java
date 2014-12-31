package com.jtmproject.user;

/**
 * This class stores the content of the item into the current JList (in Window class)
 * @author Javier Tejedor
 */
public class JListFeaturesProgram{

	private String name;
	private String author;
	private String size;
	private String urlImage;
	private String nameImage;
	
	/**
	 * constructor
	 * @param name
	 * @param author
	 * @param size
	 * @param urlImage
	 */
	public JListFeaturesProgram(String name, String author, String size, String urlImage, String nameImage) {
		this.name = name;
		this.author = author;
		this.size = size;
		this.urlImage = urlImage;
		this.nameImage = nameImage;
	}
	
	/**
	 * return the name of the image
	 * @return
	 */
	public String getNameImage(){
		return nameImage;
	}

	/**
	 * returns the name
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns the author
	 * @return
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * returns the size of the project
	 * @return
	 */
	public String getSize() {
		return size;
	}

	/**
	 * returns the url of the image
	 * @return
	 */
	public String getUrlImage() {
		return urlImage;
	}	
}
