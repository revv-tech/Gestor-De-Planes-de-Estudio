package com.sistema.controladores;

import com.sistema.excepciones.*;
import com.sistema.logicadenegocios.Curso;
import com.sistema.logicadenegocios.Escuela;
import com.sistema.logicadenegocios.PlanDeEstudio;

import java.util.ArrayList;
import java.util.Objects;

public class Controlador {
    private static final ArrayList<Escuela> ESCUELAS = new ArrayList<>();
    private static final ArrayList<PlanDeEstudio> PLANES_DE_ESTUDIOS = new ArrayList<>();
    private static final ArrayList<Curso> CURSOS = new ArrayList<>();


    public Controlador() {
    }

    private static ArrayList<PlanDeEstudio> getPlanesConCurso(String codCurso) {
        ArrayList<PlanDeEstudio> planesXCurso = new ArrayList<>();
        for (PlanDeEstudio planDeEstudio : PLANES_DE_ESTUDIOS) {
            if (planDeEstudio.hasCurso(codCurso))
                planesXCurso.add(planDeEstudio);
        }
        return planesXCurso;
    }

    private static ArrayList<PlanDeEstudio> getPlanesDeUnaEscuela(String idEscuela) {
        ArrayList<PlanDeEstudio> planesEscuela = new ArrayList<>();
        for (PlanDeEstudio planDeEstudio : PLANES_DE_ESTUDIOS) {
            if (Objects.equals(planDeEstudio.getEscuelaPropietaria(), idEscuela))
                planesEscuela.add(planDeEstudio);
        }
        return planesEscuela;
    }

    public static void agregarPlanDeEstudio(PlanDeEstudio appendedPlanDeEstudio) throws PlanDeEstudioAlreadyExistsException {
        for (PlanDeEstudio planDeEstudio : PLANES_DE_ESTUDIOS) {
            if (planDeEstudio.getCodigoPlanEstudios() == appendedPlanDeEstudio.getCodigoPlanEstudios())
                throw new PlanDeEstudioAlreadyExistsException(appendedPlanDeEstudio.getCodigoPlanEstudios());
        }
        PLANES_DE_ESTUDIOS.add(appendedPlanDeEstudio);
    }

    public static void agregarEscuela(Escuela appendedEscuela) throws EscuelaAlreadyExistsException {
        for (Escuela escuela : ESCUELAS) {
            if (Objects.equals(escuela.getCodigo(), appendedEscuela.getCodigo()))
                throw new EscuelaAlreadyExistsException(appendedEscuela.getCodigo());
        }
        ESCUELAS.add(appendedEscuela);
    }

    public static PlanDeEstudio getPlanDeEstudio(int idPlanEstudios) throws PlanDeEstudioDoesntExistException {
        for (PlanDeEstudio planDeEstudio : PLANES_DE_ESTUDIOS) {
            if (planDeEstudio.getCodigoPlanEstudios() == idPlanEstudios)
                return planDeEstudio;
        }
        throw new PlanDeEstudioDoesntExistException(idPlanEstudios);
    }

    public static Escuela getEscuela(String idEscuela) throws EscuelaDoesntExistException {
        for (Escuela escuela : ESCUELAS) {
            if (Objects.equals(escuela.getCodigo(), idEscuela))
                return escuela;
        }
        throw new EscuelaDoesntExistException(idEscuela);
    }

    public static String getRequisitosCursoEnPlanEstudio(int idPlanEstudio, String idCurso) throws PlanDeEstudioDoesntExistException, CursoDoesntExistException {
        PlanDeEstudio planDeEstudio = getPlanDeEstudio(idPlanEstudio);
        Curso curso = planDeEstudio.getCurso(idCurso);
        return curso.mostrarRequisitos();
    }

    public static String getCorequisitosCursoEnPlanEstudio(int idPlanEstudio, String idCurso) throws PlanDeEstudioDoesntExistException, CursoDoesntExistException {
        PlanDeEstudio planDeEstudio = getPlanDeEstudio(idPlanEstudio);
        Curso curso = planDeEstudio.getCurso(idCurso);
        return curso.mostrarCorequisitos();
    }

    public static void eliminarCursoEnPlanEstudio(int idPlanEstudio, String idCurso) throws PlanDeEstudioDoesntExistException, CursoDoesntExistException {
        getPlanDeEstudio(idPlanEstudio).eliminarCurso(idCurso);
    }

    public static void registrarRequisito(Curso pRequisito, int idPlanEstudio, String idCurso) throws CursoAlreadyExistsException, PlanDeEstudioDoesntExistException, CursoDoesntExistException {
        getPlanDeEstudio(idPlanEstudio).getCurso(idCurso).registrarRequisito(pRequisito);
    }

    public static void registrarCorequisito(Curso pCorequisito, int idPlanEstudio, String idCurso) throws CursoAlreadyExistsException, PlanDeEstudioDoesntExistException, CursoDoesntExistException {
        getPlanDeEstudio(idPlanEstudio).getCurso(idCurso).registrarCorequisito(pCorequisito);
    }

    public static void registrarCursoEmPlanEstudio(Curso pCurso, int idPlanEstudio) throws CursoAlreadyExistsException, PlanDeEstudioDoesntExistException {
        getPlanDeEstudio(idPlanEstudio).registrarCurso(pCurso);
    }

    public static void registrarCursoEnEscuela(Curso pCurso, String idEscuela) throws CursoAlreadyExistsException, EscuelaDoesntExistException {
        getEscuela(idEscuela).registrarCurso(pCurso);
    }

    public static void eliminarCursoEscuela(String idEscuela, String idCurso) throws EscuelaDoesntExistException, CursoDoesntExistException {
        getEscuela(idEscuela).eliminarCurso(idCurso);
    }

    public static void eliminarRequisitoCursoPlanEstudio(String idRequisito, int idPlanEstudio, String idCurso) throws CursoDoesntExistException, PlanDeEstudioDoesntExistException {
        getPlanDeEstudio(idPlanEstudio).getCurso(idCurso).eliminarRequisito(idRequisito);
    }

}
