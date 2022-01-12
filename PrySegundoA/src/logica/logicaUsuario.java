package logica;

import Data.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import prysegundoa.Objetos.Usuario;

public class logicaUsuario {

    public logicaUsuario() {

    }

    public Usuario obtenerUsuariosLogin(String correo, String clave) {
        //Instanciar mi clase de conexion
        Conexion cn = new Conexion();
        //Abrir conexion a la base de datos
        Connection cc = cn.obtenerConexion();

        String sql = "SELECT usu_codigo, usu_correo, usu_clave, usu_nombres, usu_apellidos, usu_status "
                + "FROM usuario "
                + "WHERE usu_correo='" + correo + "'"
                + "AND usu_clave='" + clave + "' AND usu_status='A'";
        
        Usuario usuario = new Usuario();
        
        try {
            
            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {                
                usuario.modificarCorreo(rs.getString(2));
                usuario.modificarClave(rs.getString(3));
                usuario.modificarNombre(rs.getString(4));
                usuario.modificarApellido(rs.getString(5));
            }
            return usuario;
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
