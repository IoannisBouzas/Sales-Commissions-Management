package gui;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import java.awt.Font;

import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;


import data.Receipt;
import data.Salesman;


public class ReceiptSelectionDialog extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel selectionWindowPanel = new JPanel();
	private JTextField dateTextField;
	private JTextField kindTextField;
	private JTextField salesTextField;
	private JTextField itemsTextField;
	private JTextField companyTextField;
	private JTextField countryTextField;
	private JTextField cityTextField;
	private JTextField streetTextField;
	private JTextField receiptIDTextField;
	private JTextField numberTextField;
	private JTextField numOfReceiptsTextField;
	private JTextField agentNameTextField;
	private int numOfReceipts = 0;
	private double totalSales;
	private JCheckBox totalSalesCheckBox;
	private JCheckBox totalItemsCheckBox;
	private JCheckBox commissionCheckBox;
	private JCheckBox categoryCheckBox;
	private JRadioButton skirtRadio;
	private JRadioButton shirtRadio;
	private JRadioButton trousersRadio;
	private JRadioButton coatRadio;
	private int totalItems;
	private float shirtSales;
	private float skirtSales;
	private float coatsSales;
	private float trousersSales;
	private double commission;
	private SalesmenInputManagerDialog inputDialog;
	private Salesman selectedSalesman;
	@SuppressWarnings("unused")
	private String fileType;
	
	public ReceiptSelectionDialog(SalesmenInputManagerDialog dialog, Salesman salesman, String fileTypeFlag) {
		inputDialog= dialog;
		selectedSalesman = salesman;
		fileType = fileTypeFlag;
		initialise();
		
	}
	public void initialise(){
		getContentPane().setBackground(SystemColor.controlHighlight);
		setBounds(100, 100, 717, 597);
		getContentPane().setLayout(null);
		selectionWindowPanel.setBounds(0, 0, 701, 1);
		selectionWindowPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(selectionWindowPanel);
		selectionWindowPanel.setLayout(null);
		totalSalesCheckBox = new JCheckBox("\u03A3\u03C5\u03BD\u03BF\u03BB\u03B9\u03BA\u03AE \u03B1\u03BE\u03AF\u03B1 \u03C0\u03C9\u03BB\u03AE\u03C3\u03B5\u03C9\u03BD");
		totalSalesCheckBox.setBackground(SystemColor.controlHighlight);
		totalSalesCheckBox.setBounds(52, 129, 169, 25);
		totalSalesCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(totalSalesCheckBox);
		
		totalItemsCheckBox = new JCheckBox("\u03A3\u03C5\u03BD\u03BF\u03BB\u03B9\u03BA\u03CC\u03C2 \u03B1\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03C0\u03C9\u03BB\u03AE\u03C3\u03B5\u03C9\u03BD");
		totalItemsCheckBox.setBackground(SystemColor.controlHighlight);
		totalItemsCheckBox.setBounds(52, 170, 204, 25);
		totalItemsCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(totalItemsCheckBox);
		
		categoryCheckBox = new JCheckBox("\u03A0\u03C9\u03BB\u03AE\u03C3\u03B5\u03B9\u03C2 \u03C3\u03C5\u03B3\u03BA\u03B5\u03BA\u03C1\u03B9\u03BC\u03AD\u03BD\u03B7\u03C2 \u03BA\u03B1\u03C4\u03B7\u03B3\u03BF\u03C1\u03AF\u03B1\u03C2");
		categoryCheckBox.setBackground(SystemColor.controlHighlight);
		
		categoryCheckBox.setBounds(52, 214, 257, 25);
		categoryCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(categoryCheckBox);
		
		shirtRadio = new JRadioButton("\u039C\u03C0\u03BB\u03BF\u03CD\u03B6\u03B5\u03C2");
		shirtRadio.setBackground(SystemColor.controlHighlight);
		shirtRadio.setEnabled(false);
		shirtRadio.setBounds(119, 242, 125, 25);
		shirtRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(shirtRadio);
		
		trousersRadio = new JRadioButton("\u03A0\u03B1\u03BD\u03C4\u03B5\u03BB\u03CC\u03BD\u03B9\u03B1");
		trousersRadio.setBackground(SystemColor.controlHighlight);
		trousersRadio.setEnabled(false);
		trousersRadio.setBounds(119, 270, 125, 25);
		trousersRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(trousersRadio);
		
		coatRadio = new JRadioButton("\u03A0\u03B1\u03BB\u03C4\u03AC");
		coatRadio.setBackground(SystemColor.controlHighlight);
		coatRadio.setEnabled(false);
		coatRadio.setBounds(119, 298, 125, 25);
		coatRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(coatRadio);
		
		skirtRadio = new JRadioButton("\u03A6\u03BF\u03CD\u03C3\u03C4\u03B5\u03C2");
		skirtRadio.setBackground(SystemColor.controlHighlight);
		skirtRadio.setEnabled(false);
		skirtRadio.setBounds(119, 326, 125, 25);
		skirtRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(skirtRadio);
		
		commissionCheckBox = new JCheckBox("\u0395\u03BC\u03C6\u03AC\u03BD\u03B9\u03C3\u03B7 \u03A0\u03C1\u03BF\u03BC\u03AE\u03B8\u03B5\u03B9\u03B1\u03C2");
		commissionCheckBox.setBackground(SystemColor.controlHighlight);
		commissionCheckBox.setBounds(52, 375, 204, 25);
		commissionCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		getContentPane().add(commissionCheckBox);
		
		final JToggleButton addReceiptToggleButton = new JToggleButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03BD\u03AD\u03B1\u03C2 \u03B1\u03C0\u03CC\u03B4\u03B5\u03B9\u03BE\u03B7\u03C2");
		addReceiptToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addReceiptToggleButton.setBackground(new Color(135, 206, 235));
		
		addReceiptToggleButton.setBounds(411, 12, 265, 47);
		getContentPane().add(addReceiptToggleButton);

		dateTextField = new JTextField();
		dateTextField.setVisible(false);
		dateTextField.setBounds(543, 120, 133, 20);
		getContentPane().add(dateTextField);
		dateTextField.setColumns(10);
		
		kindTextField = new JTextField();
		kindTextField.setVisible(false);
		kindTextField.setBounds(543, 163, 133, 20);
		getContentPane().add(kindTextField);
		kindTextField.setColumns(10);
		
		salesTextField = new JTextField();
		salesTextField.setVisible(false);
		salesTextField.setBounds(543, 208, 133, 20);
		getContentPane().add(salesTextField);
		salesTextField.setColumns(10);
		
		itemsTextField = new JTextField();
		itemsTextField.setVisible(false);
		itemsTextField.setBounds(543, 250, 133, 20);
		getContentPane().add(itemsTextField);
		itemsTextField.setColumns(10);
		
		companyTextField = new JTextField();
		companyTextField.setVisible(false);
		companyTextField.setBounds(543, 287, 133, 20);
		getContentPane().add(companyTextField);
		companyTextField.setColumns(10);
		
		countryTextField = new JTextField();
		countryTextField.setVisible(false);
		countryTextField.setBounds(543, 329, 133, 20);
		getContentPane().add(countryTextField);
		countryTextField.setColumns(10);
		
		cityTextField = new JTextField();
		cityTextField.setVisible(false);
		cityTextField.setBounds(543, 367, 133, 20);
		getContentPane().add(cityTextField);
		cityTextField.setColumns(10);
		
		streetTextField = new JTextField();
		streetTextField.setVisible(false);
		streetTextField.setBounds(543, 406, 133, 20);
		getContentPane().add(streetTextField);
		streetTextField.setColumns(10);
		
		receiptIDTextField = new JTextField();
		receiptIDTextField.setVisible(false);
		receiptIDTextField.setBounds(543, 81, 133, 20);
		getContentPane().add(receiptIDTextField);
		receiptIDTextField.setColumns(10);
		
		numberTextField = new JTextField();
		numberTextField.setVisible(false);
		numberTextField.setBounds(543, 445, 133, 20);
		getContentPane().add(numberTextField);
		numberTextField.setColumns(10);
		
		final JLabel receiptIDLabel = new JLabel("ReceiptID:");
		receiptIDLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		receiptIDLabel.setVisible(false);
		receiptIDLabel.setBounds(470, 84, 71, 14);
		getContentPane().add(receiptIDLabel);
		
		final JLabel dateLabel = new JLabel("Date:");
		dateLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		dateLabel.setVisible(false);
		dateLabel.setBounds(470, 123, 46, 14);
		getContentPane().add(dateLabel);
		
		final JLabel kindLabel = new JLabel("Kind:");
		kindLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		kindLabel.setVisible(false);
		kindLabel.setBounds(470, 166, 46, 14);
		getContentPane().add(kindLabel);
		
		final JLabel salesLabel = new JLabel("Sales:");
		salesLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		salesLabel.setVisible(false);
		salesLabel.setBounds(470, 214, 46, 14);
		getContentPane().add(salesLabel);
		
		final JLabel itemsLabel = new JLabel("Items:");
		itemsLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		itemsLabel.setVisible(false);
		itemsLabel.setBounds(470, 253, 46, 14);
		getContentPane().add(itemsLabel);
		
		final JLabel companyLabel = new JLabel("Company:");
		companyLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		companyLabel.setVisible(false);
		companyLabel.setBounds(470, 284, 63, 25);
		getContentPane().add(companyLabel);
		
		final JLabel countryLabel = new JLabel("Country:");
		countryLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		countryLabel.setVisible(false);
		countryLabel.setBounds(470, 329, 63, 19);
		getContentPane().add(countryLabel);
		
		final JLabel cityLabel = new JLabel("City:");
		cityLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		cityLabel.setVisible(false);
		cityLabel.setBounds(470, 364, 46, 25);
		getContentPane().add(cityLabel);
		
		final JLabel streetLabel = new JLabel("Street:");
		streetLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		streetLabel.setVisible(false);
		streetLabel.setBounds(470, 409, 46, 14);
		getContentPane().add(streetLabel);
		
		final JLabel numberLabel = new JLabel("Number:");
		numberLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		numberLabel.setVisible(false);
		numberLabel.setBounds(470, 448, 63, 14);
		getContentPane().add(numberLabel);
		
		final JButton addReceiptButton = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		addReceiptButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		addReceiptButton.setVisible(false);
		addReceiptButton.setBounds(519, 482, 105, 39);
		getContentPane().add(addReceiptButton);
		
		JLabel lblNewLabel_10 = new JLabel("\u0391\u03C0\u03BF\u03B4\u03B5\u03AF\u03BE\u03B5\u03B9\u03C2 \u03C0\u03BF\u03C5 \u03C0\u03C1\u03BF\u03C3\u03B8\u03AD\u03B8\u03B7\u03BA\u03B1\u03BD:");
		lblNewLabel_10.setBounds(469, 532, 157, 14);
		getContentPane().add(lblNewLabel_10);
		
		numOfReceiptsTextField = new JTextField();
		numOfReceiptsTextField.setText("0");
		numOfReceiptsTextField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		numOfReceiptsTextField.setBounds(636, 528, 40, 20);
		getContentPane().add(numOfReceiptsTextField);
		numOfReceiptsTextField.setColumns(10);
		
		JButton okbutton = new JButton("OK");
		okbutton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				okButtonPressed(evt);
				
			}
		});
		okbutton.setBounds(40, 483, 89, 32);
		getContentPane().add(okbutton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelButtonPressed(evt);
			}
		});
		cancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cancelButton.setBounds(147, 483, 94, 32);
		getContentPane().add(cancelButton);
		
		JLabel lblNewLabel_11 = new JLabel("\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5 \u03C0\u03BB\u03B7\u03C1\u03BF\u03C6\u03BF\u03C1\u03AF\u03B5\u03C2 \u03C0\u03C1\u03BF\u03C2 \u03B5\u03BC\u03C6\u03AC\u03BD\u03B9\u03C3\u03B7");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(0, 75, 271, 29);
		getContentPane().add(lblNewLabel_11);
		
		JLabel agentNameLabel = new JLabel("\u0391\u03BD\u03C4\u03B9\u03C0\u03C1\u03CC\u03C3\u03C9\u03C0\u03BF\u03C2:");
		agentNameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		agentNameLabel.setBounds(0, 8, 129, 25);
		getContentPane().add(agentNameLabel);
		
		agentNameTextField = new JTextField();
		agentNameTextField.setBackground(SystemColor.controlHighlight);
		agentNameTextField.setEditable(false);
		agentNameTextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		agentNameTextField.setBounds(135, 4, 174, 32);
		getContentPane().add(agentNameTextField);
		agentNameTextField.setColumns(10);
		
		categoryCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				skirtRadio.setEnabled(true);
				shirtRadio.setEnabled(true);
				coatRadio.setEnabled(true);
				trousersRadio.setEnabled(true);
				if(categoryCheckBox.isSelected()==false){
					if(skirtRadio.isSelected())
						skirtRadio.setSelected(false);
					
					if(shirtRadio.isSelected())
						shirtRadio.setSelected(false);
					
					if(coatRadio.isSelected())
						coatRadio.setSelected(false);
					
					if(trousersRadio.isSelected())
						trousersRadio.setSelected(false);
					
					skirtRadio.setEnabled(false);
					shirtRadio.setEnabled(false);
					coatRadio.setEnabled(false);
					trousersRadio.setEnabled(false);
				}
			}
		});
		
		addReceiptToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				receiptIDLabel.setVisible(true);receiptIDTextField.setVisible(true);
				dateLabel.setVisible(true);dateTextField.setVisible(true);
				kindLabel.setVisible(true);kindTextField.setVisible(true);
				salesLabel.setVisible(true);salesTextField.setVisible(true);
				itemsLabel.setVisible(true);itemsTextField.setVisible(true);
				companyLabel.setVisible(true);companyTextField.setVisible(true);
				countryLabel.setVisible(true);countryTextField.setVisible(true);
				streetLabel.setVisible(true);streetTextField.setVisible(true);
				cityLabel.setVisible(true);cityTextField.setVisible(true);
				numberLabel.setVisible(true);numberTextField.setVisible(true);
				addReceiptButton.setVisible(true);
				if(addReceiptToggleButton.isSelected()==false){
					receiptIDLabel.setVisible(false);receiptIDTextField.setVisible(false);
					dateLabel.setVisible(false);dateTextField.setVisible(false);
					kindLabel.setVisible(false);kindTextField.setVisible(false);
					salesLabel.setVisible(false);salesTextField.setVisible(false);
					itemsLabel.setVisible(false);itemsTextField.setVisible(false);
					companyLabel.setVisible(false);companyTextField.setVisible(false);
					countryLabel.setVisible(false);countryTextField.setVisible(false);
					streetLabel.setVisible(false);streetTextField.setVisible(false);
					cityLabel.setVisible(false);cityTextField.setVisible(false);
					numberLabel.setVisible(false);numberTextField.setVisible(false);
					addReceiptButton.setVisible(false);
				}
			}
		});
		
		addReceiptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			
				addReceiptButtonPressed(evt);
				
			}
		});
		
		try{
			agentNameTextField.setText(selectedSalesman.getName());
		}catch(NullPointerException e){
			
			JOptionPane.showMessageDialog(null,"\u03a0\u03c1\u03bf\u03ad\u03ba\u03c5\u03c8\u03b5 \u03ba\u03ac\u03c0\u03bf\u03b9\u03bf \u03c0\u03c1\u03cc\u03b2\u03bb\u03b7\u03bc\u03b1, \u03c0\u03c1\u03bf\u03c3\u03c0\u03b1\u03b8\u03ae\u03c3\u03c4\u03b5 \u03be\u03b1\u03bd\u03ac");

		}
	}

	
	private int calculateIfSelected(JCheckBox totalSalesOrItemsCheckBox, double d) {
		return totalSalesOrItemsCheckBox.isSelected() ? Double.valueOf(d).intValue() : -1;
	}
	

	private int calculateIfSelectedForKinds(JRadioButton kindRadio, double d) {
		return kindRadio.isSelected() ? Double.valueOf(d).intValue() : -1;
	}
	

	protected void okButtonPressed(ActionEvent evt) {
		totalSales = calculateIfSelected(totalSalesCheckBox, selectedSalesman.calculateTotalSales());
		totalItems = calculateIfSelected(totalItemsCheckBox, selectedSalesman.calculateTotalItems());
		shirtSales = calculateIfSelectedForKinds(shirtRadio, selectedSalesman.calculateKindSales("Shirts"));
		skirtSales = calculateIfSelectedForKinds(skirtRadio, selectedSalesman.calculateKindSales("Skirts"));
		trousersSales = calculateIfSelectedForKinds(trousersRadio, selectedSalesman.calculateKindSales("Trousers"));
		coatsSales = calculateIfSelectedForKinds(coatRadio, selectedSalesman.calculateKindSales("Coats"));
		commission = calculateIfSelected(commissionCheckBox, selectedSalesman.calculateCommission());
		SalesReportWindow rs = new SalesReportWindow(this,selectedSalesman, totalSales, totalItems, shirtSales, skirtSales, trousersSales, coatsSales, commission);
	 	rs.setVisible(true);
	 	this.setVisible(false);
	}
	

	
	private void addReceiptButtonPressed(ActionEvent evt) {
		
		JTextField[] fields = { receiptIDTextField, dateTextField, kindTextField, salesTextField, itemsTextField, 
								companyTextField, countryTextField, cityTextField, streetTextField, numberTextField };
	
		for (JTextField field : fields) {
			if (field.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"\u03a0\u03c1\u03ad\u03c0\u03b5\u03b9 \u03bd\u03b1 \u03c3\u03c5\u03bc\u03c0\u03bb\u03b7\u03c1\u03ce\u03c3\u03b5\u03c4\u03b5 \u03cc\u03bb\u03b1 \u03c4\u03b1 \u03c0\u03b5\u03b4\u03af\u03b1");
				return;
			}
		}
		
		if(addReceipt()){ 
			appendFile();
		}
		
		for (JTextField field : fields) {
			field.setText("");
		}
	}
	
	private void appendFile(){
		try {
			selectedSalesman.getFileAppender().setReceiptData(Integer.parseInt(receiptIDTextField.getText()), dateTextField.getText(), 
					kindTextField.getText(), Double.parseDouble(salesTextField.getText()), Integer.parseInt(itemsTextField.getText()));
				
				
				selectedSalesman.getFileAppender().setCompanyData(companyTextField.getText(), countryTextField.getText(), 
					cityTextField.getText(), streetTextField.getText(), Integer.parseInt(numberTextField.getText()));
				
				selectedSalesman.getFileAppender().appendFile();
				
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"\u03a0\u03c1\u03ad\u03c0\u03b5\u03b9 \u03bd\u03b1 \u03c3\u03c5\u03bc\u03c0\u03bb\u03b7\u03c1\u03ce\u03c3\u03b5\u03c4\u03b5 \u03cc\u03bb\u03b1 \u03c4\u03b1 \u03c0\u03b5\u03b4\u03af\u03b1");
			
		}
		
	}
	
	private boolean addReceipt(){
		
		Receipt receipt = new Receipt();
		String kind = kindTextField.getText();
		
		if(kind.equals("Shirts") || kind.equals("Skirts") || kind.equals("Trousers") || kind.equals("Coats")) {
			receipt.setKind(kind);
			
		} else {
			JOptionPane.showMessageDialog(null,"\u03a4\u03bf \u03b5\u03af\u03b4\u03bf\u03c2 \u03c0\u03bf\u03c5 \u03c0\u03bb\u03b7\u03ba\u03c4\u03c1\u03bf\u03bb\u03bf\u03b3\u03ae\u03c3\u03b1\u03c4\u03b5 \u03b4\u03b5\u03bd \u03ad\u03b9\u03bd\u03b1\u03b9 \u03ad\u03b3\u03ba\u03c5\u03c1\u03bf. \u03a0\u03c1\u03bf\u03c3\u03c0\u03b1\u03b8\u03ae\u03c3\u03c4\u03b5 \u03be\u03b1\u03bd\u03ac \u03c3\u03c5\u03bc\u03c0\u03bb\u03b7\u03c1\u03ce\u03bd\u03bf\u03bd\u03c4\u03b1\u03c2 \u03c4\u03bf \u03c0\u03b5\u03b4\u03af\u03bf Kind \u03bc\u03b5 Coats \u03ae Shirts \u03ae Skirts \u03ae Trousers");
			return false;
		}
		try{
			receipt.setReceiptID(Integer.parseInt(receiptIDTextField.getText()));			
			receipt.setDate(dateTextField.getText());
			receipt.setSales(Double.parseDouble(salesTextField.getText()));
			receipt.setItems(Integer.parseInt(itemsTextField.getText()));
			receipt.getCompany().setName(companyTextField.getText());
			receipt.getCompany().getCompanyAddress().setCountry(countryTextField.getText());
			receipt.getCompany().getCompanyAddress().setCity(cityTextField.getText());
			receipt.getCompany().getCompanyAddress().setStreet(streetTextField.getText());
			receipt.getCompany().getCompanyAddress().setStreetNumber(Integer.parseInt(numberTextField.getText()));
			selectedSalesman.getReceipts().add(receipt);
			numOfReceipts++;
			numOfReceiptsTextField.setText(Integer.toString(numOfReceipts));
			JOptionPane.showMessageDialog(null,"\u0397 \u03B1\u03C0\u03CC\u03B4\u03B5\u03B9\u03BE\u03B7 \u03C0\u03C1\u03BF\u03C3\u03B8\u03AD\u03B8\u03B7\u03BA\u03B5 \u03B5\u03C0\u03B9\u03C4\u03C5\u03C7\u03CE\u03C2");
			return true;

		}catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null,"\u0394\u03B5\u03BD \u03C3\u03C5\u03BC\u03C0\u03BB\u03B7\u03C1\u03CE\u03C3\u03B1\u03C4\u03B5 \u03C3\u03C9\u03C3\u03C4\u03AC \u03BA\u03AC\u03C0\u03BF\u03B9\u03BF \u03C0\u03B5\u03B4\u03AF\u03BF, \u03C0\u03C1\u03BF\u03C3\u03C0\u03B1\u03B8\u03AE\u03C3\u03C4\u03B5 \u03BE\u03B1\u03BD\u03AC");
			return false;
		}
	}
	
	private void cancelButtonPressed(ActionEvent evt) {		
		dispose();
		inputDialog.setVisible(true);		
	}
	
	
}
