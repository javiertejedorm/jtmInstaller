package com.jtmproject.gui;

import javax.swing.JButton;

import com.jtmproject.user.MessagesUser;

/**
 * This class exends a static JButton for being modified by all the classes. The button is the search button
 * @author Javier Tejedor
 */
public class ButtonSearch extends JButton{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4634127265084236753L;
	
	public static JButton jButton;
	public static boolean searching;
	public static final int STATE_CAN_CANCEL = 0;
	public static final int STATE_CAN_SEARCH = 1;
	public static final int STATE_DISABLE = 2;

	/**
	 * returns a static JButton
	 * @return
	 */
	public static JButton getjButton() {
		if(jButton == null){
			searching = false;
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
			searching = true;
			break;
			
		case STATE_CAN_SEARCH:
			jButton.setEnabled(true);
			jButton.setText(MessagesUser.getMU().getSearch());
			searching = false;
			break;
			
		case STATE_DISABLE:
			jButton.setText(MessagesUser.getMU().getCancel());
			jButton.setEnabled(false);
			searching = true;
			break;
		default:
			break;
		}
	}

	
	/**
	 * returns if the button is configured like search or cancel
	 * @return
	 */
	public static boolean isSearching() {
		return searching;
	}
}
