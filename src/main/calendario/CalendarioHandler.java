package org.example.calendario;

public interface CalendarioHandler {
    void setNextHandler(CalendarioHandler handler);
    void processarEvento(String evento);
}


