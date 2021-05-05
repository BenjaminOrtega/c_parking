package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import InterfaceDAO.GestionInterface;
import classDao.AreaClassDAO;
import connection.Conexion;

/**
 * The Class AreaDAO.
 */
public class AreaDAO extends AreaClassDAO{
	 
 	/**
 	 * Instantiates a new area DAO.
 	 */
 	public AreaDAO() {
		   super();
		}
		
		/**
		 * Instantiates a new area DAO.
		 *
		 * @param id the id
		 */
		public AreaDAO(int id) {
			super(id);
		}
		
		/**
		 * Instantiates a new area DAO.
		 *
		 * @param tamano the tamano
		 * @param altura the altura
		 * @param piso the piso
		 */
		public AreaDAO(String tamano, double altura, int piso) {
			super(tamano,altura, piso);
		}
		
		/**
		 * Instantiates a new area DAO.
		 *
		 * @param id_estacionamiento the id estacionamiento
		 * @param tamano the tamano
		 * @param altura the altura
		 * @param estatus the estatus
		 * @param piso the piso
		 */
		public AreaDAO(int id_estacionamiento, String tamano, double altura, String estatus, int piso) {
			super( id_estacionamiento,  tamano,  altura,  estatus,  piso);
		}
		
		/** The agregar.
		 * Se utilia un lamda de tipo Provedor para agregar a la base de datos */
		private final GestionInterface agregar =()->{
			boolean agregado=false;
			String sql="INSERT INTO public.area_estacionamiento(\r\n" + 
					" tamano, altura, estatus, piso) VALUES (?, ?,'vacio', ?);";
			try {
				PreparedStatement ps=Conexion.getConnection().prepareStatement(sql);
				ps.setString(1, getTamano());
				ps.setDouble(2, getAltura());
				ps.setInt(3, getPiso());
				ps.executeUpdate();
				agregado=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return agregado;
		};
		
		/** The eliminar. 
		 * Se utilia un lamda de tipo Provedor para eliminar a la base de datos*/
		private final GestionInterface eliminar=()->{
			boolean eliminado=false;
			String sql = "DELETE FROM area_estacionamiento WHERE id_estacionamiento=?";
			try {
				PreparedStatement ps =Conexion.getConnection().prepareStatement(sql);
				ps.setInt(1,getIdEestacionamiento());
				eliminado=true; 
				ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			}
			return eliminado;
		};
		
		/**
		 * Buscar todo.
		 *
		 * @return the linked list
		 */
		public LinkedList<AreaDAO> buscarTodo() {
			LinkedList<AreaDAO> area = null;
			String sql = "SELECT * FROM area_estacionamiento";
			try {
				PreparedStatement ps=Conexion.getConnection().prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				area = new LinkedList<>();
				while (rs.next()) {
					area.add( new AreaDAO(rs.getInt("id_estacionamiento"),rs.getString("tamano"),rs.getDouble("altura"),
							              rs.getString("estatus"),rs.getInt("piso")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return area;
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
		
}
