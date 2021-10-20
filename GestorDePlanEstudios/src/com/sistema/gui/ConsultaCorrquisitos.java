package com.sistema.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Francisco Javier Ovares Rojas
 * @version 1.0
 */
public class ConsultaCorrquisitos extends JFrame{
  private JPanel ConsultaCorrequisitos;
  private JTextField textFieldNombre;
  private JTextField textFieldCodigo;
  private JButton consultarButton;
  private JList listCorrequisitos;
  private JButton volverButton;

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
