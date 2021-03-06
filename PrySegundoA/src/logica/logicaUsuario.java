package logica;

import Data.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import prysegundoa.Objetos.Rol;
import prysegundoa.Objetos.Usuario;

public class logicaUsuario {

    public logicaUsuario() {

    }

    public Usuario obtenerUsuariosLogin(String correo, String clave) {
        //Instanciar mi clase de conexion
        Conexion cn = new Conexion();
        //Abrir conexion a la base de datos
        Connection cc = cn.obtenerConexion();

        String sql = "SELECT usu_codigo, usu_correo, usu_clave, usu_nombres, usu_apellidos "
                + "FROM usuario "
                + "WHERE usu_correo='" + correo + "' "
                + "AND usu_clave='" + clave + "' AND usu_status='A';";

        System.out.println(sql);

        Usuario usuario = new Usuario();

        try {

            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int cont = 0;

            while (rs.next()) {
                usuario.modificarCodigo(rs.getInt(1));
                usuario.modificarCorreo(rs.getString(2));
                usuario.modificarClave(rs.getString(3));
                usuario.modificarNombre(rs.getString(4));
                usuario.modificarApellido(rs.getString(5));
                cont++;
            }
            if (cont > 0) {
                return usuario;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public Usuario obtenerUsuariosLoginRol(String correo, String clave) {
        //Instanciar mi clase de conexion
        Conexion cn = new Conexion();
        //Abrir conexion a la base de datos
        Connection cc = cn.obtenerConexion();

        String sql = "SELECT usu_codigo, usu_correo, usu_clave, usu_nombres, usu_apellidos, rol_descripcion "
                + "FROM usuario u inner join rol r on u.rol_codigo=r.rol_codigo "
                + "WHERE usu_correo='" + correo + "' "
                + "AND usu_clave='" + clave + "' AND usu_status='A';";

        System.out.println(sql);

        Usuario usuario = new Usuario();

        try {

            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int cont = 0;

            while (rs.next()) {
                usuario.modificarCodigo(rs.getInt(1));
                usuario.modificarCorreo(rs.getString(2));
                usuario.modificarClave(rs.getString(3));
                usuario.modificarNombre(rs.getString(4));
                usuario.modificarApellido(rs.getString(5));
                Rol rol = new Rol();
                rol.setDescripcion(rs.getString(6));
                usuario.setRol(rol);

                //usuario.setRol(new Rol(1, rs.getString(6)));
                cont++;
            }
            if (cont > 0) {
                return usuario;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<Usuario> obtenerUsuariosActivos() {
        //Instanciar mi clase de conexion
        Conexion cn = new Conexion();
        //Abrir conexion a la base de datos
        Connection cc = cn.obtenerConexion();

        String sql = "SELECT usu_codigo, usu_correo, usu_clave, usu_nombres, usu_apellidos, usu_status "
                + "FROM usuario "
                + "WHERE usu_status='A';";

        System.out.println(sql);

        List<Usuario> listaUsuario = new ArrayList<>();

        try {

            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int cont = 0;

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.modificarCodigo(rs.getInt(1));
                usuario.modificarCorreo(rs.getString(2));
                usuario.modificarClave(rs.getString(3));
                usuario.modificarNombre(rs.getString(4));
                usuario.modificarApellido(rs.getString(5));
                usuario.modificarEstado(rs.getString(6));
                listaUsuario.add(usuario);
                cont++;
            }
            if (cont > 0) {
                return listaUsuario;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<Usuario> obtenerUsuariosActivosRol() {
        //Instanciar mi clase de conexion
        Conexion cn = new Conexion();
        //Abrir conexion a la base de datos
        Connection cc = cn.obtenerConexion();

        String sql = "SELECT usu_codigo, usu_correo, usu_clave, usu_nombres, usu_apellidos, usu_status, rol_descripcion "
                + "FROM usuario u INNER JOIN rol r on u.rol_codigo=r.rol_codigo "
                + "WHERE usu_status='A';";

        System.out.println(sql);

        List<Usuario> listaUsuario = new ArrayList<>();

        try {

            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int cont = 0;

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.modificarCodigo(rs.getInt(1));
                usuario.modificarCorreo(rs.getString(2));
                usuario.modificarClave(rs.getString(3));
                usuario.modificarNombre(rs.getString(4));
                usuario.modificarApellido(rs.getString(5));
                usuario.modificarEstado(rs.getString(6));
                usuario.setRol(new Rol(0, rs.getString(7)));
                
                listaUsuario.add(usuario);
                cont++;
            }
            if (cont > 0) {
                return listaUsuario;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    
    public static List<Usuario> obtenerUsuariosActivosXNombres(String nombres) {
        //Instanciar mi clase de conexion
        Conexion cn = new Conexion();
        //Abrir conexion a la base de datos
        Connection cc = cn.obtenerConexion();

        String sql = "SELECT usu_codigo, usu_correo, usu_clave, usu_nombres, usu_apellidos, usu_status, rol_descripcion "
                + "FROM usuario u INNER JOIN rol r on u.rol_codigo=r.rol_codigo "
                + "WHERE usu_status='A'"
                + "AND usu_nombres like '"+nombres+"%';";

        System.out.println(sql);

        List<Usuario> listaUsuario = new ArrayList<>();

        try {

            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int cont = 0;

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.modificarCodigo(rs.getInt(1));
                usuario.modificarCorreo(rs.getString(2));
                usuario.modificarClave(rs.getString(3));
                usuario.modificarNombre(rs.getString(4));
                usuario.modificarApellido(rs.getString(5));
                usuario.modificarEstado(rs.getString(6));
                usuario.setRol(new Rol(0, rs.getString(7)));
                
                listaUsuario.add(usuario);
                cont++;
            }
            if (cont > 0) {
                return listaUsuario;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean guardarUsuario(Usuario datosUsuario) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.obtenerConexion();

            datosUsuario.modificarEstado("A");

            String sql = "INSERT INTO usuario(usu_correo, usu_clave, usu_apellidos, usu_nombres, usu_status, rol_codigo) "
                       + "VALUES(?, ?, ?, ?, ?, ?);";

            PreparedStatement pst = cc.prepareStatement(sql);
            pst.setString(1, datosUsuario.obtenerCorreo());
            pst.setString(2, datosUsuario.obtenerClave());
            pst.setString(3, datosUsuario.obtenerApellido());
            pst.setString(4, datosUsuario.obtenerNombre());
            pst.setString(5, datosUsuario.obtenerEstado());
            pst.setInt(6, datosUsuario.getRol().getCodigoRol());

            int rows = pst.executeUpdate();
            return rows > 0;

        } catch (SQLException ex) {
               System.out.println(ex.getMessage());  
               return false;
        }
    }

    public boolean modificarUsuario(Usuario datosUsuario) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.obtenerConexion();

            String sql = "UPDATE usuario SET usu_correo=?, usu_clave=?, usu_apellidos=?, usu_nombres=?, rol_codigo=? "
                       + "WHERE usu_codigo=?;";

            PreparedStatement pst = cc.prepareStatement(sql);
            
            pst.setString(1, datosUsuario.obtenerCorreo());
            pst.setString(2, datosUsuario.obtenerClave());
            pst.setString(3, datosUsuario.obtenerApellido());
            pst.setString(4, datosUsuario.obtenerNombre());
            pst.setInt(5, datosUsuario.getRol().getCodigoRol());
            pst.setInt(6, datosUsuario.obtenerCodigo());

            int rows = pst.executeUpdate();
            return rows > 0;

        } catch (SQLException ex) {
               System.out.println(ex.getMessage());  
               return false;
        }
    }
    
    //Eliminar Logica
    public boolean eliminarUsuarioLogica(int codigoUsuario) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.obtenerConexion();

            String sql = "UPDATE usuario SET usu_status='I' "
                       + "WHERE usu_codigo=?;";

            PreparedStatement pst = cc.prepareStatement(sql);
            
            pst.setInt(1, codigoUsuario);

            int rows = pst.executeUpdate();
            return rows > 0;

        } catch (SQLException ex) {
               System.out.println(ex.getMessage());  
               return false;
        }
    }
    
    //Eliminar Logica
    public boolean eliminarUsuarioFisica(int codigoUsuario) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.obtenerConexion();

            String sql = "DELETE FROM usuario "
                       + "WHERE usu_codigo=?;";

            PreparedStatement pst = cc.prepareStatement(sql);
            
            pst.setInt(1, codigoUsuario);

            int rows = pst.executeUpdate();
            return rows > 0;

        } catch (SQLException ex) {
               System.out.println(ex.getMessage());  
               return false;
        }
    }
    
}
