package search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class DisneyPlusService implements StreamingService {
    @Override
    public void configurar(Collection<String> configParams) {
        System.out.println("Configurando servicio de DisneyPlus...");
}
    @Override
    public Collection<SearchResult> consultar(String query, Collection<String> configParams) {
        System.out.println("Consultando resultados de DisneyPlus:");
        for (String param : configParams) {
            System.out.println("- " + param);
        }

        return new ArrayList<SearchResult>();
    }

    @Override
    public Collection<SearchResult> buscar(String query, Collection<String> configParams) {
        System.out.println("Buscando '" + query + "' en DisneyPlus con los siguientes parámetros de configuración:");
        for (String param : configParams) {
            System.out.println("- " + param);
        }

        return new Vector<SearchResult>();
    }
}