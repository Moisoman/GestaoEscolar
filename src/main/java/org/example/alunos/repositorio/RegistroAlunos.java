
// Pacote: gestaoescolar.alunos.repositorio
package java.org.example.alunos.repositorio.;

import java.util.ArrayList;
import java.util.List;

/**
 * Padrão Singleton (Implementação "Eager Initialization")
 *
 * Garante UMA ÚNICA instância do registro de alunos.
 * Esta versão é 100% autocontida.
 */
public class RegistroAlunos {

    // 1. A ÚNICA INSTÂNCIA
    private static final RegistroAlunos instance = new RegistroAlunos();

    // Os dados (lista de nomes)
    private List<String> nomesDosAlunos;

    /**
     * 2. Construtor PRIVADO
     */
    private RegistroAlunos() {
        this.nomesDosAlunos = new ArrayList<>();
        // Log para provar que só roda uma vez
        System.out.println("\n(!) [Singleton] Instância de RegistroAlunos criada.\n");
    }

    /**
     * 3. O Ponto de Acesso Global
     */
    public static RegistroAlunos getInstance() {
        return instance;
    }

    // --- Métodos de Negócio (Standalone) ---

    public void adicionarAluno(String nome) {
        System.out.println("[Singleton] Adicionando aluno ao registro: " + nome);
        this.nomesDosAlunos.add(nome);
    }

    public void listarAlunos() {
        System.out.println("\n[Singleton] --- Lista de Alunos Registrados (" + nomesDosAlunos.size() + ") ---");
        if (nomesDosAlunos.isEmpty()) {
            System.out.println("Nenhum aluno registrado no sistema.");
        } else {
            for (String nome : nomesDosAlunos) {
                System.out.println(" - " + nome);
            }
        }
        System.out.println("----------------------------------------------");
    }
}