package com.jtmproject.actions;

import java.math.BigDecimal;

/**
 * this class has a functions for process strings
 * @author generis
 */
public class StringUtils {

	/**
	 * returns a correct path
	 * @param str
	 * @return
	 */
	public static String correctPathForCreateShorcutProgram(String str){
		//for path like: C:\\\\archivos\\directorio
		str = str.replace("\\\\", "\\");
		return str;
	}
	
	/**
	 * removes the invalid characters in the path
	 * @param str
	 * @return
	 */
	public static String removeInvalidCharacters(String str){
		if(str.charAt(str.length() - 1) == '\\'){
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}
	
	/**
	 * returns a correct path
	 * @param str
	 * @return
	 */
	public static String correctPath(String str){
		str = StringUtils.correctPathForCreateShorcutProgram(str);
		str = StringUtils.removeInvalidCharacters(str);
		return str;
	}
	
	/**
	 * returns the extension of the path passed by parameters.
	 * @param path
	 * @return
	 */
	public static String getExtension(String path){
		String extension = "";

		int i = path.lastIndexOf('.');
		if (i > 0) {
		    extension = path.substring(i+1);
		}
		return extension;
	}
	
	/**
	 * removes the decimals
	 * @param size
	 * @return
	 */
	public static String sizeWithoutDecimals(String size){
		float sizeProgram = Float.parseFloat(size);
		int integerSize = (int)sizeProgram / 1024;
		return String.valueOf(integerSize);
	}
	
	/**
	 * returns the name of the file
	 * @param url
	 * @return
	 */
	public static String getNameFileThroughUrl(String url){
		int i = url.lastIndexOf("/");
		return url.substring(i + 1);
	}
	
	/**
	 * returns a correct url, replacing the spaces with %20
	 * @param url
	 * @return
	 */
	public static String replaceSpacesUrl(String url){
		return url.replace(" ", "%20");
	}
	
	/**
	 * filters an IP
	 * @param ip
	 * @return
	 */
	public static String filterIp(String ip){
		if(!ip.startsWith("http://")){
			ip = "http://" + ip;
		}
		
		if(ip.endsWith("/")){
			ip = ip.substring(0, ip.length() - 1);
		}

		return ip;
	}
	
	/**
	 * this function converts the size for show to the user
	 * @param sizeProject
	 * @return
	 */
	public static String convertSizeFile(String sizeProject){
		
		float size = Float.parseFloat(sizeProject);
		
		float sizeKB = size / 1024;
		if(sizeKB < 1000){
			//kilobytes
			return String.valueOf(round(sizeKB, 2)) + " KB";
		}
		
		float sizeMB = sizeKB / 1024;
		if(sizeMB < 1000){
			return String.valueOf(round(sizeMB, 2)) + " MB";
		}
		
		//gigabytes
		return String.valueOf(round((sizeMB / 1024), 2)) + " GB";
		
	}
	
	/**
     * Round to certain number of decimals
     * 
     * @param d
     * @param decimalPlace
     * @return
     */
    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
