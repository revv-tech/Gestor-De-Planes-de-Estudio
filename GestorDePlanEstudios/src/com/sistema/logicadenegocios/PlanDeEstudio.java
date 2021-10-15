package com.sistema.logicadenegocios;

import com.sistema.excepciones.CursoAlreadyExistsException;
import com.sistema.excepciones.CursoDoesntExistException;

import java.util.ArrayList;
import java.util.Date;

public class PlanDeEstudio {
    // Atributos
    private int escuelaPropietaria;
    private int codigoPlanEstudios;
    private Date vigenciaPlan;
    private final ArrayList<Curso> cursos;

    // Constructores
    public PlanDeEstudio() {
        this.escuelaPropietaria = -1;
        this.codigoPlanEstudios = -1;
        this.vigenciaPlan = new Date();
        this.cursos = new ArrayList<>();
    }

    public PlanDeEstudio(int escuelaPropietaria, int codigoPlanEstudios) {
        this.escuelaPropietaria = escuelaPropietaria;
        this.codigoPlanEstudios = codigoPlanEstudios;
        this.setVigenciaPlan();
        this.cursos = new ArrayList<>();
    }

    // Metodos Accesores
    public int getEscuelaPropietaria() {
        return escuelaPropietaria;
    }

    public void setEscuelaPropietaria(int escuelaPropietaria) {
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
        date.setDate(date.getMonth() + 4);
        this.vigenciaPlan = date;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    // Override Super-class
    @Override
    public String toString() {
        return "PlanDeEstudio{" +
                "escuelaPropietaria=" + escuelaPropietaria +
                ", codigoPlanEstudios=" + codigoPlanEstudios +
                ", vigenciaPlan=" + vigenciaPlan +
                '}';
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
     * @param pCurso `Curso` (Curso que se desea eliminar
     * @throws CursoDoesntExistException en caso de que no exista el curso en la escuela
     */
    public void eliminarCurso(Curso pCurso) throws CursoDoesntExistException {
        boolean deleted = false;
        for (int index = 0; index < this.cursos.size(); index++) {
            if (this.cursos.get(index).getCodigo() == pCurso.getCodigo()) {
                this.cursos.remove(index);
                deleted = true;
                break;
            }
        }
        if (!deleted)
            throw new CursoDoesntExistException(pCurso.getCodigo());
    }
}
