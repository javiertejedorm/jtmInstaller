package com.jtmproject.user;

import java.awt.Font;
import java.io.IOException;
import java.text.ParseException;

import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jtmproject.gui.WindowMain;

/**
 * This is the main class of the program
 * @author Javier Tejedor
 */
public class Main {

	/**
	 * point of entry
	 * @param args
	 * @throws IOException 
	 */
	public static void main(final String[] args) throws IOException {
		
		new ChargeConfigurationToStart();
		String[] li = {"XXXX", "XXXX", "XXXX", "XXXX", "XXXX", "MXXXX"};
		UIManager.put("Synthetica.license.info", li);
		UIManager.put("Synthetica.license.key", "XXXX");
		
		UIManager.put("Synthetica.window.opaque", Boolean.FALSE);
		UIManager.put("Synthetica.font.scaleFactor", 100); //default
		//UIManager.put("Synthetica.font.resource", /*path to ttf file*/);
		
		try {
//			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
			UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());
			
//			UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
//			UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
//			UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
//			UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());////
//			UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
//			UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
//			UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());///
//			UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
//			UIManager.setLookAndFeel(new SyntheticaClassyLookAndFeel());
//			UIManager.setLookAndFeel(new SyntheticaGreenDreamLookAndFeel());
//			UIManager.setLookAndFeel(new SyntheticaMauveMetallicLookAndFeel());
//			UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());
//			UIManager.setLookAndFeel(new SyntheticaSilverMoonLookAndFeel());/////
//			UIManager.setLookAndFeel(new SyntheticaSkyMetallicLookAndFeel());
//			UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());
			

		} catch (UnsupportedLookAndFeelException e) {
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {			
				if(args.length > 0){
					new WindowMain(args[0]);
				}else{
					new WindowMain(null);
				}
				
			}
		});
	}
}