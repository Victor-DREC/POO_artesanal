package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestCliente {

	public static void main(String[] args) {
		
	        NegocioMejorado negocio = new NegocioMejorado();
	        negocio.registrarCliente("Juan Pérez", "0102030405");
	        System.out.println("Clientes registrados: " + negocio.getClientes().size());
	        
	        Cliente encontrado = negocio.buscarClientePorCedula("0102030405");
	        System.out.println(encontrado != null ? "Cliente encontrado por cédula" : "No encontrado");
	        
	        Cliente encontrado1 = negocio.buscarClientePorCedula("010203040");
	        System.out.println(encontrado1 != null ? "Cliente encontrado por cédula" : "No encontrado");
	        
	        Cliente porCodigo = negocio.buscarClientePorCodigo(100);
	        System.out.println(porCodigo != null ? "Cliente encontrado por código" : "No encontrado");
	        
	        Cliente porCodigo1 = negocio.buscarClientePorCodigo(1);
	        System.out.println(porCodigo1 != null ? "Cliente encontrado por código" : "No encontrado");
	    }

	

}
