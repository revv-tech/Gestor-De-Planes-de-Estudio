package com.sistema.gui;

import com.sistema.controladores.Controlador;
import com.sistema.excepciones.CursoDoesntExistException;
import com.sistema.excepciones.PlanDeEstudioDoesntExistException;
import com.sistema.logicadenegocios.Curso;
import com.sistema.logicadenegocios.Escuela;
import com.sistema.logicadenegocios.PlanDeEstudio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Francisco Javier Ovares Rojas
 * @version 1.0
 */
public class ModificarInformacion extends JFrame{
  // Componentes.
  private JPanel ModificaInformacion;
  private JButton eliminarRequisitoButton;
  private JButton eliminarCorrquisitoButton;
  private JButton eliminarCursoButton;
  private JComboBox comboBox1;
  private JComboBox comboBox2;
  private JComboBox comboBox3;
  private JButton volverButton;
  private JComboBox comboBox4;
  private JButton verCursosButton;
  private JButton verRequisitosDelCursoButton;

  /** Constructor */
  public ModificarInformacion() {
    setContentPane(ModificaInformacion);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("Icon/logo.png")).getImage());
    comboBox4.setModel(new DefaultComboBoxModel(Controlador.PLANES_DE_ESTUDIOS.toArray(new PlanDeEstudio[0])));

    verRequisitosDelCursoButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Curso curso = (Curso) comboBox1.getSelectedItem();
        comboBox2.setModel(new DefaultComboBoxModel(curso.getRequisitos().toArray(new Curso[0])));

      }
    });

    verCursosButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        PlanDeEstudio planDeEstudio = (PlanDeEstudio) comboBox4.getSelectedItem();
        System.out.println(planDeEstudio.getCursos());
        comboBox1.setModel(new DefaultComboBoxModel(planDeEstudio.getCursos().toArray(new Curso[0])));
      }
    });
    eliminarRequisitoButton.addActionListener(new ActionListener() {
      /**
       * Elimina los requisitos del curso seleccionado.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        Curso curso = (Curso) comboBox1.getSelectedItem();
        Curso requisito = (Curso) comboBox2.getSelectedItem();
        PlanDeEstudio planDeEstudio = (PlanDeEstudio) comboBox4.getSelectedItem();
        try {
          Controlador.eliminarRequisitoCursoPlanEstudio(requisito.getCodigo(),planDeEstudio.getCodigoPlanEstudios(),curso.getCodigo());
        } catch (CursoDoesntExistException ex) {
          ex.printStackTrace();
        } catch (PlanDeEstudioDoesntExistException ex) {
          ex.printStackTrace();
        }

      }
    });

    eliminarCorrquisitoButton.addActionListener(new ActionListener() {
      /**
       * Eliminar curso del plan seleccionado.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        PlanDeEstudio planDeEstudio = (PlanDeEstudio) comboBox4.getSelectedItem();
        Curso curso = (Curso) comboBox1.getSelectedItem();
        try {
          Controlador.eliminarCursoEnPlanEstudio(planDeEstudio.getCodigoPlanEstudios(),curso.getCodigo());
        } catch (PlanDeEstudioDoesntExistException ex) {
          ex.printStackTrace();
        } catch (CursoDoesntExistException ex) {
          ex.printStackTrace();
        }
      }
    });

    eliminarCursoButton.addActionListener(new ActionListener() {
      /**
       * Elimina un curso. Unicamente los no asocianos a planes.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {

        PlanDeEstudio planDeEstudio = (PlanDeEstudio) comboBox4.getSelectedItem();
        Curso curso = (Curso) comboBox1.getSelectedItem();
        try {
          Controlador.eliminarCursoEnPlanEstudio(planDeEstudio.getCodigoPlanEstudios(),curso.getCodigo());
        } catch (PlanDeEstudioDoesntExistException ex) {
          ex.printStackTrace();
        } catch (CursoDoesntExistException ex) {
          ex.printStackTrace();
        }
      }
    });

    volverButton.addActionListener(new ActionListener() {
      /**
       * Vuelve al menu principal.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        MainGui nuevoMainGui = new MainGui();
        nuevoMainGui.setVisible(true);
      }
    });
  }
}
