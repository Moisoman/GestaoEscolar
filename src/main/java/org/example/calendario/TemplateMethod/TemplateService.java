package java.org.example.calendario.TemplateMethod;

/**
 * Testa o template method
 */
public class TemplateService {
    public static void main(String[] args) {
        CalendarioTemplate eventoProva = new EventoProva();
        CalendarioTemplate eventoReuniao = new EventoReuniao();

        System.out.println("Agendando evento de prova:");
        eventoProva.agendarEvento();
        System.out.println();

        System.out.println("Agendando evento de reunião:");
        eventoReuniao.agendarEvento();
    }
}
