package com.jtmproject.actions;

import java.util.ArrayList;

import com.jtmproject.install.CompareHardDiskSpace;
import com.jtmproject.install.CompareOS;
import com.jtmproject.task.Program;
import com.jtmproject.user.ErrorCode;

/**
 * This class does the previous checks before install a program
 * @author Javier Tejedor
 */
public class PreviousChecks {

	private Program program;
	
	/**
	 * consctructor
	 * @param indexProgram
	 */
	public PreviousChecks(Program program){
		this.program = program; 
	}
	
	/**
	 * Does the checks
	 * @return
	 */
	public int previousCheck(){
		if(!compareOs()){
			return ErrorCode.COMPARE_OS_ERROR;
		}
		
		if(!isFreeSpaceHardDrive()){
			return ErrorCode.FREE_SPACE_ERROR;
		}
		
		return 0;
	}
	
	/**
	 * returns if there is free space in hard drive for install the program
	 * @return
	 */
	private boolean isFreeSpaceHardDrive(){
		return new CompareHardDiskSpace().correctSpaceInHardDisk(Double.parseDouble(program.getTagProject().getSize()), GetPathsOS.getLetterWindows());
	}
	
	/**
	 * this function returns if the OS is supported or not.
	 * @return
	 */
	private boolean compareOs(){
		return new CompareOS().operatingSystemCorrect(osSupported());
	}
	
	/**
	 * returns the list of Operating System supported
	 * @return
	 */
	private ArrayList<String> osSupported(){
		ArrayList<String> osSupportedList = new ArrayList<String>();
		osSupportedList.clear();

		int size = program.getListTagOperatingSystem().size();
		for(int i = 0; i < size; i++){
			osSupportedList.add(program.getListTagOperatingSystem().get(i).getNameOfOperatingSystem());
		}
		return osSupportedList;
	}
}
