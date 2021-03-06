package com.jtmproject.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * this class contains methods for launching the window in the middle of the screen
 * @author Javier Tejedor
 */
public class LaunchWindowsCentered {

	/**
	 * lunches the Window centered into the screen
	 */
	public static void launchCentered(JFrame jFrame){
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - jFrame.getWidth()) / 2;
		final int y = (screenSize.height - jFrame.getHeight()) / 2;
		jFrame.setLocation(x, y);
	}
	
	/**
	 * lunches the Window centered into the screen
	 */
	public static void launchCentered(JDialog jDialog){
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - jDialog.getWidth()) / 2;
		final int y = (screenSize.height - jDialog.getHeight()) / 2;
		jDialog.setLocation(x, y);
	}
}
