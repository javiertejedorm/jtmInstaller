package com.jtmproject.install;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.jtmproject.actions.RegistryUtils;
import com.jtmproject.actions.StringUtils;
import com.jtmproject.gui.JLabelProgressInstallation;
import com.jtmproject.task.Program;
import com.jtmproject.user.MessagesUser;

/**
 * This class adds the program to the "Uninstall" Registry for make compatible with "Uninstall Programs" in Windows
 * @author Javier Tejedor
 */
public class AddUninstallRegistry {

	/**
	 * add the program to uninstall registry
	 * @param program
	 */
	public void addUninstaller(Program program){
		
		String pathRegistry = "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\";
		
		String nameProject = program.getTagProject().getName();
		int currentHKEY = HKEYForInstall.getCurrentHKEY();
		String pathWorking = PathInstallProgram.getRootPathInstallProgram(program);
		String pathUninstaller = pathWorking + program.getTagProject().getUninstallFile();
		String version = program.getTagMetadata().getVersion();
		String sizeProject = program.getTagProject().getSize();
		String linkHelp = program.getTagMetadata().getTechnicalSupportUrl();
		String publisher = program.getTagMetadata().getAuthor();
		String url = program.getTagMetadata().getOfficialUrl();
		
		JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getAddingRegistryUninstaller() + " " + pathUninstaller);
		
		try {
			
			RegistryUtils.createKey(currentHKEY, pathRegistry + nameProject);
			RegistryUtils.writeStringValue(currentHKEY, pathRegistry + nameProject, "DisplayIcon", pathUninstaller);
			RegistryUtils.writeStringValue(currentHKEY, pathRegistry + nameProject, "DisplayName", nameProject);
			RegistryUtils.writeStringValue(currentHKEY, pathRegistry + nameProject, "DisplayVersion", version);
			RegistryUtils.writeRegDWordValue(currentHKEY, pathRegistry + nameProject, "EstimatedSize", StringUtils.sizeWithoutDecimals(sizeProject));
			RegistryUtils.writeStringValue(currentHKEY, pathRegistry + nameProject, "HelpLink", linkHelp);
			RegistryUtils.writeStringValue(currentHKEY, pathRegistry + nameProject, "InstallLocation", pathWorking);
			RegistryUtils.writeStringValue(currentHKEY, pathRegistry + nameProject, "ModifyPath", pathWorking);
			RegistryUtils.writeStringValue(currentHKEY, pathRegistry + nameProject, "Publisher", publisher);
			RegistryUtils.writeStringValue(currentHKEY, pathRegistry + nameProject, "URLInfoAbout", url);
			RegistryUtils.writeStringValue(currentHKEY, pathRegistry + nameProject, "UninstallString", pathUninstaller);
			RegistryUtils.writeStringValue(currentHKEY, pathRegistry + nameProject, "UninstallPath", pathUninstaller);
		
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
