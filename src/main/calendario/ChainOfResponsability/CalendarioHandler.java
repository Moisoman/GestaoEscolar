package org.example.calendario.ChainOfResponsability;

public interface CalendarioHandler {
    void setNextHandler(CalendarioHandler handler);
    void processarEvento(String evento);
}


