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
Client (Secretaria ou Main):
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
A classe DemoAbstractFactory que eu criei antes era apenas para fins de teste. Agora, vamos integrar essa lógica dentro da sua classe Demo (ou Main) principal, como uma das opções do menu.
Aqui está o código da sua classe Demo.java (ou Main.java), agora com a opção "1" funcional:

# Builder

Vamos aplicar o Builder na  Gestão de Turmas. O objetivo é "construir a configuração de uma turma (disciplinas, horários, número de alunos) de maneira flexível".

Este padrão é ideal para objetos que têm muitos parâmetros de configuração, alguns obrigatórios e muitos opcionais.

1. Padrão: Builder (Construtor)
Nome: Builder
.
Propósito: Separar o processo de construção de um objeto complexo de sua representação final. Isso permite que o mesmo processo de construção possa criar diferentes representações. Em Java, é mais conhecido por permitir a criação de objetos complexos passo a passo, de forma legível e garantindo um estado final válido.

2. Motivação (Problema / Solução)
Problema (Contexto: Gestão Escolar): Imagine criar um objeto Turma. Uma turma tem atributos:
:
Obrigatórios: nomeDaTurma (ex: "MAT101"), anoLetivo (ex: 2024).
.
Opcionais: professorTitular, sala, listaDeAlunos, listaDeDisciplinas, turno (Manhã/Tarde/Noite).
.
Como você cria uma instância de Turma?
.
Construtor "Telescópico"? Você teria que criar múltiplos construtores: Turma(nome, ano) Turma(nome, ano, professor) Turma(nome, ano, professor, sala) Turma(nome, ano, professor, sala, turno) ... isso é impraticável, ilegível e propenso a erros (inverter a ordem de sala e turno, por exemplo).
.
Construtor Padrão + Setters? Turma t = new Turma(); t.setNome("MAT101"); t.setAnoLetivo(2024); t.setProfessor(profJoao); ... O problema aqui é: o que acontece se o programador esquecer de chamar setNome()? E se o objeto Turma for usado antes de estar completo? O objeto pode existir em um estado inválido por um tempo.
.
Solução (Usando Builder): Criamos uma classe interna (normalmente estática) chamada TurmaBuilder.
.
O cliente obtém uma instância do Builder, passando os parâmetros obrigatórios no construtor do builder (ex: new TurmaBuilder("MAT101", 2024)).
.
O cliente usa métodos fluentes (que retornam this) para configurar os parâmetros opcionais (ex: .comProfessor(profJoao).comSala("B-102")).
.
No final, o cliente chama o método build().
.
O método build() (dentro do TurmaBuilder) executa validações (ex: "a turma tem pelo menos uma disciplina?") e, se tudo estiver OK, ele chama o construtor privado da classe Turma, passando a si mesmo (this) como argumento.
.
Isso garante que o objeto Turma só é instanciado em um estado completo e válido, e a leitura do código de criação fica limpa e explícita.

3. Estrutura (Diagrama UML)
Para esta implementação (o "Modern Java Builder"), a estrutura é:
.
Product (Turma):
.
A classe complexa que queremos criar
.
Possui um construtor privado que aceita um TurmaBuilder como argumento.
.
Geralmente é imutável (seus atributos são final).
.
Builder (TurmaBuilder):
.
Uma classe estática aninhada (nested static class) dentro de Turma.
.
Possui os mesmos atributos da Turma, mas mutáveis.
.
Tem um construtor público para os campos obrigatórios.
.
Tem métodos fluentes (ex: comSala(...)) para os campos opcionais.
.
Tem o método build() que chama o construtor privado de Turma e retorna a instância do produto.
.
Client (Demo):
.
A classe que utiliza o TurmaBuilder para criar uma Turma.