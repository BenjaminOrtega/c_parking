package classDao;

/**
 * The Class AreaClassDAO.
 */
public class AreaClassDAO {
	 
 	/** The id eestacionamiento. */
 	private int idEestacionamiento;
	 
 	/** The tamano. */
 	private String tamano; 
	 
 	/** The altura. */
 	private double altura; 
	 
 	/** The estatus. */
 	 private String estatus;
	 
 	/** The piso. */
 	private int piso;
	 
	 /**
 	 * Instantiates a new area class DAO.
 	 */
 	public AreaClassDAO() {
		 
	 }
	 
	 /**
 	 * Instantiates a new area class DAO.
 	 *
 	 * @param id the id
 	 */
 	public AreaClassDAO(int id) {
			this.idEestacionamiento=id;
	 }
		
	 /**
 	 * Instantiates a new area class DAO.
 	 *
 	 * @param tamano the tamano
 	 * @param altura the altura
 	 * @param piso the piso
 	 */
 	public AreaClassDAO(String tamano, double altura, int piso) {
			this.tamano = tamano;
			this.altura = altura;
			this.piso = piso;
			
	 }
		
	 /**
 	 * Instantiates a new area class DAO.
 	 *
 	 * @param idEestacionamiento the id eestacionamiento
 	 * @param tamano the tamano
 	 * @param altura the altura
 	 * @param estatus the estatus
 	 * @param piso the piso
 	 */
 	public AreaClassDAO(int idEestacionamiento, String tamano, double altura, String estatus, int piso) {
			this.idEestacionamiento = idEestacionamiento;
			this.tamano = tamano;
			this.altura = altura;
			this.estatus = estatus;
			this.piso = piso;
			
	 }
		
	 /**
 	 * Gets the id eestacionamiento.
 	 *
 	 * @return the id eestacionamiento
 	 */
 	public int getIdEestacionamiento() {
			return idEestacionamiento;
	 }
	 
 	/**
 	 * Sets the id eestacionamiento.
 	 *
 	 * @param idEestacionamiento the new id eestacionamiento
 	 */
 	public void setIdEestacionamiento(int idEestacionamiento) {
			this.idEestacionamiento = idEestacionamiento;
	 }
	 
 	/**
 	 * Gets the tamano.
 	 *
 	 * @return the tamano
 	 */
 	public String getTamano() {
			return tamano;
	 }
	 
 	/**
 	 * Sets the tamano.
 	 *
 	 * @param tamano the new tamano
 	 */
 	public void setTamano(String tamano) {
			this.tamano = tamano;
	 }
	 
 	/**
 	 * Gets the altura.
 	 *
 	 * @return the altura
 	 */
 	public double getAltura() {
			return altura;
	 }
	 
 	/**
 	 * Sets the altura.
 	 *
 	 * @param altura the new altura
 	 */
 	public void setAltura(double altura) {
			this.altura = altura;
	 }
	 
 	/**
 	 * Gets the estatus.
 	 *
 	 * @return the estatus
 	 */
 	public String getEstatus() {
			return estatus;
	 }
	 
 	/**
 	 * Sets the estatus.
 	 *
 	 * @param estatus the new estatus
 	 */
 	public void setEstatus(String estatus) {
			this.estatus = estatus;
	 }
	 
 	/**
 	 * Gets the piso.
 	 *
 	 * @return the piso
 	 */
 	public int getPiso() {
			return piso;
	 }
	 
 	/**
 	 * Sets the piso.
 	 *
 	 * @param piso the new piso
 	 */
 	public void setPiso(int piso) {
			this.piso = piso;
	 }
	
		
	
}
