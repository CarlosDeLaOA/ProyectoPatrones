package search;

import decorator.ControlAccesoDecorator;
import decorator.LogDecorator;
import abstractFactory.StreamingServiceAbstractFactory;
import abstractFactory.NetflixServiceFactory;
import abstractFactory.DisneyPlusServiceFactory;
import abstractFactory.CrunchyRollServiceFactory;
import Models.Usuario;
import Proxy.StreamingServiceProxy;
import command.Command;
import command.SearchCommand;
import strategy.SearchStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Esta clase maneja la selección y configuración de servicios de streaming,
 * utilizando el patrón Adapter para adaptar los diferentes servicios de streaming
 * a una interfaz común (StreamingService).
 * Además, implementa el patrón Command para encapsular las operaciones de búsqueda,
 * consulta y configuración en objetos de comando.
 * Utiliza el patrón Abstract Factory para crear los servicios de streaming.
 * Utiliza el patrón Decorator para añadir funcionalidades adicionales de manera dinámica.
 * Utiliza el patrón Strategy para cambiar dinámicamente las estrategias de búsqueda.
 */
public class StreamingServiceManager {
    private static StreamingServiceManager instance;

    private StreamingService servicioActual;
    private HashMap<String, StreamingServiceAbstractFactory> serviciosDisponibles = new HashMap<>();
    private List<Command> commandHistory = new ArrayList<>(); // Para almacenar el historial de comandos
    private SearchStrategy searchStrategy; // Para la estrategia de búsqueda

    private StreamingServiceManager() {
        // Crear fábricas para cada servicio de streaming
        StreamingServiceAbstractFactory netflixFactory = new NetflixServiceFactory();
        StreamingServiceAbstractFactory disneyPlusFactory = new DisneyPlusServiceFactory();
        StreamingServiceAbstractFactory crunchyRollFactory = new CrunchyRollServiceFactory();

        // Almacenar las fábricas en el mapa
        serviciosDisponibles.put("netflix", netflixFactory);
        serviciosDisponibles.put("disneyplus", disneyPlusFactory);
        serviciosDisponibles.put("crunchyroll", crunchyRollFactory);
    }

    public static StreamingServiceManager getInstance() {
        if (instance == null) {
            instance = new StreamingServiceManager();
        }
        return instance;
    }

    /**
     * Establece el servicio de streaming actual utilizando la fábrica correspondiente.
     *
     * @param servicio Nombre del servicio de streaming (Netflix, DisneyPlus, Crunchyroll).
     * @param usuario  El usuario que solicita el servicio.
     */
    public void setServicio(String servicio, Usuario usuario) {
        StreamingServiceAbstractFactory factory = serviciosDisponibles.get(servicio);
        if (factory != null) {
            // Crear el servicio base utilizando la fábrica abstracta
            servicioActual = factory.createService();
            // Aplicar los decoradores dinámicamente
            servicioActual = aplicarDecoradores(servicioActual);
            servicioActual = new StreamingServiceProxy(servicioActual, usuario);
        } else {
            System.out.println("Servicio no disponible");
        }
    }

    /**
     * Aplica los decoradores dinámicamente.
     *
     * @param servicio El servicio de streaming seleccionado.
     * @return El servicio de streaming con los decoradores aplicados.
     */
    private StreamingService aplicarDecoradores(StreamingService servicio) {
        // Aplicar log y control de acceso como decoradores
        servicio = new ControlAccesoDecorator(servicio); // Decorador de control de acceso
        servicio = new LogDecorator(servicio); // Decorador de log
        return servicio;
    }

    /**
     * Configura el servicio de streaming actual con parámetros de configuración.
     *
     * @param configuracionServicio Parámetros de configuración del servicio.
     */
    public void configurarServicio(ArrayList<String> configuracionServicio) {
        if (servicioActual != null) {
            servicioActual.configurar(configuracionServicio);
        } else {
            System.out.println("No se ha seleccionado ningún servicio");
        }
    }

    /**
     * Establece la estrategia de búsqueda.
     *
     * @param strategy Estrategia de búsqueda (por ejemplo, por categoría o por tendencia).
     */
    public void setSearchStrategy(SearchStrategy strategy) {
        this.searchStrategy = strategy;
    }
    public ArrayList<SearchResult> iniciarBusquedaStrategy(String query){

       if(searchStrategy != null && servicioActual != null){
           return servicioActual.usarStrategy(searchStrategy, servicioActual,query);
       }
       System.out.println("No se ha podido realizar la búsqueda, verifique que se haya seleccionado un servicio");
       return null;
    }

    /**
     * Realiza una consulta utilizando el patrón Command y la estrategia seleccionada.
     *
     * @param query        Parámetro de búsqueda.
     * @param configParams Lista de parámetros de configuración.
     * @return Resultados de la consulta.
     */
    public ArrayList<SearchResult> consultarServicio(String query, ArrayList<String> configParams) {
        if (servicioActual != null) {
            // Verificar si la estrategia está definida
            if (searchStrategy != null) {
                // Ejecutar el comando de búsqueda
                Command command = new SearchCommand(servicioActual, query, configParams);
                command.execute();
                commandHistory.add(command); // Almacenar el comando ejecutado

                // Realizar la consulta en el servicio utilizando la estrategia
                return servicioActual.consultar(query, configParams, searchStrategy);
            } else {
                System.out.println("No se ha definido una estrategia de búsqueda.");
                return null;
            }
        } else {
            System.out.println("No se ha seleccionado ningún servicio.");
            return null;
        }
    }

    /**
     * Realiza una búsqueda utilizando el patrón Command y la estrategia seleccionada.
     *
     * @param query        Parámetro de búsqueda.
     * @param configParams Lista de parámetros de configuración.
     * @return Resultados de la búsqueda.
     */
    public ArrayList<SearchResult> buscarEnServicio(String query, ArrayList<String> configParams) {
        if (servicioActual != null) {
                // Ejecutar el comando de búsqueda
                Command command = new SearchCommand(servicioActual, query, configParams);
                command.execute();
                commandHistory.add(command); // Almacenar el comando ejecutado

                // Realizar la búsqueda en el servicio utilizando la estrategia
                return servicioActual.buscar(query.replace(" ", "+"), configParams, searchStrategy);
        } else {
            System.out.println("No se ha seleccionado ningún servicio.");
            return null;
        }
    }
}
