package Models;

import java.util.Date;

/**
 * Clase que representa el historial de visualización de un usuario en un servicio de streaming.
 * Contiene información sobre el contenido visualizado, la fecha de visualización, el tiempo de reproducción, y las notificaciones.
 */
public class Historial {
    private int idHistorial;
    private int idUsuario;
    private int idContenido;
    private Date fechaVisualizacion;
    private int tiempoReproduccion;
    private boolean notificacion;

    // Constructor
    public Historial(int idHistorial, int idUsuario, int idContenido, Date fechaVisualizacion, int tiempoReproduccion, boolean notificacion) {
        this.idHistorial = idHistorial;
        this.idUsuario = idUsuario;
        this.idContenido = idContenido;
        this.fechaVisualizacion = fechaVisualizacion;
        this.tiempoReproduccion = tiempoReproduccion;
        this.notificacion = notificacion;
    }

    // Getters y Setters


    public int getIdHistorial() {
        return idHistorial;
    }


    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }


    public int getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    public int getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(int idContenido) {
        this.idContenido = idContenido;
    }


    public Date getFechaVisualizacion() {
        return fechaVisualizacion;
    }


    public void setFechaVisualizacion(Date fechaVisualizacion) {
        this.fechaVisualizacion = fechaVisualizacion;
    }


    public int getTiempoReproduccion() {
        return tiempoReproduccion;
    }


    public void setTiempoReproduccion(int tiempoReproduccion) {
        this.tiempoReproduccion = tiempoReproduccion;
    }


    public boolean isNotificacion() {
        return notificacion;
    }


    public void setNotificacion(boolean notificacion) {
        this.notificacion = notificacion;
    }
}
