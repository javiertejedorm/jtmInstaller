package com.jtmproject.actions;

import java.util.ArrayList;

import com.jtmproject.install.HKEYForInstall;
import com.jtmproject.task.ListOfPrograms;
import com.jtmproject.task.Program;
import com.jtmproject.task.TagExtensionsSupported;

/**
 * This class modify the install if the user change any settings.
 * @author Javier Tejedor 
 */
public class ModifyInstallByUser {

	/**
	 * constructor
	 * @param program
	 * @param newFolderToInstall
	 * @param doShortcutDesktop
	 * @param doShortcutStartMenu
	 */
	public ModifyInstallByUser(Program program, int indexProgram, String newFolderToInstall, boolean doShortcutDesktop, boolean doShortcutStartMenu, int HKEYToInstall, ArrayList<String> extensionsAssociated){
		modifyInstall(program, indexProgram, newFolderToInstall, doShortcutDesktop, doShortcutStartMenu, HKEYToInstall, extensionsAssociated);
	}
	
	/**
	 * this modify the install
	 * @param program
	 * @param newFolderToInstall
	 * @param doShortcutDesktop
	 * @param doShortcutStartMenu
	 */
	private void modifyInstall(Program program, int indexProgram, String newFolderToInstall, boolean doShortcutDesktop, boolean doShortcutStartMenu, int HKEYToInstall, ArrayList<String> extensionsAssociated){
		int size = program.getListTagOperatingSystem().size();
		for(int i = 0; i < size; i++){
			if(program.getListTagOperatingSystem().get(i).getNameOfOperatingSystem().toLowerCase().equals(OperatingSystem.getOS().toLowerCase())){
				ListOfPrograms.getLop().getListPrograms().get(indexProgram).getListTagOperatingSystem().get(i).setRootDirectoryInstall(newFolderToInstall);
				ListOfPrograms.getLop().getListPrograms().get(indexProgram).getListTagOperatingSystem().get(i).setFolder("");
			}
		}
		
		if(!doShortcutDesktop){
			ListOfPrograms.getLop().getListPrograms().get(indexProgram).setTagAddShortcutDesktop(null);
		}
		
		if(!doShortcutStartMenu){
			ListOfPrograms.getLop().getListPrograms().get(indexProgram).clearTagAddProgramsMenu();
		}
		
		//sets the directory to install the application into the regisrty
		HKEYForInstall.setCurrentHKEY(HKEYToInstall);
		
		//sets the extensions
		if(extensionsAssociated != null){
			if(extensionsAssociated.size() != program.getListTagExtensionsSupported().size()){
				program.removeListTagExtensionSupported();
				for(int i = 0; i < extensionsAssociated.size(); i++){
					program.addListTagExtensionsSupported(new TagExtensionsSupported(extensionsAssociated.get(i)));
				}
			}
		}else{
			program.removeListTagExtensionSupported();
		}
	}
}
