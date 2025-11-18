package java.org.example.curriculo.Command;

/**
 * Classe que irá chamar os comandos para serem executados
 */
public class Invocador {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executarComando() {
        command.execute();
    }
}