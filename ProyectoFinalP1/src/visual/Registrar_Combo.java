package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registrar_Combo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableComponente;
	private JTable tableCombo;

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
					
				}
			});
			scrollPane.setViewportView(tableComponente);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(513, 70, 394, 292);
			panelfondo.add(scrollPane_1);
			
			tableCombo = new JTable();
			scrollPane_1.setViewportView(tableCombo);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(Registrar_Combo.class.getResource("/Iconos/Actions-go-next-icon.png")));
			btnNewButton.setBounds(427, 163, 63, 25);
			panelfondo.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon(Registrar_Combo.class.getResource("/Iconos/Actions-go-previous-icon.png")));
			btnNewButton_1.setBounds(427, 201, 63, 25);
			panelfondo.add(btnNewButton_1);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Disco Duro", "Memoria Ram", "Tarjeta Madre", "Microprocesador"}));
			comboBox.setBounds(20, 42, 392, 22);
			panelfondo.add(comboBox);
			
			JLabel lblNewLabel = new JLabel("Seleccione componente");
			lblNewLabel.setBounds(10, 13, 145, 16);
			panelfondo.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(220, 220, 220));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCrearCombo = new JButton("Crear Combo");
				btnCrearCombo.setActionCommand("OK");
				buttonPane.add(btnCrearCombo);
				getRootPane().setDefaultButton(btnCrearCombo);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
