package decorator;

import search.Prototype;
import search.SearchResult;
import search.StreamingService;
import java.util.ArrayList;

/**
 * Decorador que agrega registro de logs al servicio de streaming.
 */
public class LogDecorator extends StreamingService {
    private StreamingService servicioBase;

    public LogDecorator(StreamingService servicioBase) {
        this.servicioBase = servicioBase;
    }

    @Override
    public void configurar(ArrayList<String> configParams) {
        System.out.println("Registrando acción: Configuración del servicio.");
        servicioBase.configurar(configParams);
    }

    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams) {
        System.out.println("Registrando acción: Consulta de servicio.");
        return servicioBase.consultar(query, configParams);
    }

    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams) {
        System.out.println("Registrando acción: Búsqueda en servicio.");
        return servicioBase.buscar(query, configParams);
    }

    @Override
    public Prototype clone() {
        return new LogDecorator((StreamingService) servicioBase.clone());
    }
}
