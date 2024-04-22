package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptDataModifierTXT extends ReceiptDataModifier{

	@Override
	public void setFileToAppend(File fileToAppend) {
		
		this.fileToAppend = fileToAppend;
		
	}
	
	public void appendFile() {
		System.out.println("Mpike sto TXT");
		
		try (FileWriter fileWriter = new FileWriter(fileToAppend, true)) { // true to append
		
			modifyReceiptData(fileWriter);
			modifyCompanyData(fileWriter);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void modifyReceiptData(FileWriter fileWriter) {
		try {
			fileWriter.write("\nReceipt ID: " + receipt.getReceiptID() + "\n");
			fileWriter.write("Date: " + receipt.getDate() + "\n");
			fileWriter.write("Kind: " + receipt.getKind() + "\n");
			fileWriter.write("Sales: " + receipt.getSales() + "\n");
			fileWriter.write("Items: " + receipt.getItems() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void modifyCompanyData(FileWriter fileWriter) {
		try {
			fileWriter.write("Company: " + company.getName() + "\n");
			fileWriter.write("Country: " + company.getCompanyAddress().getCountry() + "\n");
			fileWriter.write("City: " + company.getCompanyAddress().getCity() + "\n");
			fileWriter.write("Street: " + company.getCompanyAddress().getStreet() + "\n");
			fileWriter.write("Number: " + company.getCompanyAddress().getStreetNumber() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}