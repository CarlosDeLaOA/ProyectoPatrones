package Models;

public class Recomendacion {
    private int idRecomendacion;
    private Usuario usuario;  // FK: Relación con Usuario
    private int idContenido;  // FK: Relación con Contenido (asumido como otro objeto)
    private String fechaRecomendacion;
    private String notificacion;
    private String nombre;

    // Constructor
    public Recomendacion(int idRecomendacion, Usuario usuario, int idContenido, String fechaRecomendacion, String notificacion, String nombre) {
        this.idRecomendacion = idRecomendacion;
        this.usuario = usuario;
        this.idContenido = idContenido;
        this.fechaRecomendacion = fechaRecomendacion;
        this.notificacion = notificacion;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(int idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(int idContenido) {
        this.idContenido = idContenido;
    }

    public String getFechaRecomendacion() {
        return fechaRecomendacion;
    }

    public void setFechaRecomendacion(String fechaRecomendacion) {
        this.fechaRecomendacion = fechaRecomendacion;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Recomendacion{" +
                "idRecomendacion=" + idRecomendacion +
                ", usuario=" + usuario +
                ", idContenido=" + idContenido +
                ", fechaRecomendacion='" + fechaRecomendacion + '\'' +
                ", notificacion='" + notificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

