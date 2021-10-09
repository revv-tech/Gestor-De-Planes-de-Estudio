package com.sistema;

import com.sistema.clases_auxiliares.GeneratorPDF;
import com.sistema.clases_auxiliares.JavaMailAPI;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hola mundo");
        ArrayList<String> cursos = new ArrayList<String>();
        cursos.add("Matemática Discreta");
        cursos.add( "Taller de Programación");
        cursos.add("Fundamentos");
        cursos.add("Estructuras de Datos");
        cursos.add("Bases de Datos I");
        String est = "Marco Reveiz";
        String hs = "Escuela de Ingeniería en Computación";
        //Genera el pdf con los datos
        GeneratorPDF generatorPDF = new GeneratorPDF(est, hs ,cursos );
        generatorPDF.generatePDF();
        //Envia el correo
        JavaMailAPI.enviarCorreo("MarcoReveiz","revvace@gmail.com");
    }
}
