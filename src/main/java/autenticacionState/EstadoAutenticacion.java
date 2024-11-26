package autenticacionState;

public interface EstadoAutenticacion {
    /**
     * Metodo para iniciar sesion
     */
    void iniciarSesion();

    /**
     * Metodo para acceder al servicio
     */
    void accederServicio();

    /**
     * Metodo para acceder a cerrar sesion
     */
    void cerrarSesion();

    /**
     * Metodo para acceder a mostrar estado
     */
    void mostrarEstado();
}
