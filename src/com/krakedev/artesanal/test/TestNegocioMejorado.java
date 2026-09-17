package com.krakedev.artesanal.test;


import com.krakedev.artesanal.Cliente;
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
        
        //Metodo consumir cerveza
        System.out.println("\n--- Consumo de cerveza ---");
        negocio.registrarCliente("Carlos Ruiz", "0304050607");

        Maquina maquinaIpa = negocio.getMaquinas().get(0);
        Cliente carlos = negocio.buscarClientePorCedula("0304050607");

        double cantidadAntes = maquinaIpa.getCantidadActual();
        double valor = negocio.consumirCerveza(carlos.getCodigo(), maquinaIpa.getCodigo(), 300);
        

        System.out.println("Cerveza consumida: " + maquinaIpa.getNombreCerveza());
        System.out.println("Valor devuelto por consumirCerveza: " + valor);
        System.out.println("Cantidad en la máquina bajó de " + cantidadAntes + " a " + maquinaIpa.getCantidadActual());
        System.out.println("Total consumido de Carlos (debe seguir en 0.0, aun no se acumula): " + carlos.getTotalConsumido());
        
        
        //metodo registrar consumo
        System.out.println("\n--- Registro del consumo ---");
        negocio.registrarCliente("Lucía Vera", "0405060708");
        Cliente lucia = negocio.buscarClientePorCedula("0405060708");

        System.out.println("Total antes: " + lucia.getTotalConsumido());
        negocio.registrarConsumo(lucia, 15.0);
        System.out.println("Total después de sumar 15.0: " + lucia.getTotalConsumido());
        negocio.registrarConsumo(lucia, 7.5);
        System.out.println("Total después de sumar 7.5 más (debe ser 22.5, no 7.5): " + lucia.getTotalConsumido());
        
        //integracion
        System.out.println("\n--- Integracion ---");
        Maquina maquinaIpa2 = negocio.getMaquinas().get(0);
        negocio.registrarCliente("Sofía Mena", "0506070809");
        Cliente sofia = negocio.buscarClientePorCedula("0506070809");

        double valor1 = negocio.consumirCerveza(sofia.getCodigo(), maquinaIpa2.getCodigo(), 200);
        System.out.println("Total de Sofía tras el primer consumo (debe ser igual a " + valor1 + "): " + sofia.getTotalConsumido());

        double valor2 = negocio.consumirCerveza(sofia.getCodigo(), maquinaIpa.getCodigo(), 150);
        System.out.println("Total de Sofía tras el segundo consumo (debe ser " + valor1 + " + " + valor2 + " = " + (valor1 + valor2) + "): " + sofia.getTotalConsumido());
        
        //Metodo consultar valor vendido
        System.out.println("\n--- Valor vendido ---");
        System.out.println("Total vendido: " + negocio.consultarValorVendido());
        
    }

}
