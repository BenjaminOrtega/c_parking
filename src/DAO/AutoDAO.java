package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import InterfaceDAO.GestionInterface;
import connection.Conexion;
import classDao.AutoClassDAO;

/**
 * The Class AutoDAO.
 */
public class AutoDAO extends AutoClassDAO {
	
	/**
	 * Instantiates a new auto DAO.
	 */
	public AutoDAO() {
		super();
	}
    
    /**
     * Instantiates a new auto DAO.
     *
     * @param id the id
     */
    public AutoDAO(int id){
    	super(id);
    }
    
    /**
     * Instantiates a new auto DAO.
     *
     * @param cantidad the cantidad
     * @param n_placas the n placas
     * @param marca the marca
     * @param modelo the modelo
     * @param tipo the tipo
     */
    public AutoDAO(int cantidad, String numeroPlacas, String marca, String modelo, String tipo) {
    	super(cantidad, numeroPlacas, marca, modelo, tipo);
    }
    
    /**
     * Instantiates a new auto DAO.
     *
     * @param n_placas the n placas
     * @param color the color
     * @param marca the marca
     * @param tipo the tipo
     * @param modelo the modelo
     * @param observaciones the observaciones
     */
    public AutoDAO(String n_placas, String color, String marca, String tipo, String modelo,
			String observaciones) {
	super(n_placas, color, marca, tipo, modelo, observaciones);
    } 
    
	/**
	 * Instantiates a new auto DAO.
	 *
	 * @param id_auto the id auto
	 * @param n_placas the n placas
	 * @param color the color
	 * @param marca the marca
	 * @param tipo the tipo
	 * @param modelo the modelo
	 * @param observaciones the observaciones
	 */
	public AutoDAO(int id_auto,String n_placas, String color, String marca, String tipo, String modelo,
				String observaciones) {
		super(id_auto, n_placas, color, marca, tipo, modelo, observaciones);
	}
	
	/** The agregar. */
	/*
	 * Se implementan un lamda para utilizar el mtodo agregar de una interface funcional
	 */
	private final GestionInterface agregar = ()->{
		boolean agregado=false;
		String sql="insert into auto(n_placas,color,marca, tipo, modelo ,observaciones) values(?,?,?,?,?,?);";
		try {
			PreparedStatement ps=Conexion.getConnection().prepareStatement(sql);
			ps.setString(1, getNumeroPlacas());
			ps.setString(2, getColor());
			ps.setString(3, getMarca());
			ps.setString(4, getTipo());
			ps.setString(5, getModelo());
			ps.setString(6, getObservaciones());
			ps.executeUpdate();
			Conexion.getConnectionClose();
			agregado=true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			}	return agregado;
		};
		

	
		/** The actualizar. */
		/*
		 * Se implementan un lamda para utilizar el mtodo actualizar de una interface funcional
		 */
	private final GestionInterface actualizar=()->{
		boolean actualizado=false;
		String sql = "UPDATE auto SET n_placas=?,color=?,marca=?, tipo=?, modelo=? ,observaciones=? WHERE id_auto=?";
		try {
			
			PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
			ps.setString(1, getNumeroPlacas());
			ps.setString(2, getColor());
			ps.setString(3, getMarca());
			ps.setString(4, getTipo());
			ps.setString(5, getModelo());
			ps.setString(6, getObservaciones());
			ps.setInt(7, getIdauto());
			System.out.println(getObservaciones());
			actualizado = true;
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return actualizado;
	};
	
	/*
	 * Se implementan un lamda para utilizar el mtodo eliminar de una interface funcional
	 */

	/** The eliminar. */
	private final GestionInterface eliminar=()->{
		boolean eliminado=false;
		String sql = "DELETE FROM auto WHERE id_auto=?";
		try {
			PreparedStatement ps =Conexion.getConnection().prepareStatement(sql);
			ps.setInt(1,getIdauto() );
			eliminado=true; 
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return eliminado;
	};
	
	/**
	 * Gets the agregar.
	 *
	 * @return the agregar
	 */
	/*
	 * Metodos que encapsulan a las interfaces y utlizar sus metodos en otras clases
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
	
	/**
	 * Gets the eliminar.
	 *
	 * @return the eliminar
	 */
	public GestionInterface getEliminar() {
		return eliminar;
	}
	
	/**
	 * Buscar todo.
	 *
	 * @return the linked list
	 */
	public LinkedList<AutoDAO> buscarTodo() {
		// TODO Auto-generated method stub
		LinkedList<AutoDAO> autos = null;
		String sql = "SELECT * FROM auto";
		try {
			PreparedStatement ps=Conexion.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			autos = new LinkedList<>();
			while (rs.next()) {
				autos.add( new AutoDAO(rs.getInt("id_auto"),rs.getString("n_placas"),rs.getString("color"),
						              rs.getString("marca"),rs.getString("tipo"),rs.getString("modelo"),
						              rs.getString("observaciones")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return autos;
	}
	
	/**
	 * Buscar filtro.
	 *
	 * @return the linked list
	 */
	public LinkedList<AutoDAO> buscarFiltro() {
		// TODO Auto-generated method stub
		LinkedList<AutoDAO> autos = null;
		String sql = "SELECT count(r_ingresos.id_auto) as \"Cantidad\",\r\n" + 
				"  auto.n_placas, \r\n" + 
				"  auto.marca, \r\n" + 
				"  auto.modelo, \r\n" + 
				"  auto.tipo\r\n" + 
				"FROM \r\n" + 
				"  public.r_ingresos, \r\n" + 
				"  public.auto\r\n" + 
				"WHERE \r\n" + 
				"  r_ingresos.id_auto = auto.id_auto\r\n" + 
				"  group by auto.n_placas,auto.marca, \r\n" + 
				"  auto.modelo, \r\n" + 
				"  auto.tipo\r\n" + 
				"order by count(r_ingresos.id_auto) desc";
		try {
			PreparedStatement ps=Conexion.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			autos = new LinkedList<>();
			while (rs.next()) {
				autos.add( new AutoDAO(rs.getInt("Cantidad"),rs.getString("n_placas"),
						rs.getString("marca"),rs.getString("modelo"),rs.getString("tipo")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return autos;
	}
	
	/**
	 * Tipo auto.
	 *
	 * @param tipo the tipo
	 * @return the string
	 */
	public String tipoAuto(int tipo) {
		String tipoAuto = null;
		String sql = "SELECT tipo FROM auto where id_auto="+tipo+";";
		try {
			PreparedStatement ps=Conexion.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				tipoAuto=rs.getString("tipo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipoAuto;
	} //Metodo que obtiene untipo de auto de la tabla auto 
	
}
