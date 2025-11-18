package java.org.example.professores.Proxy;

public class ProxyService {
    public static void main(String[] args) {

        DiretorProxy proxy = new DiretorProxy("Carlos Silva", " Escola Padre Volei Basquete da Silva");

        proxy.mostrarInformacoes();

        proxy.coordenarProfessores();

        proxy.fazerReuniaoPedagogica();
    }
}
