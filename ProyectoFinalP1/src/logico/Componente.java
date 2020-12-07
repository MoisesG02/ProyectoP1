package logico;

import java.io.Serializable;

public class Componente implements Serializable {
	
	protected float PrecioV;
	protected String numSerie;
	protected int cantidad;
	protected String marca;
	protected String modelo;
	//**
	
	public Componente(float precioV, String numSerie, int cantidad, String marca, String modelo) {
		super();
		PrecioV = precioV;
		this.numSerie = numSerie;
		this.cantidad = cantidad;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public float getPrecioV() {
		return PrecioV;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public int getCantidad() {
		return cantidad;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setPrecioV(float precioV) {
		PrecioV = precioV;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public float calcularP() {
		
		return PrecioV*cantidad;
		
		
		
	}
	

}
