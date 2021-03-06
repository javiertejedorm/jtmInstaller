package com.jtmproject.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jtmproject.actions.ModifyInstallByUser;
import com.jtmproject.install.HKEYForInstall;
import com.jtmproject.task.Program;
import com.jtmproject.user.MessagesUser;

/**
 * This class launch a JDialog with the manual install 
 * @author Javier Tejedor
 */
public class StartInstall extends JDialog implements ActionListener{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7143380406110939528L;
	private JPanel jplGeneral;
	private JFrame jFrame;
	private JButton jbtNext;
	private JButton jbtPrevious;
	private JButton jbtAlreadyInstall;

	private ArrayList<IViewGeneral> listOfMenu;
	private MenuSettingsIntallGUI menuSettingsGUI;
	private Program program;
	private int indexProgram = 0;

	private int indexListOfMenu = 0;
	private boolean install = false;
	private boolean navigateToSettings = false;

	/**
	 * constructor
	 * @param jFrame
	 * @param program
	 */
	public StartInstall(JFrame jFrame, Program program, int indexProgram){
		super(jFrame, program.getTagProject().getName(), true);
		this.setSize(SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN, SizesGUI.WINDOW_HEIGHT_INSTALL_SCREEN);
		
		this.jFrame = jFrame;
		install = false;
		this.indexProgram = indexProgram;
		this.program = program;

		listOfMenu = new ArrayList<IViewGeneral>();

		initializeAllMenus();

		chargeJPanel();

		this.addComponentsToPrincipalWindow();
		LaunchWindowsCentered.launchCentered(this);
		
		changeToInstallButton();
		
		this.add((JPanel)listOfMenu.get(indexListOfMenu));
		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 * this method charge a JPanel
	 */
	private void chargeJPanel(){
		if(isStringVoid(program.getTagMessages().getWelcome())){
			indexListOfMenu++;
			listOfMenu.get(indexListOfMenu).chargeView();
		}else{
			listOfMenu.get(indexListOfMenu).chargeView();
		}
	}

	/**
	 * returns if the String is void
	 * @param str
	 * @return
	 */
	private boolean isStringVoid(String str){
		return str.replace(" ", "").equals("");
	}


	/**
	 * This method  adds all sub-menus to main window.
	 */
	private void initializeAllMenus(){
		listOfMenu.clear();
		listOfMenu.add(new MenuWelcomeGUI(jFrame, program));
		
		menuSettingsGUI = new MenuSettingsIntallGUI(program);
		listOfMenu.add(menuSettingsGUI);
	}

	/**
	 * add all components to main window
	 */
	private void addComponentsToPrincipalWindow(){
		jplGeneral = new JPanel();
		jplGeneral.setOpaque(true);
		jplGeneral.setLayout(null);
		jplGeneral.add(addBottomButtons());

		this.setContentPane(jplGeneral);
		this.setLocationByPlatform(true);
	}

	/**
	 * this method adds tree buttons
	 * @return
	 */
	private JPanel addBottomButtons(){
		JPanel jplContentBottomButtons = new JPanel();

		jplContentBottomButtons = setConfigurationJPanel(jplContentBottomButtons, SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN, 90, 0, SizesGUI.WINDOW_HEIGHT_INSTALL_SCREEN - 90);
		
		jbtNext = new JButton(MessagesUser.getMU().getNext());
		jbtNext = setConfigurationButton(jbtNext, 90, 35, SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN - 105, 14);
		jplContentBottomButtons.add(jbtNext);

		jbtPrevious = new JButton(MessagesUser.getMU().getPrevious());
		jbtPrevious = setConfigurationButton(jbtPrevious, 90, 35, SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN - 205, 14);
		jplContentBottomButtons.add(jbtPrevious);

		jbtAlreadyInstall = new JButton("<html>" + MessagesUser.getMU().getOneClickInstall() + "</html>");
		
		jbtAlreadyInstall = setConfigurationButton(jbtAlreadyInstall, 100, 40, 8, 11);	
		jplContentBottomButtons.add(jbtAlreadyInstall);

		return jplContentBottomButtons;
	}

	/**
	 * This function sets configuration to JButton
	 * @param jbutton
	 * @param locationX
	 * @param locationY
	 * @return
	 */
	private JButton setConfigurationButton(JButton jbutton, int sizeX, int sizeY,  int locationX, int locationY){
		jbutton.setSize(sizeX, sizeY);
		jbutton.setLocation(locationX, locationY);
		jbutton.addActionListener(this);
		return jbutton;
	}

	/**
	 * this function sets configuration to JPanel
	 * @param jPanel
	 * @param sizeX
	 * @param sizeY
	 * @param locationX
	 * @param locationY
	 * @return
	 */
	private JPanel setConfigurationJPanel(JPanel jPanel, int sizeX, int sizeY, int locationX, int locationY){
		jPanel.setLayout(null);
		jPanel.setOpaque(true);
		jPanel.setBackground(Color.gray);
		jPanel.setLayout(null);
		jPanel.setSize(sizeX, sizeY);
		jPanel.setLocation(locationX, locationY);
		return jPanel;
	}

	/**
	 * remove current jpanel of main JPanel
	 */
	private void removeCurrentComponent(){
		jplGeneral.remove((JPanel)listOfMenu.get(indexListOfMenu));
		jplGeneral.revalidate();
		this.repaint();
	}
	
	/**
	 * this method changes the text of the button Next
	 */
	private void changeToInstallButton(){
		boolean firstScreen = indexListOfMenu == 0;
		
		if(firstScreen){
			jbtNext.setText(MessagesUser.getMU().getNext());
		}else{
			jbtNext.setText(MessagesUser.getMU().getInstall());
		}
		
		jbtPrevious.setEnabled(!firstScreen);
		jbtAlreadyInstall.setVisible(firstScreen);
	}

	/**
	 * go to the next screen
	 */
	private void nextScreen(){
		if(indexListOfMenu < listOfMenu.size() - 1){
			navigateToSettings = true;
			removeCurrentComponent();
			listOfMenu.get(indexListOfMenu).saveData();
			listOfMenu.get(indexListOfMenu).removeElements();
			indexListOfMenu++;
			jplGeneral.add((JPanel)listOfMenu.get(indexListOfMenu));
			listOfMenu.get(indexListOfMenu).chargeView();
			this.repaint();
		}
	}
	
	/**
	 * go to the previous screen
	 */
	private void previousScreen(){
		if(indexListOfMenu > 0){
			removeCurrentComponent();
			listOfMenu.get(indexListOfMenu).saveData();
			listOfMenu.get(indexListOfMenu).removeElements();
			indexListOfMenu--;
			jplGeneral.add((JPanel)listOfMenu.get(indexListOfMenu));
			listOfMenu.get(indexListOfMenu).chargeView();
			this.repaint();
		}
		
	}

	/**
	 * is called when the user press Install button
	 */
	private void install(){
		listOfMenu.get(indexListOfMenu).saveData();
		
		if(navigateToSettings){
			new ModifyInstallByUser(program, indexProgram, menuSettingsGUI.getNewPathToInstall(), menuSettingsGUI.isAddShortcutDesktop(), menuSettingsGUI.isAddStartMenu(), menuSettingsGUI.getHKEYSelected(), menuSettingsGUI.getExtensionsSelected());
		}else{
			HKEYForInstall.setCurrentHKEY(HKEYForInstall.HKEY_LOCAL_MACHINE);
		}
		
		install = true;
		closeWindow();
	}
	
	/**
	 * closes the dialog
	 */
	private void closeWindow(){
		setVisible(false);
		dispose();
	}
	
	/**
	 * returns if the user wants to install or not
	 * @return
	 */
	public boolean isInstall() {
		return install;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtNext){
			if(indexListOfMenu == 0){
				nextScreen();
			}else{
				install();
			}
		}else if(e.getSource() == jbtPrevious){
			previousScreen();
		}else if(e.getSource() == jbtAlreadyInstall){
			install();
		}
		
		changeToInstallButton();
	}
}
