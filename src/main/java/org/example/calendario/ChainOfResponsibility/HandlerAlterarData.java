package java.org.example.calendario.ChainOfResponsibility;

public class HandlerAlterarData implements CalendarioHandler {
    private CalendarioHandler nextHandler;

    @Override
    public void setNextHandler(CalendarioHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void processarEvento(String evento) {
        if (evento.contains("alterar data")) {
            System.out.println("Processando alteração de data do evento...");
            System.out.println("Alteração de data feita com sucesso!");
        } else if (nextHandler != null) {
            nextHandler.processarEvento(evento);
        }
    }
}
