package com.sistema.gui;

import com.sistema.clases_auxiliares.GeneratorPDF;
import com.sistema.clases_auxiliares.JavaMailAPI;
import com.sistema.controladores.Controlador;
import com.sistema.excepciones.PlanDeEstudioDoesntExistException;
import com.sistema.logicadenegocios.Curso;
import com.sistema.logicadenegocios.Escuela;
import com.sistema.logicadenegocios.PlanDeEstudio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Francisco Javier Ovares Rojas
 * @version 1.0
 */
public class ConsultaPlan extends JFrame{
  // Componentes
  private JPanel Consulta;
  private JComboBox<Escuela> comboBoxEscuelas;

  private JTextField textFieldVigencia;
  private JButton generarPDFYEnviarButton;
  private JTable tableCursosInformacion;
  private JButton regresarButton;
  private JTextField textFieldNombreE;
  private JTextField textFieldCorreo;
  private JComboBox planesComboBox;
  private JButton verPlanes;
  private JButton verCursosDePlanButton;

  /** Constructor */
  public ConsultaPlan() {
    setContentPane(Consulta);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(900,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);


    comboBoxEscuelas.setModel(new DefaultComboBoxModel(Controlador.ESCUELAS.toArray(new Escuela[0])));

    verCursosDePlanButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        PlanDeEstudio planDeEstudio = (PlanDeEstudio) planesComboBox.getSelectedItem();

        ArrayList<Curso> cursos = planDeEstudio.getCursos();
        String columnas[] = {"Nombre Curso", "Código", "Créditos", "Horas Lectivas"};
        DefaultTableModel tb = new DefaultTableModel(columnas,0);
        tableCursosInformacion.setModel(tb);

        tb.addRow(columnas);
        for (Curso curso: cursos){
          Object[] object = {curso.getNombreCurso(),curso.getCodigo(), String.valueOf(curso.getCreditos()), String.valueOf(curso.getHorasLectivas())};
          tb.addRow(object);
        }


      }
    });

    verPlanes.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ArrayList<PlanDeEstudio> planesDeEscuela = Controlador.getPlanesDeUnaEscuela(Objects.requireNonNull(comboBoxEscuelas.getSelectedItem()).toString());
        planesComboBox.setModel(new DefaultComboBoxModel(planesDeEscuela.toArray()));
      }
    });



    regresarButton.addActionListener(new ActionListener() {
      /**
       * Regresa al menu de consultas.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Consultas nuevaConsulta = new Consultas();
        nuevaConsulta.setVisible(true);
      }
    });

    generarPDFYEnviarButton.addActionListener(new ActionListener() {
      /**
       * @autor Marco Reveiz
       * Genera pdf y envía el correo.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        //Envia correo
        try {
          // Crea Plan
          PlanDeEstudio plan = Controlador.getPlanDeEstudio(Integer.parseInt(planesComboBox.getSelectedItem().toString()));
          // Escuela
          Escuela escuela = (Escuela) comboBoxEscuelas.getSelectedItem();
          //Nombre
           String nombre = textFieldNombreE.getText();
          //Crea generador de PDF
          GeneratorPDF generatorPDF = new GeneratorPDF(nombre, ((Escuela) comboBoxEscuelas.getSelectedItem()).getNombre(), plan.getCursos(), plan.toString(), textFieldVigencia.getText());
          generatorPDF.generatePDF();
          JavaMailAPI.enviarCorreo(textFieldNombreE.getText(),textFieldCorreo.getText());
          JOptionPane.showMessageDialog(null,"Correo enviado!");
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }

    });
  }
}
