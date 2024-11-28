package search;
import java.util.ArrayList;
//Ray

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

    public ArrayList<SearchResult> consultarServicio(String query, ArrayList<String> configParams){
        if(servicioActual != null) {
            return servicioActual.consultar(query, configParams);
        }else {
            System.out.println("No se ha seleccionado ningun servicio");
            return null;
        }
    }

    public ArrayList<SearchResult> buscarEnServicio(String query, ArrayList<String> configParams){
        if(servicioActual != null) {
            return servicioActual.buscar(query.replace(" ","+"), configParams);
        }else {
            System.out.println("No se ha seleccionado ningun servicio");
            return null;
        }
    }
}
