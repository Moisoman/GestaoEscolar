
// Pacote: gestaoescolar.demo
package demo;

// Importações necessárias
import factory.HistoriaFactory;
import factory.MatematicaFactory;
import factory.MaterialDidaticoFactory;
import produtos.Apostila;
import turmas.TurmasBuilder;
import produtos.AplicativoOnline;
import model.MaterialDidatico;
import repositorio.RegistroAlunos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Classe principal para demonstração dos Padrões de Projeto
 * no Sistema de Gestão Escolar.
 */
public class Demo {

    // Um "cache" para guardar nossos protótipos já criados
    private static Map<String, MaterialDidatico> prototiposCache = new HashMap<>();

    /**
     * Método para carregar os protótipos "caros" uma única vez.
     */
    public static void carregarPrototipos() {
        System.out.println("### Carregando protótipos base (só deve rodar 1 vez) ###");
        
        // 1. Criando o material de Matemática (operação cara)
        MaterialDidatico matBase = new MaterialDidatico("Apostila Padrão de Matemática", "Matemática");
        matBase.setAnoLetivo(2024);
        prototiposCache.put("MAT-2024", matBase);

        // 2. Criando o material de História (operação cara)
        MaterialDidatico histBase = new MaterialDidatico("Apostila Padrão de História", "História");
        histBase.setAnoLetivo(2024);
        prototiposCache.put("HIST-2024", histBase);
        
        System.out.println("### Protótipos carregados. ###");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Carrega os protótipos "caros" assim que o sistema inicia
        carregarPrototipos();
        
        while (true) {
            System.out.println("\n--- Sistema de Gestão Escolar (Demo Padrões) ---");
            System.out.println("1 - Demonstrar Abstract Factory (Montar Kit Didático)");
            System.out.println("2 - Demonstrar Builder (Configurar Turma)");
            System.out.println("3 - Demonstrar Factory - Inativo");
            System.out.println("4 - Demonstrar Prototype (Clonar Material Didático)");
            System.out.println("5 - Demonstrar Singleton (Registro Central)");
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
                case 4:
                    demonstrarPrototype(scanner);
                    break;
                case 5:
                    // Chama o método de demonstração do Singleton
                    demonstrarSingleton();
                    break;
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
     * Método estático para demonstrar o padrão Prototype.
     * Ele é o "Cliente" do padrão.
     */
    private static void demonstrarPrototype(Scanner scanner) {
        System.out.println("\n### Demonstração: Prototype ###");
        System.out.println("Vamos criar o material para o novo ano letivo (2025) ");
        System.out.println("baseado no protótipo de Matemática de 2024.");

        // 1. Pega o protótipo original do cache (operação rápida)
        MaterialDidatico prototipoMat2024 = prototiposCache.get("MAT-2024");
        
        // 2. CLONA o protótipo (operação rápida)
        // Note: não usamos "new MaterialDidatico()".
        MaterialDidatico materialMat2025 = prototipoMat2024.clonar();

        // 3. Modifica o clone
        materialMat2025.setAnoLetivo(2025);
        materialMat2025.setNome("Apostila Atualizada de Matemática");
        materialMat2025.adicionarTopico("Tópico 4 - Tópicos de 2025");
        
        System.out.println("\n--- Comparação ---");
        System.out.println("ORIGINAL (2024): " + prototipoMat2024.toString());
        System.out.println("CLONE (2025):    " + materialMat2025.toString());
        
        // Prova de que o original não foi modificado
        if (prototipoMat2024.getAnoLetivo() == 2024) {
            System.out.println("\n(SUCESSO: O protótipo original permaneceu intacto!)");
        } else {
            System.out.println("\n(FALHA: O protótipo original foi modificado!)");
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

    // --- MÉTODO DE DEMONSTRAÇÃO DO SINGLETON (AUTOCONTIDO) ---

    /**
     * Método estático para demonstrar o padrão Singleton (VERSÃO STANDALONE).
     * Este método é 100% autocontido e não depende da Opção 3.
     */
    private static void demonstrarSingleton() {
        System.out.println("\n### Demonstração: Singleton (Standalone) ###");
        
        System.out.println("Acessando o registro central e adicionando 'Carlos'...");
        // Pega a instância global e usa.
        RegistroAlunos.getInstance().adicionarAluno("Carlos (adicionado na 1ª chamada)");

        System.out.println("\nAcessando o registro NOVAMENTE e adicionando 'Ana'...");
        // Pega a instância de novo (é a mesma) e usa.
        RegistroAlunos.getInstance().adicionarAluno("Ana (adicionada na 2ª chamada)");

        System.out.println("\n--- Prova de que o estado foi mantido ---");
        System.out.println("Listando todos os alunos da MESMA instância:");
        
        // Pega a instância uma terceira vez e lista.
        // Ele deve listar "Carlos" E "Ana", provando que o estado é global.
        RegistroAlunos.getInstance().listarAlunos();

        // Prova de que as instâncias são as mesmas (opcional, mas bom)
        RegistroAlunos r1 = RegistroAlunos.getInstance();
        RegistroAlunos r2 = RegistroAlunos.getInstance();
        System.out.println("\nProva de Hash: " + r1.hashCode() + " é igual a " + r2.hashCode());
    }
}
