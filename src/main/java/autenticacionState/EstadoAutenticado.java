package autenticacionState;

public class EstadoAutenticado implements EstadoAutenticacion {

    @Override
    public void iniciarSesion() {
        System.out.println("Ya estás autenticado.");
    }

    @Override
    public void accederServicio() {
        if (ContextoAutenticacion.getInstance().getToken() != null) {
            System.out.println("Accediendo a los servicios...");
        } else {
            System.out.println("Token no válido. Cambiando a EstadoSesionExpirada.");
            ContextoAutenticacion.getInstance().setEstadoAutenticacion(new EstadoSesionExpirada());
        }
    }

    @Override
    public void cerrarSesion() {
        System.out.println("Cerrando sesión...");
        ContextoAutenticacion.getInstance().setToken(null);
        ContextoAutenticacion.getInstance().setEstadoAutenticacion(new EstadoNoAutenticado());
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Estado: Autenticado");
    }
}
