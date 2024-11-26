package autenticacionState;

public class EstadoSesionExpirada implements EstadoAutenticacion{


    /**
     * Metodo para iniciar sesion
     */
    @Override
    public void iniciarSesion() {
        System.out.println("Porfavor, vuelva a iniciar sesión");
        ContextoAutenticacion.getInstance().setEstadoAutenticacion(new EstadoNoAutenticado());

    }

    /**
     * Metodo para acceder al servicio
     */
    @Override
    public void accederServicio() {
        System.out.println("Sesion expirada");
        ContextoAutenticacion.getInstance().setEstadoAutenticacion(new EstadoNoAutenticado());

    }

    /**
     * Metodo para cerrar Sesion
     */
    @Override
    public void cerrarSesion() {
        System.out.println("Sesion cerrada");
        ContextoAutenticacion.getInstance().setEstadoAutenticacion(new EstadoNoAutenticado());

    }

    /**
     * Metodo para mostrar estado
     */

    @Override
    public void mostrarEstado() {
        System.out.println("Estado Sesion Expirada");

    }
}
