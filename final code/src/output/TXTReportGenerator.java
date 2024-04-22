package output;


import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import data.Salesman;


public class TXTReportGenerator extends ReportGenerator{

	
	private  BufferedWriter bufferedWriter;
	
    private void writeLine(String line) {
        try {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error writing to the file");
        }
    }
	
	
    
    public TXTReportGenerator(Salesman a){
		salesman = a;
	}
	
	
	public void saveFile(){
        try {
            takePath();
            processData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    @Override
	public void takePath() throws Exception {
        try{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            fileChooser.setFileFilter(filter);
            int option = fileChooser.showSaveDialog(null);

            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filePath = file.getAbsolutePath();
                if(!filePath.toLowerCase().endsWith(".txt")){
                    filePath += "_SALES.txt";
                }
                bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            }   
        }catch(IOException e) {
        	JOptionPane.showMessageDialog(null,"Cancel saving");
        }
    }
	
	@Override
    public void processData() throws Exception {
        writeLine("Name: " + salesman.getName());
        writeLine("AFM: " + salesman.getAfm());
        writeLine("");
        writeLine("Total Sales: " + salesman.calculateTotalSales());
        writeLine("Trousers Sales: " + salesman.calculateKindSales("Trousers"));
        writeLine("Skirts Sales: " + salesman.calculateKindSales("Skirts"));
        writeLine("Shirts Sales: " + salesman.calculateKindSales("Shirts"));
        writeLine("Coats Sales: " + salesman.calculateKindSales("Coats"));
        writeLine("Commission: " + salesman.calculateCommission());
        bufferedWriter.close();
    }
	
	
    
}
