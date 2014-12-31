package com.jtmproject.actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.jtmproject.server.CheckCorrectServer;
import com.jtmproject.user.ErrorCode;
import com.jtmproject.user.UserProperties;

/**
 * This class makes a specifics checks into the system
 * @author Javier Tejedor
 */
public class Checks {
	
	private static int tries = 0;
	
	/**
	 * checks if there is Internet connection.
	 * @author http://sandromiccoli.com/en/2013/01/17/verificar-se-existe-conexao-com-a-internet-java/ & Javier Tejedor
	 * @return
	 */
	public static boolean isInternetReachable(){
		try {
			URL url = null;
			switch (tries) { //not tested!!!!!!!!
			case 0:
				url = new URL("http://www.google.com");
				break;
			case 1:
				url = new URL("http://www.wikipedia.org/");
				break;
			case 2:
				url = new URL("http://www.youtube.com/");
				break;
			default:
				break;
			}
			
			HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

			urlConnect.getContent();

		}catch (IOException e) {
			tries++;
			isInternetReachable();
			
		}finally{
			if(tries == 3){
				LaunchError.lauchErrorMessage(ErrorCode.NOT_INTERNET_CONNECTION, null);
				tries = 0;
				return false;
			}
		}
		tries = 0;
        
		return true;
	}
	
	/**
	 * checks if is possible to connect with the server
	 * @return
	 */
	public static boolean isConnectServerPossible(){
		if(Checks.isInternetReachable()){
			if(CheckCorrectServer.isChecked()){
				return true;
			}

			CheckCorrectServer checkCorrectServer = new CheckCorrectServer("1234");
			new Thread(checkCorrectServer).run();

			if(checkCorrectServer.isCheckCorrect()){
				UserProperties.getUp().writeProperties();
				return true;
			}
		}

		return false;
	}
}
