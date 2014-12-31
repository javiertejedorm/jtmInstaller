package com.jtmproject.gui;

import javax.swing.JLabel;

/**
 * this class has a static jLabel. All the classes can modify it. This jlabel shows the progress of the installation.
 * @author Javier Tejedor
 */
public class JLabelProgressInstallation extends JLabel{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7211544855217399548L;
	
	private static JLabelProgressInstallation jlbProgressInstallation;
	
	/**
	 * this class returns a static instance of the class.
	 * @return
	 */
	public static JLabelProgressInstallation getJlbPI() {
		if(jlbProgressInstallation == null){
			jlbProgressInstallation = new JLabelProgressInstallation();
			jlbProgressInstallation.setSize(350, 20);
			jlbProgressInstallation.setLocation(15, 425);
		}
		return jlbProgressInstallation;
	}
}
