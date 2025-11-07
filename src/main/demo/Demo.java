
// Pacote: gestaoescolar.demo
package main.demo;

// Importações necessárias
import factory.HistoriaFactory;
import factory.MatematicaFactory;
import factory.MaterialDidaticoFactory;
import produtos.Apostila;
import produtos.AplicativoOnline;
import java.util.Scanner;

/**
 * Classe principal para demonstração dos Padrões de Projeto
 * no Sistema de Gestão Escolar.
 */
public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Sistema de Gestão Escolar (Demo Padrões) ---");
            System.out.println("1 - Demonstrar Abstract Factory (Montar Kit Didático)");
            System.out.println("2 - Demonstrar Builder (Configurar Turma) - [Pendente]");
            System.out.println("3 - ... (outros padrões)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = -1;
            try {
                // Lê a linha inteira para evitar problemas com o scanner
                opcao = Integer.parseInt(scanner.nextLine()); 
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, insira um número válido.");
                continue;
            }

            switch (opcao) {
                case 1:
                    // Chama o método que demonstra o Abstract Factory
                    demonstrarAbstractFactory(scanner);
                    break;
                case 2:
                    System.out.println("Padrão Builder ainda não implementado.");
                    break;
                // ... cases para os outros 22 padrões
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    /**
     * Método estático para demonstrar o padrão Abstract Factory.
     * Ele é o "Cliente" do padrão.
     */
    private static void demonstrarAbstractFactory(Scanner scanner) {
        System.out.println("\n### Demonstração: Abstract Factory ###");
        System.out.println("Qual kit de material didático você deseja montar?");
        System.out.println(" (1) - Matemática");
        System.out.println(" (2) - História");
        System.out.print("Opção: ");
        
        String escolha = scanner.nextLine();
        MaterialDidaticoFactory factory; // O cliente só conhece a interface da fábrica

        // A decisão de qual família usar é feita aqui
        if (escolha.equals("1")) {
            factory = new MatematicaFactory();
        } else if (escolha.equals("2")) {
            factory = new HistoriaFactory();
        } else {
            System.out.println("Opção desconhecida, montando kit padrão (Matemática).");
            factory = new MatematicaFactory();
        }

        System.out.println("Montando kit com a fábrica: " + factory.getClass().getSimpleName());

        // O cliente usa a fábrica para criar os produtos
        // Ele não sabe (e não se importa) se é ApostilaCalculo ou ApostilaHistoria
        Apostila apostila = factory.criarApostila();
        AplicativoOnline aplicativo = factory.criarAplicativo();

        // Descreve o kit montado
        System.out.println("\n--- Kit Montado com Sucesso ---");
        System.out.println("Apostila: " + apostila.getTitulo());
        System.out.println("Aplicativo: " + aplicativo.getNome() + " (Acessar em: " + aplicativo.getUrlAcesso() + ")");
        System.out.println("---------------------------------");
    }
}