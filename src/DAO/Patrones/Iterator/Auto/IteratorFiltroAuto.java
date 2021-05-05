package DAO.Patrones.Iterator.Auto;

import DAO.AutoDAO;
import DAO.Patrones.Iterator.Iterator;

/**
 * The Class IteratorFiltroAuto.
 */
public class IteratorFiltroAuto implements Iterator{
	
	/** The agregado. 
	 * Variable de tipo Agergado concreto, en donde se tiene la lista*/
	private AgregadoConcretoFiltroAuto agregado; 
	
	/** The contador. 
	 * sirve para controlar el elemento actual de la lista*/
	private int contador; 
	
	/**
	 * Instantiates a new iterator filtro auto.
	 * Constructor que recibe un Objeto de la clase AgregadoConcreot
	 * @param agregado the agregado
	 */
	public IteratorFiltroAuto(AgregadoConcretoFiltroAuto agregado){
		this.agregado=agregado;
		contador=0;
		
	}
	
	/**
	 * Hay mas.
	 * Este metodo va a verificar la existencia de elementos utilizando una variable que contaviliza
	 * @return true, if successful
	 */
	@Override
	public boolean hayMas() {
		if (agregado.autos.size() > contador) {
			return true;
		}
		return false;
	} 

	/**
	 * Siguiente.
	 *
	 * @return metodo que retornara el ultimo resultado de la lista
	 */
	@Override
	public AutoDAO siguiente() {
		// TODO Auto-generated method stub
		AutoDAO res=agregado.autos.get(contador);
		contador++;
		return res;
	}
}
