package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;


import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.Tienda;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class Registrar_Componente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNumSerie;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField textPrecioVenta;
	private JTextField txtNumSerie1;
	private JTextField txtNumSerieDisco;
	private JTextField txtMarcaDisco;
	private JTextField txtModeloDisco;
	private JTextField textField;
	private JTextField txtCapacidad;
	private JTextField textField_1;
	private JTextField txtConexion;
	private JTextField txtNumSerieRAM;
	private JTextComponent txtMarcaRAM;
	private JTextField txtModeloRAM;
	private JTextField txtCapacidadRAM;
	private JTextField txtTipoRAM;
	private JPanel panelMemoriaRAM;
	private JPanel panelDiscoDuro;
	private JComboBox cbxTipoComponente;
	private JComponent lblTipoDeComponente;
	private JComponent lblCantidad;
	private JSpinner spinnerCantidad;
	private JPanel panelGeneral;
	private JLabel lblNumSerie;
	private JLabel lblMarca;
	private JComponent lblModelo;
	private JLabel lblNumSerieDisco;
	private JLabel lblMarcaDisco;
	private JComponent lblModeloDisco;
	private JLabel lblCapacidad;
	private JLabel lblTipoConexion;
	private JLabel lblNumSerieRAM;
	private JLabel lblMarcaRAM;
	private JLabel lblModeloRAM;
	private JLabel lblCapacidadRAM;
	private JLabel lblTipoRAM;
	private JPanel panelMicro;
	private JLabel lblNumSerieMicro;
	private JTextField txtNumSerieMicro;
	private JLabel lblMarcaMicro;
	private JTextField txtMarcaMicro;
	private JLabel lblModeloMicro;
	private JTextField txtModeloMicro;
	private JComponent lblVelocidadMicro;
	private JTextComponent txtVelocidadMicro;
	private JLabel lblTipoConexionMicro;
	private JTextField txtConexionMicro;
	private JPanel panelTarjeta;
	private JLabel lblNumSerieTarjeta;
	private JTextField txtNumSerieTarjeta;
	private JLabel lblMarcaTarjeta;
	private JTextField txtMarcaTarjeta;
	private JLabel lblModeloTarjeta;
	private JTextField txtModeloTarjeta;
	private JLabel lblTipoConexionTarjeta;
	private JTextField txtConexionTarjeta;
	private int index;



	public Registrar_Componente(Tienda t) {
		setTitle("Registrar Componente");
		setBounds(100, 100, 566, 336);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 128, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Registro de Componente:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblPrecioDeVenta = new JLabel("Precio de venta:");
			lblPrecioDeVenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblPrecioDeVenta.setBounds(305, 30, 86, 14);
			panel.add(lblPrecioDeVenta);
		
			textPrecioVenta = new JTextField();
			textPrecioVenta.setEditable(false);
			textPrecioVenta.setBounds(388, 27, 115, 20);
			panel.add(textPrecioVenta);
			textPrecioVenta.setColumns(10);
			
		
		    lblTipoDeComponente = new JLabel("Tipo de componente:");
			lblTipoDeComponente .setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblTipoDeComponente .setBounds(9, 30, 107, 14);
			panel.add(lblTipoDeComponente );
			
			cbxTipoComponente = new JComboBox();
			cbxTipoComponente.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					 index = cbxTipoComponente.getSelectedIndex();
					
					if(index == 1) {
						panelDiscoDuro.setVisible(true);
						panelGeneral.setVisible(false);
						panelMemoriaRAM.setVisible(false);
						panelMicro.setVisible(false);
						panelTarjeta.setVisible(false);
					}
					else if(index == 2) {
						panelDiscoDuro.setVisible(false);
						panelGeneral.setVisible(false);
						panelMemoriaRAM.setVisible(true);
						panelMicro.setVisible(false);
						panelTarjeta.setVisible(false);
					}
					else if(index == 3) {
						panelDiscoDuro.setVisible(false);
						panelGeneral.setVisible(false);
						panelMemoriaRAM.setVisible(false);
						panelMicro.setVisible(true);
						panelTarjeta.setVisible(false);
					}
					
					else if(index == 4) {
						panelDiscoDuro.setVisible(false);
						panelGeneral.setVisible(false);
						panelMemoriaRAM.setVisible(false);
						panelMicro.setVisible(false);
						panelTarjeta.setVisible(true);
						
					}
					
					else {
						panelDiscoDuro.setVisible(false);
						panelMemoriaRAM.setVisible(false);
						panelMicro.setVisible(false);
						panelTarjeta.setVisible(false);
						panelGeneral.setVisible(true);
					}
				}
			});
			
			
		    cbxTipoComponente.setFont(new Font("Tahoma", Font.PLAIN, 11));
			cbxTipoComponente.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar...", "Disco Duro", "Memoria RAM", "Microprocesador", "Tarjeta Madre"}));
			cbxTipoComponente.setBounds(116, 27, 149, 20);
			panel.add(cbxTipoComponente);
			
		    lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setFont(new Font("Dialog", Font.PLAIN, 11));
			lblCantidad.setBounds(10, 55, 55, 16);
			panel.add(lblCantidad);
		
			
		    spinnerCantidad = new JSpinner();
			spinnerCantidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
			spinnerCantidad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinnerCantidad.setBounds(116, 55, 71, 20);
			panel.add(spinnerCantidad);
			
			
			panelGeneral = new JPanel();
			panelGeneral.setBorder(new TitledBorder(null, "Datos del componente:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelGeneral.setBounds(9, 90, 519, 154);
			panel.add(panelGeneral);
			panelGeneral.setLayout(null);
			
		    lblNumSerie = new JLabel("Num. de serie:");
			lblNumSerie.setBounds(12, 33, 91, 14);
			panelGeneral.add(lblNumSerie);
			lblNumSerie.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
			txtNumSerie = new JTextField();
			txtNumSerie.setEditable(false);
			txtNumSerie.setBounds(87, 30, 172, 20);
			panelGeneral.add(txtNumSerie);
			txtNumSerie.setColumns(10);;
			

		    lblMarca= new JLabel("Marca:");
			lblMarca.setBounds(298, 33, 46, 14);
			panelGeneral.add(lblMarca);
			lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
			txtMarca = new JTextField();
			txtMarca.setEditable(false);
			txtMarca.setBounds(342, 30, 154, 20);
			panelGeneral.add(txtMarca);
			txtMarca.setColumns(10);
			
			lblModelo = new JLabel("Modelo:");
			lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblModelo.setBounds(12, 71, 93, 16);
			panelGeneral.add(lblModelo);
			
			txtModelo = new JTextField();
			txtModelo.setEditable(false);
			txtModelo.setBounds(86, 69, 142, 20);
			panelGeneral.add(txtModelo);
			txtModelo.setColumns(10);
			
			
			
			
			panelDiscoDuro = new JPanel();
			panelDiscoDuro.setLayout(null);
			panelDiscoDuro.setBorder(new TitledBorder(null, "Datos del Disco Duro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDiscoDuro.setBounds(9, 90, 519, 154);
			panelDiscoDuro.setVisible(false);
			panel.add(panelDiscoDuro);
			
		    lblNumSerieDisco = new JLabel("Num. de serie:");
			lblNumSerieDisco.setBounds(12, 33, 91, 14);
			panelDiscoDuro.add(lblNumSerieDisco);
		    lblNumSerieDisco.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
			txtNumSerieDisco = new JTextField();
			txtNumSerieDisco.setEditable(false);
			txtNumSerieDisco.setBounds(86, 30, 172, 20);
			panelDiscoDuro.add(txtNumSerieDisco);
			txtNumSerieDisco.setColumns(10);;
			
		    lblMarcaDisco= new JLabel("Marca:");
			lblMarcaDisco.setBounds(298, 33, 46, 14);
			panelDiscoDuro.add(lblMarcaDisco);
			lblMarcaDisco.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
			txtMarcaDisco = new JTextField();
			txtMarcaDisco.setEditable(false);
			txtMarcaDisco.setBounds(342, 30, 154, 20);
			panelDiscoDuro.add(txtMarcaDisco);
			txtMarcaDisco.setColumns(10);
			
		    lblModeloDisco = new JLabel("Modelo:");
			lblModeloDisco.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblModeloDisco.setBounds(12, 71, 93, 16);
			panelDiscoDuro.add(lblModeloDisco);
			
			txtModeloDisco = new JTextField();
			txtModeloDisco.setEditable(false);
			txtModeloDisco.setBounds(86, 69, 142, 20);
			panelDiscoDuro.add(txtModeloDisco);
			txtModeloDisco.setColumns(10);
			
		    lblCapacidad = new JLabel("Capacidad:");
			lblCapacidad .setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblCapacidad.setBounds(277, 72, 67, 14);
			panelDiscoDuro.add(lblCapacidad);
			
			txtCapacidad = new JTextField();
			txtCapacidad.setEditable(false);
			txtCapacidad.setBounds(342, 69, 98, 20);
			panelDiscoDuro.add(txtCapacidad);
			txtCapacidad.setColumns(10);
			
		    lblTipoConexion= new JLabel("Conexi\u00F3n:");
			lblCapacidad .setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblTipoConexion.setBounds(10, 108, 54, 14);
			panelDiscoDuro.add(lblTipoConexion);
			
			txtConexion = new JTextField();
			txtConexion.setEditable(false);
			txtConexion.setBounds(87, 105, 86, 20);
			panelDiscoDuro.add(txtConexion);
			txtConexion.setColumns(10);
			
		
			
			
			panelMemoriaRAM = new JPanel();
			panelMemoriaRAM.setLayout(null);
			panelMemoriaRAM.setBorder(new TitledBorder(null, "Datos de la Memoria RAM", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelMemoriaRAM.setBounds(9, 90, 519, 154);
			panelMemoriaRAM.setVisible(false);
			panel.add(panelMemoriaRAM);
			
			lblNumSerieRAM = new JLabel("Num. de serie:");
			lblNumSerieRAM.setBounds(12, 33, 91, 14);
			panelMemoriaRAM.add(lblNumSerieRAM);
			lblNumSerieRAM.setFont(new Font("Tahoma", Font.PLAIN, 11));
				
			txtNumSerieRAM.setEditable(false);
			txtNumSerieRAM.setBounds(86, 30, 172, 20);
			panelMemoriaRAM.add(txtNumSerieRAM);
			txtNumSerieRAM.setColumns(10);;
		
			lblMarcaRAM= new JLabel("Marca:");
			lblMarcaRAM.setBounds(298, 33, 46, 14);
			panelMemoriaRAM.add(lblMarcaRAM);
			lblMarcaRAM.setFont(new Font("Tahoma", Font.PLAIN, 11));
			
			txtMarcaRAM = new JTextField();
			txtMarcaRAM.setEditable(false);
			txtMarcaRAM.setBounds(342, 30, 154, 20);
			panelMemoriaRAM.add(txtMarcaRAM);
			((JTextField) txtMarcaRAM).setColumns(10);
			
			
			lblModeloRAM = new JLabel("Modelo:");
			lblModeloRAM.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblModeloRAM.setBounds(12, 71, 93, 16);
			panelMemoriaRAM.add(lblModeloRAM);
	
			txtModeloRAM = new JTextField();
			txtModeloRAM.setEditable(false);
			txtModeloRAM.setBounds(86, 69, 142, 20);
			panelMemoriaRAM.add(txtModeloRAM);
			txtModeloRAM.setColumns(10);
			
		    lblCapacidadRAM = new JLabel("Capacidad:");
		    lblCapacidadRAM.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblCapacidadRAM.setBounds(277, 72, 67, 14);
			panelMemoriaRAM.add(lblCapacidadRAM);
				
			txtCapacidadRAM = new JTextField();
			txtCapacidadRAM.setEditable(false);
			txtCapacidadRAM.setBounds(342, 69, 98, 20);
			panelMemoriaRAM.add(txtCapacidadRAM);
			txtCapacidadRAM.setColumns(10);
		
			
		    lblTipoRAM= new JLabel("Tipo de memoria:");
			lblTipoRAM.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblTipoRAM.setBounds(10, 108, 54, 14);
			panelMemoriaRAM.add(lblTipoRAM);
			
			txtTipoRAM = new JTextField();
			txtTipoRAM.setEditable(false);
			txtTipoRAM.setBounds(87, 105, 86, 20);
			panelMemoriaRAM.add(txtTipoRAM);
			txtTipoRAM.setColumns(10);
		
		
			panelMicro = new JPanel();
			panelMicro.setLayout(null);
			panelMicro.setBorder(new TitledBorder(null, "Datos del Microprocesador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelMicro.setBounds(9, 90, 519, 154);
			panelMicro.setVisible(false);
			panel.add(panelMicro);
			
			lblNumSerieMicro = new JLabel("Num. de serie:");
			lblNumSerieMicro.setBounds(12, 33, 91, 14);
			panelMicro.add(lblNumSerieMicro);
			lblNumSerieMicro.setFont(new Font("Tahoma", Font.PLAIN, 11));
				
		   
			txtNumSerieMicro = new JTextField();
			txtNumSerieMicro.setEditable(false);
			txtNumSerieMicro.setBounds(86, 30, 172, 20);
			panelMicro.add(txtNumSerieMicro);
			txtNumSerieMicro.setColumns(10);;
				
			lblMarcaMicro= new JLabel("Marca:");
			lblMarcaMicro.setBounds(298, 33, 46, 14);
			panelMicro.add(lblMarcaMicro);
			lblMarcaMicro.setFont(new Font("Tahoma", Font.PLAIN, 11));
				
			txtMarcaMicro = new JTextField();
			txtMarcaMicro.setEditable(false);
			txtMarcaMicro.setBounds(342, 30, 154, 20);
			panelMicro.add(txtMarcaMicro);
			txtMarcaMicro.setColumns(10);;
				
			lblModeloMicro = new JLabel("Modelo:");
			lblModeloMicro.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblModeloMicro.setBounds(12, 71, 93, 16);
		    panelMicro.add(lblModeloMicro);
				
			txtModeloMicro = new JTextField();
			txtModeloMicro.setEditable(false);
			txtModeloMicro.setBounds(86, 69, 142, 20);
			panelMicro.add(txtModeloMicro);
			txtModeloMicro.setColumns(10);
				
			lblVelocidadMicro = new JLabel("Velocidad:");
			lblVelocidadMicro.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblVelocidadMicro.setBounds(277, 72, 67, 14);
		    panelMicro.add(lblVelocidadMicro);
				
		    txtVelocidadMicro = new JTextField();
		    txtVelocidadMicro.setEditable(false);
	        txtVelocidadMicro.setBounds(342, 69, 98, 20);
		    panelMicro.add(txtVelocidadMicro);
		    ((JTextField) txtVelocidadMicro).setColumns(10);
				
		    lblTipoConexionMicro = new JLabel("Conexi\u00F3n:");
		    lblTipoConexionMicro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		    lblTipoConexionMicro.setBounds(10, 108, 54, 14);
		    panelMicro.add(lblTipoConexionMicro);
					
					txtConexionMicro = new JTextField();
					txtConexionMicro.setEditable(false);
					txtConexionMicro.setBounds(87, 105, 86, 20);
					panelMicro.add(txtConexionMicro);
					txtConexionMicro.setColumns(10);
				
			
			
					panelTarjeta = new JPanel();
					panelTarjeta.setLayout(null);
					panelTarjeta.setBorder(new TitledBorder(null, "Datos de la Tarjeta Madre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panelTarjeta.setBounds(9, 90, 519, 154);
					panelTarjeta.setVisible(false);
					panel.add(panelTarjeta);
					
				    lblNumSerieTarjeta = new JLabel("Num. de serie:");
					lblNumSerieTarjeta.setBounds(12, 33, 91, 14);
					panelTarjeta.add(lblNumSerieTarjeta);
				    lblNumSerieTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 11));
					
					txtNumSerieTarjeta= new JTextField();
					txtNumSerieTarjeta.setEditable(false);
					txtNumSerieTarjeta.setBounds(86, 30, 172, 20);
					panelTarjeta.add(txtNumSerieTarjeta);
					txtNumSerieDisco.setColumns(10);;
					
				    lblMarcaTarjeta= new JLabel("Marca:");
					lblMarcaTarjeta.setBounds(298, 33, 46, 14);
					panelTarjeta.add(lblMarcaTarjeta);
					lblMarcaTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 11));
					
					txtMarcaTarjeta = new JTextField();
					txtMarcaTarjeta.setEditable(false);
					txtMarcaTarjeta.setBounds(342, 30, 154, 20);
					panelTarjeta.add(txtMarcaTarjeta);
					txtMarcaTarjeta.setColumns(10);
					
				    lblModeloTarjeta = new JLabel("Modelo:");
					lblModeloTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 11));
					lblModeloTarjeta.setBounds(12, 71, 93, 16);
					panelTarjeta.add(lblModeloTarjeta);
					
					txtModeloTarjeta = new JTextField();
					txtModeloTarjeta.setEditable(false);
					txtModeloTarjeta.setBounds(86, 69, 142, 20);
					panelTarjeta.add(txtModeloTarjeta);
					txtModeloTarjeta.setColumns(10);
					
				    lblTipoRAM = new JLabel("Tipo de RAM:");
				    lblTipoRAM.setFont(new Font("Tahoma", Font.PLAIN, 11));
				    lblTipoRAM.setBounds(277, 72, 67, 14);
					panelTarjeta.add(lblTipoRAM);
					
					txtTipoRAM = new JTextField();
					txtTipoRAM.setEditable(false);
					txtTipoRAM.setBounds(342, 69, 98, 20);
					panelTarjeta.add(txtTipoRAM);
					txtTipoRAM.setColumns(10);
					
				    lblTipoConexionTarjeta= new JLabel("Conexi\u00F3n:");
				    lblTipoConexionTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 11));
				    lblTipoConexionTarjeta.setBounds(10, 108, 54, 14);
					panelTarjeta.add(lblTipoConexionTarjeta);
					
					txtConexionTarjeta = new JTextField();
					txtConexionTarjeta.setEditable(false);
					txtConexionTarjeta.setBounds(87, 105, 86, 20);
					panelTarjeta.add(txtConexionTarjeta);
					txtConexionTarjeta.setColumns(10);
					
		}
					
	
					
					
					{
						JPanel buttonPane = new JPanel();
						buttonPane.setBounds(0, 255, 539, 32);
						buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
						getContentPane().add(buttonPane, BorderLayout.SOUTH);
						buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
						
				{
							JButton btnRegistrar = new JButton("Registrar");
							btnRegistrar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
						
									Componente comp;
									int cantidad, index2, cantMemoria=0;
									float capacidad=0,velocidadProccess=0;
									String tipo,tipoRAM,marca,modelo,NumSerie,str1,str2,str3,str4,str5;
							
									index = cbxTipoComponente.getSelectedIndex();
									cantidad = Integer.parseInt(spinnerCantidad.getValue().toString());
									
									if(index == 1) {
										str1 = txtNumSerieDisco.getText();
										str2 = txtMarcaDisco.getText();
										str3 = txtModeloDisco.getText();
										str4 = txtConexion.getText();
										index2 = cbxTipoComponente.getSelectedIndex();
										
										if(str1.isEmpty() || str2.isEmpty() || str3.isEmpty() || str4.isEmpty())  {
											JOptionPane.showMessageDialog(null,"Has dejado campos vacíos. Por favor, intente de nuevo.","Aviso",JOptionPane.WARNING_MESSAGE);
										}
										else if(index2 == 0) {
											JOptionPane.showMessageDialog(null,"Por favor, introduzca un tipo de componente.","Aviso",JOptionPane.WARNING_MESSAGE);
										}
										else {
											NumSerie = str1;
											marca = str2;
											modelo = str3;
											tipo = str4;
											comp = new DiscoDuro(500.50f,NumSerie,cantidad,marca,modelo,capacidad,tipo);
											Tienda.getInstance().insertarComponente(comp);
											JOptionPane.showMessageDialog(null,"El componente ha sido registrado.","Aviso",JOptionPane.INFORMATION_MESSAGE);
										}
										
					              }
									
									else if(index == 2) {
										str1 = txtNumSerieRAM.getText();
										str2 = txtMarcaRAM.getText();
										str3 = txtModeloRAM.getText();
										str4 = txtTipoRAM.getText();
										index2 = cbxTipoComponente.getSelectedIndex();
										
										
										if(str1.isEmpty() || str2.isEmpty() || str3.isEmpty() || str4.isEmpty()) {
											JOptionPane.showMessageDialog(null,"Has dejado campos vacíos. Por favor, intente de nuevo.","Aviso",JOptionPane.WARNING_MESSAGE);
										}
										else if(index2 == 0) {
											JOptionPane.showMessageDialog(null,"Por favor, introduzca un tipo de componente.","Aviso",JOptionPane.WARNING_MESSAGE);
										}
										else {
											NumSerie = str1;
											marca = str2;
											modelo = str3;
											tipo = str4;
											comp = new MemoriaRam(500.50f,NumSerie,cantidad,marca,modelo,cantMemoria,tipo);
											Tienda.getInstance().insertarComponente(comp);;
											JOptionPane.showMessageDialog(null,"El componente ha sido registrado.","Aviso",JOptionPane.INFORMATION_MESSAGE);
										}
										
									}
									
									
									else if(index == 3) {
										str1 = txtNumSerieMicro.getText();
										str2 = txtMarcaMicro.getText();
										str3 = txtModeloMicro.getText();
										str4 = txtConexionMicro.getText();
										index2 = cbxTipoComponente.getSelectedIndex();
										
										if(str1.isEmpty() || str2.isEmpty() || str3.isEmpty() || str4.isEmpty()) {
											JOptionPane.showMessageDialog(null,"Has dejado campos vacíos. Por favor, intente de nuevo.","Aviso",JOptionPane.WARNING_MESSAGE);
										}
										else if(index2 == 0) {
											JOptionPane.showMessageDialog(null,"Por favor, introduzca un tipo de componente.","Aviso",JOptionPane.WARNING_MESSAGE);
										}
										
										else {
											NumSerie = str1;
											marca = str2;
											modelo = str3;
											tipo = str4;
											comp = new Microprocesador(500.50f,NumSerie,cantidad,marca,modelo,tipo,velocidadProccess);
											Tienda.getInstance().insertarComponente(comp);
											JOptionPane.showMessageDialog(null,"El componente ha sido registrado.","Aviso",JOptionPane.INFORMATION_MESSAGE);
										}
									}
									
									else if(index == 4) {
										str1 = txtNumSerieTarjeta.getText();
										str2 = txtMarcaTarjeta.getText();
										str3 = txtModeloTarjeta.getText();
										str4 = txtConexionTarjeta.getText();
										str5 = txtTipoRAM.getText();
										index2 = cbxTipoComponente.getSelectedIndex();
										
										
										if(str1.isEmpty() || str2.isEmpty() || str3.isEmpty() || str4.isEmpty() || str5.isEmpty()) {
											JOptionPane.showMessageDialog(null,"Has dejado campos vacíos. Por favor, intente de nuevo.","Aviso",JOptionPane.WARNING_MESSAGE);
										}
										else if(index2 == 0) {
											JOptionPane.showMessageDialog(null,"Por favor, introduzca un tipo de componente.","Aviso",JOptionPane.WARNING_MESSAGE);
										}
										
										else {
											NumSerie = str1;
											marca = str2;
											modelo = str3;
											tipo = str4;
											tipoRAM = str5;
											comp = new TarjetaMadre (500.50f,NumSerie,cantidad,marca,modelo,tipo,tipoRAM);
											Tienda.getInstance().insertarComponente(comp);
											JOptionPane.showMessageDialog(null,"El componente ha sido registrado.","Aviso",JOptionPane.INFORMATION_MESSAGE);
										}
									}
			
			
			
			
		}
		
							});
							
							btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
							btnRegistrar.setActionCommand("OK");
							buttonPane.add(btnRegistrar);
							getRootPane().setDefaultButton(btnRegistrar);
						}
						{
							JButton cancelButton = new JButton("Cancelar");
							cancelButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									dispose();
								}
							});
							cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
							cancelButton.setActionCommand("Cancel");
							buttonPane.add(cancelButton);
						}
					}
				}
		
		
			
				
					
				public static String TipoComponente(int ind) {
					String tipo = null;
					
					if(ind == 1) {
						tipo = "Cheddar";
					}
					else if(ind == 2) {
						tipo = "Gouda";
					}
					else if(ind == 3) {
						tipo = "Mozzarella";
					}
					else if(ind == 4) {
						tipo = "Parmesano";
					}
					else if(ind == 5) {
						tipo = "Provolone";
					}
					
					return tipo;
				}
	
	
	}


