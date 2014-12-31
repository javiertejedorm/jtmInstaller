package com.jtmproject.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jtmproject.user.Debug;
import com.jtmproject.user.GeneralPaths;

/**
 * This class extends a static JLabel for
 * @author Javier Tejedor
 */
public class AnimationSearching extends JLabel{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5356182162097390700L;
	
	private static AnimationSearching animationSearching;
	private static JFrame jframe;
	
	/**
	 * constructor
	 * @return
	 */
	public AnimationSearching(JFrame jframe){
		this.jframe = jframe;
		if(Debug.ECLIPSE_EXECUTE){
			ClassLoader cl = MainWindowJFrame.getjFrame().getClass().getClassLoader();
			setIcon(new ImageIcon(cl.getResource("images/loading.gif")));
		}else{
			setIcon(GeneralPaths.getGp().getIconAnimationCharging(MainWindowJFrame.getjFrame()));
		}
		
		setLocation(SizesGUI.LOCATION_ANIMATION_LOAD_X, SizesGUI.LOCATION_ANIMATION_LOAD_Y);
		setSize(SizesGUI.SIZE_ANIMATION_LOAD_WIDTH, SizesGUI.SIZE_ANIMATION_LOAD_HEIGHT);
		setVisible(false);
	}

	/**
	 * sets the visibility of the jlabel
	 * @param visible
	 */
	public static void setAnimationSearching(boolean visible) {
		if(visible){
			new Thread(new JLabelAnimation(
					JLabelUrlOfficial.getjLabel(), jframe.getWidth() - 140, SizesGUI.JLABEL_OFFICIAL_URL_Y, true)).start();
		}else{
			new Thread(new JLabelAnimation(
					JLabelUrlOfficial.getjLabel(), jframe.getWidth() - 140 - SizesGUI.JLABEL_ANIMATION_MOVEMENT, SizesGUI.JLABEL_OFFICIAL_URL_Y, false)).start();
		}
		AnimationSearching.animationSearching.setVisible(visible);
	}

	/**
	 * returns the static jlabel
	 * @return
	 */
	public static AnimationSearching getAnimationSearching(JFrame jFrame) {
		if(animationSearching == null){
			animationSearching = new AnimationSearching(jFrame);
		}
		return animationSearching;
	}

}
