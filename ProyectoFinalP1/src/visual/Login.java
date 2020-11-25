package visual;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logico.Tienda;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;



public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	//*
	private JLabel lblLogo;
	private JLabel lblLoginMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(175, 169, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUser.getText().equals("Usuario")) {
					txtUser.setText("");
				}else {
					txtUser.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUser.getText().equals("")) {
					txtUser.setText("Username");
				}
			}
		});
		txtUser.setBorder(null);
		txtUser.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUser.setText("Usuario");
		txtUser.setBounds(10, 11, 170, 20);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Iconos/bussiness-man.png")));
		lblNewLabel_2.setBounds(210, 1, 40, 40);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(175, 237, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
				txtPassword.setEchoChar('●');
				txtPassword.setText("");
			}else {
				txtPassword.selectAll();
			}
			}
			@Override
			public void focusLost(FocusEvent e) {
			    if(txtPassword.getText().equals("")) {
			    	txtPassword.setText("Password");
			    	txtPassword.setEchoChar((char)0);
			    }
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 11, 170, 20);
		panel_1.add(txtPassword);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/Iconos/preferences-desktop-user-password-icon2.png")));
		lblNewLabel_3.setBounds(209, 0, 41, 40);
		panel_1.add(lblNewLabel_3);
		
		JPanel panelbtnlogin = new JPanel();
		panelbtnlogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(txtPassword.getText().equalsIgnoreCase("123") && txtUser.getText().equalsIgnoreCase("admin123") ) {
					lblLoginMessage.setText("");
					JOptionPane.showMessageDialog(null, "Bienvenido a Master Tech.");
					Inicio inicio = new Inicio();
					inicio.setVisible(true);
					dispose();

				}
				else if(txtUser.getText().equals("") || txtUser.getText().equals("Username")|| txtPassword.getText().equals("") || txtPassword.getText().equals("Password")){
					lblLoginMessage.setText("Por favor llenar todos los espacios.");
				}else {
					lblLoginMessage.setText("Usuario o contraseña incorrecta.");

				}
			}
		});
		panelbtnlogin.setBackground(new Color(47, 79, 79));
		panelbtnlogin.setBounds(175, 321, 250, 40);
		contentPane.add(panelbtnlogin);
		panelbtnlogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(102, 13, 105, 16);
		panelbtnlogin.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Login.class.getResource("/Iconos/key2.png")));
		lblNewLabel_4.setBounds(56, 0, 44, 40);
		panelbtnlogin.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Iconos/Actions-edit-delete-icon.png")));
		lblNewLabel_1.setBounds(580, 0, 20, 20);
		contentPane.add(lblNewLabel_1);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/Iconos/PC-a-icon.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(251, 49, 104, 96);
		contentPane.add(lblLogo);
		
		lblLoginMessage = new JLabel("");
		lblLoginMessage.setForeground(Color.WHITE);
		lblLoginMessage.setBackground(Color.WHITE);
		lblLoginMessage.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLoginMessage.setBounds(175, 290, 250, 16);
		contentPane.add(lblLoginMessage);
	
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
