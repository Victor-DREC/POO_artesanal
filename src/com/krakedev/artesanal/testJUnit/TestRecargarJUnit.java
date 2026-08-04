package com.krakedev.artesanal.testJUnit;

import com.krakedev.artesanal.Maquina;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestRecargarJUnit {
	
	@Test
	public void testRecargarRecargaExitosa() {
		
		Maquina rubia = new Maquina("Pilsener", "Cerveza", 0.02, 8000, "001001");
		
		boolean resultado = rubia.recargarCerveza(3000);
		
		assertTrue(resultado);
		
		assertEquals(3000, rubia.getCantidadActual(), 0.0001);
		
	}
	
	
	@Test
	public void testRecargaFallidaPorDesbordo() {
		
		Maquina negra = new Maquina("Club", "Cerveza fria", 0.03, 8000, "002002");
		
		negra.recargarCerveza(7000);
		
		boolean resultado = negra.recargarCerveza(1000);
		
		assertTrue(resultado);
		
		assertEquals(3000, negra.getCantidadActual(), 0.0001);
		
	}

}
