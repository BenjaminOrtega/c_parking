package InterfaceDAO;

import DAO.AreaDAO;

/**
 * The Interface AgregarAreaInterface.
 */
@FunctionalInterface
public interface AgregarAreaInterface {
	
	/**
	 * Agregar area.
	 *
	 * @param area the area
	 * @return true, if successful
	 */
	abstract boolean agregarArea(AreaDAO area);
}
