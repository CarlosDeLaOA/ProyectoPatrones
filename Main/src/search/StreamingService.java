package search;

import java.util.ArrayList;

public interface StreamingService {
    void configurar(ArrayList<String> configParams);

    ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams);

    ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams);

}
