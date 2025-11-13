package org.example.alunos;


import java.util.ArrayList;
import java.util.List;

public class AlunosObserver implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String mensagem;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(mensagem);
        }
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
        notifyObservers();
    }

    public static void main(String[] args) {
        demonstrarObserver();

    }

    private static void demonstrarObserver() {
        AlunosObserver alunosObserver = new AlunosObserver();

        Observer aluno1 = new NotificarAlunos("João");
        Observer aluno2 = new NotificarAlunos("Maria");
        Observer aluno3 = new NotificarAlunos("Pedro");

        alunosObserver.addObserver(aluno1);
        alunosObserver.addObserver(aluno2);
        alunosObserver.addObserver(aluno3);

        alunosObserver.setMensagem("Aulas serão remarcadas para amanhã!");

        alunosObserver.removeObserver(aluno1);

        alunosObserver.setMensagem("Resultado de provas foi publicado!");
    }
}
