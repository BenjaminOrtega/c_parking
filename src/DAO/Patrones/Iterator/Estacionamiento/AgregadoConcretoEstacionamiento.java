package DAO.Patrones.Iterator.Estacionamiento;

import java.util.LinkedList;

import DAO.Patrones.Decorator.ConcreteEstacionamiento;
import DAO.Patrones.Decorator.Estacionamiento;
import DAO.Patrones.Iterator.Agregado;
import DAO.Patrones.Iterator.Iterator;
// TODO: Auto-generated Javadoc

/**
 * The Class AgregadoConcretoEstacionamiento.
 */
public class AgregadoConcretoEstacionamiento implements Agregado{
	
	/** The salida. */
	protected LinkedList<Estacionamiento> salida = new LinkedList<Estacionamiento>();
	
	/**
	 * Instantiates a new agregado concreto estacionamiento.
	 */
	public AgregadoConcretoEstacionamiento() {
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
		return new IteratorEstacionamiento(this);
	}
	
	/**
	 * Llenar.
	 * Metodo que retorna el contenido de la BD de la tabla r_ingresos
	 */
	public void llenar() {
		salida=new ConcreteEstacionamiento().buscarTodo();
		
	}
}
