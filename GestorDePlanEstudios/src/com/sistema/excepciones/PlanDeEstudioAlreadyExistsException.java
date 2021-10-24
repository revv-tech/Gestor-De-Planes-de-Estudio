package com.sistema.excepciones;

public class PlanDeEstudioAlreadyExistsException extends Exception{
    private final int codigoPlanEstudio;

    public PlanDeEstudioAlreadyExistsException(int codigoPlanEstudio) {
        this.codigoPlanEstudio = codigoPlanEstudio;
    }

    public int getCodigoPlanEstudio() {
        return codigoPlanEstudio;
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        return "Ya existe un plan de estudio con el id " + this.codigoPlanEstudio;
    }
}
