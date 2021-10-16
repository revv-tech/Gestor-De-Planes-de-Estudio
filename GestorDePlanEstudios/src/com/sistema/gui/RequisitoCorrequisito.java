package com.sistema.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequisitoCorrequisito extends JFrame{
  private JPanel RequisitoCorrequisito;
  private JComboBox comboBoxCodigoCurso;
  private JComboBox comboBoxEscuelas;
  private JComboBox comboBoxCodigoRquisito;
  private JComboBox comboBoxCodigoCorrequisito;
  private JButton registrarCorrequisitoButton;
  private JButton registrarRequisitoButton;
  private JButton cerrarButton;

  public RequisitoCorrequisito() {
    setContentPane(RequisitoCorrequisito);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(600,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    cerrarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    registrarRequisitoButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registro nuevoRegistro = new Registro();
        nuevoRegistro.setVisible(true);
      }
    });

    registrarCorrequisitoButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registro nuevoRegistro = new Registro();
        nuevoRegistro.setVisible(true);
      }
    });
  }
}
