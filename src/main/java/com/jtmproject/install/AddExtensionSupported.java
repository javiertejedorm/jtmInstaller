package com.jtmproject.install;

import java.io.IOException;

import com.jtmproject.actions.RegistryUtils;
import com.jtmproject.actions.StringUtils;
import com.jtmproject.gui.JLabelProgressInstallation;
import com.jtmproject.task.Program;
import com.jtmproject.user.MessagesUser;

/**
 * This class associates a extensions with the program
 * @author Javier Tejedor
 */
public class AddExtensionSupported {

	/**
	 * this adds the extensions
	 * @param program
	 */
	public void addExtensions(Program program){
		int size = program.getListTagExtensionsSupported().size();
		String extension = "";
		addProgramClassesRoot(program);
		
		for(int i = 0; i < size; i++){
			try {
				extension = program.getListTagExtensionsSupported().get(i).getExtension();
				
				JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getAssociatingExtension() + " " + extension);
				
				RegistryUtils.writeKeyValueHKEY_CLASSES_ROOT("", extension);
				RegistryUtils.writeStringValueHKEY_CLASSES_ROOT(extension, "", program.getTagProject().getName(), true);
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * this add the program into \HKEY_CLASSES_ROOT\
	 */
	private void addProgramClassesRoot(Program program){
		try {
			String pathInstallProgram = PathInstallProgram.getRootPathInstallProgram(program);
			
			RegistryUtils.writeKeyValueHKEY_CLASSES_ROOT("", program.getTagProject().getName());
			RegistryUtils.writeKeyValueHKEY_CLASSES_ROOT(program.getTagProject().getName() + "\\", "DefaultIcon");
			RegistryUtils.writeStringValueHKEY_CLASSES_ROOT(program.getTagProject().getName() + "\\" + "DefaultIcon", "", pathInstallProgram + program.getTagProject().getExecutableFile(), true);
			RegistryUtils.writeKeyValueHKEY_CLASSES_ROOT(program.getTagProject().getName() + "\\", "shell");
			RegistryUtils.writeKeyValueHKEY_CLASSES_ROOT(program.getTagProject().getName() + "\\shell\\", "open");
			RegistryUtils.writeKeyValueHKEY_CLASSES_ROOT(program.getTagProject().getName() + "\\shell\\open\\", "command");
			RegistryUtils.writeStringValueHKEY_CLASSES_ROOT(program.getTagProject().getName() + "\\shell\\open\\" + "command", "", StringUtils.correctPathForCreateShorcutProgram(pathInstallProgram + program.getTagProject().getExecutableFile()) + " %1", true);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
