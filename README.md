# GestaoEscolar

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

# 