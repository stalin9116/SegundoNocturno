package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String baseDatos;
    private String cadenaConexion;
    private Connection conexion;
    private String servidor;
    private int puerto;

    public Conexion() {
        this.servidor = "localhost";
        this.puerto = 3306;
        this.baseDatos = "login";
        this.cadenaConexion = "jdbc:mysql://" + servidor + ":" + puerto + "/" + baseDatos + "?characterEncoding=utf8&serverTimezone=UTC";
        //this.cadenaConexion = "jdbc:mysql://192.168.10.20:3306/login?characterEncoding=utf8&serverTimezone=UTC";
    }

    public Connection obtenerConexion()
    {
        try {
            conexion = DriverManager.getConnection(this.cadenaConexion, "root", "Sistemas.20");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conexion;
    }
    
    
}
