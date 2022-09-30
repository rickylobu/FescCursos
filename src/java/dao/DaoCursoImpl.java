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
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO `Curso`(`idCurso`, `idProfesor`, `nombre`, `descripcion`, `imagen`) VALUES((?),(?),(?),(?),(?));");
            st.setInt(1, 0);
            st.setInt(2, cur.getId_Profesor());
            st.setString(3, cur.getNombre());
            st.setString(4, cur.getDescripcion());
            st.setBlob(5, cur.getArchivoimg());

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
            PreparedStatement st = this.conexion.prepareStatement("UPDATE `Curso` SET `idProfesor`=(?),`nombre`=(?),`descripcion`=(?) WHERE  `idCurso`=(?));");
            st.setInt(1, cur.getId_Profesor());
            st.setString(2, cur.getNombre());
            st.setString(3, cur.getDescripcion());
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
            PreparedStatement st = this.conexion.prepareStatement("UPDATE `Curso` SET `imagen`=(?) WHERE  `idCurso`=(?));");
            st.setBlob(1, curso.getArchivoimg());
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
    public Curso BusCursoXId(int id) throws Exception {
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Curso` WHERE `idCurso`=(?);");
        st.setInt(1, id);
        Curso cur = null;
        try {

            rs = st.executeQuery();

            while (rs.next()) {
                cur = new Curso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBinaryStream(5));
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
    public Curso BusCursoXNombre(String nombreCurso) throws Exception {
        this.Conectar();
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Curso` WHERE `nombre`=(?);");
        st.setString(1, nombreCurso);
        Curso cur = null;
        try {

            rs = st.executeQuery();

            while (rs.next()) {
                cur = new Curso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBinaryStream(5));
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
                Curso cur = new Curso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBinaryStream(5));

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
                Curso cur = new Curso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getBinaryStream(5));

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
    public void ListarImagen(int id, HttpServletResponse response) throws Exception {
         
        InputStream inputStream =null;
        OutputStream outputStream =null;
        BufferedInputStream bufferedinputStream =null;
        BufferedOutputStream bufferedoutputStream =null;
        response.setContentType("image/*");
               
        PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Curso` WHERE `idCurso`=(?);");
        st.setInt(1, id);
        Curso cur = null;
        try {
        this.Conectar();
        outputStream =response.getOutputStream();
        
            rs = st.executeQuery();

            if (rs.next()) {
                inputStream =rs.getBinaryStream(5);
            }
            bufferedinputStream = new BufferedInputStream(inputStream);
            bufferedoutputStream = new BufferedOutputStream(outputStream);
            int i=0;
            while ((i=bufferedinputStream.read())!=-1){
                bufferedoutputStream.write(i);
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        



    }

}
