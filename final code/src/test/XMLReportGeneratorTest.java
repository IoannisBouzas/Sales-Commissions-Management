package test;

import static org.junit.Assert.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


import org.junit.Test;

import data.Salesman;
import output.XMLReportGenerator;

public class XMLReportGeneratorTest {
	private Document document;

	 @Test
	    public void testProcessData() throws Exception {
	      
	        Salesman realSalesman = new Salesman();
	       
	       
	        XMLReportGenerator xmlReportGenerator = new XMLReportGenerator(realSalesman);
	        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
		    document = documentBuilder.newDocument();

	        // Call processData
	        xmlReportGenerator.processData();

	        // Use reflection to get the private document field in xmlReportGenerator
	        java.lang.reflect.Field field = XMLReportGenerator.class.getDeclaredField("document");
	        field.setAccessible(true);
	        document = (Document) field.get(xmlReportGenerator);

	       
	        Element agentElem = document.getDocumentElement();
	        assertNotNull(agentElem.getElementsByTagName("Name").item(0));
	        assertNotNull(agentElem.getElementsByTagName("AFM").item(0));
	        assertNotNull(agentElem.getElementsByTagName("TotalSales").item(0));
	        assertNotNull(agentElem.getElementsByTagName("TrouserSales").item(0));
	        assertNotNull(agentElem.getElementsByTagName("SkirtsSales").item(0));
	        assertNotNull(agentElem.getElementsByTagName("ShirtsSales").item(0));
	        assertNotNull(agentElem.getElementsByTagName("CoatsSales").item(0));
	        assertNotNull(agentElem.getElementsByTagName("Commission").item(0));
	    }
	 
	 public void createDocument() throws ParserConfigurationException {
		    DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
		    document = documentBuilder.newDocument();
		}
	}