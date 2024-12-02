package abstractFactory;

import search.StreamingService;

/**
 * Abstract Factory para crear familias de servicios de streaming.
 */
public interface StreamingServiceAbstractFactory {

    /**
     * Crea un servicio de streaming.
     *
     * @return Una instancia de StreamingService.
     */
    StreamingService createService();
}
