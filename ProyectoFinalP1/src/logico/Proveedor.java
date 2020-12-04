package logico;

import java.io.Serializable;

public class Proveedor implements Serializable {

	private String nombre, direccion, numTel, rnc;
	private int cod;
	
	public Proveedor(String nombre, String direccion, String numTel, String rnc, int cod) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.numTel = numTel;
		this.rnc = rnc;
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getRnc() {
		return rnc;
	}

	public void setRnc(String rnc) {
		this.rnc = rnc;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
	
	
	
	
}
