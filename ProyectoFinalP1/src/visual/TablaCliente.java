package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Tienda;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TablaCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	DefaultTableModel model;
	private Object[] filas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TablaCliente dialog = new TablaCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TablaCliente() {
       setTitle("Lista de clientes");
		
		setBounds(100, 100, 495, 367);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				
				
				
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(0, 0, 467, 275);
					panel.add(scrollPane);
					model = new DefaultTableModel();
					String[] column = { "Cedula", "Nombre", "Telefono", "Direccion" };
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int index = table.getSelectedRow();
							
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					model.setColumnIdentifiers(column);
					table.setModel(model);
					
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Continuar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					dispose();
					}
				});
				btnCancelar.setActionCommand("OK");
				buttonPane.add(btnCancelar);
				getRootPane().setDefaultButton(btnCancelar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		rellenartabla1();
	}
	private void rellenartabla1() {
		model.setRowCount(0);
		filas = new Object[model.getColumnCount()];
		for (Cliente client: Tienda.getInstance().getMisClientes()) {

			filas[0] = client.getCedula();
			filas[1] = client.getNombre();
			filas[2] = client.getTelefono(); 
			filas[3] = client.getDireccion();
			model.addRow(filas);
		}
	}
}
