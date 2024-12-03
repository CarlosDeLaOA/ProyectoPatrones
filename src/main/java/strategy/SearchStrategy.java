package strategy;

import search.SearchResult;

import java.util.ArrayList;

// Interfaz Strategy para la búsqueda
public interface SearchStrategy {
    /**
     * Método que realiza una búsqueda usando un algoritmo específico.
     *
     * @param query Consulta a realizar.
     * @param configParams Parámetros de configuración adicionales.
     * @return Los resultados de la búsqueda.
     */
    ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams);
}


