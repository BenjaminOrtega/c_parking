package classDao;

import DAO.PersonaDAO;

public class PersonaClassDAO {
	private int frecuencia;
	private int idpersona;
	private String nombre;
	private String apellidos;
	private String email;
	private String telefono;
	private String direccion;
	
	
	public PersonaClassDAO(){
	}
	
	public PersonaClassDAO(int id) {
		this.idpersona=id;
	}
	
	public PersonaClassDAO(int idpersona, String nombre, String apellidos,String telefono,String direccion, String email){
		this.idpersona=idpersona;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.email=email;
		this.telefono=telefono;
		this.direccion=direccion;
	}
	
	
	public PersonaClassDAO(String nombre, String apellido,String telefono,String direccion, String email){
		this.nombre=nombre;
		this.apellidos=apellido;
		this.email=email;
		this.telefono=telefono;
		this.direccion=direccion;
	}
	
	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	
	public int getIdpersona(){
		return idpersona;
	}
	
	public void setIdpersona(int idpersona){
		this.idpersona = idpersona;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	
}
