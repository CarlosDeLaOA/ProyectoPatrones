package search;


import command.SearchCommand;
import command.Command;
import FactoryMethod.StreamingServiceFactory;
import Models.Usuario;
import Proxy.StreamingServiceProxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Esta clase maneja la selección y configuración de servicios de streaming,
 * utilizando el patrón Adapter para adaptar los diferentes servicios de streaming
 * a una interfaz común (StreamingService).
 * Además, implementa el patrón Command para encapsular las operaciones de búsqueda,
 * consulta y configuración en objetos de comando.
 */
public class StreamingServiceManager {
    private static StreamingServiceManager instance;

    private StreamingService servicioActual;
    private HashMap<String, StreamingService> serviciosDisponibles = new HashMap<>();
    private List<Command> commandHistory = new ArrayList<>(); // Para almacenar el historial de comandos

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

    /**
     * Realiza una consulta utilizando el patrón Command.
     * @param query Parámetro de búsqueda.
     * @param configParams Lista de parámetros de configuración.
     * @return Resultados de la consulta.
     */
    public ArrayList<SearchResult> consultarServicio(String query, ArrayList<String> configParams) {
        if (servicioActual != null) {
            Command command = new SearchCommand(servicioActual, query, configParams);
            command.execute();
            commandHistory.add(command); // Almacenar el comando ejecutado
            return servicioActual.consultar(query, configParams);
        } else {
            System.out.println("No se ha seleccionado ningún servicio");
            return null;
        }
    }

    /**
     * Realiza una búsqueda utilizando el patrón Command.
     * @param query Parámetro de búsqueda.
     * @param configParams Lista de parámetros de configuración.
     * @return Resultados de la búsqueda.
     */
    public ArrayList<SearchResult> buscarEnServicio(String query, ArrayList<String> configParams) {
        if (servicioActual != null) {
            Command command = new SearchCommand(servicioActual, query, configParams);
            command.execute();
            commandHistory.add(command); // Almacenar el comando ejecutado
            return servicioActual.buscar(query.replace(" ", "+"), configParams);
        } else {
            System.out.println("No se ha seleccionado ningún servicio");
            return null;
        }
    }
}
