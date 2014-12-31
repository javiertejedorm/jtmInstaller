package com.jtmproject.gui;

import java.awt.Dimension;

import javax.swing.JLabel;

/**
 * this class shared a JLabel for all the classes
 * @author Javier Tejedor
 */
public class JLabelLogin extends JLabel{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9144829446048224248L;
	
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
	
	/**
	 * sets the dimension of the jLabel
	 */
	public static void setDimension(){
		Dimension dim = jLabel.getPreferredSize();
		jLabel.setSize(dim);
	}
}
