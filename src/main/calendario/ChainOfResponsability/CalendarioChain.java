package org.example.calendario.ChainOfResponsability;

public class CalendarioChain {
    public static void main(String[] args) {
        // Criando os handlers
        CalendarioHandler handlerFérias = new HandlerFérias();
        CalendarioHandler handlerAlterarData = new HandlerAlterarData();
        CalendarioHandler handlerAdicionarCompromisso = new HandlerAdicionarCompromisso();

        // Configurando a cadeia de responsabilidade
        handlerFérias.setNextHandler(handlerAlterarData);
        handlerAlterarData.setNextHandler(handlerAdicionarCompromisso);

        // Testando os eventos
        String evento1 = "férias de julho";
        String evento2 = "alterar data do evento de reunião";
        String evento3 = "compromisso de aula de matemática";

        // Passando os eventos pela cadeia
        System.out.println("Evento 1:");
        handlerFérias.processarEvento(evento1);

        System.out.println("\nEvento 2:");
        handlerFérias.processarEvento(evento2);

        System.out.println("\nEvento 3:");
        handlerFérias.processarEvento(evento3);
    }
}
