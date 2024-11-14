package autenticacionState;
import java.util.Scanner;

public class ContextoAutenticacion{
    private EstadoAutenticacion estadoAutenticacion;
    private static ContextoAutenticacion instancia;
    private String token;
    private String correo;
    private String contrasena;

   public ContextoAutenticacion(){
       this.estadoAutenticacion = new EstadoNoAutenticado();
   }
   public void setEstadoAutenticacion(EstadoAutenticacion estadoAutenticacion) {
       this.estadoAutenticacion = estadoAutenticacion;
   }
   public static ContextoAutenticacion getInstance() {
        if (instancia == null) { // Si no existe, se crea una nueva instancia
            instancia = new ContextoAutenticacion();
        }
        return instancia; // Devuelve la instancia única
   }
    public void setToken(String token) {
        this.token = token;
   }
    public String getToken() {
        return token;
   }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void registrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su correo: ");
        this.correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        this.contrasena = scanner.nextLine();
        System.out.println("Usuario registrado exitosamente.");
    }

    public void iniciarSesion(){
       estadoAutenticacion.iniciarSesion();
    };
    public void accederServicio(){
        estadoAutenticacion.accederServicio();
    };
    public void cerrarSesion(){
        estadoAutenticacion.cerrarSesion();
    };

    public void mostrarEstado() {
    }
}
