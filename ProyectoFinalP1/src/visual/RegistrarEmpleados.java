package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logico.Administrador;
import logico.Empleado;
import logico.Tienda;
import logico.Vendedores;

import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RegistrarEmpleados extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombre;
	private JTextField textDireccion;
	private JRadioButton rdbtnM;
	private JRadioButton rdbtnF;
	private JPasswordField passwordFieldA;
	private JPasswordField passwordFieldV;
	private JRadioButton rdbtnA;
	private JRadioButton rdbtnV;
	private JPanel panelV;
	private JPanel panelADM;
	private JFormattedTextField textEdad;
	private JFormattedTextField textCedula;
	private JFormattedTextField textTelefono;
	private JFormattedTextField textUSA;
	private JFormattedTextField textSalarioA;
	private JFormattedTextField textUSV;
	private JFormattedTextField textSalarioV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarEmpleados dialog = new RegistrarEmpleados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarEmpleados() {
		setBounds(100, 100, 634, 405);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		//setUndecorated(true);
		contentPanel.setBackground(new Color(250, 240, 230));
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Informacion General", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(250, 240, 230));
		panel.setBounds(0, 0, 606, 151);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(12, 65, 74, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textNombre = new JTextField();
		textNombre.setBounds(79, 69, 215, 22);
		panel.add(textNombre);
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00E9dula:");
		lblNewLabel_1.setBounds(22, 22, 74, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MaskFormatter format = new MaskFormatter();
		try {
			format = new MaskFormatter("###-#######-#");

		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		   format.setPlaceholderCharacter('_');
		textCedula = new JFormattedTextField(format);
		textCedula.setBounds(79, 26, 215, 22);
		panel.add(textCedula);
		textCedula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("T\u00E9lefono:");
		lblNewLabel_2.setBounds(12, 108, 74, 30);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MaskFormatter formatt = new MaskFormatter();
		try {
			formatt = new MaskFormatter("(###)-###-####");

		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		   format.setPlaceholderCharacter('_');
		textTelefono = new JFormattedTextField(formatt);
		textTelefono.setBounds(79, 112, 215, 22);
		panel.add(textTelefono);
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("Direccion :");
		lblNewLabel_3.setBounds(306, 22, 74, 30);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textDireccion = new JTextField();
		textDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDireccion.setBounds(383, 27, 215, 22);
		panel.add(textDireccion);
		textDireccion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Edad :");
		lblNewLabel_4.setBounds(329, 65, 57, 30);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MaskFormatter formatter = new MaskFormatter();
		try {
			formatter = new MaskFormatter("##/##/####");

		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		   format.setPlaceholderCharacter('_');
		textEdad = new JFormattedTextField(formatter);
		textEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEdad.setBounds(383, 70, 215, 22);
		panel.add(textEdad);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo :");
		lblNewLabel_5.setBounds(329, 108, 74, 30);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		rdbtnM = new JRadioButton("Masculino");
		rdbtnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnM.setSelected(true);
				rdbtnF.setSelected(false);
				
			}
		});
		rdbtnM.setBackground(new Color(250, 240, 230));
		rdbtnM.setBounds(383, 111, 97, 25);
		panel.add(rdbtnM);
		rdbtnM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnM.setSelected(false);
		
		rdbtnF = new JRadioButton("Femenino");
		rdbtnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnM.setSelected(false);
				rdbtnF.setSelected(true);
			}
		});
		rdbtnF.setBackground(new Color(250, 240, 230));
		rdbtnF.setBounds(501, 111, 97, 25);
		panel.add(rdbtnF);
		rdbtnF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Posicion", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(250, 240, 230));
		panel_1.setBounds(0, 151, 304, 126);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		rdbtnA = new JRadioButton("Administrador");
		rdbtnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnA.setSelected(true);
				rdbtnV.setSelected(false);
				panelV.setVisible(false);
				panelADM.setVisible(true);
				
			}
		});
		rdbtnA.setBackground(new Color(250, 240, 230));
		rdbtnA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnA.setBounds(8, 54, 118, 25);
		panel_1.add(rdbtnA);
		
		rdbtnV = new JRadioButton("Vendedor");
		rdbtnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnA.setSelected(false);
				rdbtnV.setSelected(true);
				panelADM.setVisible(false);
				panelV.setVisible(true);
			}
		});
		rdbtnV.setBackground(new Color(250, 240, 230));
		rdbtnV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnV.setBounds(145, 54, 127, 25);
		panel_1.add(rdbtnV);
		
		panelADM = new JPanel();
		panelADM.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Administrador", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelADM.setBackground(new Color(250, 240, 230));
		panelADM.setBounds(316, 151, 290, 126);
		contentPanel.add(panelADM);
		panelADM.setLayout(null);
		
		JLabel lblUSA = new JLabel("Usuario:");
		lblUSA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUSA.setBounds(12, 26, 64, 25);
		panelADM.add(lblUSA);
		
		JLabel lblClaveA = new JLabel("Clave:");
		lblClaveA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClaveA.setBounds(22, 59, 51, 25);
		panelADM.add(lblClaveA);
		
		textUSA = new JFormattedTextField();
		textUSA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUSA.setBounds(72, 26, 193, 22);
		panelADM.add(textUSA);
		
		passwordFieldA = new JPasswordField();
		passwordFieldA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordFieldA.setBounds(72, 59, 193, 22);
		panelADM.add(passwordFieldA);
		
		JLabel lblSalarioA = new JLabel("Salario:");
		lblSalarioA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalarioA.setBounds(16, 88, 74, 25);
		panelADM.add(lblSalarioA);
		
		textSalarioA = new JFormattedTextField();
		textSalarioA.setBounds(72, 88, 193, 22);
		panelADM.add(textSalarioA);
		
		panelV = new JPanel();
		panelV.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Vendedor", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelV.setBackground(new Color(250, 240, 230));
		panelV.setBounds(316, 151, 290, 126);
		contentPanel.add(panelV);
		panelV.setLayout(null);
		
		JLabel lblUsuarioV = new JLabel("Usuario:");
		lblUsuarioV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuarioV.setBounds(12, 26, 64, 25);
		panelV.add(lblUsuarioV);
		
		JLabel lblClaveV = new JLabel("Clave:");
		lblClaveV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClaveV.setBounds(22, 59, 51, 25);
		panelV.add(lblClaveV);
		
		JLabel lblSueldoV = new JLabel("Salario:");
		lblSueldoV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSueldoV.setBounds(16, 88, 74, 25);
		panelV.add(lblSueldoV);
		
		textUSV = new JFormattedTextField();
		textUSV.setBounds(72, 26, 193, 22);
		panelV.add(textUSV);
		
		textSalarioV = new JFormattedTextField();
		textSalarioV.setBounds(72, 88, 193, 22);
		panelV.add(textSalarioV);
		
		passwordFieldV = new JPasswordField();
		passwordFieldV.setBounds(72, 59, 193, 22);
		panelV.add(passwordFieldV);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String  nombre = textNombre.getText();
				 String cedula = textCedula.getText();
				 String telefono = textTelefono.getText();
				 String direccion = textDireccion.getText();
				 String edad = textEdad.getText();
				 
				 if(nombre.isEmpty() || cedula.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || edad.isEmpty()) {
					 JOptionPane.showMessageDialog(null,"Llene los campos correspondientes!!.","Aviso",JOptionPane.WARNING_MESSAGE);
				 }
				 else if(Tienda.getInstance().buscarEmpleado(cedula)) {
					 JOptionPane.showMessageDialog(null,"Este empleado ya existe, intente de nuevo.","Aviso",JOptionPane.WARNING_MESSAGE);
					 
					 textCedula.setText("");
				 }
				 else {
					 if(rdbtnA.isSelected() && rdbtnM.isSelected()) {
					 Empleado admi = new Administrador(nombre,cedula,telefono,direccion,edad,"Masculino",passwordFieldA.getText(),textUSA.getText(),Float.parseFloat(textSalarioA.getText()));
					 Tienda.getInstance().insertEmpleado(admi);
					 System.out.println(admi.getNombre());
					 JOptionPane.showMessageDialog(null,"Registro exitoso.","Aviso",JOptionPane.WARNING_MESSAGE);
					 vaciar();
				 }
					 else if(rdbtnA.isSelected() &&rdbtnF.isSelected()) {
						
							 Empleado admi = new Administrador(nombre,cedula,telefono,direccion,edad,"Femenino",passwordFieldA.getText(),textUSA.getText(),Float.parseFloat(textSalarioA.getText()));
							 Tienda.getInstance().insertEmpleado(admi);
							 JOptionPane.showMessageDialog(null,"Registro exitoso.","Aviso",JOptionPane.WARNING_MESSAGE);
							 System.out.println(admi.getNombre());
							 vaciar();
					 }
					 else if (rdbtnV.isSelected() && rdbtnM.isSelected()){
							 
								 Empleado seller = new Vendedores(nombre,cedula,telefono,direccion,edad,"Masculino",passwordFieldV.getText(),textUSV.getText(),Float.parseFloat(textSalarioV.getText()),0);
								 Tienda.getInstance().insertEmpleado(seller);
								 JOptionPane.showMessageDialog(null,"Registro exitoso.","Aviso",JOptionPane.WARNING_MESSAGE);
								 vaciar();
							 
						 }
					 else if (rdbtnV.isSelected() && rdbtnF.isSelected()){
						 
						 Empleado seller = new Vendedores(nombre,cedula,telefono,direccion,edad,"Femenino",passwordFieldV.getText(),textUSV.getText(),Float.parseFloat(textSalarioV.getText()),0);
						 Tienda.getInstance().insertEmpleado(seller);
						 System.out.println(seller.getNombre()+",");
						 JOptionPane.showMessageDialog(null,"Registro exitoso.","Aviso",JOptionPane.WARNING_MESSAGE);
						 vaciar();
					 
				 }
					 }
					
					
				 }
				 
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(326, 300, 97, 44);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(459, 300, 97, 44);
		contentPanel.add(btnNewButton_1);
	}
	public void vaciar() {
		 textNombre.setText(" ");
		 textCedula.setText("");
		  textTelefono.setText("");
		 textDireccion.setText("");
		  textEdad.setText("");
		  rdbtnA.setSelected(false);
		  rdbtnV.setSelected(false);
		  rdbtnM.setSelected(false);
		  rdbtnF.setSelected(false);
		  textUSA.setText("");
		  textUSV.setText("");
		  textSalarioV.setText("");
		  textSalarioA.setText("");
		  passwordFieldV.setText("");
		  passwordFieldA.setText("");
	}
	
}
