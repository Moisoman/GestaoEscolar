
package java.org.example.notas;

import java.util.Arrays;

/**
 * Client (Cliente): Uma classe do nosso novo sistema.
 * Ela depende APENAS da interface Target (FonteDeNotas).
 */
public class ServicoDeBoletim {

    // O cliente depende da interface, não da implementação
    private FonteDeNotas fonteDeNotas;

    // Recebemos a fonte de notas por injeção de dependência
    public ServicoDeBoletim(FonteDeNotas fonteDeNotas) {
        this.fonteDeNotas = fonteDeNotas;
    }

    public void imprimirBoletim(String idAluno) {
        System.out.println("\n[Serviço Boletim] Gerando boletim para aluno: " + idAluno);
        
        // O cliente chama o método da interface que ele conhece
        double[] notas = fonteDeNotas.getNotas(idAluno);

        // Lógica de negócio do novo sistema
        System.out.println("[Serviço Boletim] Notas recebidas: " + Arrays.toString(notas));
        
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        double media = (notas.length > 0) ? soma / notas.length : 0;
        
        System.out.println("[Serviço Boletim] Média calculada: " + String.format("%.2f", media));
    }
}