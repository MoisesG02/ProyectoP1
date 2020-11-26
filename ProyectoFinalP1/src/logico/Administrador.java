package logico;

public class Administrador extends Empleado {
		private String pass;
		private String usuario;
		private float salario;
		
		public Administrador(String nombre, String id, String telefono, String direccion, String nacimiento, String sexo ,String pass, String usuario, float salario) {
		super(nombre, id, telefono, direccion, nacimiento, sexo);
		this.pass = pass;
		this.salario = salario;
		this.usuario = usuario;
	}
		
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
