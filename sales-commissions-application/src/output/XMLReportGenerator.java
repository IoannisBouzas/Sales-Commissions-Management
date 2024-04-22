package output;


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import data.Salesman;

public class XMLReportGenerator extends ReportGenerator{

	private Document document;
	private String fullPathName = "";
	
	private void appendChildElementWithText(Document document, Element parent, String tagName, String textContent) {
		Element child = document.createElement(tagName);
		child.appendChild(document.createTextNode(textContent));
		parent.appendChild(child);
	}
	
	
	public XMLReportGenerator(Salesman a){
			salesman = a;
	}	
	
	

	@Override
	public void takePath() throws Exception {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML FILES", "xml");
           fileChooser.setFileFilter(filter);
        int option = fileChooser.showSaveDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filePath = file.getAbsolutePath();
            if(!filePath.toLowerCase().endsWith(".xml")){
                filePath += "_SALES.xml";
            }
            fullPathName = filePath;
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();
        }
        
	}

	@Override	
	public void processData() throws Exception {
		try {
			// root element
			Element agentElem = document.createElement("Agent");
			document.appendChild(agentElem);
	
			appendChildElementWithText(document, agentElem, "Name", salesman.getName());
			appendChildElementWithText(document, agentElem, "AFM", salesman.getAfm());
			appendChildElementWithText(document, agentElem, "TotalSales", Double.toString(salesman.calculateTotalSales()));
			appendChildElementWithText(document, agentElem, "TrouserSales", Float.toString(salesman.calculateKindSales("Trousers")));
			appendChildElementWithText(document, agentElem, "SkirtsSales", Float.toString(salesman.calculateKindSales("Skirts")));
			appendChildElementWithText(document, agentElem, "ShirtsSales", Float.toString(salesman.calculateKindSales("Shirts")));
			appendChildElementWithText(document, agentElem, "CoatsSales", Float.toString(salesman.calculateKindSales("Coats")));
			appendChildElementWithText(document, agentElem, "Commission", Double.toString(salesman.calculateCommission()));
	
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(fullPathName));
			transformer.transform(domSource, streamResult);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}



