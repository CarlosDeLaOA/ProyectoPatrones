package adapter;

import search.SearchResult;
import java.util.ArrayList;

/**
 * Interfaz común para adaptar los diferentes servicios de streaming
 * a una interfaz unificada.
 */
public interface StreamingServiceAdapter {

    /**
     * Configura el servicio de streaming con los parámetros proporcionados.
     *
     * @param configParams Parámetros de configuración.
     */
    void configurar(ArrayList<String> configParams);

    /**
     * Realiza una consulta en el servicio de streaming.
     *
     * @param query Consulta de búsqueda.
     * @param configParams Parámetros adicionales de configuración.
     * @return Lista de resultados de búsqueda.
     */
    ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams);

    /**
     * Realiza una búsqueda en el servicio de streaming.
     *
     * @param query Consulta de búsqueda.
     * @param configParams Parámetros adicionales de configuración.
     * @return Lista de resultados de búsqueda.
     */
    ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams);
}
