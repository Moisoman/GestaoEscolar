package java.org.example.entities;

public class ProfessorCoordenador extends Pessoa {

    public ProfessorCoordenador(String nome) {
        super(nome);
    }

    public void mostrarInformacoes() {
        System.out.println("Professor Coordenador: " + getNome() + " - Responsável pela coordenação do curso.");
    }

}


