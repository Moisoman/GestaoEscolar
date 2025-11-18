// Pacote: gestaoescolar.matricula.subsistema
package org.example.matricula.facade.subsistema;

import java.util.HashSet;
import java.util.Set;

/**
 * Parte 1 do Subsistema: Cadastro
 * (Melhorado com uma lista para simular o DB)
 */
public class ServicoCadastro {
    
    // Simula uma tabela de CPFs no banco de dados
    private Set<String> cpfsRegistrados = new HashSet<>();

    public boolean verificarAluno(String cpf) {
        System.out.println("[Cadastro] Verificando se aluno com CPF " + cpf + " já existe...");
        return cpfsRegistrados.contains(cpf); // Agora verifica de verdade
    }

    public void registrarAluno(String nome, String cpf) {
        System.out.println("[Cadastro] Registrando novo aluno: " + nome);
        cpfsRegistrados.add(cpf); // Salva o CPF no "banco"
    }
}