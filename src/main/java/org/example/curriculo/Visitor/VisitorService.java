package java.org.example.curriculo.Visitor;

import java.org.example.entities.Curriculo;

public class VisitorService {
    public static void main(String[] args) {
        Curriculo curriculo = new Curriculo("João Silva", "Desenvolvedor Full Stack", "Java, Spring, SQL");

        CurriculoVisitor imprimirVisitor = new ImprimirCurriculoVisitor();
        CurriculoVisitor validarVisitor = new ValidarCurriculoVisitor();

        curriculo.aceitar(imprimirVisitor);
        curriculo.aceitar(validarVisitor);
    }
}
