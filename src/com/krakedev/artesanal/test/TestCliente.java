package com.krakedev.artesanal.test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestCliente {

	public static void main(String[] args) {
		
	        NegocioMejorado negocio = new NegocioMejorado();
	        negocio.registrarCliente("Juan Pérez", "0102030405");
	        System.out.println("Clientes registrados: " + negocio.getClientes().size());
	    }

	

}
