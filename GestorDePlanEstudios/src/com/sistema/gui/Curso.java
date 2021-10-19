package com.sistema.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Curso extends JFrame{
  // Componentes
  private JPanel Curso;
  private JButton registrarButton;
  private JButton limpiarCamposButton;
  private JComboBox comboBoxEscuelas;
  private JTextField textFieldNombre;
  private JTextField textFieldCodigo;
  private JComboBox comboBoxCreditos;
  private JComboBox comboBoxHorasLectivas;

  public Curso() {
    setContentPane(Curso);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    registrarButton.addActionListener(new ActionListener() {
      /**
       * Registra un nuevo curso y vuelve al menu de registros.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        // Falta codigo de registrar.
        setVisible(false);
        Registro nuevoRegistro = new Registro();
        nuevoRegistro.setVisible(true);
      }
    });

    limpiarCamposButton.addActionListener(new ActionListener() {
      /**
       * Limpia los datos ingresados en el panel.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        textFieldNombre.setText(null);
        textFieldCodigo.setText(null);
        comboBoxCreditos.setSelectedIndex(0);
        //comboBoxEscuelas.setSelectedIndex(0);
        comboBoxHorasLectivas.setSelectedIndex(0);
      }
    });
  }
}
