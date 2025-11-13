package org.example.alunos.PadraoObserver;

public class NotificarAlunos implements Observer {
    private String nome;

    public NotificarAlunos(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String mensagem) {
        System.out.println("Notificando aluno " +nome + ':' +  mensagem);
    }
}
