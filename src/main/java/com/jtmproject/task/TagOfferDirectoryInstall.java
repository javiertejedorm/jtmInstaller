package com.jtmproject.task;

/**
 * This class stores if the user can to choose the folder for install the program
 * @author Javier Tejedor
 */
public class TagOfferDirectoryInstall {

	public boolean canChooseFolder;

	/**
	 * constructor
	 * @param canChooseFolder
	 */
	public TagOfferDirectoryInstall(boolean canChooseFolder) {
		this.canChooseFolder = canChooseFolder;
	}

	/**
	 * this function returns if the user could choose directory for install
	 * @return
	 */
	public boolean isCanChooseFolder() {
		return canChooseFolder;
	}
}
