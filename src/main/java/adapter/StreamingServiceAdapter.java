package adapter;

import search.SearchResult;
import java.util.ArrayList;


public interface StreamingServiceAdapter {


    void configurar(ArrayList<String> configParams);


    ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams);


    ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams);
}
