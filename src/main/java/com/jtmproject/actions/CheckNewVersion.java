package com.jtmproject.actions;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.http.NameValuePair;

import com.jtmproject.gui.MainWindowJFrame;
import com.jtmproject.gui.MessageDialog;
import com.jtmproject.server.Connection;
import com.jtmproject.server.DataJSON;
import com.jtmproject.server.ServerConstants;
import com.jtmproject.user.MessagesUser;

/**
 * this class looks for a new version available
 * @author Javier Tejedor
 */
public class CheckNewVersion implements Runnable{

	private Connection connection;
	private boolean replayCorrectVersion;
	
	/**
	 * constructor
	 */
	public CheckNewVersion(boolean replayCorrectVersion){
		connection = new Connection();
		this.replayCorrectVersion = replayCorrectVersion;
		new Thread(this).start();
	}

	@Override
	public void run() {
		String currentVersion = MessagesUser.getMU().getVersionJtmInstaller();
		String newVersion = getVersionSinceServer(ServerConstants.getSc().getReplay());
		if(newVersion != null){
			if(!currentVersion.equals(newVersion)){
				String getUrlNewVersion = getVersionSinceServer(ServerConstants.getSc().getUrlDownload());
				int resp = MessageDialog.messageDialogQuestion(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getNewVersionAvailable());
				if(resp == JOptionPane.YES_OPTION){
					try {
						Desktop.getDesktop().browse(new URI(getUrlNewVersion));
					} catch (IOException e) {
						e.printStackTrace();
					} catch (URISyntaxException e) {
						e.printStackTrace();
					}
				}
			}else if(replayCorrectVersion){
				replayAllCorrect();
			}
		}
	}
	
	/**
	 * message: the version is correct
	 */
	private void replayAllCorrect(){
		MessageDialog.messageDialogInformation(MainWindowJFrame.getjFrame(), MessagesUser.getMU().getVersionCorrect());
	}
	
	/**
	 * lists the urls of the Public Serves
	 * @return
	 */
	public String getVersionSinceServer(String key){
		ArrayList<NameValuePair> post = new ArrayList<NameValuePair>();
		String serverData = connection.getServerData(post, ServerConstants.getSc().getVersionUrl());
		if(serverData != null){
			return DataJSON.getReply(serverData, key);
		}else{
			return null;
		}
	}
}
