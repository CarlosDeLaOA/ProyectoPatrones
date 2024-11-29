import ApiFachada.ClienteApiRest;
import FactoryMethod.StreamingServiceFactory;
import autenticacionState.ContextoAutenticacion;
import Proxy.StreamingServiceProxy;
import Models.Usuario;
import Models.Subscripcion;
import org.json.simple.parser.ParseException;
import search.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        ContextoAutenticacion contexto = ContextoAutenticacion.getInstance();
        StreamingServiceFactory factory = new StreamingServiceFactory();

        Usuario usuario = crearUsuarioEjemplo();
        StreamingServiceProxy proxyService = null;

        int option;
        do {
            System.out.println("\n1. Registrar Usuario");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Seleccionar Servicio de Streaming");
            System.out.println("4. Acceder a Servicio");
            System.out.println("5. Buscar Película");
            System.out.println("6. Cerrar Sesión");
            System.out.println("7. Mostrar Estado");
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

                    StreamingService selectedService = factory.getService(serviceName);
                    proxyService = new StreamingServiceProxy(selectedService, usuario);
                    System.out.println("Servicio de " + serviceName + " seleccionado y configurado.");
                }
                case 4 -> {
                    if (proxyService != null) {
                        System.out.println("Intentando acceder al servicio de streaming...");
                        ArrayList<SearchResult> resultados = proxyService.consultar("Películas populares", new ArrayList<>());
                        System.out.println("Resultados obtenidos: " + resultados.size());
                    } else {
                        System.out.println("Por favor, seleccione un servicio primero (opción 3).");
                    }
                }
                case 5 -> {
                    buscarPelicula();
                }
                case 6 -> contexto.cerrarSesion();
                case 7 -> contexto.mostrarEstado();
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

    public static void buscarPelicula() throws IOException, ParseException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el nombre de la película:");
        String movie = in.readLine();

        StreamingServiceManager.getInstance().setServicio(new CrunchyRollService());
        ArrayList<SearchResult> results = StreamingServiceManager.getInstance().buscarEnServicio(movie, null);
//        ArrayList<SearchResult> results = StreamingServiceManager.getInstance().consultarServicio(movie, null);

        ArrayList<ContenidoResult> contenidos = results.get(0).getContenidos();

//        System.out.println(contenidos.get(0).getTitulo());

        for (ContenidoResult content : contenidos){
            System.out.println(content.getId());
            System.out.println(content.getTitulo());
            System.out.println(content.getDescripcion());
            System.out.println(content.getPopularidad());
            System.out.println(content.getIdioma());
            System.out.println("-----------------------");
        }

    }
}
