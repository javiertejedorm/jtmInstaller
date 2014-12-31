package com.jtmproject.install;

import java.lang.reflect.InvocationTargetException;

import com.jtmproject.actions.RegistryUtils;
import com.jtmproject.gui.JLabelProgressInstallation;
import com.jtmproject.task.Program;
import com.jtmproject.user.MessagesUser;

/**
 * this class adds the program to the Windows Startup
 * @author Javier Tejedor
 */
public class AddWindowsStartup {

	/**
	 * add the program to the Windows Startup
	 * @param program
	 * @return
	 */
	public boolean addStartup(Program program){
		String name = program.getTagAddStartup().getName();
		String file = PathInstallProgram.getRootPathInstallProgram(program) + program.getTagAddStartup().getFile();
		file = file.replace("\\\\", "\\");
		
		JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getAddingWindowsStartup() + " " + file);
		
		try {
			RegistryUtils.writeStringValue(HKEYForInstall.getCurrentHKEY(), "Software\\Microsoft\\Windows\\CurrentVersion\\Run", name, file);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return false;
	}
}
