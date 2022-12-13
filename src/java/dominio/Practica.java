/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Ricardo
 */
public class Practica {
    private int id_Practica;
        private int id_Curso;
        private int numeroPrac;
        private String nombre;
        private String descripcion;
        private String link_Video;

    public Practica(int id_Practica, int id_Curso, int numeroPrac, String nombre, String descripcion, String link_Video) {
        this.id_Practica = id_Practica;
        this.id_Curso = id_Curso;
        this.numeroPrac = numeroPrac;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.link_Video = link_Video;
    }

    public int getNumeroPrac() {
        return numeroPrac;
    }

    public void setNumeroPrac(int numeroPrac) {
        this.numeroPrac = numeroPrac;
    }

   

    public int getId_Practica() {
        return id_Practica;
    }

    public void setId_Practica(int id_Practica) {
        this.id_Practica = id_Practica;
    }

    public int getId_Curso() {
        return id_Curso;
    }

    public void setId_Curso(int id_Curso) {
        this.id_Curso = id_Curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink_Video() {
        return link_Video;
    }

    public void setLink_Video(String link_Video) {
        this.link_Video = link_Video;
    }

        
        
}
