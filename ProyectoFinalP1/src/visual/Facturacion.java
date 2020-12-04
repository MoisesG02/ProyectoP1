package visual;

import java.awt.BorderLayout;



import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import logico.Cliente;
import logico.Combo;
import logico.Componente;
import logico.DiscoDuro;
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
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Facturacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableComponente;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtCodigoFactura;
	private JTextField txtFechaCompra;
	private JTextField txtPrecioTotal;
	private JTextField txtTotalComp;
	public static DefaultTableModel model;
	public static DefaultTableModel model1;
	private Object[] filas;
	private Object[] filasx;
	private JComboBox cbxFiltro;
	private String numSerie;
	private ArrayList<Componente>misComp = new ArrayList<Componente>();
	private JTable tableFactura;
	private String codigox;


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
				JScrollPane scrollPane = new JScrollPane();
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
				JButton btnNewButton = new JButton("");
				btnNewButton.addActionListener(new ActionListener() { //IZQUIERDA A DERECHA
					public void actionPerformed(ActionEvent e) {
						float precioT=0f;
						Componente aux = Tienda.getInstance().obtenerComponente(numSerie);
						misComp.add(aux);
						//precioT += aux.getPrecioV();
						txtPrecioTotal.setText(""+calcuprecio());
						Tienda.getInstance().getMisComps().remove(aux);
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
				JButton btnNewButton_1 = new JButton("");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						float precio = 0f;
						Componente aux = buscarQBC(codigox);
						 Tienda.getInstance().getMisComps().add(aux);
						 precio -= aux.getPrecioV();
						 misComp.remove(aux);
						 txtPrecioTotal.setText(""+precio);
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
			cbxFiltro.setModel(new DefaultComboBoxModel(new String[] { "Seleccione", "Disco Duro", "Memoria Ram",
					"Tarjeta Madre", "Microprocesador", "Combos" }));
			cbxFiltro.setBounds(17, 28, 448, 22);
			panel_Tablas.add(cbxFiltro);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = tableFactura.getSelectedRow();
					codigox = String.valueOf(tableFactura.getValueAt(index, 0));
				}
			});
			scrollPane.setBounds(597, 55, 477, 302);
			panel_Tablas.add(scrollPane);
			
			tableFactura = new JTable();
			tableFactura.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			model1 = new DefaultTableModel();
			String[] column1 = { "#Serie", "Marca", "Modelo", "Cantiad", "Precio" };
			filasx = new Object[5];
			model1.setColumnIdentifiers(column1);
			tableFactura.setModel(model1);
			scrollPane.setViewportView(tableFactura);

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

			txtCedula = new JTextField();
			txtCedula.setBounds(80, 20, 133, 22);
			panel.add(txtCedula);
			txtCedula.setColumns(10);

			txtTelefono = new JTextField();
			txtTelefono.setBounds(80, 65, 133, 22);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);

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

			JButton btnNewButton_2 = new JButton("Buscar Cliente");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cliente client = Tienda.getInstance().buscarCliente(txtCedula.getText());
					if (client != null) {
						txtCedula.setText(client.getCedula());
						txtNombre.setText(client.getNombre());
						txtTelefono.setText(client.getTelefono());
						txtDireccion.setText(client.getDireccion());
					} else {
						JOptionPane.showMessageDialog(null, "Cliente no existente.");
					}
				}
			});
			btnNewButton_2.setBounds(90, 108, 133, 25);
			panel.add(btnNewButton_2);

			JButton btnNewButton_3 = new JButton("Crear Cliente");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (txtNombre.getText().equals("") || txtCedula.getText().equals("")
							|| txtTelefono.getText().equals("") || txtDireccion.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Llene todos los campos, por favor.");
					} else {
						Cliente client = new Cliente(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText(),
								txtDireccion.getText());
						JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.");

					}
				}
			});
			btnNewButton_3.setBounds(253, 108, 133, 25);
			panel.add(btnNewButton_3);

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

			txtCodigoFactura = new JTextField();
			txtCodigoFactura.setBounds(124, 20, 81, 22);
			panel_1.add(txtCodigoFactura);
			txtCodigoFactura.setColumns(10);

			JLabel lblNewLabel_5 = new JLabel("Fecha Compra:");
			lblNewLabel_5.setBounds(12, 96, 100, 16);
			panel_1.add(lblNewLabel_5);

			txtFechaCompra = new JTextField();
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
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(192, 192, 192));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Factura");
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
		rellenartabla();
	}

	private void rellenartabla() {
		model.setRowCount(0);
		filas = new Object[model.getColumnCount()];
		for (Componente comp : Tienda.getInstance().getMisComps()) {

			filas[0] = comp.getNumSerie();
			filas[1] = comp.getMarca();
			filas[2] = comp.getModelo();
			filas[3] = comp.getCantidad();
			filas[4] = comp.getPrecioV();

			model.addRow(filas);
		}
	}
	private void rellenartabla2() {
		model1.setRowCount(0);
		filas = new Object[model1.getColumnCount()];
		for (Componente comp : Tienda.getInstance().getMisComps()) {

			filas[0] = comp.getNumSerie();
			filas[1] = comp.getMarca();
			filas[2] = comp.getModelo();
			filas[3] = comp.getCantidad();
			filas[4] = comp.getPrecioV();

			model1.addRow(filas);
		}
	}

	private void Filtro(int seleccionado) {
		model.setRowCount(0);
		String tipo = null;
		filas = new Object[model.getColumnCount()];
		if (seleccionado == 0) {
			for (Componente comp : Tienda.getInstance().getMisComps()) {

				filas[0] = comp.getNumSerie();
				filas[1] = comp.getMarca();
				filas[2] = comp.getModelo();
				filas[3] = comp.getCantidad();
				filas[4] = comp.getPrecioV();

				model.addRow(filas);
			}
		} else if (seleccionado == 1) {
			for (Componente comp : Tienda.getInstance().getMisComps()) {

				if (comp instanceof DiscoDuro) {
					filas[0] = comp.getNumSerie();
					filas[1] = comp.getMarca();
					filas[2] = comp.getModelo();
					filas[3] = comp.getCantidad();
					filas[4] = comp.getPrecioV();

					model.addRow(filas);
				}
			}
		} else if (seleccionado == 2) {
			for (Componente comp : Tienda.getInstance().getMisComps()) {

				if (comp instanceof MemoriaRam) {
					filas[0] = comp.getNumSerie();
					filas[1] = comp.getMarca();
					filas[2] = comp.getModelo();
					filas[3] = comp.getCantidad();
					filas[4] = comp.getPrecioV();

					model.addRow(filas);

				}
			}
		} else if (seleccionado == 3) {
			for (Componente comp : Tienda.getInstance().getMisComps()) {

				if (comp instanceof TarjetaMadre) {
					filas[0] = comp.getNumSerie();
					filas[1] = comp.getMarca();
					filas[2] = comp.getModelo();
					filas[3] = comp.getCantidad();
					filas[4] = comp.getPrecioV();

					model.addRow(filas);
				}
			}
		} else if (seleccionado == 4) {
			for (Componente comp : Tienda.getInstance().getMisComps()) {

				if (comp instanceof Microprocesador) {
					filas[0] = comp.getNumSerie();
					filas[1] = comp.getMarca();
					filas[2] = comp.getModelo();
					filas[3] = comp.getCantidad();
					filas[4] = comp.getPrecioV();

					model.addRow(filas);
				}
			}
		}
	}
	public  void llenarT() {
		((DefaultTableModel) tableComponente.getModel()).setRowCount(0);
		int numCols = tableComponente.getModel().getColumnCount();
		Object[] filas = new Object[numCols];
		for (Componente auxQ : Tienda.getInstance().getMisComps()) {

			filas[0] = auxQ.getNumSerie();
			filas[1] = auxQ.getMarca();
			filas[2] = auxQ.getModelo();
			filas[3] = auxQ.getCantidad();
			filas[4] = auxQ.getPrecioV();

			((DefaultTableModel) tableComponente.getModel()).addRow(filas);

		}
	}
	public  void llenarT2() {
		((DefaultTableModel) tableFactura.getModel()).setRowCount(0);
		int numCols = tableFactura.getModel().getColumnCount();
		 filasx = new Object[numCols];
		for (Componente auxQ : misComp) {

			filasx[0] = auxQ.getNumSerie();
			filasx[1] = auxQ.getMarca();
			filasx[2] = auxQ.getModelo();
			filasx[3] = auxQ.getCantidad();
			filasx[4] = auxQ.getPrecioV();

			((DefaultTableModel) tableFactura.getModel()).addRow(filasx);

		}
	}
	public Componente buscarQBC(String code) {
		Componente aux = null;
		boolean encontrado =false;
		int c= 0;
		
		while(c<misComp.size()) {
			if(misComp.get(c).getNumSerie().equalsIgnoreCase(code)) {
				encontrado = true;
				aux = misComp.get(c);
			}
			c++;
	}
		return aux;
}
	public float calcuprecio() {
		float precioT = 0f;
		for(Componente comps : misComp) {
			precioT = comps.getPrecioV();
		}
		return precioT;
	}
}
