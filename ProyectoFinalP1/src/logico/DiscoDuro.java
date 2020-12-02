package logico;

public class DiscoDuro extends Componente {

	
	private String capacidad;
	private String tipoConexion;
	//*
	
	public DiscoDuro(float precioV, String numSerie, int cantidad, String marca, String modelo, String capacidad, String tipoConexion) {
		super(precioV, numSerie, cantidad, marca, modelo);
		this.capacidad = capacidad;
		this.tipoConexion = tipoConexion;
	}
	

	public String getCapacidad() {
		return capacidad;
	}
	public String getTipoConexion() {
		return tipoConexion;
	}
	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}
	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
}
