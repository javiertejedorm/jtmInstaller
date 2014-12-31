package com.jtmproject.install;

import java.io.File;
import java.io.IOException;

/**
 * This class executes a binary file, normally a Executable File
 * @author Javier Tejedor
 */
public class RunProgram {

	/**
	 * Constructor
	 * @param filePathToExecute
	 * @thanks http://stackoverflow.com/questions/10685893/run-exe-file-from-java-from-file-location
	 */
	public RunProgram(String filePathToExecute){
        try {
        	System.out.println(new File(filePathToExecute).getParentFile());
        	ProcessBuilder processBuilder = new ProcessBuilder(filePathToExecute);
        	processBuilder.directory(new File(filePathToExecute).getParentFile());
        	processBuilder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
