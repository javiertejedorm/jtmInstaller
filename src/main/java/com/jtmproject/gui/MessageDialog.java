package com.jtmproject.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class launches messages dialog
 * @author Javier Tejedor
 */
public class MessageDialog {

	/**
	 * This is a basic message dialog
	 * @param jFrame
	 * @param message
	 */
	public static void messageDialogGeneral(JFrame jFrame ,String message){
		JOptionPane.showMessageDialog(jFrame, message, "Alert", JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * This is a warning message dialog
	 * @param jFrame
	 * @param message
	 */
	public static void messageDialogWarning(JFrame jFrame ,String message){
		JOptionPane.showMessageDialog(jFrame, message, "Alert", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * This is a error message dialog
	 * @param jFrame
	 * @param message
	 */
	public static void messageDialogError(JFrame jFrame ,String message){
		JOptionPane.showMessageDialog(jFrame, message, "Alert", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * This is a information message dialog
	 * @param jFrame
	 * @param message
	 */
	public static void messageDialogInformation(JFrame jFrame ,String message){
		JOptionPane.showMessageDialog(jFrame, message, "Alert", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * This is a question message dialog
	 * @param jFrame
	 * @param message
	 */
	public static int messageDialogQuestion(JFrame jFrame ,String message){
		return JOptionPane.showConfirmDialog(jFrame, message, "Question", JOptionPane.YES_NO_OPTION);
	}

	/**
	 * This is a dialog-input message dialog
	 * @param jFrame
	 * @param message
	 */
	public static String messageDialogInput(JFrame jFrame ,String message, String written){
		return JOptionPane.showInputDialog(message, written);
	}

	/**
	 * This is a dialog-option message dialog
	 * @param jFrame
	 * @param message
	 * @param options
	 * @return
	 */
	public static Object messageDialogOption(JFrame jFrame ,String message, String[] options){
		return JOptionPane.showOptionDialog(jFrame, message, "Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}

	/**
	 * This is a dialog-option-list message dialog
	 * @param jFrame
	 * @param message
	 * @param options
	 * @return
	 */
	public static Object messageDialogOptionList(JFrame jFrame ,String message, Object[] options){
		return JOptionPane.showInputDialog(jFrame, message, "Option", JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
	}
}
