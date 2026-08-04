package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestLlenarJUnit {

	@Test
	public void testLlenarMaquina() {
		
		Maquina rubia = new Maquina("Pilsener", "Cerveza", 0.02, 8000, "001001");
		
		rubia.llenarMaquina();
		
		assertEquals(7900, rubia.getCantidadActual()); //el 1er parametro es el resultado esperado, el 2do es de donde lo vamos a tomar, el 3ro es el margen de error
		
	}
	
}
