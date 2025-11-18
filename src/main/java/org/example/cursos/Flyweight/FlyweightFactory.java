package java.org.example.cursos.Flyweight;

import java.org.example.entities.Curso;
import java.org.example.entities.ProfessorCoordenador;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private Map<String, Curso> cursos;
    private Map<String, ProfessorCoordenador> professores;

    public FlyweightFactory() {
        cursos = new HashMap<>();
        professores = new HashMap<>();
    }

    public Curso getCurso(String nomeCurso, String codigoCurso) {
        String chave = nomeCurso + "-" + codigoCurso;
        if (!cursos.containsKey(chave)) {
            cursos.put(chave, new Curso(nomeCurso, codigoCurso));
        }
        return cursos.get(chave);
    }

    public ProfessorCoordenador getProfessor(String nomeProfessor) {
        if (!professores.containsKey(nomeProfessor)) {
            professores.put(nomeProfessor, new ProfessorCoordenador(nomeProfessor));
        }
        return (ProfessorCoordenador) professores.get(nomeProfessor);
    }

}
