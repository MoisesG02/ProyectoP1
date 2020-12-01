package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Rectangle;

public class Registrar_Componente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtNumSerie;
	private JRadioButton rdbtnTarjetaMadre;
	private JRadioButton rdbtnDiscoDuro;
	private JRadioButton rdbtnMemoriaRam;
	private JTextField txtTipoConector;
	private JTextField txtVelocidadProcesador;
	private JLabel lblTipoConexion;
	private JTextField txtTipoConexion;
	private JLabel lblTipoRAM;
	private JTextField txtTipoRAM;

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
		setBounds(100, 100, 606, 475);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel_fondo = new JPanel();
			panel_fondo.setBackground(new Color(176, 224, 230));
			contentPanel.add(panel_fondo, BorderLayout.CENTER);
			panel_fondo.setLayout(null);
			{
				JPanel panel_DatosGen = new JPanel();
				panel_DatosGen.setBackground(new Color(176, 224, 230));
				panel_DatosGen.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Datos Generales", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_DatosGen.setBounds(12, 13, 270, 178);
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
				panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Precio y Cantidad", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel.setBounds(294, 13, 270, 178);
				panel_fondo.add(panel);
				panel.setLayout(null);
				{
					JLabel lblNewLabel_3 = new JLabel("Cantidad Disponible:");
					lblNewLabel_3.setBounds(12, 54, 124, 16);
					panel.add(lblNewLabel_3);
				}
				{
					JLabel lblNewLabel_4 = new JLabel("Precio");
					lblNewLabel_4.setBounds(12, 122, 124, 16);
					panel.add(lblNewLabel_4);
				}
				
				JSpinner spnCantDisponible = new JSpinner();
				spnCantDisponible.setBounds(161, 51, 97, 22);
				panel.add(spnCantDisponible);
				
				JSpinner spnPrecio = new JSpinner();
				spnPrecio.setBounds(161, 119, 97, 22);
				panel.add(spnPrecio);
			}
			
			JSeparator separator = new JSeparator();
			separator.setBounds(0, 204, 578, 9);
			panel_fondo.add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(0, 292, 578, 9);
			panel_fondo.add(separator_1);
			
			JPanel panel_Componentes = new JPanel();
			panel_Componentes.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Componentes", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_Componentes.setBackground(new Color(176, 224, 230));
			panel_Componentes.setBounds(0, 204, 578, 91);
			panel_fondo.add(panel_Componentes);
			panel_Componentes.setLayout(null);
			
			JRadioButton rdbtnMicroprocesador = new JRadioButton("Microprocesador");
			rdbtnMicroprocesador.setSelected(true);
			rdbtnMicroprocesador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				rdbtnMicroprocesador.setSelected(true);
				rdbtnTarjetaMadre.setSelected(false);
				rdbtnDiscoDuro.setSelected(false);
				rdbtnMemoriaRam.setSelected(false);
			
		
				}
			});
			rdbtnMicroprocesador.setBackground(new Color(176, 224, 230));
			rdbtnMicroprocesador.setBounds(14, 28, 127, 25);
			panel_Componentes.add(rdbtnMicroprocesador);
			
			rdbtnTarjetaMadre = new JRadioButton("Tarjeta Madre");
			rdbtnTarjetaMadre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnMicroprocesador.setSelected(false);
					rdbtnTarjetaMadre.setSelected(true);
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRam.setSelected(false);
					
					
				
				}
			});
			rdbtnTarjetaMadre.setBackground(new Color(176, 224, 230));
			rdbtnTarjetaMadre.setBounds(155, 28, 127, 25);
			panel_Componentes.add(rdbtnTarjetaMadre);
			
			rdbtnDiscoDuro = new JRadioButton("Disco Duro");
			rdbtnDiscoDuro.setBackground(new Color(176, 224, 230));
			rdbtnDiscoDuro.setBounds(296, 28, 127, 25);
			panel_Componentes.add(rdbtnDiscoDuro);
			
			rdbtnMemoriaRam = new JRadioButton("Memoria Ram");
			rdbtnMemoriaRam.setBackground(new Color(176, 224, 230));
			rdbtnMemoriaRam.setBounds(437, 28, 127, 25);
			panel_Componentes.add(rdbtnMemoriaRam);
			
			JPanel panelMicroprocesador = new JPanel();
			panelMicroprocesador.setBackground(new Color(176, 224, 230));
			panelMicroprocesador.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Microprocesador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelMicroprocesador.setBounds(0, 292, 578, 91);
			panel_fondo.add(panelMicroprocesador);
			panelMicroprocesador.setLayout(null);
			
			JLabel lblTipoConector = new JLabel("Tipo Conector");
			lblTipoConector.setBounds(12, 37, 110, 16);
			panelMicroprocesador.add(lblTipoConector);
			
			txtTipoConector = new JTextField();
			txtTipoConector.setBounds(127, 33, 129, 22);
			panelMicroprocesador.add(txtTipoConector);
			txtTipoConector.setColumns(10);
			
			JLabel lblVelocidadProcesador = new JLabel("Velocidad Procesador");
			lblVelocidadProcesador.setBounds(307, 37, 130, 16);
			panelMicroprocesador.add(lblVelocidadProcesador);
			
			txtVelocidadProcesador = new JTextField();
			txtVelocidadProcesador.setBounds(447, 34, 75, 22);
			panelMicroprocesador.add(txtVelocidadProcesador);
			txtVelocidadProcesador.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("GHz");
			lblNewLabel_7.setBounds(534, 36, 44, 16);
			panelMicroprocesador.add(lblNewLabel_7);
			
			JPanel panelTarjetaMadre = new JPanel();
			panelTarjetaMadre.setBackground(new Color(176, 224, 230));
			panelTarjetaMadre.setBounds(0, 0, 578, 91);
			panelMicroprocesador.add(panelTarjetaMadre);
			
			lblTipoConexion = new JLabel("New label");
			lblTipoConexion.setBounds(new Rectangle(12, 37, 110, 16));
			panelTarjetaMadre.add(lblTipoConexion);
			
			txtTipoConexion = new JTextField();
			panelTarjetaMadre.add(txtTipoConexion);
			txtTipoConexion.setColumns(10);
			
			lblTipoRAM = new JLabel("New label");
			panelTarjetaMadre.add(lblTipoRAM);
			
			txtTipoRAM = new JTextField();
			panelTarjetaMadre.add(txtTipoRAM);
			txtTipoRAM.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(192, 192, 192));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
