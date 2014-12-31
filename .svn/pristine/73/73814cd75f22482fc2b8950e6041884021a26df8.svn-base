package com.jtmproject.server;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.apache.http.NameValuePair;

import com.jtmproject.gui.AnimationSearching;
import com.jtmproject.gui.ListPublicServerGUI;
import com.jtmproject.gui.MainWindowJFrame;
import com.jtmproject.gui.MessageDialog;
import com.jtmproject.user.MessagesUser;

/**
 * This class searches Publics Servers
 * @author Javier Tejedor
 */
public class SearchPublicServer implements Runnable{
	
	private Connection connection;
	private List<String> listUrls = null;
	private JFrame jFrame;
	private String serverSelected;
	

	/**
	 * constructor
	 * @param jFrame
	 */
	public SearchPublicServer(JFrame jFrame){
		this.jFrame = jFrame;
		connection = new Connection();
		new Thread(this).start();
	}


	/**
	 * lists the urls of the Public Serves
	 * @return
	 */
	public List<String> listPublicServers(){
		
		ArrayList<NameValuePair> post = new ArrayList<NameValuePair>();
		String serverData = connection.getServerData(post, ServerConstants.getSc().getPublicServersUrl());
		if(serverData != null){
			
			if(DataJSON.getReply(serverData, ServerConstants.getSc().getReplay()).equals(ServerConstants.getSc().getNotPublicServersUrls())){
				return null;
			}
			
			return DataJSON.getArrayDataJson(serverData, ServerConstants.getSc().getPublicServers());
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		listUrls = listPublicServers();
		AnimationSearching.setAnimationSearching(false);
		if(listUrls != null){
			ListPublicServerGUI lpsg = new ListPublicServerGUI(jFrame, listUrls);
			if(lpsg.getServerSelected() != null){
				ServerUrls.getSip().setIpStore(lpsg.getServerSelected());
				MessageDialog.messageDialogGeneral(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getConnectedTo() + ": " + lpsg.getServerSelected());
			}
		}else{
			MessageDialog.messageDialogGeneral(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getPublicServerListNotFound());
		}
	}

	/**
	 * returns the servers selected
	 * @return
	 */
	public String getServerSelected() {
		return serverSelected;
	}
	
	/**
	 * returns the list of the urls
	 * @return
	 */
	public List<String> getListUrls() {
		return listUrls;
	}
}
