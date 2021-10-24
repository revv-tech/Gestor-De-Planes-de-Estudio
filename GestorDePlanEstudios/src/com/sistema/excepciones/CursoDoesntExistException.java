package com.sistema.excepciones;

public class CursoDoesntExistException extends Exception{
    private final String codigoCurso;

    public CursoDoesntExistException(String codigoCurso) {
        this.codigoCurso = codigoCurso;
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
        return "No existe un curso con el id " + this.codigoCurso;
    }
}
