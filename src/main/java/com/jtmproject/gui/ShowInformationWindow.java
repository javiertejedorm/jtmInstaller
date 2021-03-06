package com.jtmproject.gui;


import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class ShowInformationWindow extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6204900667733298946L;
	
	private static final int WINDOW_HEIGHT = 510;
	private static final int WINDOW_WIDTH = 680;
	
	private JPanel contentPane;
	private JEditorPane  jepInfoProgram;
	
	private String informationToShow;
	
	/**
	 * constructor
	 */
	public ShowInformationWindow(JFrame jFrame, String informationToShow, String title){
		super(jFrame, true);
		this.setTitle(title);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		this.informationToShow = informationToShow;

		this.addComponentsToWindow();
		this.setResizable(false);
		this.setVisible(true);
				
	}
	
	/**
	 * this method adds the components
	 */
	private void addComponentsToWindow(){
		addJPanel();
		addJEditorPane();
		
		this.setContentPane(contentPane);
		this.setLocationByPlatform(true);
	}
	
	/**
	 * this method adds a JPanel
	 */
	private void addJPanel(){
		contentPane = new JPanel();
		contentPane.setOpaque(true);
		contentPane.setLayout(null);
	}
	
	/**
	 * this method adds a JTextArea to show the info about the program
	 */
	private void addJEditorPane(){
		jepInfoProgram = new JEditorPane("text/html", "<html><div id='div' align='justify'>"  + informationToShow + "</div></html>");
		
		//The scroll will start on the top
		jepInfoProgram.setCaretPosition(0); 
		jepInfoProgram.setEditable(false);
		jepInfoProgram.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JScrollPane jspCopyScroll = new JScrollPane();
		jspCopyScroll.setSize(WINDOW_WIDTH - 8, WINDOW_HEIGHT - 28);
		jspCopyScroll.setViewportView(jepInfoProgram);
		jspCopyScroll.setAutoscrolls(true);
				
		contentPane.add(jspCopyScroll);
		this.add(contentPane);
	}	
}
