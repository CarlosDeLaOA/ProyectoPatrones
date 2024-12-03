package strategy;

import java.util.ArrayList;

import ApiFachada.ClienteApiRest;
import search.SearchResult;
import search.StreamingService;

/**
 * Estrategia para realizar búsquedas basadas en tendencias.
 */
public class SearchStrategyTendencia implements SearchStrategy {

    @Override
    public ArrayList<SearchResult> buscar(String query, StreamingService servicio) {
        // Lógica de búsqueda por tendencias
        System.out.println("Buscando por tendencias: ");

        String result = ClienteApiRest.getInstance().getApiRestFachada().obtenerRecurso(servicio.getBaseUrl() + "movie/popular", servicio.getToken());
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
