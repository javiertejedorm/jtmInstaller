package com.jtmproject.install;

import com.jtmproject.actions.ControlAnInstall;
import com.jtmproject.actions.ControlSeveralInstallations;

/**
 * This class stores both instances of ControlAnInstall and ControlSeveralInstallations to control it since any class.
 * @author Javier Tejedor
 */
public class InstallerCenter {

	private static ControlAnInstall controlAnInstall;
	private static ControlSeveralInstallations controlSeveralInstallations;
	
	/**
	 * this returns an install of ControlAnInstall
	 * @return
	 */
	public static ControlAnInstall getControlAnInstall() {
		return controlAnInstall;
	}
	
	/**
	 * this sets an install of ControlAnInstall
	 * @param controlAnInstall
	 */
	public static void setControlAnInstall(ControlAnInstall controlAnInstall) {
		InstallerCenter.controlAnInstall = controlAnInstall;
	}
		
	/**
	 * this returns an install of ControlSeveralInstallations
	 * @return
	 */
	public static ControlSeveralInstallations getControlSeveralInstallations() {
		return controlSeveralInstallations;
	}
	
	/**
	 * this sets an install of ControlSeveralInstallations
	 * @param controlSeveralInstallations
	 */
	public static void setControlSeveralInstallations(
			ControlSeveralInstallations controlSeveralInstallations) {
		InstallerCenter.controlSeveralInstallations = controlSeveralInstallations;
	}
}
