package com.jtmproject.server;

/**
 * This class stores the constants for communicating with the server
 * @author Javier Tejedor
 */
public class ServerConstants {
	
	public static ServerConstants sc;
		
	/**
	 * this function returns an instance of ServerConstants (Singleton Class)
	 * @return
	 */
	public static ServerConstants getSc(){
		if(sc == null){
			sc = new ServerConstants();
		}
		return sc;
	}
	
	public String getOfficialJtmPlaceUrl(){
		return "http://www.jtmplace.com/";
	}

	/**
	 * this function returns a POST of email 
	 * @return
	 */
	public String getEmail() {
		return "email";
	}

	/**
	 * this function returns a POST of password
	 * @return
	 */
	public String getPassword() {
		return "password";
	}
	
	/**
	 * returns a JSON's key of url_jtm
	 * @return
	 */
	public String getUrlJtm(){
		return "url_jtm";
	}
	
	/**
	 * returns a JSON's key of public_servers
	 * @return
	 */
	public String getPublicServers(){
		return "public_server";
	}
	
	/**
	 * returns a POST of palabra_clave
	 * @return
	 */
	public String getWordSearch(){
		return "word_to_search";
	}
	
	/**
	 * return a JSON's key of url_download
	 * @return
	 */
	public String getUrlDownload(){
		return "url_download";
	}
	
	/**
	 * returns a POST of check_servidor
	 * @return
	 */
	public String getCheckServer(){
		return "check_server";
	}

	/**
	 * this function returns an URL for doing the login
	 * @return
	 */
	public String getLoginUrl() {
		return ServerUrls.getSip().getIpStore() + "/php/jtmInstaller/jtminstaller_login_user.php";
	}
	
	/**
	 * this function returns an URL for searching a JTM  
	 * @return
	 */
	public String getSearchJTMUrl(){
		return ServerUrls.getSip().getIpStore() + "/php/jtmInstaller/jtminstaller_search_program.php";
	}
	
	/**
	 * this url returns the version and the url to download it.
	 * @return
	 */
	public String getVersionUrl(){
		return ServerUrls.getSip().getIpStore() + "/php/jtmInstaller/jtminstaller_getversion.php";
	}
	
	/**
	 * returns the url for checking if the server is OK.
	 * @return
	 */
	public String getCheckServerOkUrl(){
		return ServerUrls.getSip().getIpStore() + "/php/jtmInstaller/jtminstaller_check_server.php";
	}
	
	/**
	 * returns the url for get the jtms favorites.
	 * @return
	 */
	public String getUserFavorites(){
		return ServerUrls.getSip().getIpStore() + "/php/jtmInstaller/jtminstaller_get_favorites.php";
	}
	
	/**
	 * returns the urls for get the public servers
	 */
	public String getPublicServersUrl(){
		return  "http://www.jtmplace.com/teje/php/jtmInstaller/jtminstaller_get_public_server.php";
	}
	
	/**
	 * this function returns a GET "OK"
	 * @return
	 */
	public String getOK(){
		return "OK";
	}
	
	/**
	 * returns a GET "NO_FAVORITOS"
	 * @return
	 */
	public String getWithoutFavorites(){
		return "NO_FAVORITOS";
	}
	
	/**
	 * returns a GET "NO_PUBLIC_SERVERS"
	 * @return
	 */
	public String getNotPublicServersUrls(){
		return "NO_PUBLIC_SERVERS";
	}
	
	/**
	 * this function returns a POST "replay"
	 * @return
	 */
	public String getReplay(){
		return "reply";
	}
	
	/**
	 *  this function returns a POST "comments"
	 */
	public String getComments(){
		return "comments";
	}
}
