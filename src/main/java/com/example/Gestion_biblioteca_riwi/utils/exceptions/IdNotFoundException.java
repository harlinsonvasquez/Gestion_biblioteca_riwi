package com.example.Gestion_biblioteca_riwi.utils.exceptions;

public class IdNotFoundException extends RuntimeException {
    private static final String ERROR_MESSAGE = "No hay registros en la entidad %s con el id sumunistrado";

    /**
     * Utilizamos el constructur de RuntimeException y enviamos el mensaje
     * Inyectando el nombre de la entidad
     */
    public IdNotFoundException(String nameEntity) {
        super(String.format(ERROR_MESSAGE, nameEntity));
    }
}
