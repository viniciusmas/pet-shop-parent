package br.edu.infnet.common.model.domain.exceptions;

public class FuncionarioNaoEncontradoException extends RuntimeException {

    public FuncionarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
