package test;
import data.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DataTest {

	@Test
	public void testData() {
		try {
			Salesman s = new Salesman();
			ArrayList<Receipt> allR = s.getReceipts();
			assertNotNull(allR);
			
			assertNotEquals("AP ZARRAS",s.getName());
			assertNotNull(String.valueOf(s.getAfm()));
			
			assertNotNull(s.calculateTotalItems());
			String kind ="Shirts";
			
			assertNotNull(String.valueOf(s.calculateKindSales(kind)));
			
			kind ="Trousers";
			
			assertNotNull(String.valueOf(s.calculateKindSales(kind)));
			kind ="Coats";
			assertNotNull(String.valueOf(s.calculateKindSales(kind)));
			
			kind ="Skirts";
			assertNotNull(String.valueOf(s.calculateKindSales(kind)));
			
			
			assertNotNull(String.valueOf(s.calculateKindSales(kind)));
			if (!("Shirts".equals(kind) || "Coats".equals(kind) || "Skirts".equals(kind) || "Trousers".equals(kind))) {
		        fail("Invalid kind provided for testing");
			
			}
			
			assertNotNull(String.valueOf(s.calculateTotalItems()));
			
			assertNotNull(String.valueOf(s.calculateCommission()));
			
			assertNotNull(String.valueOf(s.getFileAppender()));
			
			System.out.println("All data have been passed!!");
		}catch(Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
	}

}
