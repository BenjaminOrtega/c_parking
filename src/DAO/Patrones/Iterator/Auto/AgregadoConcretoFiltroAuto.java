package DAO.Patrones.Iterator.Auto;

import java.util.LinkedList;

import DAO.AutoDAO;
import DAO.Patrones.Iterator.Agregado;
import DAO.Patrones.Iterator.Iterator;

/**
 * The Class AgregadoConcretoFiltroAuto.
 */
public class AgregadoConcretoFiltroAuto implements Agregado{
	
	/** The autos. */
	protected LinkedList<AutoDAO> autos = new LinkedList<AutoDAO>();
	
	/**
	 * Instantiates a new agregado concreto filtro auto.
	 */
	public AgregadoConcretoFiltroAuto() {
		this.llenar();
	}
	
	/**
	 * Gets the iterator.
	 * retorna un objeto y y manda por parametro AgregadoConcreto
	 * @return the iterator
	 */
	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new IteratorFiltroAuto(this);
	}
	
	/**
	 * Llenar.
	 * 
	 * metodo que retorna el contenido de la BD de la tabla autos
	 */
	public void llenar() {
		autos=new AutoDAO().buscarFiltro();
		
	}
}
