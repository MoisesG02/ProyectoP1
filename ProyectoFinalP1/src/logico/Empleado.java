package logico;

public class Empleado {

	protected String nombre;
	protected String id;
	protected String telefono;
	protected String direccion;
	protected String nacimiento;
	protected String sexo;
	
	//*
	                              
	public Empleado(String nombre, String id, String telefono, String direccion, String nacimiento, String sexo) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nacimiento = nacimiento;
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	

	
}
