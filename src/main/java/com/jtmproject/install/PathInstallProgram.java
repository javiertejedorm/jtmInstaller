package com.jtmproject.install;

import com.jtmproject.actions.GetPathsOS;
import com.jtmproject.actions.OperatingSystem;
import com.jtmproject.task.Program;

/**
 * This class has a method to return the path to install the program
 * @author Javier Tejedor
 */
public class PathInstallProgram {
	
	/**
	 * returns the root path for create the folders to install the program
	 * @param program
	 * @return
	 */
	public static String getRootPathInstallProgram(Program program){
		int size = program.getListTagOperatingSystem().size();
		for(int i = 0; i < size; i++){
			if(program.getListTagOperatingSystem().get(i).getNameOfOperatingSystem().toLowerCase().equals(OperatingSystem.getOS().toLowerCase())){
				return GetPathsOS.getLetterWindows() + program.getListTagOperatingSystem().get(i).getRootDirectoryInstall() + "\\" + program.getListTagOperatingSystem().get(i).getFolder();
			}
		}
		return "";
	}
	
	/**
	 * returns the root path for create the folders to install the program
	 * @param program
	 * @return
	 */
	public static String getNameFolderInstallProgram(Program program){
		int size = program.getListTagOperatingSystem().size();
		for(int i = 0; i < size; i++){
			if(program.getListTagOperatingSystem().get(i).getNameOfOperatingSystem().toLowerCase().equals(OperatingSystem.getOS().toLowerCase())){
				return program.getListTagOperatingSystem().get(i).getFolder();
			}
		}
		return "";
	}
	
	/**
	 * returns the user application folder to do the install in the current user 
	 * @return
	 */
	public static String getLocalAppData(Program program){
		return System.getProperty("user.home") + "\\AppData\\Local\\" + getNameFolderInstallProgram(program);
	}
}
