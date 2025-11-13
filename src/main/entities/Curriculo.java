package org.example.entities;

import org.example.curriculo.Visitor.CurriculoVisitor;

public class Curriculo {
    private String nomeProfissional;
    private String experienciaProfissional;
    private String habilidades;

    public Curriculo(String nomeProfissional, String experienciaProfissional, String habilidades) {
        this.nomeProfissional = nomeProfissional;
        this.experienciaProfissional = experienciaProfissional;
        this.habilidades = habilidades;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public String getExperienciaProfissional() {
        return experienciaProfissional;
    }

    public String getHabilidades() {
        return habilidades;
    }


    public void atualizarExperiencia(String novaExperiencia) {
        this.experienciaProfissional = novaExperiencia;
        System.out.println(nomeProfissional + " atualizou a experiência: " + novaExperiencia);
    }

    public void atualizarHabilidades(String novasHabilidades) {
        this.habilidades = novasHabilidades;
        System.out.println(nomeProfissional + " atualizou as habilidades: " + novasHabilidades);
    }

    public void removerExperiencia() {
        this.experienciaProfissional = null;
        System.out.println(nomeProfissional + " removeu a experiência profissional.");
    }

    public void removerHabilidades() {
        this.habilidades = null;
        System.out.println(nomeProfissional + " removeu as habilidades.");
    }

    @Override
    public String toString() {
        return "Currículo de " + nomeProfissional + " - Experiência: " + experienciaProfissional + ", Habilidades: " + habilidades;
    }

    public void criarHabilidades(String novasHabilidades) {
        this.habilidades = novasHabilidades;
        System.out.println(nomeProfissional + " adicionou as habilidades: " + novasHabilidades);
    }

    public void criarExperiencia(String novaExperiencia) {
        this.experienciaProfissional = novaExperiencia;
        System.out.println(nomeProfissional + " adicionou a experiência: " + novaExperiencia);
    }

    public void aceitar(CurriculoVisitor visitor) {
        visitor.visitar(this);
    }
}

