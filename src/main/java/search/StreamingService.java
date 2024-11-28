package search;

import java.util.ArrayList;

public abstract class StreamingService {
    private String baseUrl;
    private String token;

    abstract public void configurar(ArrayList<String> configParams);

    abstract public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams);

    abstract public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams);

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


