package search;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Clase que representa un contenido obtenido desde la API.
 * Implementa la interfaz Contenido para poder ser gestionado por el patrón Composite.
 */
public class ContenidoResult implements Contenido {

    private long id;
    private String titulo;
    private String descripcion;
    private String popularidad;
    private String idioma;

    public ContenidoResult(String json) throws ParseException {
        JSONObject jsonObject = (JSONObject) (new JSONParser().parse(json));
        setId((long) jsonObject.get("id"));
        setTitulo(jsonObject.get("title").toString());
        setDescripcion(jsonObject.get("overview").toString());
        setPopularidad(jsonObject.get("popularity").toString());
        setIdioma(jsonObject.get("original_language").toString());
    }

    // Getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(String popularidad) {
        this.popularidad = popularidad;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Implementación del método de la interfaz Contenido para mostrar detalles del contenido.
     */
    @Override
    public void mostrarDetalles() {
        System.out.println("\n-----------------------");
        System.out.println("Título: " + titulo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Idioma: " + idioma);
        System.out.println("Popularidad: " + popularidad);
        System.out.println("-----------------------");
    }
}
