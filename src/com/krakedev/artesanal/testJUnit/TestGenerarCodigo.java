package com.krakedev.artesanal.testJUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class TestGenerarCodigo {

    private NegocioMejorado negocio;

    @BeforeEach
    void setUp() {
        negocio = new NegocioMejorado();
    }

    @Test
    @DisplayName("El código generado no debe ser nulo")
    void testGenerarCodigoNoEsNulo() {
        String codigo = negocio.generarCodigo();
        assertNotNull(codigo, "El código no debería ser null");
    }

    @Test
    @DisplayName("El código debe iniciar con el prefijo 'M-'")
    void testGenerarCodigoFormatoPrefijo() {
        String codigo = negocio.generarCodigo();
        assertTrue(codigo.startsWith("M-"), "El código debe empezar con 'M-'");
    }

    @RepeatedTest(100)
    @DisplayName("El número aleatorio del código debe estar dentro del rango 1 a 100")
    void testGenerarCodigoRangoNumerico() {
        String codigo = negocio.generarCodigo();
        
        String numeroStr = codigo.substring(2);
        int numero = Integer.parseInt(numeroStr);

        assertTrue(numero >= 1 && numero <= 100, 
            "El número " + numero + " debe estar entre 1 y 100");
    }
}