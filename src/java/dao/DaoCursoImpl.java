/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Curso;
import dominio.MisCursos;
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
            PreparedStatement st = this.conexion.prepareStatement("SELECT idCurso, idProfesor, Curso.nombre, descripcion, categoria, imagen, Usuario.nombre AS nombreProfesor, Usuario.apellidos FROM Curso INNER JOIN Usuario ON Curso.idProfesor =Usuario.idUsuario ORDER BY Curso.nombre AND Usuario.nombre ;");

            lista = new ArrayList();
            rs = st.executeQuery();

            while (rs.next()) {
                Curso cur = new Curso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7) + " " + rs.getString(8));

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
            st.setInt(1, idProf);

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
            PreparedStatement st = this.conexion.prepareStatement("SELECT idCurso, idProfesor, Curso.nombre, descripcion, categoria, imagen, Usuario.nombre AS nombreProfesor, Usuario.apellidos FROM Curso INNER JOIN Usuario ON Curso.idProfesor =Usuario.idUsuario WHERE Curso.idCurso=(?) ORDER BY Curso.nombre AND Usuario.nombre ;");
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                cur = new Curso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7) + " " + rs.getString(8));

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

    @Override
    public List<Curso> BusCursosXMisCursos(List<MisCursos> misCursos) throws Exception {

        List<Curso> CursosAlumno = null;
        try {
            this.Conectar();
            CursosAlumno = new ArrayList();
            for (MisCursos curTemp : misCursos) {
                PreparedStatement st = this.conexion.prepareStatement("SELECT idCurso, idProfesor, Curso.nombre, descripcion, categoria, imagen, Usuario.nombre AS nombreProfesor, Usuario.apellidos FROM Curso INNER JOIN Usuario ON Curso.idProfesor =Usuario.idUsuario WHERE Curso.idCurso=(?) ORDER BY Curso.nombre AND Usuario.nombre;");
                st.setInt(1, curTemp.getIdCurso());
                rs = st.executeQuery();

                while (rs.next()) {
                    Curso cur2 = new Curso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7) + " " + rs.getString(8));
                    CursosAlumno.add(cur2);
                }
                rs.close();
                st.close();
            }
            return CursosAlumno;

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public List<MisCursos> MisCursos(int idAlumno) throws Exception {

        List<MisCursos> misCursos = null;
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT `idUsuario`, `idCurso` FROM `MisCursos` WHERE idUsuario=(?);");
            st.setInt(1, idAlumno);
            rs = st.executeQuery();

            misCursos = new ArrayList();
            while (rs.next()) {
                MisCursos cur = new MisCursos(rs.getInt(1), rs.getInt(2));
                misCursos.add((MisCursos) cur);
            }
            rs.close();
            st.close();
            return misCursos;

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public void AgregarMisCursos(int idAlumno, int idCurso) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO `MisCursos` (`idUsuario`, `idCurso`) VALUES((?),(?));");
            st.setInt(1, idAlumno);
            st.setInt(2, idCurso);

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public boolean ExisteMisCursos(int idAlumno, int idCurso) throws Exception {
        boolean existe = false;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `MisCursos` WHERE `idUsuario`=(?) AND `idCurso`=(?);");
            st.setInt(1, idAlumno);
            st.setInt(2, idCurso);
            rs = st.executeQuery();

            if (rs.next()) {
                existe = true;
                rs.close();
                st.close();
                return existe;
            } else {
                existe = false;
                rs.close();
                st.close();
                return existe;
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public void EliminarMisCursos(int idAlumno, int idCurso) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM `MisCursos` WHERE `idUsuario`=(?) AND `idCurso`=(?);");
            st.setInt(1, idAlumno);
            st.setInt(2, idCurso);
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

}
