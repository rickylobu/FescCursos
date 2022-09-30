/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.InputStream;
import java.sql.Blob;

/**
 *
 * @author Ricardo
 */
public class Curso {
    
        private int id_Curso;
        private int id_Profesor;
        private String nombre;
        private String descripcion;
        InputStream archivoimg;

    public Curso(int id_Curso, int id_Profesor, String nombre, String descripcion, InputStream archivoimg) {
        this.id_Curso = id_Curso;
        this.id_Profesor = id_Profesor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivoimg = archivoimg;
    }

   

    public Curso() {
    }

    

    public int getId_Curso() {
        return id_Curso;
    }

    public void setId_Curso(int id_Curso) {
        this.id_Curso = id_Curso;
    }

    public int getId_Profesor() {
        return id_Profesor;
    }

    public void setId_Profesor(int id_Profesor) {
        this.id_Profesor = id_Profesor;
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

    public InputStream getArchivoimg() {
        return archivoimg;
    }

    public void setArchivoimg(InputStream archivoimg) {
        this.archivoimg = archivoimg;
    }

     

        
        
}
