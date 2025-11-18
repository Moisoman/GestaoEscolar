package java.org.example.curriculo.Visitor;

import java.org.example.entities.Curriculo;

public class ImprimirCurriculoVisitor implements CurriculoVisitor {
    @Override
    public void visitar(Curriculo curriculo) {
        System.out.println("Currículo do Profissional:");
        System.out.println("Nome: " + curriculo.getNomeProfissional());
        System.out.println("Experiência: " + curriculo.getExperienciaProfissional());
        System.out.println("Habilidades: " + curriculo.getHabilidades());
    }

}
