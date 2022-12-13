
package dao;

import dominio.Curso;
import dominio.MisCursos;
import java.util.List;


public interface DaoCurso {
    public void Registrar (Curso cur)throws Exception;
    public void Modificar (Curso cur)throws Exception;
    public void ModificarImagen (Curso cur)throws Exception;
    public void Eliminar (Curso cur)throws Exception;
    public Curso BusCursoXId(int id)throws Exception;
    public List<Curso> BusCursoXNombre(String nombreCurso)throws Exception;
    public List<Curso> BusCursoXCategoria(String categoria)throws Exception;
    public List<Curso> ListarTodos()throws Exception;
    public List<Curso> ListarCursosXidProf(int idProf)throws Exception;
    public boolean PruebaConexion() throws Exception;
    public String BusImagenSinRuta(Curso cur) throws Exception;
    public List<MisCursos> MisCursos (int idAlumno) throws Exception;
    public List<Curso> BusCursosXMisCursos (List<MisCursos> misCursos) throws Exception;
    public void AgregarMisCursos (int idAlumno, int idCurso) throws Exception;
    public boolean ExisteMisCursos (int idAlumno, int idCurso) throws Exception;
    public void EliminarMisCursos (int idAlumno, int idCurso)throws Exception;
    public List<String> Categorias () throws Exception;
}
