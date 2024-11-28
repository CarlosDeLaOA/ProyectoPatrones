package search;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;

public class SearchResult {
    private ArrayList<ContenidoResult> contenidos;

    public SearchResult(){
        setContenidos(new ArrayList<>());
    }

    public SearchResult(String json) throws ParseException {
        setContenidos(new ArrayList<>());

        JSONObject jsonObject = (JSONObject) (new JSONParser().parse(json));
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");

        Iterator iterador = jsonArray.iterator();

        while (iterador.hasNext()){
            ContenidoResult contenido = new ContenidoResult(iterador.next().toString());
            getContenidos().add(contenido);
        }

    }

    public ArrayList<ContenidoResult> getContenidos() {
        return contenidos;
    }

    public void setContenidos(ArrayList<ContenidoResult> contenidos) {
        this.contenidos = contenidos;
    }
}
