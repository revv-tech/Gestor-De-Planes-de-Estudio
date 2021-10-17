package com.sistema.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanEstudio extends JFrame{
  private JPanel PlanEstudio;
  private JTextField textFieldCodigoCurso;
  private JComboBox comboBoxBloque;
  private JButton registrarCursoAlPlanButton;
  private JButton regresarButton;
  private JComboBox comboBox2;
  private JTextField textFieldCodigoPlan;
  private JTextField textFieldVigencia;

  public PlanEstudio() {
    setContentPane(PlanEstudio);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(600,500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    regresarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registro nuevoRegistro = new Registro();
        nuevoRegistro.setVisible(true);
      }
    });
  }
}
