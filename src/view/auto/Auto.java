package view.auto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.AutoDAO;
import DAO.ReportesDAO;
import DAO.Patrones.Iterator.Iterator;
import DAO.Patrones.Iterator.Auto.AgregadoConcretoAuto;
import DAO.Patrones.Iterator.Auto.AgregadoConcretoFiltroAuto;
import net.sf.jasperreports.engine.JRException;
import view.Inicio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The Class Auto.
 * Esta es una clase que genera una vista y poder gestionar la tabla Autos de un base de datos
 */
public class Auto extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The txt modelo. */
	private JTextField txtMarca,txtNplacas,txtColor,txtModelo;
	
	/** The tabla filtro autos. */
	private JTable tablaAutos,tablaFiltroAutos;
	
	/** The txt observacines. */
	private JTextArea txtObservacines;
	
	/** The rb grupo. */
	private ButtonGroup rbGrupo;
	
	/** The rb filtro auto. */
	private JRadioButton rbSedan,rbPickUp,rbFiltroAuto;
	
	/** The btn reporte. */
	private JButton btnActualizar,btnGusrdar,btnEliminar,btnCanselar,btnRegresar,btnReporte;
	
	/** The Id auto. 
	 * variable que gurada el id para Eliminar o actualizar*/
	private int IdAuto;
	
	/** The inicio. */
	private Inicio inicio;
	
	/** The scroll pane. */
	private JScrollPane scrollPane;
	
	/** The reporte. */
	private ReportesDAO reporte=new ReportesDAO();
	
	/**
	 * Instantiates a new auto.
	 */
	public Auto() {
		setTitle("Autos");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEduardo = new JLabel("N\u00B0 placa: ");
		lblEduardo.setFont(new Font("Arial", Font.BOLD, 19));
		lblEduardo.setBounds(10, 22, 97, 21);
		contentPane.add(lblEduardo);
			
		rbSedan = new JRadioButton("Sedán");
		rbSedan.setFont(new Font("Arial", Font.BOLD, 19));
		rbSedan.setBounds(435, 20, 97, 25);
		contentPane.add(rbSedan);
		
		rbPickUp = new JRadioButton("Pick Up");
		rbPickUp.setFont(new Font("Arial", Font.BOLD, 19));
		rbPickUp.setBounds(551, 20, 113, 25);
		contentPane.add(rbPickUp);
		
		//grupo de raiobuttons
		rbGrupo = new ButtonGroup();
		rbGrupo.add(rbSedan);
		rbGrupo.add(rbPickUp);
		
		JLabel lblColor = new JLabel("Color: ");
		lblColor.setFont(new Font("Arial", Font.BOLD, 19));
		lblColor.setBounds(29, 70, 68, 22);
		contentPane.add(lblColor);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Arial", Font.BOLD, 19));
		lblMarca.setBounds(20, 107, 75, 28);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Arial", Font.BOLD, 19));
		lblModelo.setBounds(10, 152, 85, 19);
		contentPane.add(lblModelo);
		
		JLabel lblTipoDeAutomovil = new JLabel("Tipo de Automovil:");
		lblTipoDeAutomovil.setFont(new Font("Arial", Font.BOLD, 19));
		lblTipoDeAutomovil.setBounds(249, 24, 180, 16);
		contentPane.add(lblTipoDeAutomovil);
		
		JLabel lblObservacines = new JLabel("Observaci\u00F3nes:");
		lblObservacines.setFont(new Font("Arial", Font.BOLD, 19));
		lblObservacines.setBounds(271, 50, 158, 22);
		contentPane.add(lblObservacines);
		
		txtObservacines = new JTextArea();
		txtObservacines.setBackground(Color.WHITE);
		txtObservacines.setFont(new Font("Arial", Font.BOLD, 19));
		txtObservacines.setBounds(435, 48, 351, 127);
		//contentPane.add(txtObservacines);
		
		txtNplacas = new JTextField();
		txtNplacas.setFont(new Font("Arial", Font.BOLD, 19));
		txtNplacas.setBounds(105, 20, 116, 29);
		contentPane.add(txtNplacas);
		txtNplacas.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Arial", Font.BOLD, 19));
		txtMarca.setBounds(105, 107, 116, 29);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setFont(new Font("Arial", Font.BOLD, 19));
		txtColor.setBounds(105, 67, 116, 29);
		contentPane.add(txtColor);
		txtColor.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Arial", Font.BOLD, 19));
		txtModelo.setBounds(105, 147, 116, 28);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		//boton GUARDAR
		
		btnGusrdar = new JButton("Guardar");
		Image img3= new ImageIcon(this.getClass().getResource("/imagen/disco.png")).getImage();
		btnGusrdar .setIcon(new ImageIcon(img3));
		btnGusrdar.setFont(new Font("Arial", Font.BOLD, 19));
		btnGusrdar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGusrdar.setBounds(10, 196, 158, 45);
		contentPane.add(btnGusrdar);
		
		//boton ACTUALIZAR
		btnActualizar = new JButton("Actualizar");
		Image img4= new ImageIcon(this.getClass().getResource("/imagen/intercambio.png")).getImage();
		btnActualizar .setIcon(new ImageIcon(img4));
		btnActualizar.setFont(new Font("Arial", Font.BOLD, 19));
		btnActualizar.setEnabled(false);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Actualizar();
			}
		});
		btnActualizar.setBounds(216, 196, 180, 45);
		contentPane.add(btnActualizar);
		
		//boton ELIMINAR
		btnEliminar = new JButton("Eliminar");
		btnEliminar = new JButton("Eliminar");
		Image img5= new ImageIcon(this.getClass().getResource("/imagen/goma.png")).getImage();
		btnEliminar .setIcon(new ImageIcon(img5));
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 19));
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar();
			}
		});
		btnEliminar.setBounds(432, 196, 158, 45);
		contentPane.add(btnEliminar);
		
		//boton CANSELAR
		btnCanselar = new JButton("Cancelar");
		Image img2= new ImageIcon(this.getClass().getResource("/imagen/error.png")).getImage();
		btnCanselar .setIcon(new ImageIcon(img2));
		btnCanselar.setFont(new Font("Arial", Font.BOLD, 19));
		btnCanselar.setEnabled(false);
		btnCanselar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarForm();
			}
		});
		btnCanselar.setBounds(625, 196, 151, 45);
		contentPane.add(btnCanselar);
		
		//boton de REGRESAR
		btnRegresar = new JButton("Regresar");
		Image img1= new ImageIcon(this.getClass().getResource("/imagen/espalda(1).png")).getImage();
		btnRegresar .setIcon(new ImageIcon(img1));
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 19));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicio=new Inicio();
				inicio.setVisible(true);
				dispose();
			}
		});
		btnRegresar.setBounds(613, 454, 173, 43);
		contentPane.add(btnRegresar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 256, 776, 187);
		contentPane.add(scrollPane);
		
		/*
		 * Scroll para el Panel de texto
		 */
		JScrollPane scrollTxt = new JScrollPane();
		scrollTxt.setBounds(30, 310, 655, 187);
		contentPane.add(txtObservacines);
		
		//tabla
		tablaAutos = new JTable();
		tablaAutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel miTabla = (DefaultTableModel) tablaAutos.getModel();
				int filaSeleccionada = tablaAutos.getSelectedRow();
				
				IdAuto=(int) miTabla.getValueAt(filaSeleccionada, 0);
				txtNplacas.setText(miTabla.getValueAt(filaSeleccionada, 1) + "");
				txtMarca.setText(miTabla.getValueAt(filaSeleccionada, 2) + "");
				txtColor.setText(miTabla.getValueAt(filaSeleccionada, 3) + "");
				txtModelo.setText(miTabla.getValueAt(filaSeleccionada, 4) + "");
				String rb= miTabla.getValueAt(filaSeleccionada, 5)+"";
				getInfoRB(rb);
				txtObservacines.setText(miTabla.getValueAt(filaSeleccionada, 6) + "");
				super.mouseClicked(e);
				btnCanselar.setEnabled(true);
				btnGusrdar.setEnabled(false);
				btnRegresar.setEnabled(false);
				btnActualizar.setEnabled(true);
				btnEliminar.setEnabled(true);
				btnReporte.setEnabled(false);
				rbFiltroAuto.setEnabled(false);
			}
			
		});
		
		tablaAutos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id Auto", "N° placa", "Marca", "Color", "Modelo", "Tipo","Observaciones"
				}
			));
		scrollPane.setViewportView(tablaAutos);
		
		tablaFiltroAutos = new JTable();
		tablaFiltroAutos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Frecuencia", "N° placas", "Marca", "Modelo","Tipo"
				}
			));
		
		rbFiltroAuto = new JRadioButton("Ver Frecuencia de autos");
		rbFiltroAuto.setFont(new Font("Arial", Font.BOLD, 19));
		rbFiltroAuto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rbFiltroAuto.isSelected()) {
					buscarFiltro();
					desavilitarForm();
					scrollPane.setViewportView(tablaFiltroAutos);
				}else {
					limpiarForm();
				}
			
			}
		});
		rbFiltroAuto.setBounds(286, 463, 272, 25);
		contentPane.add(rbFiltroAuto);
		
		btnReporte = new JButton("Reporte");
		Image img6= new ImageIcon(this.getClass().getResource("/imagen/pdf.png")).getImage();
		btnReporte .setIcon(new ImageIcon(img6));
		btnReporte.setFont(new Font("Arial", Font.BOLD, 19));
		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbFiltroAuto.isSelected()) {
					
					try {
						reporte.buscarFiltroAuto();
					} catch (JRException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					try {
						reporte.buscarAutos();
					} catch (JRException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		});
		btnReporte.setBounds(39, 454, 182, 43);
		contentPane.add(btnReporte);

		buscarTodos();
		
	}//constructor
	
	
	/**
	 * Guardar.
	 * Metodo para guardar el contenido y guardarlo en el objeto AutoDao*/
	public void guardar(){
		if(validacionForm()){
			if(validarRB()) {
				AutoDAO auto=new AutoDAO(txtNplacas.getText(),txtColor.getText(),txtMarca.getText(),selectRB(),txtModelo.getText(),txtObservacines.getText());
				if(auto.getAgregar().gestionar()){
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
	 * Actualizar.
	 * Metodo para actualizar el contenido y guardarlo en el objeto AutoDao
	 */
	public void Actualizar() {
		if(validacionForm()){
			AutoDAO auto=new AutoDAO(IdAuto,txtNplacas.getText(),txtColor.getText(),txtMarca.getText(),selectRB(),txtModelo.getText(),txtObservacines.getText());
			if(auto.getActualizar().gestionar()){
				JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente");
				limpiarForm();
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido actualizar","Error",JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Completa campos", "Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * Eliminar.
	 * Metodo para elimianr el contenido 
	 */
	public void Eliminar() {
		int elimidado=JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminarlo?");
		if(elimidado==0){
			AutoDAO auto=new AutoDAO();
			auto.setIdauto(IdAuto);
			if(auto.getEliminar().gestionar()){
				JOptionPane.showMessageDialog(null, "Eliminado");
				limpiarForm();
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido elimianr","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * Validacion form.
	 *	validacion de las cajas de texto
	 * @return true, if successful
	 */
	public boolean validacionForm(){
		boolean correcto=false;
		if(!txtNplacas.getText().isEmpty() &&!txtColor.getText().isEmpty()&& 
				!txtMarca.getText().isEmpty()&&!txtModelo.getText().isEmpty()
				&&!txtObservacines.getText().isEmpty())
			correcto=true;
		return correcto;
	}
	
	
	/**
	 * Limpiar form.
	 * metodo que sirve para limpiar los campos
	 */
	public void limpiarForm(){
		txtNplacas.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtObservacines.setText("");
		txtColor.setText("");
		txtNplacas.setEnabled(true);
		txtMarca.setEnabled(true);
		txtModelo.setEnabled(true);
		txtObservacines.setEnabled(true);
		txtColor.setEnabled(true);
		rbGrupo.clearSelection();
		rbPickUp.setEnabled(true);
		rbSedan.setEnabled(true);
		btnGusrdar.setEnabled(true);
		btnRegresar.setEnabled(true);
		btnCanselar.setEnabled(false);
		btnActualizar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnReporte.setVisible(true);
		rbFiltroAuto.setSelected(false);
		btnReporte.setEnabled(true);;
		rbFiltroAuto.setEnabled(true);;
		limpiarTablas();
		buscarTodos();
		scrollPane.setViewportView(tablaAutos);
	}
	
	/**
	 * Desavilitar form.
	 * Este metodo se utiliza para cuando se utilisa el radio button que genera los filtros
	 */
	public void desavilitarForm() {
		txtNplacas.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtObservacines.setText("");
		txtColor.setText("");
		txtNplacas.setEnabled(false);
		txtMarca.setEnabled(false);
		txtModelo.setEnabled(false);
		txtObservacines.setEnabled(false);
		txtColor.setEnabled(false);
		rbGrupo.clearSelection();
		rbPickUp.setEnabled(false);
		rbSedan.setEnabled(false);
		btnGusrdar.setEnabled(false);
		btnRegresar.setEnabled(true);
		btnCanselar.setEnabled(false);
		btnActualizar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnReporte.setVisible(true);
		limpiarTablas();
		buscarFiltro();
	}
	
	/**
	 * Limpiar tablas.
	 * metodo que limpia la tabla
	 */
	public void limpiarTablas() {
		DefaultTableModel temp = (DefaultTableModel) tablaAutos.getModel();
        DefaultTableModel temp1 = (DefaultTableModel) tablaFiltroAutos.getModel();
        temp.setRowCount(0);
        temp1.setRowCount(0);
	}
	
	
	/**
	 * Buscar todos.
	 * metodo para encontrar todos los elementos utilizando el patron de diseño iterator
	 */
	private void buscarTodos() {
		DefaultTableModel miModel=(DefaultTableModel) tablaAutos.getModel();
		AgregadoConcretoAuto agre=new AgregadoConcretoAuto();
		Iterator iterator=agre.getIterator();
		while(iterator.hayMas()){
			AutoDAO au= (AutoDAO) iterator.siguiente();
			Object obj[] = new Object[7];
			obj[0]=au.getIdauto();
			obj[1]=au.getNumeroPlacas();
			obj[2]=au.getMarca();
			obj[3]=au.getColor();
			obj[4]=au.getModelo();
			obj[5]=au.getTipo();
			obj[6]=au.getObservaciones();
			miModel.addRow(obj);
			
		}
		
	}
	
	/**
	 * Buscar filtro.
	 * metodo para encontrar todos los elementos filtrados, utilizando el patron de diseño iterator
	 */
	private void buscarFiltro() {
		DefaultTableModel miModel=(DefaultTableModel) tablaFiltroAutos.getModel();
		AgregadoConcretoFiltroAuto agre=new AgregadoConcretoFiltroAuto();
		Iterator iterator=agre.getIterator();
		while(iterator.hayMas()){
			AutoDAO au= (AutoDAO) iterator.siguiente();
			Object obj[] = new Object[5];
			obj[0]=au.getCantidad();
			obj[1]=au.getNumeroPlacas();
			obj[2]=au.getMarca();
			obj[3]=au.getModelo();
			obj[4]=au.getTipo();
			miModel.addRow(obj);
			
		}
		
	}
	
	/**
	 * Gets the info RB.
	 *
	 *metodo que valida los radiobutons, dependiendo si es PickUP o Sedán sera el radio button que se seleccione
	 * automaticamente.
	 * utilizado por el metodo mouseClicked de la tabla tablita
	 *
	 * @param t the t
	 * @return the info RB
	 * */
	private void getInfoRB(String t) {
		
		switch (t) {
		case "Pick Up":
			rbPickUp.setSelected(true);
			break;

		case "Sedán":
			rbSedan.setSelected(true);
			break;
		default:
			System.out.println("no paps, no funciono :'v");
			break;
		}
	}
	
	/**
	 * Validar RB.
	 * validacion del los radio Buttons
	 * @return true, if successful
	 */
	public boolean validarRB() {
		boolean validar = true;
		if(!rbPickUp.isSelected() && !rbSedan.isSelected()) {
			validar=false;
		}
		return validar;
		
	}
	
	/**
	 * Select RB.
	 *
	 * @return the string
	 */
	public String selectRB() {
		String tipo="";
		if(rbPickUp.isSelected()) {
			tipo="Pick Up";
		}else if(rbSedan.isSelected()) {
			tipo="Sedán";
		}
		return tipo;
	}
/**
 * Validacio solo letras.
 * este metodo sirve para cuando uno de los RadioButtons este seleccionado estos manden el tipo de auto
 * Utilizado por el metodo Guardar
 * @param e the e
 */
	private void validacioSoloLetras(KeyEvent e) {
		char caracter = e.getKeyChar();
	      // Verificar si la tecla pulsada no es un digito
	      if(((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') ||
			  (caracter > 'Z')) &&(caracter != '\b' /*corresponde a BACK_SPACE*/)){
	         e.consume();  // ignorar el evento de teclado
	      }
	}

	
}//clase Auto
