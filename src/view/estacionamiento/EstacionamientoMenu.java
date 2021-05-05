package view.estacionamiento;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

/**
 * The Class EstacionamientoMenu.
 */
public class EstacionamientoMenu extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The entrada. */
	private Entrada entrada;
	
	/** The salida. */
	private Salida salida;
	
	/** The inicio. */
	private Inicio inicio;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public EstacionamientoMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrada = new JButton("Entrada");
		Image img2= new ImageIcon(this.getClass().getResource("/imagen/barrera.png")).getImage();
		btnEntrada  .setIcon(new ImageIcon(img2));
		btnEntrada .setFont(new Font("Arial", Font.BOLD, 20));
		btnEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				entrada= new Entrada();
				entrada.show();
				dispose();
			}
		});
		btnEntrada.setBounds(26, 70, 274, 63);
		contentPane.add(btnEntrada);
		
		JButton btnSalida = new JButton("Salida");
		Image img1= new ImageIcon(this.getClass().getResource("/imagen/carretera.png")).getImage();
		btnSalida .setIcon(new ImageIcon(img1));
		btnSalida.setFont(new Font("Arial", Font.BOLD, 21));
		btnSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salida=new Salida();
				salida.show();
				dispose();
			}
		});
		btnSalida.setBounds(340, 70, 274, 63);
		contentPane.add(btnSalida);
		
		JButton btnRegresar = new JButton("Regresar");
		Image img5= new ImageIcon(this.getClass().getResource("/imagen/espalda.png")).getImage();
		btnRegresar .setIcon(new ImageIcon(img5));
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 21));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicio = new Inicio();
				inicio.show();
				dispose();
			}
		});
		btnRegresar.setBounds(223, 273, 201, 63);
		contentPane.add(btnRegresar);
		
		JButton btnVerTodosLos = new JButton("Ver Todos los registros");
		Image img3= new ImageIcon(this.getClass().getResource("/imagen/contactos.png")).getImage();
		btnVerTodosLos .setIcon(new ImageIcon(img3));
		btnVerTodosLos.setFont(new Font("Arial", Font.BOLD, 21));
		btnVerTodosLos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerTodo ver=new VerTodo();
				ver.show();
				dispose();
			}
		});
		btnVerTodosLos.setBounds(136, 169, 344, 73);
		contentPane.add(btnVerTodosLos);
		
		JLabel lblSele = new JLabel("Seleccione la operaci\u00F3n que dese realizar ");
		lblSele.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 28));
		lblSele.setBounds(26, 24, 585, 35);
		contentPane.add(lblSele);
	}
}
