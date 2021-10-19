package com.sistema.clases_auxiliares;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sistema.logicadenegocios.Curso;
import com.sistema.logicadenegocios.Escuela;
import com.sistema.logicadenegocios.PlanDeEstudio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Clase encarga de manejar los archivos .json en los que se almacenara informacion vital para el programa
 * @author Marco Reveiz
 * @version 1.0
 */
public class JsonManager {

    private ArrayList<Escuela> escuelas;
    private ArrayList<PlanDeEstudio> planes;
    private ArrayList<Curso> cursos;

    /**
     * Metodo constructor
     * @param escuelas lista con los objetos Escuela
     * @param planes lista con los objetos PlanDeEstudio
     * @param cursos lista con los objetos Curso
     */
    public JsonManager(ArrayList<Escuela> escuelas, ArrayList<PlanDeEstudio> planes, ArrayList<Curso> cursos) {
        this.escuelas = escuelas;
        this.planes = planes;
        this.cursos = cursos;
    }

    /**
     * Guarda los tres archivos JSON con los datos de los array registrados
     * @throws IOException si el programa no puede escribir el archivo
     */

    public void setJsons() throws IOException {

        //Path
        String path = System.getProperty("user.dir") + "\\src\\com\\sistema\\jsons\\";
        // Objecto Gson
        Gson gson = new Gson();

        //JSON CURSOS
        File fileCurso = new File(path + "cursos.json");
        Writer wCursos = new FileWriter(fileCurso);
        gson.toJson(this.cursos,wCursos);
        wCursos.close();

        //JSON PLANES
        File filePlan= new File(path + "planes.json");
        Writer wPlanes = new FileWriter(filePlan);
        gson.toJson(this.planes,wPlanes);
        wPlanes.close();

        //JSON ESCUELAS
        File fileEscuela= new File(path + "escuelas.json");
        Writer wEscuela = new FileWriter(fileEscuela);
        gson.toJson(this.escuelas,wEscuela);
        wEscuela.close();


    }

    /**
     * Obtiene los datos de los JSON guardados y los iguala a los atributos
     */
    public void getJsons() throws IOException {

        // Objecto Gson
        Gson gson = new Gson();

        //Path
        String path = System.getProperty("user.dir") + "\\src\\com\\sistema\\jsons\\";

        //Cursos
        String listaCursos = Files.readString(Paths.get(path+"cursos.json"));
        //System.out.println(listaCursos);
        Type cursoALType = new TypeToken<ArrayList<Curso>>(){}.getType();
        ArrayList<Curso> cursoArrayList = gson.fromJson(listaCursos,cursoALType);

        //Escuelas
        String listaEscuelas = Files.readString(Paths.get(path+"escuelas.json"));
        //System.out.println(listaEscuelas);
        Type escuelaALType = new TypeToken<ArrayList<Escuela>>(){}.getType();
        ArrayList<Escuela> escuelaArrayList = gson.fromJson(listaEscuelas,escuelaALType);

        //Planes
        String listaPlanes = Files.readString(Paths.get(path+"planes.json"));
        //System.out.println(listaPlanes);
        Type planesALType = new TypeToken<ArrayList<PlanDeEstudio>>(){}.getType();
        ArrayList<PlanDeEstudio> planDeEstudioArrayList = gson.fromJson(listaPlanes,planesALType);

        //Se igualan a atributos
        this.setEscuelas(escuelaArrayList);
        this.setCursos(cursoArrayList);
        this.setPlanes(planDeEstudioArrayList);

    }


    public void setEscuelas(ArrayList<Escuela> escuelas) {
        this.escuelas = escuelas;
    }

    public void setPlanes(ArrayList<PlanDeEstudio> planes) {
        this.planes = planes;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
}
