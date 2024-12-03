package strategy;

import java.util.ArrayList;
import search.SearchResult;

/**
 * Estrategia para realizar búsquedas basadas en categorías.
 */
public class SearchStrategyCategoria implements SearchStrategy {

    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams) {
        // Lógica de búsqueda por categorías
        System.out.println("Buscando por categorías: " + query);
        return new ArrayList<>();  // Aquí deberías implementar la lógica de búsqueda real
    }
}
