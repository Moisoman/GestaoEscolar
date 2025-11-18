package java.org.example.curriculo.Command;

import java.org.example.entities.Curriculo;

public class CommandService {
    public static void main(String[] args) {
        Curriculo curriculo = new Curriculo("João Silva", "Desenvolvedor", "Java, Spring");

        Invocador invocador = new Invocador();

        Command criar = new CurriculoCreateCommand(curriculo,
                "Desenvolvedor de Software na Empresa X",
                "Java, Spring, SQL");
        invocador.setCommand(criar);
        invocador.executarComando();

        Command atualizar = new CurriculoUpdateCommand(curriculo,
                "Desenvolvedor Full Stack na Empresa Y",
                "Java, Spring, SQL, PHP, Python, Javascript, Typescript, Fazedor de Café, Pedreiro, Pintor");
        invocador.setCommand(atualizar);
        invocador.executarComando();

        Command remover = new CurriculoDeleteCommand(curriculo);
        invocador.setCommand(remover);
        invocador.executarComando();
    }

}
