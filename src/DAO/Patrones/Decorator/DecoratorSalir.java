package DAO.Patrones.Decorator;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Conexion;

// TODO: Auto-generated Javadoc
/*
 * DecoratorSalir es las clase que extiende de EstacionamientoDecorator 
 * con la funcionalidad acotada.
 */

/**
 * The Class DecoratorSalir.
 */
public class DecoratorSalir extends EstacionamientoDecorator {
	
	/**
	 * Instantiates a new decorator salir.
	 *
	 * @param estacionamiento the estacionamiento
	 */
	public DecoratorSalir(Estacionamiento estacionamiento) {
		super(estacionamiento);
		// TODO Auto-generated constructor stub
	}
		
		/**
		 * Agregar.
		 * Este metodo actualiza la tabla r_ingresos Y area_estacionamiento
		 * @return true, if successful
		 */
		@Override
	public boolean agregar() {
		boolean actualizado=false;
		String sql = "UPDATE r_ingresos SET hora_salida=CURRENT_TIME, fecha_salida=date(now())  WHERE id_registro=?";
		String sql1="UPDATE area_estacionamiento SET estatus='vacio'  WHERE id_estacionamiento=?";
		try {
			PreparedStatement ps=Conexion.getConnection().prepareStatement(sql);
			ps.setInt(1, getIdRegistro());
			
			PreparedStatement ps1=Conexion.getConnection().prepareStatement(sql1);
			ps1.setInt(1, getIdEstacionamiento());
			
			actualizado = true;
			ps.executeUpdate();
			ps1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actualizado;
	}

		
	
}
