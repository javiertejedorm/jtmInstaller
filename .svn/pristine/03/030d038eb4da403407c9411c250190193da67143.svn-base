package com.jtmproject.actions;

import com.jtmproject.task.Program;

/**
 * This class analyzes if is possible install the program configuration their settings
 * @author Javier Tejedor
 */
public class AnalizeInstallWithSetting {

	/**
	 * returns if is possible install the program configuration their settings
	 * @param program
	 * @return
	 */
	public static boolean isPossibleConfigSettings(Program program){
		return isPossibleAddShortcutDesktop(program) || isPossibleAddStartMenu(program) || isPossibleChooseFolderToInstall(program);
	}
	
	/**
	 * returns if is possible add the shortcut in the Desktop (choosed by the creator of the jtm)
	 * @param program
	 * @return
	 */
	public static boolean isPossibleAddShortcutDesktop(Program program){
		if(program.getTagAddShortcutDesktop() != null){
			return true;
		}
		return false;
	}
	
	/**
	 * returns if is possible add the shortcut in the Start Menu (choosed by the creator of the jtm)
	 * @param program
	 * @return
	 */
	public static boolean isPossibleAddStartMenu(Program program){
		if(program.getTagAddProgramsMenus() != null){
			return true;
		}
		return false;
	}
	
	/**
	 * returns if is possible change the folder to install the program(choosed by the creator of the jtm)
	 * @param program
	 * @return
	 */
	public static boolean isPossibleChooseFolderToInstall(Program program){
		if(program.getTagOfferDirectoryInstall().isCanChooseFolder()){
			return true;
		}
		return false;
	}
}
