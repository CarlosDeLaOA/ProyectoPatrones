package abstractFactory;

import search.CrunchyRollService;
import search.StreamingService;

/**
 * Fábrica concreta para crear un servicio de streaming de Crunchyroll.
 */
public class CrunchyRollServiceFactory implements StreamingServiceAbstractFactory {

    @Override
    public StreamingService createService() {
        // Crear y devolver una instancia del servicio de Crunchyroll
        return new CrunchyRollService();
    }
}
