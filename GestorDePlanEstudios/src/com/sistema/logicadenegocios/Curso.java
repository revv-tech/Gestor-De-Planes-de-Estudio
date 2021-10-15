package com.sistema.logicadenegocios;

import com.sistema.excepciones.CursoAlreadyExistsException;
import com.sistema.excepciones.CursoDoesntExistException;

import java.util.ArrayList;

public class Curso {
    // Atributos
    private int escuelaPropietaria;
    private String nombreCurso;
    private int codigo;
    private int creditos;
    private int horasLectivas;
    private final ArrayList<Curso> requisitos;
    private final ArrayList<Curso> coRequisitos;

    // Constructor
    public Curso(int escuelaPropietaria, String nombreCurso, int codigo, int creditos, int horasLectivas) {
        this.escuelaPropietaria = escuelaPropietaria;
        this.nombreCurso = nombreCurso;
        this.codigo = codigo;
        this.creditos = creditos;
        this.horasLectivas = horasLectivas;
        this.requisitos = new ArrayList<>();
        this.coRequisitos = new ArrayList<>();
     }

     // Metodos Accesores
    public int getEscuelaPropietaria() {
        return escuelaPropietaria;
    }

    public void setEscuelaPropietaria(int escuelaPropietaria) {
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
}
