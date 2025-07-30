package javaapplication1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import Controller.UsuarioController;
import Modelo.UsuarioModelo;


public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UsuarioController controller = new UsuarioController();

        // Crear usuario
        UsuarioModelo nuevo = new UsuarioModelo(123456, "Mario Luna", "mario@gmail.com", "clave123", "estudiante", "mario.jpg");
        controller.crearUsuario(nuevo);

        // Listar usuarios
        System.out.println("Lista de usuarios:");
        ArrayList<UsuarioModelo> usuarios = controller.listarUsuarios();
        for (UsuarioModelo u : usuarios) {
            System.out.println(u.getId_usuario() + " | " + u.getNombre() + " | " + u.getCorreo());
        }

        // Actualizar usuario (id 1)
        UsuarioModelo actualizado = new UsuarioModelo(123456, "Mario Actualizado", "mario_nuevo@gmail.com", "nuevaclave", "profesor", "nueva.jpg");
        controller.actualizarUsuario(1, actualizado);

        // Eliminar usuario (id 2)
        controller.eliminarUsuario(2);
    }

}
