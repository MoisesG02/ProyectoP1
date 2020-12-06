package visual;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Tienda;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel panelfondo;
	private Dimension dim;
	private JPanel panelFACT;
	private JPanel paneGRAFICOS;
	private JPanel panelList;
	private JPanel panelADM1;
	private JLabel lblADM;
	private JLabel lblLIST;
	private JPanel panelListado;
	private JPanel panelListCliente;
	private JLabel lblNewLabel_3;
	private JPanel panelListComponente;
	private JPanel panelListEmpleado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa = new FileInputStream ("Tienda.dat");
					empresaRead = new ObjectInputStream(empresa);
					Tienda temp = (Tienda)empresaRead.readObject();
					Tienda.setTienda(temp);
					empresa.close();
					empresaRead.close();
				}catch(FileNotFoundException e) {
					try {
						empresa2 = new FileOutputStream("Tienda.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						empresaWrite.writeObject(Tienda.getInstance());
						empresa2.close();
						empresaWrite.close();
					}catch(FileNotFoundException e1) {
						
					}catch(IOException e1) {
						
					}
				}catch(IOException e) {
					
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new  FileOutputStream("Tienda.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Tienda.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		panelfondo = new JPanel();
		panelfondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelListado.setVisible(false);
				panelADM1.setVisible(false);
			}
		});
		
		panelfondo.setBackground(new Color(47, 79, 79));
		panelfondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelfondo);
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		panelfondo.setLayout(null);
		
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 389, 600);
		panelMenu.setBackground(new Color(0, 128, 128));
		panelfondo.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/InicioComputer.png")));
		lblNewLabel.setBounds(138, 13, 144, 141);
		panelMenu.add(lblNewLabel);
		
		JPanel panelINICIO = new JPanel();
		panelINICIO.setBackground(new Color(0, 139, 139));
		panelINICIO.setForeground(new Color(0, 128, 128));
		panelINICIO.setBounds(0, 167, 389, 48);
		panelMenu.add(panelINICIO);
		panelINICIO.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("INICIO");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(89, 13, 152, 16);
		panelINICIO.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/house1.png")));
		lblNewLabel_2.setBounds(50, 0, 37, 40);
		panelINICIO.add(lblNewLabel_2);
		
		
		JLabel label = new JLabel("");
		label.setBounds(22, 37, 45, 40);
		panelINICIO.add(label);
		
		JPanel panelADM = new JPanel();
		panelADM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		panelADM.setBackground(new Color(0, 139, 139));
		panelADM.setForeground(new Color(0, 128, 128));
		panelADM.setBounds(0, 217, 389, 48);
		panelMenu.add(panelADM);
		panelADM.setLayout(null);
		
		
		JLabel lblAdministracion = new JLabel("ADMINISTRACI\u00D3N");
		lblAdministracion.setForeground(Color.WHITE);
		lblAdministracion.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAdministracion.setBounds(85, 13, 160, 16);
		panelADM.add(lblAdministracion);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/bussiness-man.png")));
		label_1.setBounds(50, 0, 37, 40);
		panelADM.add(label_1);
		
		
		
		lblADM = new JLabel("");
		lblADM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelADM1.setVisible(true);
				panelListado.setVisible(false);

			}
		});
		lblADM.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/right-arrow.png")));
		lblADM.setBounds(364, 0, 24, 48);
		panelADM.add(lblADM);
		
		panelList = new JPanel();
		panelList.setBackground(new Color(0, 139, 139));
		panelList.setForeground(new Color(0, 128, 128));
		panelList.setBounds(0, 360, 389, 48);
		panelMenu.add(panelList);
		panelList.setLayout(null);
		
		JLabel lblListados = new JLabel("LISTADOS");
		lblListados.setForeground(Color.WHITE);
		lblListados.setFont(new Font("Dialog", Font.BOLD, 14));
		lblListados.setBounds(85, 13, 160, 16);
		panelList.add(lblListados);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/reminders.png")));
		label_4.setBounds(50, 0, 37, 40);
		panelList.add(label_4);
		
		lblLIST = new JLabel("");
		lblLIST.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelADM1.setVisible(false);
				panelListado.setVisible(true);
				
			}
		});
		lblLIST.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/right-arrow.png")));
		lblLIST.setBounds(363, 0, 24, 48);
		panelList.add(lblLIST);
		
		panelFACT = new JPanel();
		panelFACT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Facturacion fact = new Facturacion();
				fact.setVisible(true);
			}
		});
		panelFACT.setBackground(new Color(0, 139, 139));
		panelFACT.setForeground(new Color(0, 128, 128));
		panelFACT.setBounds(0, 267, 389, 48);
		panelMenu.add(panelFACT);
		panelFACT.setLayout(null);
		
		JLabel lblGrficos = new JLabel("FACTURACI\u00D3N");
		lblGrficos.setForeground(Color.WHITE);
		lblGrficos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGrficos.setBounds(85, 13, 160, 16);
		panelFACT.add(lblGrficos);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/invoice.png")));
		label_2.setBounds(50, 0, 37, 40);
		panelFACT.add(label_2);
		
		paneGRAFICOS = new JPanel();
		paneGRAFICOS.setBackground(new Color(0, 139, 139));
		paneGRAFICOS.setForeground(new Color(0, 128, 128));
		paneGRAFICOS.setBounds(0, 314, 389, 48);
		panelMenu.add(paneGRAFICOS);
		paneGRAFICOS.setLayout(null);
		
		JLabel lblGrficos_1 = new JLabel("AN\u00C1LISIS Y ESTAD\u00CDSTICAS");
		lblGrficos_1.setForeground(Color.WHITE);
		lblGrficos_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGrficos_1.setBounds(85, 13, 191, 16);
		paneGRAFICOS.add(lblGrficos_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/graphic.png")));
		label_3.setBounds(50, 0, 37, 40);
		paneGRAFICOS.add(label_3);
		
		JLabel lblNewLabel_5 = new JLabel("");

		lblNewLabel_5.setBounds(396, 0, 24, 48);
		paneGRAFICOS.add(lblNewLabel_5);
		
		
		JPanel panelSALIR = new JPanel();
		panelSALIR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login log = new Login();
				log.setVisible(true);
				
			}
		});
		panelSALIR.setBounds(0, 552, 389, 48);
		panelMenu.add(panelSALIR);
		panelSALIR.setBackground(new Color(0, 139, 139));
		panelSALIR.setForeground(new Color(0, 128, 128));
		panelSALIR.setLayout(null);
		
		JLabel lblSalir = new JLabel("SALIR");
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSalir.setBounds(87, 13, 160, 16);
		panelSALIR.add(lblSalir);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/exit-door-symbol.png")));
		label_5.setBounds(50, 0, 37, 40);
		panelSALIR.add(label_5);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login log = new Login();
				log.setVisible(true);
			}
		});
		lblNewLabel_7.setIcon(new ImageIcon("/Iconos/right-arrow.png"));
		lblNewLabel_7.setBounds(388, 0, 32, 48);
		panelSALIR.add(lblNewLabel_7);
		
		JLabel lblNewLabel_10 = new JLabel("                                Registrar Cliente");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBackground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(0, 267, 420, 48);
		panelMenu.add(lblNewLabel_10);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(1177, 0, 23, 37);
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_9.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/Actions-edit-delete-icon.png")));
		panelfondo.add(lblNewLabel_9);
		
		panelADM1 = new JPanel();
		panelADM1.setBounds(391, 219, 289, 141);
		panelfondo.add(panelADM1);
		panelADM1.setVisible(false);
		panelADM1.setLayout(null);
		
		JPanel PanelRegCliente = new JPanel();
		PanelRegCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registrar_Combo reg = new Registrar_Combo();
				reg.setVisible(true);
			}
		});
		
		PanelRegCliente.setBounds(0, 0, 289, 48);
		panelADM1.add(PanelRegCliente);
		PanelRegCliente.setBackground(new Color(0, 128, 128));
		PanelRegCliente.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("REGISTRAR COMBO");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_4.setBounds(66, 13, 187, 22);
		PanelRegCliente.add(lblNewLabel_4);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/cpu.png")));
		lblNewLabel_11.setBounds(22, 0, 32, 48);
		PanelRegCliente.add(lblNewLabel_11);
		
		JPanel PanelRegComponente = new JPanel();
		PanelRegComponente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelADM1.setVisible(false);
				Registrar_Componente reg = new Registrar_Componente();
				reg.setVisible(true);
			}
		});
		PanelRegComponente.setBounds(0, 46, 289, 48);
		panelADM1.add(PanelRegComponente);
		PanelRegComponente.setBackground(new Color(0, 128, 128));
		PanelRegComponente.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("REGISTRAR COMPONENTE");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_8.setBounds(66, 13, 209, 22);
		PanelRegComponente.add(lblNewLabel_8);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/computer.png")));
		lblNewLabel_12.setBounds(22, 0, 32, 48);
		PanelRegComponente.add(lblNewLabel_12);
		
		JPanel panelRegEmpleado = new JPanel();
		panelRegEmpleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelADM1.setVisible(false);
				RegistrarEmpleados regE = new RegistrarEmpleados();
				regE.setVisible(true);
				
			}
		});
		panelRegEmpleado.setBounds(0, 94, 289, 48);
		panelADM1.add(panelRegEmpleado);
		panelRegEmpleado.setBackground(new Color(0, 128, 128));
		panelRegEmpleado.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("REGISTRAR EMPLEADO");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_13.setBounds(66, 13, 209, 22);
		panelRegEmpleado.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/officer.png")));
		lblNewLabel_14.setBounds(22, 0, 32, 48);
		panelRegEmpleado.add(lblNewLabel_14);
		
		panelListado = new JPanel();
		panelListado.setBounds(391, 362, 289, 147);
		panelfondo.add(panelListado);
		panelListado.setVisible(false);
		panelListado.setLayout(null);
		
		panelListCliente = new JPanel();
		panelListCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelListado.setVisible(false);
				TablaCliente client = new TablaCliente();
				client.setVisible(true);
			}
		});
		panelListCliente.setBackground(new Color(0, 128, 128));
		panelListCliente.setBounds(0, 0, 289, 48);
		panelListado.add(panelListCliente);
		panelListCliente.setLayout(null);
		
		lblNewLabel_3 = new JLabel("LISTA CLIENTES");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(66, 13, 209, 22);
		panelListCliente.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/clientes1.png")));
		lblNewLabel_6.setBounds(22, 0, 32, 48);
		panelListCliente.add(lblNewLabel_6);
		
		panelListComponente = new JPanel();
		panelListComponente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelListado.setVisible(false);
				panelADM1.setVisible(false);
				TablaComponente reg = new TablaComponente();
				reg.setVisible(true);
			}
		});
		panelListComponente.setBackground(new Color(0, 128, 128));
		panelListComponente.setBounds(0, 48, 289, 48);
		panelListado.add(panelListComponente);
		panelListComponente.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("LISTA COMPONENTES");
		lblNewLabel_15.setForeground(Color.WHITE);
		lblNewLabel_15.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_15.setBounds(66, 13, 209, 22);
		panelListComponente.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/computadoralista.png")));
		lblNewLabel_16.setBounds(22, 0, 32, 48);
		panelListComponente.add(lblNewLabel_16);
		
		panelListEmpleado = new JPanel();
		panelListEmpleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelListado.setVisible(false);
				TablaEmpleado employee = new TablaEmpleado();
				employee.setVisible(true);
			}
		});
		panelListEmpleado.setBackground(new Color(0, 128, 128));
		panelListEmpleado.setBounds(0, 93, 289, 54);
		panelListado.add(panelListEmpleado);
		panelListEmpleado.setLayout(null);
		
		JLabel lblNewLabel_17 = new JLabel("LISTA EMPLEADOS");
		lblNewLabel_17.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_17.setForeground(Color.WHITE);
		lblNewLabel_17.setBounds(66, 13, 209, 22);
		panelListEmpleado.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/empleados1.png")));
		lblNewLabel_18.setBounds(22, 0, 32, 48);
		panelListEmpleado.add(lblNewLabel_18);
		
	}
}
