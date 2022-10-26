
package dao;

import dominio.Usuario;
import java.util.List;

public interface DaoUsuario {
    
    public void Registrar (Usuario usr)throws Exception;
    public void Modificar (Usuario usr)throws Exception;
    public void Eliminar (Usuario usr)throws Exception;
    public Usuario BusUsuarioXId(int id)throws Exception;
    public Usuario BusUsuarioXCorreo(String correo)throws Exception;
    public Usuario BusUsuarioXNombre(String nombre)throws Exception;
    public List<Usuario> ListarTodos()throws Exception;
    public List<Usuario> ListarAlumnos()throws Exception;
    public List<Usuario> ListarProfesores()throws Exception;
    public String GetMD5 (String input) throws Exception;
    public void HacerProfesor (Usuario usr)throws Exception;
    public void HacerAdmin (Usuario usr)throws Exception;
}
