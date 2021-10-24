package com.sistema.excepciones;

public class PlanDeEstudioDoesntExistException extends Exception {
    private final int codigoPlanEstudio;

    public PlanDeEstudioDoesntExistException(int codigoPlanEstudio) {
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
        return "No existe un Plan de Estudio con el id " + this.codigoPlanEstudio;
    }
}
