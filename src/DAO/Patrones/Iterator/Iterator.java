package DAO.Patrones.Iterator;

/**
 *  Interfaz que incluye los m�todos para verificar la existencia de m�s elementos 
 *  y para regresar un objeto de tipo Resultado.
 */
public interface Iterator {
	
	/**
	 * Hay mas.
	 *
	 * @return true, if successful
	 */
	public boolean hayMas();
	
	/**
	 * Siguiente.
	 *
	 * @return the object
	 */
	public Object siguiente();
}
