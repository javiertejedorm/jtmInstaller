package com.jtmproject.actions;

import com.jtmproject.install.AddAppPathsRegistry;
import com.jtmproject.install.AddExtensionSupported;
import com.jtmproject.install.AddMenuPrograms;
import com.jtmproject.install.AddUninstallRegistry;
import com.jtmproject.install.AddWindowsStartup;
import com.jtmproject.install.DesktopShortcuts;
import com.jtmproject.install.DownloadJTX;
import com.jtmproject.install.PathInstallProgram;
import com.jtmproject.task.Program;
import com.jtmproject.user.ErrorCode;

/**
 * This class does the management of tasks.   
 * @author Javier Tejedor
 */
public class Installer{

	private Program program;
	private int retCode;
	private boolean run;
	private static boolean isInstalling = false;
	
	private DownloadJTX downloadJTX;
	private DecompressFile decompressFile;
	
	/**
	 * constructor
	 * @param jFrame
	 * @param program
	 */
	public Installer(Program program){
		this.program = program;
		run = true;
	}
	
	/**
	 * this method cancels the install
	 */
	public void cancelInstallation(){
		run = false;
		
		if(downloadJTX != null){
			downloadJTX.cancelDownload();
		}
		
		if(decompressFile != null){
			decompressFile.cancelDecompress();
		}
	}


	/**
	 * In this method the program is installed
	 */
	public void install(){
		isInstalling = true;
		int errorCode = ErrorCode.OK;
		
		long startTime = System.nanoTime();

		String pathInstallProgram = PathInstallProgram.getRootPathInstallProgram(program);

		if(!pathInstallProgram.equals("") && run){
			FilesUtils.mkDir(pathInstallProgram);
			
			downloadJTX = new DownloadJTX();
			
			if(downloadJTX.download(program) && run){

				String pathDestination = pathInstallProgram + program.getTagDownload().getFolder();
				String nameFile = program.getTagDownload().getFilename();

				decompressFile = new DecompressFile();
				
				if(decompressFile.unzipDirectory(pathDestination + nameFile) && run){
					FilesUtils.deleteFile(pathDestination + nameFile);
					
					if(program.getTagAddShortcutDesktop() != null && run){
						new DesktopShortcuts().createShortcutDesktop(program);
					}

					if(program.getTagAddStartup() != null && run){
						new AddWindowsStartup().addStartup(program);
					}

					if(program.getTagAddProgramsMenus() != null && run){
						new AddMenuPrograms().addMenuPrograms(program);
					}

					if(!program.getTagProject().getExecutableFile().equals(" ") && run){
						new AddAppPathsRegistry().addAppPaths(program);
					}

					if(!program.getTagProject().getUninstallFile().equals(" ") && run){
						new AddUninstallRegistry().addUninstaller(program);
					}

					if(!program.getListTagExtensionsSupported().isEmpty() && run){
						new AddExtensionSupported().addExtensions(program);
					}
					
				}else{
					errorCode = ErrorCode.DECOMPRESS_ERROR;
				}
			}else{
				errorCode = ErrorCode.DOWNLOAD_ERROR;
			}
		}else{
			errorCode = ErrorCode.FIND_PATH_ERROR;
		}
		
		long endTime = System.nanoTime();
		System.out.println("TIEMPO INSTALACIÓN TOTAL: Error:" +errorCode+"  " + ((endTime - startTime)/ 1000000000.0));

		retCode = errorCode;
		isInstalling = false;
				
		System.out.println("INSTALACIÓN EN CURSO - " + run);
	}
	
	/**
	 * this function returns the errorCode
	 * @return
	 */
	public int getRetCode() {
		return retCode;
	}

	/**
	 * returns if there are some installations on course.
	 * @return
	 */
	public static boolean isInstalling() {
		return isInstalling;
	}

	/**
	 * return if the install has been cancelled.
	 * @return
	 */
	public boolean isRun() {
		return run;
	}
}

