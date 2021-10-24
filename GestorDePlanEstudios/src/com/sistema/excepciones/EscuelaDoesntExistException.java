package com.sistema.excepciones;

public class EscuelaDoesntExistException extends Exception{
    private final String codigoEscuela;

    public EscuelaDoesntExistException(String codigoEscuela) {
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
        return "No existe la Escuela con el id " + this.codigoEscuela;
    }
}
