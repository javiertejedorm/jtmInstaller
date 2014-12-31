package com.jtmproject.support;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * This class does a filter of files. Only shows the jtm files
 * @author Javier Tejedor
 */
public class TextFilter extends FileFilter {

	/**
	 * files accept
	 * @param f
	 * @return
	 */
	public boolean accept(File f) {
		if (f.isDirectory()){
			return true;
		}

		String fileName = f.getName();
		if(fileName.length() >= 4){
			//extract the extension and compare with .jtm
			if(fileName.substring(fileName.length() - 4, fileName.length()).equals(".jtm")){
				return true;
			}
		}
		return false;
	}

	/**
	 * description in the JFileChooser
	 * @return
	 */
	public String getDescription() {
		return "Accepts .jtm files only.";
	}
}
