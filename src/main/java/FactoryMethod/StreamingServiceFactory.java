package FactoryMethod;

import adapter.CrunchyRollAdapter;
import adapter.DisneyPlusAdapter;
import adapter.NetflixAdapter;
import search.StreamingService;
import search.CrunchyRollService;
import search.DisneyPlusService;
import search.NetflixService;


public class StreamingServiceFactory {


    public static StreamingService getService(String serviceName) {
        switch (serviceName.toLowerCase()) {
            case "netflix":
                // Crear instancia del servicio y adaptarlo
                return new NetflixAdapter(new NetflixService());
            case "crunchyroll":
                // Crear instancia del servicio y adaptarlo
                return new CrunchyRollAdapter(new CrunchyRollService());
            case "disneyplus":
                // Crear instancia del servicio y adaptarlo
                return new DisneyPlusAdapter(new DisneyPlusService());
            default:
                throw new IllegalArgumentException("Servicio desconocido: " + serviceName);
        }
    }
}
