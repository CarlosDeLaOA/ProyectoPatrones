package Models;

import java.time.LocalDate;

public class Contenido {
    private String nombre;
    private String descripcion;
    private String genero;
    private LocalDate fechaLanzamiento;
    private String calidadDeVideo;
    private String tipoDeContenido;


    public Contenido(String nombre, String descripcion, String genero, LocalDate fechaLanzamiento, String calidadDeVideo, String tipoDeContenido) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;
        this.calidadDeVideo = calidadDeVideo;
        this.tipoDeContenido = tipoDeContenido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getCalidadDeVideo() {
        return calidadDeVideo;
    }

    public void setCalidadDeVideo(String calidadDeVideo) {
        this.calidadDeVideo = calidadDeVideo;
    }

    public String getTipoDeContenido() {
        return tipoDeContenido;
    }

    public void setTipoDeContenido(String tipoDeContenido) {
        this.tipoDeContenido = tipoDeContenido;
    }
}
