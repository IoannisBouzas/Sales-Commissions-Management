
package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import data.Salesman;


public class HTMLReportGenerator extends ReportGenerator {

	private  BufferedWriter bufferedWriter;
	

    private void writeLine(String line) {
        try {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error writing to the file");
        }
    }


    public HTMLReportGenerator(Salesman a){
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
        try {
        	JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("HTML FILES", "html", "html");
            fileChooser.setFileFilter(filter);
            int option = fileChooser.showSaveDialog(null);

            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String filePath = file.getAbsolutePath();
                if(!filePath.toLowerCase().endsWith(".html")){
                    filePath += "_SALES.html";
                }
                bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            }
        }catch(IOException e) {
        	JOptionPane.showMessageDialog(null,"No name file");
        }
		
    }

    @Override
    public void processData() throws Exception {
        writeLine("<!DOCTYPE html>\r\n"
        		+ "<html>\r\n"
        		+ "<head>\r\n"
        		+ "<title>HTML Report\r\n"
        		+ "</title>\r\n"
        		+ "</head>\r\n"
        		+ "<body>");
    	writeLine("<h1>Name: " + salesman.getName() + "</h1>");
        writeLine("<h1>AFM: " + salesman.getAfm() + "</h1>");
        writeLine("<h2>Sales Information</h2>");
        writeLine("<p>Total Sales: " + salesman.calculateTotalSales() + "</p>");
        writeLine("<p>Trousers Sales: " + salesman.calculateKindSales("Trousers") + "</p>");
        writeLine("<p>Skirts Sales: " + salesman.calculateKindSales("Skirts") + "</p>");
        writeLine("<p>Shirts Sales: " + salesman.calculateKindSales("Shirts") + "</p>");
        writeLine("<p>Coats Sales: " + salesman.calculateKindSales("Coats") + "</p>");
        writeLine("<p>Commission: " + salesman.calculateCommission() + "</p>" );
        writeLine("</body>\r\n"
        		+ "</html>");
        bufferedWriter.close();
    }
    
    

}
