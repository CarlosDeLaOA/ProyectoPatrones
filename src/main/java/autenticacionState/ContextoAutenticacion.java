package autenticacionState;

import java.util.Scanner;

/**
 * Clase que gestiona el contexto de autenticación de un usuario.
 * Permite registrar un usuario, iniciar sesión, cerrar sesión y acceder a un servicio.
 */
public class ContextoAutenticacion {
    private EstadoAutenticacion estadoAutenticacion;
    private static ContextoAutenticacion instancia;
    private String token;
    private String correo;
    private String contrasena;

    /**
     * Constructor privado para evitar la creación directa de instancias.
     * Inicializa el estado a EstadoNoAutenticado.
     */
    public ContextoAutenticacion() {
        this.estadoAutenticacion = new EstadoNoAutenticado();
    }

    /**
     * Obtiene la instancia única de ContextoAutenticacion.
     * Implementa el patrón Singleton para asegurar una única instancia de contexto en el sistema.
     *
     * @return La instancia única de ContextoAutenticacion.
     */
    public static ContextoAutenticacion getInstance() {
        if (instancia == null) {
            instancia = new ContextoAutenticacion();
        }
        return instancia;
    }

    /**
     * Establece el estado de autenticación actual.
     *
     * @param estadoAutenticacion El nuevo estado de autenticación.
     */
    public void setEstadoAutenticacion(EstadoAutenticacion estadoAutenticacion) {
        this.estadoAutenticacion = estadoAutenticacion;
    }

    /**
     * Establece el token de autenticación actual.
     *
     * @param token El token generado después de la autenticación.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Obtiene el token de autenticación actual.
     * @return El token de autenticación.
     */
    public String getToken() {
        return token;
    }

    /**
     * Establece el correo electrónico del usuario registrado.
     * @param correo El correo electrónico del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el correo electrónico del usuario registrado
     * @return El correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece la contraseña del usuario registrado.
     * @param contrasena La contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene la contraseña del usuario registrado
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Permite registrar un nuevo usuario ingresando su correo y contraseña.
     * Solicita la entrada del usuario y almacena las credenciales.
     */
    public void registrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su correo: ");
        this.correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        this.contrasena = scanner.nextLine();
        System.out.println("Usuario registrado exitosamente.");
    }

    /**
     * Inicia sesión para el usuario actual en el estado de autenticación actual.
     * método iniciarSesion() en la instancia de estado actual.
     */
    public void iniciarSesion() {
        estadoAutenticacion.iniciarSesion();
    }

    /**
     * Permite el acceso al servicio para el usuario autenticado.
     *  método accederServicio() en la instancia de estado actual.
     */
    public void accederServicio() {
        estadoAutenticacion.accederServicio();
    }

    /**
     * Cierra la sesión para el usuario actual.
     * método cerrarSesion() en la instancia de estado actual.
     */
    public void cerrarSesion() {
        estadoAutenticacion.cerrarSesion();
    }

    /**
     * Muestra el estado actual de autenticación del usuario.
     * método mostrarEstado() en la instancia de estado actual.
     */
    public void mostrarEstado() {
        estadoAutenticacion.mostrarEstado();
    }
}
