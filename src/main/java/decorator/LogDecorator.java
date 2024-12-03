package decorator;

import search.Prototype;
import search.SearchResult;
import search.StreamingService;
import java.util.ArrayList;

/**
 * Decorador que agrega registro de logs al servicio de streaming.
 */
public class LogDecorator extends StreamingService {

/**
 *  Servicio base que se envuelve con funcionalidad adicional.
 */
    private StreamingService servicioBase;

/**
 *  Constructor que inicializa el decorador con un servicio de streaming base.
 */
    public LogDecorator(StreamingService servicioBase) {
        this.servicioBase = servicioBase;
    }

/**
 *  Configura el servicio base con los parámetros especificados y registra la acción.
 */
    @Override
    public void configurar(ArrayList<String> configParams) {
        System.out.println("Registrando acción: Configuración del servicio.");
        servicioBase.configurar(configParams);
    }

/**
 * Realiza una consulta en el servicio base y registra la acción.
 */
    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams) {
        System.out.println("Registrando acción: Consulta de servicio.");
        return servicioBase.consultar(query, configParams);
    }

/**
 * Realiza una búsqueda en el servicio base y registra la acción.
 */

    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams) {
        System.out.println("Registrando acción: Búsqueda en servicio.");
        return servicioBase.buscar(query, configParams);
    }

/**
 * Crea una copia del decorador, incluyendo una copia del servicio base.
 */

    @Override
    public Prototype clone() {
        return new LogDecorator((StreamingService) servicioBase.clone());
    }
}
