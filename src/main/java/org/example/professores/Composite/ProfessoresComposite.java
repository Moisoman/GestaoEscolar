package java.org.example.professores.Composite;

import java.org.example.entities.Professor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ProfessoresComposite extends Professor {
    private List<Professor> professores = new ArrayList<>();

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public void removerProfessor(Professor professor) {
        professores.remove(professor);
    }

    @Override
    public void mostrarInformacoes() {
        for (Professor professor : professores) {
            professor.mostrarInformacoes();
        }
    }
}
