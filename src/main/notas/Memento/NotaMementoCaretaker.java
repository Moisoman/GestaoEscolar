package org.example.notas.Memento;

import java.util.Stack;

public class NotaMementoCaretaker {
    private Stack<NotaMemento> mementos = new Stack<>();

    // Salva o memento
    public void salvarMemento(NotaMemento memento) {
        mementos.push(memento);
    }

    // Restaura o último memento
    public NotaMemento restaurarMemento() {
        if (!mementos.isEmpty()) {
            return mementos.pop();
        }
        return null;
    }
}
