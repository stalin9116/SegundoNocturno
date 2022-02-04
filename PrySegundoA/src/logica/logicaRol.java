/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Data.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import prysegundoa.Objetos.Rol;
import prysegundoa.Objetos.Usuario;

/**
 *
 * @author stalin
 */
public class logicaRol {

    public logicaRol() {
    }

    public List<Rol> obtenerRoles() {
        //Instanciar mi clase de conexion
        Conexion cn = new Conexion();
        //Abrir conexion a la base de datos
        Connection cc = cn.obtenerConexion();

        String sql = "SELECT rol_codigo, rol_descripcion, rol_status FROM rol ORDER BY rol_descripcion; ";

        System.out.println(sql);

        List<Rol> listaRoles = new ArrayList<>();

        try {

            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int cont = 0;

            while (rs.next()) {
                Rol rol = new Rol();
                rol.setCodigoRol(rs.getInt(1));
                rol.setDescripcion(rs.getString(2));
                rol.setEstado(rs.getString(3));
                listaRoles.add(rol);
                cont++;
            }
            if (cont > 0) {
                return listaRoles;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static Rol obtenerRolesXDescripcion(String descripcion) {
        //Instanciar mi clase de conexion
        Conexion cn = new Conexion();
        //Abrir conexion a la base de datos
        Connection cc = cn.obtenerConexion();

        String sql = "SELECT rol_codigo, rol_descripcion, rol_status FROM rol "
                + "WHERE rol_descripcion='" + descripcion + "'";

        System.out.println(sql);

        Rol rol = new Rol();

        try {

            Statement st = cc.createStatement();
            ResultSet rs = st.executeQuery(sql);

            int cont = 0;

            while (rs.next()) {
                
                rol.setCodigoRol(rs.getInt(1));
                rol.setDescripcion(rs.getString(2));
                rol.setEstado(rs.getString(3));
                cont++;
            }
            if (cont > 0) {
                return rol;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
