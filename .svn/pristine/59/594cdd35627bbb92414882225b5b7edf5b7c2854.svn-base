package com.jtmproject.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.jtmproject.actions.CoreDownloadOpenJtm;
import com.jtmproject.gui.AnimationSearching;
import com.jtmproject.gui.ButtonSearch;

/**
 * This class search programs
 * @author Javier Tejedor
 */
public class SearchPrograms implements Runnable{

	private String textToFind;
	private Connection connection;
	private List<String> listUrls = null;
	private CoreDownloadOpenJtm coreDownloadOpenJtm;
	private Thread thread;
	private boolean stopSearch;
	
	/**
	 * constructor
	 * @param textToFind
	 */
	public SearchPrograms(String textToFind){
		this.stopSearch = false;
		connection = new Connection();
		this.textToFind = textToFind;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * this method stops the thread
	 */
	public void stopSearch(){
		connection.closeConnection();
		
		if(coreDownloadOpenJtm != null){
			coreDownloadOpenJtm.stopActions();
		}

		stopSearch = true;
	}

	/**
	 * checks if the user is registered
	 * @param user
	 * @param password
	 * @param storePersistant
	 * @return
	 */
	public List<String> listUrlJTM(){
		
		ArrayList<NameValuePair> post = new ArrayList<NameValuePair>();

		post.add(new BasicNameValuePair(ServerConstants.getSc().getWordSearch(), textToFind));
		String serverData = connection.getServerData(post, ServerConstants.getSc().getSearchJTMUrl());
		ButtonSearch.setStateButton(ButtonSearch.STATE_CAN_CANCEL);
		if(serverData != null){

			return DataJSON.getArrayDataJson(serverData, "url_jtm");
		}

		return null;

	}

	/**
	 * returns the list of the urls
	 * @return
	 */
	public List<String> getListUrls() {
		return listUrls;
	}

	@Override
	public void run() {
		listUrls = listUrlJTM();
		if(listUrls == null || listUrls.get(0).equals("-1")){
			AnimationSearching.setAnimationSearching(false);
			ButtonSearch.setStateButton(ButtonSearch.STATE_CAN_SEARCH);
		}else{
			if(!stopSearch){
				coreDownloadOpenJtm = new CoreDownloadOpenJtm(listUrls);
			}
		}
	}
}
