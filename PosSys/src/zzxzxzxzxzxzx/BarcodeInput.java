package zzxzxzxzxzxzx;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class BarcodeInput extends JTextField {
	
	
	public BarcodeInput(ActionListener actionListener) {
		this.requestFocusInWindow();
		this.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.addActionListener(actionListener);
			
	}

	public String getBarCode() {
		return this.getText();
	}
	
	public void reset() {
		this.setText("");
		
	}

}
