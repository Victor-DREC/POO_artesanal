package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquina {
	
	@Test
    public void testAgregarMaquinaExitoso() {
        NegocioMejorado negocio = new NegocioMejorado();

        // 1. Ejecutamos el método
        boolean resultado = negocio.agregarMaquina("IPA Artesanal", "Cerveza amarga", 0.05);

        // 2. Verificamos que devuelva true y que la lista tenga 1 elemento
        assertTrue(resultado, "El método debería retornar true al agregar una máquina válida.");
        assertEquals(1, negocio.getMaquinas().size(), "El tamaño de la lista de máquinas debería ser 1.");
    }

    @Test
    public void testAgregarMaquinaCodigoDuplicado() {
        // Sobrescribimos el comportamiento o simulamos la condición donde generarCodigo() repite un código existente
        NegocioMejorado negocio = new NegocioMejorado() {
            @Override
            public String generarCodigo() {
                return "M-10"; // Forzamos a que siempre genere el mismo código "M-10"
            }
        };

        // 1. Agregamos la primera máquina (se guardará con código M-10)
        boolean primeraCarga = negocio.agregarMaquina("IPA Artesanal", "Cerveza amarga", 0.05);
        assertTrue(primeraCarga, "La primera inserción debería ser exitosa.");

        // 2. Intentamos agregar otra máquina con el mismo código forzado
        boolean segundaCarga = negocio.agregarMaquina("Stout Cream", "Cerveza negra", 0.06);

        // 3. Verificamos que retorne false y que no se haya agregado a la lista
        assertFalse(segundaCarga, "Debería retornar false cuando recuperarMaquina encuentra un código duplicado.");
        assertEquals(1, negocio.getMaquinas().size(), "La lista no debería incrementar su tamaño al fallar la inserción.");
    }

}
