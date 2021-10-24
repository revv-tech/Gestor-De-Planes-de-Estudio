package com.sistema.logicadenegocios;

import com.sistema.excepciones.CursoAlreadyExistsException;
import com.sistema.excepciones.CursoDoesntExistException;

import java.util.ArrayList;

/**
 * Muestra la informacion de un curso que se encuentra y todos los cursos relacionados a el
 *
 * @autor Sebastian Lopez H
 * @version 1.0
 */
public class Curso {
    // Atributos
    private String escuelaPropietaria; //El id de una escuela es un string (CI, CA,...)
    private String nombreCurso;
    private int codigo; // Un alfanumerico de 2 a +4 numeros ejemplo -> IC-5102 entonces hay que cambiarlo a String :(
    private int creditos; // va de 0 a 4
    private int horasLectivas; // va de 1 a 5
    private int bloque; // bloque en el que se encuentra el curso
    private final ArrayList<Curso> requisitos;
    private final ArrayList<Curso> coRequisitos;

    // Constructor
    public Curso(String escuelaPropietaria, String nombreCurso, int codigo, int creditos, int horasLectivas) {
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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
        return "Curso{" +
                "escuelaPropietaria='" + escuelaPropietaria + '\'' +
                ", nombreCurso='" + nombreCurso + '\'' +
                ", codigo=" + codigo +
                ", creditos=" + creditos +
                ", horasLectivas=" + horasLectivas +
                '}';
    }

    // Metodos
    public void registrarRequisito(Curso pCurso) throws CursoAlreadyExistsException {
        for (Curso curso : this.requisitos) {
            if (curso.getCodigo() == pCurso.getCodigo())
                throw new CursoAlreadyExistsException(pCurso.getCodigo());
        }
        this.requisitos.add(pCurso);
    }

    public void registrarCorequisito(Curso pCurso) throws CursoAlreadyExistsException {
        for (Curso curso : this.coRequisitos) {
            if (curso.getCodigo() == pCurso.getCodigo())
                throw new CursoAlreadyExistsException(pCurso.getCodigo());
        }
        this.coRequisitos.add(pCurso);
    }

    public void eliminarRequisito(Curso pCurso) throws CursoDoesntExistException {
        boolean deleted = false;
        for (int index = 0; index < this.requisitos.size(); index++) {
            if (this.requisitos.get(index).getCodigo() == pCurso.getCodigo()) {
                this.requisitos.remove(index);
                deleted = true;
                break;
            }
        }
        if (!deleted)
            throw new CursoDoesntExistException(pCurso.getCodigo());
    }

    public Curso consultarRequisito(int idCurso) throws CursoDoesntExistException {
        for (Curso requisito : this.requisitos) {
            if (requisito.getCodigo() == idCurso)
                return requisito;
        }
        throw new CursoDoesntExistException(idCurso);
    }

    public Curso consultarCorequisito(int idCurso) throws CursoDoesntExistException {
        for (Curso corequisito : this.coRequisitos) {
            if (corequisito.getCodigo() == idCurso)
                return corequisito;
        }
        throw new CursoDoesntExistException(idCurso);
    }

    public String mostrarRequisitos() {
        StringBuilder infoReqs = new StringBuilder("Requisitos de " + this.nombreCurso + ":\n");
        for (Curso requisito : this.requisitos) {
            infoReqs.append("\t").append(requisito.toString()).append("\n");
        }
        return infoReqs.toString();
    }

    public String mostrarCorequisitos() {
        StringBuilder infoCoreqs = new StringBuilder("Corequisitos de " + this.nombreCurso + ":\n");
        for (Curso corequisito : this.coRequisitos) {
            infoCoreqs.append("\t").append(corequisito.toString()).append("\n");
        }
        return infoCoreqs.toString();
    }
}
