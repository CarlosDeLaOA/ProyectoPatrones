package adapter;

import search.DisneyPlusService;
import search.Prototype;
import search.StreamingService;
import search.SearchResult;

import java.util.ArrayList;

/**
 * Adaptador para Disney+, para que implemente la interfaz común StreamingService.
 * Esta clase adapta la interfaz específica de Disney+ a la interfaz común que utilizan
 * los demás servicios de streaming.
 */
public class DisneyPlusAdapter extends StreamingService {
    private DisneyPlusService disneyPlusService;

    public DisneyPlusAdapter(DisneyPlusService disneyPlusService) {
        this.disneyPlusService = disneyPlusService;
    }

    @Override
    public void configurar(ArrayList<String> configParams) {
        disneyPlusService.configurar(configParams);
    }

    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams) {
        return disneyPlusService.consultar(query, configParams);
    }

    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams) {
        return disneyPlusService.buscar(query, configParams);
    }

    @Override
    public Prototype clone() {
        return new DisneyPlusAdapter((DisneyPlusService) disneyPlusService.clone());
    }
}
