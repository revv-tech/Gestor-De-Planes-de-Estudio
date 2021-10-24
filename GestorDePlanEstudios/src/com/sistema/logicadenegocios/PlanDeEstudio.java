package com.sistema.logicadenegocios;

import com.sistema.excepciones.CursoAlreadyExistsException;
import com.sistema.excepciones.CursoDoesntExistException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class PlanDeEstudio {
    // Atributos
    private String escuelaPropietaria; // hay que cambiar a String porque el codigo de la escuela puede ser CI,CA....
    private int codigoPlanEstudios; // numero de 4 digitos
    private Date vigenciaPlan;
    private final ArrayList<Curso> cursos;

    // Constructores
    public PlanDeEstudio() {
        this.escuelaPropietaria = "";
        this.codigoPlanEstudios = -1;
        this.vigenciaPlan = new Date();
        this.cursos = new ArrayList<>();
    }

    public PlanDeEstudio(String escuelaPropietaria, int codigoPlanEstudios) {
        this.escuelaPropietaria = escuelaPropietaria;
        this.codigoPlanEstudios = codigoPlanEstudios;
        this.setVigenciaPlan();
        this.cursos = new ArrayList<>();
    }

    // Metodos Accesores
    public String getEscuelaPropietaria() {
        return escuelaPropietaria;
    }

    public void setEscuelaPropietaria(String escuelaPropietaria) {
        this.escuelaPropietaria = escuelaPropietaria;
    }

    public int getCodigoPlanEstudios() {
        return codigoPlanEstudios;
    }

    public void setCodigoPlanEstudios(int codigoPlanEstudios) {
        this.codigoPlanEstudios = codigoPlanEstudios;
    }

    public Date getVigenciaPlan() {
        return vigenciaPlan;
    }

    public void setVigenciaPlan() {
        Date date = new Date();
        date.setDate(date.getMonth() + 24);
        this.vigenciaPlan = date;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    // Override Super-class
    @Override
    public String toString() {
        return String.valueOf(codigoPlanEstudios);
    }

    // Metodos
    /**
     *
     * @param pCurso `Curso` (Curso que se desea agregar a la escuela)
     * @throws CursoAlreadyExistsException en caso de que ya exista el curso en la escuela
     */
    public void registrarCurso(Curso pCurso) throws CursoAlreadyExistsException {
        for (Curso curso : this.cursos) {
            if (curso.getCodigo() == pCurso.getCodigo())
                throw new CursoAlreadyExistsException(pCurso.getCodigo());
        }
        this.cursos.add(pCurso);
    }

    /**
     *
     * @param codigoCurso `Curso` (Curso que se desea eliminar)
     * @throws CursoDoesntExistException en caso de que no exista el curso en la escuela
     */
    public void eliminarCurso(String codigoCurso) throws CursoDoesntExistException {
        boolean deleted = false;
        for (int index = 0; index < this.cursos.size(); index++) {
            if (Objects.equals(this.cursos.get(index).getCodigo(), codigoCurso)) {
                this.cursos.remove(index);
                deleted = true;
                break;
            }
        }
        if (!deleted)
            throw new CursoDoesntExistException(codigoCurso);
    }


    public Curso getCurso(String codigoCurso) throws CursoDoesntExistException{
        for (Curso curso : this.cursos) {
            if (Objects.equals(curso.getCodigo(), codigoCurso))
                return curso;
        }
        throw new CursoDoesntExistException(codigoCurso);
    }

    public boolean hasCurso(String codigoCurso) {
        for (Curso curso : this.cursos) {
            if (Objects.equals(curso.getCodigo(), codigoCurso))
                return true;
        }
        return false;
    }

}
