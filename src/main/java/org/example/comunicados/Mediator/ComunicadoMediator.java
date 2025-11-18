package java.org.example.comunicados.Mediator;

import java.org.example.entities.Aluno;

/**
 * Define um objeto para centralizar a comunicação entre outros objetos,
 * promovendo o desacoplamento entre eles.
 * Em vez de os objetos se comunicarem diretamente uns com os outros,
 * eles se comunicam por meio de um objeto mediador.
 */
public interface ComunicadoMediator {
    void enviarComunicado(String comunicado, Aluno aluno);
}
