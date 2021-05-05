package DAO.Patrones.Decorator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import connection.Conexion;

/**
 * ConcreteEstacionamiento es la implementación principal y 
 * cuya clase recibirá los decoradores 
 * para agregar funcionalidad extra dinámicamente.
 * @author laloB
 *
 */
public class ConcreteEstacionamiento extends Estacionamiento{
	
	
	/**
	 * Instantiates a new concrete estacionamiento.
	 */
	public ConcreteEstacionamiento() {
		super();
	} 
	
	/**
	 * Instantiates a new concrete estacionamiento.
	 *
	 * @param frecuencia the frecuencia
	 * @param fehaEntrada the feha entrada
	 * @param costo the costo
	 */
	public ConcreteEstacionamiento(int frecuencia, String fehaEntrada,int costo ) {
		super(frecuencia, fehaEntrada, costo);
	}
	
	/**
	 * Instantiates a new concrete estacionamiento.
	 *
	 * @param idRegistro the id registro
	 * @param idPersona the id persona
	 * @param idAuto the id auto
	 * @param idEstacionamiento the id estacionamiento
	 * @param h_Entrada the h entrada
	 * @param f_Entrada the f entrada
	 * @param h_Salida the h salida
	 * @param f_Salida the f salida
	 * @param costo the costo
	 */
	public ConcreteEstacionamiento(int idRegistro, int idPersona, int idAuto, int idEstacionamiento, String h_Entrada,
			String f_Entrada, String h_Salida, String f_Salida, int costo) {
		super(idRegistro, idPersona, idAuto, idEstacionamiento, h_Entrada, f_Entrada, h_Salida, f_Salida, costo);
	}
	
	
	
	/**
	 * Agregar.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean agregar() {
		// TODO Auto-generated method stub
		return false;
	}

	
	/**
	 * Buscar todo.
	 *
	 * @return the linked list
	 */
	public LinkedList<Estacionamiento> buscarTodo() {
		LinkedList<Estacionamiento> es = null;
		String sql = "SELECT * FROM r_ingresos Order by fecha_registro";
		try {
			PreparedStatement ps=Conexion.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			es = new LinkedList<>();
			while (rs.next()) {
				es.add(new ConcreteEstacionamiento(rs.getInt("id_registro"),rs.getInt("id_persona"),
						rs.getInt("id_auto"),rs.getInt("id_estacionamiento"),rs.getString("hora_entrada"),
						rs.getString("fecha_registro"),rs.getString("hora_salida"),rs.getString("fecha_salida"),
						rs.getInt("costo")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return es;
	}
	
	/**
	 * Buscar filtro.
	 *
	 * @return the linked list
	 */
	public LinkedList<Estacionamiento> buscarFiltro() {
		LinkedList<Estacionamiento> es = null;
		String sql = "SELECT  count(r_ingresos.fecha_registro) as \"Frecuencia\",\r\n" + 
				"  r_ingresos.fecha_registro,\r\n" + 
				"  sum(costo) as \"Precios\"\r\n" + 
				"FROM  public.r_ingresos\r\n" + 
				"group by  r_ingresos.fecha_registro\r\n" + 
				"order by count(r_ingresos.fecha_registro) desc";
		try {
			PreparedStatement ps=ps=Conexion.getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			es = new LinkedList<>();
			while (rs.next()) {
				es.add(new ConcreteEstacionamiento(rs.getInt("Frecuencia"),rs.getString("fecha_registro"),rs.getInt("Precios")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return es;
	}



}
