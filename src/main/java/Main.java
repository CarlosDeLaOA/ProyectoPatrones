import autenticacionState.ContextoAutenticacion;
import Models.Usuario;
import Models.Subscripcion;
import observer.NotificationManager;
import org.json.simple.parser.ParseException;
import search.*;
import strategy.SearchStrategy;
import strategy.SearchStrategyCategoria;
import strategy.SearchStrategyTendencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ContextoAutenticacion contexto = ContextoAutenticacion.getInstance();
        Usuario usuario = crearUsuarioEjemplo();

        int option;
        do {
            System.out.println("\n1. Registrar Usuario");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Seleccionar Servicio de Streaming");
            System.out.println("4. Acceder a Servicio");
            System.out.println("5. Buscar Película");
            System.out.println("6. Cerrar Sesión");
            System.out.println("7. Mostrar Estado");
            System.out.println("8. Enviar notificacion a usuarios subscritos");
            System.out.println("0. Salir");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume el salto de línea

            switch (option) {
                case 1 -> contexto.registrarUsuario();
                case 2 -> contexto.iniciarSesion();
                case 3 -> {
                    System.out.println("Seleccione el servicio de streaming:");
                    System.out.println("1. Netflix");
                    System.out.println("2. CrunchyRoll");
                    System.out.println("3. DisneyPlus");
                    int serviceOption = scanner.nextInt();
                    scanner.nextLine();

                    String serviceName = switch (serviceOption) {
                        case 1 -> "netflix";
                        case 2 -> "crunchyroll";
                        case 3 -> "disneyplus";
                        default -> {
                            System.out.println("Opción no válida. Seleccionando Netflix por defecto.");
                            yield "netflix";
                        }
                    };

                    // Selección del servicio de streaming
                    StreamingServiceManager.getInstance().setServicio(serviceName, usuario);
                    System.out.println("Servicio de " + serviceName + " seleccionado y configurado.");

                    // Después de seleccionar el servicio, preguntar por la estrategia de búsqueda
                    seleccionarEstrategiaBusqueda(scanner);

                    // Realizar la búsqueda de películas
                    buscarPelicula(scanner);
                }
                case 4 -> {
                    System.out.println("Intentando acceder al servicio de streaming...");
                    ArrayList<SearchResult> resultados = StreamingServiceManager.getInstance().consultarServicio("Consultar", null);
                    imprimirResultados(resultados);
                }
                case 5 -> buscarPelicula(scanner);

                case 6 -> contexto.cerrarSesion();
                case 7 -> contexto.mostrarEstado();
                case 8 -> {
                    Usuario usuario1 = new Usuario();
                    usuario1.setNombre("Key");

                    Usuario usuario2 = new Usuario();
                    usuario2.setNombre("Carlos");

                    Usuario usuario3 = new Usuario();
                    usuario3.setNombre("Samanta");

                    Usuario usuario4 = new Usuario();
                    usuario4.setNombre("Rayner");

                    NotificationManager notificationManager = new NotificationManager();
                    notificationManager.subscribirse(usuario1);
                    notificationManager.subscribirse(usuario2);
                    notificationManager.subscribirse(usuario3);
                    notificationManager.subscribirse(usuario4);

                    System.out.println("Ingrese el texto de la notificacion");
                    String texto = scanner.nextLine();
                    System.out.println("Enviando notificacion\n");
                    notificationManager.notifySubcribers(texto);
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (option != 0);
    }

    private static Usuario crearUsuarioEjemplo() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan Pérez");
        usuario.setCorreoElectronico("juan@example.com");
        Subscripcion subscripcion = new Subscripcion(
                "Netflix",
                "Premium",
                LocalDate.now().minusMonths(1),
                LocalDate.now().plusMonths(1),
                12.99,
                "Acceso total"
        );
        usuario.setSubscripcion(subscripcion);
        return usuario;
    }

    public static void seleccionarEstrategiaBusqueda(Scanner scanner) {
        // Seleccionar la estrategia de búsqueda
        System.out.println("Seleccione el tipo de búsqueda:");
        System.out.println("1. Buscar por Categoría");
        System.out.println("2. Buscar por Tendencia");
        int strategyOption = scanner.nextInt();
        scanner.nextLine();

        // Seleccionamos la estrategia en base a la opción
        SearchStrategy strategy = switch (strategyOption) {
            case 1 -> new SearchStrategyCategoria();  // Estrategia por Categoría
            case 2 -> new SearchStrategyTendencia();  // Estrategia por Tendencia
            default -> {
                System.out.println("Opción no válida. Se selecciona por defecto la búsqueda por Categoría.");
                yield new SearchStrategyCategoria();  // Por defecto se selecciona por Categoría
            }
        };

        // Configurar la estrategia en el StreamingServiceManager
        StreamingServiceManager.getInstance().setSearchStrategy(strategy);
    }

    public static void buscarPelicula(Scanner scanner) throws IOException {
        // Preguntar por el nombre de la película
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el nombre de la película:");
        String movie = in.readLine();

        // Realizamos la búsqueda usando el servicio seleccionado y la estrategia configurada
        ArrayList<SearchResult> results = StreamingServiceManager.getInstance().buscarEnServicio(movie, null);
        imprimirResultados(results);
    }

    public static void imprimirResultados(ArrayList<SearchResult> results) {
        if (results != null && !results.isEmpty()) {
            // Obtener los contenidos del primer resultado (asumiendo que hay más resultados)
            ArrayList<ContenidoResult> contenidos = results.get(0).getContenidos();

            System.out.println("Resultados obtenidos: " + contenidos.size());

            // Crear una colección de contenido
            ColeccionContenido coleccion = new ColeccionContenido();

            // Convertir los resultados en objetos Contenido y agregarlos a la colección
            for (ContenidoResult content : contenidos) {
                coleccion.agregarContenido(content);
            }

            // Mostrar los detalles de todos los contenidos
            coleccion.mostrarDetalles();
        } else {
            System.out.println("No hay resultados");
        }
    }
}
