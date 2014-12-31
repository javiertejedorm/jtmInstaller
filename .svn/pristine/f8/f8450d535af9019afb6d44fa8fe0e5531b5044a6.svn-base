package com.jtmproject.actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.jtmproject.server.ServerUrls;
import com.jtmproject.user.GeneralPaths;

/**
 * this class downloads a JTM
 * @author Javier Tejedor
 */
public class DownloadJTM {

	private List<String> listUrlsJtm;
	private List<String> pathDownloadJtm;
	private Download download;

	/**
	 * constructor
	 * @param jFrame
	 * @param listUrlsJTM
	 */
	public DownloadJTM(List<String> listUrlsJTM){
		this.listUrlsJtm = new ArrayList<String>();
		this.listUrlsJtm.clear();
		this.listUrlsJtm.addAll(listUrlsJTM);

		this.pathDownloadJtm = new ArrayList<String>();
		this.pathDownloadJtm.clear();

		manageDownload();
	}

	/**
	 * this manage the download and creating a list
	 */
	public void manageDownload() {
		int size = listUrlsJtm.size();

		for(int i = 0; i < size; i++){
			pathDownloadJtm.add(checkFileForDownloading(listUrlsJtm.get(i)));
		}
	}

	/**
	 * this function download a file and returns the path where saved the file into the computer
	 * @param url
	 * @return
	 */
	private String checkFileForDownloading(String url){
		url = ServerUrls.getSip().getUrlJtm() + url.replace(" ", "%20");
		String name = StringUtils.getNameFileThroughUrl(url.replace("%20", " "));
		String pathFolderJtm = GeneralPaths.getGp().getPathJtms();

		if(!new File(pathFolderJtm + "\\" + name).exists()){
			download(url, name, pathFolderJtm);
		}

		return pathFolderJtm + "\\" + name;
	}

	/**
	 * this method downloads a jtm
	 * @param url
	 * @param name
	 * @param pathFolderJtm
	 */
	private void download(String url, String name, String pathFolderJtm) {
		download = new Download(url, pathFolderJtm, name); 
		download.downloadFile();
	}
	
	/**
	 * this stops the download
	 */
	public void stopActions(){
		if(download != null){
			download.cancelDownload();
		}
	}

	/**
	 * this function returns the list of the jtm's paths downloaded
	 * @return
	 */
	public List<String> getPathDownloadJtm() {
		return pathDownloadJtm;
	}
}
