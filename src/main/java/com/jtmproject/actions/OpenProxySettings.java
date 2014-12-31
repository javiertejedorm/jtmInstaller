package com.jtmproject.actions;

import java.io.IOException;

/**
 * this class opens the settings of the Windows's proxy.  
 * @author Javier Tejedor
 * @thanks Mikel Castillo for the idea.
 */
public class OpenProxySettings {

	/**
	 * constructor
	 */
	public OpenProxySettings(){
		openWindowsProxySettings();
	}
	
	/**
	 * this method opens the settings of the Windows's proxy in Control Panel
	 */
	private void openWindowsProxySettings() {
		
		ProcessBuilder pb = new ProcessBuilder("RUNDLL32.EXE" , "Shell32.dll", "Control_RunDLL",  "InetCpl.cpl",  "@0,4");
		pb.redirectErrorStream(true);

		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
