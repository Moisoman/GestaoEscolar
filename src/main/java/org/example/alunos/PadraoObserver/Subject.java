package java.org.example.alunos.PadraoObserver;
/*
Observer de alunos
 */
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

