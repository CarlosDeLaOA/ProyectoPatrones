package strategy;

import java.util.ArrayList;
import search.SearchResult;

/**
 * Estrategia para realizar búsquedas basadas en tendencias.
 */
public class SearchStrategyTendencia implements SearchStrategy {

    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams) {
        // Lógica de búsqueda por tendencias
        System.out.println("Buscando por tendencias: " + query);
        return new ArrayList<>();
    }
}
