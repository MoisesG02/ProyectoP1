package logico;

public class DiscoDuro extends Componente {

	
	private float capacidad;
	private String tipoConexion;
	//*
	
	public DiscoDuro(float precioV, String numSerie, int cantidad, String marca, String modelo, float capacidad, String tipoConexion) {
		super(precioV, numSerie, cantidad, marca, modelo);
		this.capacidad = capacidad;
		this.tipoConexion = tipoConexion;
	}
	

	public float getCapacidad() {
		return capacidad;
	}
	public String getTipoConexion() {
		return tipoConexion;
	}
	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}
	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
}
