package java.org.example.recursos.model;

// Pacote: gestaoescolar.recursos.model

import java.org.example.recursos.prototipo.Prototipo;
import java.util.ArrayList;
import java.util.List;

/**
 * ConcretePrototype (Protótipo Concreto)
 * Esta é a nossa classe "cara" que implementa a interface de clonagem.
 */
public class MaterialDidatico implements Prototipo<MaterialDidatico> {

    private String nome;
    private String disciplina;
    private int anoLetivo;
    private List<String> topicos; // Uma lista de tópicos (objeto complexo)


    /**
     * Construtor "CARO".
     * Simula um carregamento pesado (ex: consulta ao banco de dados).
     */
    public MaterialDidatico(String nome, String disciplina) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.topicos = new ArrayList<>();
        // Simula a operação cara
        carregarTopicosDoBanco();
    }

    /**
     * Construtor de Cópia (PRIVADO).
     * Usado internamente pelo método clonar() para criar a cópia.
     * Esta é a essência do padrão.
     */
    private MaterialDidatico(MaterialDidatico original) {
        this.nome = original.nome;
        this.disciplina = original.disciplina;
        this.anoLetivo = original.anoLetivo;
        
        // ---- PONTO CRÍTICO: DEEP COPY ----
        // Se fizéssemos "this.topicos = original.topicos", ambos os objetos
        // apontariam para a MESMA lista (Shallow Copy).
        // Ao criar uma NOVA ArrayList, garantimos que o clone é independente.
        this.topicos = new ArrayList<>(original.topicos);
    }

    private void carregarTopicosDoBanco() {
        System.out.println("(!) OPERAÇÃO CUSTOSA: Carregando tópicos para " + this.disciplina + "...");
        try {
            // Simula o tempo de uma consulta complexa ao DB
            Thread.sleep(1500); // 1.5 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        this.topicos.add("Tópico 1 - Base");
        this.topicos.add("Tópico 2 - Avançado");
        this.topicos.add("Tópico 3 - Exercícios");
    }

    // Setters para modificar a cópia
    public void setNome(String nome) { this.nome = nome; }
    public void setAnoLetivo(int anoLetivo) { this.anoLetivo = anoLetivo; }
    public void adicionarTopico(String topico) { this.topicos.add(topico); }

    public int getAnoLetivo() {
        return this.anoLetivo;
    }
    /**
     * Implementação do método clonar.
     * Ele é rápido, pois apenas chama o construtor de cópia.
     */
    @Override
    public MaterialDidatico clonar() {
        System.out.println("(+) CLONAGEM: Criando cópia rápida de: " + this.nome);
        return new MaterialDidatico(this);
    }

    @Override
    public String toString() {
        // Usamos o hashCode do objeto para provar que são instâncias diferentes
        String hash = Integer.toHexString(this.hashCode());
        return String.format("MaterialDidatico [Hash: %s, Nome: %s, Ano: %d, Tópicos: %s]",
                             hash, nome, anoLetivo, topicos);
    }
}