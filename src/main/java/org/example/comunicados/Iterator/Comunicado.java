package java.org.example.comunicados.Iterator;

public class Comunicado {
    private String titulo;
    private String mensagem;

    public Comunicado(String titulo, String mensagem) {
        this.titulo = titulo;
        this.mensagem = mensagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nMensagem: " + mensagem;
    }
}
