package view.estacionamiento;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.AreaDAO;
import DAO.AutoDAO;
import DAO.PersonaDAO;
import DAO.ReportesDAO;
import DAO.Patrones.Decorator.ConcreteEstacionamiento;
import DAO.Patrones.Decorator.DecoratorEntrada;
import DAO.Patrones.Decorator.Estacionamiento;
import DAO.Patrones.Iterator.Iterator;
import DAO.Patrones.Iterator.Area.AgregadoConcretoArea;
import DAO.Patrones.Iterator.Auto.AgregadoConcretoAuto;
import DAO.Patrones.Iterator.Persona.AgregadoConcretoPersona;
import net.sf.jasperreports.engine.JRException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

/**
 * The Class Entrada.
 */
public class Entrada extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The cb lugar. */
	private JComboBox cbAutos,cbPersonas,cbLugar;
	
	/** The lbl lugar. */
	private JLabel lblLugar;
	
	/** The costo. */
	private int costo;
	
	/** The tiket. */
	private ReportesDAO tiket;

	/**
	 * Instantiates a new entrada.
	 */
	public Entrada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbAutos = new JComboBox();
		cbAutos.setFont(new Font("Arial", Font.BOLD, 19));
		cbAutos.setBounds(110, 26, 237, 29);
		cbAutos.addItem("Seleccione un auto");
		buscarAutos();
		contentPane.add(cbAutos);
		
		cbPersonas = new JComboBox();
		cbPersonas.setFont(new Font("Arial", Font.BOLD, 19));
		cbPersonas.setBounds(110, 70, 237, 29);
		cbPersonas.addItem("Seleccione al dueño");
		buscarPersonas();
		contentPane.add(cbPersonas);
		
		JLabel lblNewLabel = new JLabel("Autos");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel.setBounds(12, 28, 61, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Personas");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_1.setBounds(12, 70, 99, 22);
		contentPane.add(lblNewLabel_1);
		
		lblLugar = new JLabel("Lugar");
		lblLugar.setFont(new Font("Arial", Font.BOLD, 19));
		lblLugar.setBounds(12, 111, 61, 29);
		contentPane.add(lblLugar);
		
		cbLugar = new JComboBox();
		cbLugar.setFont(new Font("Arial", Font.BOLD, 19));
		cbLugar.setBounds(110, 111, 237, 29);
		cbLugar.addItem("Seleccione un Lugar");
		buscarArea();
		contentPane.add(cbLugar);
		
		JButton btnAgregar = new JButton("Agregar");
		Image img3= new ImageIcon(this.getClass().getResource("/imagen/archivo.png")).getImage();
		btnAgregar .setIcon(new ImageIcon(img3));
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 20));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnAgregar.setBounds(365, 48, 219, 73);
		contentPane.add(btnAgregar);
		
		JButton btnRegresar = new JButton("Regresar");
		Image img2= new ImageIcon(this.getClass().getResource("/imagen/espalda.png")).getImage();
		btnRegresar .setIcon(new ImageIcon(img2));
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 20));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EstacionamientoMenu esta =new EstacionamientoMenu();
				esta.show();
				dispose();
			}
		});
		btnRegresar.setBounds(32, 177, 245, 73);
		contentPane.add(btnRegresar);
		
		JButton btnAgregarLugar = new JButton("Agregar Lugar");
		Image img1= new ImageIcon(this.getClass().getResource("/imagen/marcador.png")).getImage();
		btnAgregarLugar .setIcon(new ImageIcon(img1));
		btnAgregarLugar.setFont(new Font("Arial", Font.BOLD, 20));
		btnAgregarLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Area area=new Area();
				area.show();
				dispose();
			}
		});
		btnAgregarLugar.setBounds(347, 177, 237, 73);
		contentPane.add(btnAgregarLugar);
		
	
	}//constructor
	
	/**
	 * Guardar.
	 */
	public void guardar(){
		
			if(cbAutos.getSelectedItem()=="Seleccione un auto" || 
					cbPersonas.getSelectedItem()=="Seleccione al dueño" ||
					cbLugar.getSelectedItem() =="Seleccione un Lugar") {

				JOptionPane.showMessageDialog(null, "Uno de los capos no fue seleccionado");
				}else{
					/**
					 * En esta parte se implemento el patron de diseño Decorator 
					 * para poder utilizar una solo clase y uzar funcionalidadez dinamicamente
					 *  
					 */
					Estacionamiento esta = new DecoratorEntrada(new ConcreteEstacionamiento());
					esta.setIdPersona((Integer)cbPersonas.getSelectedItem());
					esta.setIdAuto((Integer)cbAutos.getSelectedItem());
					esta.setIdEstacionamiento((Integer) cbLugar.getSelectedItem());
					esta.setCosto(validarCostos());
					
					
					if(esta.agregar()){
						
						JOptionPane.showMessageDialog(null, "Agregado correctamente, cobrar: "+costo+"");
						limpiar();
						tiket=new ReportesDAO();
						try {tiket.generarTicket();} catch (JRException e) {e.printStackTrace();}
						
				}else {
					JOptionPane.showMessageDialog(null, "No se ha podido guardar","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		
		
	}
	
	/**
	 * Buscar autos.
	 * metodo para encontrar todos los ids utilizando el patron de diseño iterator
	 */
	private void buscarAutos() {
		AgregadoConcretoAuto agre=new AgregadoConcretoAuto();
		Iterator iterator=agre.getIterator();
		while(iterator.hayMas()){
			AutoDAO au= (AutoDAO) iterator.siguiente();
			cbAutos.addItem(au.getIdauto());
		}
		
	}

	/**
	 * Buscar personas.
	 * metodo para encontrar todos los ids utilizando el patron de diseño iterator
	 */
	private void buscarPersonas() {
		AgregadoConcretoPersona agre=new AgregadoConcretoPersona();
		Iterator iterator=agre.getIterator();
		while(iterator.hayMas()){
			PersonaDAO per= (PersonaDAO) iterator.siguiente();
			cbPersonas.addItem(per.getIdpersona());
		}
		
		
	}
	
	/**
	 * Buscar area.
	 * 
	 * metodo para encontrar todos los ids utilizando el patron de diseño iterator
	 */
	private void buscarArea() {
		AgregadoConcretoArea agre=new AgregadoConcretoArea();
		Iterator iterator=agre.getIterator();
		while(iterator.hayMas()){
			AreaDAO per= (AreaDAO) iterator.siguiente();
			switch (per.getEstatus()) {
			case "vacio":
				cbLugar.addItem(per.getIdEestacionamiento());
				break;
			}	
		}	
	}
	
	/**
	 * Validar costos.
	 *
	 * @return the int
	 * metodo para obtener los costos
	 */
	public int validarCostos() {
		int precio=0;
		int sel=(Integer) cbAutos.getSelectedItem();
		AutoDAO auto=new AutoDAO();
		switch (auto.tipoAuto(sel)) {
		case "Sedán":
			precio=26;
			costo=precio;
			break;
	
		case "Pick Up":
			precio =50;
			costo=precio;
			break;
		}
		
		return precio;
	}
	
	/**
	 * Limpiar.
	 * metodo para obtener la fecha
	 */
	public void limpiar() {
		cbAutos.removeAllItems();
		cbPersonas.removeAllItems();
		cbLugar.removeAllItems();
		cbAutos.addItem("Seleccione un auto");
		cbPersonas.addItem("Seleccione al dueño");
		cbLugar.addItem("Seleccione un Lugar");
		buscarArea();
		buscarAutos();
		buscarPersonas();
		cbAutos.setSelectedItem("Seleccione un auto");
		cbPersonas.setSelectedItem("Seleccione al dueño");
		cbLugar.setSelectedItem("Seleccione un Lugar");
		
		
	}
}
