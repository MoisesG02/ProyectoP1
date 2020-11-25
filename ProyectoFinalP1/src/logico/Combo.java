package logico;

import java.util.ArrayList;

public class Combo {

	 private ArrayList<Componente> componentes;
	 private String codigo; 
	 private float precio;
	 private int desc;
	 //.
	 
	public Combo(String codigo, float precio,int desc) {
		super();
		this.componentes = new ArrayList<Componente>();
		this.codigo = codigo;
		this.precio = precio;
		this.desc = desc;
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
	
}
