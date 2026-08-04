package com.krakedev.artesanal.testJUnit;

import com.krakedev.artesanal.Maquina;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestServirCervezaIA {

    private static final double TOLERANCIA = 0.0001;

    @Test
    public void testServirCervezaSuficienteConstructor1() {
        // Valida servir cerveza exitosamente cuando hay suficiente cantidad,
        // usando el constructor de 4 parámetros (con capacidad máxima personalizada).
        Maquina maquina = new Maquina("IPA", "India Pale Ale", 0.05, 5000.0);
        maquina.recargarCerveza(1000.0); // Cantidad actual = 1000 ml

        double cantidadAServir = 300.0;
        double valorEsperado = 300.0 * 0.05; // 15.0
        double cantidadRestanteEsperada = 700.0;

        double valorRetornado = maquina.servirCerveza(cantidadAServir);

        // Verifica que retorne el valor correcto a pagar y reduzca el stock disponible
        assertEquals(valorEsperado, valorRetornado, TOLERANCIA);
        assertEquals(cantidadRestanteEsperada, maquina.getCantidadActual(), TOLERANCIA);
    }

    @Test
    public void testServirCervezaSuficienteConstructor2() {
        // Valida servir cerveza usando el constructor de 3 parámetros (capacidad por defecto 10000).
        Maquina maquina = new Maquina("Stout", "Cerveza Negra", 0.08);
        maquina.recargarCerveza(2000.0); // Cantidad actual = 2000 ml

        double cantidadAServir = 500.0;
        double valorEsperado = 500.0 * 0.08; // 40.0
        double cantidadRestanteEsperada = 1500.0;

        double valorRetornado = maquina.servirCerveza(cantidadAServir);

        assertEquals(valorEsperado, valorRetornado, TOLERANCIA);
        assertEquals(cantidadRestanteEsperada, maquina.getCantidadActual(), TOLERANCIA);
    }

    @Test
    public void testServirCervezaCantidadExacta() {
        // Valida servir exactamente la totalidad de la cerveza disponible en la máquina.
        Maquina maquina = new Maquina("Golden", "Rubia suave", 0.04, 3000.0);
        maquina.recargarCerveza(400.0); // Cantidad actual = 400 ml

        double cantidadAServir = 400.0;
        double valorEsperado = 400.0 * 0.04; // 16.0
        double cantidadRestanteEsperada = 0.0;

        double valorRetornado = maquina.servirCerveza(cantidadAServir);

        // Debe servir todo, retornar el valor correcto y dejar la cantidad actual en 0
        assertEquals(valorEsperado, valorRetornado, TOLERANCIA);
        assertEquals(cantidadRestanteEsperada, maquina.getCantidadActual(), TOLERANCIA);
    }

    @Test
    public void testServirCervezaInsuficiente() {
        // Valida que si la máquina no tiene suficiente cerveza, no sirva nada,
        // retorne 0 y mantenga intacta la cantidad actual.
        Maquina maquina = new Maquina("Amber", "Roja especial", 0.06, 4000.0);
        maquina.recargarCerveza(200.0); // Cantidad actual = 200 ml

        double cantidadAServir = 500.0; // Se solicita más de lo disponible
        double valorEsperado = 0.0;
        double cantidadRestanteEsperada = 200.0; // No debe modificarse

        double valorRetornado = maquina.servirCerveza(cantidadAServir);

        assertEquals(valorEsperado, valorRetornado, TOLERANCIA);
        assertEquals(cantidadRestanteEsperada, maquina.getCantidadActual(), TOLERANCIA);
    }

    @Test
    public void testServirCervezaMaquinaVacia() {
        // Valida el comportamiento al intentar servir cuando la máquina está completamente vacía (0 ml).
        Maquina maquina = new Maquina("Pilsen", "Trigo tradicional", 0.03); // cantidadActual inicia en 0

        double cantidadAServir = 100.0;
        double valorEsperado = 0.0;
        double cantidadRestanteEsperada = 0.0;

        double valorRetornado = maquina.servirCerveza(cantidadAServir);

        assertEquals(valorEsperado, valorRetornado, TOLERANCIA);
        assertEquals(cantidadRestanteEsperada, maquina.getCantidadActual(), TOLERANCIA);
    }

    @Test
    public void testServirCervezaDespuesDeLlenarMaquina() {
        // Valida el cálculo del cobro y descuento de stock tras haber preparado la máquina con llenarMaquina().
        Maquina maquina = new Maquina("Porter", "Cerveza artesanal oscura", 0.05, 2000.0);
        maquina.llenarMaquina(); // Carga la máquina con capacidadMaxima - 100 = 1900 ml

        double cantidadAServir = 400.0;
        double valorEsperado = 400.0 * 0.05; // 20.0
        double cantidadRestanteEsperada = 1500.0; // 1900 - 400

        double valorRetornado = maquina.servirCerveza(cantidadAServir);

        assertEquals(valorEsperado, valorRetornado, TOLERANCIA);
        assertEquals(cantidadRestanteEsperada, maquina.getCantidadActual(), TOLERANCIA);
    }
}