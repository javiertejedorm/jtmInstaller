package com.jtmproject.actions;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.jtmproject.user.GeneralPaths;

/**
 * this class analyzes a JTM with XSD file.
 * @author Javier Tejedor
 */
public class AnalizeXSD {

	/**
	 * analyzes the JTM
	 * @param pathFile
	 * @return
	 */
	public boolean analizeJtmWithXsd(File pathFile){
		boolean result = false;
		
		try {
			
			SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
			File schemaLocation = new File(GeneralPaths.getGp().getPathValidationXSD());
			Schema schema = factory.newSchema(schemaLocation);
			Validator validator = schema.newValidator();
			Source source = new StreamSource(pathFile);
			validator.validate(source);
			result = true;
			
		}catch (SAXException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
		return result;
	}
}
