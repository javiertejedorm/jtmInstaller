package com.jtmproject.actions;

import com.jtmproject.gui.MainWindowJFrame;
import com.jtmproject.gui.MessageDialog;
import com.jtmproject.user.MessagesUser;
import com.jtmproject.user.SettingsUser;

/**
 * this class controls the error while the jtm is opening
 * @author Javier Tejedor
 */
public class ErrorOpenJtm {

	/**
	 * constructor
	 */
	public ErrorOpenJtm(){
		checkErrorOpen();
	}

	/**
	 * this method checks and controls errors while the jtm is opening
	 */
	private void checkErrorOpen() {
		if(SettingsUser.isCheckNewVersionIfFailToOpenJtmFile()){
			MessageDialog.messageDialogError(MainWindowJFrame.getjFrame(), "No hemos podido abrir el .jtm, vamos a comprobar si tiene la última versión de jtmInstaller");
			new CheckNewVersion(true);
		}else{
			MessageDialog.messageDialogError(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getErrorOpenFile());
		}
	}
	
}
