package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Combo implements Serializable {

	 private ArrayList<Componente> componentes;
	 private String codigo; 
	 private float precio;
	 private int desc;
	 private String nombre;
	 //.
	 
	public Combo(ArrayList<Componente>componentes,String nombre, float precio, int desc) {
		super();
		this.componentes = componentes;
		this.codigo = codigo;
		this.precio = precio;
		this.desc = desc;
		this.nombre = nombre;
	}
	
	
	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
	public String getCodigo() {
		return codigo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setComponentes(ArrayList<Componente> componentes) {
		this.componentes = componentes;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public void addCC(Componente comp) {
		componentes.add(comp);
			
	}
	public float precioComb() {
		float precioCombo = 0;
		precioCombo = (float)((100-desc)/100)*precio;
		
		return precioCombo;
	}


	public int getDesc() {
		return desc;
	}


	public void setDesc(int desc) {
		this.desc = desc;
	}
	public void insertarComponentesCombo(Componente compps) {
		componentes.add(compps);
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void insertCompCombo(Componente comp) {
		
	}
	
}
