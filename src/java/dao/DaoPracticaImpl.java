/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dominio.Practica;
import dominio.Recurso;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class DaoPracticaImpl extends ConexionClever implements DaoPractica {

    @Override
    public void Registrar(Practica prac) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO `Practica` (`idPractica`, `idCurso`, `numeroPrac`, `nombre`, `descripcion`, `linkVideo`) VALUES ((?),(?),(?),(?),(?),(?));");
            st.setInt(1, 0);
            st.setInt(2, prac.getId_Curso());
            st.setInt(3, prac.getNumeroPrac());
            st.setString(4, prac.getNombre());
            st.setString(5, prac.getDescripcion());
            st.setString(6, prac.getLink_Video());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void Modificar(Practica prac) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE `Practica` SET `numeroPrac`=(?),`nombre`=(?),`descripcion`=(?),`linkVideo`=(?) WHERE `idPractica`=(?);");
            st.setInt(1, prac.getNumeroPrac());
            st.setString(2, prac.getNombre());
            st.setString(3, prac.getDescripcion());
            st.setString(4, prac.getLink_Video());
            st.setInt(5, prac.getId_Practica());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void Eliminar(Practica prac) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM `Practica` WHERE `idPractica`=(?);");
            st.setInt(1, prac.getId_Practica());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public Practica BusPracticaXId(int id) throws Exception {
        Practica prac = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Practica` WHERE `idPractica`=(?);");
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                prac = new Practica(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return prac;
    }

    @Override
    public Practica BusPracticaXNombre(String nombre) throws Exception {
        Practica practica = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Practica` WHERE LOWER(`nombre`) LIKE LOWER('%" + nombre + "%');");
            rs = st.executeQuery();
            while (rs.next()) {
                practica = new Practica(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return practica;
    }

    @Override
    public List<Practica> ListarPracticasXidCurso(int idCurso) throws Exception {
        List<Practica> lista = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Practica` WHERE `idCurso`=(?) ORDER BY `numeroPrac`;");
            st.setInt(1, idCurso);

            lista = new ArrayList();
            rs = st.executeQuery();

            while (rs.next()) {
                Practica prac = new Practica(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));

                lista.add(prac);
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
    public void RegistrarRecurso(Recurso recurso) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO `Recurso` (`idRecurso`, `idCurso`, `idPractica`, `nombre`, `recurso`) VALUES ((?),(?),(?),(?),(?));");
            st.setInt(1, 0);
            st.setInt(2, recurso.getIdCurso());
            st.setInt(3, recurso.getIdPractica());
            st.setString(4, recurso.getNombre());
            st.setString(5, recurso.getRecurso());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void EliminarRecurso(Recurso recurso) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM `Recurso` WHERE `idRecurso`=(?);");
            st.setInt(1, recurso.getIdRecurso());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Recurso> BusRecursosXIdPractica(int idPractica) throws Exception {
        List<Recurso> lista = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Recurso` WHERE `idPractica`=(?);");
            st.setInt(1, idPractica);

            lista = new ArrayList();
            rs = st.executeQuery();

            while (rs.next()) {
                Recurso recurso = new Recurso(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));

                lista.add(recurso);
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
    public int getNumeroPrac(int idCurso) throws Exception {

        int ultimaPrac = 0;
        int nuevaPrac = 0;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT MAX(`numeroPrac`) FROM `Practica` WHERE `idCurso`=(?);");
            st.setInt(1, idCurso);

            rs = st.executeQuery();

            if (rs == null) {
                nuevaPrac = 1;
            } else {
                while (rs.next()) {
                    ultimaPrac = rs.getInt(1);
                    ultimaPrac++;
                    nuevaPrac = ultimaPrac;
                }
            }

            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return nuevaPrac;

    }

    @Override
    public String BusRecursoSinRuta(Recurso rec) throws Exception {
         String recurso = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT substring(`recurso`,10,100) FROM `Recurso` WHERE `idRecurso`=(?);");
            st.setInt(1, rec.getIdRecurso());
            rs = st.executeQuery();

            while (rs.next()) {
                recurso = rs.getString(1);

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return recurso;


    }

    @Override
    public Recurso BusRecursoXId(int idRecurso) throws Exception {
        Recurso recurso = null;

        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM `Recurso` WHERE `idRecurso`=(?);");
            st.setInt(1, idRecurso);

            rs = st.executeQuery();

            while (rs.next()) {
                recurso = new Recurso(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));

            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return recurso;    }

}
