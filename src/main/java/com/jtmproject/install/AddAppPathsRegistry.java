package com.jtmproject.install;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import com.jtmproject.actions.RegistryUtils;
import com.jtmproject.gui.JLabelProgressInstallation;
import com.jtmproject.task.Program;
import com.jtmproject.user.MessagesUser;
/**
 * This class add the program to the App Paths into registry. This is for make compatible the program with Windows
 * @author Javier Tejedor
 */
public class AddAppPathsRegistry {

	/**
	 * this adds the program to the "\SOFTWARE\Microsoft\Windows\CurrentVersion\App Paths\ into the registry"
	 * @param program
	 */
	public void addAppPaths(Program program){
		
		String pathRegistry = "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\App Paths\\";
		
		int currentHKEY = HKEYForInstall.getCurrentHKEY();
		
		String name = new File(program.getTagProject().getExecutableFile()).getName();
		String pathWorking = PathInstallProgram.getRootPathInstallProgram(program);
		String pathFull = pathWorking + "\\" + name;
		
		JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getAddingRegistryAppPaths() + " " + pathFull);
		
		try {
			System.out.println(currentHKEY);
			RegistryUtils.createKey(currentHKEY, pathRegistry + name);
			RegistryUtils.writeStringValue(currentHKEY, pathRegistry + name, "", pathFull);
			RegistryUtils.writeStringValue(currentHKEY, pathRegistry + name, "Path", pathWorking);
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
