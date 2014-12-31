package com.jtmproject.task;

import java.util.ArrayList;

/**
 * Singleton class
 * This class stores all the features to install one program
 * @author Javier Tejedor
 */
public class Program {
	
	private TagProject tagProject;
	private ArrayList<TagOperatingSystem> listTagOperatingSystem;
	private TagAddStartup tagAddStartup;
	private TagOfferDirectoryInstall tagOfferDirectoryInstall;
	private TagAddShortcutDesktop tagAddShortcutDesktop;
	private ArrayList<TagAddProgramsMenu> listTagAddProgramsMenus;
	private TagMessages tagMessages;
	private TagMetadata tagMetadata;
	private TagDownload tagDownload;
	private TagSecurityKey tagSecurityKey;
	private ArrayList<TagExtensionsSupported> listTagExtensionsSupported;
	private String pathJtm;

	/**
	 * constructor
	 */
	public Program(){
		listTagOperatingSystem = new ArrayList<TagOperatingSystem>();
		listTagOperatingSystem.clear();
		
		listTagAddProgramsMenus = new ArrayList<TagAddProgramsMenu>();
		listTagAddProgramsMenus.clear();
		
		listTagExtensionsSupported = new ArrayList<TagExtensionsSupported>();
		listTagExtensionsSupported.clear();
	}
	
	/**
	 * returns the list of extensions supported
	 * @return
	 */
	public ArrayList<TagExtensionsSupported> getListTagExtensionsSupported() {
		return listTagExtensionsSupported;
	}

	/**
	 * this adds a TagExtensionSupported into the list
	 * @param tag
	 */
	public void addListTagExtensionsSupported(TagExtensionsSupported tag){
		this.listTagExtensionsSupported.add(tag);
	}
	
	/**
	 * this removes the list of extension supported
	 */
	public void removeListTagExtensionSupported(){
		this.listTagExtensionsSupported.clear();
	}

	/**
	 * returns the tag of the download
	 * @return
	 */
	public TagDownload getTagDownload() {
		return tagDownload;
	}

	/**
	 * sets the tag of the download
	 * @param tagDownload
	 */
	public void setTagDownload(TagDownload tagDownload) {
		this.tagDownload = tagDownload;
	}


	/**
	 * add a task for create shortcut into menu-programs
	 * @param tagAddProgramsMenu
	 */
	public void addTagProgramsMenus(TagAddProgramsMenu tagAddProgramsMenu){
		this.listTagAddProgramsMenus.add(tagAddProgramsMenu);
	}
	
	/**
	 * returns the list for create shortcuts into menu-progrmas
	 * @return
	 */
	public ArrayList<TagAddProgramsMenu> getTagAddProgramsMenus() {
		return listTagAddProgramsMenus;
	}

	/**
	 * this is for changes by the user
	 */
	public void clearTagAddProgramsMenu(){
		listTagAddProgramsMenus.clear();
		listTagAddProgramsMenus = null;
	}
	/**
	 * returns the features for create a shortcut into desktop
	 * @return
	 */
	public TagAddShortcutDesktop getTagAddShortcutDesktop() {
		return tagAddShortcutDesktop;
	}

	/**
	 * sets a shortcut into desktop
	 * @param tagAddShortcutDesktop
	 */
	public void setTagAddShortcutDesktop(TagAddShortcutDesktop tagAddShortcutDesktop) {
		this.tagAddShortcutDesktop = tagAddShortcutDesktop;
	}

	/**
	 * returns the tag for add the program to the OS startup
	 * @return
	 */
	public TagAddStartup getTagAddStartup() {
		return tagAddStartup;
	}

	/**
	 * set the features for add the program to the OS startup 
	 * @param tagAddStartup
	 */
	public void setTagAddStartup(TagAddStartup tagAddStartup) {
		this.tagAddStartup = tagAddStartup;
	}

	/**
	 * returns the tag of the project
	 * @return
	 */
	public TagProject getTagProject() {
		return tagProject;
	}

	/**
	 * sets the tag of the project
	 * @param tagProject
	 */
	public void setTagProject(TagProject tagProject) {
		this.tagProject = tagProject;
	}

	/**
	 * returns the tag for offer directory to install
	 * @return
	 */
	public TagOfferDirectoryInstall getTagOfferDirectoryInstall() {
		return tagOfferDirectoryInstall;
	}

	/**
	 * sets the tag for offer directory to install 
	 * @param tagOfferDirectoryInstall
	 */
	public void setTagOfferDirectoryInstall(TagOfferDirectoryInstall tagOfferDirectoryInstall) {
		this.tagOfferDirectoryInstall = tagOfferDirectoryInstall;
	}

	/**
	 * returns the tag of the messages
	 * @return
	 */
	public TagMessages getTagMessages() {
		return tagMessages;
	}

	/**
	 * sets the tag of the messages
	 * @param tagMessages
	 */
	public void setTagMessages(TagMessages tagMessages) {
		this.tagMessages = tagMessages;
	}

	/**
	 * returns the tag for store the metadata
	 * @return
	 */
	public TagMetadata getTagMetadata() {
		return tagMetadata;
	}

	/**
	 * sets the tag for store the metadata
	 * @param tagMetadata
	 */
	public void setTagMetadata(TagMetadata tagMetadata) {
		this.tagMetadata = tagMetadata;
	}

	/**
	 * returns the tag of the security key
	 * @return
	 */
	public TagSecurityKey getTagSecurityKey() {
		return tagSecurityKey;
	}

	/**
	 * sets the tag of the security key
	 * @param tagSecurityKey
	 */
	public void setTagSecurityKey(TagSecurityKey tagSecurityKey) {
		this.tagSecurityKey = tagSecurityKey;
	}

	/**
	 * returns the list of the operating system supported
	 * @return
	 */
	public ArrayList<TagOperatingSystem> getListTagOperatingSystem() {
		return listTagOperatingSystem;
	}
	
	/**
	 * adds a operating system into the list of the operating system supported
	 * @param tagOperatingSystem
	 */
	public void addListTagOperationgSystem(TagOperatingSystem tagOperatingSystem){
		listTagOperatingSystem.add(tagOperatingSystem);
	}

	/**
	 * returns the path of jtm file
	 * @return
	 */
	public String getPathJtm() {
		return pathJtm;
	}

	/**
	 * sets the path of jtm file
	 * @param pathJtm
	 */
	public void setPathJtm(String pathJtm) {
		this.pathJtm = pathJtm;
	}
	
	
}
