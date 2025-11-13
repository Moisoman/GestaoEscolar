package org.example.entities;

public class Curso {
    private final String nomeCurso;
    private final String codigoCurso;

    public Curso(String nomeCurso, String codigoCurso) {
        this.nomeCurso = nomeCurso;
        this.codigoCurso = codigoCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void exibirCurso() {
        System.out.println("Curso: " + nomeCurso + ", Código: " + codigoCurso);
    }
}
