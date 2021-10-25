package com.sistema.gui;

import com.sistema.controladores.Controlador;
import com.sistema.logicadenegocios.Curso;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Francisco Javier Ovares Rojas
 * @version 1.0
 */
public class ConsultaCorrquisitos extends JFrame{
  private JPanel ConsultaCorrequisitos;
  private JTextField textFieldNombre;
  private JTextField textFieldCodigo;
  private JButton consultarButton;
  private JButton volverButton;
  private JTable table1;

  /** Constructor */
  public ConsultaCorrquisitos() {
    setContentPane(ConsultaCorrequisitos);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(500,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("Icon/logo.png")).getImage());

    consultarButton.addActionListener(new ActionListener() {
      /**
       * Realiza la consulta de los correquisitos del curso.
       * @param e
       */
       @Override
       public void actionPerformed(ActionEvent e) {

         String columnas[] = {"Nombre Curso", "Código", "Créditos", "Horas Lectivas"};
         DefaultTableModel tb = new DefaultTableModel(columnas,0);
         String nombreCurso = textFieldNombre.getText();
         String codigoCurso = textFieldCodigo.getText();
         ArrayList<Curso> cursos = Controlador.getRequisitos(codigoCurso);
         if (cursos != null) {
           table1.setModel(tb);
           tb.addRow(columnas);

           for (Curso curso : cursos) {
             Object[] object = {curso.getNombreCurso(), curso.getCodigo(), String.valueOf(curso.getCreditos()), String.valueOf(curso.getHorasLectivas())};
             tb.addRow(object);
           }
         }
       }
    });

    volverButton.addActionListener(new ActionListener() {
      /**
       * Vuelve al menu de consultas.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Consultas nuevaConsulta = new Consultas();
        nuevaConsulta.setVisible(true);
      }
    });
  }
}
