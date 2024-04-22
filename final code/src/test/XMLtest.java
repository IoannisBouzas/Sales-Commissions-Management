package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;


import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import input.XMLInput;

public class XMLtest {

	@Test
	    public void testProcessMethodXML() throws IOException, ParserConfigurationException {
	    	
	    	
	    	File file = new File(".\\src\\test\\test-case-2-XML.xml");
	    	System.out.println("The file has been loaded!");
	    	System.out.println("File path: " + file.getAbsolutePath());
	    	
	    	
	    	XMLInput xmlInput = new XMLInput(file);
	        xmlInput.readFile();
	        //Document doc =xmlInput.getDoc();
	        
	        NodeList nodeLst = xmlInput.getNode();
	        Element agentElement = (Element) nodeLst.item(0);
			//Element agentElement = (Element) nodeLst.item(0);
	        try {
				assertNotNull(xmlInput.getElementValue(agentElement, "Name"));
				assertNotNull(xmlInput.getElementValue(agentElement, "AFM"));
			} catch (Exception e) {
				fail("Exception occurred: " + e.getMessage());
			}
	        
	        DataTest dt = new DataTest();
	        dt.testData();
	        
	      
	        try {
		        for(int i=0; i<nodeLst.getLength(); i++){
					Element receiptElement = (Element) nodeLst.item(i);
		        
			        assertNotNull(String.valueOf(xmlInput.getIntElementValue(receiptElement, "ReceiptID")));
			        assertNotNull(xmlInput.getElementValue(receiptElement, "Date"));
			        assertNotNull(xmlInput.getElementValue(receiptElement, "Kind"));
			        assertNotNull(String.valueOf(xmlInput.getDoubleElementValue(receiptElement, "Sales")));
			        assertNotNull(String.valueOf(xmlInput.getIntElementValue(receiptElement, "Items")));
			        assertNotNull(xmlInput.getElementValue(receiptElement, "Company"));
			        assertNotNull(xmlInput.getElementValue(receiptElement, "Country"));
			        assertNotNull(xmlInput.getElementValue(receiptElement, "City"));
			        assertNotNull(xmlInput.getElementValue(receiptElement, "Street"));
			        assertNotNull(String.valueOf(xmlInput.getIntElementValue(receiptElement, "Number")));
		        	}
		        
	        	}catch (Exception e) {
	                fail("Exception occurred: " + e.getMessage());
	            }

	}
}
