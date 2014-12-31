package com.jtmproject.actions;

import com.jtmproject.install.PathInstallProgram;
import com.jtmproject.task.Program;

/**
 * this class cleans the install
 * @author Javier Tejedor
 */
public class CleanInstall {

	/**
	 * constructor
	 * @param program
	 */
	public CleanInstall(Program program){
		removeFolder(program);
		removeShortcuts(program);
		//...
	}
	
	/**
	 * this removes the folder
	 * @param program
	 */
	private void removeFolder(Program program){
		String pathInstallProgram = PathInstallProgram.getRootPathInstallProgram(program);
		FilesUtils.deleteDirectory(pathInstallProgram);
	}
	
	/**
	 * this method removes the shortcuts
	 * @param progrma
	 */
	private void removeShortcuts(Program progrma){
		//code, code, code
	}
}
