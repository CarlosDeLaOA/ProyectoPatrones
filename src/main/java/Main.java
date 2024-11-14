import autenticacionState.ContextoAutenticacion;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
//Hola

/**
 * Clase principal que permite al usuario interactuar con el sistema de autenticación.
 * Proporciona un menú para registrar usuario, iniciar sesión, acceder a servicios, cerrar sesión y ver el estado.
 * Incluye la funcionalidad para buscar una película utilizando la API de The Movie Database (TMDb).
 */
public class Main {

    /**
     * Método principal que ejecuta el menú interactivo del sistema de autenticación.
     * Los usuarios pueden elegir entre registrar un usuario, iniciar sesión, acceder a un servicio,
     * cerrar sesión, mostrar el estado actual de autenticación o salir del programa.
     *
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ContextoAutenticacion contexto = ContextoAutenticacion.getInstance();
        int option;

        do {
            System.out.println("\n1. Registrar Usuario\n2. Iniciar Sesión\n3. Acceder a Servicio\n4. Cerrar Sesión\n5. Mostrar Estado\n0. Salir");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume el salto de línea

            switch (option) {
                case 1 -> contexto.registrarUsuario();
                case 2 -> contexto.iniciarSesion();
                case 3 -> contexto.accederServicio();
                case 4 -> contexto.cerrarSesion();
                case 5 -> contexto.mostrarEstado();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (option != 0);
    }

    /**
     * Permite al usuario buscar una película en la API de The Movie Database (TMDb).
     * Solicita al usuario el nombre de la película
     *
     * @throws IOException Si ocurre un error de entrada/salida al leer datos o realizar la solicitud HTTP.
     */
    public static void buscarPelicula() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el nombre de la película:");
        String movie = in.readLine();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/search/movie?query=" + movie)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNzVkYzIyNzI3NmU0YWQ4NDY4OGI2MzQ1NTQ2MDZlZiIsIm5iZiI6MTcyOTc0NDc2MS45NjkyODksInN1YiI6IjY3MTljZDg4MjY4NWNiNjU2M2MwOTZiNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.SewK_9MKll2KoAcxHzEnx2STJt89uRc7TYAqfsdB_JQ")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
