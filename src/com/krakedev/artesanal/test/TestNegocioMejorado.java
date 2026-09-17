package com.krakedev.artesanal.test;


import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestNegocioMejorado {

	public static void main(String[] args) {
		
        NegocioMejorado negocio = new NegocioMejorado();

        System.out.println("--- Agregando máquinas de cerveza ---");
        negocio.agregarMaquina("IPA Artesanal", "Cerveza intensa con notas cítricas", 0.05);
        negocio.agregarMaquina("Stout Cream", "Cerveza negra con cuerpo y aroma a café", 0.06);
        negocio.agregarMaquina("Golden Ale", "Cerveza rubia refrescante", 0.04);

        //Genera codigo aleatorio
        System.out.println("\n--- Prueba directa del método generarCodigo() ---");
        System.out.println("Código aleatorio suelto: " + negocio.generarCodigo());

        //Agregar Maquinas
        System.out.println("\n--- Lista de máquinas guardadas ---");
        for (Maquina maquina : negocio.getMaquinas()) {
            System.out.println("Código: " + maquina.getCodigo() +
                               " | Cerveza: " + maquina.getNombreCerveza() +
                               " | Descripción: " + maquina.getDescripcion() +
                               " | Precio/ml: $" + maquina.getPrecioPorMl());
        }
        
        //Metodo Cargar Maquinas
        System.out.println("\n--- Carga de Maquinas ---");
        negocio.cargarMaquinas();
        for (Maquina m : negocio.getMaquinas()) {
            m.imprimir();
        }
        
        //Metodo Recuperar Maquina
        System.out.println("\n--- Recuperar Maquina ---");
        String codigoExistente = negocio.getMaquinas().get(negocio.getMaquinas().size() - 1).getCodigo();

        Maquina encontrada = negocio.recuperarMaquina(codigoExistente);
        System.out.println("Buscando código existente (" + codigoExistente + "): "
                + (encontrada != null ? "encontrada -> " + encontrada.getNombreCerveza() : "no encontrada"));

        Maquina noEncontrada = negocio.recuperarMaquina("M-999");
        System.out.println("Buscando código inexistente (M-999): "
                + (noEncontrada != null ? "encontrada" : "no encontrada, como se esperaba"));
    }

}
