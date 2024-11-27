import ApiFachada.ClienteApiRest;
import autenticacionState.ContextoAutenticacion;
import Proxy.StreamingServiceProxy;
import Models.Usuario;
import Models.Subscripcion;
import search.NetflixService;
import search.SearchResult;
import search.StreamingService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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

        // Crear un ejemplo de usuario y subscripción
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan Pérez");
        usuario.setCorreoElectronico("juan@example.com");
        Subscripcion subscripcion = new Subscripcion(
                "Netflix",
                "Premium",
                LocalDate.now().minusMonths(1), // Activada hace un mes
                LocalDate.now().plusMonths(1), // Expira en un mes
                12.99,
                "Acceso total"
        );
        usuario.setSubscripcion(subscripcion);

        // Configurar servicio de streaming real y proxy
        StreamingService netflixService = new NetflixService();
        StreamingService proxyService = new StreamingServiceProxy(netflixService, usuario);

        do {
            System.out.println("\n1. Registrar Usuario\n2. Iniciar Sesión\n3. Acceder a Servicio\n4. Cerrar Sesión\n5. Mostrar Estado\n0. Salir");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume el salto de línea

            switch (option) {
                case 1 -> contexto.registrarUsuario();
                case 2 -> contexto.iniciarSesion();
                case 3 -> {
                    System.out.println("Intentando acceder al servicio de streaming...");
                    ArrayList<SearchResult> resultados = proxyService.consultar("Películas populares", new ArrayList<>());
                    System.out.println("Resultados obtenidos: " + resultados.size());
                }
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

        System.out.println(ClienteApiRest.getInstance().getApiRestFachada().obtenerRecurso("search/movie?query=" + movie));

    }
}
