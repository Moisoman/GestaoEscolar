package java.org.example.notas.Memento;

import java.org.example.comunicados.Mediator.ComunicadoMediator;
import java.org.example.comunicados.Mediator.EscolaMediator;
import java.org.example.entities.Aluno;

public class MementoService {
    public static void main(String[] args) {

        EscolaMediator mediator = new EscolaMediator();
        Aluno aluno = new Aluno("Carlos", mediator,5.9);

        aluno.mostrarNota();

        aluno.modificarNota(7.0);
        aluno.mostrarNota();

        aluno.modificarNota(9.5);
        aluno.mostrarNota();

        aluno.restaurarEstado();
        aluno.mostrarNota();

        aluno.restaurarEstado();
        aluno.mostrarNota();

        aluno.modificarNota(8.0);

        aluno.receberComunicado("Nota alterada, nota final:");
        aluno.mostrarNota();
    }
}
