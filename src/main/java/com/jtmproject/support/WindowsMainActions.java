package com.jtmproject.support;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.jtmproject.actions.Checks;
import com.jtmproject.actions.ControlAnInstall;
import com.jtmproject.actions.ControlSeveralInstallations;
import com.jtmproject.actions.ErrorOpenJtm;
import com.jtmproject.actions.FilesUtils;
import com.jtmproject.actions.Installer;
import com.jtmproject.actions.ListAllData;
import com.jtmproject.actions.OpenJTM;
import com.jtmproject.actions.OpenProxySettings;
import com.jtmproject.gui.AnimationSearching;
import com.jtmproject.gui.ButtonSearch;
import com.jtmproject.gui.EnterLoginValues;
import com.jtmproject.gui.MessageDialog;
import com.jtmproject.gui.PreferencesGUI;
import com.jtmproject.gui.ShowInformationWindow;
import com.jtmproject.install.InstallerCenter;
import com.jtmproject.server.LoginUser;
import com.jtmproject.server.LoginUserToServer;
import com.jtmproject.server.SearchFavorites;
import com.jtmproject.server.SearchPrograms;
import com.jtmproject.server.SearchPublicServer;
import com.jtmproject.server.ServerConstants;
import com.jtmproject.server.ServerUrls;
import com.jtmproject.task.ListOfPrograms;
import com.jtmproject.task.Program;
import com.jtmproject.user.GeneralPaths;
import com.jtmproject.user.MessagesUser;
import com.jtmproject.user.UserProperties;

/**
 * this class does the actions orderer by WindowMain.java
 * @author Javier Tejedor
 */
public class WindowsMainActions {

	private JFrame jFrame;
	private SearchPrograms searchPrograms;
	private SearchFavorites searchFavourites;
	private ControlAnInstall controlAnInstall;
	private ControlSeveralInstallations controlSeveralInstallations;

	/**
	 * constructor
	 * @param jFrame
	 */
	public WindowsMainActions(JFrame jFrame){
		this.jFrame = jFrame;
	}

	/**
	 * this method tries to login the user if exist in the properties file
	 */
	public void tryLoginUser(){
		String user = UserProperties.getUp().getUser();
		String password = UserProperties.getUp().getPassword();
		if(!user.equals("") && !password.equals("")){
			new LoginUserToServer(user, password, false);
		}
	}

	/**
	 * btnOpen is click and opens a dialog for choose a file with jtm extension
	 */
	public void openJTM(){
		JFileChooser fileChooserSelectFile = new JFileChooser(GeneralPaths.getGp().getLastDirectoryOpened());
		fileChooserSelectFile.setAcceptAllFileFilterUsed(false);
		fileChooserSelectFile.addChoosableFileFilter(new TextFilter());
		int returnVal = fileChooserSelectFile.showOpenDialog(jFrame);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			File file = fileChooserSelectFile.getSelectedFile();
			chargeJTM(file.getAbsolutePath());
			GeneralPaths.getGp().saveDirectory(file.getParent());
		}
	}

	/**
	 * this method charge a JTM into the list
	 * @param path
	 */
	public void chargeJTM(String path){
		if(!new OpenJTM().open(path)){
			errorOpenFile();
		}
	}

	/**
	 * this checks the version. Maybe the jtm contains new Tags
	 */
	private void errorOpenFile(){
		new ErrorOpenJtm();
	}

	/**
	 * sets the IP for connecting with the server
	 */
	public void requestForIP(){
		String ip = MessageDialog.messageDialogInput(jFrame, MessagesUser.getMU().getEnterIP(), ServerUrls.getSip().getIpStore());
		if(ip != null){
			ServerUrls.getSip().setIpStore(ip);
			LoginUser.getLu().logout();
		}
	}

	/**
	 * gets all favorites JTMs
	 */
	public void getFavorites(){
		if(LoginUser.getLu().isConnected()){
			AnimationSearching.setAnimationSearching(true);
			ButtonSearch.setStateButton(ButtonSearch.STATE_DISABLE);
			searchFavourites = new SearchFavorites();
		}else{
			MessageDialog.messageDialogError(jFrame, MessagesUser.getMU().getYouMustLoginFirst());
		}
	}

	/**
	 * opens the list of Public Servers to connect.
	 */
	public void openListPublicServers(){
		AnimationSearching.setAnimationSearching(true);
		new SearchPublicServer(jFrame);
	}

	/**
	 * this opens the settings of the proxy
	 */
	public void openProxySettings(){
		new OpenProxySettings();
	}

	/**
	 * opens the settings window
	 */
	public void openSettings(){
		new PreferencesGUI(jFrame);
	}

	/**
	 * login user
	 */
	public void openLoginWindows(){
		new EnterLoginValues(jFrame);
	}

	/**
	 * logout user
	 */
	public void logout(){
		if(LoginUser.getLu().isConnected()){
			LoginUser.getLu().logout();
		}
	}

	/**
	 * this method shows the info of the program
	 */
	public void showInfoJtm(int itemSelected){
		if(itemSelected != -1){
			Program programSelected = ListOfPrograms.getLop().getListPrograms().get(itemSelected);
			new ShowInformationWindow(jFrame, new ListAllData().getAllData(programSelected), MessagesUser.getMU().getInformationProgram());
		}
	}

	/**
	 * this method opens the browser and showing the help of jtmProject
	 */
	public void showHelpContent(){

	}

	/**
	 * this method opens the browser and showing the about of jtmProject
	 */
	public void showAbout(){

	}

	/**
	 * this method opens the browser and showing the jtmPlace.com
	 */
	public void goJtmPlaceCom(){
		try {  
			Desktop.getDesktop().browse(new URI(ServerConstants.getSc().getOfficialJtmPlaceUrl()));  
		} catch (URISyntaxException ex) {  

		} catch (IOException ex) {  

		}  
	}

	/**
	 * when search button is pulsed.
	 */
	public void startSearch(String text){
		if(Checks.isConnectServerPossible()){
			if(!text.replace(" ", "").equals("")){
				AnimationSearching.setAnimationSearching(true);
				ButtonSearch.setStateButton(ButtonSearch.STATE_DISABLE);
				searchPrograms = new SearchPrograms(text);
			}
		}else{
			MessageDialog.messageDialogError(jFrame, MessagesUser.getMU().getInvalidServer());
		}
	}

	/**
	 * this method decides if there is one install to do or there are several installs
	 * @param openByParameters
	 */
	public void managedInstall(int itemsSelected[]){
		if(Installer.isInstalling() == false){
			if(itemsSelected.length != 0){
				if(itemsSelected.length == 1){
					startInstallAProgram(itemsSelected[0]);
				}else{
					startInstallSeveralPrograms(itemsSelected);
				}
			}
		}else{
			MessageDialog.messageDialogGeneral(jFrame, MessagesUser.getMU().getThereAreOthersInstalls());
		}
	}

	/**
	 * this cancels the installation
	 */
	public void cancelInstalations(){
		if(controlAnInstall != null){
			controlAnInstall.cancelInstall();
		}

		if(controlSeveralInstallations != null){
			controlSeveralInstallations.cancelInstall();
		}

		if(searchFavourites != null){
			searchFavourites.cancelSearch();
		}
	}

	/**
	 * install button is clicked
	 */
	public void startInstallAProgram(int index){
		if(index != -1){
			controlAnInstall = new ControlAnInstall(index);
			InstallerCenter.setControlAnInstall(controlAnInstall);
			new Thread(controlAnInstall).start();
		}
	}
	/**
	 * this method asks about if to do several installs or not
	 * @param itemsSelected
	 */
	private void startInstallSeveralPrograms(int[] itemsSelected){
		int ret = MessageDialog.messageDialogQuestion(jFrame, "Desea instalar varios programas, ┐Continuar?: \n " + getNameProgramsSelected(itemsSelected));
		if(ret == JOptionPane.YES_OPTION){
			controlSeveralInstallations = new ControlSeveralInstallations(itemsSelected);
			InstallerCenter.setControlSeveralInstallations(controlSeveralInstallations);
			new Thread(controlSeveralInstallations).start();
		}
	}

	/**
	 * gets the name of the programs selected
	 * @param itemsSelected
	 * @return
	 */
	private List<String> getNameProgramsSelected(int[] itemsSelected){
		List<String> names = new ArrayList<String>();
		names.clear();

		for(int i = 0; i < itemsSelected.length; i++){
			int item = itemsSelected[i];
			if(i == itemsSelected.length - 1){
				names.add(ListOfPrograms.getLop().getListPrograms().get(item).getTagProject().getName());
			}else{
				names.add(ListOfPrograms.getLop().getListPrograms().get(item).getTagProject().getName() + "\n");
			}

		}
		return names;
	}

	/**
	 * this method cancels the search
	 */
	public void stopSearch(){
		if(searchPrograms != null){
			searchPrograms.stopSearch();
			ButtonSearch.setStateButton(ButtonSearch.STATE_CAN_SEARCH);
		}
	}

	/**
	 * this method saves a jtm file
	 * @param index
	 */
	public boolean saveJtm(int index){
		File fileName = null;
		JFileChooser chooser = new JFileChooser();
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.addChoosableFileFilter(new TextFilter());
		chooser.setCurrentDirectory(new File(GeneralPaths.getGp().getLastDirectoryOpened()));
		int actionDialog = chooser.showSaveDialog(jFrame);
		if(actionDialog == JFileChooser.APPROVE_OPTION ){
			fileName = chooser.getSelectedFile(); 
			if(fileName != null){
				GeneralPaths.getGp().saveDirectory(fileName.getParent());
				String pathJtm = ListOfPrograms.getLop().getListPrograms().get(index).getPathJtm();
				File jtmFile = new File(pathJtm);
				File jtmDestination = FilesUtils.setExtensionJtm(fileName);

				if(FilesUtils.copyFile(jtmFile, jtmDestination)){
					return true;
				}
			}
		}
		return false;
	}
}
