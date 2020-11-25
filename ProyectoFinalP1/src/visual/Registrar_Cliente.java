package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import logico.Cliente;
import logico.Tienda;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class Registrar_Cliente extends JDialog {

	private final JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JFormattedTextField txtTelefono;
	private JFormattedTextField txtCed;


	public Registrar_Cliente() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Registrar Cliente");
		setBounds(100, 100, 485, 262);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Informaci\u00F3n", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setForeground(new Color(176, 224, 230));
			panel.setBackground(new Color(255, 250, 205));
			contentPane.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setForeground(new Color(0, 0, 0));
				lblNombre.setBackground(new Color(0, 0, 0));
				lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNombre.setBounds(12, 67, 67, 16);
				panel.add(lblNombre);
			}
			
			{
				JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
				lblDireccion.setForeground(new Color(0, 0, 0));
				lblDireccion.setBackground(Color.WHITE);
				lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblDireccion.setBounds(12, 96, 67, 16);
				panel.add(lblDireccion);
			}
			
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(87, 66, 193, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			
			
			{
				JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
				lblTelfono.setForeground(new Color(0, 0, 0));
				lblTelfono.setBackground(Color.WHITE);
				lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblTelfono.setBounds(12, 125, 67, 16);
				panel.add(lblTelfono);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setToolTipText("");
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(87, 95, 193, 20);
				panel.add(txtDireccion);
			
			}
			
			{
				JLabel lblCedula = new JLabel("C\u00E9dula:");
				lblCedula.setForeground(new Color(0, 0, 0));
				lblCedula.setBackground(new Color(0, 0, 0));
				lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblCedula.setBounds(12, 38, 67, 16);
				panel.add(lblCedula);
			}
			{
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(Registrar_Cliente.class.getResource("/Iconos/customer-feedback (2).png")));
				lblNewLabel.setBounds(326, 33, 119, 108);
				panel.add(lblNewLabel);
			}
			
			MaskFormatter format = new MaskFormatter();
			try {
				format = new MaskFormatter("###-##-#");
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			   format.setPlaceholderCharacter('_');
			{
				txtCed = new JFormattedTextField(format);
				txtCed.setBounds(87, 36, 193, 22);
				panel.add(txtCed);
			}
			
			MaskFormatter formatter = new MaskFormatter();
			try {
				formatter = new MaskFormatter("(###)-###-####");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   formatter.setPlaceholderCharacter('_');
			{
				txtTelefono = new JFormattedTextField(formatter);
				txtTelefono.setBounds(87, 123, 193, 22);
				panel.add(txtTelefono);
			}
				
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 250, 205));
			buttonPane.setBorder(null);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int ind;
						String nom;
						String ced;
						String dir;
						String tel;
						ced = txtCed.getText();
						nom = txtNombre.getText();
						tel = txtTelefono.getText();
						dir = txtDireccion.getText();
					
						ind = Tienda.getInstance().BuscarCliente(ced);
		
						if(nom.isEmpty() || dir.isEmpty() || tel.isEmpty()) {
							JOptionPane.showMessageDialog(null,"Has dejado campos vacíos o incompletos","Aviso",JOptionPane.WARNING_MESSAGE);
						}
						else if(ind > -1){
							JOptionPane.showMessageDialog(null,"Ya existe un cliente con ese número.","Aviso",JOptionPane.WARNING_MESSAGE);
						}
						else {
							dispose();
							Cliente c1 = new Cliente(ced,nom,tel,dir);
							Tienda.getInstance().insertarCliente(c1);
							System.out.println(""+c1.getNombre()+c1.getCedula()+c1.getTelefono());
							JOptionPane.showMessageDialog(null,"El cliente ha sido registrado.","Información",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				
				btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			
		}
				
			}
			
	

	}
	


	

