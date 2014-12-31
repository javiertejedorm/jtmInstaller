package com.jtmproject.user;

import java.lang.reflect.InvocationTargetException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.jtmproject.actions.RegistryUtils;

/**
 * This class stores the path of this program (C:\Programs Files\OneClick)
 * @author Javier Tejedor
 */
public class GeneralPaths {
	
	public static GeneralPaths gp;
	
	private String rootPath;
	private String pathBin;
	private String pathFiles;
	private String pathSettings;
	private String pathValidationXSD;
	private String pathProgramCreateShortcut;
	private String pathImages;
	private String pathBackground;
	private String pathJtms;
	
	private String lastDirectoryOpened;
	
	
	public String getLastDirectoryOpened() {
		return lastDirectoryOpened;
	}

	public void setLastDirectoryOpened(String lastDirectoryOpened) {
		this.lastDirectoryOpened = lastDirectoryOpened;
	}

	/**
	 * returns an instance of GeneralPaths (Singleton Class)
	 */
	public static GeneralPaths getGp(){
		if(gp == null){
			gp = new GeneralPaths();
		}
		return gp;
	}

	/**
	 * this method fills the paths for a correct functioning 
	 */
	public void fillPaths() {
		rootPath = getRootPathFromCurrentUser();

		if(rootPath == null){
			rootPath = getRootPathFromLocalMachine();
			if(rootPath == null){

				//houston we have a problem!!!Control this!!!
			}
		}
		
		pathBin = rootPath + "\\bin";
		pathProgramCreateShortcut = pathBin + "\\create_shortcut.exe";
		pathImages = rootPath + "\\images";
		pathFiles = rootPath + "\\files";
		pathSettings = pathFiles + "\\settings.properties";
		pathValidationXSD = pathFiles + "\\validation.xsd";
		pathBackground = pathFiles + "\\background.jpg";
		pathJtms = rootPath + "\\jtm";
		
	}
	
	/**
	 * this method saves the directory for selecting files more easly
	 * @param file
	 */
	public void saveDirectory(String directory) {
		setLastDirectoryOpened(directory);
		UserProperties.getUp().writeProperties();
	}
	
	/**
	 * returns the path of the background image
	 * @return
	 */
	public String getPathBackground() {
		return pathBackground;
	}

	/**
	 * returns the root path saved into the registry, in the Current User
	 * @return
	 */
	private String getRootPathFromCurrentUser(){
		String path = null;
		try {
			path = RegistryUtils.readString(RegistryUtils.HKEY_CURRENT_USER, "Software\\Microsoft\\Windows\\CurrentVersion\\App Paths\\jtmInstaller.exe", "Path");
			if(path == null){
				path = RegistryUtils.readString(RegistryUtils.HKEY_LOCAL_MACHINE, "Software\\Microsoft\\Windows\\CurrentVersion\\App Paths\\jtmInstaller.exe", "Path");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return path;
	}
	
	/**
	 * returns the root path saved into the registry, in the Local Machine
	 * @return
	 */
	private String getRootPathFromLocalMachine(){
		try {
			return RegistryUtils.readString(RegistryUtils.HKEY_LOCAL_MACHINE, "Software\\Microsoft\\Windows\\CurrentVersion\\App Paths\\jtmInstaller.exe", "Path");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * returns the arrow's icon
	 * @return
	 */
	public ImageIcon getIconArrow(JFrame jFrame) {
		ClassLoader cl = jFrame.getClass().getClassLoader();
		return new ImageIcon(cl.getResource("resources/images/arrow.png"));
	}

	/**
	 * returns the root path of the program
	 * @return
	 */
	public String getRootPath() {
		return rootPath;
	}

	/**
	 * returns the bin folder path
	 * @return
	 */
	public String getPathBin() {
		return pathBin;
	}

	/**
	 * returns the images folder path
	 * @return
	 */
	public String getPathImages() {
		return pathImages;
	}

	/**
	 * returns the jtm folder path
	 * @return
	 */
	public String getPathJtms() {
		return pathJtms;
	}

	/**
	 * returns the path of the program to do the shortcuts
	 * @return
	 */
	public String getPathProgramCreateShortcut() {
		return pathProgramCreateShortcut;
	}

	/**
	 * returns the default icon resource
	 * @return
	 */
	public ImageIcon getPathDefaultIcon(JFrame jFrame) {
		ClassLoader cl = jFrame.getClass().getClassLoader();
		return new ImageIcon(cl.getResource("resources/images/default_icon.png"));
	}

	/**
	 * returns the .gif of animation charging
	 * @return
	 */
	public ImageIcon getIconAnimationCharging(JFrame jFrame) {
		ClassLoader cl = jFrame.getClass().getClassLoader();
		return new ImageIcon(cl.getResource("resources/images/loading.gif"));
	}

	/**
	 * returns the path of the folder "files"
	 * @return
	 */
	public String getPathFiles() {
		return pathFiles;
	}

	/**
	 * returns the path of the settings-file
	 * @return
	 */
	public String getPathSettings() {
		return pathSettings;
	}

	/**
	 * returns the path of the xsd file
	 * @return
	 */
	public String getPathValidationXSD() {
		return pathValidationXSD;
	}	
}
