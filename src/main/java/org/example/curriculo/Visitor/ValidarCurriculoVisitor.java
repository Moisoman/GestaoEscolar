package java.org.example.curriculo.Visitor;

import java.org.example.entities.Curriculo;

public class ValidarCurriculoVisitor implements CurriculoVisitor {
    @Override
    public void visitar(Curriculo curriculo) {
        if (curriculo.getNomeProfissional() == null || curriculo.getNomeProfissional().isEmpty()) {
            System.out.println("Erro: Nome do profissional não pode ser vazio.");
        }
        if (curriculo.getExperienciaProfissional() == null || curriculo.getExperienciaProfissional().isEmpty()) {
            System.out.println("Erro: Experiência profissional não pode ser vazia.");
        }
        if (curriculo.getHabilidades() == null || curriculo.getHabilidades().isEmpty()) {
            System.out.println("Erro: Habilidades não podem ser vazias.");
        }
    }
}
