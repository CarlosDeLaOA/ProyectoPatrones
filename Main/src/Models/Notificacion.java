package Models;

public class Notificacion {
    private int idNotificacion;
    private Usuario usuario;  // FK: Relación con Usuario
    private String contenidoDeLaNotificacion;
    private String fechaDeEnvio;

    // Constructor
    public Notificacion(int idNotificacion, Usuario usuario, String contenidoDeLaNotificacion, String fechaDeEnvio) {
        this.idNotificacion = idNotificacion;
        this.usuario = usuario;
        this.contenidoDeLaNotificacion = contenidoDeLaNotificacion;
        this.fechaDeEnvio = fechaDeEnvio;
    }

    // Getters y Setters
    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getContenidoDeLaNotificacion() {
        return contenidoDeLaNotificacion;
    }

    public void setContenidoDeLaNotificacion(String contenidoDeLaNotificacion) {
        this.contenidoDeLaNotificacion = contenidoDeLaNotificacion;
    }

    public String getFechaDeEnvio() {
        return fechaDeEnvio;
    }

    public void setFechaDeEnvio(String fechaDeEnvio) {
        this.fechaDeEnvio = fechaDeEnvio;
    }

    @Override
    public String toString() {
        return "Notificacion{" +
                "idNotificacion=" + idNotificacion +
                ", usuario=" + usuario +
                ", contenidoDeLaNotificacion='" + contenidoDeLaNotificacion + '\'' +
                ", fechaDeEnvio='" + fechaDeEnvio + '\'' +
                '}';
    }
}
