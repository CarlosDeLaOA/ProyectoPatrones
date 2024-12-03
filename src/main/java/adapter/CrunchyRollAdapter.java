package adapter;

import search.CrunchyRollService;
import search.Prototype;
import search.StreamingService;
import search.SearchResult;

import java.util.ArrayList;

public class CrunchyRollAdapter extends StreamingService {
    private CrunchyRollService crunchyRollService;

    public CrunchyRollAdapter(CrunchyRollService crunchyRollService) {
        this.crunchyRollService = crunchyRollService;
    }

    @Override
    public void configurar(ArrayList<String> configParams) {
        crunchyRollService.configurar(configParams);
    }

    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams) {
        return crunchyRollService.consultar(query, configParams);
    }

    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams) {
        return crunchyRollService.buscar(query, configParams);
    }

    @Override
    public Prototype clone() {
        return new CrunchyRollAdapter((CrunchyRollService) crunchyRollService.clone());
    }
}
