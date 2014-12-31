package com.jtmproject.install;

import java.util.ArrayList;

import com.jtmproject.actions.OperatingSystem;

/**
 * This class compare the current Operating System installed with the Operatings Systems supported by the program
 * @author Javier Tejedor
 */
public class CompareOS {

	/**
	 * compares both Operating Systems
	 * @param os
	 * @return
	 */
	public boolean operatingSystemCorrect(ArrayList<String> os){
		int size = os.size();
		for(int i = 0; i < size; i++){
			if(os.get(i).toLowerCase().equals(OperatingSystem.getOS().toLowerCase())){
				return true;
			}
		}		
		return false;
	}
}
