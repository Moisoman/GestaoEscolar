package org.example.calendario.TemplateMethod;

/**
 * Define o esqueleto de um algoritmo em uma classe base,
 * deixando os detalhes específicos para as subclasses. Ele permite que
 * uma classe defina a estrutura de um processo,
 * mas permite que as subclasses definam alguns passos ou
 * detalhes do processo sem alterar sua estrutura.
 */
public abstract class CalendarioTemplate {

    public final void agendarEvento() {
        verificarDisponibilidade();
        if (precisaDeAprovacao()) {
            aprovarEvento();
        }
        registrarEvento();
        enviarNotificacoes();
    }

    protected abstract void verificarDisponibilidade();

    protected boolean precisaDeAprovacao() {
        return false;
    }

    protected void aprovarEvento() {
        System.out.println("Evento aprovado!");
    }

    protected abstract void registrarEvento();

    protected abstract void enviarNotificacoes();
}