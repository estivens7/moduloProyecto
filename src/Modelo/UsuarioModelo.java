/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Particular
 */
public class UsuarioModelo {
    private int id_usuario;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rol;
    private String foto_perfil;

    // Constructor vacío
    public UsuarioModelo() {}

    // Constructor con parámetros
    public UsuarioModelo(int id_usuario, String nombre, String correo, String contrasena, String rol, String foto_perfil) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.foto_perfil = foto_perfil;
    }

    // Getters y setters
    public int getId_usuario() { return id_usuario; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getFoto_perfil() { return foto_perfil; }
    public void setFoto_perfil(String foto_perfil) { this.foto_perfil = foto_perfil; }
}
