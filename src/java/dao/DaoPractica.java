
package dao;

import dominio.Practica;
import dominio.Usuario;
import java.util.List;


public interface DaoPractica {
    public void Registrar (Practica prac)throws Exception;
    public void Modificar (Practica prac)throws Exception;
    public void Eliminar (Practica prac)throws Exception;
    public Practica BusPracticaXId(int id)throws Exception;
    public Practica BusPracticaXNombre(String nombre)throws Exception;
    public List<Practica> ListarPracticasXidCurso()throws Exception;
}
