package search;

import java.util.Collection;
import java.util.Vector;

public interface StreamingService {
    void configurar(Collection<String> configParams);

    Collection<SearchResult> consultar(String query, Vector<String> configParams);

    Collection<SearchResult> buscar(String query, Vector<String> configParams);
}
