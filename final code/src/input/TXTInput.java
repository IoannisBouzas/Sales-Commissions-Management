package input;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;


public class TXTInput extends Input{

	
	private BufferedReader br;
	
	public TXTInput(File recieptFileTXT){
		this.inputFile = recieptFileTXT;
		inputFilePath =  inputFile.getAbsolutePath();
		
	}
	public File getFileName()
	{
		return this.inputFile;
	}
	public String getinputFilePath()
	{
		return inputFilePath;
	}

	public String getInfo(String line)
	{
	 	String info = line.substring(line.indexOf(":") + 1).trim();
	  	return info;
	}
	public Integer getIntInfo(String line)
	{
	    Integer intInfo = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
	   	return intInfo;
	}
	public Double getDoubleInfo(String line)
	{
	   	Double doubleInfo =Double.parseDouble(line.substring(line.indexOf(":") + 1).trim());
	    return doubleInfo;
	}
	
	private void processName(String line){
		if(line.startsWith("Name:")){
			name = getInfo(line);
		}
	}

	private void processAFM(String line){
		if(line.startsWith("AFM")){
			afm = getInfo(line);
			addSalesman();
		}
	}

	private void processReceiptID(String line){
		if(line.startsWith("Receipt ID")){
			receiptID = getIntInfo(line);
		}
	}

	private void processDate(String line){
		if(line.startsWith("Date")){
			date = getInfo(line);
		}
	}

	private void processKind(String line){
		if(line.startsWith("Kind")){
			kind = getInfo(line);
		}
	}

	private void processSales(String line){
		if(line.startsWith("Sales")){
			sales = getDoubleInfo(line);
		}
	}

	private void processItems(String line){
		if(line.startsWith("Items")){
			items = getIntInfo(line);
		}
	}

	private void processCompanyName(String line){
		if(line.startsWith("Company")){
			companyName = getInfo(line);
		}
	}

	private void processCompanyCountry(String line){
		if(line.startsWith("Country")){
			companyCountry = getInfo(line);
		}
	}

	private void processCompanyCity(String line){
		if(line.startsWith("City")){
			companyCity = getInfo(line);
		}
	}

	private void processCompanyStreet(String line){
		if(line.startsWith("Street")){
			companyStreet = getInfo(line);
		}
	}

	private void processCompanyStreetNumber(String line){
		if(line.startsWith("Number")){
			companyStreetNumber = getIntInfo(line);
			addReceipt();
		}
	}

	public void readFile() {
		try {
			openFile(inputFilePath);
			process();
			closeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void openFile(String inputFilePath) throws Exception
	{
		br = null;
	    try {
	            	
			br = new BufferedReader(new FileReader(inputFilePath));
		} catch (IllegalArgumentException e1) {
			JOptionPane.showMessageDialog(null, "\u03a4\u03bf \u03b1\u03c1\u03c7\u03b5\u03b9\u03bf \u03c0\u03bf\u03c5 \u03b5\u03c0\u03b9\u03bb\u03b5\u03be\u03b1\u03c4\u03b5 \u03b4\u03b5\u03bd \u03b5\u03b9\u03bd\u03b1\u03b9 \u03c3\u03c9\u03c3\u03c4\u03bf. \u0395\u03c0\u03b9\u03bb\u03b5\u03be\u03c4\u03b5 \u03b5\u03bd\u03b1 \u03bc\u03b5 \u03ba\u03b1\u03c4\u03b1\u03bb\u03b7\u03be\u03b7 .txt");
		}
	}
	
	
	@Override
	public void process() throws Exception  {
		try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				processName(line);
				processAFM(line);
				processReceiptID(line);
				processDate(line);
				processKind(line);
				processSales(line);
				processItems(line);
				processCompanyName(line);
				processCompanyCountry(line);
				processCompanyCity(line);
				processCompanyStreet(line);
				processCompanyStreetNumber(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void closeFile() throws Exception
	{
	  
	    try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	
	
	
}