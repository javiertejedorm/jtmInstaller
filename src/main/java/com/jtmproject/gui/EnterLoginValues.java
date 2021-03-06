package com.jtmproject.gui;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jtmproject.actions.Checks;
import com.jtmproject.server.LoginUserToServer;
import com.jtmproject.support.JTextFieldLimit;
import com.jtmproject.user.MessagesUser;

/**
 * This class shows a dialog for introducing the user and the password
 * @author Javier Tejedor
 */
public class EnterLoginValues extends JDialog implements ActionListener{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1028919242541374505L;
	
	private static final int WINDOW_HEIGHT = 203;
	private static final int WINDOW_WIDTH = 310;

	private JButton jbtAccept;
	private JButton jbtCancel;
	private JTextField jtfUser;
	private JPasswordField  jpfPassword;

	private String user = "";
	private String password = "";
	private JFrame jFrame;
	private boolean loginCorrect;

	/**
	 * constructor
	 * @param jFrame
	 */
	public EnterLoginValues(JFrame jFrame){
		super(jFrame, true);
		this.jFrame = jFrame;
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setTitle(MessagesUser.getMU().getLogin());
		this.setLayout(null);
		this.addComponentsToWindow();
		LaunchWindowsCentered.launchCentered(this);
		this.setResizable(false);
		this.setVisible(true);
	}
	

	/**
	 * this adds the components of the window.
	 */
	private void addComponentsToWindow(){
		addLabels();
		addJTextFields();
		addButtons();
	}

	/**
	 * this adds the labels
	 */
	private void addLabels(){
		JLabel jlbUser = new JLabel(MessagesUser.getMU().getUser());
		jlbUser = setConfigurationJLabel(jlbUser, 10, 10);
		this.add(jlbUser);

		JLabel jlbPassword = new JLabel(MessagesUser.getMU().getPassword());
		jlbPassword = setConfigurationJLabel(jlbPassword, 10, 70);
		this.add(jlbPassword);
	}

	/**
	 * this function configures label features
	 * @param jlabel
	 * @param positionX
	 * @param positionY
	 * @return
	 */
	private JLabel setConfigurationJLabel(JLabel jlabel, int positionX, int positionY){
		jlabel.setSize(400, 20);
		jlabel.setLocation(positionX, positionY);
		return jlabel;
	}

	/**
	 * this adds the JTextFields
	 */
	private void addJTextFields(){
		jtfUser = new JTextField();
		jtfUser.setDocument(new JTextFieldLimit());
		jtfUser = setJTextFieldConfiguration(jtfUser, 30);
		jtfUser.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jbtAccept.doClick();
				}
			}
		});

		this.add(jtfUser);

		jpfPassword = new JPasswordField ();
		jpfPassword.setDocument(new JTextFieldLimit());
		jpfPassword = setJPasswordFieldConfiguration(jpfPassword, 90);
		jpfPassword.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jbtAccept.doClick();
				}
			}
		});
		this.add(jpfPassword);
	}

	/**
	 * this sets the configuration of JTextFiels
	 * @param jTextField
	 * @param locationY
	 * @return
	 */
	private JTextField setJTextFieldConfiguration(JTextField jTextField, int locationY){
		jTextField.setSize(280, 25);
		jTextField.setLocation(10, locationY);
		return jTextField;
	}
	
	/**
	 * this sets the configuration of JTextFiels
	 * @param jPasswordField
	 * @param locationY
	 * @return
	 */
	private JPasswordField setJPasswordFieldConfiguration(JPasswordField jPasswordField, int locationY){
		jPasswordField.setSize(280, 25);
		jPasswordField.setLocation(10, locationY);
		return jPasswordField;
	}

	/**
	 * this adds the buttons
	 */
	private void addButtons(){
		jbtAccept = new JButton(MessagesUser.getMU().getAccept());
		jbtAccept = setConfigurationJButton(jbtAccept, 120);
		this.add(jbtAccept);

		jbtCancel = new JButton(MessagesUser.getMU().getCancel());
		jbtCancel = setConfigurationJButton(jbtCancel, 210);
		this.add(jbtCancel);
	}

	/**
	 * this method configures the buttons
	 * @param jButton
	 * @param positionX
	 * @param positionY
	 * @return
	 */
	private JButton setConfigurationJButton(JButton jButton, int positionX){
		jButton.setSize(80, 30);
		jButton.setLocation(positionX, 130);
		jButton.addActionListener(this);
		jButton.setMargin(new Insets(0, 0, 0, 0));
		return jButton;
	}


	/**
	 * returns the user
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * returns the password
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * returns if the login is correct
	 * @return
	 */
	public boolean isLoginCorrect() {
		return loginCorrect;
	}

	/**
	 * closes the window 
	 */
	private void exit(){
		setVisible(false);
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtAccept){	
			if(Checks.isConnectServerPossible()){
				user = jtfUser.getText().replace(" ", "");
				//here we can modify the password if we can't to have the password in memory
				password = String.valueOf(jpfPassword.getPassword()).replace(" ", "");
				
				new LoginUserToServer(user, password, true);
			}else{
				MessageDialog.messageDialogError(jFrame, MessagesUser.getMU().getInvalidServer());
			}
			
		}else if(e.getSource() == jbtCancel){
			user = "";
			password = "";
		}
		
		exit();
	}
}
