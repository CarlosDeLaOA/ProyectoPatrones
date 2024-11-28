package Proxy;

import Models.Usuario;
import Models.Subscripcion;
import search.StreamingService;
import search.SearchResult;
import java.util.ArrayList;

/**
 * Proxy para la interfaz de servicios de streaming, que gestiona el acceso
 * a los métodos del servicio real en función de la suscripción del usuario.
 * Este patrón Proxy permite verificar la validez de la suscripción antes
 * de delegar las llamadas al servicio real.
 */
public class StreamingServiceProxy implements StreamingService {
    
    /**
     * Instancia del servicio real de streaming que será delegado.
     */
    private StreamingService realService;

    /**
     * Usuario cuyo acceso será verificado antes de realizar las operaciones.
     */
    private Usuario usuario;

    /**
     * Constructor de la clase proxy.
     * 
     * @param realService El servicio real de streaming que se va a delegar.
     * @param usuario El usuario cuya suscripción se va a verificar.
     */
    public StreamingServiceProxy(StreamingService realService, Usuario usuario) {
        this.realService = realService;
        this.usuario = usuario;
    }

    /**
     * Verifica si el usuario tiene acceso al servicio basándose en su suscripción.
     * 
     * @return true si el usuario tiene acceso, false si no tiene una suscripción activa
     *         o si esta ha expirado.
     */
    private boolean tieneAcceso() {
        Subscripcion subscripcion = usuario.getSubscripcion();
        
        if (subscripcion == null) {
            System.out.println("Acceso denegado: No hay suscripción activa.");
            return false;
        }

        if (subscripcion.getFechaExpiracion().isBefore(java.time.LocalDate.now())) {
            System.out.println("Acceso denegado: La suscripción ha expirado.");
            return false;
        }

        System.out.println("Acceso permitido: Usuario tiene suscripción válida.");
        return true;
    }

    /**
     * Configura el servicio de streaming con los parámetros proporcionados si el
     * usuario tiene acceso.
     * 
     * @param configParams Lista de parámetros de configuración que serán aplicados
     *                     al servicio de streaming.
     */
    @Override
    public void configurar(ArrayList<String> configParams) {
        if (tieneAcceso()) {
            realService.configurar(configParams);
        }
    }

    /**
     * Realiza una consulta de búsqueda en el servicio de streaming, si el usuario
     * tiene acceso.
     * 
     * @param query Consulta a realizar en el servicio de streaming.
     * @param configParams Lista de parámetros de configuración a usar durante
     *                     la consulta.
     * @return Lista de resultados de la búsqueda. Si el acceso es denegado,
     *         se devuelve una lista vacía.
     */
    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams) {
        if (tieneAcceso()) {
            return realService.consultar(query, configParams);
        }
        System.out.println("Acceso denegado a la consulta.");
        return new ArrayList<>();
    }

    /**
     * Realiza una búsqueda en el servicio de streaming, si el usuario tiene acceso.
     * 
     * @param query Consulta a realizar en el servicio de streaming.
     * @param configParams Lista de parámetros de configuración a usar durante
     *                     la búsqueda.
     * @return Lista de resultados de la búsqueda. Si el acceso es denegado,
     *         se devuelve una lista vacía.
     */
    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams) {
        if (tieneAcceso()) {
            return realService.buscar(query, configParams);
        }
        System.out.println("Acceso denegado a la búsqueda.");
        return new ArrayList<>();
    }
}
