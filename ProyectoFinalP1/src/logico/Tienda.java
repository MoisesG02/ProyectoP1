package logico;

import java.util.ArrayList;

public class Tienda {

	private ArrayList<Componente> misComps;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Combo> misCombos;
	private ArrayList<Empleado> misEmpleados;
	private static Tienda tiendita = null;
	private static int codFactura;
	private static int codComponente;
	private static int codCombo;
	//*

	public Tienda() {
		super();
		this.misComps = new ArrayList<Componente>();
		this.misFacturas = new ArrayList<Factura>();
		this.misClientes = new ArrayList<Cliente>();
		this.misCombos = new ArrayList<Combo>();
		this.misEmpleados = new ArrayList<Empleado>();
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
	
	public int BuscarCliente(String ced) {
		int index = -1;
		int j = 0;
		
		for (Cliente i : misClientes) {
			if(i.getCedula().equalsIgnoreCase(ced)) {
				index = j;
				break;
			}
			j++;
		}
		return index;
	}
	

	public void insertEmpleado(Empleado employee) {
		misEmpleados.add(employee);
	}

	public void insertarCombo(Combo combito) {
		misCombos.add(combito);
		codCombo++;
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

}
