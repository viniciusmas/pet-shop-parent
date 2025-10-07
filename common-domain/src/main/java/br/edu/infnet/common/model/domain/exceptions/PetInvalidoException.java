package br.edu.infnet.common.model.domain.exceptions;

public class PetInvalidoException extends RuntimeException {

    public PetInvalidoException(String mensagem) {
        super(mensagem);
    }
}
