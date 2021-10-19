package com.sistema.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Francisco Javier Ovares Rojas
 * @version 1.0
 */
public class ConsultaRequisitos extends JFrame{
  // Componentes.
  private JPanel ConsultaRequisitos;
  private JTextField textFieldNombre;
  private JTextField textFieldCodigo;
  private JButton consultarButton;
  private JList listRequisitos;
  private JButton volverButton;

  /** Constructor */
  public ConsultaRequisitos() {
    setContentPane(ConsultaRequisitos);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(500,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("Icon/logo.png")).getImage());

    consultarButton.addActionListener(new ActionListener() {
      /**
       * Realiza la consulta sobre los requistos del curso.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    volverButton.addActionListener(new ActionListener() {
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
  }
}
