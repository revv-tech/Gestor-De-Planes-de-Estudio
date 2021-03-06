package com.sistema.controladores;

import com.sistema.clases_auxiliares.JsonManager;
import com.sistema.excepciones.*;
import com.sistema.logicadenegocios.Curso;
import com.sistema.logicadenegocios.Escuela;
import com.sistema.logicadenegocios.PlanDeEstudio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Permite controlar las funcionalidades del programa entre la vista y el modelo
 *
 * @autor Sebastian Lopez H
 * @version 1.0
 */
public class Controlador {
    // Atributos
    public static ArrayList<Escuela> ESCUELAS = new ArrayList<>();
    public static ArrayList<PlanDeEstudio> PLANES_DE_ESTUDIOS = new ArrayList<>();
    public static ArrayList<Curso> CURSOS = new ArrayList<>();


    public Controlador() {}

    public static void setLists(){
        JsonManager jsonManager = new JsonManager();
        try {
            jsonManager.getJsons();
            Controlador.ESCUELAS = jsonManager.getEscuelas();
            Controlador.PLANES_DE_ESTUDIOS = jsonManager.getPlanes();
            Controlador.CURSOS = jsonManager.getCursos();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveLists(){
        JsonManager jsonManager = new JsonManager();
        try {
            jsonManager.getJsons();
            jsonManager.setEscuelas(Controlador.ESCUELAS);
            jsonManager.setPlanes(Controlador.PLANES_DE_ESTUDIOS);
            jsonManager.setCursos( Controlador.CURSOS);
            jsonManager.setJsons();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Curso getCurso(String codigoCurso) throws CursoDoesntExistException {
        for (Curso curso : CURSOS) {
            if (Objects.equals(curso.getCodigo(), codigoCurso))
                return curso;
        }
        throw new CursoDoesntExistException(codigoCurso);
    }

    public static ArrayList<PlanDeEstudio> getPlanesConCurso(String codCurso) {
        ArrayList<PlanDeEstudio> planesXCurso = new ArrayList<>();
        for (PlanDeEstudio planDeEstudio : PLANES_DE_ESTUDIOS) {
            if (planDeEstudio.hasCurso(codCurso))
                planesXCurso.add(planDeEstudio);
        }
        return planesXCurso;
    } 

    public static ArrayList<PlanDeEstudio> getPlanesDeUnaEscuela(String idEscuela) {
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

    public static void registrarRequisito(Curso pRequisito, String codigoEscuela, String idCurso) throws CursoAlreadyExistsException, CursoDoesntExistException, EscuelaDoesntExistException {
        getEscuela(codigoEscuela).getCurso(idCurso).registrarRequisito(pRequisito);
    }

    public static void registrarCorequisito(Curso pRequisito, String codigoEscuela, String idCurso) throws CursoAlreadyExistsException, CursoDoesntExistException, EscuelaDoesntExistException {
        getEscuela(codigoEscuela).getCurso(idCurso).registrarCorequisito(pRequisito);
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


    public static ArrayList<Curso> getRequisitos(String codigo){

        for (Escuela escuela :ESCUELAS) {
            for (Curso curso : escuela.getCursos()) {
                if (curso.getCodigo().equals(codigo)) {
                    return curso.getRequisitos();
                }
            }
        }
        return null;
    }

    public static ArrayList<Curso> getCorequisitos(String codigo){

        for (Escuela escuela :ESCUELAS) {
            for (Curso curso : escuela.getCursos()) {
                if (curso.getCodigo().equals(codigo)) {
                    return curso.getCoRequisitos();
                }
            }
        }
        return null;
    }

    /**
     *  Funcion para probar datos sin utilizar json
     * @throws CursoAlreadyExistsException
     */
    public static void cargarArchivosPrueba() throws CursoAlreadyExistsException {
        ArrayList<Curso> cursosCI = new ArrayList<>();
        ArrayList<Curso> cursosCC = new ArrayList<>();
        ArrayList<Curso> cursosEA = new ArrayList<>();
        ArrayList<Escuela> escuelas = new ArrayList<>();
        ArrayList<PlanDeEstudio> planDeEstudios = new ArrayList<>();
        String est = "Marco Reveiz";
        String hs = "Escuela de Ingenier??a en Computaci??n";
        String hs2 = "Escuela de Ingenier??a en Computadores";
        String hs3 = "Escuela de Administraci??n";

        PlanDeEstudio planComputacion = new PlanDeEstudio("CI",1012);
        PlanDeEstudio planComputacion2 = new PlanDeEstudio("CI",2212);
        PlanDeEstudio planComputadores = new PlanDeEstudio("CC",4122);
        PlanDeEstudio planAdministracion = new PlanDeEstudio("EA",2223);
        planDeEstudios.add(planComputacion);
        planDeEstudios.add(planComputacion2);
        planDeEstudios.add(planComputadores);
        planDeEstudios.add(planAdministracion);



        Curso foc = new Curso("CI","Fundamentos de Computadores", "CI - 1025", 5, 8);
        Curso intro = new Curso("CI","Introduccion a Programaci??n", "CI - 1026", 4, 8);
        Curso taller = new Curso("CI","Taller de Programaci??n", "CI - 1023", 4, 6);

        Curso datos = new Curso("CI","Estrcuturas de Datos", "CI - 1029", 5, 10);
        Curso bases = new Curso("CI","Bases de Datos", "CI - 1022", 4, 4);
        Curso bases2 = new Curso("CI","Bases de Datos II", "CI - 1024", 4, 4);
        cursosCI.add(foc);
        cursosCI.add(intro);
        cursosCI.add(taller);
        cursosCI.add(datos);
        cursosCI.add(bases);
        planComputacion.registrarCurso(foc);
        planComputacion.registrarCurso(intro);
        planComputacion.registrarCurso(taller);
        planComputacion.registrarCurso(datos);
        planComputacion.registrarCurso(bases);
        planComputacion2.registrarCurso(foc);
        planComputacion2.registrarCurso(intro);
        planComputacion2.registrarCurso(taller);
        planComputacion2.registrarCurso(datos);
        planComputacion2.registrarCurso(bases);
        planComputacion2.registrarCurso(bases2);

        Escuela escuela = new Escuela(hs,"CI",cursosCI);



        Curso cont = new Curso("EA","Contabilidad", "EA - 2025", 5, 8);
        Curso prob = new Curso("EA","Probabilidadn", "EA - 2026", 4, 8);
        Curso admi = new Curso("EA","Administraci??n General", "EA - 2023", 4, 6);
        Curso matGen = new Curso("EA","Matem??tica General", "EA - 2029", 5, 10);
        cursosEA.add(cont);
        cursosEA.add(prob);
        cursosEA.add(admi);
        cursosEA.add(matGen);
        planAdministracion.registrarCurso(cont);
        planAdministracion.registrarCurso(prob);
        planAdministracion.registrarCurso(admi);
        planAdministracion.registrarCurso(matGen);


        Escuela escuela2 = new Escuela(hs3,"EA",cursosEA);




        Curso reque = new Curso("CC","Requerimientos de Hardware", "CC - 4025", 5, 8);
        Curso reque2 = new Curso("CC","Requerimientos de Hardware II", "CC - 4026", 4, 8);
        Curso cir = new Curso("CC","Hardware B??sico", "CC - 4023", 4, 6);

        cursosCC.add(reque);
        cursosCC.add(reque2);
        cursosCC.add(cir);

        planComputadores.registrarCurso(reque);
        planComputadores.registrarCurso(reque2);
        planComputadores.registrarCurso(cir);

        Escuela escuela1 = new Escuela(hs2,"CC",cursosCC);


        escuelas.add(escuela);
        escuelas.add(escuela1);
        escuelas.add(escuela2);
        ArrayList<Curso> cursos = new ArrayList<>();
        cursos.addAll(cursosCC);
        cursos.addAll(cursosEA);
        cursos.addAll(cursosCI);
        Controlador.ESCUELAS = escuelas;
        Controlador.PLANES_DE_ESTUDIOS = planDeEstudios;
        Controlador.CURSOS = cursos;
    }

}
