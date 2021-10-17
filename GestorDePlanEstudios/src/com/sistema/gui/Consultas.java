package com.sistema.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Consultas extends JFrame{
  private JPanel Consulta;
  private JComboBox comboBoxEscuelas;
  private JTextField textFieldCodigoPlan;
  private JTextField textFieldVigencia;
  private JButton generarPDFYEnviarButton;
  private JTable tableCursosInformacion;
  private JButton regresarButton;

  public Consultas() {
    setContentPane(Consulta);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(800,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    regresarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        MainGui nuevaMainGui = new MainGui();
        nuevaMainGui.setVisible(true);
      }
    });

    generarPDFYEnviarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Aqui iria lo de generara pdf y el correo.
      }
    });
  }
}
