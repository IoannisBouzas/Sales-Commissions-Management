package test;



import input.TXTInput;




import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;




public class TXTTest {

    @org.junit.Test
    public void testProcessMethodTXT() throws IOException {
        // Create a mock file with content similar to your expected input
    	
    	File file = new File(".\\src\\test\\test-case-1-TXT.txt");
    	System.out.println("The file has been loaded!");
    	

       
        System.out.println("File path: " + file.getAbsolutePath());
        // Assuming TXTInput loads the file internally
        TXTInput txtInput = new TXTInput(file);
        DataTest dt = new DataTest();
        dt.testData();
       
        
        txtInput.readFile();
        try {
	        assertNotNull(txtInput.getSalesman().getName());
	        assertNotNull(txtInput.getSalesman().getAfm());
	        assertNotNull(String.valueOf(txtInput.getInfo("Receipt ID")));
	        assertNotNull(txtInput.getInfo("Date"));
	        assertNotNull(txtInput.getInfo("Kind"));
	        assertNotNull(String.valueOf(txtInput.getInfo("Sales")));
	        assertNotNull(String.valueOf(txtInput.getInfo("Items")));
	        assertNotNull(txtInput.getInfo("Company"));
	        assertNotNull(txtInput.getInfo("Country"));
	        assertNotNull(txtInput.getInfo("City"));
	        assertNotNull(txtInput.getInfo("Street"));
	        assertNotNull(String.valueOf(txtInput.getInfo("Number")));
        }catch  (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
        // Add assertions for all properties based on your expectations
    }
   
}
