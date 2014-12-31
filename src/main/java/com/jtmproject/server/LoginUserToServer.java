package com.jtmproject.server;

import com.jtmproject.actions.Checks;
import com.jtmproject.gui.EnterLoginValues;
import com.jtmproject.gui.JLabelLogin;
import com.jtmproject.gui.MainWindowJFrame;
import com.jtmproject.gui.MessageDialog;
import com.jtmproject.user.MessagesUser;
import com.jtmproject.user.UserProperties;

/**
 * This class checks if the user must be logged or not
 * @author Javier Tejedor
 */
public class LoginUserToServer extends Thread{
	
	private String user;
	private String password;
	private boolean saveProperties;
	
	/**
	 * constructor
	 * @param user
	 * @param password
	 */
	public LoginUserToServer(String user, String password, boolean saveProperties){
		this.user = user;
		this.password = password;
		this.saveProperties = saveProperties;
		this.start();
	}

	@Override
	public void run() {
		Login checkUserAndPass = new Login(user, password);
		if(Checks.isInternetReachable()){
			JLabelLogin.getjLabel().setText(MessagesUser.getMU().getLoggingStart());
			if(checkUserAndPass.isLoginCorrect()){
				JLabelLogin.getjLabel().setText(MessagesUser.getMU().getWelcome() + " " + user);
				LoginUser.getLu().login(user, password, true);
				
				if(saveProperties){
					UserProperties.getUp().writeProperties();
				}
			}else{
				MessageDialog.messageDialogError(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getLoginError());
				LoginUser.getLu().logout();
				new EnterLoginValues(MainWindowJFrame.getjFrame());
			}
		}
	}
}

