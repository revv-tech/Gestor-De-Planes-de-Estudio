package com.sistema.excepciones;

public class EscuelaAlreadyExistsException extends Exception{
    private final String codigoEscuela;

    public EscuelaAlreadyExistsException(String codigoEscuela) {
        this.codigoEscuela = codigoEscuela;
    }

    public String getCodigoEscuela() {
        return codigoEscuela;
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        return "Ya existe una escuela con id " + this.codigoEscuela;
    }
}
