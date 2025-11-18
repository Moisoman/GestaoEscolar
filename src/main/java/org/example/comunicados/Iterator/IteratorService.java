package java.org.example.comunicados.Iterator;

public class IteratorService {
    public static void main(String[] args) {
        ComunicadoCollection comunicadosCollection = new ComunicadoCollection();

        comunicadosCollection.adicionarComunicado(new Comunicado("Reunião de Pais", "Haverá reunião de pais amanhã às 19h."));
        comunicadosCollection.adicionarComunicado(new Comunicado("Férias", "As férias escolares começam na próxima semana."));
        comunicadosCollection.adicionarComunicado(new Comunicado("Prova Final", "A prova final será realizada na próxima sexta-feira."));

        Iterator iterator = comunicadosCollection.getIterator();

        while (iterator.hasNext()) {
            Comunicado comunicado = (Comunicado) iterator.next();
            System.out.println(comunicado);
            System.out.println("----------------------------------");
        }
    }
}
