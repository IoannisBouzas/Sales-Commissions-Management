package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.junit.Test;


import output.ReceiptDataModifierXML;

public class ReceiptDataModifierXMLTest {

		private File file = new File(".\\src\\test\\test-case-2-XML.xml");
		private ReceiptDataModifierXML receiptDataModifierXML = new ReceiptDataModifierXML();
		//private FileWriter fileWriter;

		@Test
	    public void testModifyReceiptData() throws IOException {
	        receiptDataModifierXML.setFileToAppend(file);

	        try (FileWriter fileWriter = new FileWriter(file, true)) {
	            receiptDataModifierXML.modifyReceiptData(fileWriter);
	        } catch (Exception e) {
	            fail("Exception should not be thrown: " + e.getMessage());
	        }

	        String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
	        assertTrue(content.contains("<Receipt>"));
	    }

	    @Test
	    public void testModifyCompanyData() throws IOException {
	        receiptDataModifierXML.setFileToAppend(file);

	        try (FileWriter fileWriter = new FileWriter(file, true)) {
	            receiptDataModifierXML.modifyCompanyData(fileWriter);
	        } catch (Exception e) {
	            fail("Exception should not be thrown: " + e.getMessage());
	        }

	        String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
	        assertTrue(content.contains("<Company>"));
	    }
	
}
