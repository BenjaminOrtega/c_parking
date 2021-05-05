package DAO.Patrones.Iterator.Estacionamiento;

import java.util.LinkedList;

import DAO.Patrones.Decorator.ConcreteEstacionamiento;
import DAO.Patrones.Decorator.Estacionamiento;
import DAO.Patrones.Iterator.Agregado;
import DAO.Patrones.Iterator.Iterator;

/**
 * The Class AgregadoConcretoFiltroEstacionamiento.
 */
public class AgregadoConcretoFiltroEstacionamiento implements Agregado{
	
	/** The salida. */
	protected LinkedList<Estacionamiento> salida = new LinkedList<Estacionamiento>();
	
	/**
	 * Instantiates a new agregado concreto filtro estacionamiento.
	 */
	public AgregadoConcretoFiltroEstacionamiento() {
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
		return new IteratorFiltroEstacionamiento(this);
	}
	
	/**
	 * Llenar.
	 * metodo que retorna el contenido de la BD de la tabla r_ingresos
	 */
	public void llenar() {
		salida=new ConcreteEstacionamiento().buscarFiltro();
		
	}
}
