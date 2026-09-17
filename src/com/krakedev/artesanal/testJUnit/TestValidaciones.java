package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestValidaciones {
	
	@Test
	void testConsumirCerveza() {
	    NegocioMejorado negocio = new NegocioMejorado();
	    negocio.agregarMaquina("IPA", "desc", 0.05);
	    Maquina maquina = negocio.getMaquinas().get(0);
	    negocio.cargarMaquinas();
	    negocio.registrarCliente("Ana Torres", "0101010101");
	    Cliente cliente = negocio.getClientes().get(0);

	    double cantidadAntes = maquina.getCantidadActual();
	    double valor = negocio.consumirCerveza(cliente.getCodigo(), maquina.getCodigo(), 300);

	    assertEquals(300 * 0.05, valor, 0.001);
	    assertEquals(cantidadAntes - 300, maquina.getCantidadActual(), 0.001);
	    assertEquals(valor, cliente.getTotalConsumido(), 0.001);
	}

}
