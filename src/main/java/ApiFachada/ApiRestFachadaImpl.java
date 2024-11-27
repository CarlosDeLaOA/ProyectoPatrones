package ApiFachada;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRestFachadaImpl implements ApiRestFachada {

    private String baseUrl = "https://api.themoviedb.org/3/";
    private String apiKey = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNzVkYzIyNzI3NmU0YWQ4NDY4OGI2MzQ1NTQ2MDZlZiIsIm5iZiI6MTcyOTc0NDc2MS45NjkyODksInN1YiI6IjY3MTljZDg4MjY4NWNiNjU2M2MwOTZiNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.SewK_9MKll2KoAcxHzEnx2STJt89uRc7TYAqfsdB_JQ";

    @Override
    public String obtenerRecurso(String url) {
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(baseUrl + url))
                    .header("Authorization", apiKey)
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            System.out.println("Error haciendo GET");
        }
        return "";
    }

    @Override
    public String crearRecurso(String url, String jsonBody) {
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(baseUrl + url))
                    .header("Authorization", apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            System.out.println("Error haciendo POST");
        }
        return "";
    }

    @Override
    public String actualizarRecurso(String url, String jsonBody) {
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(baseUrl + url))
                    .header("Authorization", apiKey)
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            System.out.println("Error haciendo PUT");
        }
        return "";
    }

    @Override
    public String eliminarRecurso(String url) {
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(baseUrl + url))
                    .header("Authorization", apiKey)
                    .DELETE()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            System.out.println("Error haciendo Delete");
        }
        return "";
    }
}

