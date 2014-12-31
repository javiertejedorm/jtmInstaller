package com.jtmproject.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.jtmproject.actions.CoreDownloadOpenJtm;
import com.jtmproject.gui.AnimationSearching;
import com.jtmproject.gui.ButtonSearch;

public class SearchFavorites implements Runnable{

	private Connection connection;
	private CoreDownloadOpenJtm coreDownloadOpenJtm;
	private List<String> listUrls = null;
	private boolean stopSearch;
	
	/**
	 * constructor
	 * @param textToFind
	 */
	public SearchFavorites(){
		this.stopSearch = false;
		connection = new Connection();
		listUrls = new ArrayList<String>();
		new Thread(this).start();
	}

	/**
	 * this method stops the thread
	 */
	public void cancelSearch(){
		connection.closeConnection();
		
		if(coreDownloadOpenJtm != null){
			coreDownloadOpenJtm.stopActions();
		}

		stopSearch = true;
	}

	/**
	 * lists the urls of the favorites jtm
	 * @return
	 */
	public List<String> listUrlJtmFavorites(){
		
		String user = LoginUser.getLu().getEmail();
		String password = LoginUser.getLu().getPassword();
		
		ArrayList<NameValuePair> post = new ArrayList<NameValuePair>();

		post.add(new BasicNameValuePair(ServerConstants.getSc().getEmail(), user));
		post.add(new BasicNameValuePair(ServerConstants.getSc().getPassword(), password));

		String serverData = connection.getServerData(post, ServerConstants.getSc().getUserFavorites());
		ButtonSearch.setStateButton(ButtonSearch.STATE_CAN_CANCEL);
		
		if(serverData != null){
			
			return DataJSON.getArrayDataJson(serverData, ServerConstants.getSc().getUrlJtm());
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
		listUrls = listUrlJtmFavorites();
		System.out.println(listUrls);
		if(listUrls == null || listUrls.get(0).equals("-1")){
			AnimationSearching.setAnimationSearching(false);
		}else{
			if(!stopSearch){
				coreDownloadOpenJtm = new CoreDownloadOpenJtm(listUrls);
			}
		}
	}

}
