package search;
import java.util.ArrayList;
import java.util.List;

public class ColeccionContenido implements Contenido {
    private List<Contenido> contenidos = new ArrayList<>();

    // Agregar un contenido a la colección
    public void agregarContenido(Contenido contenido) {
        contenidos.add(contenido);
    }

    // Mostrar los detalles de todos los contenidos en la colección
    @Override
    public void mostrarDetalles() {
        for (Contenido contenido : contenidos) {
            contenido.mostrarDetalles();  // Llamamos a mostrarDetalles de cada contenido
            try{
                Thread.sleep(500);
            }catch (Exception e){

            }
        }
    }
}
