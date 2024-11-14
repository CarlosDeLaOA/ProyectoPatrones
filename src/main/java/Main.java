import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n1. Iniciar Sesión\n2. Acceder a Servicio\n3. Cerrar Sesión\n0. Salir");
            option = scanner.nextInt();

            switch ( option) {
                case 1 -> contexto.iniciarSesion();
                case 2 -> contexto.accederServicio();
                case 3 -> contexto.cerrarSesion();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while ( option != 0);
    }

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
