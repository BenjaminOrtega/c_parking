package DAO.Patrones.Iterator.Persona;

import DAO.PersonaDAO;
import DAO.Patrones.Iterator.Iterator;

// TODO: Auto-generated Javadoc
/**
 * The Class IteratorFiltroPersona.
 * Variable de tipo Agergado concreto, en donde se tiene la lista
 */
public class IteratorFiltroPersona implements Iterator{
	
	/** The agregado. */
	private AgregadoConcretoFiltroPersona agregado;
	
	/** The contador. 
	 * sirve para controlar el elemento actual de la lista*/
	private int contador; 
	
	/**
	 * Instantiates a new iterator filtro persona.
	 *Constructor que recibe un Objeto de la clase AgregadoConcretoPersona
	 * @param agregado the agregado
	 */
	public IteratorFiltroPersona(AgregadoConcretoFiltroPersona agregado){
		this.agregado=agregado;
		contador=0;
		
	}
	
	/**
	 * Hay mas.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean hayMas() {
		if (agregado.persona.size() > contador) {
			return true;
		}
		return false;
	}

	/**
	 * Siguiente.
	 *
	 * @return the persona DAO
	 */
	@Override
	public PersonaDAO siguiente() {
		// TODO Auto-generated method stub
		PersonaDAO res=agregado.persona.get(contador);
		contador++;
		return res;
	}
}
