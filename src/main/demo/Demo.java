
// Pacote: gestaoescolar.demo
package demo;

// Importações necessárias
import factory.HistoriaFactory;
import factory.MatematicaFactory;
import factory.MaterialDidaticoFactory;
import produtos.Apostila;
import turmas.TurmasBuilder;
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
            System.out.println("2 - Demonstrar Builder (Configurar Turma)");
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
                    // Chama o método que demonstra o Builder
                    demonstrarBuilder();
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

    /**
     * Método estático para demonstrar o padrão Builder.
     * Ele é o "Cliente" do padrão.
     */
    private static void demonstrarBuilder() {
        System.out.println("\n### Demonstração: Builder ###");
        System.out.println("Criando duas turmas com configurações complexas...");

        // --- Cenário 1: Turma de TI (completa) ---
        // O cliente usa a interface fluente do Builder
        System.out.println("\nConstruindo Turma de TI (Completa)...");
        TurmasBuilder turmaTI = new TurmasBuilder.TurmaBuilder("TADS-2024", 2024)
                .comTurno("NOITE")
                .comSala("C-301")
                .comDisciplina("Programação Orientada a Objetos")
                .comDisciplina("Banco de Dados I")
                .comDisciplina("Engenharia de Software")
                .build(); // O objeto Turma é criado aqui!
        
        System.out.println("Turma Criada: " + turmaTI.toString());

        // --- Cenário 2: Turma de Pedagogia (mínima) ---
        // Note que o cliente não precisa se preocupar com os campos nulos.
        System.out.println("\nConstruindo Turma de Pedagogia (Mínima)...");
        TurmasBuilder turmaPedagogia = new TurmasBuilder.TurmaBuilder("PED-2024", 2024)
                .comTurno("MANHA")
                // Sem sala definida intencionalmente
                .comDisciplina("Didática Geral")
                .build();

        System.out.println("Turma Criada: " + turmaPedagogia.toString());

        // --- Cenário 3: Tentativa de falha (Validação) ---
        System.out.println("\nTentando construir Turma sem disciplina (Deve falhar)...");
        try {
            TurmasBuilder turmaFantasma = new TurmasBuilder.TurmaBuilder("FANTASMA-2024", 2024)
                    .comTurno("NOITE")
                    .comSala("A-100")
                    .build(); // <- Esta linha vai lançar uma exceção
            
            System.out.println("ERRO: Turma fantasma foi criada! " + turmaFantasma.toString());
        } catch (IllegalStateException e) {
            System.out.println("SUCESSO: Falha ao construir turma, como esperado.");
            System.out.println("Mensagem: " + e.getMessage());
        }
    }
}
