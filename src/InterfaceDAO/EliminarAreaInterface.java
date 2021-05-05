package InterfaceDAO;

import DAO.AreaDAO;

/**
 * The Interface EliminarAreaInterface.
 */
@FunctionalInterface
public interface EliminarAreaInterface {
	
	/**
	 * Elimiunar area.
	 *
	 * @param area the area
	 * @param id the id
	 * @return true, if successful
	 */
	abstract boolean elimiunarArea(AreaDAO area, int id); 
}
