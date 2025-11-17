# GestaoEscolar
Link para o chat: https://gemini.google.com/share/6e6fb0cb73ab

# Abstract Factory

O Abstract Factory é um dos padrões criacionais mais importantes e, por vezes, confundido com o Factory Method. Vamos esclarecê-lo.

O foco dele é criar famílias de objetos relacionados sem que o cliente precise saber quais classes concretas estão sendo usadas.

Seguindo o seu plano de "Gestão de Recursos", nosso exemplo será a criação de kits de material didático (apostilas e aplicativos) para diferentes disciplinas (Matemática, História), garantindo que os materiais sejam sempre compatíveis.

1. Padrão: Abstract Factory (Fábrica Abstrata)
Nome: Abstract Factory (Fábrica Abstrata)
Propósito: Fornecer uma interface para criar famílias de objetos relacionados ou dependentes (produtos) sem especificar suas classes concretas. Ele encapsula a criação de um "kit" de objetos.

2. Motivação (Problema / Solução)
Problema (Contexto: Gestão Escolar): Imagine que seu sistema de gestão escolar precisa montar kits de material didático para os alunos. Cada disciplina tem seu próprio conjunto de materiais que devem ser compatíveis. Por exemplo:
Kit de Matemática: Requer uma Apostila de Cálculo e um Aplicativo de Geometria.
Kit de História: Requer uma Apostila de História Antiga e um Aplicativo de Mapa Histórico.
O problema é: como garantir que a classe Secretaria, ao montar um kit, nunca misture uma Apostila de Cálculo com um Aplicativo de Mapa Histórico? Um código ingênuo cheio de if (disciplina == "MATEMATICA") { ... } else if (disciplina == "HISTORIA") { ... } se tornaria complexo, difícil de manter e propenso a erros.
Solução (Usando Abstract Factory): Criamos uma interface "fábrica" (MaterialDidaticoFactory) que define o que é necessário para um kit (ex: criarApostila() e criarAplicativo()).
Em seguida, criamos fábricas concretas para cada "família" (disciplina):
MatematicaFactory: Sabe criar ApostilaCalculo e AplicativoGeometria.
HistoriaFactory: Sabe criar ApostilaHistoriaAntiga e AplicativoMapaHistorico.
A classe Secretaria (o cliente) decide qual fábrica usar, mas a partir daí, ela apenas chama os métodos criarApostila() e criarAplicativo(), sem nunca saber a classe concreta. A fábrica garante 100% de compatibilidade dentro daquela família.

3. Estrutura (Diagrama UML)
Aqui está a descrição dos componentes do diagrama UML para este padrão:
AbstractFactory (MaterialDidaticoFactory):
Interface que declara os métodos de criação para cada produto abstrato.
Métodos: criarApostila() e criarAplicativo().
ConcreteFactory (MatematicaFactory, HistoriaFactory):
Classes que implementam MaterialDidaticoFactory.
MatematicaFactory implementa criarApostila() retornando ApostilaCalculo e criarAplicativo() retornando AplicativoGeometria.
HistoriaFactory faz o análogo para seus produtos.
AbstractProduct (Apostila, AplicativoOnline):
Interfaces que definem os tipos de produtos que podem ser criados.
Apostila tem o método getTitulo().
AplicativoOnline tem o método getUrlAcesso().
ConcreteProduct (ApostilaCalculo, AplicativoGeometria, ApostilaHistoriaAntiga, AplicativoMapaHistorico):
As implementações reais dos produtos, criadas pelas fábricas concretas.
Client (Secretaria ou PadroesDeProjetoMain):
Utiliza apenas as interfaces MaterialDidaticoFactory, Apostila e AplicativoOnline.

4. Estrutura de Pacotes e Arquivos
Aqui está como a árvore de diretórios do seu projeto ficaria (assumindo uma estrutura Java padrão). Os arquivos que acabamos de criar estão marcados com [AF]:
/gestao-escolar
└── src
    └── main
        └── java
            └── gestaoescolar
                |
                |-- alunos/
                |   |-- Aluno.java
                |   |-- AlunoFactory.java
                |   `-- ...
                |
                |-- professores/
                |   `-- ...
                |
                |-- recursos/  <-- NOSSO MÓDULO
                |   |
                |   |-- factory/
                |   |   |-- MaterialDidaticoFactory.java  [AF - Interface Fábrica]
                |   |   |-- MatematicaFactory.java        [AF - Fábrica Concreta]
                |   |   `-- HistoriaFactory.java        [AF - Fábrica Concreta]
                |   |
                |   `-- produtos/
                |       |-- Apostila.java                 [AF - Interface Produto A]
                |       |-- AplicativoOnline.java         [AF - Interface Produto B]
                |       |
                |       |-- matematica/  <-- Família 1
                |       |   |-- ApostilaCalculo.java      [AF - Produto Concreto]
                |       |   `-- AplicativoGeometria.java  [AF - Produto Concreto]
                |       |
                |       `-- historia/    <-- Família 2
                |           |-- ApostilaHistoriaAntiga.java [AF - Produto Concreto]
                |           `-- AplicativoMapaHistorico.java[AF - Produto Concreto]
                |
                `-- demo/  <-- Pacote para a demonstração
                    |
                    `-- Demo.java  [Classe Principal com o menu]

5. Integração com o Menu Principal
Como você mencionou no seu plano, a melhor forma de demonstrar é com um menu interativo no console.
A classe DemoAbstractFactory que eu criei antes era apenas para fins de teste. Agora, vamos integrar essa lógica dentro da sua classe Demo (ou PadroesDeProjetoMain) principal, como uma das opções do menu.
Aqui está o código da sua classe Demo.java (ou PadroesDeProjetoMain.java), agora com a opção "1" funcional:

# Builder

Vamos aplicar o Builder na  Gestão de Turmas. O objetivo é "construir a configuração de uma turma (disciplinas, horários, número de alunos) de maneira flexível".

Este padrão é ideal para objetos que têm muitos parâmetros de configuração, alguns obrigatórios e muitos opcionais.

1. Padrão: Builder (Construtor)
Nome: Builder
Propósito: Separar o processo de construção de um objeto complexo de sua representação final. Isso permite que o mesmo processo de construção possa criar diferentes representações. Em Java, é mais conhecido por permitir a criação de objetos complexos passo a passo, de forma legível e garantindo um estado final válido.

2. Motivação (Problema / Solução)
Problema (Contexto: Gestão Escolar): Imagine criar um objeto Turma. Uma turma tem atributos:
Obrigatórios: nomeDaTurma (ex: "MAT101"), anoLetivo (ex: 2024).
Opcionais: professorTitular, sala, listaDeAlunos, listaDeDisciplinas, turno (Manhã/Tarde/Noite).
Como você cria uma instância de Turma?
Construtor "Telescópico"? Você teria que criar múltiplos construtores: Turma(nome, ano) Turma(nome, ano, professor) Turma(nome, ano, professor, sala) Turma(nome, ano, professor, sala, turno) ... isso é impraticável, ilegível e propenso a erros (inverter a ordem de sala e turno, por exemplo).
Construtor Padrão + Setters? Turma t = new Turma(); t.setNome("MAT101"); t.setAnoLetivo(2024); t.setProfessor(profJoao); ... O problema aqui é: o que acontece se o programador esquecer de chamar setNome()? E se o objeto Turma for usado antes de estar completo? O objeto pode existir em um estado inválido por um tempo.
Solução (Usando Builder): Criamos uma classe interna (normalmente estática) chamada TurmaBuilder.
O cliente obtém uma instância do Builder, passando os parâmetros obrigatórios no construtor do builder (ex: new TurmaBuilder("MAT101", 2024)).
O cliente usa métodos fluentes (que retornam this) para configurar os parâmetros opcionais (ex: .comProfessor(profJoao).comSala("B-102")).
No final, o cliente chama o método build().
O método build() (dentro do TurmaBuilder) executa validações (ex: "a turma tem pelo menos uma disciplina?") e, se tudo estiver OK, ele chama o construtor privado da classe Turma, passando a si mesmo (this) como argumento.
Isso garante que o objeto Turma só é instanciado em um estado completo e válido, e a leitura do código de criação fica limpa e explícita.

3. Estrutura (Diagrama UML)
Para esta implementação (o "Modern Java Builder"), a estrutura é:
Product (Turma):
A classe complexa que queremos criar
Possui um construtor privado que aceita um TurmaBuilder como argumento.
Geralmente é imutável (seus atributos são final).
Builder (TurmaBuilder):
Uma classe estática aninhada (nested static class) dentro de Turma.
Possui os mesmos atributos da Turma, mas mutáveis.
Tem um construtor público para os campos obrigatórios.
Tem métodos fluentes (ex: comSala(...)) para os campos opcionais.
Tem o método build() que chama o construtor privado de Turma e retorna a instância do produto.
Client (Demo):
A classe que utiliza o TurmaBuilder para criar uma Turma.

# Prototype

Este padrão se encaixa perfeitamente no seu plano, na "7. Gestão de Recursos", para "criar clones de turmas e materiais".

O objetivo do Prototype é criar novos objetos copiando uma instância existente (um "protótipo"), em vez de criar o objeto "do zero". Isso é útil quando a criação de um objeto é cara ou complexa.

1. Padrão: Prototype (Protótipo)
Nome: Prototype
Propósito: Especificar os tipos de objetos a serem criados usando uma instância-protótipo e criar novos objetos pela cópia (clonagem) desse protótipo.

2. Motivação (Problema / Solução)
Problema (Contexto: Gestão Escolar): Imagine que, no seu sistema, um objeto MaterialDidatico é muito "caro" para ser criado. Talvez, para ser montado, ele precise fazer 10 consultas ao banco de dados para carregar todos os tópicos, exercícios e referências.
Agora, a Secretaria precisa criar o Material de Matemática para 2025. Esse material é 95% idêntico ao Material de Matemática de 2024, mudando apenas o ano e um ou dois tópicos novos.
O código "ingênuo" criaria um novo objeto (new MaterialDidatico(...)) e executaria novamente as 10 consultas caras ao banco de dados, o que é um desperdício de tempo e recursos.
Solução (Usando Prototype):
Temos uma instância "mãe" já criada (o Material de Matemática de 2024), que chamamos de protótipo.
Quando queremos o material de 2025, em vez de new, nós pedimos ao protótipo: material2025 = prototipoMatematica2024.clonar().
Este método clonar() cria uma nova instância em memória e copia todos os atributos do protótipo (inclusive a lista de tópicos já carregada) para ela. Isso é quase instantâneo.
Agora, só precisamos fazer as pequenas modificações: material2025.setAnoLetivo(2025); material2025.adicionarTopico("Novo Tópico de IA");
Ganhamos performance, pois evitamos o processo de construção caro.

3. Estrutura (Diagrama UML)
A estrutura pode ser implementada de algumas formas em Java. A forma mais moderna e segura (que usaremos) é com um construtor de cópia e uma interface de clonagem.
Prototype (Prototipo):
Uma interface que criaremos, com um método clonar().
(Alternativa: usar a interface Cloneable nativa do Java, mas ela tem suas complicações).
ConcretePrototype (MaterialDidatico):
A classe que implementa Prototipo.
Ela sabe como criar uma cópia de si mesma (geralmente usando um construtor de cópia privado).
Client (Demo / PrototipoCache):
A classe que precisa de um novo objeto e, em vez de usar new, usa o prototipo.clonar().

# Singleton

Sem qualquer dependência de outros padrões (como o Aluno do Factory Method).

Aqui está tudo o que você precisa. Este exemplo demonstra o padrão de forma isolada, usando um RegistroAlunos que armazena uma lista simples de String (nomes).

1. Padrão: Singleton (Instância Única)
Nome: Singleton
Propósito: Garantir que uma classe tenha somente uma instância em toda a aplicação e fornecer um ponto de acesso global a essa instância.

2. Motivação (Problema / Solução)
Problema (Contexto: Gestão Escolar): Seu sistema precisa de um local central para registrar todos os alunos matriculados. Se o "Módulo de Matrícula" criar sua própria lista (new RegistroAlunos()) e o "Módulo de Relatórios" criar outra (new RegistroAlunos()), eles estarão olhando para bancos de dados diferentes. O módulo de relatórios não verá os alunos que o módulo de matrícula acabou de adicionar. O estado do sistema se torna inconsistente.
Solução (Usando Singleton): Forçamos todos os módulos do sistema a usar a exatamente mesma instância do RegistroAlunos. Fazemos isso:
Tornando o construtor private (impedindo o new).
Fornecendo um método public static getInstance() que sempre retorna a única instância que a própria classe criou.

3. Estrutura (Diagrama UML)
Singleton (RegistroAlunos):
- instance: static final RegistroAlunos (O atributo estático que guarda a si mesmo).
- nomesDosAlunos: List<String> (Os dados internos).
- RegistroAlunos() (O construtor privado).
+ getInstance(): static RegistroAlunos (O método de acesso global).
+ adicionarAluno(String nome): void (Método de negócio).
+ listarAlunos(): void (Método de negócio).

# Adapter
Este é o primeiro padrão Estrutural da lista. Conforme seu plano, ele se encaixa na "3. Gestão de Notas e Avaliações" para "adaptar o formato das notas de um sistema antigo para o novo sistema".

A função do Adapter é ser um "tradutor". Ele permite que duas interfaces incompatíveis trabalhem juntas.

1. Padrão: Adapter (Adaptador)
Nome: Adapter (ou Wrapper)
Propósito: Converter a interface de uma classe (o "Adaptado") em outra interface que o cliente espera (o "Alvo"). O Adapter permite que classes com interfaces incompatíveis colaborem.

2. Motivação (Problema / Solução)
Problema (Contexto: Gestão Escolar): Seu novo Sistema de Gestão Escolar é moderno. Ele tem um ServicoDeBoletim que, para calcular a média, espera receber um array de notas em double[].
No entanto, a escola ainda usa um sistema legado (SistemaDeNotasAntigo) que foi comprado de outra empresa. Este sistema antigo é uma "caixa preta" (não podemos alterá-lo) e ele retorna as notas em um formato totalmente diferente: um único Map<String, String>, onde a chave é o nome da matéria e o valor é a nota como String (ex: "P1", "8.5").
O novo ServicoDeBoletim (Cliente) não sabe ler Map<String, String>. Ele espera double[]. Como fazer os dois conversarem sem "poluir" o código novo com lógica de conversão?
Solução (Usando Adapter): Criamos uma classe "tradutora": AdaptadorDeNotasLegado.
O Alvo (Target) que o cliente quer é a interface FonteDeNotas. Ela tem o método double[] getNotas(String idAluno).
O Adaptado (Adaptee) é a classe SistemaDeNotasAntigo com o método Map<String, String> buscarNotasLegado(String idAluno).
O AdaptadorDeNotasLegado implementa a interface FonteDeNotas (o que o cliente quer).
Internamente, o AdaptadorDeNotasLegado contém uma instância do SistemaDeNotasAntigo.
Quando o cliente chama adaptador.getNotas(), o adaptador, por baixo dos panos, executa a "tradução": a. Chama o sistemaAntigo.buscarNotasLegado(). b. Recebe o Map<String, String>. c. Itera sobre o mapa, converte as Strings em doubles. d. Coloca esses doubles em um double[]. e. Retorna o double[] para o cliente.
O cliente (ServicoDeBoletim) fica feliz, pois recebeu os dados no formato que esperava, e não faz a menor ideia de que falou com um sistema legado.

3. Estrutura (Diagrama UML)
Target (FonteDeNotas): A interface que o nosso novo sistema (Cliente) entende e espera.
Método: getNotas(String idAluno): double[]
Client (ServicoDeBoletim): A classe do nosso novo sistema que usa a interface FonteDeNotas.
Adaptee (SistemaDeNotasAntigo): A classe legada com a interface incompatível.
Método: buscarNotasLegado(String idAluno): Map<String, String>
Adapter (AdaptadorDeNotasLegado): A classe "tradutora".
implements FonteDeNotas
private SistemaDeNotasAntigo sistemaAntigo; (contém o adaptado)
No método getNotas(), ele chama sistemaAntigo.buscarNotasLegado() e traduz o resultado.

# Facade
Vamos usá-lo para simplificar o processo de matrícula.

O objetivo do Facade (Fachada) é fornecer uma interface unificada e simplificada para um conjunto de interfaces de um subsistema complexo. Ele é como um "balcão de atendimento".

1. Padrão: Facade (Fachada)
Nome: Facade
Propósito: Fornecer uma interface simplificada para um subsistema complexo. Em vez de o cliente ter que interagir com 5 ou 6 classes diferentes para realizar uma tarefa, ele interage apenas com uma (a fachada), que coordena o trabalho internamente.

2. Motivação (Problema / Solução)
Problema (Contexto: Gestão Escolar): O processo de matricular um novo aluno é muito complexo. Um atendente da secretaria (o cliente) precisaria, manualmente, interagir com vários módulos do sistema na ordem correta:
Acessar o ServicoCadastro para verificar se o CPF do aluno já existe.
Acessar o ServicoDeTurmas para verificar se há vagas na turma "101-A".
Acessar o ServicoFinanceiro para gerar o boleto da taxa de matrícula.
Acessar o ServicoCadastro novamente para, enfim, salvar o aluno.
Acessar o ServicoDeTurmas novamente para alocar o aluno na vaga.
Isso é complicado, propenso a erros (e se o atendente esquecer o passo 3?) e acopla fortemente o atendente a toda a lógica interna do sistema.
Solução (Usando Facade): Criamos uma classe MatriculaFacade. O atendente da secretaria agora só precisa fazer uma chamada: facade.matricularAluno("João Silva", "123.456.789-00", "101-A");
A classe MatriculaFacade (a fachada) fará, internamente, todas as 5 chamadas aos subsistemas na ordem correta, tratando o fluxo. O atendente não precisa mais saber como o processo funciona, apenas o que ele quer fazer.

3. Estrutura (Diagrama UML)
Client (Demo): A classe que precisa realizar a matrícula (ex: a secretaria).
Facade (MatriculaFacade): A classe que simplifica o acesso.
Método: matricularAluno(...)
Subsystem Classes (ServicoCadastro, ServicoDeTurmas, ServicoFinanceiro): As classes complexas do sistema. Elas não fazem ideia de que a fachada existe; elas apenas executam seu trabalho.