package DAO.Patrones.Iterator.Area;

import DAO.AreaDAO;
import DAO.Patrones.Iterator.Iterator;

/**
 * The Class IteratorArea.
 */
public class IteratorArea implements Iterator{
	
	/** The agregado. 
	 * Variable de tipo Agergado concreto, en donde se tiene la lista*/
	private AgregadoConcretoArea agregado; 
	
	/** The contador.
	 * sirve para controlar el elemento actual de la lista */
	private int contador; 
	
	/**
	 * Instantiates a new iterator area.
	 *
	 *	Constructor que recibe un Objeto de la clase AgregadoConcreoto
	 * @param agregado the agregado
	 */
	public IteratorArea(AgregadoConcretoArea agregado){
		this.agregado=agregado;
		contador=0;
		
	}
	
	/**
	 * Hay mas.
	 * este metodo va a verificar la existencia de elementos utilizando una variable que contaviliza 
	 * @return true, if successful
	 */
	@Override
	public boolean hayMas() {
		if (agregado.area.size() > contador) {
			return true;
		}
		return false;
	}

	/**
	 * Siguiente.
	 *
	 * @return the area DAO
	 */
	@Override
	public AreaDAO siguiente() {
		AreaDAO res=agregado.area.get(contador);
		contador++;
		return res;
	}
}
