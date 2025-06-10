package br.ifsp.infection.exceptions;

public class EntityAlreadyExists extends RuntimeException {
    public EntityAlreadyExists(String message) {
        super(message);
    }
}
