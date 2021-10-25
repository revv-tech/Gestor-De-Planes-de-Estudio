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
  private JTextField textFieldCodigo;
  private JButton consultarButton;
  private JButton volverButton;
  private JTable table1;
  private JComboBox comboBox1;

  /** Constructor */
  public ConsultaCorrquisitos() {
    setContentPane(ConsultaCorrequisitos);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(500,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("Icon/logo.png")).getImage());
    comboBox1.setModel(new DefaultComboBoxModel(Controlador.CURSOS.toArray()));
    textFieldCodigo.setEditable(false);
    consultarButton.addActionListener(new ActionListener() {
      /**
       * Realiza la consulta de los correquisitos del curso.
       * @param e
       */
       @Override
       public void actionPerformed(ActionEvent e) {

         String columnas[] = {"Nombre Curso", "Código", "Créditos", "Horas Lectivas"};
         DefaultTableModel tb = new DefaultTableModel(columnas,0);
         Curso curso = (Curso) comboBox1.getSelectedItem();
         textFieldCodigo.setText(curso.getCodigo());
         ArrayList<Curso> cursos = Controlador.getCorequisitos(curso.getCodigo());



         if (cursos != null) {
           table1.setModel(tb);
           tb.addRow(columnas);

           for (Curso pCurso : cursos) {
             Object[] object = {pCurso.getNombreCurso(), pCurso.getCodigo(), String.valueOf(pCurso.getCreditos()), String.valueOf(pCurso.getHorasLectivas())};
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
