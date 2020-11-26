package logico;

public class Vendedores extends Empleado {

			
			private String password;
			private float ventas;
			private String usuario;
			private float salario;
			public Vendedores(String nombre, String id, String telefono, String direccion, String nacimiento, String sexo, String password,String usuario, float salario, float ventas) {
		super(nombre, id, telefono, direccion, nacimiento, sexo);
		
			this.password = password;
			this.ventas = ventas;
			this.salario = salario;
			this.usuario = usuario;
			}

		
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getVentas() {
		return ventas;
	}
	public void setVentas(float ventas) {
		this.ventas = ventas;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public float getSalario() {
		return salario;
	}



	public void setSalario(float salario) {
		this.salario = salario;
	}

	
}

