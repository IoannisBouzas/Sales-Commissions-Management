package test;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.StringWriter;


import org.junit.Test;

import data.Salesman;
import output.TXTReportGenerator;

public class TXTReportGeneratorTest {

    
    private Salesman salesman = new Salesman();
    private TXTReportGenerator txtReportGenerator = new TXTReportGenerator(salesman);

    @Test
    public void testProcessData() throws Exception {
    	try {
    		
    	
	        StringWriter stringWriter = new StringWriter();
	        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
	
	        // Use reflection to set the private bufferedWriter field in txtReportGenerator
	        java.lang.reflect.Field field = TXTReportGenerator.class.getDeclaredField("bufferedWriter");
	        field.setAccessible(true);
	        field.set(txtReportGenerator, bufferedWriter);
	     // Check that the file was created
	        assertTrue(new File(".\\src\\test\\test-case-1-TXT.txt").exists());
	
	        txtReportGenerator.processData();
	
	        String content = stringWriter.toString();
	        assertTrue(content.contains("Name: " + salesman.getName()));
	        assertTrue(content.contains("AFM: " + salesman.getAfm()));
	        
	       
	
	       
	        assertTrue(content.contains("Total Sales: " + salesman.calculateTotalSales()));
	        assertTrue(content.contains("Trousers Sales: " + salesman.calculateKindSales("Trousers")));
	        assertTrue(content.contains("Skirts Sales: " + salesman.calculateKindSales("Skirts")));
	        assertTrue(content.contains("Shirts Sales: " + salesman.calculateKindSales("Shirts")));
	        assertTrue(content.contains("Coats Sales: " + salesman.calculateKindSales("Coats")));
	        assertTrue(content.contains("Commission: " + salesman.calculateCommission()));
	        System.out.println("The report .txt has been created and all data have been passed");

    	} catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());

        
    	}
    }
}