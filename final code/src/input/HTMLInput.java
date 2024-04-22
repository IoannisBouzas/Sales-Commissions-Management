package input;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class HTMLInput extends Input {

	private BufferedReader br;
	private Pattern pattern;
	private String content;
	

	public HTMLInput(File recieptFileHTML) {
		this.inputFile = recieptFileHTML;
		inputFilePath =  inputFile.getAbsolutePath();
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
	public void openFile(String inputFilePath) throws Exception {
		br = null;
	    try {
	            	
			br = new BufferedReader(new FileReader(inputFilePath));
		} catch (IllegalArgumentException e1) {
			JOptionPane.showMessageDialog(null, "\u03a4\u03bf \u03b1\u03c1\u03c7\u03b5\u03b9\u03bf \u03c0\u03bf\u03c5 \u03b5\u03c0\u03b9\u03bb\u03b5\u03be\u03b1\u03c4\u03b5 \u03b4\u03b5\u03bd \u03b5\u03b9\u03bd\u03b1\u03b9 \u03c3\u03c9\u03c3\u03c4\u03bf. \u0395\u03c0\u03b9\u03bb\u03b5\u03be\u03c4\u03b5 \u03b5\u03bd\u03b1 \u03bc\u03b5 \u03ba\u03b1\u03c4\u03b1\u03bb\u03b7\u03be\u03b7 .html");
		}
		
	}

	@Override
	public void process() throws Exception {
		
		StringBuilder contentBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				contentBuilder.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		content = contentBuilder.toString();

		try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))){
        	Pattern salesManInfoPattern = Pattern.compile("<h2>Name: (.*?)</h2>\\s*<h2>AFM: (.*?)</h2>");
			pattern = Pattern.compile("<h4>Receipt ID: (.*?)</h4>\\s*<p>Date: (.*?)</p>\\s*<p>Kind: (.*?)</p>\\s*<p>Sales: (.*?)</p>\\s*<p>Items: (.*?)</p>\\s*<p>Company: (.*?)</p>\\s*<p>Country: (.*?)</p>\\s*<p>City: (.*?)</p>\\s*<p>Street: (.*?)</p>\\s*<p>Number: (.*?)</p>");
	
			
        	
			Matcher matcherSalesManInfo = salesManInfoPattern.matcher(content);
			if (matcherSalesManInfo.find()) {
				name = matcherSalesManInfo.group(1);
				afm = matcherSalesManInfo.group(2);
				addSalesman();
			}
		
				
			Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
				receiptID = Integer.parseInt(matcher.group(1));
				date = matcher.group(2);
				kind = matcher.group(3);
				sales = Double.parseDouble(matcher.group(4));
				items = Integer.parseInt(matcher.group(5));
				companyName = matcher.group(6);
				companyCountry = matcher.group(7);
				companyCity = matcher.group(8);
				companyStreet = matcher.group(9);
				companyStreetNumber = Integer.parseInt(matcher.group(10));
				addReceipt();
            }
				
        }catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeFile() throws Exception {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Pattern getPattern()
	{
		return pattern;
	}
	public String getContent()
	{
		return content;
	}
	
	
	
	
	
	
	
	

}
