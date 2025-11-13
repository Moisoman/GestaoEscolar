package org.example.entities;

import org.example.calendario.TemplateMethod.CalendarioTemplate;
import org.example.calendario.TemplateMethod.EventoReuniao;

public class Diretor {
    private String nome;
    private String escola;

    CalendarioTemplate reuniao =  new EventoReuniao();

    public Diretor(String nome, String escola) {
        this.nome = nome;
        this.escola = escola;
    }

    public void mostrarInformacoes() {
        System.out.println("Diretor: " + nome);
        System.out.println("Escola: " + escola);
    }

    public void coordenarProfessores() {
        System.out.println(nome + " está coordenando os professores da escola:" + escola);
    }

    public void fazerReuniaoPedagogica() {
        System.out.println(nome + " vai agendar uma reunião\n");
        reuniao.agendarEvento();
    }
}
