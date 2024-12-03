package adapter;

import search.NetflixService;
import search.Prototype;
import search.StreamingService;
import search.SearchResult;
import strategy.SearchStrategy;

import java.util.ArrayList;


public class NetflixAdapter extends StreamingService {
    private NetflixService netflixService;

    public NetflixAdapter(NetflixService netflixService) {
        this.netflixService = netflixService;
    }

    @Override
    public void configurar(ArrayList<String> configParams) {
        netflixService.configurar(configParams);
    }

    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams, SearchStrategy searchStrategy) {
        return netflixService.consultar(query, configParams, searchStrategy);
    }

    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams, SearchStrategy searchStrategy) {
        return netflixService.buscar(query, configParams, searchStrategy);
    }

    @Override
    public Prototype clone() {
        return new NetflixAdapter((NetflixService) netflixService.clone());
    }
}
