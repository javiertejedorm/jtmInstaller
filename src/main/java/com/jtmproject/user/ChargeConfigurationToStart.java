package com.jtmproject.user;

import com.jtmproject.actions.CheckNewVersion;
import com.jtmproject.actions.Checks;
import com.jtmproject.actions.CleanTemporaryFolder;
import com.jtmproject.actions.DatesUtils;
import com.jtmproject.actions.FilesUtils;
import com.jtmproject.server.ServerUrls;

/**
 * this class charges all the configuration for a good start of the program.
 * @author Javier Tejedor
 */
public class ChargeConfigurationToStart {

	private static final int DAYS_TO_CLEAN_TEMPORARY = 2;

	/**
	 * constructor
	 */
	public ChargeConfigurationToStart(){
		fillAllPaths();
		chargePropertiesUser();
		chargeSettingsUser();
		createFolders();
		
		if(SettingsUser.isCleanTemporaryEveryTwoDays()){
			cleanJtmTemporaryFiles();
		}
		
		if(SettingsUser.isAskForUpdates()){
			checkNewVersion();
		}
	}
	
	/**
	 * this method recovers all the paths necessary for the program
	 */
	private void fillAllPaths(){
		GeneralPaths.getGp().fillPaths();
	}
	
	/**
	 * this method starts the program with the last configuration saved by the user
	 */
	private void chargePropertiesUser(){
		UserProperties.getUp().readProperties(); 
		if(UserProperties.getUp().getUrl() != null){
			ServerUrls.getSip().setIpStore(UserProperties.getUp().getUrl());
		}
		GeneralPaths.getGp().setLastDirectoryOpened(UserProperties.getUp().getLastDirectoryOpened());		
	}
	
	/**
	 * this charges the settings of the user
	 */
	private void chargeSettingsUser(){
		SettingsUser.setCleanTemporaryEveryTwoDays(UserProperties.getUp().isCleanTemporaryFiles());
		SettingsUser.setKeepSessionExit(UserProperties.getUp().isKeepSession());
		SettingsUser.setRemoveJtmAfterInstall(UserProperties.getUp().isRemoveJtmAfterInstall());
		SettingsUser.setCheckNewVersionIfFailToOpenJtmFile(UserProperties.getUp().isCheckNewVersionJtmFail());
		SettingsUser.setShowCertificateInformation(UserProperties.getUp().isShowCertificateInformation());
		SettingsUser.setAskForUpdates(UserProperties.getUp().isAskForUpdates());
	}
	
	/**
	 * this class cleans all the temporary files if was needed.
	 */
	private void cleanJtmTemporaryFiles(){
		if(new DatesUtils().temporalFolderMustBeCleaned(UserProperties.getUp().getDateCleanTemp(), DAYS_TO_CLEAN_TEMPORARY)){
			new CleanTemporaryFolder();
		}
	}
	
	/**
	 * this method creates the basic folders
	 */
	private void createFolders(){
		if(!FilesUtils.existFile(GeneralPaths.getGp().getRootPath())){
			FilesUtils.mkDir(GeneralPaths.getGp().getRootPath());
		}
		
		if(!FilesUtils.existFile(GeneralPaths.getGp().getPathImages())){
			FilesUtils.mkDir(GeneralPaths.getGp().getPathImages());
		}
		
		if(!FilesUtils.existFile(GeneralPaths.getGp().getPathJtms())){
			FilesUtils.mkDir(GeneralPaths.getGp().getPathJtms());
		}
		
		if(!FilesUtils.existFile(GeneralPaths.getGp().getPathFiles())){
			FilesUtils.mkDir(GeneralPaths.getGp().getPathJtms());
		}
	}
	
	/**
	 * this checks if there is a new version available
	 */
	private void checkNewVersion(){
		if(Checks.isConnectServerPossible()){
			new CheckNewVersion(false);
		}
	}
}
