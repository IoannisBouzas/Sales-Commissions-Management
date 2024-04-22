package output;


import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;


public class ReceiptDataModifierHTML extends ReceiptDataModifier {


	
	@Override
	public void setFileToAppend(File fileToAppend) {
		this.fileToAppend = fileToAppend;
		
	}
	
	
	private void deleteLastTwoLines() {
		try {
			Path path = fileToAppend.toPath();
			List<String> lines = Files.readAllLines(path);
			int size = lines.size();

			// Remove the last two lines
			if (size > 1) {
				lines.remove(size - 1);
				lines.remove(size - 2);
			}

			// Write the lines back to the file
			Files.write(path, lines, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void appendFile() {
		System.out.println("Mpike sto HTML");
		try (FileWriter fileWriter = new FileWriter(fileToAppend, true)) { // true to append
			deleteLastTwoLines();
			modifyReceiptData(fileWriter);
			modifyCompanyData(fileWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifyReceiptData(FileWriter fileWriter) {
		try {
			fileWriter.write("\n<!-- New Receipt -->\n");
			fileWriter.write("<h4>Receipt ID: " + receipt.getReceiptID() + "</h4>\n");
			fileWriter.write("<p>Date: " + receipt.getDate() + "</p>\n");
			fileWriter.write("<p>Kind: " + receipt.getKind() + "</p>\n");
			fileWriter.write("<p>Sales: " + receipt.getSales() + "</p>\n");
			fileWriter.write("<p>Items: " + receipt.getItems() + "</p>\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifyCompanyData(FileWriter fileWriter) {
		
		try {
        	fileWriter.write("<p>Company: " + company.getName() + "</p>\n");
        	fileWriter.write("<p>Country: " + company.getCompanyAddress().getCountry() + "</p>\n");
        	fileWriter.write("<p>City: " + company.getCompanyAddress().getCity() + "</p>\n");
        	fileWriter.write("<p>Street: " + company.getCompanyAddress().getStreet() + "</p>\n");
        	fileWriter.write("<p>Number: " + company.getCompanyAddress().getStreetNumber() + "</p>\n\n");
        	fileWriter.write("</body>\n");
        	fileWriter.write("</html>\n");
    	} catch (IOException e) {
        	e.printStackTrace();
    	}
	}

}
