package com.jtmproject.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.jtmproject.actions.ControlProgramClose;
import com.jtmproject.actions.Installer;
import com.jtmproject.actions.StringUtils;
import com.jtmproject.server.LoginUser;
import com.jtmproject.support.FileDrop;
import com.jtmproject.support.JTextFieldLimit;
import com.jtmproject.support.WindowsMainActions;
import com.jtmproject.task.ListOfPrograms;
import com.jtmproject.user.Debug;
import com.jtmproject.user.FontDefault;
import com.jtmproject.user.GeneralPaths;
import com.jtmproject.user.MessagesUser;

/**
 * this class generates the window main
 * @author Javier Tejedor
 */
public class WindowMain extends JFrame implements ActionListener, MouseListener, FocusListener{

	private static final long serialVersionUID = 1L;
	

	private static final String POWER_INSTALL_TITLE_WINDOW = "jtmInstaller v0.1 Beta";
	private static final int WINDOW_HEIGHT = 517;
	private static final int WINDOW_WIDTH = 480;

	private JMenuItem jmiOpen;
	private JMenuItem jmiExit;
	private JMenuItem jmiFavorites;
	private JMenuItem jmiLogin;
	private JMenuItem jmiLogout;
	private JMenuItem jmiServerConfiguration;
	private JMenuItem jmiProxyConfiguration;
	private JMenuItem jmiListPublicServers;
	private JMenuItem jmiSettings;
	private JMenuItem jmiHelpContent;
	private JMenuItem jmiAbout;
	
	private JButton jbtInstall;
	private JButton jbtSearch;
	private JButton jbtSelectAll;
	
	private JLabel jlbAccount;
	private JLabel jlbVisitJtmPlace;
	private JScrollPane jspScrollJList;

	private JTextField jtfTextSearch;
	private JPanel contentPane;

	private JListPrograms jlp;
	private JPopupMenu jPopupMenu;

	private JMenuItem itemInstall;
	private JMenuItem itemRemove;
	private JMenuItem itemInfo;
	private JMenuItem itemSave;

	private WindowAdapter windowAdapter;

	private WindowsMainActions wma;

	/**
	 * constructor
	 */
	public WindowMain(String path){
		super(POWER_INSTALL_TITLE_WINDOW);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MainWindowJFrame.setjFrame(this);

		wma = new WindowsMainActions(this);

		this.addComponentsToWindow();
		LaunchWindowsCentered.launchCentered(this);
		this.setResizable(true);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(WINDOW_WIDTH - 140, WINDOW_HEIGHT - 190));
		resizeOnlyHeight();
		if(path != null){
			wma.chargeJTM(path);
			wma.managedInstall(jlp.getAllElementsSelectedJList());
		}

		wma.tryLoginUser();
		
		windowCloseEvent();
		
		this.addWindowListener(windowAdapter);
		
		jspScrollJList.requestFocusInWindow();
		
	}

	/**
	 * this method set a JFrame's feature to do only vertical resizabled  
	 */
	private void resizeOnlyHeight(){
		this.addComponentListener(new ComponentAdapter() {

		    @Override
		    public void componentResized(ComponentEvent e) {
		        resizeAll();
		        super.componentResized(e);
		    }

		});
	}
	
	/**
	 * this captures the event when the window is closing.
	 */
	private void windowCloseEvent(){
		windowAdapter = new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				new ControlProgramClose();
			}
		};
	}
	
	/**
	 * this method adds the components
	 */
	private void addComponentsToWindow(){
		addJPanel();
		addMenuBar();
		addJTextField();
		addJButtons();
		addJList();
		addLabels();
		addJProgressBar();
		addPopupMenu();

		this.setContentPane(contentPane);
		this.setLocationByPlatform(true);
		
	}

	/**
	 * this adds a PopupMenu 
	 */
	private void addPopupMenu(){
		jPopupMenu = new JPopupMenu();

		jPopupMenu.add(itemInstall = new JMenuItem(MessagesUser.getMU().getInstall()));
		itemInstall.addActionListener(this);

		jPopupMenu.add(new JSeparator());

		jPopupMenu.add(itemSave = new JMenuItem(MessagesUser.getMU().getSaveJtm()));
		itemSave.addActionListener(this);

		jPopupMenu.add(itemRemove = new JMenuItem(MessagesUser.getMU().getRemove()));
		itemRemove.addActionListener(this);

		jPopupMenu.add(itemInfo = new JMenuItem(MessagesUser.getMU().getInformationProgram()));
		itemInfo.addActionListener(this);


	}

	/**
	 * this adds a menu bar on the top of the window
	 */
	private void addMenuBar(){
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu(MessagesUser.getMU().getFile());

		jmiOpen = new JMenuItem(MessagesUser.getMU().getOpen());
		jmiOpen.addActionListener(this);
		fileMenu.add(jmiOpen);

		jmiExit = new JMenuItem(MessagesUser.getMU().getExit());
		jmiExit.addActionListener(this);
		fileMenu.add(jmiExit);
		menubar.add(fileMenu);

		JMenu userMenu = new JMenu(MessagesUser.getMU().getUser());
		jmiLogin = new JMenuItem(MessagesUser.getMU().getLogin());
		jmiLogin.addActionListener(this);
		userMenu.add(jmiLogin);

		jmiLogout = new JMenuItem(MessagesUser.getMU().getLogout());
		jmiLogout.addActionListener(this);
		userMenu.add(jmiLogout);

		userMenu.add(new JSeparator());

		jmiFavorites = new JMenuItem(MessagesUser.getMU().getFavorites());
		jmiFavorites.addActionListener(this);
		userMenu.add(jmiFavorites);

		JMenu configurationMenu = new JMenu(MessagesUser.getMU().getConfigurationMenu());
		JMenu server = new JMenu(MessagesUser.getMU().getNetwork());
		configurationMenu.add(server);
		
		jmiServerConfiguration = new JMenuItem(MessagesUser.getMU().getServerConfiguration());
		jmiServerConfiguration.addActionListener(this);
		server.add(jmiServerConfiguration);
		
		jmiListPublicServers = new JMenuItem(MessagesUser.getMU().getPublicServers());
		jmiListPublicServers.addActionListener(this);
		server.add(jmiListPublicServers);
		
		server.add(new JSeparator());
		
		jmiProxyConfiguration = new JMenuItem(MessagesUser.getMU().getProxyConfiguration());
		jmiProxyConfiguration.addActionListener(this);
		server.add(jmiProxyConfiguration);
		
		configurationMenu.add(new JSeparator());
		
		jmiSettings = new JMenuItem(MessagesUser.getMU().getPreferences());
		jmiSettings.addActionListener(this);
		configurationMenu.add(jmiSettings);

		JMenu helpMenu = new JMenu(MessagesUser.getMU().getHelp());
		jmiHelpContent = new JMenuItem(MessagesUser.getMU().getHelpContent());
		jmiHelpContent.addActionListener(this);
		helpMenu.add(jmiHelpContent);
		
		jmiAbout = new JMenuItem(MessagesUser.getMU().getAbout());
		jmiAbout.addActionListener(this);
		helpMenu.add(jmiAbout);
		
		menubar.add(fileMenu);
		menubar.add(userMenu);
		menubar.add(configurationMenu);
		menubar.add(helpMenu);
		this.setJMenuBar(menubar);
	}

	/**
	 * this method adds a JPanel
	 */
	private void addJPanel(){
		contentPane = new JPanel();

		contentPane.setOpaque(true);
		contentPane.setLayout(null);
	}

	/**
	 * this method adds a JTextField
	 */
	private void addJTextField(){
		jtfTextSearch = JTextFieldSearch.getJtf();
		jtfTextSearch.setSize(this.getWidth() - 130, 25);
		jtfTextSearch.setLocation(15, 43);
		jtfTextSearch.addFocusListener(this);
		jtfTextSearch.setDocument(new JTextFieldLimit());
		jtfTextSearch.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				check();
			}
			public void removeUpdate(DocumentEvent e) {
				check();
			}
			public void insertUpdate(DocumentEvent e) {
				check();
			}

			public void check(){
				if(!jtfTextSearch.getText().equals(MessagesUser.getMU().getSearchProgram())){
					if(jtfTextSearch.getText().length() > 2){
						jbtSearch.setEnabled(true);
					}else{
						jbtSearch.setEnabled(false);
					}
				}else{
					jtfTextSearch.setForeground(Color.gray);
				}
			}
		});

		jtfTextSearch.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					clickButtonSearch();
				}
			}
		});
		
		voidJtfSearch();
		
		contentPane.add(jtfTextSearch);
	}
	
	/**
	 * this writes into the jtextfield the string: Search a program
	 */
	private void voidJtfSearch() {
		jtfTextSearch.setText(MessagesUser.getMU().getSearchProgram());
		jtfTextSearch.setForeground(Color.gray);
	}

	/**
	 * this method adds a JList
	 */
	private void addJList(){
		jlp = new JListPrograms();
		jlp.addMouseListener(this);
		jlp.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jlp.setFixedCellHeight(60);
		jlp.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					wma.managedInstall(jlp.getAllElementsSelectedJList());
				}else if(e.getKeyCode() == KeyEvent.VK_DELETE){
					removeProgram();
				}
			}
		});
		
//		jlp.setSelectionModel(new DefaultListSelectionModel() {
//			
//		    private int i0 = -1;
//		    private int i1 = -1;
//
//		    public void setSelectionInterval(int index0, int index1) {
//		        if(i0 == index0 && i1 == index1){
//		            if(getValueIsAdjusting()){
//		                 setValueIsAdjusting(false);
//		                 setSelection(index0, index1);
//		            }
//		        }else{
//		            i0 = index0;
//		            i1 = index1;
//		            setValueIsAdjusting(false);
//		            setSelection(index0, index1);
//		        }
//		    }
//		    
//		    private void setSelection(int index0, int index1){
//		    	System.out.println(index0 + " " + index1);
//		        if(super.isSelectedIndex(index0)) {
//		            super.removeSelectionInterval(index0, index1);
//		        }else {
//		            super.addSelectionInterval(index0, index1);
//		        }
//		    }
//		});

		jspScrollJList = new JScrollPane(jlp) ;
		jspScrollJList.setSize(this.getWidth() - 35, this.getHeight() - 252);
		jspScrollJList.setLocation(15, 110);
		
		contentPane.add(jspScrollJList);

		new FileDrop(System.out, jlp, new FileDrop.Listener(){   
			public void filesDropped( java.io.File[] files ){   
				for( int i = 0; i < files.length; i++ ){   
					try{   
						if(StringUtils.getExtension(files[i].getCanonicalPath()).toLowerCase().equals("jtm")){
							wma.chargeJTM(files[i].getCanonicalPath());
						}
					} catch( java.io.IOException e ) {

					}
				}  
			}   
		}); 

	}

	/**
	 * this method adds the buttons
	 */
	private void addJButtons(){
		jbtSearch = ButtonSearch.getjButton();
		jbtSearch = setConfigurationJButton(jbtSearch, 80, 30, this.getWidth() - 100, 40);
		ButtonSearch.setStateButton(ButtonSearch.STATE_CAN_SEARCH);
		jbtSearch.setEnabled(false);
		contentPane.add(jbtSearch);

		jbtInstall = ButtonInstall.getjButton();
		jbtInstall = setConfigurationJButton(jbtInstall, 80, 30, this.getWidth() - 100, this.getHeight() - 100);
		ButtonInstall.setStateButton(ButtonInstall.STATE_CAN_INSTALL);
		contentPane.add(jbtInstall);

		if(Debug.ECLIPSE_EXECUTE){
			jbtSelectAll = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("images/arrow.png")));
		}else{
			jbtSelectAll = new JButton(GeneralPaths.getGp().getIconArrow(this));
		}
			
		jbtSelectAll = setConfigurationJButton(jbtSelectAll, 20, 20, this.getWidth() - 40, 85);
		contentPane.add(jbtSelectAll);

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
	 * this method adds the labels
	 */
	private void addLabels(){
		jlbAccount = JLabelLogin.getjLabel();
		jlbAccount = setConfigurationJLabel(jlbAccount, 200, 30, 15, 5);

		JLabelLogin.getjLabel().setText(MessagesUser.getMU().getLogin());
		JLabelLogin.getjLabel().addMouseListener(new MouseAdapter() {  
			@Override  
			public void mouseReleased(MouseEvent e) { 
				if(!LoginUser.getLu().isConnected()){
					if(e.getX() < 30){
						wma.openLoginWindows();
					}
				}
			}
		});
		contentPane.add(jlbAccount);
		
		
		contentPane.add(AnimationSearching.getAnimationSearching(this));

		jlbVisitJtmPlace = JLabelUrlOfficial.getjLabel();
		jlbVisitJtmPlace.setText(MessagesUser.getMU().getVisitJtmPlace());
		jlbVisitJtmPlace = setConfigurationJLabel(jlbVisitJtmPlace, 650, 20, this.getWidth() - 140, 10);
		jlbVisitJtmPlace.addMouseListener(new MouseAdapter() {  
			@Override  
			public void mouseReleased(MouseEvent e) {  
				wma.goJtmPlaceCom();
			}
		});

		contentPane.add(jlbVisitJtmPlace);

		JLabel jlbProgressInstallation = JLabelProgressInstallation.getJlbPI();
		contentPane.add(jlbProgressInstallation);

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
	private JLabel setConfigurationJLabel(JLabel jlabel, int sizeX, int sizeY, int positionX, int positionY){
		jlabel.setSize(sizeX, sizeY);
		jlabel.setLocation(positionX, positionY);
		return jlabel;
	}

	/**
	 * this method adds a JProgressBar
	 */
	private void addJProgressBar(){
		BarInstall.getBarInstall().setSize(this.getWidth() - 35, 20);
		BarInstall.getBarInstall().setLocation(15, this.getHeight() - 127);
		BarInstall.getBarInstall().setStringPainted(true);
		BarInstall.getBarInstall().setVisible(true);
		contentPane.add(BarInstall.getBarInstall());
	}

	/**
	 * this method resize all the components
	 */
	private void resizeAll(){
		jbtInstall.setLocation(new Point(this.getWidth() - 100, this.getHeight() - 92));
		BarInstall.getBarInstall().setLocation(15, this.getHeight() - 127);
		BarInstall.getBarInstall().setSize(this.getWidth() - 35, 20);
		jspScrollJList.setSize(this.getWidth() - 35, this.getHeight() - 252);
		jlbVisitJtmPlace.setLocation(this.getWidth() - 140, 10);
		jbtSearch.setLocation(this.getWidth() - 100, 40);
		jtfTextSearch.setSize(this.getWidth() - 130, 25);
		jbtSelectAll.setLocation(this.getWidth() - 40, 85);
		AnimationSearching.getAnimationSearching(this).setLocation(this.getWidth() - 45, SizesGUI.LOCATION_ANIMATION_LOAD_Y);
	}
	
	/**
	 * closes the dialog
	 */
	private void closeWindow(){
		setVisible(false);
		dispose();
	}

	/**
	 * this method removes a program to the list
	 */
	private void removeProgram(){
		int itemsSelected[] = jlp.getAllElementsSelectedJList();
		if(itemsSelected.length != 0){
			jlp.removeAllElementsSelectedJList();
			ListOfPrograms.getLop().removesPrograms(itemsSelected);
		}
	}

	/**
	 * button search is clicked
	 */
	private void clickButtonSearch(){
		if(ButtonSearch.isSearching()){
			wma.stopSearch();
		}else{
			wma.startSearch(jtfTextSearch.getText());			
		}
	}

	/**
	 * button get favorites is clicked
	 */
	private void clickButtonGetFavourites(){
		if(!ButtonSearch.isSearching()){
			wma.getFavorites();
		}
	}
	
	private void selectAllItems(){
		int itemsInJList = jlp.getModel().getSize();
		int itemsSelected = jlp.getSelectedIndices().length;
		
		if(itemsInJList > 0){
			if(itemsInJList == itemsSelected){
				jlp.clearSelection();
			}else{
				jlp.setSelectionInterval(0, itemsInJList - 1);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == jbtInstall){
			if(Installer.isInstalling()){
				//we can cancel the install
				wma.cancelInstalations();
			}else{
				wma.managedInstall(jlp.getAllElementsSelectedJList());
			}
		}

		if(e.getSource() == jbtSearch){
			clickButtonSearch();
		}

		if(e.getSource() == jmiOpen){
			wma.openJTM();
		}
		
		if(e.getSource() == jbtSelectAll){
			selectAllItems();
		}

		if(e.getSource() == jmiExit){
			closeWindow();
		}

		if(e.getSource() == jmiFavorites){
			clickButtonGetFavourites();
		}

		if(e.getSource() == jmiServerConfiguration){
			wma.requestForIP();
		}
		
		if(e.getSource() == jmiProxyConfiguration){
			wma.openProxySettings();
		}

		if(e.getSource() == jmiListPublicServers){
			wma.openListPublicServers();
		}
		
		if(e.getSource() == jmiSettings){
			wma.openSettings();
		}

		if(e.getSource() == jmiLogin){
			wma.openLoginWindows();
		}

		if(e.getSource() == jmiLogout){
			wma.logout();
		}

		if(e.getSource() == itemInstall){
			wma.managedInstall(jlp.getAllElementsSelectedJList());
		}

		if(e.getSource() == itemRemove){
			removeProgram();
		}

		if(e.getSource() == itemSave){
			if(wma.saveJtm(jlp.getElementSelected())){
				MessageDialog.messageDialogInformation(this, MessagesUser.getMU().getSaved());
			}
		}

		if(e.getSource() == itemInfo){
			wma.showInfoJtm(jlp.getElementSelected());
		}
		
		if(e.getSource() == jmiHelpContent){
			wma.showHelpContent();
		}
		
		if(e.getSource() == jmiAbout){
			wma.showAbout();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			wma.managedInstall(jlp.getAllElementsSelectedJList());
		} 
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)){
			
			if(!jlp.isEmpty()){
				
				if(jlp.getSelectedIndices().length < 2){
					jlp.setSelectedIndex(jlp.locationToIndex(e.getPoint()));
				}
		
				if(jlp.getSelectedIndices().length > 1){
					itemSave.setEnabled(false);
					itemInfo.setEnabled(false);
				}else{
					itemSave.setEnabled(true);
					itemInfo.setEnabled(true);
				}
				jPopupMenu.show(jlp, e.getX(), e.getY());
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == jtfTextSearch){
			if(jtfTextSearch.getText().equals(MessagesUser.getMU().getSearchProgram())){
				jtfTextSearch.setText("");
				jtfTextSearch.setForeground(Color.black);
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource() == jtfTextSearch){
			if(jtfTextSearch.getText().length() == 0){
				voidJtfSearch();
			}
		}
	}
}
