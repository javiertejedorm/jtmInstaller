package com.jtmproject.actions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.jtmproject.gui.BarInstall;
import com.jtmproject.task.Program;

/**
 * This class downloads files
 * @author Javier Tejedor
 */
public class Download {

	private int codeDownload = -1;
	private String urlDownload;
	private String pathDestination;
	private String nameFile;
	private Program program;
	private boolean run;

	/**
	 * constructor for download a jtx
	 * @param urlDownload
	 * @param pathDestination
	 * @param nameFile
	 * @param program
	 */
	public Download(String urlDownload, String pathDestination, String nameFile, Program program) {
		this.urlDownload = urlDownload;
		this.pathDestination = pathDestination;
		this.nameFile = nameFile;
		this.program = program;
	}

	/**
	 * constructor for download a file
	 * @param urlDownload
	 * @param pathDestination
	 * @param nameFile
	 */
	public Download(String urlDownload, String pathDestination, String nameFile) {
		this.urlDownload = urlDownload;
		this.pathDestination = pathDestination;
		this.nameFile = nameFile;
		this.program = null;
	}

	/**
	 * Download a file.
	 * @param urlDownload
	 * @param pathDestination
	 * @param nameFile
	 * @param program
	 * @return
	 */
	public boolean downloadFile(){
		if(Checks.isInternetReachable()){
			try{
				run = true;
				long startTime = System.currentTimeMillis();

				URL url = new URL(urlDownload);
				url.openConnection();
				InputStream reader = url.openStream();
				FileOutputStream writer = new FileOutputStream(pathDestination + "\\" + nameFile);

				byte[] buffer = new byte[2048];
				int totalBytesRead = 0;
				int bytesRead = 0;

				if(program != null){
					BarInstall.getBarInstall().setMaximum((int)Double.parseDouble(program.getTagDownload().getSize()));
				}

				while ((bytesRead = reader.read(buffer)) > 0 && run){  
					writer.write(buffer, 0, bytesRead);
					totalBytesRead += bytesRead;

					if(program != null){
						BarInstall.getBarInstall().setValue(totalBytesRead);
					}
				}

				long endTime = System.currentTimeMillis();

				System.out.println("TIEMPO DE DESCARGA: " + ((endTime - startTime) / 1000.0));

				writer.close();
				reader.close();

				codeDownload = 0;

				return true;

			}catch (MalformedURLException e){
				e.printStackTrace();
				codeDownload = -1;

			}catch (IOException e){
				e.printStackTrace();
				codeDownload = -2;
			}
		}

		return false;
	}


	/**
	 * this method cancel the download
	 */
	public void cancelDownload() {
		run = false;
	}

	/**
	 * returns the code of download
	 * @return
	 */
	public int getCodeDownload() {
		return codeDownload;
	}
}
