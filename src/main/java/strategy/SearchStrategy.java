package strategy;

import search.SearchResult;
import search.StreamingService;

import java.util.ArrayList;

// Interfaz Strategy para la búsqueda
public interface SearchStrategy {
    /**
     * Método que realiza una búsqueda usando un algoritmo específico.
     *
     * @param query Consulta a realizar.
     * @return Los resultados de la búsqueda.
     */
    ArrayList<SearchResult> buscar(String query, StreamingService servicio);
}


