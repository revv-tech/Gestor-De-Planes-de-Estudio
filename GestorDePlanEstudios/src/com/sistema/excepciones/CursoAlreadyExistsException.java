package com.sistema.excepciones;

/**
 * @author Sebastian Lopez
 * @version 1.0
 */
public class CursoAlreadyExistsException extends Exception{
    private final String codingCursor;

    public CursoAlreadyExistsException(String pCodigoCurso) {
        this.codingCursor = pCodigoCurso;
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
        return "Ya existe un curso con el id " + this.codingCursor;
    }
}
