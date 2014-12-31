package com.jtmproject.gui;

import java.awt.Color;
import java.awt.Component;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.jtmproject.actions.FilesUtils;
import com.jtmproject.actions.ImageUtils;
import com.jtmproject.actions.StringUtils;
import com.jtmproject.user.Debug;
import com.jtmproject.user.GeneralPaths;
import com.jtmproject.user.JListFeaturesProgram;

/**
 * This class paints each cell into JList in Window class
 * @author Javier Tejedor
 */
public class FileCellRenderer extends JLabel implements ListCellRenderer<Object>{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1586655335323497836L;
	
	private final Color HIGHLIGHT_COLOR = new Color(189, 189, 189);
	private ImageIcon imageIcon;

	/**
	 * constructor
	 */
	public FileCellRenderer() {
		setOpaque(true);
		setIconTextGap(12);
	}

	/**
	 * Return a component that has been configured to display the specified value.
	 */
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		JListFeaturesProgram entry = (JListFeaturesProgram) value;
		
		setText("<html>" + entry.getName() + "<br/>" + entry.getAuthor() + "<br/>" + StringUtils.convertSizeFile(entry.getSize()) +"</html>");

		//this controls if the image is already download
		if(FilesUtils.existFile(GeneralPaths.getGp().getPathImages() + "\\" + entry.getNameImage())){
			imageIcon = new ImageIcon(GeneralPaths.getGp().getPathImages() + "\\" + entry.getNameImage());
		}else{
			DownloadImage downloadImage = new DownloadImage(entry.getUrlImage(), entry.getNameImage());
			downloadImage.start();

			synchronized(downloadImage){
				try {
					downloadImage.wait();
				} catch (InterruptedException ex) { 

				}
			}
		}
		
		setIcon(ImageUtils.getIu().resizeImageIcon(imageIcon, 50, 50));

		if(isSelected){
			setBackground(HIGHLIGHT_COLOR);
			setForeground(Color.BLACK);
		}else{
			setBackground(Color.white);
			setForeground(Color.black);
		}

		return this;
	}

    
	/**
	 * this class downloads an icon
	 * @author Javier Tejedor
	 */
	class DownloadImage extends Thread {

		private String urlImage;
		private String nameImage;

		/**
		 * constructor
		 * @param url
		 * @param nameImage
		 */
		public DownloadImage(String url, String nameImage){
			this.urlImage = url;
			this.nameImage = nameImage;
			
		}

		@Override
		public void run() {
			download();
		}

		/**
		 * download the icon
		 */
		private void download(){
			try{
				URL url = new URL(urlImage.replace(" ", "%20"));
				url.openConnection();
				InputStream reader = url.openStream();
				FileOutputStream writer = new FileOutputStream(GeneralPaths.getGp().getPathImages() + "\\" + nameImage);
				byte[] buffer = new byte[2048];
				int bytesRead = 0;

				while ((bytesRead = reader.read(buffer)) > 0){  
					writer.write(buffer, 0, bytesRead);
				}

				writer.close();
				reader.close();

				imageIcon = new ImageIcon(GeneralPaths.getGp().getPathImages() + "\\" + nameImage);
			}catch(IOException e){
				if(Debug.ECLIPSE_EXECUTE){
					ClassLoader cl = MainWindowJFrame.getjFrame().getClass().getClassLoader();
					imageIcon = new ImageIcon(cl.getResource("images/default_icon.png"));
				}else{
					imageIcon = GeneralPaths.getGp().getPathDefaultIcon(MainWindowJFrame.getjFrame());	
				}
				
				e.printStackTrace();
			}
		}
	}
}

