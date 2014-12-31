package com.jtmproject.gui;

import javax.swing.JLabel;

/**
 * this class is to do the animation when the program is charging
 * @author Javier Tejedor
 */
public class JLabelAnimation implements Runnable{

	private static final int TIME_SLEEP = 10;
	private JLabel jLabel;
	private int locationY;
	private int locationX;
	private boolean left;
	
	/**
	 * constructor
	 * @param jLabel
	 * @param locationX
	 * @param locationY
	 * @param left
	 */
	public JLabelAnimation(JLabel jLabel, int locationX, int locationY, boolean left){
		this.jLabel = jLabel;
		this.locationX = locationX;
		this.locationY = locationY;
		this.left = left;
	}


	@Override
	public void run() {
		for(int i = 0; i < SizesGUI.JLABEL_ANIMATION_MOVEMENT; i++){
			if(left){
				jLabel.setLocation(locationX - i, locationY);
			}else{
				jLabel.setLocation(locationX + i, locationY);
			}
			jLabel.repaint();
			
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}