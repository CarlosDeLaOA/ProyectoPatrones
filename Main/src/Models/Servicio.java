package Models;

/**
 * Clase que representa un Servicio de streaming en el sistema.
 * Contiene información sobre el nombre, la URL de conexión, las credenciales y el contenido.
 */
public class Servicio {
    private int idServicio;
    private String nombreServicio;
    private String urlConexion;
    private String credenciales;
    private String contenido;

    // Constructor
    public Servicio(int idServicio, String nombreServicio, String urlConexion, String credenciales, String contenido) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.urlConexion = urlConexion;
        this.credenciales = credenciales;
        this.contenido = contenido;
    }

    // Getters y Setters

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }


    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getUrlConexion() {
        return urlConexion;
    }


    public void setUrlConexion(String urlConexion) {
        this.urlConexion = urlConexion;
    }


    public String getCredenciales() {
        return credenciales;
    }


    public void setCredenciales(String credenciales) {
        this.credenciales = credenciales;
    }


    public String getContenido() {
        return contenido;
    }


    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

