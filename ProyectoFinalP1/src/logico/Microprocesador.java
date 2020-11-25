package logico;

public class Microprocesador extends Componente {

	private String tipoConexion;
	private double velocidadProccess;
	//*
	public Microprocesador(float precioV, String numSerie, int cantidad, String marca, String modelo, String tipoConexion, float velocidadProccess) {
		super(precioV, numSerie, cantidad, marca, modelo);
		this.tipoConexion = tipoConexion;
		this.velocidadProccess = velocidadProccess;
	}
	public String getTipoConexion() {
		return tipoConexion;
	}
	public double getVelocidadProccess() {
		return velocidadProccess;
	}
	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
	public void setVelocidadProccess(double velocidadProccess) {
		this.velocidadProccess = velocidadProccess;
	}
	
}
