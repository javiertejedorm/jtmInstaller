package com.jtmproject.gui;

import javax.swing.JProgressBar;

/**
 * This class contains a static JPrograssBar for access it since different class
 * @author Javier Tejedor
 */
public class BarInstall extends JProgressBar{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3560757038365604716L;
	
	private static BarInstall barInstall;

	/**
	 * returns an object of this class (Singleton Class)
	 * @return
	 */
	public static BarInstall getBarInstall() {
		if(barInstall == null){
			barInstall = new BarInstall();
		}
		return barInstall;
	}
}
