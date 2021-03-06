package com.jtmproject.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.jtmproject.task.Program;
import com.jtmproject.user.MessagesUser;

/**
 * This class create a JPanel for show the Welcome Message
 * @author Javier Tejedor
 */
public class MenuWelcomeGUI extends JPanel implements IViewGeneral, ActionListener{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6330478725260371162L;

	private Program program;
	
	private JButton jbtCopyright;
	private JFrame jFrame;
	/**
	 * constructor
	 * @param program
	 */
	public MenuWelcomeGUI(JFrame jFrame, Program program){
		this.program = program;
		this.jFrame = jFrame;
	}

	@Override
	public void chargeView() {
		this.setSize(SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN, SizesGUI.WINDOW_HEIGHT_INSTALL_SCREEN - 90);
		this.setLocation(0, 0);
		this.setLayout(null);

		addComponents();
	}
	
	/**
	 * this adds the components
	 */
	private void addComponents(){
		addJLabel();
		addButton();
		addJEditorPane();
	}

	/**
	 * this adds the JLabels
	 */
	private void addJLabel(){
		JLabel jlbWelcome = new JLabel(MessagesUser.getMU().getWelcome());
		jlbWelcome = setConfigurationJLabel(jlbWelcome, 300, 20, 20, 12);
		this.add(jlbWelcome);
	}
	
	/**
	 * this method configures a JLabel
	 * @param jlb
	 * @param sizeX
	 * @param sizeY
	 * @param locationX
	 * @param locationY
	 * @return
	 */
	private JLabel setConfigurationJLabel(JLabel jlb, int sizeX, int sizeY, int locationX, int locationY){
		jlb.setSize(sizeX, sizeY);
		jlb.setLocation(locationX, locationY);
		jlb.setFont(new Font("Arial", Font.PLAIN, 20));
		return jlb;
	}
	
	/**
	 * this adds a JTextArea
	 */
	private void addJEditorPane(){
		JEditorPane jtpWelcome = new JEditorPane("text/html", "<html><div id='div' align='justify'>"  + program.getTagMessages().getWelcome() + "</div></html>");
		jtpWelcome.setEditable(false);
		jtpWelcome.setBorder(new EmptyBorder(5,5, 5, 5));
		jtpWelcome.setCaretPosition(0); 
		
		JScrollPane jspCopyScroll = new JScrollPane(jtpWelcome);
		jspCopyScroll.setSize(SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN - 48, SizesGUI.WINDOW_HEIGHT_INSTALL_SCREEN - 190);
		jspCopyScroll.setLocation(20, 45);
		jspCopyScroll.setAutoscrolls(true);

		this.add(jspCopyScroll);
	}
	
	/**
	 * this method adds a button
	 */
	private void addButton(){
		jbtCopyright = new JButton(MessagesUser.getMU().getCopyright());
		jbtCopyright = setConfigurationButton(jbtCopyright, 100, 20, 355, 371);
		this.add(jbtCopyright);
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
	
	@Override
	public void removeElements() {
		this.removeAll();
	}

	@Override
	public void saveData() {
		
	}

	@Override
	public int errorCode() {
		return 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtCopyright){
			new ShowInformationWindow(jFrame, program.getTagMessages().getCopyright(), MessagesUser.getMU().getCopyright());
		}
	}

}
