package DAO.Patrones.Decorator;

/**
 * The Class EstacionamientoDecorator.
 *
 * @author laloB
 * Es una clase abstracta define
 * el Decorador que hereda de la clase abstracta Estacionamiento
 * y de la cual luego se crearán todos los demás decoradores. 
 * El decorador debe mantener la referencia al objeto original a fin de invocarlo y 
 * luego agregarle otras funcionalidades propias del decorador
 */

public abstract class EstacionamientoDecorator extends Estacionamiento{
	
	/** The estacionamiento. */
	private final Estacionamiento estacionamiento;
	
	/**
	 * Instantiates a new estacionamiento decorator.
	 *
	 * @param estacionamiento the estacionamiento
	 */
	public EstacionamientoDecorator(Estacionamiento estacionamiento) {
	this.estacionamiento=estacionamiento;
	}

}
