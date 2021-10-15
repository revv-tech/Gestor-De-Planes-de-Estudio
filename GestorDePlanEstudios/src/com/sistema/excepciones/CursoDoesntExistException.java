package com.sistema.excepciones;

public class CursoDoesntExistException extends Exception{
    private final int codigoCurso;

    public CursoDoesntExistException(int codigoCurso) {
        this.codigoCurso = codigoCurso;
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
        return "No existe un curso con el id " + this.codigoCurso;
    }
}
