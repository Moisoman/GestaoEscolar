package org.example.matricula.facade.subsistema;

/**
 * Parte 2 do Subsistema: Turmas
 */
public class ServicoDeTurmas {
    public boolean verificarVagas(String idTurma) {
        System.out.println("[Turmas] Verificando vagas na turma " + idTurma + "...");
        // Simula que sempre há vagas
        return true;
    }

    public void alocarAlunoNaTurma(String nomeAluno, String idTurma) {
        System.out.println("[Turmas] Alocando aluno '" + nomeAluno + "' na turma " + idTurma);
    }
}
