package com.jtmproject.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.jtmproject.actions.CipherUtils;
import com.jtmproject.actions.DatesUtils;
import com.jtmproject.actions.GetPathsOS;
import com.jtmproject.server.LoginUser;
import com.jtmproject.server.ServerUrls;

/**
 * This class gets and sets the user settings
 * @author Javier Tejedor
 * @tnks http://codejavu.blogspot.com.es/2013/05/leer-archivo-properties-en-java.html
 */
public class UserProperties {

	public static UserProperties up;

	private String user;
	private String password;
	private String url;
	private String lastDirectoryOpened;
	private String dateCleanTemp;
	private String askForUpdate;
	private String cleanTemporaryFiles;
	private String showCertificateInformation;
	private String removeJtmAfterInstall;
	private String keepSession;
	private String checkNewVersionJtmFail;

	public static final String KEY_USER = "user";
	public static final String KEY_PASSWORD = "password";
	public static final String KEY_URL = "url_server";
	public static final String KEY_LAST_DIRECTORY_OPENED = "last_directory_opened";
	public static final String KEY_ASK_FOR_UPDATES = "ask_for_updates"; 
	public static final String KEY_DATE_CLEAN_TEMP = "date_clean_temp";
	public static final String CLEAN_TEMPORARY = "clean_temporary";
	public static final String SHOW_CERTIFICATE_INFORMATION = "show_certificate_information";
	public static final String REMOVE_JTM_AFTER_INSTALL = "remove_jtm_after_install";
	public static final String KEEP_SESSION_EXIT = "keep_session_on_exit";
	public static final String CHECK_NEW_VERSION_WHEN_JTM_FAILS = "check_new_version_when_jtm_fail_open";

	/**
	 * This method returns an instance of UserProperties (Singleton Class)
	 * @return
	 */
	public static UserProperties getUp(){
		if(up == null){
			up = new UserProperties();
		}
		return up;
	}

	/**
	 * this method reads the properties. If it not exists, call to create a documents.
	 */
	public void readProperties(){
		String pathPropertiesFile = GeneralPaths.getGp().getPathSettings();
		if(!new File(pathPropertiesFile).exists()){
			createSettingFile();
		}

		try {

			Properties settings = new Properties(); 
			settings.load(new FileInputStream(pathPropertiesFile)); 

			//user
			user = settings.getProperty(KEY_USER);
			password = CipherUtils.decrypt(settings.getProperty(KEY_PASSWORD));
			url = settings.getProperty(KEY_URL);
			lastDirectoryOpened = settings.getProperty(KEY_LAST_DIRECTORY_OPENED);
			dateCleanTemp = settings.getProperty(KEY_DATE_CLEAN_TEMP);
			askForUpdate = settings.getProperty(KEY_ASK_FOR_UPDATES);

			//settings
			cleanTemporaryFiles = settings.getProperty(CLEAN_TEMPORARY);
			showCertificateInformation = settings.getProperty(SHOW_CERTIFICATE_INFORMATION);
			removeJtmAfterInstall = settings.getProperty(REMOVE_JTM_AFTER_INSTALL);
			keepSession = settings.getProperty(KEEP_SESSION_EXIT);
			checkNewVersionJtmFail = settings.getProperty(CHECK_NEW_VERSION_WHEN_JTM_FAILS);
			
			checkNullVariables();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * write the properties
	 * @param key
	 * @param value
	 */
	public void writeProperties(){
		String pathPropertiesFile = GeneralPaths.getGp().getPathSettings();

		try {
			Properties prop = new Properties();

			if(LoginUser.getLu().isConnected()){
				prop.setProperty(KEY_USER, LoginUser.getLu().getEmail());
				prop.setProperty(KEY_PASSWORD, CipherUtils.encrypt(LoginUser.getLu().getPassword()));
			}else{
				prop.setProperty(KEY_USER, "");
				prop.setProperty(KEY_PASSWORD, "");
			}

			if(dateCleanTemp == null){
				prop.setProperty(KEY_DATE_CLEAN_TEMP, new DatesUtils().getToday());
			}else{
				prop.setProperty(KEY_DATE_CLEAN_TEMP, dateCleanTemp);
			}
			
			if(GeneralPaths.getGp().getLastDirectoryOpened() == null){
				prop.setProperty(KEY_LAST_DIRECTORY_OPENED, GetPathsOS.getLetterWindows());
			}else{
				prop.setProperty(KEY_LAST_DIRECTORY_OPENED, GeneralPaths.getGp().getLastDirectoryOpened());
			}
			
			prop.setProperty(KEY_LAST_DIRECTORY_OPENED, GetPathsOS.getLetterWindows());

			prop.setProperty(KEY_URL, ServerUrls.getSip().getIpStore());
			prop.setProperty(KEY_ASK_FOR_UPDATES, String.valueOf(SettingsUser.isAskForUpdates()));
			prop.setProperty(CLEAN_TEMPORARY, String.valueOf(SettingsUser.isCleanTemporaryEveryTwoDays()));
			prop.setProperty(SHOW_CERTIFICATE_INFORMATION, String.valueOf(SettingsUser.isShowCertificateInformation()));
			prop.setProperty(REMOVE_JTM_AFTER_INSTALL, String.valueOf(SettingsUser.isRemoveJtmAfterInstall()));
			prop.setProperty(KEEP_SESSION_EXIT, String.valueOf(SettingsUser.isKeepSessionExit()));
			prop.setProperty(CHECK_NEW_VERSION_WHEN_JTM_FAILS, String.valueOf(SettingsUser.isCheckNewVersionIfFailToOpenJtmFile()));

			FileOutputStream fileOut = new FileOutputStream(pathPropertiesFile);
			prop.store(fileOut, null);
			fileOut.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * if there are problems reading the properties file we create a new properties file and set void all the variables 
	 */
	private void checkNullVariables(){
		if(isAnythingNull()){
			restartPropertiesFile();
			
		}else{
			if(!canCastBoolean()){
				restartPropertiesFile();
			}
		}
	}

	/**
	 * this method restarts the property file
	 */
	private void restartPropertiesFile(){
		new File(GeneralPaths.getGp().getPathSettings()).delete();
		createSettingFile();
		user = "";
		password = "";
		url = "";
		lastDirectoryOpened = "";
		dateCleanTemp = "";
		askForUpdate = "true";
		cleanTemporaryFiles = "true";
		showCertificateInformation = "true"; 
		removeJtmAfterInstall = "false"; 
		keepSession = "false";
		checkNewVersionJtmFail = "true";
	}

	/**
	 * returns true if anything is null
	 * @return
	 */
	private boolean isAnythingNull(){
		if(user == null || 
				password == null || 
				url == null || 
				lastDirectoryOpened == null ||
				dateCleanTemp == null || 
				cleanTemporaryFiles == null || 
				showCertificateInformation == null || 
				removeJtmAfterInstall == null || 
				keepSession == null ||
				askForUpdate == null ||
				checkNewVersionJtmFail == null){
			return true;
		}
		return false;
	}

	/**
	 * this tries to do a cast String - Boolean 
	 * @return
	 */
	private boolean canCastBoolean(){
		if(cleanTemporaryFiles.equalsIgnoreCase("true") || cleanTemporaryFiles.equalsIgnoreCase("false") &&
				showCertificateInformation.equalsIgnoreCase("true") || showCertificateInformation.equalsIgnoreCase("false") &&
				removeJtmAfterInstall.equalsIgnoreCase("true") || removeJtmAfterInstall.equalsIgnoreCase("false") &&
				keepSession.equalsIgnoreCase("true") || keepSession.equalsIgnoreCase("false") &&
				askForUpdate.equalsIgnoreCase("true") || askForUpdate.equalsIgnoreCase("false") &&
				checkNewVersionJtmFail.equalsIgnoreCase("true") || checkNewVersionJtmFail.equalsIgnoreCase("false")){
			return true;
		}
		return false;
	}

	/**
	 * this method creates a file settings if not exists
	 */
	private void createSettingFile(){
		Path newFile = Paths.get(GeneralPaths.getGp().getPathSettings());

		try(BufferedWriter writer = Files.newBufferedWriter(newFile, Charset.defaultCharset())){
			writer.append(KEY_URL + "=" + ServerUrls.getSip().getIpStore()); 
			writer.newLine(); 
			writer.append(KEY_USER + "="); 
			writer.newLine(); 
			writer.append(KEY_PASSWORD + "="); 
			writer.newLine(); 
			writer.append(KEY_DATE_CLEAN_TEMP + "=" + new DatesUtils().getToday()); 
			writer.newLine(); 
			writer.append(KEY_ASK_FOR_UPDATES + "=" + "true"); 
			writer.newLine(); 
			writer.append(KEY_LAST_DIRECTORY_OPENED + "=" + GetPathsOS.getLetterWindows());
			writer.newLine();
			writer.newLine(); 
			writer.append(SHOW_CERTIFICATE_INFORMATION + "=" + "true"); 
			writer.newLine(); 
			writer.append(CLEAN_TEMPORARY + "=" + "true"); 
			writer.newLine(); 
			writer.append(REMOVE_JTM_AFTER_INSTALL + "=" + "false"); 
			writer.newLine(); 
			writer.append(KEEP_SESSION_EXIT + "=" + "false"); 
			writer.newLine(); 
			writer.append(CHECK_NEW_VERSION_WHEN_JTM_FAILS + "=" + "true"); 
			writer.flush(); 
			writer.close();
		}catch(IOException exception){ 
			System.out.println("Error writing to file"); 
		}

	}

	/**
	 * returns the user saved
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * returns the password saved
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * returns the url saved
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * returns the last directory opened by the user to find a jtm
	 * @return
	 */
	public String getLastDirectoryOpened() {
		return lastDirectoryOpened;
	}

	/**
	 * returns the date of the last temp cleaned 
	 * @return
	 */
	public String getDateCleanTemp() {
		return dateCleanTemp;
	}

	/**
	 * returns if the user want to clean the temporary folder
	 * @return
	 */
	public boolean isCleanTemporaryFiles(){
		return Boolean.parseBoolean(cleanTemporaryFiles);
	}

	/**
	 * returns if the user want to show the certificate information when he opens the jtm
	 * @return
	 */
	public boolean isShowCertificateInformation(){
		return Boolean.parseBoolean(showCertificateInformation);
	}

	/**
	 * returns  if the user want to remove the jtm after install it
	 * @return
	 */
	public boolean isRemoveJtmAfterInstall(){
		return Boolean.parseBoolean(removeJtmAfterInstall);
	}
	
	
	/**
	 * returns if the user want to check a new version if the jtm fail when open
	 * @return
	 */
	public boolean isCheckNewVersionJtmFail(){
		return Boolean.parseBoolean(checkNewVersionJtmFail);
	}

	/**
	 * returns if the user want to keep his session when he had gone out.
	 * @return
	 */
	public boolean isKeepSession(){
		return Boolean.parseBoolean(keepSession);
	}
	
	/**
	 * returns if the user want to be asked for news updates.
	 * @return
	 */
	public boolean isAskForUpdates(){
		return Boolean.parseBoolean(askForUpdate);
	}
}
