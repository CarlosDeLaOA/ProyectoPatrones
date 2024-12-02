package abstractFactory;

import search.NetflixService;
import search.StreamingService;

/**
 * Fábrica concreta para crear un servicio de streaming de Netflix.
 */
public class NetflixServiceFactory implements StreamingServiceAbstractFactory {

    @Override
    public StreamingService createService() {
        // Crear y devolver una instancia del servicio de Netflix
        return new NetflixService();
    }
}