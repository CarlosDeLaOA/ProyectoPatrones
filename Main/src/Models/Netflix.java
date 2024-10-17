package Models;

public class Netflix extends Servicio{


    public Netflix(int idServicio, String urlConexion, String credenciales, String contenido) {
        super(idServicio, "Netflix", urlConexion, credenciales, contenido);  // Llama al constructor de Servicio

    }

}

