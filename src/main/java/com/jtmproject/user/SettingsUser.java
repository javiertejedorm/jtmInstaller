package com.jtmproject.user;

/**
 * this class stores the user settings
 * @author Javier Tejedor
 */
public class SettingsUser {

	private static boolean cleanTemporaryEveryTwoDays;
	private static boolean showCertificateInformation;
	private static boolean removeJtmAfterInstall;
	private static boolean keepSessionExit;
	private static boolean askForUpdates;
	private static boolean checkNewVersionIfFailToOpenJtmFile;
	
	/**
	 * returns if the user want to clean temporary files  
	 * @return
	 */
	public static boolean isCleanTemporaryEveryTwoDays() {
		return cleanTemporaryEveryTwoDays;
	}
	
	/**
	 * sets if the user want to clean temporary files
	 * @param cleanTemporaryEveryTwoDays
	 */
	public static void setCleanTemporaryEveryTwoDays(
			boolean cleanTemporaryEveryTwoDays) {
		SettingsUser.cleanTemporaryEveryTwoDays = cleanTemporaryEveryTwoDays;
	}
	
	/**
	 * returns if the user want to show the certificate information when open a jtm 
	 * @return
	 */
	public static boolean isShowCertificateInformation() {
		return showCertificateInformation;
	}
	
	/**
	 * sets if the user want to show the certificate information when open a jtm
	 * @param showCertificateInformation
	 */
	public static void setShowCertificateInformation(
			boolean showCertificateInformation) {
		SettingsUser.showCertificateInformation = showCertificateInformation;
	}
	
	/**
	 * returns if the user want to remove the jtm after his install
	 * @return
	 */
	public static boolean isRemoveJtmAfterInstall() {
		return removeJtmAfterInstall;
	}
	
	/**
	 * sets if the user want to remove the jtm after his install
	 * @param removeJtmAfterInstall
	 */
	public static void setRemoveJtmAfterInstall(boolean removeJtmAfterInstall) {
		SettingsUser.removeJtmAfterInstall = removeJtmAfterInstall;
	}
	
	/**
	 * returns if the user want to keep his session after exit
	 * @return
	 */
	public static boolean isKeepSessionExit() {
		return keepSessionExit;
	}

	/**
	 * sets if the user want to keep his session after exit
	 * @param keepSessionExit
	 */
	public static void setKeepSessionExit(boolean keepSessionExit) {
		SettingsUser.keepSessionExit = keepSessionExit;
	}

	/**
	 * returns if the user want to be asked by the program for updates
	 * @return
	 */
	public static boolean isAskForUpdates() {
		return askForUpdates;
	}
	
	/**
	 * sets  if the user want to be asked by the program for updates
	 * @param askForUpdates
	 */
	public static void setAskForUpdates(boolean askForUpdates) {
		SettingsUser.askForUpdates = askForUpdates;
	}

	/**
	 * returns if the user want to check a new version if the .jtm file fails to open 
	 * @return
	 */
	public static boolean isCheckNewVersionIfFailToOpenJtmFile() {
		return checkNewVersionIfFailToOpenJtmFile;
	}

	/**
	 * sets if the user want to check a new version if the .jtm file fails to open 
	 * @param checkNewVersionIfFailToOpenJtmFile
	 */
	public static void setCheckNewVersionIfFailToOpenJtmFile(
			boolean checkNewVersionIfFailToOpenJtmFile) {
		SettingsUser.checkNewVersionIfFailToOpenJtmFile = checkNewVersionIfFailToOpenJtmFile;
	}
	
}
