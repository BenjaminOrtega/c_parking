package DAO.Patrones.Decorator;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Conexion;

/*
 * DecoratorEntrada es las clase que extiende de EstacionamientoDecorator 
 * con la funcionalidad acotada.
 */

/**
 * The Class DecoratorEntrada.
 */
public class DecoratorEntrada extends EstacionamientoDecorator{

	/**
	 * Instantiates a new decorator entrada.
	 *
	 * @param estacionamiento the estacionamiento
	 */
	public DecoratorEntrada(Estacionamiento estacionamiento) {
		super(estacionamiento);
		// TODO Auto-generated constructor stub
	}		
		
		/**
		 * Agregar.
		 *
		 * @return true, if successful
		 */
		@Override
		public boolean agregar() {
			boolean agregado=false;
			String sql="INSERT INTO r_ingresos(\r\n" + 
					"	id_persona, id_auto, id_estacionamiento, hora_entrada, fecha_registro, hora_salida, fecha_salida, costo)\r\n" + 
					"	VALUES ( ?, ?, ?, CURRENT_TIME, date(now()),null, null,?);";
			
			String sql1="UPDATE public.area_estacionamiento SET estatus='ocupado'  WHERE id_estacionamiento=?";
			
			try {
				
				PreparedStatement ps=Conexion.getConnection().prepareStatement(sql);
				ps.setInt(1, getIdPersona());
				ps.setInt(2, getIdAuto());
				ps.setInt(3, getIdEstacionamiento());
				ps.setInt(4, getCosto());
				
				
				PreparedStatement ps1 =Conexion.getConnection().prepareStatement(sql1);
				ps1.setInt(1, getIdEstacionamiento());
				
				
				ps.executeUpdate();
				ps1.executeUpdate();
				agregado=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return agregado;
		}

	
		



}
