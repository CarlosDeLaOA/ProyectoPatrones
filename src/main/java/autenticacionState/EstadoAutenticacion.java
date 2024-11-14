package autenticacionState;

public interface EstadoAutenticacion {

    void iniciarSesion();
    void accederServicio();
    void cerrarSesion();
    void mostrarEstado();
}
