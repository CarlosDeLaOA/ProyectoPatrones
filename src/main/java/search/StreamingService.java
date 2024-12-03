package search;

import strategy.SearchStrategy;

import java.util.ArrayList;

public abstract class StreamingService implements Prototype {
    private String baseUrl;
    private String token;

    public StreamingService(){
        setBaseUrl("https://api.themoviedb.org/3/");
        setToken("Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNzVkYzIyNzI3NmU0YWQ4NDY4OGI2MzQ1NTQ2MDZlZiIsIm5iZiI6MTcyOTc0NDc2MS45NjkyODksInN1YiI6IjY3MTljZDg4MjY4NWNiNjU2M2MwOTZiNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.SewK_9MKll2KoAcxHzEnx2STJt89uRc7TYAqfsdB_JQ");
    }
    public StreamingService(StreamingService pStreamingService){
        if(pStreamingService != null){
            setBaseUrl(pStreamingService.getBaseUrl());
            setToken(pStreamingService.token);
        }
    }

    abstract public void configurar(ArrayList<String> configParams);

    abstract public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams, SearchStrategy searchStrategy);

    abstract public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams, SearchStrategy searchStrategy);

    abstract public Prototype clone();
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ArrayList<SearchResult> usarStrategy(SearchStrategy searchStrategy, StreamingService servicio, String query){
        return searchStrategy.buscar(query, servicio);
    }
}


