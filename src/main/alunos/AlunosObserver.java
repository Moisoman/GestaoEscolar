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
}
