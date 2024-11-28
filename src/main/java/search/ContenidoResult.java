package search;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ContenidoResult {
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
}
