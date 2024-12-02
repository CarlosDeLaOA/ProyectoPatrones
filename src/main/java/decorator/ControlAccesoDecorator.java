package decorator;

import search.Prototype;
import search.SearchResult;
import search.StreamingService;
import java.util.ArrayList;

/**
 * Decorador que implementa control de acceso para el servicio de streaming.
 */
public class ControlAccesoDecorator extends StreamingService {
    private StreamingService servicioBase;

    public ControlAccesoDecorator(StreamingService servicioBase) {
        this.servicioBase = servicioBase;
    }



    @Override
    public void configurar(ArrayList<String> configParams) {
        // Añadir funcionalidad de control de acceso
        System.out.println("Controlando acceso...");
        servicioBase.configurar(configParams);
    }

    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams) {
        // Añadir control de acceso antes de la consulta
        System.out.println("Verificando acceso para consulta...");
        return servicioBase.consultar(query, configParams);
    }

    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams) {
        // Añadir control de acceso antes de la búsqueda
        System.out.println("Verificando acceso para búsqueda...");
        return servicioBase.buscar(query, configParams);
    }

    @Override
    public Prototype clone() {
        return new ControlAccesoDecorator((StreamingService) servicioBase.clone());
    }
}
