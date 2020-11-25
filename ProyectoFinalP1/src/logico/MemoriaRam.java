package logico;

public class MemoriaRam extends Componente {

	
	private int cantMemoria;
	private String tipoMemoria;
	//*
	public MemoriaRam(float precioV, String numSerie, int cantidad, String marca, String modelo, int cantMemoria, String tipoMemoria) {
		super(precioV, numSerie, cantidad, marca, modelo);
		this.cantMemoria = cantMemoria;
		this.tipoMemoria = tipoMemoria;
	}
	public int getCantMemoria() {
		return cantMemoria;
	}
	public String getTipoMemoria() {
		return tipoMemoria;
	}
	public void setCantMemoria(int cantMemoria) {
		this.cantMemoria = cantMemoria;
	}
	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}
}
