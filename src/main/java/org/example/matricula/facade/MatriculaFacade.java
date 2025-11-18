package java.org.example.matricula.facade;


import java.org.example.matricula.facade.subsistema.ServicoCadastro;
import java.org.example.matricula.facade.subsistema.ServicoDeTurmas;
import java.org.example.matricula.facade.subsistema.ServicoFinanceiro;

/**
 * Facade (Fachada)
 * Esta classe é o "balcão de atendimento" único.
 * Ela simplifica o processo complexo de matrícula.
 */
public class MatriculaFacade {

    // A fachada conhece e "contém" o subsistema complexo
    private ServicoCadastro cadastro;
    private ServicoDeTurmas turmas;
    private ServicoFinanceiro financeiro;

    public MatriculaFacade() {
        // Inicializa os serviços do subsistema
        this.cadastro = new ServicoCadastro();
        this.turmas = new ServicoDeTurmas();
        this.financeiro = new ServicoFinanceiro();
    }

    /**
     * Este é o método simples que o cliente chama.
     * Toda a complexidade está escondida aqui dentro.
     */
    public boolean realizarMatricula(String nome, String cpf, String idTurma) {
        System.out.println("\n[FACADE] Iniciando processo de matrícula para: " + nome + "...");

        // 1. Orquestração: Chamar o Cadastro
        if (cadastro.verificarAluno(cpf)) {
            System.out.println("[FACADE] ERRO: Aluno com este CPF já está cadastrado.");
            return false;
        }

        // 2. Orquestração: Chamar as Turmas
        if (!turmas.verificarVagas(idTurma)) {
            System.out.println("[FACADE] ERRO: Não há vagas na turma " + idTurma + ".");
            return false;
        }

        // 3. Orquestração: Chamar o Financeiro
        financeiro.gerarCobrancaMatricula(nome);

        // 4. Orquestração: Finalizar o processo
        cadastro.registrarAluno(nome, cpf);
        turmas.alocarAlunoNaTurma(nome, idTurma);

        System.out.println("[FACADE] Matrícula concluída com sucesso!");
        return true;
    }
}