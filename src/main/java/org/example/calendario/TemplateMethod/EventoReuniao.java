package java.org.example.calendario.TemplateMethod;

public class EventoReuniao extends CalendarioTemplate {

    @Override
    protected void verificarDisponibilidade() {
        System.out.println("Verificando disponibilidade para agendar a reunião...");
    }

    @Override
    protected boolean precisaDeAprovacao() {
        return false;  // Reuniões não precisam de aprovação
    }

    @Override
    protected void registrarEvento() {
        System.out.println("Registrando evento de reunião no calendário...");
        System.out.println("Marcada para 18/11");
    }

    @Override
    protected void enviarNotificacoes() {
        System.out.println("Enviando notificações para os participantes da reunião...");
    }
}
