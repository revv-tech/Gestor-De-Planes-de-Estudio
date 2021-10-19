package com.sistema.gui;

//import com.sistema.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Francisco Javier Ovares Rojas
 * @version 1.0
 */
public class Registro extends JFrame {
  // Componentes.
  private JButton registrarEscuelaOÁreaButton;
  private JPanel WindowRegistrar;
  private JButton registrarPlanesDeEstudioButton;
  private JButton registrarCursosButton;
  private JButton asignarRequisitosYCorrequisitosButton;
  private JButton volverButton;

  /** Constructor */
  public Registro() {
    setContentPane(WindowRegistrar);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("Icon/logo.png")).getImage());

    volverButton.addActionListener(new ActionListener() {
      /**
       * Vuelve al menu principal.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        MainGui nuevaMainGui = new MainGui();
        nuevaMainGui.setVisible(true);
      }
    });

    registrarCursosButton.addActionListener(new ActionListener() {
      /**
       * Abre una ventana para registrar un curso.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Curso nuevoCurso = new Curso();
        nuevoCurso.setVisible(true);
      }
    });

    registrarEscuelaOÁreaButton.addActionListener(new ActionListener() {
      /**
       * Abre un ventana para registrar una escuela o area academica.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        EscuelaAreaAcademica nuevaEscuelaArea = new EscuelaAreaAcademica();
        nuevaEscuelaArea.setVisible(true);
      }
    });

    asignarRequisitosYCorrequisitosButton.addActionListener(new ActionListener() {
      /**
       * Abre una ventana para registrar un requisito o correquisito de curso.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        RequisitoCorrequisito nuevoCoReQuisito = new RequisitoCorrequisito();
        nuevoCoReQuisito.setVisible(true);
      }
    });

    registrarPlanesDeEstudioButton.addActionListener(new ActionListener() {
      /**
       * Abre una ventana para registrar un plan de estudios.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        PlanEstudio nuevoPlan = new PlanEstudio();
        nuevoPlan.setVisible(true);
      }
    });
  }
}
