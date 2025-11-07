// Pacote: gestaoescolar.turmas
package turmas;

import java.util.ArrayList;
import java.util.List;
// Assumindo que existem classes Aluno e Professor em outros pacotes
// import gestaoescolar.alunos.Aluno;
// import gestaoescolar.professores.Professor;

/**
 * Produto (Product): A classe complexa 'Turma'.
 * Note que ela é imutável (atributos final) e seu construtor é privado.
 */
public class TurmasBuilder {

    // Atributos
    private final String nomeDaTurma;
    private final int anoLetivo;
    private final String turno;
    private final String sala;
    // private final Professor professorTitular;
    // private final List<Aluno> alunos;
    private final List<String> disciplinas; // Simplificado para List<String>

    /**
     * O único construtor é PRIVADO.
     * Ele só pode ser chamado pelo Builder.
     */
    private TurmasBuilder(TurmaBuilder builder) {
        this.nomeDaTurma = builder.nomeDaTurma;
        this.anoLetivo = builder.anoLetivo;
        this.turno = builder.turno;
        this.sala = builder.sala;
        // this.professorTitular = builder.professorTitular;
        // this.alunos = builder.alunos;
        this.disciplinas = builder.disciplinas;
    }

    // Getters públicos para os atributos
    public String getNomeDaTurma() { return nomeDaTurma; }
    public int getAnoLetivo() { return anoLetivo; }
    public String getTurno() { return turno; }
    public String getSala() { return sala; }
    public List<String> getDisciplinas() { return disciplinas; }

    @Override
    public String toString() {
        return "Turma [Nome=" + nomeDaTurma + ", Ano=" + anoLetivo + 
               ", Turno=" + (turno != null ? turno : "N/D") + 
               ", Sala=" + (sala != null ? sala : "N/D") + 
               ", Disciplinas=" + disciplinas.size() + "]";
    }

    // --- O BUILDER ---

    /**
     * Builder (Construtor): Classe estática aninhada 'TurmaBuilder'.
     * É aqui que a mágica acontece.
     */
    public static class TurmaBuilder {

        // 1. Atributos obrigatórios (final para garantir que sejam passados no construtor)
        private final String nomeDaTurma;
        private final int anoLetivo;

        // 2. Atributos opcionais (mutáveis)
        private String turno;
        private String sala;
        // private Professor professorTitular;
        // private List<Aluno> alunos = new ArrayList<>();
        private List<String> disciplinas = new ArrayList<>();

        /**
         * Construtor do Builder com os campos OBRIGATÓRIOS.
         */
        public TurmaBuilder(String nomeDaTurma, int anoLetivo) {
            if (nomeDaTurma == null || nomeDaTurma.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome da turma é obrigatório.");
            }
            this.nomeDaTurma = nomeDaTurma;
            this.anoLetivo = anoLetivo;
        }

        /**
         * Métodos fluentes para os campos OPCIONAIS.
         * Eles retornam 'this' (a própria instância do Builder)
         * para permitir encadeamento.
         */
        public TurmaBuilder comTurno(String turno) {
            this.turno = turno;
            return this;
        }

        public TurmaBuilder comSala(String sala) {
            this.sala = sala;
            return this;
        }
        
        // public TurmaBuilder comProfessor(Professor professor) {
        //     this.professorTitular = professor;
        //     return this;
        // }

        public TurmaBuilder comDisciplina(String disciplina) {
            this.disciplinas.add(disciplina);
            return this;
        }

        /**
         * O método final: build().
         * Valida os dados e cria a instância do Produto (Turma).
         */
        public TurmasBuilder build() {
            // --- PONTO DE VALIDAÇÃO ---
            // Regra de negócio: Uma turma não pode ser criada sem disciplina.
            if (this.disciplinas.isEmpty()) {
                throw new IllegalStateException("Não é possível criar uma turma sem ao menos uma disciplina.");
            }
            
            // Regra de negócio: Turmas da manhã devem ser na sala B.
            if ("MANHA".equals(this.turno) && this.sala != null && !this.sala.startsWith("B-")) {
                 System.out.println("Aviso: Turma da manhã alocada fora do bloco B.");
            }

            // Cria o objeto Turma imutável
            return new TurmasBuilder(this);
        }
    }
}