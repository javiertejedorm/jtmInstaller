package com.jtmproject.support;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * This class sets a limit for the JTextFields.
 * @author Javier Tejedor
 * @thanks http://apuntes.delibertad.com/java/limitar-los-caracteres-en-un-jtextfield/
 */
public class JTextFieldLimit extends PlainDocument {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3587226852843967287L;
	
	private static final int LIMIT = 25;

	@Override
	public void insertString(int offset, String  str, AttributeSet attr)throws BadLocationException {
		if (str == null){
			return;
		}

		if ((getLength() + str.length()) <= LIMIT) {
			super.insertString(offset, str, attr);
		}
	}
}
