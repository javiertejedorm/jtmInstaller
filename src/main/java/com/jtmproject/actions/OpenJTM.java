package com.jtmproject.actions;

import java.io.File;

import com.jtmproject.gui.JListPrograms;
import com.jtmproject.task.ListOfPrograms;
import com.jtmproject.task.Program;
import com.jtmproject.user.JListFeaturesProgram;

/**
 * This class reads and analyzes the jtm
 * @author Javier Tejedor
 */
public class OpenJTM {

	/**
	 * this function reads the tags and analyzes the securityKey of the jtm.
	 * @return
	 */
	public boolean open(String pathJtmInternalFile){
		if(new AnalizeXSD().analizeJtmWithXsd(new File(pathJtmInternalFile))){
			if(actionReader(pathJtmInternalFile)){
//				if(AnalyzeKeySecurity.getAks().analyze(pathJtmInternalFile)){
					generateContentItem();
//				}else{
//					MessageDialog.messageDialogError(jFrame, MessagesUser.getMU().getModified());
//				}
					return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * This method generates a item in the JList
	 */
	public void generateContentItem(){
		String nameProject = "";
		String nameDeveloper = "";
		String sizeProject = "";
		String urlIcon = "";
		String nameImage = "";

		int lastItem = ListOfPrograms.getLop().getListPrograms().size() - 1;
		Program program = ListOfPrograms.getLop().getListPrograms().get(lastItem);

		nameProject = program.getTagProject().getName();
		sizeProject = program.getTagProject().getSize();

		if(!program.getTagProject().getIdImage().equals(" ")){
			urlIcon = program.getTagProject().getUrl() + program.getTagProject().getIdImage();
			nameImage = program.getTagProject().getIdImage();
		}

		nameDeveloper = program.getTagMetadata().getAuthor();

		JListFeaturesProgram jl = new JListFeaturesProgram(nameProject, nameDeveloper, sizeProject, urlIcon, nameImage);

		JListPrograms.addElementJList(jl);
	}


	/**
	 * This method makes call for extract the content of jtm file.
	 */
	private boolean actionReader(String pathJtmInternalFile){
		return ReadJTM.getXMLReader().readXMLFile(pathJtmInternalFile);
	}
}
