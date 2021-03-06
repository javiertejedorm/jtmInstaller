package com.jtmproject.actions;

import java.util.ArrayList;

import com.jtmproject.gui.JLabelProgressInstallation;
import com.jtmproject.gui.MainWindowJFrame;
import com.jtmproject.gui.MessageDialog;
import com.jtmproject.task.Program;
import com.jtmproject.user.ErrorCode;
import com.jtmproject.user.MessagesUser;

public class LaunchError {

	/**
	 * this method launches a message error about space on disk
	 */
	private static void launchMessageSpaceError(){
		MessageDialog.messageDialogError(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getErrorSpace());
		JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getErrorSpace());
	}
	
	/**
	 * this method launch a message error when the Operating System is incompatible
	 */
	private static void launchMessageOSIncompatible(Program program){
		String osCompatible = "";
		int size = osSupported(program).size();
		for(int i = 0; i < size; i++){
			osCompatible += osSupported(program).get(i) + "\n"; 
		}
		MessageDialog.messageDialogError(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getOsIncompatible() + " (" + OperatingSystem.getOS().toLowerCase() + ")" + ".\n" + osCompatible);
		JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getOsIncompatible());
	}
	
	/**
	 * returns the list of Operating System supported
	 * @return
	 */
	private static ArrayList<String> osSupported(Program program){
		ArrayList<String> osSupportedList = new ArrayList<String>();
		osSupportedList.clear();
		
		int size = program.getListTagOperatingSystem().size();
		for(int i = 0; i < size; i++){
			osSupportedList.add(program.getListTagOperatingSystem().get(i).getNameOfOperatingSystem());
		}
		return osSupportedList;
	}
	
	/**
	 * This method launches a message advising that there is not Internet connection
	 */
	private static void notInternetConnection(){
		MessageDialog.messageDialogError(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getThereIsNotInternetConnection());
	}

	/**
	 * This method launches a message advising that there is a problem with the decompress
	 */
	private static void launchDecompressError(){
		MessageDialog.messageDialogError(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getErrorDecompress());
	}
	
	/**
	 * This method launches a message advising that there is a problem with the jtx download 
	 */
	private static void launchDownloadError(){
		MessageDialog.messageDialogError(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getErrorDownload());
	}
	
	/**
	 * This method launches a message advising that there is a problem finding the path to install the program
	 */
	private static void launchFindPathError(){
		MessageDialog.messageDialogError(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getErrorFindPath());
	}
	
	/**
	 * @param error
	 */
	public static void lauchErrorMessage(int error, Program program){
		switch (error) {
		case ErrorCode.COMPARE_OS_ERROR:
			launchMessageOSIncompatible(program);
			break;

		case ErrorCode.FREE_SPACE_ERROR:
			launchMessageSpaceError();
			break;
			
		case ErrorCode.DECOMPRESS_ERROR:
			launchDecompressError();
			break;
			
		case ErrorCode.DOWNLOAD_ERROR:
			launchDownloadError();
			break;
			
		case ErrorCode.FIND_PATH_ERROR:
			launchFindPathError();
			break;
		
		case ErrorCode.NOT_INTERNET_CONNECTION:
			notInternetConnection();
			break;
		default:
			break;
		}
	}
}
