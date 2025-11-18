package java.org.example.curriculo.Command;

import java.org.example.entities.Curriculo;

public class CurriculoCreateCommand implements Command {
    private Curriculo curriculo;
    private String novaExperiencia;
    private String novaHabilidades;

    public CurriculoCreateCommand(Curriculo curriculo, String novaExperiencia, String novaHabilidades) {
        this.curriculo = curriculo;
        this.novaExperiencia = novaExperiencia;
        this.novaHabilidades = novaHabilidades;
    }


    @Override
    public void execute() {
        curriculo.criarExperiencia(novaExperiencia);
        curriculo.criarHabilidades(novaHabilidades);
    }
}
