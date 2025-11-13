package org.example.calendario.ChainOfResponsibility;

public interface CalendarioHandler {
    void setNextHandler(CalendarioHandler handler);
    void processarEvento(String evento);
}


