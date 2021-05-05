package view.estacionamiento;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.AreaDAO;
import DAO.Patrones.Iterator.Iterator;
import DAO.Patrones.Iterator.Area.AgregadoConcretoArea;
import InterfaceDAO.AgregarAreaInterface;
import InterfaceDAO.EliminarAreaInterface;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

/**
 * The Class Area.
 */
public class Area extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The table area. */
	private JTable tableArea;
	
	/** The txt piso. */
	private JTextField txtPiso;
	
	/** The rb grupo. */
	private ButtonGroup rbGrupo;
	
	/** The btn regresar. */
	private JButton btnAgregar,btnRegresar;
	
	/** The rdbtn chico. */
	private JRadioButton rdbtnGrande,rdbtnChico;
	
	/** The altura. */
	private double altura;
	
	/** The id area. */
	private int idArea;
	
	/** The lbl seleccione una fila. */
	private JLabel lblSeleccioneUnaFila;
	
	/**
	 * Create the frame.
	 */
	public Area() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTamao = new JLabel("Tama\u00F1o:");
		lblTamao.setFont(new Font("Arial", Font.BOLD, 19));
		lblTamao.setBounds(223, 64, 109, 16);
		contentPane.add(lblTamao);
		
		JLabel lblLugar = new JLabel("Piso:");
		lblLugar.setFont(new Font("Arial", Font.BOLD, 19));
		lblLugar.setBounds(252, 117, 56, 16);
		contentPane.add(lblLugar);
		
		btnAgregar = new JButton("Agregar");
		Image img1= new ImageIcon(this.getClass().getResource("/imagen/marcador.png")).getImage();
		btnAgregar .setIcon(new ImageIcon(img1));
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 20));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarArea();
			}
		});
		btnAgregar.setBounds(479, 101, 183, 73);
		contentPane.add(btnAgregar);
		
		btnRegresar = new JButton("Regresar");
		Image img2= new ImageIcon(this.getClass().getResource("/imagen/espalda.png")).getImage();
		btnRegresar .setIcon(new ImageIcon(img2));
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 20));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entrada entra =new Entrada();
				entra.show();
				dispose();
			}
		});
		btnRegresar.setBounds(12, 101, 194, 73);
		contentPane.add(btnRegresar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 212, 650, 187);
		contentPane.add(scrollPane);
		
		tableArea = new JTable();
		tableArea.setBounds(79, 179, 1, 1);
		tableArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel miTabla = (DefaultTableModel) tableArea.getModel();
				int filaSeleccionada = tableArea.getSelectedRow();

				idArea=(int) miTabla.getValueAt(filaSeleccionada, 0);	
				eliminarArea();
			}
			
		});
		
		tableArea.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "tamano", "altura","Estatus", "piso"
				}
			));
		scrollPane.setViewportView(tableArea);

		rdbtnGrande = new JRadioButton("Grande");
		rdbtnGrande.setFont(new Font("Arial", Font.BOLD, 19));
		rdbtnGrande.setBounds(433, 60, 109, 25);
		contentPane.add(rdbtnGrande);
		
		rdbtnChico = new JRadioButton("Chico");
		rdbtnChico.setFont(new Font("Arial", Font.BOLD, 19));
		rdbtnChico.setBounds(318, 60, 97, 25);
		contentPane.add(rdbtnChico);
		
		
		rbGrupo = new ButtonGroup();
		rbGrupo.add(rdbtnGrande);
		rbGrupo.add(rdbtnChico);
		
		txtPiso = new JTextField();
		txtPiso.setFont(new Font("Arial", Font.BOLD, 19));
		txtPiso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validacioSoloNumeros(e);
			}
		});
		txtPiso.setBounds(318, 111, 116, 30);
		contentPane.add(txtPiso);
		txtPiso.setColumns(10);
		
		lblSeleccioneUnaFila = new JLabel("Seleccione una columna de la tabla para eliminar una Area de Estacionamiento");
		lblSeleccioneUnaFila.setFont(new Font("Arial", Font.BOLD, 17));
		lblSeleccioneUnaFila.setBounds(12, 183, 639, 16);
		contentPane.add(lblSeleccioneUnaFila);
		
JLabel lblAgregeUnLugar = new JLabel("Agrege un lugar de estacionamiento");
		
		lblAgregeUnLugar.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblAgregeUnLugar.setBounds(168, 11, 374, 30);
		contentPane.add(lblAgregeUnLugar);
		
		buscarTodos();
	}//constructor
	
	/**
	 * Guardar area.
	 * Metodo para guardar el contenido y guardarlo en el objeto AutoDao*/
	public void guardarArea(){
		/*
		 * Se implemento un lambda de tipo PREDICADO
		 * el cual tiene como parametro la referencia de objeto 
		 * y hace una operacion logica con el metodo de el objeto referenciado 
		 */
		final AgregarAreaInterface auto =  x ->  x.getAgregar().gestionar() == true;
		if(validacionForm()){
			if(validarRB()) {
				/*
				 * en este if se utiliza el metodo de la interface AgregarAreaInterface para 
				 * utilizar la operacion logica implementada en el lambda
				 */
				if(auto.agregarArea(new AreaDAO(selectRB(),altura,Integer.parseInt(txtPiso.getText())))){
					JOptionPane.showMessageDialog(null, "Agregado correctamente");
					limpiarForm();
				}else{
					JOptionPane.showMessageDialog(null, "No se ha podido guardar","Error",JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Completa campos", "Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}else{
			JOptionPane.showMessageDialog(null, "Completa campos", "Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	/**
	 * Eliminar area.
	 */
	public void eliminarArea() {
		/*
		 * Se implemento un lambda de tipo FUNCION
		 * el cual, tiene como parametro una referencia a un objeto y un numero que representa un ID
		 * 
		 */
		EliminarAreaInterface eliminar = (x, y) -> {
			x.setIdEestacionamiento(y);return x.getAgregar().gestionar();};
		int elimidado=JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminarlo?");
		if(elimidado==0){
			if(eliminar.elimiunarArea(new AreaDAO(), idArea)){
				/*
				 * la variable eliminar utiliza el metodo elimiunarArea que paso como parametro un 
				 * objeto y una variable id, el cual retornara un valor voleano que es un metodo 
				 * del objeto AreaDao
				 */
				JOptionPane.showMessageDialog(null, "Eliminado");
				limpiarForm();
			}else {
				JOptionPane.showMessageDialog(null, "No se ha podido elimianr","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Buscar todos.
	 * metodo para encontrar todos los elementos utilizando el patron de diseño iterator
	 */
	private void buscarTodos() {
		DefaultTableModel miModel=(DefaultTableModel) tableArea.getModel();
		AgregadoConcretoArea agre=new AgregadoConcretoArea();
		Iterator iterator=agre.getIterator();
		
		while(iterator.hayMas()){
			AreaDAO ar= (AreaDAO) iterator.siguiente();
			Object obj[] = new Object[5];
			obj[0]=ar.getIdEestacionamiento();
			obj[1]=ar.getTamano();
			obj[2]=ar.getAltura();
			obj[3]=ar.getEstatus();
			obj[4]=ar.getPiso();
			miModel.addRow(obj);
		}
	}
	
	/**
	 * Validacion form.
	 *
	 * @return true, if successful
	 */
	private boolean validacionForm() {
		boolean correcto=false;
		if(!txtPiso.getText().isEmpty())
			correcto=true;
		return correcto;
	}
	
	/**
	 * Limpiar form.
	 */
	private void limpiarForm() {
		rbGrupo.clearSelection();
		txtPiso.setText("");
		limpiarTabla();
		buscarTodos();
		
	}
	
	/**
	 * Validar RB.
	 *
	 * @return true, if successful
	 */
	private boolean validarRB() {
		boolean validar = true;
		if(!rdbtnGrande.isSelected() && !rdbtnChico.isSelected()) {
			validar=false;
		}
		return validar;
	}
	
	/**
	 * Limpiar tabla.
	 * metodo que limpia la tabla
	 */
	public void limpiarTabla() {
		DefaultTableModel temp = (DefaultTableModel) tableArea.getModel();
        temp.setRowCount(0);
	}
	
	/**
	 * Select RB.
	 * este metodo sirve para cuando uno de los RadioButtons este seleccionado estos manden el tipo de auto
	 * Utilizado por el metodo Guardar
	 * @return the string
	 */
	public String selectRB() {
		String tipo="";
		if(rdbtnGrande.isSelected()) {
			tipo="Grande";
			altura=2.52;
		}else if(rdbtnChico.isSelected()) {
			tipo="Chico";
			altura=2;
		}
		return tipo;
	}
	
	/**
 * Validacio solo numeros.
 *
 * @param e the e
 */
private void validacioSoloNumeros(KeyEvent e) {
		char caracter = e.getKeyChar();
	      // Verificar si la tecla pulsada no es un digito
	      if(((caracter < '0') || (caracter > '9'))&&(caracter != '\b' /*corresponde a BACK_SPACE*/)){
	         e.consume();  // ignorar el evento de teclado
	      }
	}
}//class
