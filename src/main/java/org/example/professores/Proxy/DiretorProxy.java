package java.org.example.professores.Proxy;

import java.org.example.entities.Diretor;

/**
 * Fornece um substituto ou um representante para outro objeto,
 * controlando o acesso a ele.
 * Ele pode ser usado para controlar a criação,
 * o acesso, e a execução de operações em objetos
 */
public class DiretorProxy implements DiretorInterface {
    private Diretor diretor;
    private String nome;
    private String escola;

    public DiretorProxy(String nome, String escola) {
        this.nome = nome;
        this.escola = escola;
    }

    private void carregarDiretor() {
        if (diretor == null) {
            diretor = new Diretor(nome, escola);
        }
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Acessando informações do diretor...");
        carregarDiretor();
        diretor.mostrarInformacoes();
    }

    @Override
    public void coordenarProfessores() {
        carregarDiretor();
        diretor.coordenarProfessores();
    }

    @Override
    public void fazerReuniaoPedagogica() {
        carregarDiretor();
        diretor.fazerReuniaoPedagogica();
    }
    
}
