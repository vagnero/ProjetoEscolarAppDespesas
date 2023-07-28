package br.com.vag.calc.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.objecthunter.exp4j.ExpressionBuilder;


public class CalculadoraCodigo {
	private double soma;
	private double subtracao;
	private double multiplicacao;
	private double divisao;
	private double res;
	public static String n1="";
	public static String n2="";
	public static String somaDois = n1+n2;
	
	public static String padrao = "^[0-9]+(\\.[0-9]+)?(\\s*[-+*/]\\s*[0-9]+(\\.[0-9]+)?)*$";
	
	List<Double> lista = new ArrayList<>();
	List<CalculadoraObservador> observadores = new ArrayList<>();
	public static JPanel painel = new JPanel();
	
	
	public void registrarObservadores (CalculadoraObservador calc) {
		observadores.add(calc);
	}
	public void notificarObservadores (Double valor,CalcEvento evento) {
		observadores.stream().forEach(v -> v.eventoOcorreu(valor, evento));
	}
	
	public static String valorString (String valor) {
		StringBuilder sb = new StringBuilder(valor);
		if (valor.length()>0) {
			sb.deleteCharAt(valor.length() - 1);
		}
		return sb.toString();
	}
	
	public static boolean Combinacao(String valorX) {
		Pattern regex = Pattern.compile(padrao);
        Matcher matcher = regex.matcher(valorX);
        if (matcher.matches()) {
            return true;
            // Processe a entrada e execute as operações da calculadora
        } else {
            return false;
        }
	}
	
	public static double calcular(String valor) {
		String valor2 = "";
		char caractere = 'f';
		double resposta = 0.0;
		for (int i = 0; i < valor.length(); i++) {
			caractere = valor.charAt(i);
			if (caractere == 'x') {
				caractere = '*';
			}else if (caractere ==',') {
				caractere='.';
			}else if (caractere == '÷') {
				caractere = '/';
			}
			
			valor2 += caractere;
		}
		
		try {
			resposta = new ExpressionBuilder(valor2).build().evaluate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(painel, "Valores inseridos incorretamente, tente novamente!");
		}
		n1 = resposta+"";
		n1.replace(',','.');
		return resposta;
	}
	
	public void somar(double n1, double n2) {
		if (lista.size()>1) {
			n1 = lista.get(lista.size()-1);
		}
		this.soma = n1+n2;
		
	}
	public double numeros (String n) {
		return Double.parseDouble(n);
	}
	
	public static boolean todosNumeros(String v) {
		for (int i = 0; i<10; i++) {
			if (v.equals(i+"")) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean todosSimbolos(String v) {
		if (v.equals("+")||v.equals("-")||v.equals("x")||v.equals("÷")||v.equals("."))  {
			return true;
		}
		return false;	
	}
	
	public static boolean contemSimbolo(String v) {
		if (v.contains("+")||v.contains("-")||v.contains("x")||v.contains("÷"))  {
			return true;
		}
		return false;	
	
	}
	
	
	
	
	
	public static boolean naoRepetirSimbolos() {
		if (!n1.contains("+")&& (!n1.contains("-"))&& (!n1.contains("x")) && (!n1.contains("÷"))) {
			return true;
		}
		return false;
	}
	
	public void subtrair(double n1, double n2) {
		this.subtracao = n1-n2;
		notificarObservadores(subtracao,CalcEvento.SUBTRAIR);
	}
	public double getSoma() {
		return soma;
	}
	public double getSubtracao() {
		return subtracao;
	}

	
	
}
