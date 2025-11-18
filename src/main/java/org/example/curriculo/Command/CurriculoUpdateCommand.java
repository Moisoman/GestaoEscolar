package java.org.example.curriculo.Command;

import java.org.example.entities.Curriculo;

/**
 * Comando para Atualizar o Curriculo
 */
public class CurriculoUpdateCommand implements Command {
    private Curriculo curriculo;
    private String novaExperiencia;
    private String novaHabilidades;

    public CurriculoUpdateCommand(Curriculo curriculo, String novaExperiencia, String novaHabilidades) {
        this.curriculo = curriculo;
        this.novaExperiencia = novaExperiencia;
        this.novaHabilidades = novaHabilidades;
    }


    @Override
    public void execute() {
        curriculo.atualizarExperiencia(novaExperiencia);
        curriculo.atualizarHabilidades(novaHabilidades);
    }
    
}
