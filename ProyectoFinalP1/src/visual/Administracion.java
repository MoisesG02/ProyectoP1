package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

public class Administracion extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Administracion dialog = new Administracion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Administracion() {
		setBounds(-7, 399, 429, 269);
		getContentPane().setLayout(new BorderLayout());
		setUndecorated(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Registrar Componentes");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(0, 92, 432, 47);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registrar Empleados");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(0, 46, 432, 47);
		contentPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Combo de componentes");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(0, 137, 432, 47);
		contentPanel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Registrar Clientes");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registrar_Cliente reg = new Registrar_Cliente();
				reg.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(0, 0, 432, 47);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBounds(0, 183, 432, 47);
		contentPanel.add(btnNewButton_4);
	}
}
