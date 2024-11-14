package autenticacionState;

import java.util.Scanner;
import java.util.UUID;

public class EstadoNoAutenticado implements EstadoAutenticacion {

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

    @Override
    public void accederServicio() {
        System.out.println("Acceso denegado. Usuario no autenticado.");
    }

    @Override
    public void cerrarSesion() {
        System.out.println("Ya estás sin sesión.");
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Estado: No Autenticado");
    }
}
