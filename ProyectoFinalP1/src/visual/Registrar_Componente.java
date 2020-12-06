package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import logico.Componente;
import logico.DiscoDuro;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.Tienda;

import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

public class Registrar_Componente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtNumSerie;
	private JRadioButton rdbtnTarjetaMadre;
	private JRadioButton rdbtnDiscoDuro;
	private JRadioButton rdbtnMemoriaRam;
	private JPanel panelMicro;
	private JPanel panel_fondo;
	private JPanel panelTarjeta;
	private JPanel panelRam;
	private JPanel panelDisco;
	private JTextField textFieldVelocidadMicro;
	private JLabel lblTipoConector;
	private JLabel lblTipoRam;
	private JComboBox comboBoxTipoConector;
	private JComboBox comboBoxTipoRam;
	private JLabel lblTipoConexDisco;
	private JLabel lblCapacidad;
	private JLabel lblCantidad;
	private JComboBox comboBox;
	private JLabel lblTipoMemoria;
	private JLabel lblNewLabel_5;
	private JLabel lblVelocidad;
	private JComboBox comboBoxTConexD;
	private JLabel lblTconex;
	private JTextPane txtPrecio;
	private JRadioButton rdbtnMicroprocesador;
	private JSpinner spnCantDisponible;
	private JComboBox comboBoxTipoConexionDisco;
	private JTextField txtGb;
	private JComboBox comboBoxGRAM;
	private JLabel lblGb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registrar_Componente dialog = new Registrar_Componente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Registrar_Componente() {
		setTitle("Registrar Componente");
		setBounds(100, 100, 634, 497);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel_fondo = new JPanel();
			panel_fondo.setBackground(new Color(176, 224, 230));
			contentPanel.add(panel_fondo, BorderLayout.CENTER);
			panel_fondo.setLayout(null);
			{
				JPanel panel_DatosGen = new JPanel();
				panel_DatosGen.setBackground(new Color(176, 224, 230));
				panel_DatosGen.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
						"Datos Generales", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
				panel_DatosGen.setBounds(8, 13, 285, 178);
				panel_fondo.add(panel_DatosGen);
				panel_DatosGen.setLayout(null);
				{
					JLabel label = new JLabel("New label");
					label.setBounds(108, 111, -366, -60);
					panel_DatosGen.add(label);
				}
				{
					JLabel lblNewLabel = new JLabel("N\u00B0 Serie:");
					lblNewLabel.setBounds(12, 37, 70, 16);
					panel_DatosGen.add(lblNewLabel);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Marca:");
					lblNewLabel_1.setBounds(12, 82, 70, 16);
					panel_DatosGen.add(lblNewLabel_1);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Modelo:");
					lblNewLabel_2.setBounds(12, 129, 70, 16);
					panel_DatosGen.add(lblNewLabel_2);
				}
				{
					txtModelo = new JTextField();
					txtModelo.setBounds(94, 126, 148, 22);
					panel_DatosGen.add(txtModelo);
					txtModelo.setColumns(10);
				}
				{
					txtMarca = new JTextField();
					txtMarca.setBounds(94, 79, 148, 22);
					panel_DatosGen.add(txtMarca);
					txtMarca.setColumns(10);
				}
				{
					txtNumSerie = new JTextField();
					txtNumSerie.setBounds(94, 34, 148, 22);
					panel_DatosGen.add(txtNumSerie);
					txtNumSerie.setColumns(10);
				}
			}
			{
				JPanel panel = new JPanel();
				panel.setBackground(new Color(176, 224, 230));
				panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
						"Precio y Cantidad", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel.setBounds(331, 13, 270, 178);
				panel_fondo.add(panel);
				panel.setLayout(null);
				{
					JLabel lblNewLabel_3 = new JLabel("Cantidad Disponible:");
					lblNewLabel_3.setBounds(12, 54, 147, 16);
					panel.add(lblNewLabel_3);
				}
				{
					JLabel lblNewLabel_4 = new JLabel("Precio unitario:");
					lblNewLabel_4.setBounds(12, 122, 118, 22);
					panel.add(lblNewLabel_4);
				}

				spnCantDisponible = new JSpinner();
				spnCantDisponible.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
				spnCantDisponible.setBounds(139, 51, 97, 22);
				panel.add(spnCantDisponible);

				txtPrecio = new JTextPane();
				txtPrecio.setBounds(142, 118, 94, 26);
				panel.add(txtPrecio);
			}

			JSeparator separator = new JSeparator();
			separator.setBounds(0, 204, 578, 9);
			panel_fondo.add(separator);

			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(0, 292, 578, 9);
			panel_fondo.add(separator_1);

			JPanel panel_Componentes = new JPanel();
			panel_Componentes.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
					"Componentes", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_Componentes.setBackground(new Color(176, 224, 230));
			panel_Componentes.setBounds(0, 204, 601, 91);
			panel_fondo.add(panel_Componentes);
			panel_Componentes.setLayout(null);

			rdbtnMicroprocesador = new JRadioButton("Microprocesador");
			rdbtnMicroprocesador.setSelected(true);
			rdbtnMicroprocesador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnMicroprocesador.setSelected(true);
					rdbtnTarjetaMadre.setSelected(false);
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRam.setSelected(false);
					panelMicro.setVisible(true);
					panelTarjeta.setVisible(false);
					panelDisco.setVisible(false);
					panelRam.setVisible(false);

				}
			});
			rdbtnMicroprocesador.setBackground(new Color(176, 224, 230));
			rdbtnMicroprocesador.setBounds(14, 28, 158, 25);
			panel_Componentes.add(rdbtnMicroprocesador);

			rdbtnTarjetaMadre = new JRadioButton("Tarjeta Madre");
			rdbtnTarjetaMadre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnMicroprocesador.setSelected(false);
					rdbtnTarjetaMadre.setSelected(true);
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRam.setSelected(false);
					panelMicro.setVisible(false);
					panelTarjeta.setVisible(true);
					panelDisco.setVisible(false);
					panelRam.setVisible(false);

				}
			});
			rdbtnTarjetaMadre.setBackground(new Color(176, 224, 230));
			rdbtnTarjetaMadre.setBounds(168, 28, 142, 25);
			panel_Componentes.add(rdbtnTarjetaMadre);

			rdbtnDiscoDuro = new JRadioButton("Disco Duro");
			rdbtnDiscoDuro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnMicroprocesador.setSelected(false);
					rdbtnTarjetaMadre.setSelected(false);
					rdbtnDiscoDuro.setSelected(true);
					rdbtnMemoriaRam.setSelected(false);
					panelMicro.setVisible(false);
					panelTarjeta.setVisible(false);
					panelDisco.setVisible(true);
					panelRam.setVisible(false);

				}
			});
			rdbtnDiscoDuro.setBackground(new Color(176, 224, 230));
			rdbtnDiscoDuro.setBounds(317, 28, 127, 25);
			panel_Componentes.add(rdbtnDiscoDuro);

			rdbtnMemoriaRam = new JRadioButton("Memoria Ram");
			rdbtnMemoriaRam.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnMicroprocesador.setSelected(false);
					rdbtnTarjetaMadre.setSelected(false);
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRam.setSelected(true);
					panelMicro.setVisible(false);
					panelTarjeta.setVisible(false);
					panelDisco.setVisible(false);
					panelRam.setVisible(true);

				}
			});
			rdbtnMemoriaRam.setBackground(new Color(176, 224, 230));
			rdbtnMemoriaRam.setBounds(451, 28, 142, 25);
			panel_Componentes.add(rdbtnMemoriaRam);

			panelMicro = new JPanel();
			panelMicro.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Microprocesador",
					TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelMicro.setBackground(new Color(176, 224, 230));
			panelMicro.setBounds(0, 292, 601, 104);
			panel_fondo.add(panelMicro);
			panelMicro.setLayout(null);

			lblTconex = new JLabel("Tipo de conexion:");
			lblTconex.setBounds(15, 36, 176, 40);
			panelMicro.add(lblTconex);

			comboBoxTConexD = new JComboBox();
			comboBoxTConexD.setModel(new DefaultComboBoxModel(new String[] { "<Selecciona>", "PGA", "BGA", "LGA" }));
			comboBoxTConexD.setBounds(143, 43, 134, 26);
			panelMicro.add(comboBoxTConexD);

			lblVelocidad = new JLabel("Velocidad:");
			lblVelocidad.setBounds(346, 36, 84, 40);
			panelMicro.add(lblVelocidad);

			textFieldVelocidadMicro = new JTextField();
			textFieldVelocidadMicro.setBounds(426, 43, 65, 26);
			panelMicro.add(textFieldVelocidadMicro);
			textFieldVelocidadMicro.setColumns(10);

			lblNewLabel_5 = new JLabel("GHZ");
			lblNewLabel_5.setBounds(497, 43, 69, 26);
			panelMicro.add(lblNewLabel_5);

			panelTarjeta = new JPanel();
			panelTarjeta.setBackground(new Color(176, 224, 230));
			panelTarjeta.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Tarjeta Madre",
					TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelTarjeta.setBounds(0, 292, 601, 104);
			panel_fondo.add(panelTarjeta);
			panelTarjeta.setLayout(null);

			lblTipoConector = new JLabel("Tipo Conector:");
			lblTipoConector.setBounds(15, 36, 139, 40);
			panelTarjeta.add(lblTipoConector);

			comboBoxTipoConector = new JComboBox();
			comboBoxTipoConector
					.setModel(new DefaultComboBoxModel(new String[] { "<Seleccionar>", "BGA", "PGA", "LGA" }));
			comboBoxTipoConector.setBounds(143, 43, 134, 26);
			panelTarjeta.add(comboBoxTipoConector);

			lblTipoRam = new JLabel("Tipo Ram:");
			lblTipoRam.setBounds(346, 36, 84, 40);
			panelTarjeta.add(lblTipoRam);

			comboBoxTipoRam = new JComboBox();
			comboBoxTipoRam.setModel(
					new DefaultComboBoxModel(new String[] { "<Seleccionar>", "DDR", "DDR2", "DDR3", "DDR4" }));
			comboBoxTipoRam.setBounds(426, 43, 134, 26);
			panelTarjeta.add(comboBoxTipoRam);

			panelDisco = new JPanel();
			panelDisco.setBackground(new Color(176, 224, 230));
			panelDisco.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Disco Duro", TitledBorder.CENTER,
					TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelDisco.setBounds(0, 292, 601, 104);
			panel_fondo.add(panelDisco);
			panelDisco.setLayout(null);

			lblTipoConexDisco = new JLabel("Tipo Conexion:");
			lblTipoConexDisco.setBounds(15, 36, 139, 40);
			panelDisco.add(lblTipoConexDisco);

			lblCapacidad = new JLabel("Capacidad:");
			lblCapacidad.setBounds(346, 36, 84, 40);
			panelDisco.add(lblCapacidad);

			comboBoxTipoConexionDisco = new JComboBox();
			comboBoxTipoConexionDisco.setModel(
					new DefaultComboBoxModel(new String[] { "<Seleccionar>", "IDE", "SATA", "SATAII", "SATAIII" }));
			comboBoxTipoConexionDisco.setBounds(143, 43, 134, 26);
			panelDisco.add(comboBoxTipoConexionDisco);

			txtGb = new JTextField();
			txtGb.setBounds(426, 43, 65, 26);
			panelDisco.add(txtGb);
			txtGb.setColumns(10);

			JLabel lblramc = new JLabel("GB");
			lblramc.setBounds(497, 46, 69, 20);
			panelDisco.add(lblramc);

			panelRam = new JPanel();
			panelRam.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Memoria Ram",
					TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelRam.setBackground(new Color(176, 224, 230));
			panelRam.setBounds(0, 292, 601, 104);
			panel_fondo.add(panelRam);
			panelRam.setLayout(null);

			lblTipoMemoria = new JLabel("Tipo memoria:");
			lblTipoMemoria.setBounds(15, 36, 139, 40);
			panelRam.add(lblTipoMemoria);

			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "<Seleccionar>", "DDR2", "DDR3", "DDR4" }));
			comboBox.setBounds(100, 43, 134, 26);
			panelRam.add(comboBox);

			lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setBounds(346, 36, 84, 40);
			panelRam.add(lblCantidad);
			
			comboBoxGRAM = new JComboBox();
			comboBoxGRAM.setModel(new DefaultComboBoxModel(new String[] {"<Opc>", "1", "2", "4", "8", "16 "}));
			comboBoxGRAM.setBounds(426, 43, 64, 26);
			panelRam.add(comboBoxGRAM);
			
			lblGb = new JLabel("Gb");
			lblGb.setBounds(500, 43, 69, 26);
			panelRam.add(lblGb);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(192, 192, 192));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String marca = txtMarca.getText();
						String modelo = txtModelo.getText();
						String numS = txtNumSerie.getText();
						String precio = txtPrecio.getText();
						String cantidad = spnCantDisponible.getValue() + "";
						if (marca.isEmpty() || modelo.isEmpty() || numS.isEmpty() || precio.isEmpty()
								|| cantidad.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Llene los campos correspondientes!!.", "Aviso",
									JOptionPane.WARNING_MESSAGE);
						} else if (rdbtnDiscoDuro.isSelected()) {
							String combox1 = comboBoxTipoConexionDisco.getSelectedItem().toString();
							String combox2 = txtGb.getText();
							if (combox1.isEmpty() || combox2.isEmpty()) {
								JOptionPane.showMessageDialog(null, "Seleccione una de las opciones.", "Aviso",
										JOptionPane.WARNING_MESSAGE);
							} else {
								Componente comp = new DiscoDuro(Float.parseFloat(precio), numS,
										Integer.valueOf(cantidad), marca, modelo, combox2, combox1);
								JOptionPane.showMessageDialog(null, "Registro exitoso!.", "Aviso",
										JOptionPane.WARNING_MESSAGE);
								Tienda.getInstance().insertarComponente(comp);
								System.out.println(comp.getClass());
								System.out.println(comp.getPrecioV() * comp.getCantidad());

							}

						} else if (rdbtnMicroprocesador.isSelected()) {
							String combox1 = comboBoxTConexD.getSelectedItem().toString();
							String text1 = textFieldVelocidadMicro.getText();

							if (text1.isEmpty() || combox1.isEmpty()) {
								JOptionPane.showMessageDialog(null, "Llene los campos correspondites !!.", "Aviso",
										JOptionPane.WARNING_MESSAGE);
							} else {
								Componente comp = new Microprocesador(Float.parseFloat(precio), numS,
										Integer.valueOf(cantidad), marca, modelo, combox1, text1);
								JOptionPane.showMessageDialog(null, "Registro exitoso!.", "Aviso",
										JOptionPane.WARNING_MESSAGE);
								Tienda.getInstance().insertarComponente(comp);
								System.out.println(comp.getClass());
								System.out.println(comp.getPrecioV() * comp.getCantidad());
							}
						} else if (rdbtnMemoriaRam.isSelected()) {
							String combox1 = comboBox.getSelectedItem().toString();
							String text = comboBoxGRAM.getSelectedItem().toString();
							if (combox1.isEmpty()) {

								JOptionPane.showMessageDialog(null, "Seleccione una de las ocpiones.", "Aviso",
										JOptionPane.WARNING_MESSAGE);
							} 
							else if (text.isEmpty()) {
								JOptionPane.showMessageDialog(null, "Llenar los campos correspondientes.", "Aviso",
										JOptionPane.WARNING_MESSAGE);
							} 
							else {
								Componente comp = new MemoriaRam(Float.parseFloat(precio), numS,
										Integer.valueOf(cantidad), marca, modelo, Integer.valueOf(text), combox1);
								JOptionPane.showMessageDialog(null, "Registro exitoso!.", "Aviso",
										JOptionPane.WARNING_MESSAGE);
								Tienda.getInstance().insertarComponente(comp);
								System.out.println(comp.getClass());
								System.out.println(comp.getPrecioV() * comp.getCantidad());
							}
						} else if (rdbtnTarjetaMadre.isSelected()) {
							String combox1 = comboBoxTipoConector.getSelectedItem().toString();
							String combox2 = comboBoxTipoRam.getSelectedItem().toString();
							if (combox1.isEmpty() || combox2.isEmpty()) {

								JOptionPane.showMessageDialog(null, "Seleccione una de las opciones.", "Aviso",
										JOptionPane.WARNING_MESSAGE);
							} else {
								Componente comp = new TarjetaMadre(Float.parseFloat(precio), numS,
										Integer.valueOf(cantidad), marca, modelo, combox1, combox2);
								JOptionPane.showMessageDialog(null, "Registro exitoso!.", "Aviso",
										JOptionPane.WARNING_MESSAGE);
								Tienda.getInstance().insertarComponente(comp);
								System.out.println(comp.getClass());
								System.out.println(comp.getPrecioV() * comp.getCantidad());
							}

						}
						clean();
					}
				});
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void clean() {

		txtPrecio.setText("");
		txtNumSerie.setText("");
		txtModelo.setText("");
		txtMarca.setText("");
		txtGb.setText("");
		comboBoxGRAM.getSelectedItem().toString();
		spnCantDisponible.setValue(0);
		rdbtnTarjetaMadre.setSelected(false);
		;
		rdbtnDiscoDuro.setSelected(false);
		;
		rdbtnMemoriaRam.setSelected(false);
		;
		rdbtnMicroprocesador.setSelected(true);
		textFieldVelocidadMicro.setText("");
		panelMicro.setVisible(true);
	

	}
}
