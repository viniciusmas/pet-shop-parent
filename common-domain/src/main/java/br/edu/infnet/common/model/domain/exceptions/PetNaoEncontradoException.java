package br.edu.infnet.common.model.domain.exceptions;

public class PetNaoEncontradoException extends RuntimeException {

    public PetNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
