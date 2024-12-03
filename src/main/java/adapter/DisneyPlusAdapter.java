package adapter;

import search.DisneyPlusService;
import search.Prototype;
import search.StreamingService;
import search.SearchResult;
import strategy.SearchStrategy;

import java.util.ArrayList;

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
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams, SearchStrategy searchStrategy) {
        return disneyPlusService.consultar(query, configParams, searchStrategy);
    }

    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams, SearchStrategy searchStrategy) {
        return disneyPlusService.buscar(query, configParams, searchStrategy);
    }

    @Override
    public Prototype clone() {
        return new DisneyPlusAdapter((DisneyPlusService) disneyPlusService.clone());
    }
}
