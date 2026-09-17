package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	
	private ArrayList<Maquina> maquinas;
	private double cantidadesCambio;
	private double cantidadActual;
	private ArrayList<Cliente> clientes;

	
	
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
    
}
