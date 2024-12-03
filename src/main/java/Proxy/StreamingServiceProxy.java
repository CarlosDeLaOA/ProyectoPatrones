package Proxy;

import Models.Usuario;
import Models.Subscripcion;
import search.Prototype;
import search.StreamingService;
import search.SearchResult;
import java.util.ArrayList;


public class StreamingServiceProxy extends StreamingService {


    private StreamingService realService;


    private Usuario usuario;


    public StreamingServiceProxy(StreamingService realService, Usuario usuario) {
        this.realService = realService;
        this.usuario = usuario;
    }


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


    @Override
    public void configurar(ArrayList<String> configParams) {
        if (tieneAcceso()) {
            realService.configurar(configParams);
        }
    }


    @Override
    public ArrayList<SearchResult> consultar(String query, ArrayList<String> configParams) {
        if (tieneAcceso()) {
            return realService.consultar(query, configParams);
        }
        System.out.println("Acceso denegado a la consulta.");
        return new ArrayList<>();
    }
    
    @Override
    public ArrayList<SearchResult> buscar(String query, ArrayList<String> configParams) {
        if (tieneAcceso()) {
            return realService.buscar(query, configParams);
        }
        System.out.println("Acceso denegado a la búsqueda.");
        return new ArrayList<>();
    }

    @Override
    public Prototype clone() {
        return null;
    }
}
