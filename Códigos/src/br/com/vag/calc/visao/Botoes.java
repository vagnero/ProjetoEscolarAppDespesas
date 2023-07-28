package br.com.vag.calc.visao;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import br.com.vag.calc.modelo.CalculadoraCodigo;
	


public class Botoes extends JButton implements MouseListener {
	private static int contador = 0;
	private List<Botoes> lista = new ArrayList<>();
	String valor ="";
	
	public Botoes() {
		addMouseListener(this);
		addOperacoes();
		lista.add(this);
		contador++;
	}
	
	public void addOperacoes() {
		
		setFont(new Font("Dialog", Font.BOLD, 40));
		switch(this.contador) {
		case 0:
			setText("+");
			break;
		case 1:
			setText("-");
			break;
		case 2:
			setText("x");
			break;
		case 3:
			setText("÷");
			break;
		case 14:
			setText(".");
			break;
		case 15:
			setText("=");
			break;
		case 16:
			setText("⌫");
			break;
		case 17:
			setText("C");
			break;
		case 18:
		default:
			
		}
		if (contador >3 && contador<14) {
			setText((contador-4)+"");
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String valor ="";
		if (e.getButton() ==1&& (CalculadoraCodigo.todosNumeros(this.getText()))) {
			CalculadoraCodigo.n1 +=this.getText();
			PainelCalculadora.returnString(CalculadoraCodigo.n1);
		
		}
		if (e.getButton() ==1&& (this.getText().equals("="))) {
			System.out.println(CalculadoraCodigo.calcular(CalculadoraCodigo.n1));
			PainelCalculadora.returnString(CalculadoraCodigo.n1);
	}
		
		
		if (e.getButton() ==1&& (this.getText().equals("⌫"))) {
			CalculadoraCodigo.n1 =CalculadoraCodigo.valorString(CalculadoraCodigo.n1);
			PainelCalculadora.returnString(CalculadoraCodigo.n1);
	}
		if (e.getButton() ==1&& (CalculadoraCodigo.todosSimbolos(this.getText()))) {
			CalculadoraCodigo.n1 +=this.getText();
			PainelCalculadora.returnString(CalculadoraCodigo.n1);
	}
	if (e.getButton() ==1&& (this.getText().equals("C"))) {
		CalculadoraCodigo.n1 = "";
		PainelCalculadora.returnString(CalculadoraCodigo.n1);
	}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
