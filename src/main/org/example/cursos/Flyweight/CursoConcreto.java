package org.example.cursos.Flyweight;

public class CursoConcreto implements CursoFlyweight {
    private String nomeCurso;
    private String codigoCurso;

    public CursoConcreto(String nomeCurso, String codigoCurso) {
        this.nomeCurso = nomeCurso;
        this.codigoCurso = codigoCurso;
    }

    @Override
    public void exibirCurso() {
        System.out.println("Curso: " + nomeCurso + ", Código: " + codigoCurso);
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }
}

