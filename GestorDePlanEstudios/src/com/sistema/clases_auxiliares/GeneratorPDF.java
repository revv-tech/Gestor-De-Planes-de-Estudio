package com.sistema.clases_auxiliares;
import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GeneratorPDF {

    private Document pdf;
    private String nombreEscuela;
    private String nombre;
    private ArrayList<String> listaCursos;
    private FileOutputStream archivo;
    private Paragraph titulo;
    private Font fuenteTitulo;
    private String carpetaFinal;


    public GeneratorPDF(String nombre, String nombreEscuela, ArrayList<String> listaCursos){

        this.nombre = nombre;
        this.nombreEscuela = nombreEscuela;
        this.listaCursos = listaCursos;
        this.pdf = new Document();
        this.fuenteTitulo = new Font(Font.FontFamily.TIMES_ROMAN,30,Font.NORMAL);
        this.titulo = new Paragraph("Plan de Estudios",fuenteTitulo);

    }

    public void generatePDF(){
        //Cambia de color la fuente
        fuenteTitulo.setColor(BaseColor.BLUE.darker().darker());
        //Crea fuente para subtitulos
        Font subFuente =  new Font(Font.FontFamily.TIMES_ROMAN,15,Font.NORMAL);
        //Crea fuente para texto normal
        Font fuente =  new Font(Font.FontFamily.TIMES_ROMAN,10,Font.NORMAL);
        try{
            String pdfNombre = "PlanEstudio"+this.nombre+".pdf";
            pdfNombre = pdfNombre.replaceAll("\\s", "");
            System.out.println(pdfNombre);
            this.archivo = new FileOutputStream(pdfNombre);
            //Genera el escritor del Documento PDF
            PdfWriter.getInstance(pdf,archivo);
            //Abre el documento para llenarlo
            pdf.open();
            titulo.setAlignment(1);
            pdf.add(titulo);
            //Agrega nueva línea
            pdf.add(new Paragraph(Chunk.NEWLINE));
            //Agrega nueva línea
            pdf.add(new Paragraph(Chunk.NEWLINE));
            //Agrega logo
            Image logo = null;
            //Busca la imagen en el path
            try {
                logo = Image.getInstance("C:\\Users\\Marco\\Desktop\\DocumentosTEC\\Github\\Gestor-De-Planes-de-Estudio\\GestorDePlanEstudios\\src\\com\\sistema\\Images\\Logo-TEC-Color.png");
                logo.scaleAbsolute(150,150);
                logo.setAbsolutePosition(415,700);
                pdf.add(logo);
            } catch (BadElementException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Agrega nueva línea
            pdf.add(new Paragraph(Chunk.NEWLINE));
            //Agrega Nombre del estudiante
            pdf.add(new Paragraph("Nombre del estudiante: " + this.nombre, subFuente));
            //Agrega nueva línea
            pdf.add(new Paragraph(Chunk.NEWLINE));
            //Nombre de la escuela
            pdf.add(new Paragraph("Nombre de la escuela: " + this.nombreEscuela, subFuente));
            //Agrega nueva línea
            pdf.add(new Paragraph(Chunk.NEWLINE));
            //Agrega nueva línea
            pdf.add(new Paragraph(Chunk.NEWLINE));
            //Crea tabla de cursos
            PdfPTable tabla = new PdfPTable(4);

            //Settea el tamanho de las celdas
            tabla.setWidthPercentage(100);

            //Crea columnas
            PdfPCell nombreDelCurso = new PdfPCell(new Phrase("Nombre del curso", fuente));
            nombreDelCurso.setBorderColor(BaseColor.BLUE.darker());
            nombreDelCurso.setFixedHeight(20);
            nombreDelCurso.setHorizontalAlignment(1);
            PdfPCell id = new PdfPCell(new Phrase("Código", fuente));
            id.setBorderColor(BaseColor.BLUE.darker());
            id.setFixedHeight(20);
            id.setHorizontalAlignment(1);
            PdfPCell creditos = new PdfPCell(new Phrase("Créditos", fuente));
            creditos.setBorderColor(BaseColor.BLUE.darker());
            creditos.setFixedHeight(20);
            creditos.setHorizontalAlignment(1);
            PdfPCell hrs = new PdfPCell(new Phrase("Horas Lectivas", fuente));
            hrs.setBorderColor(BaseColor.BLUE.darker());
            hrs.setFixedHeight(20);
            hrs.setHorizontalAlignment(1);
            //Agrega las columnas a la tabla
            tabla.addCell(nombreDelCurso);
            tabla.addCell(id);
            tabla.addCell(creditos);
            tabla.addCell(hrs);
            /*
            for (Curso curso: this.listaCursos){
                tabla.addCell(curso.getNombre());
                tabla.addCell(curso.getCodigo());
                tabla.addCell(curso.getCreditos());
                tabla.addCell(curso.getHoras());
            }
            //Agrega tabla
            pdf.add(tabla)

            */
            for (String curso: this.listaCursos) {
                //Crea las celdas y las llena con la información de cada curso
                PdfPCell nombreCurso = new PdfPCell(new Phrase(curso, fuente));
                nombreCurso.setBorderColor(BaseColor.BLUE.darker());
                nombreCurso.setFixedHeight(25);
                nombreCurso.setHorizontalAlignment(1);
                PdfPCell codigo = new PdfPCell(new Phrase("", fuente));
                codigo.setBorderColor(BaseColor.BLUE.darker());
                codigo.setFixedHeight(25);
                codigo.setHorizontalAlignment(1);
                PdfPCell cantCreditos = new PdfPCell(new Phrase("", fuente));
                cantCreditos.setBorderColor(BaseColor.BLUE.darker());
                cantCreditos.setFixedHeight(25);
                cantCreditos.setHorizontalAlignment(1);
                PdfPCell horasLectivas = new PdfPCell(new Phrase("", fuente));
                horasLectivas.setBorderColor(BaseColor.BLUE.darker());
                horasLectivas.setFixedHeight(25);
                horasLectivas.setHorizontalAlignment(1);
                //Agrega las columnas a la tabla
                tabla.addCell(nombreCurso);
                tabla.addCell(codigo);
                tabla.addCell(cantCreditos);
                tabla.addCell(horasLectivas);
            }
            pdf.add(tabla);
            //Cierra el documento con todos los elementos agregados
            pdf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
