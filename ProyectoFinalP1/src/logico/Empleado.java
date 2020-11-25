package logico;

public class Empleado {

	protected String nombre;
	protected String id;
	protected String cod;
	protected String password;
	//*
	                              
	public Empleado(String nombre, String id, String cod, String password) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.cod = cod;
		this.password = password;
	}
	

	public String getNombre() {
		return nombre;
	}
	public String getId() {
		return id;
	}
	public String getCod() {
		return cod;
	}
	public String getPassword() {
		return password;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
