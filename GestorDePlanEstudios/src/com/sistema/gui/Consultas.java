package com.sistema.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Consultas extends JFrame{
  // Componentes.
  private JPanel panelConsultas;
  private JButton consultarPlanDeEstudiosButton;
  private JButton consultarCursoButton;
  private JButton consultarRequisitosDeCursoButton;
  private JButton cursultarCorrequisitosDeCursoButton;
  private JButton volverButton;


  public Consultas() {
    setContentPane(panelConsultas);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(500,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("Icon/logo.png")).getImage());

    consultarPlanDeEstudiosButton.addActionListener(new ActionListener() {
      /**
       * Abre ventana para consultar sobre un plan de estudios.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        ConsultaPlan consultaPlan = new ConsultaPlan();
        consultaPlan.setVisible(true);
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
        MainGui nuevaMainGui = new MainGui();
        nuevaMainGui.setVisible(true);
      }
    });

    consultarCursoButton.addActionListener(new ActionListener() {
      /**
       * Abre ventana para consultar sobre un curso y los planes en los que esta.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        ConsultarCurso consultaCurso = new ConsultarCurso();
        consultaCurso.setVisible(true);
      }
    });

    consultarRequisitosDeCursoButton.addActionListener(new ActionListener() {
      /**
       * Abre ventana para consultar sobre los requisitos de un curso.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        ConsultaRequisitos consultaRequisitos = new ConsultaRequisitos();
        consultaRequisitos.setVisible(true);
      }
    });

    cursultarCorrequisitosDeCursoButton.addActionListener(new ActionListener() {
      /**
       * Abre ventana para consultar sobre los correquisitos de un curso.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        ConsultaCorrquisitos consultaCorrquisitos = new ConsultaCorrquisitos();
        consultaCorrquisitos.setVisible(true);
      }
    });
  }
}
