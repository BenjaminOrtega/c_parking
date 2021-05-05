package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import InterfaceDAO.*;
import classDao.PersonaClassDAO;
import connection.*;

/**
 * The Class PersonaDAO.
 */
public class PersonaDAO extends PersonaClassDAO{
	
	/**
	 * Instantiates a new persona DAO.
	 */
	public PersonaDAO(){
		super();
	}
	
	/**
	 * Instantiates a new persona DAO.
	 *
	 * @param id the id
	 */
	public PersonaDAO(int id){
		super(id);
	}
	
	/**
	 * Instantiates a new persona DAO.
	 *
	 * @param frecuencia the frecuencia
	 * @param idpersona the idpersona
	 * @param nombre the nombre
	 * @param email the email
	 */
	public PersonaDAO(int frecuencia, int idpersona,String nombre, String email){
		setFrecuencia(frecuencia);
		setIdpersona(idpersona);
		setNombre(nombre);
		setEmail(email);
	}
	
	/**
	 * Instantiates a new persona DAO.
	 *
	 * @param nombre the nombre
	 * @param apellido the apellido
	 * @param telefono the telefono
	 * @param direccion the direccion
	 * @param email the email
	 */
	public PersonaDAO(String nombre, String apellido,String telefono,String direccion, String email){
		super(nombre, apellido, telefono, direccion, email);
	}
	
	/**
	 * Instantiates a new persona DAO.
	 *
	 * @param idpersona the idpersona
	 * @param nombre the nombre
	 * @param apellidos the apellidos
	 * @param telefono the telefono
	 * @param direccion the direccion
	 * @param email the email
	 */
	public PersonaDAO(int idpersona, String nombre, String apellidos,String telefono,String direccion, String email){
		super(idpersona, nombre, apellidos, telefono, direccion, email);
	}

	/** The agregar. */
	private final GestionInterface agregar=()->{
		boolean agregado=false;
		String sql="INSERT INTO persona(nombre,apellidos,telefono,direccion,email) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps=Conexion.getConnection().prepareStatement(sql);
			ps.setString(1, getNombre());
			ps.setString(2, getApellidos());
			ps.setString(3, getTelefono());
			ps.setString(4, getDireccion());
			ps.setString(5, getEmail());
			ps.executeUpdate();
			agregado=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return agregado;
	};
	
	/** The eliminar. */
	private  final GestionInterface eliminar=()->{
		boolean eliminado=false;
		String sql = "DELETE FROM persona WHERE id_persona=?";
		try {
			PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
			ps.setInt(1, getIdpersona());
			eliminado=true; 
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return eliminado;
	};
	
	/** The actualizar. */
	private final GestionInterface actualizar=()->{
		boolean actualizado=false;
		String sql = "UPDATE persona SET nombre=?, apellidos=?,telefono=?,direccion=?,email=? WHERE id_persona=?";
		try {
			PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
			ps.setString(1, getNombre());
			ps.setString(2, getApellidos());
			ps.setString(3, getTelefono());
			ps.setString(4, getDireccion());
			ps.setString(5, getEmail());
			ps.setInt(6, getIdpersona());
			actualizado = true;
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actualizado;
	};


	/**
	 * Buscar todos.
	 *
	 * @return the linked list
	 */
	public LinkedList<PersonaDAO> buscarTodos(){
		LinkedList<PersonaDAO> perso = null;
		String sql = "SELECT * FROM persona";
		try {
			PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			perso = new LinkedList<>();
			while (rs.next()) {
				perso.add(new PersonaDAO(rs.getInt("id_persona"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("telefono"),rs.getString("direccion"), rs.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return perso;
		
	}
	
	/**
	 * Buscar filtro.
	 *
	 * @return the linked list
	 */
	public LinkedList<PersonaDAO> buscarFiltro(){
		LinkedList<PersonaDAO> perso = null;
		String sql = "SELECT count(r_ingresos.id_persona) as \"Frecuencia\",\r\n" + 
				"  r_ingresos.id_persona, \r\n" + 
				"  persona.nombre, \r\n" + 
				"  persona.email\r\n" + 
				"FROM \r\n" + 
				"  public.persona, \r\n" + 
				"  public.r_ingresos\r\n" + 
				"WHERE \r\n" + 
				"  r_ingresos.id_persona = persona.id_persona\r\n" + 
				"group by r_ingresos.id_persona,persona.nombre , persona.email\r\n" + 
				"order by count(r_ingresos.id_persona) desc";
		try {
			PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			perso = new LinkedList<>();
			while (rs.next()) {
				perso.add(new PersonaDAO(rs.getInt("Frecuencia"),rs.getInt("id_persona"),rs.getString("nombre"),rs.getString("email")));
			}
			ps=(PreparedStatement) Conexion.getConnectionClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return perso;
		
	}

	/**
	 * Gets the eliminar.
	 *
	 * @return the eliminar
	 */
	public GestionInterface getEliminar() {
		return eliminar;
	}

	/**
	 * Gets the agregar.
	 *
	 * @return the agregar
	 */
	public GestionInterface getAgregar() {
		return agregar;
	}

	/**
	 * Gets the actualizar.
	 *
	 * @return the actualizar
	 */
	public GestionInterface getActualizar() {
		return actualizar;
	}
	

	
	
	
	
	

}
