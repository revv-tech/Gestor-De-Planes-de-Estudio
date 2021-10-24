package com.sistema.excepciones;

public class CursoAlreadyExistsException extends Exception{
    private final String codigoCurso; // Cambiar a string

    public CursoAlreadyExistsException(String pCodigoCurso) {
        this.codigoCurso = pCodigoCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        return "Ya existe un curso con el id " + this.codigoCurso;
    }
}
