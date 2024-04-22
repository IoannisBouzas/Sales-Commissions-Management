package input;

import java.io.File;


import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



public class XMLInput extends Input {
 
	private Document doc;
	
	
	public XMLInput(File receiptFileXML ){
		this.inputFile = receiptFileXML;
		inputFilePath =  inputFile.getAbsolutePath();
	}
	
	
	private String getElementValue(Element element, String tagName) {
		return element.getElementsByTagName(tagName).item(0).getChildNodes().item(0).getNodeValue().trim();
	}
	private Integer getIntElementValue(Element element, String tagName) {
		return Integer.parseInt(element.getElementsByTagName(tagName).item(0).getChildNodes().item(0).getNodeValue().trim());
	}
	private Double getDoubleElementValue(Element element, String tagName) {
		return  Double.parseDouble(element.getElementsByTagName(tagName).item(0).getChildNodes().item(0).getNodeValue().trim());
	}
	

	

	@Override
	public void openFile(String inputFilePath) throws Exception
	{
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	    	doc = docBuilder.parse(inputFile);
	    	doc.getDocumentElement().normalize();
		}catch(IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "\u03a4\u03bf \u03b1\u03c1\u03c7\u03b5\u03b9\u03bf \u03c0\u03bf\u03c5 \u03b5\u03c0\u03b9\u03bb\u03b5\u03be\u03b1\u03c4\u03b5 \u03b4\u03b5\u03bd \u03b5\u03b9\u03bd\u03b1\u03b9 \u03c3\u03c9\u03c3\u03c4\u03bf. \u0395\u03c0\u03b9\u03bb\u03b5\u03be\u03c4\u03b5 \u03b5\u03bd\u03b1 \u03bc\u03b5 \u03ba\u03b1\u03c4\u03b1\u03bb\u03b7\u03be\u03b7 .xml");
		}
		
	}
	
	
	@Override
	public void process() throws Exception {
		try {
			NodeList nodeLst = doc.getElementsByTagName("Agent");
			Element agentElement = (Element) nodeLst.item(0);
	
			name = getElementValue(agentElement, "Name");
			afm = getElementValue(agentElement, "AFM");
			addSalesman();
	
			NodeList receiptsNodeList = agentElement.getElementsByTagName("Receipt");
			int size = receiptsNodeList.getLength();
	
			for(int i=0; i<size; i++){
				Element receiptElement = (Element) receiptsNodeList.item(i);
	
				receiptID = Integer.parseInt(getElementValue(receiptElement, "ReceiptID"));
				date = getElementValue(receiptElement, "Date");
				kind = getElementValue(receiptElement, "Kind");
				sales = getDoubleElementValue(receiptElement, "Sales");
				items = getIntElementValue(receiptElement, "Items");
				companyName = getElementValue(receiptElement, "Company");
				companyCountry = getElementValue(receiptElement, "Country");
				companyCity = getElementValue(receiptElement, "City");
				companyStreet = getElementValue(receiptElement, "Street");
				companyStreetNumber = getIntElementValue(receiptElement, "Number");
	
				addReceipt();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog
			(null,"\u03a0\u03c1\u03bf\u03ad\u03ba\u03c5\u03c8\u03b5 \u03ba\u03ac\u03c0\u03bf\u03b9\u03bf \u03c0\u03c1\u03cc\u03b2\u03bb\u03b7\u03bc\u03b1 \u03ba\u03b1\u03c4\u03ac \u03c4\u03b7\u03bd \u03b1\u03bd\u03ac\u03b3\u03bd\u03c9\u03c3\u03b7 \u03c4\u03bf\u03c5 \u03b1\u03c1\u03c7\u03b5\u03af\u03bf\u03c5");
		}
	}
	
	
	@Override
	public void closeFile() throws Exception
    {
    	doc = null;
    }
    
}

