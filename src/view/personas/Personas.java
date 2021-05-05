package view.personas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.PersonaDAO;
import DAO.ReportesDAO;
import DAO.Patrones.Iterator.Iterator;
import DAO.Patrones.Iterator.Persona.AgregadoConcretoFiltroPersona;
import DAO.Patrones.Iterator.Persona.AgregadoConcretoPersona;
import net.sf.jasperreports.engine.JRException;
import view.Inicio;

import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class Personas.
 */
public class Personas extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The txt apellidos. */
	private JTextField txtNombre,txtDireccion,txtEmail,txtTelefono,txtApellidos;
	
	/** The txt id. */
	private String txtId;
	
	/** The btn cancelar. */
	private JButton btnGuardar,btnReportes,btnActualizar,btnEliminar,btnRegresar,btnCancelar;
	
	/** The tabla persona filtro. */
	private JTable tablePersona,tablaPersonaFiltro;
	
	/** The inicio. */
	private Inicio inicio;
	
	/** The rb filtro. */
	private JRadioButton rbFiltro;
	
	/** The scroll pane. */
	private JScrollPane scrollPane;
	
	/** The reportes. */
	private ReportesDAO reportes= new ReportesDAO();



	/**
	 * Instantiates a new personas.
	 */
	public Personas() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(53, 30, 92, 24);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {		         
				 validacionSoloLetras(arg0);
			}
		});
		txtNombre.setBounds(144, 26, 280, 33);
		txtNombre.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n ");
		lblDireccion.setBounds(38, 118, 107, 20);
		lblDireccion.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(lblDireccion);
		
		JLabel lblEmail = new JLabel("Correo:");
		lblEmail.setBounds(62, 162, 81, 26);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(42, 210, 92, 14);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(lblTelefono);
		
		btnReportes = new JButton("Reporte");
		btnReportes.setBounds(10, 250, 156, 44);
		Image img6= new ImageIcon(this.getClass().getResource("/imagen/pdf.png")).getImage();
		btnReportes.setIcon(new ImageIcon(img6));
		btnReportes.setFont(new Font("Arial", Font.BOLD, 19));
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbFiltro.isSelected()) {
					try {
						reportes.BuscarFiltroPersona();
					} catch (JRException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					try {
						reportes.BuscarPersonas();
					} catch (JRException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		btnReportes.setVisible(true);
		panel.add(btnReportes);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(144, 112, 280, 33);
		txtDireccion.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(144, 159, 280, 33);
		txtEmail.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validacionSoloNumeros(e);
			}
		});
		txtTelefono.setBounds(144, 203, 280, 33);
		txtTelefono.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(447, 22, 164, 41);
		Image img1= new ImageIcon(this.getClass().getResource("/imagen/disco.png")).getImage();
		btnGuardar .setIcon(new ImageIcon(img1));
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 19));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		panel.add(btnGuardar);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(42, 70, 100, 28);
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				validacionSoloLetras(e);
			}
		});
		txtApellidos.setBounds(144, 70, 280, 31);
		txtApellidos.setFont(new Font("Arial", Font.BOLD, 19));
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		
		
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(447, 126, 164, 41);
		Image img2= new ImageIcon(this.getClass().getResource("/imagen/goma.png")).getImage();
		btnEliminar .setIcon(new ImageIcon(img2));
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 19));
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			eliminar();
			}
		});
		panel.add(btnEliminar);
		
		
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(447, 74, 164, 41);
		Image img3= new ImageIcon(this.getClass().getResource("/imagen/intercambio.png")).getImage();
		btnActualizar.setIcon(new ImageIcon(img3));
		btnActualizar.setFont(new Font("Arial", Font.BOLD, 19));
		btnActualizar.setEnabled(false);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizar();
			}
		});
		panel.add(btnActualizar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 305, 687, 139);
		panel.add(scrollPane);
		
		tablePersona = new JTable();
		tablePersona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel miTabla = (DefaultTableModel) tablePersona.getModel();
				int filaSeleccionada = tablePersona.getSelectedRow();
				txtId=(miTabla.getValueAt(filaSeleccionada, 0) + "");
				txtNombre.setText(miTabla.getValueAt(filaSeleccionada, 1) + "");
				txtApellidos.setText(miTabla.getValueAt(filaSeleccionada, 2) + "");
				txtDireccion.setText(miTabla.getValueAt(filaSeleccionada, 3) + "");
				txtTelefono.setText(miTabla.getValueAt(filaSeleccionada, 4) + "");
				txtEmail.setText(miTabla.getValueAt(filaSeleccionada, 5) + "");
				/**
				 * TALVEZ AQUI IRIA LA DESAPARICION DEL BOTON CHECAR
				 * */
				btnGuardar.setEnabled(false);
				btnActualizar.setEnabled(true);
				btnEliminar.setEnabled(true);
				btnCancelar.setEnabled(true);
				btnRegresar.setEnabled(false);
				btnReportes.setEnabled(false);
				rbFiltro.setEnabled(false);
			}
		});
		tablePersona.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Persona", "Nombre", "Apellidos", "Direcci\u00F3n", "Tel\u00E9fono", "Email"
			}
		));
		scrollPane.setViewportView(tablePersona);
		
		tablaPersonaFiltro = new JTable();
		tablaPersonaFiltro.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Frecuencia", "Id persona", "nombre", "email"
				}
			));
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(533, 250, 164, 44);
		Image img4= new ImageIcon(this.getClass().getResource("/imagen/espalda(1).png")).getImage();
		btnRegresar .setIcon(new ImageIcon(img4));
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 19));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 inicio = new Inicio();
				inicio.setVisible(true);
				dispose();
			}
		});
		panel.add(btnRegresar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(447, 178, 164, 41);
		Image img5= new ImageIcon(this.getClass().getResource("/imagen/error.png")).getImage();
		btnCancelar .setIcon(new ImageIcon(img5));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 19));
		btnCancelar.setEnabled(false);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limpiarForm();
			}
		});
		panel.add(btnCancelar);
		
		rbFiltro = new JRadioButton("Ver usuarios m\u00E1s frecuentes");
		rbFiltro.setBounds(199, 260, 308, 25);
		rbFiltro.setFont(new Font("Arial", Font.BOLD, 19));
		rbFiltro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (rbFiltro.isSelected()) {
					scrollPane.setViewportView(tablaPersonaFiltro);
					desavilitarForm();
				}else {
					limpiarForm();
				}
				
				
			}
		});
		
		panel.add(rbFiltro);		
		buscarTodos();
	}//Contructor
	
	
	/**
	 * Guardar.
	 */
	public void guardar(){
		if(validacionForm()){
			PersonaDAO pers=new PersonaDAO (txtNombre.getText(),txtApellidos.getText(),txtTelefono.getText(),txtDireccion.getText(),txtEmail.getText());
			if(pers.getAgregar().gestionar()){
				JOptionPane.showMessageDialog(null, "Se Agrego correctamente");
				limpiarForm();
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido agregar","Error",JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Completa campos Falatantes", "Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	
	/**
	 * Eliminar.
	 */
	public void eliminar(){
		int elimidado=JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminarlo?");
		if(elimidado==0){
			PersonaDAO pso=new PersonaDAO();
			pso.setIdpersona(Integer.parseInt(txtId));
			if(pso.getEliminar().gestionar()){
				JOptionPane.showMessageDialog(null, "Se a Eliminado con exito");
				limpiarForm();
	
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo elimianar","Error",JOptionPane.ERROR_MESSAGE);

			}
		}
	}
	
	/**
	 * Actualizar.
	 */
	public void actualizar(){
		if(validacionForm()){
			PersonaDAO pss=new PersonaDAO(Integer.parseInt(txtId),txtNombre.getText(),txtApellidos.getText(),txtTelefono.getText(),txtDireccion.getText(),txtEmail.getText());
			if(pss.getActualizar().gestionar()){
				JOptionPane.showMessageDialog(null, "Se actualizo correctamente");
				limpiarForm();
			}else{
				JOptionPane.showMessageDialog(null, "No se pudo actualizar","Error",JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Completa campos Faltantes", "Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	/**
	 * Buscar todos.
	 */
	public void buscarTodos(){
		DefaultTableModel miModel=(DefaultTableModel) tablePersona.getModel();
		AgregadoConcretoPersona agre=new AgregadoConcretoPersona();
		Iterator iterator=agre.getIterator();
		while(iterator.hayMas()){
			PersonaDAO per= (PersonaDAO) iterator.siguiente();
			Object[] obj=new Object[6];
			obj[0]=per.getIdpersona();
			obj[1]=per.getNombre();
			obj[2]=per.getApellidos();
			obj[3]=per.getDireccion();
			obj[4]=per.getTelefono();
			obj[5]=per.getEmail();
			miModel.addRow(obj);
			
		}
		
		
	}
	
	/**
	 * Buscar persona.
	 */
	private void buscarPersona() {
		DefaultTableModel miModel=(DefaultTableModel) tablaPersonaFiltro.getModel();
		AgregadoConcretoFiltroPersona agre=new AgregadoConcretoFiltroPersona();
		Iterator iterator=agre.getIterator();
		while(iterator.hayMas()){
			PersonaDAO au= (PersonaDAO) iterator.siguiente();
			Object obj[] = new Object[4];
			obj[0]=au.getFrecuencia();
			obj[1]=au.getIdpersona();
			obj[2]=au.getNombre();
			obj[3]=au.getEmail();
			miModel.addRow(obj);
			
		}
	}
	
	/**
	 * validacion de los campos.
	 *
	 * @return true, if successful
	 */
	public boolean validacionForm(){
		boolean correcto=false;
		if(!txtApellidos.getText().isEmpty() &&!txtNombre.getText().isEmpty()&& !txtTelefono.getText().isEmpty()&&!txtDireccion.getText().isEmpty()&& !txtEmail.getText().isEmpty())
			correcto=true;
		return correcto;
	}
	
	
	/**
	 * metodo para limpiar.
	 */
	public void limpiarForm(){
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
		txtNombre.setEnabled(true);
		txtApellidos.setEnabled(true);
		txtDireccion.setEnabled(true);
		txtTelefono.setEnabled(true);
		txtEmail.setEnabled(true);
		btnActualizar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(false);
		btnRegresar.setEnabled(true);
		btnReportes.setVisible(true);
		rbFiltro.setSelected(false);
		rbFiltro.setEnabled(true);
		btnReportes.setEnabled(true);
		limpiarTablas();
		buscarTodos();
		scrollPane.setViewportView(tablePersona);
	}
	
	
	/**
	 * Desavilitar form.
	 */
	public void desavilitarForm() {
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
		txtNombre.setEnabled(false);
		txtApellidos.setEnabled(false);
		txtDireccion.setEnabled(false);
		txtTelefono.setEnabled(false);
		txtEmail.setEnabled(false);
		btnActualizar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnRegresar.setEnabled(true);
		btnReportes.setVisible(true);
		limpiarTablas();
		buscarPersona();
	}
	
	/**
	 * Limpiar tablas.
	 */
	public void limpiarTablas() {
		DefaultTableModel model = (DefaultTableModel) tablePersona.getModel();
		DefaultTableModel model1 = (DefaultTableModel) tablaPersonaFiltro.getModel();
		model.setRowCount(0);
		model1.setRowCount(0);
	}
	
	/**
	 * Validacion solo letras.
	 *
	 * @param e the e
	 */
	private void validacionSoloLetras(KeyEvent e) {
		char caracter = e.getKeyChar();
	      // Verificar si la tecla pulsada no es un digito
	      if(((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') ||
			  (caracter > 'Z')) &&(caracter != '\b' /*corresponde a BACK_SPACE*/)){
	         e.consume();  // ignorar el evento de teclado
	      }
	}
	
	/**
	 * Validacion solo numeros.
	 *
	 * @param e the e
	 */
	private void validacionSoloNumeros(KeyEvent e) {
		char caracter = e.getKeyChar();
	      // Verificar si la tecla pulsada no es un digito
	      if(((caracter < '0') || (caracter > '9'))&&(caracter != '\b' /*corresponde a BACK_SPACE*/)){
	         e.consume();  // ignorar el evento de teclado
	      }
	}
}