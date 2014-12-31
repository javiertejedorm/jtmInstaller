package com.jtmproject.actions;

import java.util.List;

import com.jtmproject.gui.AnimationSearching;
import com.jtmproject.gui.ButtonSearch;

/**
 * this class manages the jtm downloads and opens 
 * @author Javier Tejedor
 */
public class CoreDownloadOpenJtm implements Runnable{

	private List<String> listUrlsJTM;
	private DownloadJTM downloadJTM;
	private boolean run;
	
	/**
	 * constructor
	 * @param jFrame
	 * @param listUrlsJTM
	 */
	public CoreDownloadOpenJtm(List<String> listUrlsJTM) {
		this.listUrlsJTM = listUrlsJTM;
		this.run = true;
		new Thread(this).start();
	}
	
	/**
	 * this method stops all the actions
	 */
	public void stopActions(){
		if(downloadJTM != null){
			downloadJTM.stopActions();
		}
		run = false;
	}
	
	@Override
	public void run() {
		downloadJTM = new DownloadJTM(listUrlsJTM);
		OpenJTM op = new OpenJTM();
		int size = downloadJTM.getPathDownloadJtm().size();
		int contFails = 0;
		int i = 0;
		
		while(i < size && run){
			String path = downloadJTM.getPathDownloadJtm().get(i);
			if(!op.open(path)){
				contFails++;
			}
			i++;
		}
		
		if(contFails > 0){
			errorOpenAnyFile();
		}
		
		AnimationSearching.setAnimationSearching(false);
		ButtonSearch.setStateButton(ButtonSearch.STATE_CAN_SEARCH);
	}
	
	/**
	 * this checks the version. Maybe the jtm contains new Tags
	 */
	private void errorOpenAnyFile(){
		new ErrorOpenJtm();
	}
	
}
