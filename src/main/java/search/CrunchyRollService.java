package search;

import ApiFachada.ClienteApiRest;
import strategy.SearchStrategy;

import java.util.ArrayList;



public class CrunchyRollService extends StreamingService {
    public CrunchyRollService(){

    }
    public CrunchyRollService(CrunchyRollService pCrunchyRollService){
        super(pCrunchyRollService);
    }
    public Prototype clone(){
        return new CrunchyRollService(this);
    }
    @Override
    public void configurar(ArrayList<String> configParams) {
        setBaseUrl(configParams.get(0));
        setToken(configParams.get(1));
        System.out.println("Configurando servicio de CrunchyRoll...");
    }

    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams, SearchStrategy searchStrategy) {
        System.out.println("Consultando resultados de CrunchyRoll: ");

        String result = ClienteApiRest.getInstance().getApiRestFachada().obtenerRecurso(getBaseUrl() + "search/movie?query=anime", getToken());
        SearchResult searchResult = null;

        try {
            searchResult = new SearchResult(result);
        }catch (Exception e){
            System.out.println("Error de conversion");
        }

        ArrayList<SearchResult> lista = new ArrayList<>();
        lista.add(searchResult);

        return lista;
    }

    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams, SearchStrategy searchStrategy) {
        System.out.println("Buscando '" + query + "' en CrunchyRoll:");

        String result = ClienteApiRest.getInstance().getApiRestFachada().obtenerRecurso(getBaseUrl() + "search/movie?query=" + query, getToken());
        SearchResult searchResult = null;

        try {
            searchResult = new SearchResult(result);
        }catch (Exception e){
            System.out.println("Error de conversion");
        }

        ArrayList<SearchResult> lista = new ArrayList<>();
        lista.add(searchResult);

        return lista;
    }
}