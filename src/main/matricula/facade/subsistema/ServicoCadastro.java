// Pacote: gestaoescolar.matricula.subsistema
package main.matricula.facade.subsistema;

/**
 * Parte 1 do Subsistema: Cadastro
 */
public class ServicoCadastro {
    public boolean verificarAluno(String cpf) {
        System.out.println("[Cadastro] Verificando se aluno com CPF " + cpf + " já existe...");
        // Simula que o aluno não existe
        return false;
    }

    public void registrarAluno(String nome, String cpf) {
        System.out.println("[Cadastro] Registrando novo aluno: " + nome);
        // Lógica de salvar no banco de dados...
    }
}