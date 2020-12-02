package logico;

import java.sql.Date;

public class main {
	public static void main(String[] args) {
	
	Tienda tiendita = new Tienda();
	Cliente client0 = new Cliente("402-1118709-7", "Freddy" , "8298149010", "Calle H, #9");
	Componente comp0 = new MemoriaRam(500,"402",1,"MSI","HG-014",6,"DDR4");
	//Componente comp1 = new Microprocesador(1000,"523",1,"INTEL", "I7", "SOCKET",3.6f);

	Factura facturita0 = new Factura(client0, "402");
    
	tiendita.insertarCliente(client0);
	tiendita.insertarComponente(comp0);
	//tiendita.insertarComponente(comp1);
	
	Combo com = new Combo("222",32,500);
	tiendita.insertarCombo(com);
	
	tiendita.insertarFactura(facturita0);
	facturita0.insetarCompenFactura(comp0);
	//facturita0.insetarCompenFactura(comp1);
	System.out.println(""+tiendita.obtenerpreciodadoFactura("402"));
	System.out.println(""+tiendita.obtenerComponente("402"));
	//hola
	}
}
