package com.sistema.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

  public ModificarInformacion() {
    setContentPane(ModificaInformacion);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("Icon/logo.png")).getImage());

    eliminarRequisitoButton.addActionListener(new ActionListener() {
      /**
       * Elimina los requisitos del curso seleccionado.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    eliminarCorrquisitoButton.addActionListener(new ActionListener() {
      /**
       * Eliminar los correquisitos del curso seleccionado.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    eliminarCursoButton.addActionListener(new ActionListener() {
      /**
       * Elimina un curso. Unicamente los no asocianos a planes.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {

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
