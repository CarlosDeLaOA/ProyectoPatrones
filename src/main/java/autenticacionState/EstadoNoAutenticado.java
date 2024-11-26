package autenticacionState;

import java.util.Scanner;
import java.util.UUID;

/**
 * Clase que representa el estado de no autenticación. el usuario no tiene acceso a los servicios del sistema
 */
public class EstadoNoAutenticado implements EstadoAutenticacion {

    /**
     * Solicita al usuario su correo y contraseña para intentar iniciar sesión.
     * Si las credenciales son correctas, genera un token de autenticación, muestra un mensaje de éxito y cambia el estado a EstadoAutenticado.
     * Si las credenciales no coinciden, muestra un mensaje de error.
     */
    @Override
    public void iniciarSesion() {
        ContextoAutenticacion contexto = ContextoAutenticacion.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su correo: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        // Verificar si las credenciales coinciden
        if (correo.equals(contexto.getCorreo()) && contrasena.equals(contexto.getContrasena())) {
            String token = UUID.randomUUID().toString(); // Genera un token único
            contexto.setToken(token);
            System.out.println("Usuario autenticado. Token generado: " + token);
            contexto.setEstadoAutenticacion(new EstadoAutenticado());
        } else {
            System.out.println("Credenciales incorrectas. Intente de nuevo.");
        }
    }

    /**
     * Intenta acceder a los servicios, pero el acceso es denegado
     * debido a que el usuario no está autenticado. Muestra un mensaje indicando que el acceso es denegado.
     */
    @Override
    public void accederServicio() {
        System.out.println("Acceso denegado. Usuario no autenticado.");
    }

    /**
     * Intenta cerrar la sesión
     */
    @Override
    public void cerrarSesion() {
        System.out.println("Ya estás sin sesión.");
    }

    /**
     * Muestra el estado actual del usuario como no autenticado.
     */
    @Override
    public void mostrarEstado() {
        System.out.println("Estado: No Autenticado");
    }
}
