package gui;
import input.HTMLInput;
import input.TXTInput;
import input.XMLInput;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;

import java.util.Vector;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.LayoutStyle.ComponentPlacement;

import data.Salesman;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.NullPointerException;


public class SalesmenInputManagerDialog extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel inputWindowPanel = new JPanel();
	private DefaultListModel <String> listModel = new DefaultListModel <String>();
	private JList <String> salesmenList = new JList <String>();
	private Vector <Salesman> allSalesmen;
	private  Salesman salesman = new Salesman();
	private Salesman selectedSalesman = null;
	static SalesmenInputManagerDialog dialog = new SalesmenInputManagerDialog();
	@SuppressWarnings("unused")
	private File inputFile;
	private String fileTypeFlag;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager.getInstalledLookAndFeels();
			for (int i = 0; i < installedLookAndFeels.length; i++) {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SalesmenInputManagerDialog(){
		
		initialise();
	}
	
	public void initialise() {
		allSalesmen = new Vector <Salesman>();
		
		setBackground(new Color(0, 0, 0));
		setBounds(100, 100, 736, 472);
		getContentPane().setLayout(new BorderLayout());
		inputWindowPanel.setBackground(SystemColor.controlHighlight);
		inputWindowPanel.setBorder(null);
		getContentPane().add(inputWindowPanel, BorderLayout.CENTER);
		
				
				JButton buttonTXTInput = new JButton("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u03B1\u03C0\u03CC TXT");
				buttonTXTInput.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				buttonTXTInput.setBackground(UIManager.getColor("InternalFrame.borderLight"));
				buttonTXTInput.setFocusPainted(false);
				
				JButton buttonXMLInput = new JButton("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u03B1\u03C0\u03CC XML");
				buttonXMLInput.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				buttonXMLInput.setBackground(UIManager.getColor("InternalFrame.borderLight"));
				buttonXMLInput.setFocusPainted(false);
				
				JButton buttonHTMLInput = new JButton("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u03B1\u03C0\u03CC HTML");
				buttonHTMLInput.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				buttonHTMLInput.setBackground(UIManager.getColor("InternalFrame.borderLight"));
				buttonHTMLInput.setFocusPainted(false);
				
				
				JLabel label = new JLabel("\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5 \u03B5\u03AF\u03B4\u03BF\u03C2 \u03B1\u03C1\u03C7\u03B5\u03AF\u03BF\u03C5 \u03B3\u03B9\u03B1 \u03C6\u03CC\u03C1\u03C4\u03C9\u03C3\u03B7 \u03B1\u03C0\u03BF\u03B4\u03B5\u03AF\u03BE\u03B5\u03C9\u03BD:");
				label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				salesmenList.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						selectAgent(e);
					}
				});
				
				salesmenList.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				salesmenList.setBackground(UIManager.getColor("Button.light"));
				salesmenList.setBorder(new LineBorder(new Color(0, 0, 0)));
				
				
				JLabel label_1 = new JLabel("\u039B\u03B9\u03C3\u03C4\u03B1 \u0391\u03BD\u03C4\u03B9\u03C0\u03C1\u03BF\u03C3\u03CE\u03C0\u03C9\u03BD");
				label_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				
				JButton button = new JButton("OK");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						okButtonPressed(evt);						
					}

				
				});
				button.setToolTipText("");
				button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				button.setBackground(UIManager.getColor("Button.shadow"));
				
				JButton button_1 = new JButton("Cancel");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelButtonPressed(e);
					}
				});
				button_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				button_1.setBackground(UIManager.getColor("Button.shadow"));
				
				GroupLayout gl_inputWindowPanel = new GroupLayout(inputWindowPanel);
				gl_inputWindowPanel.setHorizontalGroup(
					gl_inputWindowPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_inputWindowPanel.createSequentialGroup()
							.addGroup(gl_inputWindowPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_inputWindowPanel.createSequentialGroup()
									.addGap(258)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_inputWindowPanel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(label)
									.addComponent(buttonTXTInput, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
									.addComponent(buttonXMLInput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(buttonHTMLInput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(18)
							.addGroup(gl_inputWindowPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(salesmenList, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(57, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_inputWindowPanel.createSequentialGroup()
							.addContainerGap(453, Short.MAX_VALUE)
							.addComponent(label_1)
							.addGap(143))
				);
				gl_inputWindowPanel.setVerticalGroup(
					gl_inputWindowPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_inputWindowPanel.createSequentialGroup()
							.addGap(23)
							.addComponent(label)
							.addGap(11)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_inputWindowPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_inputWindowPanel.createSequentialGroup()
									.addComponent(buttonTXTInput, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(20)
									.addComponent(buttonXMLInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(20)
									.addComponent(buttonHTMLInput, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
								.addComponent(salesmenList, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
							.addGap(139)
							.addGroup(gl_inputWindowPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(25, Short.MAX_VALUE))
				);
				inputWindowPanel.setLayout(gl_inputWindowPanel);
				buttonTXTInput.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						insertFromTXT(evt);
					}
				});
				
				buttonXMLInput.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						insertFromXML(e);
					}
				});
				
				buttonHTMLInput.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						insertFromHTML(evt);
					}
				});
	}
	
	
	private void cancelButtonPressed(ActionEvent e) {
		System.exit(0);	
	}
	
	private void insertFromTXT(ActionEvent evt){
		
		JFileChooser TXTFileChooser;
		TXTFileChooser = new JFileChooser();     
		TXTFileChooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);		       
		TXTFileChooser.showOpenDialog(null);
		boolean agentDuplicate = false;
		try{
			File recieptFileTXT = TXTFileChooser.getSelectedFile();
			TXTInput inputFileTXT = new TXTInput(recieptFileTXT);	
			inputFileTXT.readFile();
			salesman = inputFileTXT.getSalesman();
			salesman.setFileType("TXT");
			salesman.getFileAppender().setFileToAppend(recieptFileTXT);				
			allSalesmen.add(salesman);
			for(int i = 0; i< listModel.getSize(); i++){
				if(salesman.getName().equals(listModel.getElementAt(i))){
					agentDuplicate = true;

				}
			}
			if(agentDuplicate == true){
				JOptionPane.showMessageDialog(null,"\u039F \u03B1\u03BD\u03C4\u03B9\u03C0\u03C1\u03CC\u03C3\u03C9\u03C0\u03BF\u03C2 \u03C5\u03C0\u03AC\u03C1\u03C7\u03B5\u03B9 \u03AE\u03B4\u03B7 \u03C3\u03C4\u03B7 \u03BB\u03AF\u03C3\u03C4\u03B1");

			}
			else{
				listModel.addElement(salesman.getName());
				salesmenList.setModel(listModel);
				this.fileTypeFlag = "TXT";
			}
			
		}catch (NullPointerException e){
			
			JOptionPane.showMessageDialog(null,"\u0394\u03B5\u03BD \u03B5\u03C0\u03B9\u03BB\u03AD\u03C7\u03B8\u03B7\u03BA\u03B5 \u03BA\u03B1\u03BD\u03AD\u03BD\u03B1 \u03B1\u03C1\u03C7\u03B5\u03AF\u03BF");

		}catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null,"\u03a0\u03c1\u03bf\u03ad\u03ba\u03c5\u03c8\u03b5 \u03ba\u03ac\u03c0\u03bf\u03b9\u03bf \u03c0\u03c1\u03cc\u03b2\u03bb\u03b7\u03bc\u03b1 \u03ba\u03b1\u03c4\u03ac \u03c4\u03b7\u03bd \u03b1\u03bd\u03ac\u03b3\u03bd\u03c9\u03c3\u03b7 \u03c4\u03bf\u03c5 \u03b1\u03c1\u03c7\u03b5\u03af\u03bf\u03c5");
		}
		
	}
	
	private void insertFromXML(ActionEvent evt2){
		JFileChooser XMLFileChooser;
		XMLFileChooser = new JFileChooser();     
		XMLFileChooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);		       
		XMLFileChooser.showOpenDialog(null);
		boolean agentDuplicate = false;
		try{
			File recieptFileXML = XMLFileChooser.getSelectedFile();
			XMLInput inputFileXML = new XMLInput(recieptFileXML);	
			inputFileXML.readFile();
			salesman = inputFileXML.getSalesman();
			salesman.setFileType("XML");
			salesman.getFileAppender().setFileToAppend(recieptFileXML);				
			allSalesmen.add(salesman);
			for(int i = 0; i< listModel.getSize(); i++){
				if(salesman.getName().equals(listModel.getElementAt(i))){
					agentDuplicate = true;

				}
			}
			if(agentDuplicate == true){
				JOptionPane.showMessageDialog(null,"\u039F \u03B1\u03BD\u03C4\u03B9\u03C0\u03C1\u03CC\u03C3\u03C9\u03C0\u03BF\u03C2 \u03C5\u03C0\u03AC\u03C1\u03C7\u03B5\u03B9 \u03AE\u03B4\u03B7 \u03C3\u03C4\u03B7 \u03BB\u03AF\u03C3\u03C4\u03B1");

			}
			else{
				listModel.addElement(salesman.getName());
				salesmenList.setModel(listModel);
				this.fileTypeFlag = "XML";
				
			}
		}catch (IllegalArgumentException e){
		
			JOptionPane.showMessageDialog(null,"\u0394\u03B5\u03BD \u03B5\u03C0\u03B9\u03BB\u03AD\u03C7\u03B8\u03B7\u03BA\u03B5 \u03BA\u03B1\u03BD\u03AD\u03BD\u03B1 \u03B1\u03C1\u03C7\u03B5\u03AF\u03BF");

		}catch (NullPointerException e){
			
			JOptionPane.showMessageDialog(null,"\u0394\u03B5\u03BD \u03B5\u03C0\u03B9\u03BB\u03AD\u03C7\u03B8\u03B7\u03BA\u03B5 \u03BA\u03B1\u03BD\u03AD\u03BD\u03B1 \u03B1\u03C1\u03C7\u03B5\u03AF\u03BF");

		}
        
             
	}
	
	
	
	private void insertFromHTML(ActionEvent evt3){
		JFileChooser HTMLFileChooser;
		HTMLFileChooser = new JFileChooser();     
		HTMLFileChooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);		       
		HTMLFileChooser.showOpenDialog(null);
		boolean agentDuplicate = false;
		try{
			File recieptFileHTML = HTMLFileChooser.getSelectedFile();
			HTMLInput inputFileHTML = new HTMLInput(recieptFileHTML);	
			inputFileHTML.readFile();
			salesman = inputFileHTML.getSalesman();
			salesman.setFileType("HTML");
			salesman.getFileAppender().setFileToAppend(recieptFileHTML);				
			allSalesmen.add(salesman);
			for(int i = 0; i< listModel.getSize(); i++){
				if(salesman.getName().equals(listModel.getElementAt(i))){
					agentDuplicate = true;

				}
			}
			if(agentDuplicate == true){
				JOptionPane.showMessageDialog(null,"\u039F \u03B1\u03BD\u03C4\u03B9\u03C0\u03C1\u03CC\u03C3\u03C9\u03C0\u03BF\u03C2 \u03C5\u03C0\u03AC\u03C1\u03C7\u03B5\u03B9 \u03AE\u03B4\u03B7 \u03C3\u03C4\u03B7 \u03BB\u03AF\u03C3\u03C4\u03B1");

			}
			else{
				listModel.addElement(salesman.getName());
				salesmenList.setModel(listModel);
				this.fileTypeFlag = "HTML";
				
			}
		}catch (IllegalArgumentException e){
		
			JOptionPane.showMessageDialog(null,"\u0394\u03B5\u03BD \u03B5\u03C0\u03B9\u03BB\u03AD\u03C7\u03B8\u03B7\u03BA\u03B5 \u03BA\u03B1\u03BD\u03AD\u03BD\u03B1 \u03B1\u03C1\u03C7\u03B5\u03AF\u03BF");

		}catch (NullPointerException e){
			
			JOptionPane.showMessageDialog(null,"\u0394\u03B5\u03BD \u03B5\u03C0\u03B9\u03BB\u03AD\u03C7\u03B8\u03B7\u03BA\u03B5 \u03BA\u03B1\u03BD\u03AD\u03BD\u03B1 \u03B1\u03C1\u03C7\u03B5\u03AF\u03BF");

		}
        
             
	}
	

	public String getFileTypeFlag() {
		return fileTypeFlag;
	}
	
		
	
	private void selectAgent(MouseEvent e){
		
		String agentName;
        if(salesmenList.getSelectedIndex()>=0){
        	
            agentName = salesmenList.getSelectedValue().toString();
            for(int i=0; i<allSalesmen.size(); i++){
                if(agentName.equals(allSalesmen.get(i).getName())){
                	
                		selectedSalesman = allSalesmen.get(i);
                		break;
                		
                }
            }
        	
        }
	}
	
	private void okButtonPressed(ActionEvent evt) {
		if(salesmenList.isSelectionEmpty()){
			JOptionPane.showMessageDialog(null,"\u0394\u03B5\u03BD \u03AD\u03C7\u03B5\u03C4\u03B5 \u03B5\u03C0\u03B9\u03BB\u03AD\u03BE\u03B5\u03B9 \u03B1\u03BD\u03C4\u03B9\u03C0\u03C1\u03CC\u03C3\u03C9\u03C0\u03BF");

		}
		else{
			ReceiptSelectionDialog sw = new  ReceiptSelectionDialog(dialog,selectedSalesman,fileTypeFlag);
			this.setVisible(false);
			sw.setVisible(true);
		}	
	}	

}
