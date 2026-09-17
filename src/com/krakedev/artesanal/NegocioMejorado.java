package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	
	private ArrayList<Maquina> maquinas;
	private double cantidadesCambio;
	private double cantidadActual;
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private int ultimoCodigo = 100;

	
	
	public NegocioMejorado() {
		maquinas = new ArrayList<Maquina>();
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	public ArrayList<Cliente> getClientes() {
	    return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
	    this.clientes = clientes;
	}
	
	public String generarCodigo() {
        int numeroAleatorio = (int) (Math.random() * 100) + 1;
        return "M-" + numeroAleatorio;
    }
	
	public double getCantidadesCambio() {
		return cantidadesCambio;
	}

	public void setCantidadesCambio(double cantidadesCambio) {
		this.cantidadesCambio = cantidadesCambio;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(double cantidadActual) {
		this.cantidadActual = cantidadActual;
	}
	
	public int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public void setUltimoCodigo(int ultimoCodigo) {
		this.ultimoCodigo = ultimoCodigo;
	}
	
	//////

	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
	    String codigo = generarCodigo();
	    if (recuperarMaquina(codigo) != null) {
	        return false;
	    }
	    Maquina maquina = new Maquina(nombreCerveza, descripcion, precioPorMl, codigo);
	    maquinas.add(maquina);
	    return true;
	}
	
	
	public void cargarMaquinas() {

	    for (Maquina maquina : maquinas) {
	        maquina.llenarMaquina();
	    }
	}

	public Maquina recuperarMaquina(String codigo) {
	    for (Maquina maquina : maquinas) {
	        if (maquina.getCodigo().equals(codigo)) {
	            return maquina;
	        }
	    }
	    return null;
	}
	
	public void registrarCliente(String nombre, String cedula) {
	    Cliente cliente = new Cliente(nombre, cedula);
	    cliente.setCodigo(ultimoCodigo);
	    ultimoCodigo++;
	    clientes.add(cliente);
	}
	
	public Cliente buscarClientePorCedula(String cedula) {
	    for (Cliente cliente : clientes) {
	        if (cliente.getCedula().equals(cedula)) {
	            return cliente;
	        }
	    }
	    return null;
	}
	
	public Cliente buscarClientePorCodigo(int codigo) {
	    for (Cliente cliente : clientes) {
	        if (cliente.getCodigo() == codigo) {
	            return cliente;
	        }
	    }
	    return null;
	}
	
	public double consumirCerveza(int codigoCliente, String codigoMaquina, double cantidad) {
	    Maquina maquina = recuperarMaquina(codigoMaquina);
	    Cliente cliente = buscarClientePorCodigo(codigoCliente);
	    double valor = maquina.servirCerveza(cantidad);
	    registrarConsumo(cliente, valor);
	    return valor;
	}
	
	public void registrarConsumo(Cliente cliente, double valor) {
	    cliente.setTotalConsumido(cliente.getTotalConsumido() + valor);
	}
	
	public double consultarValorVendido() {
	    double total = 0;
	    for (Cliente cliente : clientes) {
	        total += cliente.getTotalConsumido();
	    }
	    return total;
	}
    
}
