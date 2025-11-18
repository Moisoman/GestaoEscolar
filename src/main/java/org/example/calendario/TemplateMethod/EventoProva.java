package java.org.example.calendario.TemplateMethod;

public class EventoProva extends CalendarioTemplate {

    @Override
    protected void verificarDisponibilidade() {
        System.out.println("Verificando disponibilidade para agendar a prova...");
    }

    @Override
    protected boolean precisaDeAprovacao() {
        return true;
    }

    @Override
    protected void registrarEvento() {
        System.out.println("Registrando evento de prova no calendário...");
        System.out.println("Marcada para 2/12");
    }

    @Override
    protected void enviarNotificacoes() {
        System.out.println("Enviando notificações para alunos e professores sobre a prova...");
    }
}
