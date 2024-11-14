package autenticacionState;

public class EstadoSesionExpirada implements EstadoAutenticacion{

    @Override
    public void iniciarSesion() {

    }

    @Override
    public void accederServicio() {

    }

    @Override
    public void cerrarSesion() {

    }

    @Override
    public void mostrarEstado() {
        System.out.println("Estado Sesion Expirada");

    }
}
