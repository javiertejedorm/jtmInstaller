package com.jtmproject.gui;

import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.jtmproject.actions.AnalizeInstallWithSetting;
import com.jtmproject.install.HKEYForInstall;
import com.jtmproject.install.PathInstallProgram;
import com.jtmproject.task.Program;
import com.jtmproject.user.GeneralPaths;
import com.jtmproject.user.MessagesUser;

/**
 * This class create a JPanel with content for configuring the install 
 * @author Javier Tejedor
 */
public class MenuSettingsIntallGUI extends JPanel implements IViewGeneral, ActionListener{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6578446466867386197L;
	
	private JLabel jlbPathInstall;
	private JButton jbtChangePath;
	private JCheckBox jcbAddDesktopShorcut;
	private JCheckBox jcbAddMenuPrograms;
	private JRadioButton jrbInstallCurrentUser;
	private JRadioButton jrbInstallAllUsers;

	private JList<?> jltCheckBoxesExtensions;

	private String newPathToInstall = "";
	private int HKEYSelected = 0;
	private ArrayList<String> extensionsSelected;
	private CheckableItemJListChecbox[] items;
	private String defaultPathToInstall;

	private int numberOfExtensions = 0;
	private Program program;

	/**
	 * constructor
	 * @param program
	 */
	public MenuSettingsIntallGUI(Program program){
		this.program = program;
	}

	@Override
	public void chargeView() {
		this.setSize(SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN, SizesGUI.WINDOW_HEIGHT_INSTALL_SCREEN - 90);
		this.setLocation(0, 0);
		this.setLayout(null);

		extensionsSelected = new ArrayList<String>();
		extensionsSelected.clear();
		
		defaultPathToInstall = PathInstallProgram.getRootPathInstallProgram(program);

		addComponents();
	}

	/**
	 * this adds the components
	 */
	private void addComponents(){
		addTitle();
		addInstallInto();
		addShortcuts();
		addExtensions();
	}
	
	/**
	 * this mehtod adds the title
	 */
	private void addTitle(){
		JLabel jlbConfiguration = new JLabel(MessagesUser.getMU().getConfiguration());
		jlbConfiguration = setConfigurationLabel(jlbConfiguration, 20, 12);
		jlbConfiguration.setFont(new Font("Arial", Font.PLAIN, 20));
		this.add(jlbConfiguration);
	}

	/**
	 * this method adds intall into jPanel
	 */
	private void addInstallInto(){
		boolean canChangeDirectory = AnalizeInstallWithSetting.isPossibleChooseFolderToInstall(program);
		int heightButton = 0;
		
		if(canChangeDirectory){
			heightButton = 20;
		}
		
		JPanel jplInstallIn = new JPanel();
		jplInstallIn.setLayout(null);
		jplInstallIn.setSize(420, 112 + heightButton);
		jplInstallIn.setLocation(20, 45);
		jplInstallIn.setBorder(BorderFactory.createTitledBorder(MessagesUser.getMU().getInstallTo()));
		
		jlbPathInstall = new JLabel();		
		jlbPathInstall = setConfigurationLabel(jlbPathInstall, 10, 30 + heightButton);
		this.setPathToInstall(defaultPathToInstall);
		jplInstallIn.add(jlbPathInstall);
		
		if(canChangeDirectory){
			jbtChangePath = new JButton(MessagesUser.getMU().getChange());
			jbtChangePath.setMargin(new Insets(0,0,0,0));
			jbtChangePath.setSize(70, 20);
			jbtChangePath.setLocation(10, 25);
			jbtChangePath.addActionListener(this);
			jplInstallIn.add(jbtChangePath);
		}
		
		jrbInstallCurrentUser = new JRadioButton(MessagesUser.getMU().getInstallCurrentUser());
		jrbInstallCurrentUser = jrbConfiguration(jrbInstallCurrentUser, 7, 60  + heightButton);
		jrbInstallCurrentUser.setSelected(false);

		jrbInstallAllUsers = new JRadioButton(MessagesUser.getMU().getInstallAllUsers());
		jrbInstallAllUsers = jrbConfiguration(jrbInstallAllUsers, 7, 82 + heightButton);
		jrbInstallAllUsers.setSelected(true);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(jrbInstallCurrentUser);
	    group.add(jrbInstallAllUsers);
	    
	    jplInstallIn.add(jrbInstallCurrentUser);
	    jplInstallIn.add(jrbInstallAllUsers);
		
		this.add(jplInstallIn);
	}
	
	/**
	 * this sets the path to install the program
	 * @param path
	 */
	private void setPathToInstall(String path){
		newPathToInstall = path;
		jlbPathInstall.setText(newPathToInstall);
	}
	
	/**
	 * this method adds the jCheckBox for the shortcuts
	 */
	private void addShortcuts(){
		JPanel jplAddShortcuts = new JPanel();
		jplAddShortcuts.setLayout(null);
		jplAddShortcuts.setSize(420, 74);
		jplAddShortcuts.setLocation(20, 195);
		jplAddShortcuts.setBorder(BorderFactory.createTitledBorder(MessagesUser.getMU().getAddShortcuts()));
		
		if(AnalizeInstallWithSetting.isPossibleAddShortcutDesktop(program)){
			jcbAddDesktopShorcut = new JCheckBox(MessagesUser.getMU().getAddShortcutDesktop());
			jcbAddDesktopShorcut = jcbConfiguration(jcbAddDesktopShorcut, 7, 23);
			jplAddShortcuts.add(jcbAddDesktopShorcut);
		}

		if(AnalizeInstallWithSetting.isPossibleAddStartMenu(program)){
			jcbAddMenuPrograms = new JCheckBox(MessagesUser.getMU().getAddShortcutStartMenu());
			jcbAddMenuPrograms = jcbConfiguration(jcbAddMenuPrograms, 7, 45);
			jplAddShortcuts.add(jcbAddMenuPrograms); 
		}
		
		this.add(jplAddShortcuts);
	}
	
	/**
	 * this method adds the jCheckBox for the extensions
	 */
	private void addExtensions(){
		
		numberOfExtensions = getArrayListExtension().size();
		
		if(numberOfExtensions > 0){
			JPanel jplAddExtensions = new JPanel();
			jplAddExtensions.setLayout(null);
			jplAddExtensions.setSize(420, 120);
			jplAddExtensions.setLocation(20, 280);
			jplAddExtensions.setBorder(BorderFactory.createTitledBorder(MessagesUser.getMU().getAssociateExtension()));
			
			String[] extensions = new String[numberOfExtensions];
			extensions = getArrayListExtension().toArray(extensions);

			jltCheckBoxesExtensions = new JList<Object>(createData(extensions)); 
			jltCheckBoxesExtensions.setCellRenderer(new CheckListRenderer());
			jltCheckBoxesExtensions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			jltCheckBoxesExtensions.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int index = jltCheckBoxesExtensions.locationToIndex(e.getPoint());
					CheckableItemJListChecbox item = (CheckableItemJListChecbox) jltCheckBoxesExtensions.getModel().getElementAt(index);
					item.setSelected(!item.isSelected());
					Rectangle rect = jltCheckBoxesExtensions.getCellBounds(index, index);
					jltCheckBoxesExtensions.repaint(rect);
				}
			});

			JScrollPane scrollPane = new JScrollPane(jltCheckBoxesExtensions);
			scrollPane.setSize(400, 90);
			scrollPane.setLocation(10, 20);
			jplAddExtensions.add(scrollPane);
			this.add(jplAddExtensions);
		}
	}

	/**
	 * This function sets configuration to JLabel
	 * @param jlabel
	 * @param locationX
	 * @param locationY
	 * @return
	 */
	private JLabel setConfigurationLabel(JLabel jlabel, int locationX, int locationY){
		jlabel.setSize(SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN - 50, 24);
		jlabel.setLocation(locationX, locationY);
		return jlabel;
	}

	/**
	 * this function configures a JCheckBox
	 * @param jcb
	 * @param locationX
	 * @param locationY
	 * @return
	 */
	private JCheckBox jcbConfiguration(JCheckBox jcb, int locationX, int locationY){
		jcb.setSize(SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN - 50, 20);
		jcb.setLocation(locationX, locationY);
		jcb.setSelected(true);
		jcb.addActionListener(this);
		return jcb;
	}
	
	/**
	 * this function configures a JCheckBox
	 * @param jrb
	 * @param locationX
	 * @param locationY
	 * @return
	 */
	private JRadioButton jrbConfiguration(JRadioButton jrb, int locationX, int locationY){
		jrb.setSize(SizesGUI.WINDOW_WIDTH_INSTALL_SCREEN - 50, 20);
		jrb.setLocation(locationX, locationY);
		jrb.setSelected(true);
		jrb.addActionListener(this);
		return jrb;
	}

	/**
	 * this create the array of JCheckBox for adding into the JList
	 * @param strs
	 * @return
	 */
	private CheckableItemJListChecbox[] createData(String[] strs) {
		int n = strs.length;
		items = new CheckableItemJListChecbox[n];
		for (int i = 0; i < n; i++) {
			items[i] = new CheckableItemJListChecbox(strs[i]);
		}
		return items;
	}

	/**
	 * returns the list of extension for charge into the JList
	 * @return
	 */
	private ArrayList<String> getArrayListExtension(){
		ArrayList<String> listExtension = new ArrayList<String>();
		listExtension.clear();

		int size = program.getListTagExtensionsSupported().size();
		for(int i = 0; i < size; i++){
			listExtension.add(program.getListTagExtensionsSupported().get(i).getExtension());
		}
		return listExtension;
	}

	/**
	 * this saves the extensions selected
	 */
	private void saveExtensionIntoTheList(){
		for(int i = 0; i < items.length; i++){
			if(items[i].isSelected()){
				extensionsSelected.add(items[i].toString());
			}
		}
	}

	@Override
	public void removeElements() {
		this.removeAll();
	}

	@Override
	public void saveData() {
		
		if(jrbInstallAllUsers.isSelected()){
			HKEYSelected = HKEYForInstall.HKEY_LOCAL_MACHINE;
		}else if(jrbInstallCurrentUser.isSelected()){
			HKEYSelected = HKEYForInstall.HKEY_CURRENT_USER;
		}

		if(program.getListTagExtensionsSupported().size() > 0){
			saveExtensionIntoTheList();
		}

	}

	@Override
	public int errorCode() {
		return 0;
	}

	/**
	 * returns the new path to install the program
	 * @return
	 */
	public String getNewPathToInstall(){
		return newPathToInstall.substring(3, newPathToInstall.length());
	}

	/**
	 * returns if is added to shortcut desktop
	 * @return
	 */
	public boolean isAddShortcutDesktop(){
		if(AnalizeInstallWithSetting.isPossibleAddShortcutDesktop(program)){
			return jcbAddDesktopShorcut.isSelected();
		}
		return false;
	}

	/**
	 * returns if is added to start menu
	 * @return
	 */
	public boolean isAddStartMenu(){
		if(AnalizeInstallWithSetting.isPossibleAddStartMenu(program)){
			return jcbAddMenuPrograms.isSelected();
		}
		return false;
	}

	/**
	 * this is called when jbtChangePath is pressed
	 */
	private void clickChangePathButton(){
		String pathSelected = "";
		JFileChooser fileChooserSelectDirectory = new JFileChooser(GeneralPaths.getGp().getLastDirectoryOpened()); 
		fileChooserSelectDirectory.setDialogTitle(MessagesUser.getMU().getSelectDirectory());
		fileChooserSelectDirectory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooserSelectDirectory.setAcceptAllFileFilterUsed(false);
		if (fileChooserSelectDirectory.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
			
			pathSelected = fileChooserSelectDirectory.getSelectedFile().toString();
			GeneralPaths.getGp().saveDirectory(pathSelected);
			
			if(pathSelected.endsWith("\\")){
				setPathToInstall(pathSelected + PathInstallProgram.getNameFolderInstallProgram(program));
			}else{
				setPathToInstall(pathSelected + "\\" + PathInstallProgram.getNameFolderInstallProgram(program));
			}
			
		}
	}

	/**
	 * returns the HKEYSelected
	 * @return
	 */
	public int getHKEYSelected() {
		return HKEYSelected;
	}

	/**
	 * this returns the extensions selected
	 * @return
	 */
	public ArrayList<String> getExtensionsSelected(){
		if(extensionsSelected.size() == 0){
			return null;
		}
		return extensionsSelected;
	}
	
	/**
	 * this checks the radiobutton clicked
	 */
	private void checkJRadioButtons(){
		boolean selected = jrbInstallCurrentUser.isSelected();
		if(selected){
			setPathToInstall(PathInstallProgram.getLocalAppData(program));
		}else{
			setPathToInstall(defaultPathToInstall);
		}
		
		if(jbtChangePath != null){
			jbtChangePath.setEnabled(!selected);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtChangePath){
			clickChangePathButton();
		}
		
		if(e.getSource() == jrbInstallCurrentUser || e.getSource() == jrbInstallAllUsers){
			checkJRadioButtons();
		}
	}
}
