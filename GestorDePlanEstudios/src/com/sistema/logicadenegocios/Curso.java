package com.sistema.logicadenegocios;

import com.sistema.excepciones.CursoAlreadyExistsException;
import com.sistema.excepciones.CursoDoesntExistException;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Muestra la informacion de un curso que se encuentra y todos los cursos relacionados a el
 *
 * @autor Sebastian Lopez H
 * @version 1.0
 */
public class Curso {
    // Atributos
    private String escuelaPropietaria;
    private String nombreCurso;
    private String codigo;
    private int creditos;
    private int horasLectivas;
    private int bloque;
    private final ArrayList<Curso> requisitos;

    public ArrayList<Curso> getRequisitos() {
        return requisitos;
    }

    public ArrayList<Curso> getCoRequisitos() {
        return coRequisitos;
    }

    private final ArrayList<Curso> coRequisitos;

    // Constructor
    public Curso(String escuelaPropietaria, String nombreCurso, String codigo, int creditos, int horasLectivas) {
        this.escuelaPropietaria = escuelaPropietaria;
        this.nombreCurso = nombreCurso;
        this.codigo = codigo;
        this.creditos = creditos;
        this.horasLectivas = horasLectivas;
        this.bloque = 0;
        this.requisitos = new ArrayList<>();
        this.coRequisitos = new ArrayList<>();
     }

     // Metodos Accesores
    public String getEscuelaPropietaria() {
        return escuelaPropietaria;
    }

    public void setEscuelaPropietaria(String escuelaPropietaria) {
        this.escuelaPropietaria = escuelaPropietaria;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHorasLectivas() {
        return horasLectivas;
    }

    public void setHorasLectivas(int horasLectivas) {
        this.horasLectivas = horasLectivas;
    }

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    // Override Super-class
    @Override
    public String toString() {
        return nombreCurso;
    }

    // Metodos

    /**
     *
     * @param pCurso Curso
     * @throws CursoAlreadyExistsException si el curso ya existe
     */
    public void registrarRequisito(Curso pCurso) throws CursoAlreadyExistsException {
        for (Curso curso : this.requisitos) {
            if (Objects.equals(curso.getCodigo(), pCurso.getCodigo()))
                throw new CursoAlreadyExistsException(pCurso.getCodigo());
        }

        this.requisitos.add(pCurso);
    }

    /**
     *
     * @param pCurso Curso
     * @throws CursoAlreadyExistsException si el curso ya existe
     */
    public void registrarCorequisito(Curso pCurso) throws CursoAlreadyExistsException {
        for (Curso curso : this.coRequisitos) {
            if (curso.getCodigo() == pCurso.getCodigo())
                throw new CursoAlreadyExistsException(pCurso.getCodigo());
        }
        this.coRequisitos.add(pCurso);
    }

    /**
     *
     * @param pCurso String
     * @throws CursoDoesntExistException si no encuentra el curso
     */
    public void eliminarRequisito(String pCurso) throws CursoDoesntExistException {
        boolean deleted = false;
        for (int index = 0; index < this.requisitos.size(); index++) {
            if (Objects.equals(this.requisitos.get(index).getCodigo(), pCurso)) {
                this.requisitos.remove(index);
                deleted = true;
                break;
            }
        }
        if (!deleted)
            throw new CursoDoesntExistException(pCurso);
    }

    /**
     *
     * @param idCurso String
     * @return Curso
     * @throws CursoDoesntExistException si no encuentra el curso
     */
    public Curso consultarRequisito(String idCurso) throws CursoDoesntExistException {
        for (Curso requisito : this.requisitos) {
            if (Objects.equals(requisito.getCodigo(), idCurso))
                return requisito;
        }
        throw new CursoDoesntExistException(idCurso);
    }

    /**
     *
     * @param idCurso String
     * @return Curso
     * @throws CursoDoesntExistException si no existe el curso
     */
    public Curso consultarCorequisito(String idCurso) throws CursoDoesntExistException {
        for (Curso corequisito : this.coRequisitos) {
            if (Objects.equals(corequisito.getCodigo(), idCurso))
                return corequisito;
        }
        throw new CursoDoesntExistException(idCurso);
    }

    /**
     *
     * @return String
     */
    public String mostrarRequisitos() {
        StringBuilder infoReqs = new StringBuilder("Requisitos de " + this.nombreCurso + ":\n");
        for (Curso requisito : this.requisitos) {
            infoReqs.append("\t").append(requisito.toString()).append("\n");
        }
        return infoReqs.toString();
    }


    /**
     *
     * @return String
     */
    public String mostrarCorequisitos() {
        StringBuilder infoCoreqs = new StringBuilder("Corequisitos de " + this.nombreCurso + ":\n");
        for (Curso corequisito : this.coRequisitos) {
            infoCoreqs.append("\t").append(corequisito.toString()).append("\n");
        }
        return infoCoreqs.toString();
    }
}
