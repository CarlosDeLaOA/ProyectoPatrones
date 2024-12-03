package decorator;

import search.SearchResult;
import search.StreamingService;

import java.util.ArrayList;


public abstract class StreamingServiceDecorator extends StreamingService {
    protected StreamingService servicio;

    public StreamingServiceDecorator(StreamingService servicio) {
        this.servicio = servicio;
    }

    @Override
    public void configurar(ArrayList<String> configParams) {
        servicio.configurar(configParams);
    }

    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams) {
        return servicio.consultar(query, configParams);
    }

    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams) {
        return servicio.buscar(query, configParams);
    }
}
