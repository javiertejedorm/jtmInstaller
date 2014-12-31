package com.jtmproject.gui;

/**
 * This stores the data of JCheckBox into the JList
 * @author Javier Tejedor
 */
public class CheckableItemJListChecbox {

	private String str;
	private boolean isSelected;

	/**
	 * constructor
	 * @param str
	 */
	public CheckableItemJListChecbox(String str) {
		this.str = str;
		isSelected = false;
	}

	/**
	 * sets the value of the checkbox
	 * @param b
	 */
	public void setSelected(boolean b) {
		isSelected = b;
	}

	/**
	 * returns if the JCheckBox is selected
	 * @return
	 */
	public boolean isSelected() {
		return isSelected;
	}

	@Override
	public String toString() {
		return str;
	}
}
