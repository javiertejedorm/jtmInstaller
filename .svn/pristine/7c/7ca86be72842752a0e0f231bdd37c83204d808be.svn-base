package com.jtmproject.actions;

import java.lang.reflect.InvocationTargetException;

/**
 * This class returns the most important path of the Operating System
 * @author Javier Tejedor
 */
public class GetPathsOS {

	/**
	 * returns the letter which Windows is installed
	 * @return
	 */
	public static String getLetterWindows(){
		return System.getenv("windir").substring(0, 3);
	}
	
	/**
	 * returns the path of Programs Files
	 * @return
	 */
	public static String getPathProgramsFiles(){
		return System.getenv("ProgramFiles");
	}
	
	/**
	 * returns the path of Menu-Programs
	 * @return
	 */
	public static String getFolderStartMenu(){
		try {
			return RegistryUtils.readString(RegistryUtils.HKEY_CURRENT_USER, "Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\Shell Folders", "Programs");
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
	 * returns the path of Desktop
	 * @return
	 */
	public static String getFolderDesktop(){
		try {
			return RegistryUtils.readString(RegistryUtils.HKEY_CURRENT_USER, "Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\Shell Folders", "Desktop");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
