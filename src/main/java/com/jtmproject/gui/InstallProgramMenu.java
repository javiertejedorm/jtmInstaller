package com.jtmproject.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.jtmproject.user.MessagesUser;

/**
 * You can read the copyright and select the type of install.
 * @author Javier Tejedor
 */
public class InstallProgramMenu extends JDialog implements ActionListener{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4782365890200499906L;
	
	private static final int WINDOW_HEIGHT = 570;
	private static final int WINDOW_WIDTH = 700;

	private boolean oneClickInstall = false;
	private boolean normalInstall = false;
	private boolean scanAvSelected = false;
	private boolean install = false;
	private boolean settings = false;
	private String name;
	private String textCopyright;

	private JPanel jplGeneralPanel;
	private JButton jbtOneClickInstall;
	private JButton jbtNormalInstall;
	private JCheckBox jcbAv;

	/**
	 * constructor
	 * @param jFrame
	 * @param name
	 */
	public InstallProgramMenu(JFrame jFrame, String name, String textCopyright, boolean settings){
		super(jFrame, true);
		this.name = name;
		this.textCopyright = textCopyright;
		this.setSize(478, 492);
		this.setTitle(MessagesUser.getMU().getInstall());
		this.settings = settings;
		this.addComponentsToWindow();
		launchWindowCentered();
		this.setResizable(false);
		this.setVisible(true);

	}

	/**
	 * lunches the JDialog centered into the screen
	 */
	private void launchWindowCentered(){
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - this.getWidth()) / 2;
		final int y = (screenSize.height - this.getHeight()) / 2;
		this.setLocation(x, y);
	}

	/**
	 * adds the components to the view
	 */
	private void addComponentsToWindow(){
		addJPanel();
		addJTextPane();
		addLabel();
		addButtons();
		addCheckBox();
		this.add(jplGeneralPanel);
	}

	/**
	 * add the general JPanel
	 */
	private void addJPanel(){
		jplGeneralPanel = new JPanel();
		jplGeneralPanel.setLayout(null);
		jplGeneralPanel.setLocation(0, 0);
		jplGeneralPanel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	/**
	 * adds a JTextArea with the copyright
	 */
	private void addJTextPane(){
		JTextPane jtPCopyright = new JTextPane();
		jtPCopyright.setEditable(false);
		jtPCopyright.setText(textCopyright);

		final JScrollPane jspCopyScroll = new JScrollPane();
		jspCopyScroll.setSize(450, 300);
		jspCopyScroll.setLocation(10, 50);

		jspCopyScroll.getViewport().setBackground(Color.WHITE);
		jspCopyScroll.setViewportView(jtPCopyright);
		jspCopyScroll.setAutoscrolls(true);


		StyledDocument doc = jtPCopyright.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		jtPCopyright.setText(textCopyright);

		//setting the scroll to the top
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() { 
				jspCopyScroll.getVerticalScrollBar().setValue(0);
			}
		});

		jplGeneralPanel.add(jspCopyScroll);
	}

	/**
	 * adds the labels
	 */
	private void addLabel(){
		JLabel jlbName = new JLabel(name);
		jlbName = setConfigurationJLabel(jlbName, 10, 15, 20);
		jplGeneralPanel.add(jlbName);
	}

	/**
	 * this function configures label features
	 * @param jlabel
	 * @param sizeX
	 * @param sizeY
	 * @param positionX
	 * @param positionY
	 * @return
	 */
	private JLabel setConfigurationJLabel(JLabel jlabel, int positionX, int positionY, int textSize){
		jlabel.setSize(500, 20);
		jlabel.setLocation(positionX, positionY);
		jlabel.setFont(new Font("arial", Font.PLAIN, textSize));
		return jlabel;
	}

	/**
	 * adds the buttons
	 */
	private void addButtons(){
		jbtOneClickInstall = new JButton("<html>" + MessagesUser.getMU().getOneClickInstall() + "</html>");
		jbtOneClickInstall = setConfigurationJButton(jbtOneClickInstall, 110, 40, 10, 395);
		jplGeneralPanel.add(jbtOneClickInstall);

		if(settings){
			jbtNormalInstall = new JButton(MessagesUser.getMU().getNormalInstall());
			jbtNormalInstall = setConfigurationJButton(jbtNormalInstall, 110, 40, 135, 395);
			jplGeneralPanel.add(jbtNormalInstall);	
		}
	}

	/**
	 * this method configures the buttons
	 * @param jButton
	 * @param sizeX
	 * @param sizeY
	 * @param positionX
	 * @param positionY
	 * @return
	 */
	private JButton setConfigurationJButton(JButton jButton, int sizeX, int sizeY, int positionX, int positionY){
		jButton.setSize(sizeX, sizeY);
		jButton.setLocation(positionX, positionY);
		jButton.addActionListener(this);
		jButton.setMargin(new Insets(0, 0, 0, 0));
		return jButton;
	}

	/**
	 * adds a checkbox
	 */
	private void addCheckBox(){
		jcbAv = new JCheckBox(MessagesUser.getMU().getScanAv());
		jcbAv.setSize(500, 20);
		jcbAv.setLocation(10, 362);
		jplGeneralPanel.add(jcbAv);
	}

	/**
	 * returns if will be a oneClick install
	 * @return
	 */
	public boolean isOneClickInstall() {
		return oneClickInstall;
	}

	/**
	 * returns if will be a normal install
	 * @return
	 */
	public boolean isNormalInstall() {
		return normalInstall;
	}

	/**
	 * returns if the user want to install the program
	 * @return
	 */
	public boolean isInstall() {
		return install;
	}

	/**
	 * returns if will be analyzed by antivirus.
	 * @return
	 */
	public boolean isScanAvSelected() {
		return scanAvSelected;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtOneClickInstall){
			oneClickInstall = true;
			normalInstall = false;
			install = true;
			scanAvSelected = jcbAv.isSelected();
			closeWindow();
		}else if(e.getSource() == jbtNormalInstall){
			oneClickInstall = false;
			normalInstall = true;
			install = true;
			scanAvSelected = jcbAv.isSelected();
			closeWindow();
		}		
	}

	/**
	 * closes the dialog
	 */
	private void closeWindow(){
		setVisible(false);
		dispose();
	}
}
