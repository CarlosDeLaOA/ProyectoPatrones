package search;

import ApiFachada.ClienteApiRest;
import strategy.SearchStrategy;

import java.util.ArrayList;


public class NetflixService extends StreamingService{
    public NetflixService(){

    }
    public NetflixService(NetflixService pNetflixService){
        super(pNetflixService);
    }
    public Prototype clone(){
        return new NetflixService(this);
    }
    @Override
    public void configurar(ArrayList<String> configParams) {
        System.out.println("Configurando servicio de Netflix...");
    }

    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams, SearchStrategy searchStrategy) {
        System.out.println("Consultando resultados de Netflix:");
        String result = ClienteApiRest.getInstance().getApiRestFachada().obtenerRecurso(getBaseUrl() + "search/movie?query=netflix", getToken());
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
        System.out.println("Buscando '" + query + "' en Netflix");
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