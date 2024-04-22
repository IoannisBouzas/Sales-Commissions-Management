package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import data.Company;
import data.Receipt;



public abstract class ReceiptDataModifier {

	protected File fileToAppend;
	protected Receipt receipt = new Receipt();
	protected Company company = new Company();

	

	public abstract void setFileToAppend(File fileToAppend); 
	public abstract void modifyReceiptData(FileWriter fileWriter);
	public abstract void modifyCompanyData(FileWriter fileWriter);


	public void appendFile() {
        try (FileWriter fileWriter = new FileWriter(fileToAppend, true)) { // true to append
            modifyReceiptData(fileWriter);
            modifyCompanyData(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void setReceiptData(int id , String date , String kind , double sales , int items ) {
		receipt.setReceiptID(id);
		receipt.setDate(date);
		receipt.setKind(kind);
		receipt.setSales(sales);
		receipt.setItems(items);
	}
	
	public void setCompanyData(String companyName , String country , String city , String street , int streetNumber) {
		company.setName(companyName);
		company.getCompanyAddress().setCountry(country);
		company.getCompanyAddress().setCity(city);
		company.getCompanyAddress().setStreet(street);
		company.getCompanyAddress().setStreetNumber(streetNumber);
	}
	



	
}

