package org.example.calendario.ChainOfResponsability;

public class HandlerFérias implements CalendarioHandler {
    private CalendarioHandler nextHandler;

    @Override
    public void setNextHandler(CalendarioHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void processarEvento(String evento) {
        if (evento.contains("férias")) {
            System.out.println("Processando evento de férias...");
            System.out.println("Evento de férias adicionado com sucesso!");
        } else if (nextHandler != null) {
            nextHandler.processarEvento(evento);
        }
    }
}
