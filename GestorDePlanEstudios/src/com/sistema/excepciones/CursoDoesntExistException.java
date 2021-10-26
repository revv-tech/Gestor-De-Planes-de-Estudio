package com.sistema.excepciones;

public class CursoDoesntExistException extends Exception{
    private final String codingCursor;

    public CursoDoesntExistException(String codingCursor) {
        this.codingCursor = codingCursor;
    }

    public String getCodingCursor() {
        return codingCursor;
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        return "No existe un curso con el id " + this.codingCursor;
    }
}
