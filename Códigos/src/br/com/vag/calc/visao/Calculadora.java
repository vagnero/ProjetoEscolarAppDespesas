package br.com.vag.calc.visao;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Calculadora extends JFrame {
	
	public Calculadora() {
		setSize(500,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new PainelCalculadora());
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new Calculadora();
		
	}
	
}
