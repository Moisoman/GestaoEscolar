package org.example.entities;

import org.example.comunicados.Mediator.ComunicadoMediator;
import org.example.notas.Memento.Nota;
import org.example.notas.Memento.NotaMemento;
import org.example.notas.Memento.NotaMementoCaretaker;

public class Aluno extends Pessoa {
    private ComunicadoMediator mediator;
    private Nota nota;
    private NotaMementoCaretaker caretaker;


    public Aluno(String nome,  ComunicadoMediator mediator, double notaInicial) {
        super(nome);
        this.mediator = mediator;
        this.nota = new Nota(notaInicial);
        this.caretaker = new NotaMementoCaretaker();
    }

    public void receberComunicado(String comunicado) {
        System.out.println("Aluno " + nome + " recebeu o comunicado: " + comunicado);
    }

    public void enviarComunicado(String comunicado) {
        System.out.println("Aluno " + nome + " enviou um comunicado: " + comunicado);
        mediator.enviarComunicado(comunicado, this);  // O mediador envia para todos os outros alunos
    }

    public void salvarEstado() {
        caretaker.salvarMemento(nota.criarMemento());
    }

    // Restaura o estado anterior da nota
    public void restaurarEstado() {
        NotaMemento memento = caretaker.restaurarMemento();
        if (memento != null) {
            nota.restaurarMemento(memento);
        }
    }

    // Modificar a nota
    public void modificarNota(double novaNota) {
        salvarEstado();
        nota.alterarNota(novaNota);
    }

    // Mostrar a nota atual
    public void mostrarNota() {
        System.out.println("Aluno: " + nome);
        nota.mostrarNota();
    }


}
