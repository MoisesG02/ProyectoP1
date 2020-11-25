package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class Inicio extends JFrame {

	private JPanel panelfondo;
	private Dimension dim;
	private JPanel panelFACT;
	private JPanel paneGRAFICOS;
	private JPanel panelList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1027, 504);
		panelfondo = new JPanel();
		
		panelfondo.setBackground(new Color(47, 79, 79));
		panelfondo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelfondo);
		panelfondo.setLayout(null);
		dim = getToolkit().getScreenSize();
		super.setSize(dim.width,dim.height-45);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 128, 128));
		panelMenu.setBounds(0, 0, 420, 1048);
		panelfondo.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/computer.png")));
		lblNewLabel.setBounds(138, 13, 144, 141);
		panelMenu.add(lblNewLabel);
		
		JPanel panelINICIO = new JPanel();
		panelINICIO.setBackground(new Color(0, 139, 139));
		panelINICIO.setForeground(new Color(0, 128, 128));
		panelINICIO.setBounds(0, 167, 420, 48);
		panelMenu.add(panelINICIO);
		panelINICIO.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("INICIO");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(89, 13, 152, 16);
		panelINICIO.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/house (1).png")));
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
		panelADM.setBounds(0, 217, 420, 48);
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
		
		
		
		JLabel lblADM = new JLabel("");
		lblADM.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				Administracion adm = new Administracion();
				adm.setVisible(true);
				
			
			}
			
			
		});
		lblADM.setBounds(396, 0, 24, 48);
		panelADM.add(lblADM);
		
		panelList = new JPanel();
		panelList.setBackground(new Color(0, 139, 139));
		panelList.setForeground(new Color(0, 128, 128));
		panelList.setBounds(0, 350, 420, 48);
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
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(396, 0, 24, 48);
		panelList.add(lblNewLabel_6);
		
		panelFACT = new JPanel();
		panelFACT.setBackground(new Color(0, 139, 139));
		panelFACT.setForeground(new Color(0, 128, 128));
		panelFACT.setBounds(0, 267, 420, 48);
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
		
		JLabel lblNewLabel_3 = new JLabel("");

		lblNewLabel_3.setBounds(396, 0, 24, 48);
		panelFACT.add(lblNewLabel_3);
		
		paneGRAFICOS = new JPanel();
		paneGRAFICOS.setBackground(new Color(0, 139, 139));
		paneGRAFICOS.setForeground(new Color(0, 128, 128));
		paneGRAFICOS.setBounds(0, 308, 420, 48);
		panelMenu.add(paneGRAFICOS);
		paneGRAFICOS.setLayout(null);
		
		JLabel lblGrficos_1 = new JLabel("AN\u00C1LISIS Y ESTAD\u00CDSTICAS");
		lblGrficos_1.setForeground(Color.WHITE);
		lblGrficos_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGrficos_1.setBounds(85, 13, 191, 16);
		paneGRAFICOS.add(lblGrficos_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/graph-bar (1).png")));
		label_3.setBounds(50, 0, 37, 40);
		paneGRAFICOS.add(label_3);
		
		JLabel lblNewLabel_5 = new JLabel("");

		lblNewLabel_5.setBounds(396, 0, 24, 48);
		paneGRAFICOS.add(lblNewLabel_5);
		
		JPanel panelOpciones = new JPanel();
		panelOpciones.setBackground(new Color(0, 128, 128));
		panelOpciones.setBounds(0, 399, 420, 321);
		panelMenu.add(panelOpciones);
		panelOpciones.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("RegCliente");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registrar_Cliente reg = new Registrar_Cliente();
				
				reg.setVisible(true);
				
			}
		});
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(131, 67, 128, 27);
		panelOpciones.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("TablaCliente");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TablaCliente reg = new TablaCliente();
				reg.setVisible(true);
			}
		});
		lblNewLabel_8.setBounds(131, 96, 103, 16);
		panelOpciones.add(lblNewLabel_8);
		
		
		JPanel panelSALIR = new JPanel();
		panelSALIR.setBounds(0, 987, 420, 48);
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
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_9.setIcon(new ImageIcon(Inicio.class.getResource("/Iconos/Actions-edit-delete-icon.png")));
		lblNewLabel_9.setBounds(1897, 0, 23, 37);
		panelfondo.add(lblNewLabel_9);
		
	}
}
