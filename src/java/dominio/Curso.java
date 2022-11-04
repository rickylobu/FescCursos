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
        private String categoria;
        private String rutaImg;
        
        private String nombreProf;
        

    public Curso(int id_Curso, int id_Profesor, String nombre, String descripcion, String categoria, String rutaImg) {
        this.id_Curso = id_Curso;
        this.id_Profesor = id_Profesor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.rutaImg = rutaImg;
    }

    public Curso(int id_Curso, int id_Profesor, String nombre, String descripcion, String categoria, String rutaImg, String nombreProf) {
        this.id_Curso = id_Curso;
        this.id_Profesor = id_Profesor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.rutaImg = rutaImg;
        this.nombreProf = nombreProf;
    }

    

    
    
    public String getNombreProf() {
        return nombreProf;
    }

    public void setNombreProf(String nombreProf) {
        this.nombreProf = nombreProf;
    }

    public Curso() {
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }

    
        
        
}
