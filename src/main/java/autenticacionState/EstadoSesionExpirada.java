package autenticacionState;

public class EstadoSesionExpirada implements EstadoAutenticacion{

    @Override
    public void iniciarSesion() {
        System.out.println("Porfavor, vuelva a iniciar sesión");
        ContextoAutenticacion.getInstance().setEstadoAutenticacion(new EstadoNoAutenticado());

    }

    @Override
    public void accederServicio() {
        System.out.println("Sesion expirada");
        ContextoAutenticacion.getInstance().setEstadoAutenticacion(new EstadoNoAutenticado());

    }

    @Override
    public void cerrarSesion() {
        System.out.println("Sesion cerrada");
        ContextoAutenticacion.getInstance().setEstadoAutenticacion(new EstadoNoAutenticado());

    }

    @Override
    public void mostrarEstado() {
        System.out.println("Estado Sesion Expirada");

    }
}
