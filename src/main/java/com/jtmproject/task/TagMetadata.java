package com.jtmproject.task;

/**
 * This class stores the metadata of the project
 * @author Javier Tejedor
 */
public class TagMetadata {

	private String author = "";
	private String description = "";
	private String localization = "";
	private String developer = "";
	private String officialUrl = "";
	private String productCode = "";
	private String productName = "";
	private String technicalSupportTelephone = "";
	private String technicalSupportUrl = "";
	private String version = "";

	/**
	 * returns the author
	 * @return
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * sets the author
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * returns the description
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * sets the description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * returns the localization
	 * @return
	 */
	public String getLocalization() {
		return localization;
	}
	
	/**
	 * sets the localization
	 * @param localization
	 */
	public void setLocalization(String localization) {
		this.localization = localization;
	}
	
	/**
	 * return the developer
	 * @return
	 */
	public String getDeveloper() {
		return developer;
	}
	
	/**
	 * sets the developer
	 * @param developer
	 */
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	
	/**
	 * returns the official url
	 * @return
	 */
	public String getOfficialUrl() {
		return officialUrl;
	}
	
	/**
	 * sets the official url
	 * @param officialUrl
	 */
	public void setOfficialUrl(String officialUrl) {
		this.officialUrl = officialUrl;
	}
	
	/**
	 * returns the product's code
	 * @return
	 */
	public String getProductCode() {
		return productCode;
	}
	
	/**
	 * sets the product's code
	 * @param productCode
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	/**
	 * returns the product's name
	 * @return
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * sets the product's name
	 * @param version
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	/**
	 * returns the technical support telephone
	 * @return
	 */
	public String getTechnicalSupportTelephone() {
		return technicalSupportTelephone;
	}
	
	/**
	 * sets the technical support telephone
	 * @param version
	 */
	public void setTechnicalSupportTelephone(String technicalSupportTelephone) {
		this.technicalSupportTelephone = technicalSupportTelephone;
	}
	
	/**
	 * returns the technical support url
	 * @return
	 */
	public String getTechnicalSupportUrl() {
		return technicalSupportUrl;
	}
	
	/**
	 * sets the technical support url
	 * @param version
	 */
	public void setTechnicalSupportUrl(String technicalSupportUrl) {
		this.technicalSupportUrl = technicalSupportUrl;
	}
	
	/**
	 * returns the version
	 * @return
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * sets the version
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
}
