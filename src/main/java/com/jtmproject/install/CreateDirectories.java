package com.jtmproject.install;

import java.io.File;
import java.util.ArrayList;

/**
 * This class creates the folders
 * @author Javier Tejedor
 */
public class CreateDirectories {
	
	/**
	 * this method create the folders
	 * @param path
	 * @param folders
	 * @return
	 */
	public boolean createFolders(String rootpath, ArrayList<String> folders){
		int size = folders.size();
		for(int i = 0; i < size; i++){
			if(!new File(rootpath + folders.get(i)).mkdirs()){
				return false;
			}
		}
		return true;
	}
}
