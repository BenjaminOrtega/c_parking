package view.estacionamiento;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.Patrones.Decorator.ConcreteEstacionamiento;
import DAO.Patrones.Decorator.DecoratorSalir;
import DAO.Patrones.Decorator.Estacionamiento;
import DAO.Patrones.Iterator.Iterator;
import DAO.Patrones.Iterator.Estacionamiento.AgregadoConcretoEstacionamiento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The Class Salida.
 */
public class Salida extends JFrame {
	private JLabel label;

	/** The content pane. */
	private JPanel contentPane;
	
	/** The tabla salida. */
	private JTable tablaSalida;
	
	/** The lbl numero. */
	private JLabel lblNumero;
	
	/** The lbl mensaje. */
	private JLabel lblMensaje;
	
	/** The btn registrar salida. */
	private JButton btnRegistrarSalida;
	
	/** The btn cancelar. */
	private JButton btnCancelar;
	
	/** The id registro. 
	 * variables que se usan para guardar los ids y pasarlos por parametro
	 * */
	private int idEstacionamiento,idRegistro;
	
	/** The btn regresar. */
	private JButton btnRegresar;

	/**
	 * Create the frame.
	 */
	public Salida() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMensaje = new JLabel("Selecciona un registro");
		lblMensaje.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblMensaje.setBounds(346, 11, 251, 25);
		contentPane.add(lblMensaje);
		
		lblNumero = new JLabel("N\u00B0");
		lblNumero.setForeground(Color.BLACK);
		lblNumero.setFont(new Font("Arial", Font.BOLD, 67));
		lblNumero.setBounds(139, 137, 80, 81);
		contentPane.add(lblNumero);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(262, 100, 539, 187);
		contentPane.add(scrollPane);
		
		tablaSalida = new JTable();
		tablaSalida.setBounds(65, 339, 370, -107);	tablaSalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel miTabla = (DefaultTableModel) tablaSalida.getModel();
				int filaSeleccionada = tablaSalida.getSelectedRow();
				lblMensaje.setText("Numero de Registro");
				
				idRegistro=(int) miTabla.getValueAt(filaSeleccionada, 0);
				idEstacionamiento=(int) miTabla.getValueAt(filaSeleccionada, 3);
				lblNumero.setText(""+idRegistro+"");
				super.mouseClicked(e);
				btnRegistrarSalida.setEnabled(true);
				btnCancelar.setEnabled(true);
				btnRegresar.setEnabled(false);
				
			}
			
		});
		
		tablaSalida.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id id_registro", "id_persona", "id_auto", "id_estacionamiento", "costo"
				}
			));
		scrollPane.setViewportView(tablaSalida);
		
		btnRegistrarSalida = new JButton("Registrar Salida");
		Image img5= new ImageIcon(this.getClass().getResource("/imagen/tarea.png")).getImage();
		btnRegistrarSalida .setIcon(new ImageIcon(img5));
		btnRegistrarSalida.setFont(new Font("Arial", Font.BOLD, 19));
		btnRegistrarSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		btnRegistrarSalida.setEnabled(false);
		btnRegistrarSalida.setBounds(262, 47, 215, 34);
		contentPane.add(btnRegistrarSalida);
		
		btnCancelar = new JButton("Cancelar");
		Image img3= new ImageIcon(this.getClass().getResource("/imagen/error.png")).getImage();
		btnCancelar .setIcon(new ImageIcon(img3));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 19));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancelar();
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(485, 47, 153, 34);
		contentPane.add(btnCancelar);
		
		btnRegresar = new JButton("Regresar");
		Image img2= new ImageIcon(this.getClass().getResource("/imagen/espalda(1).png")).getImage();
		btnRegresar .setIcon(new ImageIcon(img2));
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 19));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstacionamientoMenu es=new EstacionamientoMenu();
				es.show();
				dispose();
			}
		});
		btnRegresar.setBounds(648, 47, 153, 34);
		contentPane.add(btnRegresar);
		
		label = new JLabel("");
		Image img1= new ImageIcon(this.getClass().getResource("/imagen/id.png")).getImage();
		label .setIcon(new ImageIcon(img1));
		label.setBounds(0, 11, 282, 265);
		contentPane.add(label);
		
		buscarTodos();//metodo que muestra todos los registros, solo si no tienen fecha de salida
		
	}//constructor
	
	/**
	 * Guardar.
	 * Para guardar la salida se ocupo de el patron Decorator
	 * y poder utilizar dinamicamente el metodo agregar.
	 */
	public void guardar(){
		Estacionamiento esta =new DecoratorSalir(new ConcreteEstacionamiento());
		esta.setIdRegistro(idRegistro);
		esta.setIdEstacionamiento(idEstacionamiento);
		if(esta.agregar()){
			JOptionPane.showMessageDialog(null, "Salida registrada");
			Cancelar();
		}else{
			JOptionPane.showMessageDialog(null, "No se ha podido actualizar","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Buscar todos.
	 * metosdo para buscar objetos implementado el patron de diseño iterator
	 */
	private void buscarTodos() {
		DefaultTableModel miModel=(DefaultTableModel) tablaSalida.getModel();
		AgregadoConcretoEstacionamiento agre=new AgregadoConcretoEstacionamiento();
		//agre.llenar();
		Iterator iterator=agre.getIterator();
		while(iterator.hayMas()){
			Estacionamiento sal= (Estacionamiento) iterator.siguiente();
			Object obj[] = new Object[5];
			obj[0]=sal.getIdRegistro();
			obj[1]=sal.getIdPersona();
			obj[2]=sal.getIdAuto();
			obj[3]=sal.getIdEstacionamiento();
			obj[4]=sal.getCosto();
			if(sal.getFechaSalida()==null && sal.getHoraSalida()==null) {
				miModel.addRow(obj);
			}
			
			
		}
	}
	
	
	/**
	 * Cancelar.
	 * metodo que restaura el frame a su estado original
	 */
	private void Cancelar() {
		lblMensaje.setText("Selecciona un registro");
		lblNumero.setText("N°");
		btnRegistrarSalida.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnRegresar.setEnabled(true);
		limpiarTabla();
		buscarTodos();
	}
	
	/**
	 * Limpiar tabla.
	 * metodo que limpia la tabla
	 */
	public void limpiarTabla() {
		DefaultTableModel temp = (DefaultTableModel) tablaSalida.getModel();
        temp.setRowCount(0);
	}

	
}//class
