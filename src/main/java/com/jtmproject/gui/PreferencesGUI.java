package com.jtmproject.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jtmproject.user.MessagesUser;
import com.jtmproject.user.SettingsUser;
import com.jtmproject.user.UserProperties;

/**
 * this class is the window for managing the settings
 * @author Javier Tejedor
 */
public class PreferencesGUI extends JDialog implements ActionListener{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5832221668138920776L;
	
	private JPanel jplGeneral;
	private JCheckBox jcbCleanTemporalFolder;
	private JCheckBox jcbRemoveJtmAfterInstall;
	private JCheckBox jcbShowCertificateInformation;
	private JCheckBox jcbKeepSessionUserAfterExit;
	private JCheckBox jcbAskForUpdates;
	private JCheckBox jcbCheckNewVersionWhenOpenFail;
	private JButton jbtAccept;
	private JButton jbtCancel;

	/**
	 * constructor
	 * @param jFrame
	 */
	public PreferencesGUI(JFrame jFrame){
		super(jFrame, true);
		this.setTitle(MessagesUser.getMU().getPreferences());
		this.setSize(400, 270);

		this.addComponentsToPrincipalWindow();
		
		setJCheckBoxes();
		
		LaunchWindowsCentered.launchCentered(this);
		this.setResizable(false);
		this.setVisible(true);
		
		
	}

	/**
	 * this adds the principal components to the window
	 */
	private void addComponentsToPrincipalWindow(){
		addGeneralPanel();
		
		addUserPanel();
		addSecurityPanel();
		
		addButtons();
	}

	/**
	 * this adds the general panel
	 */
	private void addGeneralPanel(){
		jplGeneral = new JPanel();
		jplGeneral.setOpaque(true);
		jplGeneral.setLayout(null);

		this.setContentPane(jplGeneral);
		this.setLocationByPlatform(true);
	}

	/**
	 * this adds the User panel
	 */
	private void addUserPanel(){
		JPanel jplUser = new JPanel();
		jplUser.setLayout(null);
		jplUser.setSize(392, 108);
		jplUser.setLocation(0, 5);
		jplUser.setBorder(BorderFactory.createTitledBorder(MessagesUser.getMU().getUser()));
		addJCheckBoxUser(jplUser);
		jplGeneral.add(jplUser);
	}

	/**
	 * this adds the Security panel 
	 */
	private void addSecurityPanel(){
		JPanel jplSecurity = new JPanel();
		jplSecurity.setLayout(null);
		jplSecurity.setSize(392, 68);
		jplSecurity.setLocation(0, 120);
		jplSecurity.setBorder(BorderFactory.createTitledBorder(MessagesUser.getMU().getSecurity()));
		addJCheckBoxSecurity(jplSecurity);
		jplGeneral.add(jplSecurity);
	}

	/**
	 * this add the components to jPanel of Clean
	 * @param jpl
	 */
	private void addJCheckBoxUser(JPanel jpl){
		jcbCleanTemporalFolder = new JCheckBox(MessagesUser.getMU().getCleanTemporalFolder());
		jcbCleanTemporalFolder = jcbConfiguration(jcbCleanTemporalFolder, 5, 20);
		jpl.add(jcbCleanTemporalFolder);

		jcbRemoveJtmAfterInstall = new JCheckBox(MessagesUser.getMU().getRemoveJtmAfterInstall());
		jcbRemoveJtmAfterInstall = jcbConfiguration(jcbRemoveJtmAfterInstall, 5, 40);
		jpl.add(jcbRemoveJtmAfterInstall);
		
		jcbAskForUpdates = new JCheckBox(MessagesUser.getMU().getNotifyNewVersion());
		jcbAskForUpdates = jcbConfiguration(jcbAskForUpdates, 5, 60);
		jpl.add(jcbAskForUpdates);
		
		jcbCheckNewVersionWhenOpenFail = new JCheckBox(MessagesUser.getMU().getCheckNewVersionWhenFailOpen());
		jcbCheckNewVersionWhenOpenFail = jcbConfiguration(jcbCheckNewVersionWhenOpenFail, 5, 80);
		jpl.add(jcbCheckNewVersionWhenOpenFail);
	}

	/**
	 * this add the components to jPanel of Security
	 * @param jpl
	 */
	private void addJCheckBoxSecurity(JPanel jpl){
		jcbShowCertificateInformation = new JCheckBox(MessagesUser.getMU().getShowInformationCertificate());
		jcbShowCertificateInformation = jcbConfiguration(jcbShowCertificateInformation, 5, 20);
		jpl.add(jcbShowCertificateInformation);

		jcbKeepSessionUserAfterExit = new JCheckBox(MessagesUser.getMU().getKeepUserSession());
		jcbKeepSessionUserAfterExit = jcbConfiguration(jcbKeepSessionUserAfterExit, 5, 40);
		jpl.add(jcbKeepSessionUserAfterExit);
	}

	/**
	 * this function configures a JCheckBox
	 * @param jcb
	 * @param locationX
	 * @param locationY
	 * @return
	 */
	private JCheckBox jcbConfiguration(JCheckBox jcb, int locationX, int locationY){
		jcb.setSize(392, 20);
		jcb.setLocation(locationX, locationY);
		return jcb;
	}

	/**
	 * this adds the buttons
	 */
	private void addButtons(){
		jbtAccept = new JButton(MessagesUser.getMU().getAccept());
		jbtAccept = setConfigurationJButton(jbtAccept, 215, 200);
		jplGeneral.add(jbtAccept);

		jbtCancel = new JButton(MessagesUser.getMU().getCancel());
		jbtCancel = setConfigurationJButton(jbtCancel, 305, 200);
		jplGeneral.add(jbtCancel);
	}

	/**
	 * set the configuration for jButton
	 * @param jbt
	 * @param locationX
	 * @param locationY
	 * @return
	 */
	private JButton setConfigurationJButton(JButton jbt, int locationX, int locationY){
		jbt.addActionListener(this);
		jbt.setSize(80, 30);
		jbt.setLocation(locationX, locationY);
		return jbt;
	}
	
	/**
	 * this sets the jcheckboxes with the settings established by the user
	 */
	private void setJCheckBoxes(){
		jcbCleanTemporalFolder.setSelected(SettingsUser.isCleanTemporaryEveryTwoDays());
		jcbKeepSessionUserAfterExit.setSelected(SettingsUser.isKeepSessionExit());
		jcbRemoveJtmAfterInstall.setSelected(SettingsUser.isRemoveJtmAfterInstall());
		jcbShowCertificateInformation.setSelected(SettingsUser.isShowCertificateInformation());
		jcbAskForUpdates.setSelected(SettingsUser.isAskForUpdates());
		jcbCheckNewVersionWhenOpenFail.setSelected(SettingsUser.isCheckNewVersionIfFailToOpenJtmFile());
	}
	
	/**
	 * when button accept is clicked
	 */
	private void clickBtnAccept(){
		saveSettings();
		exit();
	}
	
	/**
	 * this saves the settigs
	 */
	private void saveSettings(){
		SettingsUser.setCleanTemporaryEveryTwoDays(jcbCleanTemporalFolder.isSelected());
		SettingsUser.setRemoveJtmAfterInstall(jcbRemoveJtmAfterInstall.isSelected());
		SettingsUser.setShowCertificateInformation(jcbShowCertificateInformation.isSelected());
		SettingsUser.setKeepSessionExit(jcbKeepSessionUserAfterExit.isSelected());
		SettingsUser.setAskForUpdates(jcbAskForUpdates.isSelected());
		SettingsUser.setCheckNewVersionIfFailToOpenJtmFile(jcbCheckNewVersionWhenOpenFail.isSelected());
		UserProperties.getUp().writeProperties();
	}
	
	/**
	 * when button cancel is clicked
	 */
	private void clickBtnCancel(){
		 exit();
	}

	/**
	 * close the window
	 */
	private void exit(){
		setVisible(false);
		dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtAccept){
			clickBtnAccept();
		}

		if(e.getSource() == jbtCancel){
			clickBtnCancel();
		}
	}
}
