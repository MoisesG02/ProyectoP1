package logico;

import java.util.ArrayList;

public class TarjetaMadre extends Componente {
	private String tipoConector;
	private String tipoRAM;
	private ArrayList<DiscoDuro> discos;
	//*
	
	public TarjetaMadre(float precioV, String numSerie, int cantidad, String marca, String modelo, String tipoConector, String tipoRAM ) {
		super(precioV, numSerie, cantidad, marca, modelo);
		this.tipoConector = tipoConector;
		this.tipoRAM = tipoRAM;
		discos = new ArrayList<DiscoDuro>();
	}

	public String getTipoConector() {
		return tipoConector;
	}
	public String getTipoRAM() {
		return tipoRAM;
	}
	public ArrayList<DiscoDuro> getDiscos() {
		return discos;
	}
	public void setTipoConector(String tipoConector) {
		this.tipoConector = tipoConector;
	}
	public void setTipoRAM(String tipoRAM) {
		this.tipoRAM = tipoRAM;
	}
	public void setDiscos(ArrayList<DiscoDuro> discos) {
		this.discos = discos;
	}

}
