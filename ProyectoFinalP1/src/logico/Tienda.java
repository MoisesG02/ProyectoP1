package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Tienda implements Serializable {

	private ArrayList<Componente> misComps;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Combo> misCombos;
	private ArrayList<Empleado> misEmpleados;
	private ArrayList<Componente> misCompCombo;
	private static Tienda tiendita = null;
	private static int codFactura;
	private static int codComponente;
	public static int codCombo;
	public static Tienda tienda = null;
	//*

	public Tienda() {
		super();
		misCompCombo = new ArrayList<Componente>();
		misComps = new ArrayList<Componente>();
		misFacturas = new ArrayList<Factura>();
		misClientes = new ArrayList<Cliente>();
		misCombos = new ArrayList<Combo>();
		misEmpleados = new ArrayList<Empleado>();
		codFactura = 1;
		codComponente = 1;
		codCombo = 1;
	}

	public static Tienda getInstance() {
		if (tiendita == null) {
			tiendita = new Tienda();
		}
		return tiendita;

	}

	public ArrayList<Componente> getMisComps() {
		return misComps;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}

	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}

	public void setMisComps(ArrayList<Componente> misComps) {
		this.misComps = misComps;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}

	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}

	public void insertarFactura(Factura factura) {
		misFacturas.add(factura);
		codFactura++;
	}

	public void insertarComponente(Componente comp) {
		misComps.add(comp);
		codComponente++;
	}

	public void insertarCliente(Cliente client) {
		misClientes.add(client);
		System.out.println(misClientes);
	}
	public void insertarEmpleado(Empleado employee) {
		misEmpleados.add(employee);
	}

	
	public boolean BuscarCliente(String ced) {
		boolean encontrado  = false;
		Cliente client = null;
		int c = 0;
		while(c <misClientes.size()) {
			if(misClientes.get(c).getCedula().equalsIgnoreCase(ced)) {
				client = misClientes.get(c);
				encontrado = true;
				System.out.println(client);
			}
			c++;
		}
		return encontrado;
	}
	

	public void insertEmpleado(Empleado employee) {
		misEmpleados.add(employee);
	}
	public void insertarComponentesCombo(ArrayList<Componente> misCompCant) {
		misCompCombo.addAll(misCompCant);
		System.out.println(""+misCompCombo);

	}

	public void insertarCombo(Combo combito) {
		misCombos.add(combito);
		codCombo++;
		System.out.println(""+misCombos+""+codCombo);
	}
	

	public Componente obtenerComponente(String NumSerie) {
		Componente comp = null;
		boolean encontrado = false;
		int i = 0;
		while (i < misComps.size() && !encontrado) {
			if (misComps.get(i).getNumSerie().equalsIgnoreCase(NumSerie)) {
				comp = misComps.get(i);
				encontrado = true;
			}
			i++;
		}
		return comp;
	}
	public float precioTComponentes(ArrayList<Componente> comp,ArrayList<Integer> cant) {
		float precioT = 0;
		int c = 0;
		if(!comp.isEmpty() &&!cant.isEmpty()) {
			for(Componente comps :misComps) {
				precioT += comps.getPrecioV()*cant.get(c);
				c++;
			}
		}
		
		return precioT;
	}

	public float obtenerpreciodadoFactura(String cod) {
		float precio = 0;
		Factura facturita = obtenerfacturabycod(cod);
		if(facturita!=null) {
        for (Componente facturin : facturita.getComps()) {
			precio += facturin.getPrecioV()* facturin.getCantidad();
		}
		}
		return precio;
		
	}	
	
	

	public Factura obtenerfacturabycod(String codigo) {
		Factura facturita = null;
		int i = 0;
		boolean encontrado = false;
		while (i < misFacturas.size() && !encontrado) {
			if (misFacturas.get(i).getCodFactura().equalsIgnoreCase(codigo)) {
				facturita = misFacturas.get(i);
				encontrado = true;
			}
			i++;
		}
		return facturita;

	}
	public boolean eliminarC(Componente componente) {
			boolean encontrado  = false;
			for(Combo combx :misCombos) {
				
				for(Componente compo :misComps) {
					if(compo == componente) {
						encontrado = true;
						misComps.remove(componente);
					}
					if(compo != componente) {
						encontrado = false;
					}
				}
			}
		
		
		return encontrado;
	}
	public boolean buscarEmpleado(String cedula) {
		boolean encontrado = false;
		int c = 0;
		
		while(c<misEmpleados.size()) {
			if(misEmpleados.get(c).getId().equalsIgnoreCase(cedula)) {
				encontrado = true;
			}
			c++;
		}
		
		return encontrado;
	}
	public Cliente buscarCliente(String cedula) {
		boolean encontrado = false;
		Cliente client = null;
		int c = 0;
		while(c<misClientes.size()) {
			if(misClientes.get(c).getCedula().equalsIgnoreCase(cedula)) {
				encontrado = true;
				client = misClientes.get(c);
				
				
			}
			c++;
		}
		return client;
	}

	public static Tienda getTiendita() {
		return tiendita;
	}

	public static int getCodFactura() {
		return codFactura;
	}

	public static int getCodComponente() {
		return codComponente;
	}

	public static int getCodCombo() {
		return codCombo;
	}

	public static void setTiendita(Tienda tiendita) {
		Tienda.tiendita = tiendita;
	}

	public static void setCodFactura(int codFactura) {
		Tienda.codFactura = codFactura;
	}

	public static void setCodComponente(int codComponente) {
		Tienda.codComponente = codComponente;
	}

	public static void setCodCombo(int codCombo) {
		Tienda.codCombo = codCombo;
	}
	public static void setTienda(Tienda tienda1) {
		Tienda.tienda = tienda1;
	}

	public ArrayList<Componente> getMisCompCombo() {
		return misCompCombo;
	}

	public void setMisCompCombo(ArrayList<Componente> misCompCombo) {
		this.misCompCombo = misCompCombo;
	}
	

}
