package com.jtmproject.install;

import com.jtmproject.actions.Download;
import com.jtmproject.actions.StringUtils;
import com.jtmproject.gui.JLabelProgressInstallation;
import com.jtmproject.task.Program;
import com.jtmproject.user.MessagesUser;

/**
 * this class does the downloads
 * @author Javier Tejedor
 */
public class DownloadJTX {
	
	private Download download;

	/**
	 * this cancels the download
	 */
	public void cancelDownload(){
		if(download != null){
			download.cancelDownload();
		}
	}
	
	/**
	 * this downloads the program
	 * @param program
	 */
	public boolean download(Program program){
		boolean run = true;
		boolean downloadOK = false;

		String urlDownload = StringUtils.replaceSpacesUrl(program.getTagDownload().getUrl());
		String pathDestination = PathInstallProgram.getRootPathInstallProgram(program) + program.getTagDownload().getFolder();
		String nameFile = program.getTagDownload().getFilename();

		JLabelProgressInstallation.getJlbPI().setText(MessagesUser.getMU().getDownloading() + " " + urlDownload);
		
		while(run){

			int attempt = 0;
			downloadOK = false;
			//3 attempt for download the file
			download = new Download(urlDownload, pathDestination, nameFile, program);
			while(!downloadOK && attempt < 3){
				if(!download.downloadFile()){
					attempt++;
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					downloadOK = true;
					run = false;
				}

				if(attempt == 3){
					run = false;
				}
			}
		}
		return downloadOK;
	}
}

