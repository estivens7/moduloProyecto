/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.*;
import java.util.ArrayList;
import Modelo.UsuarioModelo;
import Connection.DbConnection;
/**
 *
 * @author Particular
 */
public class UsuarioController {
    public void crearUsuario(UsuarioModelo usuario) {
        String sql = "INSERT INTO usuario (nombre, correo_electronico, contrasena, rol, foto_perfil) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DbConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasena());
            stmt.setString(4, usuario.getRol());
            stmt.setString(5, usuario.getFoto_perfil());
            stmt.executeUpdate();
            System.out.println("Usuario creado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e.getMessage());
        }
    }

    public ArrayList<UsuarioModelo> listarUsuarios() {
        ArrayList<UsuarioModelo> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection conn = DbConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                UsuarioModelo usuario = new UsuarioModelo(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("correo_electronico"),
                    rs.getString("contrasena"),
                    rs.getString("rol"),
                    rs.getString("foto_perfil")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    public void actualizarUsuario(int id, UsuarioModelo usuario) {
        String sql = "UPDATE usuario SET nombre=?, correo_electronico=?, contrasena=?, rol=?, foto_perfil=? WHERE id_usuario=?";
        try (Connection conn = DbConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasena());
            stmt.setString(4, usuario.getRol());
            stmt.setString(5, usuario.getFoto_perfil());
            stmt.setInt(6, id);
            stmt.executeUpdate();
            System.out.println("Usuario actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario=?";
        try (Connection conn = DbConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuario eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}

