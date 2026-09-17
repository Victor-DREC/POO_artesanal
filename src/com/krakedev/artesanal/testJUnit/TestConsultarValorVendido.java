package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsultarValorVendido {
	
	@Test
	void testConsultarValorVendido() {
	    NegocioMejorado negocio = new NegocioMejorado();
	    negocio.agregarMaquina("IPA", "desc", 0.05);
	    negocio.cargarMaquinas();
	    Maquina maquina = negocio.getMaquinas().get(0);

	    negocio.registrarCliente("Cliente 1", "111");
	    negocio.registrarCliente("Cliente 2", "222");

	    Cliente c1 = negocio.getClientes().get(0);
	    Cliente c2 = negocio.getClientes().get(1);

	    negocio.consumirCerveza(c1.getCodigo(), maquina.getCodigo(), 200);
	    negocio.consumirCerveza(c2.getCodigo(), maquina.getCodigo(), 100);

	    double esperado = (200 * 0.05) + (100 * 0.05);
	    assertEquals(esperado, negocio.consultarValorVendido(), 0.001);
	}

}
