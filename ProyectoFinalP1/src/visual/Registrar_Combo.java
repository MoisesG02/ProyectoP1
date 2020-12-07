package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Combo;
import logico.Componente;
import logico.Tienda;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Registrar_Combo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableComponente;
	private JTable tableCombo;
	private String numSerie;
	private String codigox;
	public static DefaultTableModel model;
	public static DefaultTableModel model1;
	private Object[] filas;
	private Object[] filasx;
	private ArrayList<Componente> misCombos = new ArrayList<Componente>();
	private ArrayList<Componente> misCompCant = new ArrayList<Componente>();

	private JTextField txtPrecioTotal;
	private float precio = 0;
	private int cantx;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registrar_Combo dialog = new Registrar_Combo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Registrar_Combo() {
		setBounds(100, 100, 947, 467);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelfondo = new JPanel();
			panelfondo.setBackground(new Color(176, 224, 230));
			contentPanel.add(panelfondo, BorderLayout.CENTER);
			panelfondo.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(21, 70, 394, 292);
			panelfondo.add(scrollPane);

			tableComponente = new JTable();
			tableComponente.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = tableComponente.getSelectedRow();
					numSerie = String.valueOf(tableComponente.getValueAt(index, 0));
				}
			});
			model = new DefaultTableModel();
			String[] column = { "#Serie", "Marca", "Modelo", "Cantidad", "Precio" };
			filas = new Object[5];
			model.setColumnIdentifiers(column);
			tableComponente.setModel(model);
			scrollPane.setViewportView(tableComponente);

			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(513, 70, 394, 292);
			panelfondo.add(scrollPane_1);

			tableCombo = new JTable();
			tableCombo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int index = tableCombo.getSelectedRow();
					codigox = String.valueOf(tableCombo.getValueAt(index, 0));
				}
			});
			model1 = new DefaultTableModel();
			String[] column1 = { "#Serie", "Marca", "Modelo", "Cantidad", "Precio" };
			filasx = new Object[5];
			model1.setColumnIdentifiers(column1);
			tableCombo.setModel(model1);
			scrollPane_1.setViewportView(tableCombo);

			JButton btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() { // IZQ A DERECHA
				public void actionPerformed(ActionEvent e) {
					Componente aux = Tienda.getInstance().obtenerComponente(numSerie);
					
					String cant = JOptionPane.showInputDialog("Introduce un numero");
					if(Integer.valueOf(cant)>aux.getCantidad()) {
						JOptionPane.showMessageDialog(null,"Cantidad no disponible","Aviso",JOptionPane.WARNING_MESSAGE);
					}
					else{
						Componente auxi = new Componente(aux.getPrecioV(),aux.getNumSerie(),Integer.valueOf(cant),aux.getMarca(),aux.getModelo());
					
					precio += aux.getPrecioV()-aux.getPrecioV()*0.10f;
					misCompCant.add(auxi);
					cantx = aux.getCantidad()-auxi.getCantidad();
					int c = 0;
					aux.setCantidad(cantx);
					if(aux.getCantidad()<=0) {
						Tienda.getInstance().getMisComps().remove(aux);
						JOptionPane.showMessageDialog(null,"Ultimo en el inventario "+aux.getMarca()+""+"Disponibles","Aviso",JOptionPane.WARNING_MESSAGE);
							
					}
							
						
					}
				txtPrecioTotal.setText(""+precio);
					
							llenarT();
							llenarT2();
					
					
					
				
				}
			});
			llenarT();
			btnNewButton.setIcon(new ImageIcon(Registrar_Combo.class.getResource("/Iconos/Actions-go-next-icon.png")));
			btnNewButton.setBounds(427, 163, 63, 25);
			panelfondo.add(btnNewButton);

			JButton btnNewButton_1 = new JButton(""); //DE DERECHA A IZQUIERDA
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tableCombo.getSelectedRow();
					Componente aux = buscarQBC(codigox);
					precio -= aux.getPrecioV() - aux.getPrecioV() * 0.10;
					Tienda.getInstance().getMisComps().add(aux);
					misCombos.remove(aux);
					misCompCant.remove(aux);
					txtPrecioTotal.setText("" + precio);
					llenarT();
					llenarT2();
				}
			});
			btnNewButton_1
					.setIcon(new ImageIcon(Registrar_Combo.class.getResource("/Iconos/Actions-go-previous-icon.png")));
			btnNewButton_1.setBounds(427, 201, 63, 25);
			panelfondo.add(btnNewButton_1);

			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(
					new String[] { "<Todos>", "Disco Duro", "Memoria Ram", "Tarjeta Madre", "Microprocesador" }));
			comboBox.setBounds(20, 42, 392, 22);
			panelfondo.add(comboBox);

			JLabel lblNewLabel = new JLabel("Seleccione componente");
			lblNewLabel.setBounds(10, 13, 145, 16);
			panelfondo.add(lblNewLabel);

			txtPrecioTotal = new JTextField();
			txtPrecioTotal.setBounds(808, 35, 99, 22);
			panelfondo.add(txtPrecioTotal);
			txtPrecioTotal.setColumns(10);

			JLabel lblNewLabel_1 = new JLabel("Precio Total del Combo");
			lblNewLabel_1.setBounds(657, 41, 139, 16);
			panelfondo.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(220, 220, 220));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCrearCombo = new JButton("Crear Combo");
				btnCrearCombo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
			         	Combo combito = new Combo(misCompCant,"COD-"+Tienda.getInstance().getCodCombo(),precio,10);
						
						Tienda.getInstance().insertarCombo(combito);
						JOptionPane.showMessageDialog(null, "Su registro fue exitoso!");
						Tienda.getInstance().getMisComps().removeAll(misCompCant);
						misCompCant.removeAll(misCompCant);
                        model1.setRowCount(0);
                        precio = 0;
                        txtPrecioTotal.setText(""+0.0f+"$");
                        System.out.println(combito.getPrecio());
                        
                        llenarT2();
						
					}
				});
				btnCrearCombo.setActionCommand("OK");
				buttonPane.add(btnCrearCombo);
				getRootPane().setDefaultButton(btnCrearCombo);
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
	}

	public void llenarT() {
		((DefaultTableModel) tableComponente.getModel()).setRowCount(0);
		int numCols = tableComponente.getModel().getColumnCount();
		Object[] filas = new Object[numCols];
		for (Componente auxQ : Tienda.getInstance().getMisComps()) {
            if(auxQ.getCantidad()>0) {
			filas[0] = auxQ.getNumSerie();
			filas[1] = auxQ.getMarca();
			filas[2] = auxQ.getModelo();
			filas[3] = auxQ.getCantidad();
			filas[4] = auxQ.getPrecioV();
            }
//tabla bien
			((DefaultTableModel) tableComponente.getModel()).addRow(filas);

		}
	}

	public void llenarT2() {
		((DefaultTableModel) tableCombo.getModel()).setRowCount(0);
		int numColus = tableCombo.getModel().getColumnCount();
		Object[] filasx = new Object[numColus];
		for (Componente auxQ : misCompCant) {

			filasx[0] = auxQ.getNumSerie();
			filasx[1] = auxQ.getMarca();
			filasx[2] = auxQ.getModelo();
			filasx[3] = auxQ.getCantidad();
			filasx[4] = auxQ.getPrecioV();
			// tabla bien
			((DefaultTableModel) tableCombo.getModel()).addRow(filasx);

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
}
