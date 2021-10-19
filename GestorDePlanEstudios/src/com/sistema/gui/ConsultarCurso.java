package com.sistema.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarCurso extends JFrame{
  // Componentes
  private JPanel ConsultaCurso;
  private JButton consultarButton;
  private JButton limpiarCamposButton;
  private JTextField textFieldNombre;
  private JTextField textFieldCodigo;
  private JButton volverButton;
  private JList listPlanesDeEstudio;

  public ConsultarCurso() {
    setContentPane(ConsultaCurso);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(500,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("Icon/logo.png")).getImage());

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

    consultarButton.addActionListener(new ActionListener() {
      /**
       * Realiza la consulta del curso en los diferentes planes de estudio.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    limpiarCamposButton.addActionListener(new ActionListener() {
      /**
       * Limpia los datos en pantalla.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        textFieldCodigo.setText(null);
        textFieldNombre.setText(null);
        listPlanesDeEstudio.removeAll();
      }
    });
  }
}
