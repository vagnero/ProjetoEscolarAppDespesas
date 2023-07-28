package br.com.vag.calc.visao;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PainelCalculadora extends JPanel {
	 private JTextField display;
	 private static JTextArea textField = new JTextArea (5,20);
	 
	public PainelCalculadora() {
		Font fonte = new Font("Arial", Font.BOLD, 70);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		display = new JTextField();
		setLayout(new GridLayout(2, 1));
		JPanel topPanel = new JPanel(new GridLayout(1, 4)); // Inner GridLayout with 1 row and 4 columns
		topPanel.setPreferredSize(new Dimension (getPreferredSize().width,40));
		
		textField.setColumns(4);
		topPanel.add(textField);
		JPanel bottomPanel = new JPanel(new GridLayout(6, 4)); // Inner GridLayout with 6 rows and 4 columns
		
		textField.setEditable(false);
		textField.setFont(fonte);
	
		
		
		
		//setLayout(gridLayout);
		for (int i = 0; i<18; i++) {
			bottomPanel.add(new Botoes());
		}
		
		//setLayout(gridBagLayout);
		add(topPanel);
		add(bottomPanel);
		
	}

	public JTextArea  getTextField() {
		return textField;
	}
	public static void returnString(String valor) {
		textField.setText(valor);
		
	}

	
	

	
	
}
