package FactoryMethod;

import search.CrunchyRollService;
import search.DisneyPlusService;
import search.NetflixService;
import search.StreamingService;

public class StreamingServiceFactory {

    public static StreamingService getService(String serviceName) {
        switch (serviceName.toLowerCase()) {
            case "netflix":
                return new NetflixService();
            case "crunchyroll":
                return new CrunchyRollService(); // Asegúrate de que esta clase esté implementada
            case "disneyplus":
                return new DisneyPlusService(); // Asegúrate de que esta clase esté implementada
            default:
                throw new IllegalArgumentException("Servicio desconocido: " + serviceName);
        }
    }}
