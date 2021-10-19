package com.sistema;

import com.sistema.clases_auxiliares.GeneratorPDF;
import com.sistema.clases_auxiliares.JavaMailAPI;
import com.sistema.clases_auxiliares.JsonManager;
import com.sistema.logicadenegocios.Curso;
import com.sistema.logicadenegocios.Escuela;
import com.sistema.logicadenegocios.PlanDeEstudio;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hola mundo");
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Escuela> escuelas = new ArrayList<>();
        ArrayList<PlanDeEstudio> planDeEstudios = new ArrayList<>();
        String est = "Marco Reveiz";
        String hs = "Escuela de Ingeniería en Computación";
        String hs2 = "Escuela de Ingeniería en Computadores";
        Escuela escuela = new Escuela(hs,"1");
        Escuela escuela1 = new Escuela(hs2,"2");
        escuelas.add(escuela);
        escuelas.add(escuela1);
        PlanDeEstudio planComputacion = new PlanDeEstudio(1,1);
        PlanDeEstudio planComputadores = new PlanDeEstudio(2,2);
        planDeEstudios.add(planComputacion);
        planDeEstudios.add(planComputadores);
/*
        //Curso foc = new Curso(1,"Fundamentos de Computadores", 1, 5, 8);
        //Curso intro = new Curso(1,"Introduccion a Programación", 2, 4, 8);
        //Curso taller = new Curso(1,"Taller de Programación", 3, 4, 6);
        //Curso datos = new Curso(1,"Estrcuturas de Datos", 4, 5, 10);
        Curso bases = new Curso(1,"Bases de Datos", 5, 4, 4);
        cursos.add(foc);
        cursos.add(intro);
        cursos.add(taller);
        cursos.add(datos);
        cursos.add(bases);


        //JsonManager jsonManager = new JsonManager(escuelas,planDeEstudios,cursos);
        //jsonManager.getJsons();
        //Genera el pdf con los datos
        //GeneratorPDF generatorPDF = new GeneratorPDF(est,hs,cursos);
        //generatorPDF.generatePDF();
        //Envia el correo
        //JavaMailAPI.enviarCorreo("MarcoReveiz","revvace@gmail.com");
        */

    }
}
