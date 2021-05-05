package DAO.Patrones.Decorator;

// TODO: Auto-generated Javadoc
/**
 * Estacionamiento es la clase abstracta 
 * que define la funcionalidad y de la cuál 
 * se hereda la clase concreteEstacionamiento y los decorators.
 * @author laloB
 *
 */
public abstract class Estacionamiento {
	
	/** The frecuencia. */
	private int frecuencia;
	
	/** The id registro. */
	private int idRegistro;
	
	/** The id persona. */
	private int idPersona;
	
	/** The id auto. */
	private int idAuto;
	
	/** The id estacionamiento. */
	private int idEstacionamiento;
	
	/** The hora entrada. */
	private String horaEntrada;
	
	/** The feha entrada. */
	private String fehaEntrada;
	
	/** The hora salida. */
	private String horaSalida;
	
	/** The fecha salida. */
	private String fechaSalida;
	
	/** The costo. */
	private int costo;
	
	/**
	 * Instantiates a new estacionamiento.
	 */
	public Estacionamiento() {
	}
	
	/**
	 * Instantiates a new estacionamiento.
	 *
	 * @param idRegistro the id registro
	 * @param idEstacionamiento the id estacionamiento
	 */
	public Estacionamiento( int idRegistro, int idEstacionamiento) {
		this.idRegistro = idRegistro;
		this.idEstacionamiento = idEstacionamiento;
	}
	
	/**
	 * Instantiates a new estacionamiento.
	 *
	 * @param frecuencia the frecuencia
	 * @param fehaEntrada the feha entrada
	 * @param costo the costo
	 */
	public Estacionamiento(int frecuencia, String fehaEntrada,int costo ) {
		this.frecuencia=frecuencia;
		this.fehaEntrada=fehaEntrada;
		this.costo=costo;
	}
	
	/**
	 * Instantiates a new estacionamiento.
	 *
	 * @param idPersona the id persona
	 * @param idAuto the id auto
	 * @param idEstacionamiento the id estacionamiento
	 * @param costo the costo
	 */
	public Estacionamiento( int idPersona, int idAuto, int idEstacionamiento, int costo) {
		this.idPersona = idPersona;
		this.idAuto = idAuto;
		this.idEstacionamiento = idEstacionamiento;
		this.costo = costo;
	}
	
	/**
	 * Instantiates a new estacionamiento.
	 *
	 * @param idRegistro the id registro
	 * @param idPersona the id persona
	 * @param idAuto the id auto
	 * @param idEstacionamiento the id estacionamiento
	 * @param horaEntrada the hora entrada
	 * @param fehaEntrada the feha entrada
	 * @param horaSalida the hora salida
	 * @param fechaSalida the fecha salida
	 * @param costo the costo
	 */
	public Estacionamiento(int idRegistro, int idPersona, int idAuto, int idEstacionamiento, String horaEntrada,
			String fehaEntrada, String horaSalida, String fechaSalida, int costo) {
		this.idRegistro = idRegistro;
		this.idPersona = idPersona;
		this.idAuto = idAuto;
		this.idEstacionamiento = idEstacionamiento;
		this.horaEntrada = horaEntrada;
		this.fehaEntrada=fehaEntrada;
		this.horaSalida=horaSalida;
		this.fechaSalida=fechaSalida;
		this.costo = costo;
	}
	
	/**
	 * Gets the frecuencia.
	 *
	 * @return the frecuencia
	 */
	public int getFrecuencia() {
		return frecuencia;
	}
	
	/**
	 * Sets the frecuencia.
	 *
	 * @param frecuencia the new frecuencia
	 */
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	
	/**
	 * Gets the id registro.
	 *
	 * @return the id registro
	 */
	public int getIdRegistro() {
		return idRegistro;
	}

	/**
	 * Sets the id registro.
	 *
	 * @param idRegistro the new id registro
	 */
	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	/**
	 * Gets the id persona.
	 *
	 * @return the id persona
	 */
	public int getIdPersona() {
		return idPersona;
	}

	/**
	 * Sets the id persona.
	 *
	 * @param idPersona the new id persona
	 */
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * Gets the id auto.
	 *
	 * @return the id auto
	 */
	public int getIdAuto() {
		return idAuto;
	}

	/**
	 * Sets the id auto.
	 *
	 * @param idAuto the new id auto
	 */
	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}

	/**
	 * Gets the id estacionamiento.
	 *
	 * @return the id estacionamiento
	 */
	public int getIdEstacionamiento() {
		return idEstacionamiento;
	}

	/**
	 * Sets the id estacionamiento.
	 *
	 * @param idEstacionamiento the new id estacionamiento
	 */
	public void setIdEstacionamiento(int idEstacionamiento) {
		this.idEstacionamiento = idEstacionamiento;
	}

	
	/**
	 * Gets the hora entrada.
	 *
	 * @return the hora entrada
	 */
	public String getHoraEntrada() {
		return horaEntrada;
	}
	
	/**
	 * Sets the hora entrada.
	 *
	 * @param horaEntrada the new hora entrada
	 */
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	
	/**
	 * Gets the feha entrada.
	 *
	 * @return the feha entrada
	 */
	public String getFehaEntrada() {
		return fehaEntrada;
	}
	
	/**
	 * Sets the feha entrada.
	 *
	 * @param fehaEntrada the new feha entrada
	 */
	public void setFehaEntrada(String fehaEntrada) {
		this.fehaEntrada = fehaEntrada;
	}
	
	/**
	 * Gets the hora salida.
	 *
	 * @return the hora salida
	 */
	public String getHoraSalida() {
		return horaSalida;
	}
	
	/**
	 * Sets the hora salida.
	 *
	 * @param horaSalida the new hora salida
	 */
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	
	/**
	 * Gets the fecha salida.
	 *
	 * @return the fecha salida
	 */
	public String getFechaSalida() {
		return fechaSalida;
	}
	
	/**
	 * Sets the fecha salida.
	 *
	 * @param fechaSalida the new fecha salida
	 */
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	/**
	 * Gets the costo.
	 *
	 * @return the costo
	 */
	public int getCosto() {
		return costo;
	}

	/**
	 * Sets the costo.
	 *
	 * @param costo the new costo
	 */
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	/**
	 * Agregar.
	 *
	 * @return true, if successful
	 */
	public abstract boolean agregar();
}
