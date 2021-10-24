package com.sistema;

import com.sistema.clases_auxiliares.GeneratorPDF;
import com.sistema.clases_auxiliares.JavaMailAPI;
import com.sistema.clases_auxiliares.JsonManager;
import com.sistema.controladores.Controlador;
import com.sistema.logicadenegocios.Curso;
import com.sistema.logicadenegocios.Escuela;
import com.sistema.logicadenegocios.PlanDeEstudio;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
/*
        System.out.println("Hola mundo");
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Escuela> escuelas = new ArrayList<>();
        ArrayList<PlanDeEstudio> planDeEstudios = new ArrayList<>();
        String est = "Marco Reveiz";
        String hs = "Escuela de Ingeniería en Computación";
        String hs2 = "Escuela de Ingeniería en Computadores";
        String hs3 = "Escuela de Administración";
        Escuela escuela = new Escuela(hs,"CI");
        Escuela escuela1 = new Escuela(hs2,"CC");
        Escuela escuela2 = new Escuela(hs3,"EA");
        escuelas.add(escuela);
        escuelas.add(escuela1);
        escuelas.add(escuela2);
        PlanDeEstudio planComputacion = new PlanDeEstudio("CI",1012);
        PlanDeEstudio planComputacion2 = new PlanDeEstudio("CI",2212);
        PlanDeEstudio planComputadores = new PlanDeEstudio("CC",4122);
        PlanDeEstudio planAdministracion = new PlanDeEstudio("EA",2223);
        planDeEstudios.add(planComputacion);
        planDeEstudios.add(planComputacion2);
        planDeEstudios.add(planComputadores);
        planDeEstudios.add(planAdministracion);



        Curso foc = new Curso("CI","Fundamentos de Computadores", "CI - 1025", 5, 8);
        Curso intro = new Curso("CI","Introduccion a Programación", "CI - 1026", 4, 8);
        Curso taller = new Curso("CI","Taller de Programación", "CI - 1023", 4, 6);

        Curso datos = new Curso("CI","Estrcuturas de Datos", "CI - 1029", 5, 10);
        Curso bases = new Curso("CI","Bases de Datos", "CI - 1022", 4, 4);
        Curso bases2 = new Curso("CI","Bases de Datos II", "CI - 1024", 4, 4);
        cursos.add(foc);
        cursos.add(intro);
        cursos.add(taller);
        cursos.add(datos);
        cursos.add(bases);
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

        Curso cont = new Curso("EA","Contabilidad", "EA - 2025", 5, 8);
        Curso prob = new Curso("EA","Probabilidadn", "EA - 2026", 4, 8);
        Curso admi = new Curso("EA","Administración General", "EA - 2023", 4, 6);
        Curso matGen = new Curso("EA","Matemática General", "EA - 2029", 5, 10);
        cursos.add(cont);
        cursos.add(prob);
        cursos.add(admi);
        cursos.add(matGen);
        planAdministracion.registrarCurso(cont);
        planAdministracion.registrarCurso(prob);
        planAdministracion.registrarCurso(admi);
        planAdministracion.registrarCurso(matGen);

        Curso reque = new Curso("CC","Requerimientos de Hardware", "CC - 4025", 5, 8);
        Curso reque2 = new Curso("CC","Requerimientos de Hardware II", "CC - 4026", 4, 8);
        Curso cir = new Curso("CC","Hardware Bósico", "CC - 4023", 4, 6);

        cursos.add(reque);
        cursos.add(reque2);
        cursos.add(cir);

        planComputadores.registrarCurso(reque);
        planComputadores.registrarCurso(reque2);
        planComputadores.registrarCurso(cir);


        Controlador.ESCUELAS = escuelas;
        Controlador.PLANES_DE_ESTUDIOS = planDeEstudios;
        Controlador.CURSOS = cursos;
        Controlador.saveLists();

*/

    }
}
