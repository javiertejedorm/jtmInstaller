package com.jtmproject.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.jtmproject.gui.JLabelProgressInstallation;
import com.jtmproject.user.MessagesUser;

/**
 * This class contains function to manipulate files
 * @author Javier Tejedor
 */
public class FilesUtils {

	/**
	 * this function moves a file to another directory
	 * @param origin
	 * @param destination
	 * @return
	 */
	public static int moveFile(String origin, String destination){
		try {

			File afile =new File(origin);
			if(afile.renameTo(new File(destination))){
				return 0;
			}

		} catch (Exception e) {
			return -1;
		}

		return 1;
	}

	/**
	 * returns if exist the file passed through path
	 * @param path
	 * @return
	 */
	public static boolean existFile(String path){
		if(new File(path).exists()){
			return true;
		}
		return false;
	}

	/**
	 * this function renames a file
	 * @param origin
	 * @param renamed
	 * @return
	 */
	public static int renameFile(String origin, String renamed){
		try {

			File oldfile =new File(origin);
			File newfile =new File(renamed);

			if(oldfile.renameTo(newfile)){
				return 0;
			}

		} catch (Exception e) {
			return -1;
		}

		return 1;
	}

	/**
	 * this function deletes a file
	 * @param path
	 * @return
	 */
	public static int deleteFile(String path){
		try {

			File file = new File(path);
			if(file.delete()){
				return 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

		return 1;
	}

	/**
	 * this method removes a directory
	 * @param path
	 */
	public static void deleteDirectory(String path){
		File file = new File(path);
		if(file.isDirectory()){

			if(file.list().length == 0){
				file.delete();
			}else{
				String files[] = file.list();

				for (String temp : files) {
					File fileDelete = new File(file, temp);
					deleteDirectory(fileDelete.getAbsolutePath());
				}

				if(file.list().length == 0){
					file.delete();

				}
			}
		}else{
			file.delete();
		}
	}

	/**
	 * this function creates a folder.
	 * @param path
	 * @return
	 */
	 public static int mkDir(String path){

		 JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getCreatingFolders() + " " + path);

		 try {
			 File file = new File(path);
			 if(file.mkdirs()){
				 return 0;
			 }

		 } catch (Exception e) {
			 e.printStackTrace();
			 return -1;
		 }

		 return 1;
	 }

	 /**
	  * this method copies a file
	  * @param file
	  * @param fileToCopy
	  */
	 public static boolean copyFile(File file, File fileToCopy){

		 try {
			 InputStream in = new FileInputStream(file);
			 OutputStream out = new FileOutputStream(fileToCopy); 

			 byte[] buf = new byte[1024];
			 int len;

			 while ((len = in.read(buf)) > 0){

				 out.write(buf, 0, len);

			 }

			 in.close();
			 out.close();

			 return true;

		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 return false;
	 }

	 /**
	  * set a correct extension for jtm files
	  * @param path
	  * @return
	  */
	 public static File setExtensionJtm(File path){
		 String analize = path.getAbsolutePath();
		 boolean correctString = false;
		 //remove all .jtm extensions. Can be fichero1.jtm.jtm
		 while(!correctString){
			 if(analize.substring(analize.length() - 4, analize.length()).equals(".jtm")){
				 analize = analize.substring(0, analize.length() - 4);
			 }else{
				 correctString = true;
			 }
		 }
		 return new File(analize + ".jtm");
	 }
}
