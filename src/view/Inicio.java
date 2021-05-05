package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import view.auto.Auto;
import view.estacionamiento.EstacionamientoMenu;
import view.personas.Personas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

/**
 * The Class Inicio.
 */
public class Inicio extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The auto. */
	private Auto auto;
	
	/** The persona. */
	private Personas persona;
	
	/** The estacionamiento. */
	private EstacionamientoMenu estacionamiento;


	/**
	 * Instantiates a new inicio.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPersonas = new JButton("Personas");
		btnPersonas.setIcon(new ImageIcon(Inicio.class.getResource("/imagen/equipo.png")));
		btnPersonas.setFont(new Font("Arial", Font.BOLD, 20));
		btnPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				persona=new Personas();
				persona.setVisible(true);
				dispose();
			}
		});
		btnPersonas.setBounds(282, 124, 274, 54);
		contentPane.add(btnPersonas);
		
		JButton btnEstacionamientos = new JButton("Estacionamientos");
		Image img1= new ImageIcon(this.getClass().getResource("/imagen/aparcamiento(2).png")).getImage();
		btnEstacionamientos .setIcon(new ImageIcon(img1));
		btnEstacionamientos.setFont(new Font("Arial", Font.BOLD, 20));
		btnEstacionamientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estacionamiento=new EstacionamientoMenu();
				estacionamiento.show();
				
				dispose();
			}
			
		});
		btnEstacionamientos.setBounds(282, 318, 274, 54);
		contentPane.add(btnEstacionamientos);
		
		JButton btnAutos = new JButton("Autos");
		Image img2= new ImageIcon(this.getClass().getResource("/imagen/coche.png")).getImage();
		btnAutos .setIcon(new ImageIcon(img2));
		btnAutos.setFont(new Font("Arial", Font.BOLD, 20));
		btnAutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				auto=new Auto();
				auto.setVisible(true);
				dispose();
			}
		});
		btnAutos.setBounds(422, 222, 217, 54);
		contentPane.add(btnAutos);
		
		JLabel label = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/imagen/logov2.0.png")).getImage();
	label .setIcon(new ImageIcon(img));
		label.setBounds(7, 124, 310, 234);
		contentPane.add(label);
		
		
		JLabel lblBienvenidoACar = new JLabel("BIENVENIDO A CAR PARKING");
		lblBienvenidoACar.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 37));
		lblBienvenidoACar.setBounds(48, 11, 553, 44);
		contentPane.add(lblBienvenidoACar);
		
		JLabel lblSeleccioneAQue = new JLabel("Seleccione a que secci\u00F3n quiere ingresar:");
		lblSeleccioneAQue.setFont(new Font("Arial", Font.ITALIC, 21));
		lblSeleccioneAQue.setBounds(10, 74, 601, 32);
		contentPane.add(lblSeleccioneAQue);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 20));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int seleccion = comboBox.getSelectedIndex();
			
					if (seleccion==1) {
						try {
							UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
							SwingUtilities.updateComponentTreeUI(getContentPane());
						} catch (Exception e) {
							// TODO: handle exception
						}
						
					} else if(seleccion==2){
						try {
						UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
						SwingUtilities.updateComponentTreeUI(getContentPane());
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					else if(seleccion==3){
						try {
						UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
						SwingUtilities.updateComponentTreeUI(getContentPane());
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					else if(seleccion==4){
						try {
						UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
						SwingUtilities.updateComponentTreeUI(getContentPane());
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					else if(seleccion==5){
						try {
						UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
						SwingUtilities.updateComponentTreeUI(getContentPane());
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					else if(seleccion==6){
						try {
						UIManager.setLookAndFeel("UpperEssential.UpperEssentialLookAndFeel");
						SwingUtilities.updateComponentTreeUI(getContentPane());
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				} 
				
			
		});
		
		comboBox.setBounds(24, 369, 190, 20);
		contentPane.add(comboBox);
		comboBox.addItem("Cambiar diseño");
		comboBox.addItem("JTattoo smart");
		comboBox.addItem("JTattoo Acryl");
		comboBox.addItem("JTattoo Mac");
		comboBox.addItem("JTattoo Texture");
		comboBox.addItem("JTattoo Hifi");
		comboBox.addItem("Upper Essential");
		
		
	}//constructor
}
