package view.estacionamiento;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ReportesDAO;
import DAO.Patrones.Decorator.Estacionamiento;
import DAO.Patrones.Iterator.Iterator;
import DAO.Patrones.Iterator.Estacionamiento.AgregadoConcretoEstacionamiento;
import DAO.Patrones.Iterator.Estacionamiento.AgregadoConcretoFiltroEstacionamiento;
import net.sf.jasperreports.engine.JRException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

/**
 * The Class VerTodo.
 */
public class VerTodo extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The table filtro estacionamiento. */
	private JTable tableEstacionamiento,tableFiltroEstacionamiento;
	
	/** The btn regresar. */
	private JButton btnReporte,btnRegresar;
	
	/** The scroll pane. */
	private JScrollPane scrollPane;
	
	/** The rb filtro. */
	private JRadioButton rbFiltro;
	
	/** The reportes. */
	private ReportesDAO reportes = new ReportesDAO();
	/**
	 * Create the frame.
	 */
	public VerTodo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 59, 792, 320);
		contentPane.add(scrollPane);
		
		tableEstacionamiento = new JTable();
		tableEstacionamiento.setBounds(65, 339, 370, -107);		
		tableEstacionamiento.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id_registro", "id_persona", "id_auto", "id_estacionamiento","hora_entrada","fecha_registro","hora_salida","fecha_salida", "costo"
				}
			));
		scrollPane.setViewportView(tableEstacionamiento);
		
		tableFiltroEstacionamiento = new JTable();
		tableFiltroEstacionamiento.setBounds(65, 339, 370, -107);		
		tableFiltroEstacionamiento.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Frecuencia", "Fechas","Recaudacion por Dia"
				}
			));
		
		btnRegresar= new JButton("Regresar");
		Image img1= new ImageIcon(this.getClass().getResource("/imagen/espalda(1).png")).getImage();
		btnRegresar .setIcon(new ImageIcon(img1));
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 19));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstacionamientoMenu es=new EstacionamientoMenu();
				es.show();
				dispose();
			}
		});
		btnRegresar.setBounds(632, 13, 176, 35);
		contentPane.add(btnRegresar);
		
		btnReporte = new JButton("Reporte");
		Image img2= new ImageIcon(this.getClass().getResource("/imagen/pdf.png")).getImage();
		btnReporte .setIcon(new ImageIcon(img2));
		btnReporte.setFont(new Font("Arial", Font.BOLD, 19));
		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					reportes.buscarRegistrosGenerales();
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnReporte.setBounds(20, 11, 224, 41);
		contentPane.add(btnReporte);
		
		rbFiltro = new JRadioButton("Ver Ganancias Por D\u00EDa");
		rbFiltro.setFont(new Font("Arial", Font.BOLD, 19));
		rbFiltro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rbFiltro.isSelected()) {
					buscarFiltro();
					scrollPane.setViewportView(tableFiltroEstacionamiento);
					btnReporte.setVisible(false);
				}else {
					limpiar();
				}
			}
		});
		rbFiltro.setBounds(269, 13, 331, 25);
		contentPane.add(rbFiltro);
		buscarTodos();
	}//Contructor
	
	/**
	 * Limpiar.
	 */
	public void limpiar() {
		DefaultTableModel temp = (DefaultTableModel) tableEstacionamiento.getModel();
        DefaultTableModel temp1 = (DefaultTableModel) tableFiltroEstacionamiento.getModel();
        temp.setRowCount(0);
        temp1.setRowCount(0);
        rbFiltro.setSelected(false);
        btnReporte.setVisible(true);
        scrollPane.setViewportView(tableEstacionamiento);
        buscarTodos();
	}
	
	/**
	 * Buscar todos.
	 * metosdo para buscar objetos implementado el patron de diseño iterator
	 */
	private void buscarTodos() {
		DefaultTableModel miModel=(DefaultTableModel) tableEstacionamiento.getModel();
		AgregadoConcretoEstacionamiento agre=new AgregadoConcretoEstacionamiento();
		Iterator iterator=agre.getIterator();
		while(iterator.hayMas()){
			Estacionamiento sal= (Estacionamiento) iterator.siguiente();
			Object obj[] = new Object[9];
			obj[0]=sal.getIdRegistro();
			obj[1]=sal.getIdPersona();
			obj[2]=sal.getIdAuto();
			obj[3]=sal.getIdEstacionamiento();
			obj[4]=sal.getHoraEntrada();
			obj[5]=sal.getFehaEntrada();
			obj[6]=sal.getHoraSalida();
			obj[7]=sal.getFechaSalida();
			obj[8]=sal.getCosto();
			miModel.addRow(obj);
		}
	}
	
	/**
	 * Buscar filtro.
	 * metosdo para buscar objetos implementado el patron de diseño iterator
	 */
	private void buscarFiltro() {
		DefaultTableModel miModel=(DefaultTableModel) tableFiltroEstacionamiento.getModel();
		AgregadoConcretoFiltroEstacionamiento agre=new AgregadoConcretoFiltroEstacionamiento();
		Iterator iterator=agre.getIterator();
		while(iterator.hayMas()){
			Estacionamiento sal= (Estacionamiento) iterator.siguiente();
			Object obj[] = new Object[3];
			obj[0]=sal.getFrecuencia();
			obj[1]=sal.getFehaEntrada();
			obj[2]="$ "+sal.getCosto();
			miModel.addRow(obj);
		}
	}
}
