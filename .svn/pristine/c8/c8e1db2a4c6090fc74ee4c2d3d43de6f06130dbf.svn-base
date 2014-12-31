package com.jtmproject.install;

import java.io.IOException;
import java.util.ArrayList;

import com.jtmproject.actions.GetPathsOS;
import com.jtmproject.actions.StringUtils;
import com.jtmproject.gui.JLabelProgressInstallation;
import com.jtmproject.task.Program;
import com.jtmproject.user.GeneralPaths;
import com.jtmproject.user.MessagesUser;

/**
 * This class add the program to the Menu-Programs
 * @author Javier Tejedor
 */
public class AddMenuPrograms {
		
	/**
	 * this function adds the program to the Menu Program
	 * @param program
	 * @return
	 */
	public boolean addMenuPrograms(Program program){
		new CreateDirectories().createFolders(GetPathsOS.getFolderStartMenu(), getListFolders(program));
		makeShorcuts(program);
		return false;
	}
	
	/**
	 * this method do the shortcuts in Menu-Programs
	 * @param program
	 */
	private void makeShorcuts(Program program){
		int size = program.getTagAddProgramsMenus().size();
		String pathInstallProgram = PathInstallProgram.getRootPathInstallProgram(program);
		for(int i = 0; i < size; i++){
			
			String file = pathInstallProgram + program.getTagAddProgramsMenus().get(i).getFile();
			file = StringUtils.removeInvalidCharacters(file);
			
			JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getAddingDesktopShortcuts() + " " + file);
			
			String nameShorcut = program.getTagAddProgramsMenus().get(i).getName();
			
			String folder = GetPathsOS.getFolderStartMenu() + program.getTagAddProgramsMenus().get(i).getFolder();
			folder = StringUtils.removeInvalidCharacters(folder);
			
			String description = nameShorcut;
			
			try {
				//this create the shortcuts
				new ProcessBuilder(GeneralPaths.getGp().getPathProgramCreateShortcut(), StringUtils.correctPathForCreateShorcutProgram("\"" + file + "\""), "\"" + StringUtils.correctPath(pathInstallProgram) + "\"", "\"" + description + "\"", StringUtils.correctPathForCreateShorcutProgram("\"" + folder + "\\" + nameShorcut + ".lnk" + "\"")).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * returns a list of folders to create directories
	 * @param program
	 * @return
	 */
	private ArrayList<String> getListFolders(Program program){
		ArrayList<String> folders = new ArrayList<String>();
		folders.clear();
		int size = program.getTagAddProgramsMenus().size();
		for(int i = 0; i < size; i++){
			folders.add("\\" + program.getTagAddProgramsMenus().get(i).getFolder());
		}
		return folders;
	}
}
