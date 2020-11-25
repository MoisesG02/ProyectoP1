package logico;

import java.util.ArrayList;
import java.util.Date;

public class Factura {

	private float PrecioTotal;
	private Date FechaActual;
	private Cliente clients;
	private ArrayList<Componente> comps;
	private String codFactura;
	private Cliente client;
	//*
	
	public Factura( Cliente clients, String codFactura) {
		super();
		FechaActual = new Date();
		this.clients = clients;
		this.comps = new ArrayList<Componente>();
		this.codFactura = codFactura;
	}
	
	public float getPrecioTotal() {
		return PrecioTotal;
	}
	public Date getFechaActual() {
		return FechaActual;
	}
	public Cliente getClients() {
		return clients;
	}

	public void setPrecioTotal(float precioTotal) {
		PrecioTotal = precioTotal;
	}
	public void setFechaActual(Date fechaActual) {
		FechaActual = fechaActual;
	}
	public void setClients(Cliente clients) {
		this.clients = clients;
	}
	

	public String getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(String codFactura) {
		this.codFactura = codFactura;
	}

	public ArrayList<Componente> getComps() {
		return comps;
	}

	public void setComps(ArrayList<Componente> comps) {
		this.comps = comps;
	}
	public void insetarCompenFactura(Componente componente) {
		comps.add(componente);
	}

}
