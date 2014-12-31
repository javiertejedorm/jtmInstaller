package com.jtmproject.actions;

import com.jtmproject.install.InstallerCenter;
import com.jtmproject.server.LoginUser;
import com.jtmproject.user.SettingsUser;
import com.jtmproject.user.UserProperties;

/**
 * This class controls the windows main exit
 * @author Javier Tejedor
 */
public class ControlProgramClose {

	/**
	 * constructor
	 */
	public ControlProgramClose() {
		controlInstalling();
		controlKeepSessionUser();
	}
	
	/**
	 * this controls if the user is downloading a file
	 */
	private void controlInstalling() {
		if(InstallerCenter.getControlAnInstall() != null){
			InstallerCenter.getControlAnInstall().cancelInstall();
		}
		
		if(InstallerCenter.getControlSeveralInstallations() != null){
			InstallerCenter.getControlSeveralInstallations().cancelInstall();
		}
	}
	
	/**
	 * this controls if the user want to keep his session when the programs is closed.
	 */
	private void controlKeepSessionUser(){
		if(!SettingsUser.isKeepSessionExit()){
			LoginUser.getLu().login("", "", false);
			UserProperties.getUp().writeProperties();
		}
	}
}
