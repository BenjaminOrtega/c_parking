package DAO.Patrones.Iterator.Auto;
import java.util.LinkedList;

import DAO.*;
import DAO.Patrones.Iterator.Agregado;
import DAO.Patrones.Iterator.Iterator;

/**
 * The Class AgregadoConcretoAuto.
 */
public class AgregadoConcretoAuto implements Agregado {
	
	/** The autos. */
	protected LinkedList<AutoDAO> autos = new LinkedList<AutoDAO>();
	
	/**
	 * Instantiates a new agregado concreto auto.
	 */
	public AgregadoConcretoAuto() {
		this.llenar();
	}
	
	/**
	 * Gets the iterator.
	 *
	 * @return retorna un objeto y y manda por parametro AgregadoConcreto
	 */
	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new IteratorAuto(this);
	}
	
	/**
	 * Llenar.
	 * Metodo que retorna el contenido de la BD de la tabla autos
	 */
	public void llenar() {
		autos=new AutoDAO().buscarTodo();
		
	}

}
