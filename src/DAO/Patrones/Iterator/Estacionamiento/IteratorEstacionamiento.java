package DAO.Patrones.Iterator.Estacionamiento;

import DAO.Patrones.Decorator.Estacionamiento;
import DAO.Patrones.Iterator.Iterator;


/**
 * The Class IteratorEstacionamiento.
 */
public class IteratorEstacionamiento implements Iterator{
	
	/** The agregado. 
	 * Variable de tipo Agergado concreto, en donde se tiene la lista*/
	private AgregadoConcretoEstacionamiento agregado; // 
	
	/** The contador. 
	 * sirve para controlar el elemento actual de la lista*/
	private int contador;
	
	/**
	 * Instantiates a new iterator estacionamiento.
	 * Constructor que recibe un Objeto de la clase AgregadoConcreot
	 * @param agregado the agregado
	 */
	public IteratorEstacionamiento(AgregadoConcretoEstacionamiento agregado){ 
		this.agregado=agregado;
		contador=0;
		
	}
	
	/**
	 * Hay mas.
	 *Este metodo va a verificar la existencia de elementos utilizando una variable que contaviliza 
	 * @return true, if successful
	 */
	@Override
	public boolean hayMas() {
		if (agregado.salida.size() > contador) {
			return true;
		}
		return false;
	}

	/**
	 * Siguiente.
	 *	metodo que retornara el ultimo resultado de la lista
	 * @return the estacionamiento
	 */
	@Override
	public Estacionamiento siguiente() {
		// TODO Auto-generated method stub
		Estacionamiento res=agregado.salida.get(contador);
		contador++;
		return res;
	}
}
