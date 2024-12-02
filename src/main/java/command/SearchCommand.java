package command;

import search.StreamingService;
import java.util.ArrayList;

/**
 * Comando para realizar una búsqueda en un servicio de streaming.
 */
public class SearchCommand implements Command {
    private StreamingService servicio;
    private String query;
    private ArrayList<String> configParams;

    /**
     * Constructor del comando de búsqueda.
     *
     * @param servicio Servicio de streaming donde se realizará la búsqueda.
     * @param query Término de búsqueda.
     * @param configParams Parámetros de configuración adicionales.
     */
    public SearchCommand(StreamingService servicio, String query, ArrayList<String> configParams) {
        this.servicio = servicio;
        this.query = query;
        this.configParams = configParams;
    }

    @Override
    public void execute() {
        // Ejecutar búsqueda en el servicio
        servicio.buscar(query, configParams);
    }
}
