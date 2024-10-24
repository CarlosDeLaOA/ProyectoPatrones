package search;
import java.util.Collection;
import java.util.Vector;
public class NetflixService implements StreamingService{
    @Override
    public void configurar(Collection<String> configParams) {
        System.out.println("Configurando servicio de Netflix...");
    }

    @Override
    public Collection<SearchResult> consultar(String query, Vector<String> configParams) {
        System.out.println("Consultando resultados de Netflix:");
        for (String param : configParams) {
            System.out.println("- " + param);
        }

        return new Vector<SearchResult>();
    }

    @Override
    public Collection<SearchResult> buscar(String query, Vector<String> configParams) {
        System.out.println("Buscando '" + query + "' en Netflix con los siguientes parámetros de configuración:");
        for (String param : configParams) {
            System.out.println("- " + param);
        }

        return new Vector<SearchResult>();
    }
}


