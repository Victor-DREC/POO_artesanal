package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestRecuperarMaquina {
	
	@Test
    public void testRecuperarMaquinaExitoso() {
        // 1. Instanciamos la clase del negocio
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.agregarMaquina("IPA Artesanal", "Cerveza amarga", 0.05);

        // 2. Obtenemos el código real generado dinámicamente
        Maquina maquinaEsperada = negocio.getMaquinas().get(0);
        String codigoBuscado = maquinaEsperada.getCodigo();

        // 3. Ejecutamos el método a probar
        Maquina maquinaObtenida = negocio.recuperarMaquina(codigoBuscado);

        // 4. Verificaciones con JUnit 5
        assertNotNull(maquinaObtenida, "La máquina no debería ser nula.");
        assertEquals(codigoBuscado, maquinaObtenida.getCodigo(), "Los códigos deben coincidir.");
    }

    @Test
    public void testRecuperarMaquinaNoEncontrada() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.agregarMaquina("Stout Cream", "Cerveza negra", 0.06);

        // Buscamos un código que no existe en el ArrayList
        Maquina maquinaObtenida = negocio.recuperarMaquina("CODIGO-INEXISTENTE");

        // Verificamos que retorne null
        assertNull(maquinaObtenida, "Debe retornar null cuando el código no existe.");
    }

    @Test
    public void testRecuperarMaquinaListaVacia() {
        NegocioMejorado negocio = new NegocioMejorado();

        // Se prueba buscar en un ArrayList recién instanciado
        Maquina maquinaObtenida = negocio.recuperarMaquina("M-10");

        assertNull(maquinaObtenida, "Debe retornar null si la lista de máquinas está vacía.");
    }

}
