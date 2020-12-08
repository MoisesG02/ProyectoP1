package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.MemoriaRam;
import logico.Cliente;
import logico.Combo;
import logico.Componente;
import logico.DiscoDuro;
import logico.Factura;
import logico.MemoriaRam;
import logico.Microprocesador;
import logico.TarjetaMadre;
import logico.Tienda;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;

public class Facturacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableComponente;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtFechaCompra;
	private JTextField txtPrecioTotal;
	private JTextField txtTotalComp;
	public static DefaultTableModel model;
	public static DefaultTableModel model1;
	private static Object[] filas;
	private Object[] filasx;
	private JComboBox cbxFiltro;
	private String numSerie;
	private float precio = 0;
	private ArrayList<Componente> misComp = new ArrayList<>();
	private ArrayList<Componente> misCompCant = new ArrayList<>();
	private JTable tableFactura;
	private String codigox;
	private int cantx;
	private Date fecha;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton_2;
	private JFormattedTextField textIDC;
	private JFormattedTextField txtTelefono;
	private JScrollPane scrollPane;
	private String[] encabezadoCompo = { "No. Serie", "Marca", "Modelo","Cantidad", "Precio" };
	private String[] encabezadoCompra = { "No. Serie/Codigo", "Tipo", "Informacion" };
	private String[] encabezadoDD = { "No. Serie", "Marca", "Modelo", "Precio", "Almacenamiento", "Tipo Conexion" };
	private String[] encabezadoMicro = { "No. Serie", "Marca", "Modelo", "Precio ", "Velocidad", "Tipo Conexion" };
	private String[] encabezadoMother = { "No. Serie", "Marca", "Modelo", "Precio", "Tipo Conector", "Tipo RAM" };
	private String[] encabezadoRAM = { "No. Serie", "Marca", "Modelo", "Precio", "Cant Memoria", "Tipo Memoria" };
	private String[] encabezadoCombo = { "Codigo", "Disco Duro", "Microprocesador", "Motherboard", "RAM", "Descuento" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturacion dialog = new Facturacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturacion() {
		setTitle("Facturaci\u00F3n");
		setBounds(100, 100, 1134, 684);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel_Fondo = new JPanel();
			panel_Fondo.setBackground(new Color(224, 255, 255));
			contentPanel.add(panel_Fondo, BorderLayout.CENTER);
			panel_Fondo.setLayout(null);

			JPanel panel_Tablas = new JPanel();
			panel_Tablas.setBackground(new Color(224, 255, 255));
			panel_Tablas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					"Elementos a seleccionar", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panel_Tablas.setBounds(12, 13, 1082, 369);
			panel_Fondo.add(panel_Tablas);
			panel_Tablas.setLayout(null);
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(16, 54, 477, 302);
				panel_Tablas.add(scrollPane);

				tableComponente = new JTable();
				tableComponente.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = tableComponente.getSelectedRow();
						numSerie = String.valueOf(tableComponente.getValueAt(index, 0));
					}
				});
				model = new DefaultTableModel();
				String[] column = { "#Serie", "Marca", "Modelo", "Cantiad", "Precio" };
				filas = new Object[5];
				model.setColumnIdentifiers(column);
				tableComponente.setModel(model);
				scrollPane.setViewportView(tableComponente);
			}
			{
				{

				}
			}
			{
				btnNewButton = new JButton("");
				btnNewButton.addActionListener(new ActionListener() { // IZQUIERDA A DERECHA
					public void actionPerformed(ActionEvent e) {

						Componente aux = Tienda.getInstance().obtenerComponente(numSerie);
						showDate();
						String cant = JOptionPane.showInputDialog("Introduce un numero");
						if (Integer.valueOf(cant) > aux.getCantidad()) {
							JOptionPane.showMessageDialog(null, "Cantidad no disponible", "Aviso",
									JOptionPane.WARNING_MESSAGE);
						} else if (Integer.valueOf(cant) <= aux.getCantidad()) {
							Componente auxi = new Componente(aux.getPrecioV(), aux.getNumSerie(), Integer.valueOf(cant),
									aux.getMarca(), aux.getModelo());

							precio += aux.getPrecioV() * Integer.valueOf(cant);
							misCompCant.add(auxi);
							txtPrecioTotal.setText(String.format("%.2f", precio) + "$");
							cantx = aux.getCantidad() - auxi.getCantidad();

							aux.setCantidad(cantx);
							txtTotalComp.setText("" + misCompCant.size());

							if (aux.getCantidad() < 1) {
								Tienda.getInstance().getMisComps().remove(aux);
								JOptionPane.showMessageDialog(null,
										"Ultimo en el inventario " + aux.getMarca() + "" + "Disponibles", "Aviso",
										JOptionPane.WARNING_MESSAGE);

							}

						}

						llenarT();
						llenarT2();

					}
				});
				llenarT();

				btnNewButton.setIcon(new ImageIcon(Facturacion.class.getResource("/Iconos/Actions-go-next-icon.png")));
				btnNewButton.setBounds(517, 161, 68, 25);
				panel_Tablas.add(btnNewButton);
			}
			{
				btnNewButton_1 = new JButton("");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Componente aux = buscarQBC(codigox);

						precio -= aux.getPrecioV() * aux.getCantidad();
						Tienda.getInstance().getMisComps().add(aux);
						misCompCant.remove(aux);

						txtPrecioTotal.setText(String.format("%.2f", precio) + "$");

						llenarT();
						llenarT2();

					}
				});

				btnNewButton_1
						.setIcon(new ImageIcon(Facturacion.class.getResource("/Iconos/Actions-go-previous-icon.png")));
				btnNewButton_1.setBounds(517, 213, 68, 25);
				panel_Tablas.add(btnNewButton_1);
			}

			cbxFiltro = new JComboBox();
			cbxFiltro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Filtro(cbxFiltro.getSelectedIndex());
				}
			});
			cbxFiltro.setModel(new DefaultComboBoxModel(new String[] { "<Todos>", "Disco Duro", "Combos",
					"Tarjeta Madre", "Microprocesador", "Memoria Ram" }));
			cbxFiltro.setBounds(17, 28, 476, 22);
			panel_Tablas.add(cbxFiltro);

			scrollPane_1 = new JScrollPane();
			scrollPane_1.addMouseListener(new MouseAdapter() {

			});

			scrollPane_1.setBounds(597, 55, 477, 302);
			panel_Tablas.add(scrollPane_1);

			tableFactura = new JTable();
			tableFactura.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = tableFactura.getSelectedRow();

					codigox = String.valueOf(tableFactura.getValueAt(index, 0));

				}
			});
			model1 = new DefaultTableModel();
			String[] column1 = { "#Serie", "Marca", "Modelo", "Cantidad", "Precio" };
			filasx = new Object[5];
			model1.setColumnIdentifiers(column1);
			tableFactura.setModel(model1);
			scrollPane_1.setViewportView(tableFactura);

			JPanel panel = new JPanel();
			panel.setBackground(new Color(224, 255, 255));
			panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
					"Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(12, 411, 496, 146);
			panel_Fondo.add(panel);
			panel.setLayout(null);

			JLabel lblNewLabel = new JLabel("C\u00E9dula:");
			lblNewLabel.setBounds(12, 23, 56, 16);
			panel.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Tel\u00E9fono:");
			lblNewLabel_1.setBounds(12, 68, 62, 16);
			panel.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Nombre:");
			lblNewLabel_2.setBounds(225, 23, 56, 16);
			panel.add(lblNewLabel_2);

			txtNombre = new JTextField();
			txtNombre.setBounds(293, 20, 156, 22);
			panel.add(txtNombre);
			txtNombre.setColumns(10);

			JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n:");
			lblNewLabel_3.setBounds(225, 68, 68, 16);
			panel.add(lblNewLabel_3);

			txtDireccion = new JTextField();
			txtDireccion.setBounds(293, 65, 156, 22);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);

			btnNewButton_2 = new JButton("Buscar Cliente");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cliente client = null;
					boolean encontrado = Tienda.getInstance().BuscarCliente(textIDC.getText());
					System.out.println(encontrado);
					client = Tienda.getInstance().buscarCliente(textIDC.getText());

					if (encontrado == true) {
						JOptionPane.showMessageDialog(null, "Cliente encontrado!.", "Aviso",
								JOptionPane.WARNING_MESSAGE);
						txtNombre.setText(client.getNombre());
						textIDC.setText(client.getCedula());
						txtDireccion.setText(client.getDireccion());
						txtTelefono.setText(client.getTelefono());
					}

				}
			});
			btnNewButton_2.setBounds(90, 108, 133, 25);
			panel.add(btnNewButton_2);

			JButton btnNewButton_3 = new JButton("Crear Cliente");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (Tienda.getInstance().BuscarCliente(textIDC.getText())) {
						JOptionPane.showMessageDialog(null, "Ya existe un cliente con esa Cedula, ingrese otro.");

					} else if (txtNombre.getText().equals("") || textIDC.getText().equals("")
							|| txtTelefono.getText().equals("") || txtDireccion.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Llene todos los campos, por favor.");
					} else {
						Cliente client = new Cliente(textIDC.getText(), txtNombre.getText(), txtTelefono.getText(),
								txtDireccion.getText());
						Tienda.getInstance().insertarCliente(client);
						JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.");
						System.out.println(client.getNombre() + "" + client.getCedula());

					}
				}

			});
			btnNewButton_3.setBounds(253, 108, 133, 25);
			panel.add(btnNewButton_3);
			MaskFormatter format = new MaskFormatter();
			try {
				format = new MaskFormatter("###-########-#");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			format.setPlaceholderCharacter('_');
			textIDC = new JFormattedTextField(format);
			textIDC.setBounds(80, 20, 133, 22);
			panel.add(textIDC);
			MaskFormatter formatterr = new MaskFormatter();
			try {
				formatterr = new MaskFormatter("(###)-###-####");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formatterr.setPlaceholderCharacter('_');
			txtTelefono = new JFormattedTextField(formatterr);
			txtTelefono.setBounds(80, 65, 133, 22);
			panel.add(txtTelefono);

			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(224, 255, 255));
			panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Factura",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(610, 411, 468, 146);
			panel_Fondo.add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel_4 = new JLabel("C\u00F3digo Factura:");
			lblNewLabel_4.setBounds(12, 23, 100, 16);
			panel_1.add(lblNewLabel_4);

			JLabel lblNewLabel_5 = new JLabel("Fecha Compra:");
			lblNewLabel_5.setBounds(12, 96, 100, 16);
			panel_1.add(lblNewLabel_5);

			txtFechaCompra = new JTextField();
			txtFechaCompra.setEditable(false);
			txtFechaCompra.setBounds(124, 93, 81, 22);
			panel_1.add(txtFechaCompra);
			txtFechaCompra.setColumns(10);

			JLabel lblNewLabel_6 = new JLabel("Precio Total:");
			lblNewLabel_6.setBounds(244, 23, 86, 16);
			panel_1.add(lblNewLabel_6);

			txtPrecioTotal = new JTextField();
			txtPrecioTotal.setBounds(331, 20, 115, 22);
			panel_1.add(txtPrecioTotal);
			txtPrecioTotal.setColumns(10);

			JLabel lblNewLabel_7 = new JLabel("Total Componentes");
			lblNewLabel_7.setBounds(244, 96, 126, 16);
			panel_1.add(lblNewLabel_7);

			txtTotalComp = new JTextField();
			txtTotalComp.setBounds(365, 93, 81, 22);
			panel_1.add(txtTotalComp);
			txtTotalComp.setColumns(10);
			MaskFormatter formatter = new MaskFormatter();
			try {
				formatter = new MaskFormatter("FT-000" + Tienda.getCodFactura());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formatter.setPlaceholderCharacter('_');
			JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
			formattedTextField.setEditable(false);
			formattedTextField.setBounds(106, 20, 99, 22);
			panel_1.add(formattedTextField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(192, 192, 192));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Factura");
				okButton.addActionListener(new ActionListener() {
					@SuppressWarnings({ "unlikely-arg-type" })
					public void actionPerformed(ActionEvent e) {

						boolean clientx = Tienda.getInstance().BuscarCliente(textIDC.getText());
						Cliente client = Tienda.getInstance().buscarCliente(textIDC.getText());
						if (clientx == true && !misCompCant.isEmpty()) {

							Factura facts = new Factura(client, null, precio);

							Tienda.getInstance().getMisFacturas().add(facts);

							Tienda.getInstance().getMisComps().removeAll(misCompCant);

							System.out.println(facts.getPrecioTotal());
							misCompCant.removeAll(misCompCant);
							model1.setRowCount(0);

							precio = 0;
							txtPrecioTotal.setText(0 + "$");
							llenarT2();

							JOptionPane.showMessageDialog(null, "Se ha efectuado la compra", "Notificacion",
									JOptionPane.INFORMATION_MESSAGE);

						} else if (client == null) {
							JOptionPane.showMessageDialog(null, "No se ha encontrado un cliente", "Notificacion",
									JOptionPane.INFORMATION_MESSAGE);
						} else if (misComp.isEmpty()) {
							JOptionPane.showMessageDialog(null, "No hay objetos para facturar", "Notificacion",
									JOptionPane.INFORMATION_MESSAGE);
						}

					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void Filtro(int seleccionado) {
		model.setRowCount(0);
		String tipo = null;
		filas = new Object[model.getColumnCount()];
		if (seleccionado == 0) {
			model.setColumnIdentifiers(encabezadoCompo);
			llenarT();
		} else if (seleccionado == 1) {
			model.setColumnIdentifiers(encabezadoDD);
			CargarDiscoDuro();

		} else if (seleccionado == 2) {
			model.setColumnIdentifiers(encabezadoCombo);
			cargarCombos();

		} else if (seleccionado == 3) {
			model.setColumnIdentifiers(encabezadoMother);
			cargartarjeta();

		} else if (seleccionado == 4) {
			model.setColumnIdentifiers(encabezadoMicro);
			cargarMicro();

		} else if (cbxFiltro.getSelectedIndex() == 5) {
			model.setColumnIdentifiers(encabezadoRAM);
			for (Componente comp : Tienda.getInstance().getMisComps()) {
				if (comp instanceof MemoriaRam) {
					filas[0] = comp.getNumSerie();
					filas[1] = comp.getMarca();
					filas[2] = comp.getModelo();
					filas[3] = comp.getPrecioV();
					filas[4] = ((MemoriaRam) comp).getCantMemoria();
					filas[5] = ((MemoriaRam) comp).getTipoMemoria();

					model.addRow(filas);

				}
			}
		}
	}

	public void llenarT() {
		((DefaultTableModel) tableComponente.getModel()).setRowCount(0);
		int numCols = tableComponente.getModel().getColumnCount();
		Object[] filas = new Object[numCols];
		for (Componente auxQ : Tienda.getInstance().getMisComps()) {

			filas[0] = auxQ.getNumSerie();
			filas[1] = auxQ.getMarca();
			filas[2] = auxQ.getModelo();

			filas[3] = auxQ.getCantidad();

			filas[4] = auxQ.getPrecioV();
//tabla bien
			((DefaultTableModel) tableComponente.getModel()).addRow(filas);

		}
	}

	public void llenarT2() {
		((DefaultTableModel) tableFactura.getModel()).setRowCount(0);
		int numColus = tableFactura.getModel().getColumnCount();
		Object[] filasx = new Object[numColus];
		for (Componente auxQ : misCompCant) {

			filasx[0] = auxQ.getNumSerie();
			filasx[1] = auxQ.getMarca();
			filasx[2] = auxQ.getModelo();
			filasx[3] = auxQ.getCantidad();
			filasx[4] = auxQ.getPrecioV();
			// tabla bien
			((DefaultTableModel) tableFactura.getModel()).addRow(filasx);

		}
	}

	public Componente buscarQBC(String code) {
		Componente aux = null;
		boolean encontrado = false;
		int c = 0;

		while (c < misCompCant.size()) {
			if (misCompCant.get(c).getNumSerie().equalsIgnoreCase(code)) {
				encontrado = true;
				aux = misCompCant.get(c);

			}
			c++;
		}
		return aux;
	}

	public float calcularP() {

		return 0;
	}

	public void showDate() {
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		txtFechaCompra.setText(sf.format(d));
	}

	public ArrayList<Componente> getMisCompCant() {
		return misCompCant;
	}

	public void setMisCompCant(ArrayList<Componente> misCompCant) {
		this.misCompCant = misCompCant;
	}

	public int getCantx() {
		return cantx;
	}

	public void setCantx(int cantx) {
		this.cantx = cantx;
	}

	public static void cargarCombos() {
		model.setRowCount(0);
		filas = new Object[model.getColumnCount()];
		if (!Tienda.getInstance().getMisCombos().isEmpty()) {
			for (Combo combo : Tienda.getInstance().getMisCombos()) {
				filas[0] = combo.getNombre();
				for (Componente componente : combo.getComponentes()) {
					if (componente instanceof DiscoDuro) {
						filas[1] = componente.getMarca() + " : " + componente.getModelo();
					}
					if (componente instanceof Microprocesador) {
						filas[2] = componente.getMarca() + " : " + componente.getModelo();
					}
					if (componente instanceof TarjetaMadre) {
						filas[3] = componente.getMarca() + " : " + componente.getModelo();
					}
					if (componente instanceof MemoriaRam) {
						filas[4] = componente.getMarca() + " : " + componente.getModelo();
					}
				}
				filas[5] = combo.getDesc() + "%";
				model.addRow(filas);
			}
		}
	}

	public static void CargarDiscoDuro() {
		model.setRowCount(0);
		filas = new Object[model.getColumnCount()];
		if (!Tienda.getInstance().getMisCombos().isEmpty()) {
			for (Componente comp : Tienda.getInstance().getMisComps()) {
				if (comp instanceof DiscoDuro) {
					filas[0] = comp.getNumSerie();
					filas[1] = comp.getMarca();
					filas[2] = comp.getModelo();
					filas[3] = comp.getPrecioV();
					filas[4] = ((DiscoDuro) comp).getCapacidad();
					filas[5] = ((DiscoDuro) comp).getTipoConexion();
					model.addRow(filas);
				}
			}
		}
	}

	public static void cargartarjeta() {
		model.setRowCount(0);
		filas = new Object[model.getColumnCount()];
		if (!Tienda.getInstance().getMisCombos().isEmpty()) {
			for (Componente comp : Tienda.getInstance().getMisComps()) {
				if (comp instanceof TarjetaMadre) {
					filas[0] = comp.getNumSerie();
					filas[1] = comp.getMarca();
					filas[2] = comp.getModelo();
					filas[3] = comp.getPrecioV();
					filas[4] = ((TarjetaMadre) comp).getTipoConector();
					filas[5] = ((TarjetaMadre) comp).getTipoRAM();

					model.addRow(filas);
				}
			}
		}
	}

	public static void cargarMicro() {
		model.setRowCount(0);
		filas = new Object[model.getColumnCount()];
		if (!Tienda.getInstance().getMisCombos().isEmpty()) {
			for (Componente comp : Tienda.getInstance().getMisComps()) {
				if (comp instanceof Microprocesador) {
					filas[0] = comp.getNumSerie();
					filas[1] = comp.getMarca();
					filas[2] = comp.getModelo();
					filas[3] = comp.getPrecioV();
					filas[4] = ((Microprocesador) comp).getVelocidadProccess();
					filas[5] = ((Microprocesador) comp).getTipoConexion();
					model.addRow(filas);
				}
			}
		}
	}
}
