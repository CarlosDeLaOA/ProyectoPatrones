package search;

import java.util.ArrayList;

public abstract class StreamingService implements Prototype {
    private String baseUrl;
    private String token;

    public StreamingService(){

    }
    public StreamingService(StreamingService pStreamingService){
        if(pStreamingService != null){
            setBaseUrl(pStreamingService.getBaseUrl());
            setToken(pStreamingService.token);
        }
    }

    public StreamingService(DisneyPlusService pDisneyPlusService) {
    }

    abstract public void configurar(ArrayList<String> configParams);

    abstract public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams);

    abstract public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams);

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

}


