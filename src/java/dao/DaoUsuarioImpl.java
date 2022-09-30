/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Usuario;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class DaoUsuarioImpl extends ConexionClever implements DaoUsuario {

    @Override
    public void Registrar(Usuario usr) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO `Usuario`(`idUsuario`, `correo`, `contraseña`, `nombre`, `apellidos`, `fechaNac`, `alumno`, `profesor`) VALUES ((?),(?),(?),(?),(?),(?),(?),(?));");
            st.setInt(1, 0);
            st.setString(2, usr.getCorreo());
            st.setString(3, usr.getContraseña());
            st.setString(4, usr.getNombre());
            st.setString(5, usr.getApellidos());

            java.util.Date date = usr.getFecha_Nac();
            long timeInMilliSeconds = date.getTime();
            java.sql.Date datesql = new java.sql.Date(timeInMilliSeconds);
            st.setDate(6, datesql);

            int alumno;
            int prof;
            if (usr.isProfesor()) {
                alumno = 0;
                prof = 1;

            } else {
                alumno = 1;
                prof = 0;
            }
            st.setInt(7, alumno);
            st.setInt(8, prof);

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public void Modificar(Usuario usr) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE `Usuario` SET `correo`= ?, `contraseña`= ?, `nombre`= ?, `apellidos`= ?, `fechaNac`= ?, `alumno`= ?, `profesor`= ? WHERE `idUsuario`= ?;");
            st.setString(1, usr.getCorreo());
            st.setString(2, usr.getContraseña());
            st.setString(3, usr.getNombre());
            st.setString(4, usr.getApellidos());

            java.util.Date date = usr.getFecha_Nac();
            long timeInMilliSeconds = date.getTime();
            java.sql.Date datesql = new java.sql.Date(timeInMilliSeconds);
            st.setDate(5, datesql);

            int alumno;
            int prof;
            if (usr.isProfesor()) {
                alumno = 0;
                prof = 1;

            } else {
                alumno = 1;
                prof = 0;
            }
            st.setInt(6, alumno);
            st.setInt(7, prof);
            st.setInt(8, usr.getId_Usuario());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public void Eliminar(Usuario usr) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM `Usuario` WHERE `idUsuario`=(?);");
            //DELETE FROM `usuarios` WHERE `id_usuario`=4             
            st.setInt(1, usr.getId_Usuario());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public Usuario BusUsuarioXId(int id) throws Exception {
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Usuario` WHERE `idUsuario`=(?);");
        //SELECT * FROM `usuarios` WHERE `id_usuario`= 4;            
        Usuario usr = null;
        try {
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                usr = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getBoolean(7), rs.getBoolean(8));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return usr;

    }

    @Override
    public Usuario BusUsuarioXCorreo(String correo) throws Exception {
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Usuario` WHERE `correo`=(?);");
        //SELECT * FROM `usuarios` WHERE `id_usuario`= 4;            
        Usuario usr = null;
        try {
            st.setString(1, correo);
            rs = st.executeQuery();

            while (rs.next()) {
                usr = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getBoolean(7), rs.getBoolean(8));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return usr;

    }

    @Override
    public Usuario BusUsuarioXNombre(String nombre) throws Exception {

        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Usuario` WHERE `nombre`=(?);");
        //SELECT * FROM `usuarios` WHERE `id_usuario`= 4;            
        Usuario usr = null;
        try {
            st.setString(1, nombre);
            rs = st.executeQuery();

            while (rs.next()) {
                usr = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getBoolean(7), rs.getBoolean(8));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return usr;

    }

    @Override
    public List<Usuario> ListarTodos() throws Exception {

        List<Usuario> lista = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Usuario`;");

            lista = new ArrayList();
            rs = st.executeQuery();

            while (rs.next()) {
                Usuario usr = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getBoolean(7), rs.getBoolean(8));

                lista.add(usr);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return lista;

    }

    @Override
    public List<Usuario> ListarAlumnos() throws Exception {

        List<Usuario> lista = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Usuario` WHERE `alumno`= 1;");

            lista = new ArrayList();
            rs = st.executeQuery();

            while (rs.next()) {
                Usuario usr = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getBoolean(7), rs.getBoolean(8));

                lista.add(usr);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return lista;

    }

    @Override
    public List<Usuario> ListarProfesores() throws Exception {

        List<Usuario> lista = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Usuario` WHERE `profesor`= 1;");

            lista = new ArrayList();
            rs = st.executeQuery();

            while (rs.next()) {
                Usuario usr = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getBoolean(7), rs.getBoolean(8));

                lista.add(usr);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return lista;

    }

}
