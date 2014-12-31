package com.jtmproject.gui;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

/**
 * This is the render of JList with JCheckBoxes
 * @author Javier Tejedor
 */
public class CheckListRenderer extends JCheckBox implements ListCellRenderer<Object> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8974690595058067918L;

	/**
	 * constructor
	 */
	public CheckListRenderer() {
		setBackground(UIManager.getColor("List.textBackground"));
		setForeground(UIManager.getColor("List.textForeground"));
	}

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean hasFocus) {
		setEnabled(list.isEnabled());
		setSelected(((CheckableItemJListChecbox) value).isSelected());
		setFont(list.getFont());
		setText(value.toString());
		return this;
	}
}
