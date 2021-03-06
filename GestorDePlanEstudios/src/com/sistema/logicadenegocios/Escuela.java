package com.sistema.logicadenegocios;

import com.sistema.excepciones.CursoAlreadyExistsException;
import com.sistema.excepciones.CursoDoesntExistException;
import com.sistema.excepciones.PlanDeEstudioDoesntExistException;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Guarda la informacion de la escuela y todos los cursos relacionados a ella
 *
 * @autor Sebastian Lopez H
 * @version 1.0
 */
public class Escuela {
    // Atributos
    private String nombre;
    private String codigo;
    private final ArrayList<Curso> cursos;

    // Constructores
    public Escuela() {
        this.codigo = "";
        this.nombre = "";
        this.cursos = new ArrayList<>();
    }

    public Escuela(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cursos = new ArrayList<>();
    }

    public Escuela(String nombre, String codigo, ArrayList<Curso> cursos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cursos = cursos;
    }

    // Métodos Accesores
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }



    // Override Super-class
    @Override
    public String toString() {
        return codigo;
    }

    // Métodos
    /**
     *
     * @param pCurso `Curso` (Curso que se desea agregar a la escuela)
     * @throws CursoAlreadyExistsException en caso de que ya exista el curso en la escuela
     */
    public void registrarCurso(Curso pCurso) throws CursoAlreadyExistsException {
        for (Curso curso : this.cursos) {
            if (Objects.equals(curso.getCodigo(), pCurso.getCodigo()))
                throw new CursoAlreadyExistsException(pCurso.getCodigo());
        }
        this.cursos.add(pCurso);
    }

    /**
     *
     * @param pCurso `int` (Curso que se desea eliminar
     * @throws CursoDoesntExistException en caso de que no exista el curso en la escuela
     */
    public void eliminarCurso(String pCurso) throws CursoDoesntExistException {
        boolean deleted = false;
        for (int index = 0; index < this.cursos.size(); index++) {
            if (Objects.equals(this.cursos.get(index).getCodigo(), pCurso)) {
                this.cursos.remove(index);
                deleted = true;
                break;
            }
        }
        if (!deleted)
            throw new CursoDoesntExistException(pCurso);
    }

    /**
     *
     * @param codigoCurso String
     * @return Curso
     * @throws CursoDoesntExistException si no encuentra el curso
     */
    public Curso getCurso(String codigoCurso) throws CursoDoesntExistException {
        for (Curso curso : this.cursos) {
            if (Objects.equals(curso.getCodigo(), codigoCurso))
                return curso;
        }
        throw new CursoDoesntExistException(codigoCurso);
    }

}
