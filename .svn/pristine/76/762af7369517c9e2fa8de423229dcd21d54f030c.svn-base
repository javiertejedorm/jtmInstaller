package com.jtmproject.task;

import java.util.ArrayList;

/**
 * This class stores the list of the programs charged
 * @author Javier Tejedor
 */
public class ListOfPrograms {

	private static ListOfPrograms lop;
	private ArrayList<Program> listPrograms = new ArrayList<Program>();

	/**
	 * returns an instance of ListOfPrograms(Singleton Class)
	 * @return
	 */
	public static ListOfPrograms getLop() {
		if(lop == null){
			lop = new ListOfPrograms();
		}
		return lop;
	}

	/**
	 * returns the list of the programs
	 * @return
	 */
	public ArrayList<Program> getListPrograms() {
		return listPrograms;
	}

	/**
	 * adds a program into the list
	 * @param program
	 */
	public void addListProgram(Program program) {
		listPrograms.add(program);
	}

	/**
	 * this method removes a program of the list
	 * @param index
	 */
	public void removeProgram(int index){
		listPrograms.remove(index);
	}

	/**
	 * this method removes a program of the list
	 * @param index
	 */
	public void removesPrograms(int[] index){
		for(int i = index.length - 1; i >= 0 ; i--){
			listPrograms.remove(index[i]);
		}
	}
}
