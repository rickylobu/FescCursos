/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;

/**
 *
 * @author Ricardo
 */
public class Usuario {
    private int id_Usuario;
    private String correo;
    private String contraseña;
    private String nombre;
    private String apellidos;
    private Date fecha_Nac;
    private boolean alumno;
    private boolean profesor;
    private boolean admin;

    public Usuario(int id_Usuario, String correo, String contraseña, String nombre, String apellidos, Date fecha_Nac, boolean alumno, boolean profesor, boolean admin) {
        this.id_Usuario = id_Usuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_Nac = fecha_Nac;
        this.alumno = alumno;
        this.profesor = profesor;
        this.admin = admin;
    }

    public Usuario(int id_Usuario, String correo, String nombre, String apellidos, Date fecha_Nac, boolean alumno, boolean profesor, boolean admin) {
        this.id_Usuario = id_Usuario;
        this.correo = correo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_Nac = fecha_Nac;
        this.alumno = alumno;
        this.profesor = profesor;
        this.admin = admin;
    }

    public Usuario(int id_Usuario, String nombre) {
        this.id_Usuario = id_Usuario;
        this.nombre = nombre;
    }
    
    

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


    

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_Nac() {
        return fecha_Nac;
    }

    public void setFecha_Nac(Date fecha_Nac) {
        this.fecha_Nac = fecha_Nac;
    }

    public boolean isAlumno() {
        return alumno;
    }

    public void setAlumno(boolean alumno) {
        this.alumno = alumno;
    }

    public boolean isProfesor() {
        return profesor;
    }

    public void setProfesor(boolean profesor) {
        this.profesor = profesor;
    }

  
    


}
