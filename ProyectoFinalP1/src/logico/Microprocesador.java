package logico;

public class Microprocesador extends Componente {

	private String tipoConexion;
	private String velocidadProccess;
	//*
	public Microprocesador(float precioV, String numSerie, int cantidad, String marca, String modelo, String tipoConexion, String text1) {
		super(precioV, numSerie, cantidad, marca, modelo);
		this.tipoConexion = tipoConexion;
		this.velocidadProccess = text1;
	}
	public String getTipoConexion() {
		return tipoConexion;
	}
	public String getVelocidadProccess() {
		return velocidadProccess;
	}
	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
	public void setVelocidadProccess(String velocidadProccess) {
		this.velocidadProccess = velocidadProccess;
	}
	
}
