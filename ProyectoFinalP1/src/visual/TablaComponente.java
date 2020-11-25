package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cliente;
import logico.Componente;
import logico.DiscoDuro;
import logico.Tienda;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TablaComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	DefaultTableModel model;
	private Object[] filas;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TablaComponente dialog = new TablaComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TablaComponente() {
		  setTitle("Lista de Componentes");
			
			setBounds(100, 100, 612, 424);
			getContentPane().setLayout(new BorderLayout());
			setLocationRelativeTo(null);
			contentPanel.setBackground(new Color(47, 79, 79));
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel = new JPanel();
				panel.setForeground(new Color(0, 128, 128));
				panel.setBackground(new Color(0, 128, 128));
				contentPanel.add(panel, BorderLayout.CENTER);
				panel.setLayout(null);
				{
					
					
					
					{
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBounds(0, 0, 584, 332);
						panel.add(scrollPane);
						model = new DefaultTableModel();
						String[] column = { "Numero de Serie", "Modelo", "Marca", "Cantidad", "Precio" };
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
		for (Componente comps : Tienda.getInstance().getMisComps()) {

			filas[0] = comps.getNumSerie();
			filas[1] = comps.getModelo();
			filas[2] = comps.getMarca();
			filas[3] = comps.getCantidad();
			filas[4] = comps.getPrecioV();
		
			model.addRow(filas);
			
		}
	}
}
