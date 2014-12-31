package com.jtmproject.gui;

import javax.swing.JTextField;

/**
 * this class returns a static JTextField for manipulating since all classes
 * @author Javier Tejedor
 */
public class JTextFieldSearch extends JTextField{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3514594434120347439L;
	
	private static JTextField jtf;
	
	/**
	 * returna a static JTextField
	 * @return
	 */
	public static JTextField getJtf(){
		if(jtf == null){
			jtf = new JTextField("", JTextField.CENTER);
		}
		
		return jtf;
	}
}
