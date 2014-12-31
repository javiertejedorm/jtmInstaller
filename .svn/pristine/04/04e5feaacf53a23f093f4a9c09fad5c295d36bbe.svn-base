package com.jtmproject.actions;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jtmproject.task.ListOfPrograms;
import com.jtmproject.task.Program;
import com.jtmproject.task.TagAddProgramsMenu;
import com.jtmproject.task.TagAddShortcutDesktop;
import com.jtmproject.task.TagAddStartup;
import com.jtmproject.task.TagDownload;
import com.jtmproject.task.TagExtensionsSupported;
import com.jtmproject.task.TagMessages;
import com.jtmproject.task.TagMetadata;
import com.jtmproject.task.TagOfferDirectoryInstall;
import com.jtmproject.task.TagOperatingSystem;
import com.jtmproject.task.TagProject;
import com.jtmproject.task.TagSecurityKey;
import com.jtmproject.user.Tags;

/**
 * This is a Singleton class. It read a document xml and stores the data into the lists (UrlDownload)
 * @author Javier Tejedor
 */
public class ReadJTM{

	public static ReadJTM xmlReader;
	private Program program;
	
	/**
	 * returns XMLReader's variable
	 * @return
	 */
	public static ReadJTM getXMLReader(){
		if(xmlReader == null){
			xmlReader = new ReadJTM();
		}
		return xmlReader;
	} 

	/**
	 * this method reads a XML file passed trough parameter
	 * @param path
	 * @return
	 */
	public boolean readXMLFile(String path){
		
		try {
			
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			program = new Program();
			
			program.setPathJtm(path);
			
			NodeList nListSecurityKey = doc.getElementsByTagName(Tags.SECURITY_KEY);
			if(nListSecurityKey != null){
				extractSecurityKey(nListSecurityKey);
			}
			
			NodeList nListOperatingSystem = doc.getElementsByTagName(Tags.OPERATING_SYSTEM);
			if(nListOperatingSystem != null){
				extractOperatingSystem(nListOperatingSystem);
			}
			
			NodeList nListProjectName = doc.getElementsByTagName(Tags.PROJECT);
			if(nListProjectName != null){
				extractProjectName(nListProjectName);
			}
			
			NodeList nListOfferDirectoryInstall = doc.getElementsByTagName(Tags.OFFER_DIRECTORY_INSTALL);
			if(nListOfferDirectoryInstall != null){
				extractOfferDirectoryInstall(nListOfferDirectoryInstall);
			}
			
			NodeList nListMessages = doc.getElementsByTagName(Tags.MESSAGES);
			if(nListMessages != null){
				extractMessages(nListMessages);
			}
			
			NodeList nListMetadata = doc.getElementsByTagName(Tags.METADATA);
			if(nListMetadata != null){
				extractMetadata(nListMetadata);
			}
			
			NodeList nListDownload = doc.getElementsByTagName(Tags.DOWNLOAD);
			if(nListDownload != null){
				extractDownload(nListDownload);
			}
			
			NodeList nListAddStartup = doc.getElementsByTagName(Tags.ADD_STARTUP);
			if(nListAddStartup != null){
				extractAddStartup(nListAddStartup);
			}
			
			NodeList nListAddShorcutDesktop = doc.getElementsByTagName(Tags.ADD_SHORCUT_DESKTOP);
			if(nListAddShorcutDesktop != null){
				extractAddShorcutDesktop(nListAddShorcutDesktop);
			}
			
			NodeList nListAddProgramsMenu = doc.getElementsByTagName(Tags.ADD_PROGRAMS_MENU);
			if(nListAddProgramsMenu != null){
				extractAddProgramsMenu(nListAddProgramsMenu);
			}
			
			NodeList nListExtensionSupported = doc.getElementsByTagName(Tags.EXTENSIONS_SUPPORTED);
			if(nListExtensionSupported != null){
				extractExtensionSupported(nListExtensionSupported);
			}
			
			ListOfPrograms.getLop().addListProgram(program);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * this method extracts the content of the tag project_name and add a task
	 * @param nListProjectName
	 */
	private void extractProjectName(NodeList nListProjectName){
		for (int temp = 0; temp < nListProjectName.getLength(); temp++) {
			Node nNode = nListProjectName.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				String name = eElement.getElementsByTagName(Tags.NAME).item(0).getTextContent();
				String totalFiles = eElement.getElementsByTagName(Tags.TOTAL_FILES).item(0).getTextContent();
				String url = eElement.getElementsByTagName(Tags.URL).item(0).getTextContent();
				String size = eElement.getElementsByTagName(Tags.SIZE).item(0).getTextContent();
				String executableFile = eElement.getElementsByTagName(Tags.EXECUTABLE_FILE).item(0).getTextContent();
				String uninstallFile = eElement.getElementsByTagName(Tags.UNINSTALL_FILE).item(0).getTextContent();
				String idImage = eElement.getElementsByTagName(Tags.ID_IMAGE).item(0).getTextContent();
				
				program.setTagProject(new TagProject(name, url, size, executableFile, uninstallFile, idImage, totalFiles));
			}
		}
	}
	
	/**
	 * this method extracts the content of the tag operating_system and add a task
	 * @param nListOperatingSystem
	 */
	private void extractOperatingSystem(NodeList nListOperatingSystem){
		for (int temp = 0; temp < nListOperatingSystem.getLength(); temp++) {
			Node nNode = nListOperatingSystem.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				String name = eElement.getElementsByTagName(Tags.NAME).item(0).getTextContent();
				String rootDirectory = eElement.getElementsByTagName(Tags.ROOT_DIRECTORY).item(0).getTextContent();
				String folder = eElement.getElementsByTagName(Tags.FOLDER).item(0).getTextContent();
				
				program.addListTagOperationgSystem(new TagOperatingSystem(name, rootDirectory, folder));
			}
		} 
	}
	
	/**
	 * this method extracts the content of the tag add_startup and add a task
	 * @param nListAddStartup
	 */
	private void extractAddStartup(NodeList nListAddStartup){
		for (int temp = 0; temp < nListAddStartup.getLength(); temp++) {
			Node nNode = nListAddStartup.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				String name = eElement.getElementsByTagName(Tags.NAME).item(0).getTextContent();
				String file = eElement.getElementsByTagName(Tags.FILE).item(0).getTextContent();
				
				program.setTagAddStartup(new TagAddStartup(name, file));
			}
		}
	}
	
	/**
	 * this method extracts the content of the tag offer_directory_install and add a task
	 * @param nListOfferDirectoryInstall
	 */
	private void extractOfferDirectoryInstall(NodeList nListOfferDirectoryInstall){
		for (int temp = 0; temp < nListOfferDirectoryInstall.getLength(); temp++) {
			Node nNode = nListOfferDirectoryInstall.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				String offer = eElement.getElementsByTagName(Tags.OFFER).item(0).getTextContent();
				
				program.setTagOfferDirectoryInstall(new TagOfferDirectoryInstall(Boolean.valueOf(offer)));
			}
		}
	}
	
	/**
	 * this method extracts the content of the tag add_shorcut_desktop and add a task
	 * @param nListAddShorcutDesktop
	 */
	private void extractAddShorcutDesktop(NodeList nListAddShorcutDesktop){
		for (int temp = 0; temp < nListAddShorcutDesktop.getLength(); temp++) {
			Node nNode = nListAddShorcutDesktop.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				String name = eElement.getElementsByTagName(Tags.NAME).item(0).getTextContent();
				String file = eElement.getElementsByTagName(Tags.FILE).item(0).getTextContent();
				
				program.setTagAddShortcutDesktop(new TagAddShortcutDesktop(name, file));
			}
		}
	}
	
	/**
	 * this method extracts the content of the tag add_programs_menu and add a task
	 * @param nListAddProgramsMenu
	 */
	private void extractAddProgramsMenu(NodeList nListAddProgramsMenu){
		for (int temp = 0; temp < nListAddProgramsMenu.getLength(); temp++) {
			Node nNode = nListAddProgramsMenu.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				String folder = eElement.getElementsByTagName(Tags.FOLDER).item(0).getTextContent();
				String name = eElement.getElementsByTagName(Tags.NAME).item(0).getTextContent();
				String file = eElement.getElementsByTagName(Tags.FILE).item(0).getTextContent();
				
				program.addTagProgramsMenus(new TagAddProgramsMenu(folder, name, file));
			}
		}
	}
	
	/**
	 * this method extracts the content of the tag messages and add a task
	 * @param nListMessages
	 */
	private void extractMessages(NodeList nListMessages){
		for (int temp = 0; temp < nListMessages.getLength(); temp++) {
			Node nNode = nListMessages.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				String welcome = eElement.getElementsByTagName(Tags.WELCOME).item(0).getTextContent();
				String copyright = eElement.getElementsByTagName(Tags.COPYRIGHT).item(0).getTextContent();
				
				program.setTagMessages(new TagMessages(welcome, copyright));
			}
		}
	}
	
	/**
	 * this method extracts the content of the tag metadata and add a task
	 * @param nListMetadata
	 */
	private void extractMetadata(NodeList nListMetadata){
		for (int temp = 0; temp < nListMetadata.getLength(); temp++) {
			Node nNode = nListMetadata.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				String author = eElement.getElementsByTagName(Tags.AUTHOR).item(0).getTextContent();
				String localization = eElement.getElementsByTagName(Tags.LOCALIZATION).item(0).getTextContent();
				String description = eElement.getElementsByTagName(Tags.DESCRIPTION).item(0).getTextContent();
				String developer = eElement.getElementsByTagName(Tags.DEVELOPER).item(0).getTextContent();
				String officialUrl = eElement.getElementsByTagName(Tags.OFFICIAL_URL).item(0).getTextContent();
				String productCode = eElement.getElementsByTagName(Tags.PRODUCT_CODE).item(0).getTextContent();
				String productName = eElement.getElementsByTagName(Tags.PRODUCT_NAME).item(0).getTextContent();
				String technicalSupportTelephone = eElement.getElementsByTagName(Tags.TECHNICAL_SUPPORT_TELEPHONE).item(0).getTextContent();
				String technicalSupportUrl = eElement.getElementsByTagName(Tags.TECHNICAL_SUPPORT_URL).item(0).getTextContent();
				String version = eElement.getElementsByTagName(Tags.VERSION).item(0).getTextContent();
				
				TagMetadata tagMetadata = new TagMetadata();
				tagMetadata.setAuthor(author);
				tagMetadata.setLocalization(localization);
				tagMetadata.setDescription(description);
				tagMetadata.setDeveloper(developer);
				tagMetadata.setOfficialUrl(officialUrl);
				tagMetadata.setProductCode(productCode);
				tagMetadata.setProductName(productName);
				tagMetadata.setTechnicalSupportTelephone(technicalSupportTelephone);
				tagMetadata.setTechnicalSupportUrl(technicalSupportUrl);
				tagMetadata.setVersion(version);
				
				program.setTagMetadata(tagMetadata);
			}
		}
	}
	
	/**
	 * this method extracts the content of the tag download and add a task
	 * @param nListDownload
	 */
	private void extractDownload(NodeList nListDownload){
		for (int temp = 0; temp < nListDownload.getLength(); temp++) {
			Node nNode = nListDownload.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				String url = eElement.getElementsByTagName(Tags.URL).item(0).getTextContent();
				String folder = eElement.getElementsByTagName(Tags.FOLDER).item(0).getTextContent();
				String filename = eElement.getElementsByTagName(Tags.FILENAME).item(0).getTextContent();
				String size = eElement.getElementsByTagName(Tags.SIZE).item(0).getTextContent();
				
				program.setTagDownload(new TagDownload(url, folder, filename, size));
			}
		}
	}
	
	/**
	 * this method extracts the content of the tag security_key and add a task
	 * @param nListSecurityKey
	 */
	private void extractSecurityKey(NodeList nListSecurityKey){
		for (int temp = 0; temp < nListSecurityKey.getLength(); temp++) {
			Node nNode = nListSecurityKey.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				String securityKey = eElement.getElementsByTagName(Tags.KEY).item(0).getTextContent();
				
				program.setTagSecurityKey(new TagSecurityKey(securityKey));
			}
		}
	}
	
	/**
	 * this method extracts the content of the tag extensions_supported and add a task
	 * @param nListSecurityKey
	 */
	private void extractExtensionSupported(NodeList nListSecurityKey){
		for (int temp = 0; temp < nListSecurityKey.getLength(); temp++) {
			Node nNode = nListSecurityKey.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				String extensionSupported = eElement.getElementsByTagName(Tags.EXTENSION).item(0).getTextContent();
				program.addListTagExtensionsSupported(new TagExtensionsSupported(extensionSupported));
			}
		}
	}
}
