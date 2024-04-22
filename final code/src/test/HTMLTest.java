package test;

import static org.junit.Assert.*;

import org.junit.Test;


import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import input.HTMLInput;
public class HTMLTest {

   
    


	@Test
    public void testProcessMethodHTML() {
		
		File file = new File(".\\src\\test\\test-case-3-HTML.html");
		System.out.println("The file has been loaded!");
    	HTMLInput htmltest = new HTMLInput(file);
    	
    	
    	

        
        System.out.println("File path: " + file.getAbsolutePath());
		
    	
       htmltest.readFile();
       Pattern pattern =htmltest.getPattern();
       Matcher matcherSalesManInfo = pattern.matcher(htmltest.getContent());
       
       try {
      
	       assertTrue(matcherSalesManInfo.find());
		   assertNotNull(matcherSalesManInfo.group(1));
		   assertNotNull(matcherSalesManInfo.group(2));
       } catch (Exception e) {
           fail("Exception occurred: " + e.getMessage());
       }
       
	   Matcher matcher = pattern.matcher(htmltest.getContent());
	   DataTest dt = new DataTest();
       dt.testData();
	   
	   try {
          
           assertTrue(matcher.find());

           // Assert that the parsed values are not null directly from matcher groups
           assertNotNull(String.valueOf(Integer.parseInt(matcher.group(1))));
           assertNotNull(matcher.group(2));
           assertNotNull(matcher.group(3));
           assertNotNull(String.valueOf(Double.parseDouble(matcher.group(4))));
           assertNotNull(String.valueOf(Integer.parseInt(matcher.group(5))));
           assertNotNull(matcher.group(6));
           assertNotNull(matcher.group(7));
           assertNotNull(matcher.group(8));
           assertNotNull(matcher.group(9));
           assertNotNull(String.valueOf(Integer.parseInt(matcher.group(10))));

           // Add any further assertions based on the behavior after data assignment

       } catch (Exception e) {
           fail("Exception occurred: " + e.getMessage());
       }
   }
	   
	    
    
}
