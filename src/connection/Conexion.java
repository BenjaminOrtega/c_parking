package connection;

import java.sql.Connection;
import java.sql.DriverManager;

// TODO: Auto-generated Javadoc
/**
 * The Class Conexion.
 */
public class Conexion {
	
	/** The conn. */
	private static Connection conn;
	
	/** The url. */
	private static String url;
	
	/** The usuario. */
	private static String usuario;
	
	/** The password. */
	private static String password;
	
	/**
	 * Instantiates a new conexion.
	 */
	private Conexion() {
		url="jdbc:postgresql://localhost:5432/car_parking";
	    usuario="postgres";
	    password="123456";
		try{
            Class.forName("org.postgresql.Driver");
            conn=(Connection) DriverManager.getConnection(url,usuario,password);
        }catch(Exception e){
        e.printStackTrace();
        System.out.println(e);
        }
         
	}//

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public static Connection getConnection(){
		
		if(conn==null){
			new Conexion();
			
		}
		return conn;
	}
	
	/**
	 * Gets the connection close.
	 *
	 * @return the connection close
	 */
	public static Connection getConnectionClose(){
		conn=null;
		return conn;
	}
}
