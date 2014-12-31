package com.jtmproject.install;

/**
 * This class sets which is the current HKEY for install the app
 * @author Javier Tejedor
 */
public class HKEYForInstall {

	public static final int HKEY_CURRENT_USER = 0x80000001;
	public static final int HKEY_LOCAL_MACHINE = 0x80000002;

	private static int currentHKEY;

	/**
	 * returns the current HKEY
	 * @return
	 */
	public static int getCurrentHKEY() {
		return currentHKEY;
	}

	/**
	 * sets the current HKEY
	 * @param currentHKEY
	 */
	public static void setCurrentHKEY(int currentHKEY) {
		HKEYForInstall.currentHKEY = currentHKEY;
	}
}
