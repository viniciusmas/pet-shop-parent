package br.edu.infnet.common.model.domain.exceptions;

public class ClienteInvalidoException extends RuntimeException {

    public ClienteInvalidoException(String mensagem) {
        super(mensagem);
    }
}
