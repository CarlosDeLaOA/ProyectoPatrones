package observer;

import java.util.ArrayList;

public class NotificationManager {
    private ArrayList<ISubscriptor> subscriptores = new ArrayList<>();

    public void subscribirse(ISubscriptor subscriptor){
        subscriptores.add(subscriptor);
    }
    public void desubscribirse(ISubscriptor subscriptor){
        subscriptores.remove(subscriptor);
    }
    public void notifySubcribers(String mensaje){
        for (ISubscriptor subscriptor: subscriptores){
            subscriptor.actualizar(mensaje);
        }
    }
}
