package java.org.example.cursos.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class CursoFactory {
    private Map<String, CursoFlyweight> cursos;

    public CursoFactory() {
        cursos = new HashMap<>();
    }

    public CursoFlyweight getCurso(String nomeCurso, String codigoCurso) {
        String chave = nomeCurso + "-" + codigoCurso;
        if (!cursos.containsKey(chave)) {
            cursos.put(chave, new CursoConcreto(nomeCurso, codigoCurso));
        }
        return cursos.get(chave);
    }
}

