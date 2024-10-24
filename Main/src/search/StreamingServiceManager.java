package search;
import java.util.ArrayList;
import java.util.Collection;

public class StreamingServiceManager {
    private static StreamingServiceManager instance;
    private StreamingService servicioActual;

    private StreamingServiceManager() {}

    public static StreamingServiceManager getInstance() {
        if(instance == null) {
            instance = new StreamingServiceManager();
        }
        return instance;
    }

    public void setServicio(StreamingService servicio) {
        this.servicioActual = servicio;
    }
    public void configurarServicio(ArrayList<String> configuracionServicio) {
        if(servicioActual != null) {
            servicioActual.configurar(configuracionServicio);
        }else {
            System.out.println("No se ha seleccionado ningun servicio");
        }
    }

    public void consultarServicio(String query, ArrayList<String> configParams){
        if(servicioActual != null) {
            servicioActual.buscar(query, configParams);
        }else {
            System.out.println("No se ha seleccionado ningun servicio");
        }
    }

    public void buscarEnServicio(String query, ArrayList<String> configParams){
        if(servicioActual != null) {
            servicioActual.buscar(query, configParams);
        }else {
            System.out.println("No se ha seleccionado ningun servicio");
        }
    }
}
