package ApiFachada;

public class ClienteApiRest {
    private static ClienteApiRest instance;

    private ApiRestFachada apiRestFachada;

    private ClienteApiRest() {
        apiRestFachada = new ApiRestFachadaImpl();
    }

    public static ClienteApiRest getInstance() {
        if (instance == null) {
            instance = new ClienteApiRest();
        }
        return instance;
    }

    public ApiRestFachada getApiRestFachada() {
        return apiRestFachada;
    }
}
