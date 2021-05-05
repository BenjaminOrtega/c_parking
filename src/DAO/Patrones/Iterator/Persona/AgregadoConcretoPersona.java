package DAO.Patrones.Iterator.Persona;

import java.util.LinkedList;

import DAO.PersonaDAO;
import DAO.Patrones.Iterator.Agregado;
import DAO.Patrones.Iterator.Iterator;

/**
 * The Class AgregadoConcretoPersona.
 */
public class AgregadoConcretoPersona implements Agregado {
	
	/** The persona. */
	protected LinkedList<PersonaDAO> persona = new LinkedList<PersonaDAO>();
	
	/**
	 * Instantiates a new agregado concreto persona.
	 */
	public AgregadoConcretoPersona() {
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
		return new IteratorPersona(this);
	}
	
	/**
	 * 
	 * Llenar.
	 * metodo que retorna el contenido de la BD de la tabla persona
	 */
	public void llenar() {
		persona=new PersonaDAO().buscarTodos();
		
	}
}
