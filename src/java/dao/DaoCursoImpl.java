/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Curso;
import dominio.Practica;
import dominio.Usuario;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo
 */
public class DaoCursoImpl extends ConexionClever implements DaoCurso {

    @Override
    public void Registrar(Curso cur) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO `Curso`(`idCurso`, `idProfesor`, `nombre`, `descripcion`,`categoria`, `imagen`) VALUES((?),(?),(?),(?),(?),(?));");
            st.setInt(1, 0);
            st.setInt(2, cur.getId_Profesor());
            st.setString(3, cur.getNombre());
            st.setString(4, cur.getDescripcion());
            st.setString(5, cur.getCategoria());
            st.setString(6, cur.getRutaImg());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public void Modificar(Curso cur) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE `Curso` SET `nombre`=(?),`descripcion`=(?),`categoria`=(?) WHERE  `idCurso`=(?);");
            st.setString(1, cur.getNombre());
            st.setString(2, cur.getDescripcion());
            st.setString(3, cur.getCategoria());
            st.setInt(4, cur.getId_Curso());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public void ModificarImagen(Curso curso) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE `Curso` SET `imagen`=(?) WHERE  `idCurso`=(?);");
            st.setString(1, curso.getRutaImg());
            st.setInt(2, curso.getId_Curso());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public void Eliminar(Curso cur) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM `Curso` WHERE `idCurso`=(?);");
            st.setInt(1, cur.getId_Curso());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public Curso BusCursoXNombre(String nombreCurso) throws Exception {
        Curso cur = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Curso` WHERE `nombre`=(?);");
            st.setString(1, nombreCurso);
            rs = st.executeQuery();

            while (rs.next()) {
                cur = new Curso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return cur;

    }

    @Override
    public List<Curso> ListarTodos() throws Exception {
        List<Curso> lista = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Curso`;");

            lista = new ArrayList();
            rs = st.executeQuery();

            while (rs.next()) {
                Curso cur = new Curso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

                lista.add(cur);

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
    public List<Curso> ListarCursosXidProf(int idProf) throws Exception {
        List<Curso> lista = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Curso` WHERE `idProfesor`= (?);");

            lista = new ArrayList();
            rs = st.executeQuery();

            while (rs.next()) {
                Curso cur = new Curso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

                lista.add(cur);

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
    public boolean PruebaConexion() throws Exception {

        boolean pruebaConexion = false;
        try {
            this.Conectar();

            pruebaConexion = true;
        } catch (Exception e) {
            System.out.println("error al conectar");
        } finally {
            this.Cerrar();
        }
        return pruebaConexion;

    }

    @Override
    public Curso BusCursoXId(int id) throws Exception {
        Curso cur = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Curso` WHERE `idCurso`=(?);");
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                cur = new Curso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return cur;

    }

    @Override
    public String BusImagenSinRuta(Curso curso) throws Exception {
        String img = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT substring(`imagen`,15,100) FROM `Curso` WHERE `idCurso`=(?);");
            st.setInt(1, curso.getId_Curso());
            rs = st.executeQuery();

            while (rs.next()) {
                img = rs.getString(1);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return img;
    }

}
