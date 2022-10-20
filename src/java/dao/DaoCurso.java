
package dao;

import dominio.Curso;
import java.util.List;


public interface DaoCurso {
    public void Registrar (Curso cur)throws Exception;
    public void Modificar (Curso cur)throws Exception;
    public void ModificarImagen (Curso cur)throws Exception;
    public void Eliminar (Curso cur)throws Exception;
    public Curso BusCursoXId(int id)throws Exception;
    public Curso BusCursoXNombre(String nombreCurso)throws Exception;
    public List<Curso> ListarTodos()throws Exception;
    public List<Curso> ListarCursosXidProf(int idProf)throws Exception;
    public boolean PruebaConexion() throws Exception;
    public String BusImagenSinRuta(Curso cur) throws Exception;
}
