package com.jtmproject.install;

import java.io.IOException;

import com.jtmproject.actions.GetPathsOS;
import com.jtmproject.actions.StringUtils;
import com.jtmproject.gui.JLabelProgressInstallation;
import com.jtmproject.task.Program;
import com.jtmproject.user.GeneralPaths;
import com.jtmproject.user.MessagesUser;

/**
 * This class does the Shortcut Desktop
 * @author Javier Tejedor
 */
public class DesktopShortcuts {
	
	/**
	 * this function creates the Shortcut Desktop
	 * @param program
	 * @return
	 */
	public boolean createShortcutDesktop(Program program){
		String pathDesktop = GetPathsOS.getFolderDesktop();
		String name = program.getTagAddShortcutDesktop().getName();
		String rootPath =  PathInstallProgram.getRootPathInstallProgram(program);
		String file = rootPath + program.getTagAddShortcutDesktop().getFile();
		
		String description = name;
		
		JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getAddShortcutDesktop() + " " + file);
		
		try {
			new ProcessBuilder(GeneralPaths.getGp().getPathProgramCreateShortcut(), StringUtils.correctPathForCreateShorcutProgram("\"" + file + "\""), "\"" + StringUtils.correctPath(rootPath) + "\"", "\"" + description + "\"", StringUtils.correctPathForCreateShorcutProgram("\"" + pathDesktop + "\\" + name + ".lnk" + "\"")).start();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
