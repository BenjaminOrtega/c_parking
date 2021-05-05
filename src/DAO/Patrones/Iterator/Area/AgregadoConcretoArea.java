package DAO.Patrones.Iterator.Area;

import java.util.LinkedList;

import DAO.AreaDAO;
import DAO.Patrones.Iterator.Agregado;
import DAO.Patrones.Iterator.Iterator;

/**
 * The Class AgregadoConcretoArea.
 */
public class AgregadoConcretoArea implements Agregado{
	
	/** The area. */
	protected LinkedList<AreaDAO> area = new LinkedList<AreaDAO>();
	
	/**
	 * Instantiates a new agregado concreto area.
	 */
	public AgregadoConcretoArea() {
		this.llenar();
	}
	
	/**
	 * Gets the iterator.
	 * 
	 * @return Retorna un iterator y manda por parametro AgregadoConcreto
	 */
	@Override
	public Iterator getIterator() {
		// TODO Auto-generated method stub
		return new IteratorArea(this);
	}//
	
	/**
	 * Llenar.
	 */
	public void llenar() {
		area=new AreaDAO().buscarTodo();
	}
}
	
