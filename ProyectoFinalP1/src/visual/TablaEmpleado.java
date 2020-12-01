package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Administrador;
import logico.Cliente;
import logico.Empleado;
import logico.Tienda;
import logico.Vendedores;

public class TablaEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	DefaultTableModel model;
	private Object[] filas;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TablaEmpleado dialog = new TablaEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TablaEmpleado() {
		 setTitle("Lista de clientes");
			
			setBounds(100, 100, 743, 469);
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
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 715, 377);
				model = new DefaultTableModel();
				String[] column = { "Posición", "Cedula", "Nombre","Sexo", "Usuario", "Contraseña" };
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
				panel.add(scrollPane);
				
				scrollPane.setViewportView(table);
				{

					{
					
						
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
			String pos = "Administrador";
			String pos1 = "Vendedor";
            
            
            			
			for (Empleado employee: Tienda.getInstance().getMisEmpleados()) {
				
                   if(employee instanceof Administrador) {
                  	 String password1;

				filas[0] = pos;
				filas[1] = employee.getId();
				filas[2] = employee.getNombre();
                filas[3] = employee.getSexo();
				filas[4] = ((Administrador) employee).getUsuario();
				password1 = ((Administrador) employee).getPass();
				filas[5] = password1.replace(password1, "*");
				
				model.addRow(filas);
                   }
                   if(employee instanceof Vendedores) {
                	   
                	 String password;
                	 
                    filas[0] = pos1;
       				filas[1] = employee.getId();
       				filas[2] = employee.getNombre();
       				filas[3] = employee.getSexo();
       				filas[4] = ((Vendedores) employee).getUsuario();
                    password = ((Vendedores) employee).getPassword();
                    
       				filas[5] = password.replace(password, "*");
       				
       				model.addRow(filas);
                   }
			}
		}
	}
