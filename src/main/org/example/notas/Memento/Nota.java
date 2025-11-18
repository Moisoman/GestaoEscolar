package org.example.notas.Memento;

public class Nota {
    private double nota;

    public Nota(double nota) {
        this.nota = nota;
    }

    public NotaMemento criarMemento() {
        return new NotaMemento(nota);
    }

    public void restaurarMemento(NotaMemento memento) {
        this.nota = memento.getNota();
    }

    public void alterarNota(double novaNota) {
        this.nota = novaNota;
    }

    public void mostrarNota() {
        System.out.println("Nota atual: " + nota);
    }
}