package com.sistema.excepciones;

public class CursoAlreadyExistsException extends Exception{
    private final int codigoCurso; // Cambiar a string

    public CursoAlreadyExistsException(int pCodigoCurso) {
        this.codigoCurso = pCodigoCurso;
    }

    public int getCodigoCurso() {
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
