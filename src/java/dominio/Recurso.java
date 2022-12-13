/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Ricardo
 */
public class Recurso {
    
    private int idRecurso;
    private int idCurso;
    private int idPractica;
    private String nombre;
    private String recurso;

        public Recurso(int idRecurso, int idCurso, int idPractica, String nombre, String recurso) {
        this.idRecurso = idRecurso;
        this.idCurso = idCurso;
        this.idPractica = idPractica;
        this.nombre = nombre;
        this.recurso = recurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }


    public Recurso() {
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public int getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(int idPractica) {
        this.idPractica = idPractica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
 
    
    
}
