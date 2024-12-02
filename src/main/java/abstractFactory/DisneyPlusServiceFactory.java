package abstractFactory;

import search.DisneyPlusService;
import search.StreamingService;

/**
 * Fábrica concreta para crear un servicio de streaming de Disney+.
 */
public class DisneyPlusServiceFactory implements StreamingServiceAbstractFactory {

    @Override
    public StreamingService createService() {
        // Crear y devolver una instancia del servicio de Disney+
        return new DisneyPlusService();
    }
}
