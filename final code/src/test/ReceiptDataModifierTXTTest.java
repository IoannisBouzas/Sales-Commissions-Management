package test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import output.ReceiptDataModifierTXT;

public class ReceiptDataModifierTXTTest {
	private File file = new File(".\\src\\test\\test-case-1-TXT.txt");
	private ReceiptDataModifierTXT receiptDataModifierTXT = new ReceiptDataModifierTXT();
   

    @Test
    public void testReceiptTXT() throws IOException {
    	try {
    	
	    	receiptDataModifierTXT.setFileToAppend(file);
	        // Set up your Receipt and Company objects here
	
	        receiptDataModifierTXT.appendFile();
	
	        String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
	
	        assertNotNull(content);
	        //testModifyReceiptDataAndModifyCompanyData();
	    
	    
	        FileWriter fileWriter = new FileWriter(file);
	        
	
	        // Set up your Receipt and Company objects here
	
	        receiptDataModifierTXT.modifyReceiptData(fileWriter);
	        receiptDataModifierTXT.modifyCompanyData(fileWriter);
	
	        fileWriter.flush();
	        fileWriter.close();
	
	        content = new String(Files.readAllBytes(Paths.get(file.getPath())));
	
	        assertNotNull(content);
    		} catch (Exception e) {
                fail("Exception occurred: " + e.getMessage());
            }
       
    }
}
