package com.jtmproject.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.jtmproject.user.MessagesUser;

/**
 * This class shows a list with the public server list
 * @author Javier Tejedor
 */
public class ListPublicServerGUI extends JDialog implements MouseListener, ActionListener{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7382931049842924275L;
	
	private JPanel jplGeneral;
	private JButton jbtConnect;
	private JButton jbtCancel;
	private JList<String> jltList;
	private DefaultListModel<String> defaultList;
	
	private String serverSelected;
	
	/**
	 * constructor
	 * @param jFrame
	 * @param servers
	 */
	public ListPublicServerGUI(JFrame jFrame, List<String> servers){
		super(jFrame, MessagesUser.getMU().getPublicServers(), true);
		this.setSize(SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN - 200, SizesGUI.WINDOW_HEIGHT_INSTALL_SCREEN);
		
		this.addComponentsToPrincipalWindow();
		this.addUrlToList(servers);
		LaunchWindowsCentered.launchCentered(this);
		this.setResizable(false);
		this.setVisible(true);
	}

	/**
	 * this adds the components to the window
	 */
	private void addComponentsToPrincipalWindow(){
		addJPanel();
		addJList();
		addButtons();
	}
	
	/**
	 * add all components to main window
	 */
	private void addJPanel(){
		jplGeneral = new JPanel();
		jplGeneral.setOpaque(true);
		jplGeneral.setLayout(null);

		this.setContentPane(jplGeneral);
		this.setLocationByPlatform(true);
	}
	
	/**
	 * this adds a JList
	 */
	private void addJList(){
		defaultList = new DefaultListModel<String>();
		jltList = new JList<String>(defaultList);
		
		jltList.addMouseListener(this);
		//only selection a single element at the same time.
		jltList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane jScrollPane = new JScrollPane(jltList);
		jScrollPane.setLocation(0, 0);
		jScrollPane.setSize(SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN - 205, SizesGUI.WINDOW_HEIGHT_INSTALL_SCREEN - 80);
		jplGeneral.add(jScrollPane);
	}
	
	/**
	 * this adds the buttons into the window
	 */
	private void addButtons(){
		jbtConnect = new JButton(MessagesUser.getMU().getAccept());
		jbtConnect = setConfigurationJButton(jbtConnect, SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN - 380, SizesGUI.WINDOW_HEIGHT_INSTALL_SCREEN - 70);
		jplGeneral.add(jbtConnect);
		
		jbtCancel = new JButton(MessagesUser.getMU().getCancel());
		jbtCancel = setConfigurationJButton(jbtCancel, SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN - 290, SizesGUI.WINDOW_HEIGHT_INSTALL_SCREEN - 70);
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
	 * this adds all the url to the JList
	 * @param urls
	 */
	private void addUrlToList(List<String> urls){
		int size = urls.size();
		for(int i = 0; i < size; i++){
			defaultList.addElement(urls.get(i));
		}
	}
	
	/**
	 * saves the url of the server selected
	 */
	private void saveUrl(){
		if(jltList.getSelectedIndex() != -1){
			serverSelected = defaultList.get(jltList.getSelectedIndex());
			exit();
		}
	}
	
	/**
	 * close the window
	 */
	private void exit(){
		setVisible(false);
		dispose();
	}

	/**
	 * returns the server selected
	 * @return
	 */
	public String getServerSelected() {
		return serverSelected;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			saveUrl();
		} 
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtConnect){
			saveUrl();
		}else if(e.getSource() == jbtCancel){
			exit();
		}
	}
}
