package org.example.usuarios;

abstract class Usuario {
    protected String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public abstract void exibirInfo();
}


class Aluno extends Usuario {
    public Aluno(String nome) { super(nome); }
    public void exibirInfo() {
        System.out.println("Aluno: " + nome);
    }
}

class Professor extends Usuario {
    public Professor(String nome) { super(nome); }
    public void exibirInfo() {
        System.out.println("Professor: " + nome);
    }
}

// Criador abstrato
abstract class UsuarioFactory {
    public abstract Usuario criarUsuario(String nome);
}

// Fábricas concretas
class AlunoFactory extends UsuarioFactory {
    public Usuario criarUsuario(String nome) {
        return new Aluno(nome);
    }
}

class ProfessorFactory extends UsuarioFactory {
    public Usuario criarUsuario(String nome) {
        return new Professor(nome);
    }
}

// Teste
public class TesteFactoryMethod {
    public static void main(String[] args) {
        UsuarioFactory factoryAluno = new AlunoFactory();
        UsuarioFactory factoryProfessor = new ProfessorFactory();

        Usuario a1 = factoryAluno.criarUsuario("Maria");
        Usuario p1 = factoryProfessor.criarUsuario("Carlos");

        a1.exibirInfo();
        p1.exibirInfo();
    }
}