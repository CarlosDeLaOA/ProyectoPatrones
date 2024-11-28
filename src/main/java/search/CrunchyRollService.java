package search;

import ApiFachada.ClienteApiRest;

import java.util.ArrayList;



public class CrunchyRollService extends StreamingService {

    @Override
    public void configurar(ArrayList<String> configParams) {
        setBaseUrl(configParams.get(0));
        setToken(configParams.get(1));
        System.out.println("Configurando servicio de CrunchyRoll...");
    }

    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams) {
        System.out.println("Consultando resultados de CrunchyRoll:");

        String result = ClienteApiRest.getInstance().getApiRestFachada().obtenerRecurso("movie/" + query);
        ContenidoResult content = null;

        try {
            content = new ContenidoResult(result);
        }catch (Exception e){
            System.out.println("Error de conversion");
        }

        ArrayList<SearchResult> lista = new ArrayList<>();
        lista.add(new SearchResult());
        lista.getFirst().getContenidos().add(content);

        return lista;
    }

    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams) {
        System.out.println("Buscando '" + query + "' en CrunchyRoll:");

        String result = ClienteApiRest.getInstance().getApiRestFachada().obtenerRecurso("search/movie?query=" + query);
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