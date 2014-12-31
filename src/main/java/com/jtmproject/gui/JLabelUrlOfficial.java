package com.jtmproject.gui;

import javax.swing.JLabel;

/**
 * this class has been created to store the official url of www.jtmplace.com
 * @author Javier Tejedor
 */
public class JLabelUrlOfficial extends JLabel{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9003127354209696110L;
	
	private static JLabel jLabel;
	
	/**
	 * returns a static JLabel
	 * @return
	 */
	public static JLabel getjLabel(){
		if(jLabel == null){
			jLabel = new JLabel();		
		}
		return jLabel;
	}
	
}
