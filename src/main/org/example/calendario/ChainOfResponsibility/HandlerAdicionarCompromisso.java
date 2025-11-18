package org.example.calendario.ChainOfResponsibility;

public class HandlerAdicionarCompromisso implements CalendarioHandler {
    private CalendarioHandler nextHandler;

    @Override
    public void setNextHandler(CalendarioHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void processarEvento(String evento) {
        if (evento.contains("compromisso")) {
            System.out.println("Adicionando compromisso de aula...");
            System.out.println("Compromisso adicionado com sucesso!");
        } else if (nextHandler != null) {
            nextHandler.processarEvento(evento);
        }
    }
}
