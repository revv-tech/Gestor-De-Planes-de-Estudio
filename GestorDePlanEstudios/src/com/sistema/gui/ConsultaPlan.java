package com.sistema.gui;

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

  /** Constructor */
  public ConsultaPlan() {
    setContentPane(Consulta);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(800,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

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
       * Genera pdf y envía el correo.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        // Aqui iria lo de generara pdf y el correo.
      }

    });
  }
}
