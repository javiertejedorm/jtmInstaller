package com.jtmproject.install;

import java.io.File;

/**
 * This class compares free space on hard drive with the size of the project
 * @author Javier Tejedor
 */
public class CompareHardDiskSpace {

	/**
	 * compare the free space
	 * @param sizeOfProgram
	 * @param unit
	 * @return
	 */
	public boolean correctSpaceInHardDisk(double sizeOfProgram, String unit){
		File file = new File(unit);
		if(file.getFreeSpace() > sizeOfProgram){
			return true;
		}
		return false;
	}
}
