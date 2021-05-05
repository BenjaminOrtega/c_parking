package classDao;

/**
 * The Class AutoClassDAO.
 */
public class AutoClassDAO {
	
	/** The cantidad. */
	private int cantidad;
	
	/** The idauto. */
	private int idauto;
	
	/** The numero placas. */
	private String numeroPlacas;
	
	/** The color. */
	private String color;
	
	/** The marca. */
	private String marca;
	
	/** The tipo. */
	private String tipo;
	
	/** The modelo. */
	private String modelo;
	
	/** The observaciones. */
	private String observaciones;
	
	/**
	 * Instantiates a new auto class DAO.
	 */
	public AutoClassDAO() {
	}
	
	/**
	 * Instantiates a new auto class DAO.
	 *
	 * @param id the id
	 */
	public AutoClassDAO(int id) {
		this.idauto=id;
	}
	
	/**
	 * Instantiates a new auto class DAO.
	 *
	 * @param cantidad the cantidad
	 * @param numeroPlacas the numero placas
	 * @param marca the marca
	 * @param modelo the modelo
	 * @param tipo the tipo
	 */
	public AutoClassDAO(int cantidad, String numeroPlacas, String marca, String modelo, String tipo) {
		this.cantidad=cantidad;
		this.numeroPlacas=numeroPlacas;
		this.marca=marca;
		this.modelo=modelo;
		this.tipo=tipo;
	}
	
	/**
	 * Instantiates a new auto class DAO.
	 *
	 * @param idauto the idauto
	 * @param n_placas the n placas
	 * @param color the color
	 * @param marca the marca
	 * @param tipo the tipo
	 * @param modelo the modelo
	 * @param observaciones the observaciones
	 */
	public AutoClassDAO(int idauto,String n_placas, String color, String marca, String tipo, String modelo,
			String observaciones) {
		
		this.idauto=idauto;
		this.numeroPlacas = n_placas;
		this.color = color;
		this.marca = marca;
		this.tipo = tipo;
		this.modelo = modelo;
		this.observaciones = observaciones;
	}
	
	/**
	 * Instantiates a new auto class DAO.
	 *
	 * @param n_placas the n placas
	 * @param color the color
	 * @param marca the marca
	 * @param tipo the tipo
	 * @param modelo the modelo
	 * @param observaciones the observaciones
	 */
	public AutoClassDAO(String n_placas, String color, String marca, String tipo, String modelo,
			String observaciones) {
		this.numeroPlacas = n_placas;
		this.color = color;
		this.marca = marca;
		this.tipo = tipo;
		this.modelo = modelo;
		this.observaciones = observaciones;
	}
	
	/**
	 * Gets the cantidad.
	 *
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * Sets the cantidad.
	 *
	 * @param cantidad the new cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Gets the idauto.
	 *
	 * @return the idauto
	 */
	public int getIdauto() {
		return idauto;
	}

	/**
	 * Sets the idauto.
	 *
	 * @param idauto the new idauto
	 */
	public void setIdauto(int idauto) {
		this.idauto = idauto;
	}

	/**
	 * Gets the numero placas.
	 *
	 * @return the numero placas
	 */
	public String getNumeroPlacas() {
		return numeroPlacas;
	}

	/**
	 * Sets the numero placas.
	 *
	 * @param numeroPlacas the new numero placas
	 */
	public void setNumeroPlacas(String numeroPlacas) {
		this.numeroPlacas = numeroPlacas;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Gets the marca.
	 *
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Sets the marca.
	 *
	 * @param marca the new marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the modelo.
	 *
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Sets the modelo.
	 *
	 * @param modelo the new modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Gets the observaciones.
	 *
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * Sets the observaciones.
	 *
	 * @param observaciones the new observaciones
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
