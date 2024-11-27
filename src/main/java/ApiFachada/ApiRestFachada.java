package ApiFachada;

/**
 * Interfaz fachada
 */
public interface ApiRestFachada {

    /**
     * Representa una
     * solicitud GET para obtener datos de un recurso en una URL
     * específica.
     * @param url
     * @return resultado
     */
    String obtenerRecurso(String url);

    //Representa una solicitud POST para crear un nuevo recurso
    //usando un JSON en el cuerpo de la solicitud.

    /**
     * Representa una solicitud POST para crear un nuevo recurso
     * usando un JSON en el cuerpo de la solicitud.
     * @param url
     * @param jsonBody
     * @return resultado
     */
    String crearRecurso(String url, String jsonBody);



    /**
     * Representa una solicitud PUT para actualizar un
     * recurso existente.
     * @param url
     * @param jsonBody
     * @return resultado
     */
    String actualizarRecurso(String url, String jsonBody);

    /**
     * Representa una
     * solicitud DELETE para eliminar un recurso en una URL específica.
     * @param url
     * @return resultado
     */
    String eliminarRecurso(String url);



}

