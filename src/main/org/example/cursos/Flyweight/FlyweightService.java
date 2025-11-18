package org.example.cursos.Flyweight;

import org.example.entities.Curso;
import org.example.entities.ProfessorCoordenador;
import org.example.entities.Turma;

public class FlyweightService {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Curso cursoMatematica = factory.getCurso("Matemática", "MAT101");
        Curso cursoFisica = factory.getCurso("Física", "FIS101");

        ProfessorCoordenador profJoao = factory.getProfessor("Prof. Coordenador João");
        ProfessorCoordenador profMaria = factory.getProfessor("Prof. Coordenadora Maria");

        Turma turma1 = new Turma("A", "08:00 - 10:00", cursoMatematica, profJoao);
        Turma turma2 = new Turma("B", "10:00 - 12:00", cursoMatematica, profJoao);
        Turma turma3 = new Turma("A", "14:00 - 16:00", cursoFisica, profMaria);
        Turma turma4 = new Turma("B", "16:00 - 18:00", cursoFisica, profMaria);

        turma1.adicionarAluno("João");
        turma1.adicionarAluno("Maria");
        turma2.adicionarAluno("Carlos");
        turma2.adicionarAluno("Ana");
        turma3.adicionarAluno("Lucas");
        turma3.adicionarAluno("Pedro");
        turma4.adicionarAluno("Fernanda");
        turma4.adicionarAluno("Clara");

        turma1.exibirInformacoesTurma();
        System.out.println("=================================");
        turma2.exibirInformacoesTurma();
        System.out.println("=================================");
        turma3.exibirInformacoesTurma();
        System.out.println("=================================");
        turma4.exibirInformacoesTurma();
    }
}
