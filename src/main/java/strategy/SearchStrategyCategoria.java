package strategy;

import java.util.ArrayList;

import ApiFachada.ClienteApiRest;
import search.SearchResult;
import search.StreamingService;

/**
 * Estrategia para realizar búsquedas basadas en categorías.
 */
public class SearchStrategyCategoria implements SearchStrategy {

    @Override
    public ArrayList<SearchResult> buscar(String query, StreamingService servicio) {
        String genero;
        genero = switch (query){
            // Comedia
            case "1"-> "35";
            // Horror
            case "2"-> "27";
            // Aventura
            case "3"-> "12";
            //Romance
            case "4"-> "10749";
            // Drama
            case "5"-> "18";
            default -> "35";
        };

        // Lógica de búsqueda por categorías
        System.out.println("Buscando por categoría: ");
        String result = ClienteApiRest.getInstance().getApiRestFachada().obtenerRecurso(servicio.getBaseUrl() + "discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc&with_genres=" + genero, servicio.getToken());
        SearchResult searchResult = null;

        try {
            searchResult = new SearchResult(result);
        }catch (Exception e){
            System.out.println("Error de conversion");
        }

        ArrayList<SearchResult> lista = new ArrayList<>();
        lista.add(searchResult);

        return lista;

    }
}
