package search;

import FactoryMethod.StreamingServiceFactory;
import Models.Usuario;
import Proxy.StreamingServiceProxy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Esta clase maneja la selección y configuración de servicios de streaming,
 * utilizando el patrón Adapter para adaptar los diferentes servicios de streaming
 * a una interfaz común (StreamingService).
 */
public class StreamingServiceManager {
    private static StreamingServiceManager instance;

    private StreamingService servicioActual;
    private HashMap<String, StreamingService> serviciosDisponibles = new HashMap<>();

    private StreamingServiceManager() {
        // Usar el Factory Method para obtener servicios adaptados
        StreamingService crunchyRoll = StreamingServiceFactory.getService("crunchyroll");
        StreamingService disneyPlus = StreamingServiceFactory.getService("disneyplus");
        StreamingService netflix = StreamingServiceFactory.getService("netflix");

        // Almacenar los servicios adaptados
        serviciosDisponibles.put("crunchyroll", crunchyRoll);
        serviciosDisponibles.put("disneyplus", disneyPlus);
        serviciosDisponibles.put("netflix", netflix);
    }

    public static StreamingServiceManager getInstance() {
        if (instance == null) {
            instance = new StreamingServiceManager();
        }
        return instance;
    }

    public void setServicio(String servicio, Usuario usuario) {
        switch (servicio) {
            case "crunchyroll":
            case "disneyplus":
            case "netflix":
                servicioActual = new StreamingServiceProxy((StreamingService) serviciosDisponibles.get(servicio).clone(), usuario);
                break;
            default:
                System.out.println("Servicio no disponible");
        }
    }

    public void configurarServicio(ArrayList<String> configuracionServicio) {
        if (servicioActual != null) {
            servicioActual.configurar(configuracionServicio);
        } else {
            System.out.println("No se ha seleccionado ningún servicio");
        }
    }

    public ArrayList<SearchResult> consultarServicio(String query, ArrayList<String> configParams) {
        if (servicioActual != null) {
            return servicioActual.consultar(query, configParams);
        } else {
            System.out.println("No se ha seleccionado ningún servicio");
            return null;
        }
    }

    public ArrayList<SearchResult> buscarEnServicio(String query, ArrayList<String> configParams) {
        if (servicioActual != null) {
            return servicioActual.buscar(query.replace(" ", "+"), configParams);
        } else {
            System.out.println("No se ha seleccionado ningún servicio");
            return null;
        }
    }
}
