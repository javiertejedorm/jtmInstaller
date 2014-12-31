package com.jtmproject.gui;

import javax.swing.JButton;

import com.jtmproject.user.MessagesUser;

/**
 * This class exends a static JButton for being modified by all the classes
 * @author Javier Tejedor
 */
public class ButtonInstall extends JButton{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8919468715403308016L;
	
	public static JButton jButton;
	public static boolean installing;
	public static final int STATE_CAN_CANCEL = 0;
	public static final int STATE_CAN_INSTALL = 1;
	public static final int STATE_DISABLE = 2;
	
	
	/**
	 * returns a static JButton
	 * @return
	 */
	public static JButton getjButton() {
		if(jButton == null){
			installing = false;
			jButton = new JButton();
		}
		return jButton;
	}
	
	/**
	 * sets the type of button that we needed
	 * @param search
	 */
	public static void setStateButton(int state){
		switch (state) {
		case STATE_CAN_CANCEL:
			jButton.setEnabled(true);
			jButton.setText(MessagesUser.getMU().getCancel());
			installing = true;
			break;
			
		case STATE_CAN_INSTALL:
			jButton.setEnabled(true);
			jButton.setText(MessagesUser.getMU().getInstall());
			installing = false;
			break;
			
		case STATE_DISABLE:
			jButton.setText(MessagesUser.getMU().getCancel());
			jButton.setEnabled(false);
			installing = true;
			break;
		default:
			break;
		}
	}
	
	/**
	 * returns if the button is configured like search or cancel
	 * @return
	 */
	public static boolean isInstallig() {
		return installing;
	}
}
