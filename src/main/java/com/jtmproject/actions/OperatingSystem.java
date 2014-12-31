package com.jtmproject.actions;

/**
 * This class consult the name of the Operating System and his architecture.
 * @author Javier Tejedor
 */
public class OperatingSystem {

	/**
	 * returns the model of the Operating System
	 * @return
	 */
	public static String getOS(){
		return System.getProperty("os.name") + " " + System.getProperty("sun.arch.data.model");
	}
}
