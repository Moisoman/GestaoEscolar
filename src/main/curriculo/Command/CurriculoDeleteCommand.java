package org.example.curriculo.Command;

import org.example.entities.Curriculo;

public class CurriculoDeleteCommand implements Command {
    private Curriculo curriculo;

    public CurriculoDeleteCommand(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

    @Override
    public void execute() {
        curriculo.removerExperiencia();
        curriculo.removerHabilidades();
    }
}
