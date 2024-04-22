package input;


import java.io.File;

import data.Receipt;
import data.Salesman;

public abstract class Input {
	
	protected Salesman salesman;
	protected File inputFile;
	protected String inputFilePath;
	protected String name;
	protected String afm;
	protected int receiptID;
	protected String date;
	protected String kind;
	protected double sales;
	protected int items;
	protected String companyName;
	protected String companyCountry;
	protected String companyCity;
	protected String companyStreet;
	protected int companyStreetNumber;
	
	

	public abstract void openFile(String inputFilePath) throws Exception;

    public abstract void process() throws Exception;

    public abstract void closeFile() throws Exception;



	public void readFile()
	{
		try {
            openFile(inputFilePath);
            process();
            closeFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	

	
	public Input() {
		salesman = new Salesman();
		kind  = new String("");
	}
	

	
	public void addSalesman() {
		salesman.setName(name);
		salesman.setAfm(afm);
	}
	
	public void addReceipt(){ 
			Receipt receipt =new Receipt();			
			if(kind.equals("Shirts")) {
				receipt.setKind(kind);

			}
			else if (kind.equals("Skirts")) {
				receipt.setKind(kind);

			}
			else if (kind.equals("Trousers")) {
				receipt.setKind(kind);

			}
			else if(kind.equals("Coats")) {
				receipt.setKind(kind);
			}
			
			receipt.setReceiptID(receiptID);			
			receipt.setDate(date);
			receipt.setSales(sales);
			receipt.setItems(items);
			receipt.getCompany().setName(companyName);
			receipt.getCompany().getCompanyAddress().setCountry(companyCountry);
			receipt.getCompany().getCompanyAddress().setCity(companyCity);
			receipt.getCompany().getCompanyAddress().setStreet(companyStreet);
			receipt.getCompany().getCompanyAddress().setStreetNumber(companyStreetNumber);
			salesman.getReceipts().add(receipt);
	}
	public Salesman getSalesman() {
		return salesman;
	}

}