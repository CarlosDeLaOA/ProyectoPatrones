package Models;

import java.time.LocalDate;

public class Subscripcion {
    private String nombre;
    private String nivel;
    private LocalDate fechaActivacion;
    private LocalDate fechaExpiracion;
    private double precio;
    private String descripcionAcceso;

    public Subscripcion(String nombre, String nivel, LocalDate fechaActivacion, LocalDate fechaExpiracion, double precio, String descripcionAcceso) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.fechaActivacion = fechaActivacion;
        this.fechaExpiracion = fechaExpiracion;
        this.precio = precio;
        this.descripcionAcceso = descripcionAcceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public LocalDate getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(LocalDate fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcionAcceso() {
        return descripcionAcceso;
    }

    public void setDescripcionAcceso(String descripcionAcceso) {
        this.descripcionAcceso = descripcionAcceso;
    }
}
