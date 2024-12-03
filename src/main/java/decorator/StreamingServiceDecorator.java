package decorator;

import search.SearchResult;
import search.StreamingService;
import strategy.SearchStrategy;

import java.util.ArrayList;

/**
 * Clase decoradora para StreamingService.
 * Esta clase permite agregar funcionalidades adicionales al servicio de streaming.
 */
public abstract class StreamingServiceDecorator extends StreamingService {
/**
* El servicio de streaming al que se le añaden funcionalidades adicionales.
*/
    protected StreamingService servicio;

    public StreamingServiceDecorator(StreamingService servicio) {
        this.servicio = servicio;
    }
/**
* Configura el servicio de streaming base con los parámetros proporcionados.
*/
    @Override
    public void configurar(ArrayList<String> configParams) {
        servicio.configurar(configParams);
    }

/**
* Realiza una consulta utilizando el servicio de streaming base.
*/ 
    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams, SearchStrategy searchStrategy) {
        return servicio.consultar(query, configParams, searchStrategy);
    }

/**
* Realiza una busqueda utilizando el servicio de streaming base.
*/ 
    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams, SearchStrategy searchStrategy) {
        return servicio.buscar(query, configParams, searchStrategy);
    }
}