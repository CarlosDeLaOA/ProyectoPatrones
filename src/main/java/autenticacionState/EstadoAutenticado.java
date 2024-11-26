package autenticacionState;

/**
 * Clase que representa el estado de autenticación autenticado.
 * En este estado, el usuario tiene acceso a los servicios del sistema
 */
public class EstadoAutenticado implements EstadoAutenticacion {

    /**
     * Maneja el intento de iniciar sesión cuando el usuario ya está autenticado.
     */
    @Override
    public void iniciarSesion() {
        System.out.println("Ya estás autenticado.");
    }

    /**
     * Permite el acceso a los servicios si el token de autenticación es válido.
     *
     */
    @Override
    public void accederServicio() {
        if (ContextoAutenticacion.getInstance().getToken() != null) {
            System.out.println("Accediendo a los servicios...");
        } else {
            System.out.println("Token no válido. Cambiando a EstadoSesionExpirada.");
            ContextoAutenticacion.getInstance().setEstadoAutenticacion(new EstadoSesionExpirada());
        }
    }

    /**
     * Cierra la sesión actual del usuario.
     * Elimina el token de autenticación y cambia el estado a EstadoNoAutenticado.
     */
    @Override
    public void cerrarSesion() {
        System.out.println("Cerrando sesión...");
        ContextoAutenticacion.getInstance().setToken(null);
        ContextoAutenticacion.getInstance().setEstadoAutenticacion(new EstadoNoAutenticado());
    }

    /**
     * Muestra el estado actual del usuario como autenticado.
     */
    @Override
    public void mostrarEstado() {
        System.out.println("Estado: Autenticado");
    }
}
