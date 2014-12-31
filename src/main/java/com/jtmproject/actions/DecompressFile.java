package com.jtmproject.actions;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import com.jtmproject.gui.JLabelProgressInstallation;
import com.jtmproject.user.MessagesUser;

/**
 * This class compress and decompress folders
 * @author Javier Tejedor
 */
public class DecompressFile {

	private boolean run;
	
	/**
	 * this method decompress a directory
	 * @param zipFile
	 * @param folderExtractZipFile
	 * @throws IOException
	 * @thks http://stackoverflow.com/questions/981578/how-to-unzip-files-recursively-in-java
	 */	
	public boolean unzipDirectory(String zipFile){
		
		boolean correct = true;
		run = true;
		
	    int BUFFER = 2048;
	    File file = new File(zipFile);

	    ZipFile zip = null;
		try {
			zip = new ZipFile(file);
		    Enumeration<? extends ZipEntry> zipFileEntries = zip.entries();

		    // Process each entry
		    while (zipFileEntries.hasMoreElements()){
		        // grab a zip file entry
		        ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
		        String currentEntry = entry.getName();
		        
		        JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getUnzipping() + " " + currentEntry);
		        
		        File destFile = new File(new File(zipFile).getParent(), currentEntry);
		        //destFile = new File(newPath, destFile.getName());
		        File destinationParent = destFile.getParentFile();

		        // create the parent directory structure if needed
		        destinationParent.mkdirs();

		        if (!entry.isDirectory()){
		            BufferedInputStream is = new BufferedInputStream(zip.getInputStream(entry));
		            int currentByte;
		            // establish buffer for writing file
		            byte data[] = new byte[BUFFER];

		            // write the current file to disk
		            FileOutputStream fos = new FileOutputStream(destFile);
		            BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);

		            // read and write until last byte is encountered
		            while ((currentByte = is.read(data, 0, BUFFER)) != -1 && run) {
		                dest.write(data, 0, currentByte);
		            }
		            
		            dest.flush();
		            dest.close();
		            is.close();
		            
		        }else{
		        	destFile.mkdirs();
		        }
		    }
		    
		} catch (ZipException e) {
			correct = false;
			e.printStackTrace();
		} catch (IOException e) {
			correct = false;
			e.printStackTrace();
		}
	    
	    try {
			zip.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    if(run == false){
	    	correct = false;
	    }
	    return correct;
	}
	
	/**
	 * this method cancels the decompress
	 */
	public void cancelDecompress(){
		run = false;
	}
}
