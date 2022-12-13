
package dao;

import dominio.Practica;
import dominio.Recurso;
import dominio.Usuario;
import java.util.List;


public interface DaoPractica {
    public void Registrar (Practica prac)throws Exception;
    public void Modificar (Practica prac)throws Exception;
    public void Eliminar (Practica prac)throws Exception;
    public Practica BusPracticaXId(int id)throws Exception;
    public Practica BusPracticaXNombre(String nombre)throws Exception;
    public List<Practica> ListarPracticasXidCurso(int idCurso)throws Exception;
    public void RegistrarRecurso (Recurso recurso) throws Exception;
    public void EliminarRecurso (Recurso recurso) throws Exception;
    public List<Recurso> BusRecursosXIdPractica (int idPractica) throws Exception;
    public int getNumeroPrac (int idCurso) throws Exception;
    public Recurso BusRecursoXId (int idRecurso) throws Exception;
    public String BusRecursoSinRuta (Recurso recurso) throws Exception;
}
