package test;

import static org.junit.Assert.*;


import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

import data.Salesman;
import output.HTMLReportGenerator;

public class HTMLReportGeneratorTest {

	 @Test
	public void testProcessData() throws Exception {
		try {
	    Salesman salesman = new Salesman();
	    // Set up the Salesman with the necessary state
	    // ...
	
	    // Create a temporary file
	    Path tempFile = Files.createTempFile(null, ".html");
	
	    // Create a HTMLReportGenerator with the real Salesman
	    HTMLReportGenerator htmlReportGenerator = new HTMLReportGenerator(salesman);
	    
	    
	    
	    java.lang.reflect.Field field = HTMLReportGenerator.class.getDeclaredField("bufferedWriter");
        field.setAccessible(true);
        field.set(htmlReportGenerator, new BufferedWriter(new FileWriter(tempFile.toFile())));
        
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        field.set(htmlReportGenerator, bufferedWriter);

        
        htmlReportGenerator.processData();
        String content = stringWriter.toString();
       
      
        	 
          assertTrue(content.contains("<!DOCTYPE html>\r\n"
        		+ "<html>\r\n"
        		+ "<head>\r\n"
        		+ "<title>HTML Report\r\n"
        		+ "</title>\r\n"
        		+ "</head>\r\n"
        		+ "<body>"));
        	assertTrue(content.contains("<h1>Name: " + salesman.getName() + "</h1>"));
	        assertTrue(content.contains("<h1>AFM: " + salesman.getAfm() + "</h1>"));
	        assertTrue(content.contains("<h2>Sales Information</h2>"));
	        assertTrue(content.contains("<p>Total Sales: " + salesman.calculateTotalSales() + "</p>"));
	        assertTrue(content.contains("<p>Trousers Sales: " + salesman.calculateKindSales("Trousers") + "</p>"));
	        assertTrue(content.contains("<p>Skirts Sales: " + salesman.calculateKindSales("Skirts") + "</p>"));
	        assertTrue(content.contains("<p>Shirts Sales: " + salesman.calculateKindSales("Shirts") + "</p>"));
	        assertTrue(content.contains("<p>Coats Sales: " + salesman.calculateKindSales("Coats") + "</p>"));
	        assertTrue(content.contains("<p>Commission: " + salesman.calculateCommission() + "</p>"));
	        assertTrue(content.contains(("</body>\r\n" + "</html>")));
	        System.out.println("The report .html has been created and all data have been passed");
		} catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());

        
		}
	 }
}
