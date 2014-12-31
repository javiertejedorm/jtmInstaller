package com.jtmproject.gui;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;

import com.jtmproject.user.JListFeaturesProgram;

/**
 * This class controls the JList in the main window
 * @author Javier Tejedor
 */
public class JListPrograms extends JList<JListFeaturesProgram>{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4621982615281403699L;
	
	private static DefaultListModel<JListFeaturesProgram> defaultList;

	/**
	 * constructor
	 */
	public JListPrograms(){
		defaultList = new DefaultListModel<JListFeaturesProgram>();
		this.setModel(defaultList);
		this.setCellRenderer(new FileCellRenderer());
		this.setBorder(new EmptyBorder(5,5, 5, 5));
	}

	/**
	 * this adds a element into the list
	 * @param element
	 */
	public static void addElementJList(JListFeaturesProgram element){
		defaultList.addElement(element);
	}

	/**
	 * return the elemet selected
	 * @return
	 */
	public int getElementSelected(){
		return getSelectedIndex();
	}

	/**
	 * returns all elements selected in the jList
	 * @return
	 */
	public int[] getAllElementsSelectedJList(){
		return getSelectedIndices();
	}
	
	/**
	 * returns if the list is empty
	 * @return
	 */
	public boolean isEmpty(){
		return defaultList.isEmpty();
	}

	/**
	 * removes a jtm from jlist
	 * @param index
	 */
	public static void removeElementJList(int index){
		defaultList.remove(index);
	}

	/**
	 * removes all indexes selected
	 */
	public void removeAllElementsSelectedJList(){
		int [] selectedIndexes = getSelectedIndices();
		for(int i = selectedIndexes.length - 1; i >= 0 ; i--){
			defaultList.remove(selectedIndexes[i]);
		}
	}
}
