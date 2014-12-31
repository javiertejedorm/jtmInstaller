package com.jtmproject.actions;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

/**
 * This class has methods for manipulate Images
 * @author Javier Tejedor
 */
public class ImageUtils {

	private static ImageUtils iu;

	/**
	 * returns an object of this class (Singleton Class)
	 * @return
	 */
	public static ImageUtils getIu() {
		if(iu == null){
			iu = new ImageUtils();
		}
		return iu;
	}

	/**
	 * this function returns a image resize
	 * @param imgIcon
	 * @param sizeX
	 * @param sizeY
	 * @return
	 */
	public ImageIcon resizeImageIcon(ImageIcon imgIcon, int sizeX, int sizeY){
		Image img = imgIcon.getImage();  
		Image newimg = img.getScaledInstance(sizeX, sizeY,  java.awt.Image.SCALE_SMOOTH);  
		return new ImageIcon(newimg);
	}
	

	/**
	 * this function returns the size of the image: width x height
	 * @param file
	 * @return
	 */
	public int[] imageFileProperlies(File file){
		int[] i = new int[2];
		ImageIcon image = new ImageIcon(file.getAbsolutePath());
		i[0] = image.getIconWidth();
		i[1] = image.getIconHeight();
		return i;
	}
}
