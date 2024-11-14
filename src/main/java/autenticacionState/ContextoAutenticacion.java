package autenticacionState;

public class ContextoAutenticacion{
   private EstadoAutenticacion estadoAutenticacion;

   public ContextoAutenticacion(){
       this.estadoAutenticacion = new EstadoNoAutenticado();
   }

    public void setEstadoAutenticacion(EstadoAutenticacion estadoAutenticacion) {
        this.estadoAutenticacion = estadoAutenticacion;
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
}
