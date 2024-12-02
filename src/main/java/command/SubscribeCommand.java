package command;

import search.StreamingService;
import Models.Usuario;

/**
 * Comando para suscribirse a un servicio de streaming.
 */
public class SubscribeCommand implements Command {
    private StreamingService servicio;
    private Usuario usuario;

    /**
     * Constructor del comando de suscripción.
     *
     * @param servicio Servicio de streaming al que se suscribirá el usuario.
     * @param usuario Usuario que se suscribe.
     */
    public SubscribeCommand(StreamingService servicio, Usuario usuario) {
        this.servicio = servicio;
        this.usuario = usuario;
    }

    @Override
    public void execute() {
        // Lógica para suscribir al usuario al servicio
        System.out.println("Usuario " + usuario.getNombre() + " suscrito a " + servicio.getClass().getSimpleName());
    }
}
