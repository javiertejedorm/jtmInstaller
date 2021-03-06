package com.jtmproject.actions;

import javax.swing.JOptionPane;

import com.jtmproject.gui.BarInstall;
import com.jtmproject.gui.ButtonInstall;
import com.jtmproject.gui.JLabelProgressInstallation;
import com.jtmproject.gui.JListPrograms;
import com.jtmproject.gui.JTextFieldSearch;
import com.jtmproject.gui.MainWindowJFrame;
import com.jtmproject.gui.MessageDialog;
import com.jtmproject.gui.StartInstall;
import com.jtmproject.install.InstallerCenter;
import com.jtmproject.install.PathInstallProgram;
import com.jtmproject.install.RunProgram;
import com.jtmproject.task.ListOfPrograms;
import com.jtmproject.task.Program;
import com.jtmproject.user.ErrorCode;
import com.jtmproject.user.MessagesUser;
import com.jtmproject.user.SettingsUser;

/**
 * this class controls an installation
 * @author Javier Tejedor
 */
public class ControlAnInstall implements Runnable{

	private int itemSelected;
	private Installer installer;
	
	/**
	 * constructor
	 * @param jFrame
	 * @param itemsSelected
	 */
	public ControlAnInstall(int itemSelected) {
		this.itemSelected = itemSelected;
	}

	@Override
	public void run(){
		install();
	}
	
	/**
	 * this cancels the install
	 */
	public void cancelInstall(){
		if(installer != null){
			installer.cancelInstallation();
		}
	}

	/**
	 * it does the installs
	 */
	private void install(){
		Program program = ListOfPrograms.getLop().getListPrograms().get(itemSelected);

		PreviousChecks pc = new PreviousChecks(program);
		int errorCode = pc.previousCheck();
		if(errorCode == ErrorCode.OK){

			StartInstall startInstall = new StartInstall(MainWindowJFrame.getjFrame(), program, itemSelected);
			if(startInstall.isInstall()){
				ButtonInstall.setStateButton(ButtonInstall.STATE_CAN_CANCEL);
				
				installer = new Installer(program);
				installer.install();

			}
			
		}else{
			LaunchError.lauchErrorMessage(errorCode, program);
		}

		if(installer != null){
			
			BarInstall.getBarInstall().setValue(0);
			JTextFieldSearch.getJtf().setText(MessagesUser.getMU().getSearchProgram());
			ButtonInstall.setStateButton(ButtonInstall.STATE_CAN_INSTALL);
			
			if(!installer.isRun()){
				cleanInstallStoppedByUser(program);
				completingACancelInstall();
			}else{
				checkErrorCode(installer, program, itemSelected);
			}
		}
		
		InstallerCenter.setControlAnInstall(null);
	}

	/**
	 * this method finishes the install 
	 */
	private void completingInstalation(Program program, int item){
		JListPrograms.removeElementJList(item); 
		ListOfPrograms.getLop().removeProgram(item);
		askExecuteProgram(program);

		
	}
	
	/**
	 * this method finishes a cancel install
	 */
	private void completingACancelInstall(){
		JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getInstallationCancelled());
	} 
	
	/**
	 * this checks the error code
	 * @param installer
	 * @param program
	 */
	private void checkErrorCode(Installer installer, Program program, int item){
		if(installer != null){
			int errorCode = installer.getRetCode();
			if(errorCode == ErrorCode.OK){
				completingInstalation(program, item);
				JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getProgramInstalled());
				if(SettingsUser.isRemoveJtmAfterInstall()){
					FilesUtils.deleteFile(program.getPathJtm());
				}
			}else{
				LaunchError.lauchErrorMessage(errorCode, program);
			}
		}
	}
	
	/**
	 * this calls to clean the installation
	 * @param program
	 */
	private void cleanInstallStoppedByUser(Program program){
		new CleanInstall(program);
	}

	/**
	 * this method asks if exists a executable file to run the program 
	 */
	private void askExecuteProgram(Program program){
		String executablePath =  program.getTagProject().getExecutableFile();

		if(executablePath.equals("")){
			MessageDialog.messageDialogInformation(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getProgramInstalled());
		}else{
			String completePath = StringUtils.correctPath(PathInstallProgram.getRootPathInstallProgram(program) + executablePath);
			int ret = MessageDialog.messageDialogQuestion(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getProgramInstalled() + ", " + MessagesUser.getMU().getDoYouWantToRun() + "\n" + completePath);
			if(ret == JOptionPane.YES_OPTION){
				
				new RunProgram(completePath);
			}
		}
	}
}
