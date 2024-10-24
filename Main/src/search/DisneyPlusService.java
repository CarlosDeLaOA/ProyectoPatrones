package search;

import java.util.ArrayList;



public class DisneyPlusService implements StreamingService {
    @Override
    public void configurar(ArrayList<String> configParams) {
        System.out.println("Configurando servicio de DisneyPlus...");
}
    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams) {
        System.out.println("Consultando resultados de DisneyPlus:");
        for (String param : configParams) {
            System.out.println("- " + param);
        }

        return new ArrayList<SearchResult>();
    }

    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams) {
        System.out.println("Buscando '" + query + "' en DisneyPlus con los siguientes parámetros de configuración:");
        for (String param : configParams) {
            System.out.println("- " + param);
        }

        return new ArrayList<SearchResult>();
    }
}