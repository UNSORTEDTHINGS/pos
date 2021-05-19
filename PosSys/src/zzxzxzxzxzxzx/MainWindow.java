package zzxzxzxzxzxzx;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Inventory inventory = new Inventory();
	DefaultTableModel model = new DefaultTableModel();
	BarcodeInput barcodeInput;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		barcodeInput = new BarcodeInput(this);
		barcodeInput.setBounds(10, 11, 409, 39);
		contentPane.add(barcodeInput);
		
		
		JButton btnNewButton = new JButton("PATENT RECORD");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(429, 8, 234, 116);
		contentPane.add(btnNewButton);
		
		JButton btnMangerLogin = new JButton("MANGER LOGIN");
		btnMangerLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMangerLogin.setBounds(429, 126, 234, 116);
		contentPane.add(btnMangerLogin);
		
		
		
		JButton btnRemoveItem = new JButton("REMOVE ITEM");
		btnRemoveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "NOTHING TO DELET");
					
				}
				else {
				model.removeRow(table.getSelectedRow());
				JOptionPane.showMessageDialog(null, "DELETED");
				}
			}
		});
		btnRemoveItem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveItem.setBounds(429, 244, 234, 116);
		contentPane.add(btnRemoveItem);
		
		JButton btnNewTransiction = new JButton("NEW TRANSICTION");
		btnNewTransiction.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewTransiction.setBounds(429, 365, 234, 116);
		contentPane.add(btnNewTransiction);
		
		JButton btnPayPrint = new JButton("PAY & PRINT SLIP");
		btnPayPrint.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPayPrint.setBounds(429, 491, 234, 116);
		contentPane.add(btnPayPrint);
		
		JLabel lblNewLabel = new JLabel("TOTAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 511, 73, 22);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setBounds(93, 511, 166, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setBounds(10, 61, 409, 439);
		contentPane.add(scrollPane);
		
		model =new DefaultTableModel(new Product[][] {},new String[] {"UPC NUMBER", "PRODUCT NAME", "PRICE"});
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		table.setModel(model);
		setTableCellAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(table);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(93, 546, 166, 25);
		contentPane.add(textField_2);
		
		JLabel lblPaid = new JLabel("PAID");
		lblPaid.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPaid.setBounds(10, 546, 73, 22);
		contentPane.add(lblPaid);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(93, 582, 166, 25);
		contentPane.add(textField_3);
		
		JLabel lblChange = new JLabel("CHANGE");
		lblChange.setHorizontalAlignment(SwingConstants.CENTER);
		lblChange.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChange.setBounds(10, 582, 73, 22);
		contentPane.add(lblChange);
		
		JLabel lblNewLabel_1 = new JLabel("$");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(267, 511, 19, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("$");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(267, 546, 19, 22);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("$");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(267, 582, 19, 22);
		contentPane.add(lblNewLabel_1_2);
	}
	private void setTableCellAlignment(int alignment) {
		DefaultTableCellRenderer renderer = new	DefaultTableCellRenderer();
	      renderer.setHorizontalAlignment(alignment);
	      for (int i=0; i<table.getColumnCount();i++){
	         table.setDefaultRenderer(table.getColumnClass(i),renderer);
	      }
	      // repaint to show table cell changes
	      table.updateUI();
	     }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(inventory.lookupFor(barcodeInput.getBarCode())) {
		model.insertRow(model.getRowCount(),
				new Object[]{inventory.getProduct().getProductNumber(),
						inventory.getProduct().getName(),
						(inventory.getProduct().getPrice()+"$")});
							
		barcodeInput.reset();
			
		}
		else {
			JOptionPane.showConfirmDialog(null, "PRODUCT NOT FOUNT OR NOT IN THE SYSTEM DO YOU LIKE TO ADD IT?");
		}
		
		
	}
}
