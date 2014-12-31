package com.jtmproject.actions;

import java.io.File;

import com.jtmproject.user.GeneralPaths;

/**
 * this class cleans the temporary file if is called
 * @author Javier Tejedor
 */
public class CleanTemporaryFolder {

	/**
	 * constructor
	 */
	public CleanTemporaryFolder(){
		clean();
	}
	
	/**
	 * this method clean the temporary folder
	 */
	private void clean(){
		File directoryTemporalFiles = new File(GeneralPaths.getGp().getPathJtms());
		if(directoryTemporalFiles.exists()){
			for(File file: directoryTemporalFiles.listFiles()){
				file.delete();
			}
		}
	}
}
