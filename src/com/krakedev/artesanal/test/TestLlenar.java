package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		
		Maquina rubia = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000, "001001");
		rubia.imprimir();
		rubia.llenarMaquina();
		rubia.imprimir();
		
		Maquina negra = new Maquina("Club", "Cerveza buena", 0.03, "002002");
		negra.imprimir();
		negra.llenarMaquina();
		negra.imprimir();

	}

}
