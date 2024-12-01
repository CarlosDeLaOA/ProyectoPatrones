package Models;

import observer.ISubscriptor;

public class Usuario implements ISubscriptor {

    // Atributos privados de la clase Usuario
    private int idUsuario;
    private int tipoSuscripcion;
    private int historialVisualizacion;
    private String nombre;
    private String correoElectronico;
    private String contrasenia;
    private String preferencias;
    private String servicioStreaming;

    /**
     * Obtiene el ID del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el ID del usuario.
     * @param idUsuario el id del usuario a establecer.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el tipo de suscripción del usuario.
     *
     * @return el tipo de suscripción.
     */
    public int getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    /**
     * Establece el tipo de suscripción del usuario.
     *
     * @param tipoSuscripcion el tipo de suscripción a establecer.
     */
    public void setTipoSuscripcion(int tipoSuscripcion) {
        this.tipoSuscripcion = tipoSuscripcion;
    }

    /**
     * Obtiene el historial de visualización del usuario.
     * @return el historial de visualización.
     */
    public int getHistorialVisualizacion() {
        return historialVisualizacion;
    }

    /**
     * Establece el historial de visualización del usuario
     * @param historialVisualizacion el historial de visualización a establecer.
     */
    public void setHistorialVisualizacion(int historialVisualizacion) {
        this.historialVisualizacion = historialVisualizacion;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return el nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre el nombre del usuario a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return el correo electrónico del usuario.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param correoElectronico el correo electrónico a establecer.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return la contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del usuario.
     * @param contrasenia la contraseña a establecer.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene las preferencias del usuario.
     * @return las preferencias del usuario.
     */
    public String getPreferencias() {
        return preferencias;
    }

    /**
     * Establece las preferencias del usuario.
     * @param preferencias las preferencias a establecer.
     */
    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    /**
     * Obtiene el servicio de streaming utilizado por el usuario.
     * @return el servicio de streaming del usuario.
     */
    public String getServicioStreaming() {
        return servicioStreaming;
    }

    /**
     * Establece el servicio de streaming utilizado por el usuario.
     * @param servicioStreaming el servicio de streaming a establecer.
     */
    public void setServicioStreaming(String servicioStreaming) {
        this.servicioStreaming = servicioStreaming;
    }

    public Subscripcion getSubscripcion() {
        return null;
    }

    public void setSubscripcion(Subscripcion subscripcion) {
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Hola!!" + getNombre());
        System.out.println(mensaje);
    }
}
