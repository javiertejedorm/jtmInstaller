package com.jtmproject.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.jtmproject.task.ListOfPrograms;
import com.jtmproject.task.Program;

/**
 * This class analyzes if is correct the security_key
 * @author Javier Tejedor
 */
public class AnalyzeKeySecurity {

	//this is a password which generates the key. In the future this have to be in a file 
	private final static String PASSWORD = "oneoneone";

	private static AnalyzeKeySecurity aks;

	/**
	 * returns an instance of AnalyzeKeySecurity (Singleton Class)
	 * @return
	 */
	public static AnalyzeKeySecurity getAks() {
		if(aks == null){
			aks = new AnalyzeKeySecurity();
		}
		return aks;
	}

	/**
	 * Analyze the key
	 * @param filePath
	 * @return
	 */
	public boolean analyze(String filePath){
		File fileJtm = new File(filePath);

		if(fileJtm.exists()){
			if(removeTagKey(fileJtm)){
				return true;
			}
		}
		return false;
	}

	/**
	 * this function removes the tag <security_key> and call for analyze the key
	 * @return
	 */
	private boolean removeTagKey(File fileJtm){
		String openTagAnalyzeKey = "<security_key>";
		String closeTagAnalyzeKey = "</security_key>";
		String contentFile = readFile(fileJtm);
		if(!contentFile.equals("") && contentFile.contains(openTagAnalyzeKey) && contentFile.contains(closeTagAnalyzeKey)){

			contentFile = removeSpecialCharacters(contentFile); 
			int begins = contentFile.indexOf(openTagAnalyzeKey);
			int finalize = contentFile.indexOf(closeTagAnalyzeKey) + closeTagAnalyzeKey.length(); 
			String start = contentFile.substring(0, begins);
			String finals = contentFile.substring(finalize, contentFile.length());
			contentFile = start + finals;

			if(analyzeKey(contentFile)){
				return true;
			}
		}

		return false;
	}

	/**
	 * this function analyzes both, if the key is correct or if the text has been modified
	 * @param textWithoutTagKeySecurity
	 * @return
	 */
	private boolean analyzeKey(String textWithoutTagKeySecurity){
		int lastItem = ListOfPrograms.getLop().getListPrograms().size() - 1;
		Program program = ListOfPrograms.getLop().getListPrograms().get(lastItem);
		if(SHA1Security.generateSHA1(textWithoutTagKeySecurity, PASSWORD).equals(program.getTagSecurityKey().getKey())){
			return true;
		}
		return false;
	}

	/**
	 * removes "special" characters
	 * @param str
	 * @return
	 */
	private String removeSpecialCharacters(String str){
		str = str.replace("\n", "");
		str = str.replace("\t", "");
		str = str.replace(" ", "");
		return str;
	}

	/**
	 * this function returns the content of a file
	 * @param file
	 * @return
	 */
	private String readFile(File file){
		String content = "";
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file.getAbsolutePath()));

			while ((sCurrentLine = br.readLine()) != null) {
				content += sCurrentLine;
			}

		} catch (IOException e) {
			content = "";
			e.printStackTrace();
		} finally {

			try {
				if (br != null)br.close();
			} catch (IOException ex) {

				ex.printStackTrace();
			}
		}
		return content;
	}
}
