package search;

import ApiFachada.ClienteApiRest;

import java.util.ArrayList;



public class DisneyPlusService extends StreamingService {
    public  DisneyPlusService(){

    }
    public DisneyPlusService(DisneyPlusService pDisneyPlusService){
        super(pDisneyPlusService);
    }
    public Prototype clone(){
        return new DisneyPlusService(this);
    }
    @Override
    public void configurar(ArrayList<String> configParams) {
        System.out.println("Configurando servicio de DisneyPlus...");
}
    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams) {
        System.out.println("Consultando resultados de DisneyPlus:");

        String result = ClienteApiRest.getInstance().getApiRestFachada().obtenerRecurso(getBaseUrl() + "search/movie?query=disney", getToken());
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
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams) {
        System.out.println("Buscando '" + query + "' en DisneyPlus");
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