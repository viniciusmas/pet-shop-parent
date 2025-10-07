package br.edu.infnet.common.model.domain.exceptions;

public class FuncionarioInvalidoException extends RuntimeException {

    public FuncionarioInvalidoException(String mensagem) {
        super(mensagem);
    }
}
