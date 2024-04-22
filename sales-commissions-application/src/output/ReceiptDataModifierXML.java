package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


public class ReceiptDataModifierXML  extends ReceiptDataModifier{

	
	 private void writeDocumentToFile(Document doc) {
	       try{
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(fileToAppend);
	            transformer.transform(source, result);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }

	 
	 private void createElementWithText(Document doc, Element parent, String tagName, String textContent) {
		    Element elem = doc.createElement(tagName);
		    elem.appendChild(doc.createTextNode(textContent));
		    parent.appendChild(elem);
	 }
	
    @Override
    public  void setFileToAppend(File fileToAppend) {
		
	   this.fileToAppend = fileToAppend;
	
    }

    
    @Override
    public void modifyReceiptData(FileWriter fileWriter) {
       
    	try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = null;
                Document doc = null;
               
                try {
                    docBuilder = docFactory.newDocumentBuilder();
                    doc = docBuilder.parse(fileToAppend);
                } catch (ParserConfigurationException | SAXException e) {
                    e.printStackTrace();
                }
		
                Node agent = doc.getFirstChild();
                
                Element receiptElem = doc.createElement("Receipt");
                agent.appendChild(receiptElem);

                createElementWithText(doc, receiptElem, "ReceiptID", String.valueOf(receipt.getReceiptID()));
                createElementWithText(doc, receiptElem, "Date", String.valueOf(receipt.getDate()));
                createElementWithText(doc, receiptElem, "Kind", receipt.getKind());
                createElementWithText(doc, receiptElem, "Sales", String.valueOf(receipt.getSales()));
                createElementWithText(doc, receiptElem, "Items", String.valueOf(receipt.getItems()));
                writeDocumentToFile(doc);
        }
        catch (IOException e) {
            e.printStackTrace();
            }
    }

    @Override
    public void modifyCompanyData(FileWriter fileWriter) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = null;
            Document doc = null;
            try {
                docBuilder = docFactory.newDocumentBuilder();
                doc = docBuilder.parse(fileToAppend);
            } catch (ParserConfigurationException | SAXException e) {
                e.printStackTrace();
            }

            Node agent = doc.getFirstChild();

            Element companyElem = doc.createElement("Company");
            agent.appendChild(companyElem);

            createElementWithText(doc, companyElem, "Country", company.getCompanyAddress().getCountry());
            createElementWithText(doc, companyElem, "City", company.getCompanyAddress().getCity());
            createElementWithText(doc, companyElem, "Street", company.getCompanyAddress().getStreet());
            createElementWithText(doc, companyElem, "Number", String.valueOf(company.getCompanyAddress().getStreetNumber()));
            writeDocumentToFile(doc);
            System.out.println("Mpike sto XML");
        }
        catch (IOException e){
            e.printStackTrace();
            }
    }
}
