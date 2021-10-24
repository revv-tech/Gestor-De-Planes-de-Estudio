package com.sistema.gui;

import com.sistema.clases_auxiliares.GeneratorPDF;
import com.sistema.clases_auxiliares.JavaMailAPI;
import com.sistema.logicadenegocios.Escuela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Francisco Javier Ovares Rojas
 * @version 1.0
 */
public class ConsultaPlan extends JFrame{
  // Componentes
  private JPanel Consulta;
  private JComboBox comboBoxEscuelas;
  private JTextField textFieldCodigoPlan;
  private JTextField textFieldVigencia;
  private JButton generarPDFYEnviarButton;
  private JTable tableCursosInformacion;
  private JButton regresarButton;
  private JTextField textFieldNombreE;
  private JTextField textFieldCorreo;

  /** Constructor */
  public ConsultaPlan() {
    setContentPane(Consulta);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(800,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    //comboBoxEscuelas.setModel(new DefaultComboBoxModel(<Escuela>()));



    comboBoxEscuelas.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

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
        // Escuela
        Escuela escuela = (Escuela) comboBoxEscuelas.getSelectedItem();
        // Codigo de Plan
        String planID = textFieldCodigoPlan.getText();
        //Crea generador de PDF
        GeneratorPDF generatorPDF = new GeneratorPDF(textFieldNombreE.getText(),comboBoxEscuelas.getName(), escuela.getCursos(), textFieldCodigoPlan.getText());
        generatorPDF.generatePDF();
        //Envia correo
        try {
          JavaMailAPI.enviarCorreo(textFieldNombreE.getText(),textFieldCorreo.getText());
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }

    });
  }
}
