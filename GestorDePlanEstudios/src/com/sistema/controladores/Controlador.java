package com.sistema.controladores;

import com.sistema.excepciones.*;
import com.sistema.logicadenegocios.Curso;
import com.sistema.logicadenegocios.Escuela;
import com.sistema.logicadenegocios.PlanDeEstudio;

import java.util.ArrayList;
import java.util.Objects;

public class Controlador {
    private final ArrayList<Escuela> escuelas;
    private final ArrayList<PlanDeEstudio> planesDeEstudios;
    private final ArrayList<Curso> cursos;


    public Controlador() {
        this.escuelas = new ArrayList<>();
        this.planesDeEstudios = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    private ArrayList<PlanDeEstudio> getPlanesConCurso(String codCurso) {
        ArrayList<PlanDeEstudio> planesXCurso = new ArrayList<>();
        for (PlanDeEstudio planDeEstudio : this.planesDeEstudios) {
            if (planDeEstudio.hasCurso(codCurso))
                planesXCurso.add(planDeEstudio);
        }
        return planesXCurso;
    }

    private ArrayList<PlanDeEstudio> getPlanesDeUnaEscuela(String idEscuela) {
        ArrayList<PlanDeEstudio> planesEscuela = new ArrayList<>();
        for (PlanDeEstudio planDeEstudio : this.planesDeEstudios) {
            if (Objects.equals(planDeEstudio.getEscuelaPropietaria(), idEscuela))
                planesEscuela.add(planDeEstudio);
        }
        return planesEscuela;
    }

    public void agregarPlanDeEstudio(PlanDeEstudio appendedPlanDeEstudio) throws PlanDeEstudioAlreadyExistsException {
        for (PlanDeEstudio planDeEstudio : this.planesDeEstudios) {
            if (planDeEstudio.getCodigoPlanEstudios() == appendedPlanDeEstudio.getCodigoPlanEstudios())
                throw new PlanDeEstudioAlreadyExistsException(appendedPlanDeEstudio.getCodigoPlanEstudios());
        }
        this.planesDeEstudios.add(appendedPlanDeEstudio);
    }

    public void agregarEscuela(Escuela appendedEscuela) throws EscuelaAlreadyExistsException {
        for (Escuela escuela : this.escuelas) {
            if (Objects.equals(escuela.getCodigo(), appendedEscuela.getCodigo()))
                throw new EscuelaAlreadyExistsException(appendedEscuela.getCodigo());
        }
        this.escuelas.add(appendedEscuela);
    }

    public PlanDeEstudio getPlanDeEstudio(int idPlanEstudios) throws PlanDeEstudioDoesntExistException {
        for (PlanDeEstudio planDeEstudio : this.planesDeEstudios) {
            if (planDeEstudio.getCodigoPlanEstudios() == idPlanEstudios)
                return planDeEstudio;
        }
        throw new PlanDeEstudioDoesntExistException(idPlanEstudios);
    }

    public Escuela getEscuela(String idEscuela) throws EscuelaDoesntExistException {
        for (Escuela escuela : this.escuelas) {
            if (Objects.equals(escuela.getCodigo(), idEscuela))
                return escuela;
        }
        throw new EscuelaDoesntExistException(idEscuela);
    }

    public String getRequisitosCursoEnPlanEstudio(int idPlanEstudio, String idCurso) throws PlanDeEstudioDoesntExistException, CursoDoesntExistException {
        PlanDeEstudio planDeEstudio = this.getPlanDeEstudio(idPlanEstudio);
        Curso curso = planDeEstudio.getCurso(idCurso);
        return curso.mostrarRequisitos();
    }

    public String getCorequisitosCursoEnPlanEstudio(int idPlanEstudio, String idCurso) throws PlanDeEstudioDoesntExistException, CursoDoesntExistException {
        PlanDeEstudio planDeEstudio = this.getPlanDeEstudio(idPlanEstudio);
        Curso curso = planDeEstudio.getCurso(idCurso);
        return curso.mostrarCorequisitos();
    }

    public void eliminarCursoEnPlanEstudio(int idPlanEstudio, String idCurso) throws PlanDeEstudioDoesntExistException, CursoDoesntExistException {
        this.getPlanDeEstudio(idPlanEstudio).eliminarCurso(idCurso);
    }

    public void registrarRequisito(Curso pRequisito, int idPlanEstudio, String idCurso) throws CursoAlreadyExistsException, PlanDeEstudioDoesntExistException, CursoDoesntExistException {
        this.getPlanDeEstudio(idPlanEstudio).getCurso(idCurso).registrarRequisito(pRequisito);
    }

    public void registrarCorequisito(Curso pCorequisito, int idPlanEstudio, String idCurso) throws CursoAlreadyExistsException, PlanDeEstudioDoesntExistException, CursoDoesntExistException {
        this.getPlanDeEstudio(idPlanEstudio).getCurso(idCurso).registrarCorequisito(pCorequisito);
    }

    public void registrarCursoEmPlanEstudio(Curso pCurso, int idPlanEstudio) throws CursoAlreadyExistsException, PlanDeEstudioDoesntExistException {
        this.getPlanDeEstudio(idPlanEstudio).registrarCurso(pCurso);
    }

    public void registrarCursoEnEscuela(Curso pCurso, String idEscuela) throws CursoAlreadyExistsException, EscuelaDoesntExistException {
        this.getEscuela(idEscuela).registrarCurso(pCurso);
    }

    public void eliminarCursoEscuela(String idEscuela, String idCurso) throws EscuelaDoesntExistException, CursoDoesntExistException {
        this.getEscuela(idEscuela).eliminarCurso(idCurso);
    }

    public void eliminarRequisitoCursoPlanEstudio(String idRequisito, int idPlanEstudio, String idCurso) throws CursoDoesntExistException, PlanDeEstudioDoesntExistException {
        this.getPlanDeEstudio(idPlanEstudio).getCurso(idCurso).eliminarRequisito(idRequisito);
    }
    
}
