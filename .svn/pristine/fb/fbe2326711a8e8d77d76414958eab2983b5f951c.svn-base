package com.jtmproject.actions;

import com.jtmproject.task.Program;
import com.jtmproject.user.MessagesUser;

/**
 * This class compiles data about the program for showing to the user
 * @author Javier Tejedor
 */
public class ListAllData {

	private static final String DOUBLE_BR = "<BR /><BR />"; 
	
	/**
	 * return all data
	 * @return
	 */
	public String getAllData(Program program) {
		
		String result = "";
		result += getDataProject(program) + "";
		result += getOperatingSystemAndDefaultFolder(program);
		result += getMetadata(program);
		
		return result;
	}
	
	/**
	 * returns the metadata of the project
	 * @param program
	 * @return
	 */
	private String getMetadata(Program program){
		String data = "";
		data += "<b>" + MessagesUser.getMU().getAuthor() + "</b>: " + program.getTagMetadata().getAuthor() + DOUBLE_BR;
		data += "<b>" + MessagesUser.getMU().getLocalization() + "</b>: " + program.getTagMetadata().getLocalization() + DOUBLE_BR;
		data += "<b>" + MessagesUser.getMU().getDescription() + "</b>: " + program.getTagMetadata().getDescription() + DOUBLE_BR;
		data += "<b>" + MessagesUser.getMU().getDeveloper() + "</b>: " + program.getTagMetadata().getDeveloper() + DOUBLE_BR;
		data += "<b>" + MessagesUser.getMU().getProductCode() + "</b>: " + program.getTagMetadata().getProductCode() + DOUBLE_BR;
		data += "<b>" + MessagesUser.getMU().getProductName() + "</b>: " + program.getTagMetadata().getProductName() + DOUBLE_BR;
		data += "<b>" + MessagesUser.getMU().getTechnicalSupportTelephone() + "</b>: " + program.getTagMetadata().getTechnicalSupportTelephone() + DOUBLE_BR;
		data += "<b>" + MessagesUser.getMU().getTechnicalSupportUrl() + "</b>: " + program.getTagMetadata().getTechnicalSupportUrl() + DOUBLE_BR;
		data += "<b>" + MessagesUser.getMU().getVersion() + "</b>: " + program.getTagMetadata().getVersion() + DOUBLE_BR;
		return data;
	}
	
	/**
	 * returns the name of the proggram
	 * @param program
	 * @return
	 */
	private String getDataProject(Program program){
		String data = "";
		data += "<b>" + MessagesUser.getMU().getNameOfTheProgram() + "</b>: " + program.getTagProject().getName() + DOUBLE_BR;
		data += "<b>" + MessagesUser.getMU().getSizeAfterInstall() + "</b>: " + StringUtils.convertSizeFile(program.getTagProject().getSize()) + DOUBLE_BR;
		data += "<b>" + MessagesUser.getMU().getTotalFiles() + "</b>: " + program.getTagProject().getTotalFiles() + DOUBLE_BR;
		data += "<b>" + MessagesUser.getMU().getUrlDownloadFile() + "</b>: " + program.getTagProject().getUrl() + DOUBLE_BR;
		return data;
	}
	
	/**
	 * returns the operating system supported and his default folder to install 
	 * @param program
	 * @return
	 */
	private String getOperatingSystemAndDefaultFolder(Program program){
		String data = "";
		int size = program.getListTagOperatingSystem().size();
		for(int i = 0 ; i < size; i++){
			data += "<b>" + MessagesUser.getMU().getOsSupported() + "</b>: " + program.getListTagOperatingSystem().get(i).getNameOfOperatingSystem() +
					"(" + GetPathsOS.getLetterWindows() + program.getListTagOperatingSystem().get(i).getRootDirectoryInstall() +
					"\\" +program.getListTagOperatingSystem().get(i).getFolder() + ")" + DOUBLE_BR;
		}
		
		return data;
	}
}
