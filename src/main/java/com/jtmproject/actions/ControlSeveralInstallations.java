package com.jtmproject.actions;

import java.util.ArrayList;
import java.util.List;

import com.jtmproject.gui.BarInstall;
import com.jtmproject.gui.ButtonInstall;
import com.jtmproject.gui.JLabelProgressInstallation;
import com.jtmproject.gui.JListPrograms;
import com.jtmproject.gui.JTextFieldSearch;
import com.jtmproject.install.HKEYForInstall;
import com.jtmproject.install.InstallerCenter;
import com.jtmproject.task.ListOfPrograms;
import com.jtmproject.task.Program;
import com.jtmproject.user.ErrorCode;
import com.jtmproject.user.MessagesUser;
import com.jtmproject.user.SettingsUser;

/**
 * this class controls several installs
 * @author Javier Tejedor
 */
public class ControlSeveralInstallations implements Runnable{

	private static final int FIRST_ITEM = 0;
	private int itemsSelected[];
	private List<Program> queueProgramsToInstall;
	private Installer installer;
	private boolean run;

	/**
	 * constructor
	 * @param itemsSelected
	 */
	public ControlSeveralInstallations(int[] itemsSelected) {
		this.itemsSelected = itemsSelected;
		run = true;
		fillQueueListPrograms();
	}

	@Override
	public void run(){
		install();
	}

	/**
	 * this cancels the install
	 */
	public void cancelInstall(){
		run = false;
		if(installer != null){
			installer.cancelInstallation();
		}
	}
	
	/**
	 * this fills the queue
	 */
	private void fillQueueListPrograms(){
		queueProgramsToInstall = new ArrayList<Program>();
		queueProgramsToInstall.clear();

		for(int i = 0; i < itemsSelected.length; i++){
			queueProgramsToInstall.add(ListOfPrograms.getLop().getListPrograms().get(itemsSelected[i]));
		}
	}

	/**
	 * it does the installs
	 */
	private void install(){
		int size = queueProgramsToInstall.size();
		int i = 0;
		while(i < size && run){
			int item = itemsSelected[i];
			Program program = queueProgramsToInstall.get(FIRST_ITEM);
			PreviousChecks pc = new PreviousChecks(program);
			int errorCode = pc.previousCheck();
			if(errorCode == ErrorCode.OK){
				HKEYForInstall.setCurrentHKEY(HKEYForInstall.HKEY_LOCAL_MACHINE);
				ButtonInstall.setStateButton(ButtonInstall.STATE_CAN_CANCEL);
				
				installer = new Installer(program);
				installer.install();
				
				checkErrorCode(installer, program, item - i); //(item - i) because it will remove the item into the list.
			}else{
				LaunchError.lauchErrorMessage(errorCode, program);
			}
			i++;
		}
		
		if(installer != null){
			
			JTextFieldSearch.getJtf().setText(MessagesUser.getMU().getSearchProgram());
			ButtonInstall.setStateButton(ButtonInstall.STATE_CAN_INSTALL);
			
			if(!installer.isRun()){ //or if this.run is true also is valid
				completingACancelInstall();
			}
		}
		
		InstallerCenter.setControlSeveralInstallations(null);
	}
	
	
	/**
	 * this method finishes a cancel install
	 */
	private void completingACancelInstall(){
		BarInstall.getBarInstall().setValue(0);
		JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getInstallationCancelled());
	} 

	/**
	 * this method checks if there is a error code on the install
	 * @param installer
	 * @param program
	 * @param item
	 */
	private void checkErrorCode(Installer installer, Program program, int item){
		BarInstall.getBarInstall().setValue(0);
		
		int errorCode = installer.getRetCode();
		if(errorCode == ErrorCode.OK){
			JListPrograms.removeElementJList(item);
			ListOfPrograms.getLop().removeProgram(item);
			queueProgramsToInstall.remove(FIRST_ITEM);
			JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getProgramInstalled());
			
			if(SettingsUser.isRemoveJtmAfterInstall()){
				FilesUtils.deleteFile(program.getPathJtm());
			}
		}else{
			LaunchError.lauchErrorMessage(errorCode, program);
		}
	}
}
