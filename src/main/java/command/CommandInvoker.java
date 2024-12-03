package command;

import command.Command;

/**
 * Invoca los comandos que se ejecutan a través del patrón Command.
 */
public class CommandInvoker {
    private Command command;

    /**
     * Establece el comando que se va a ejecutar.
     *
     * @param command Comando a ejecutar.
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * Ejecuta el comando.
     */
    public void invoke() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No hay comando para ejecutar.");
        }
    }
}
