package com.sistema.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Francisco Javier Ovares Rojas
 * @version 1.0
 */
public class RequisitoCorrequisito extends JFrame{
  // Componentes.
  private JPanel RequisitoCorrequisito;
  private JComboBox comboBoxCodigoCurso;
  private JComboBox comboBoxEscuelas;
  private JComboBox comboBoxCodigoRquisito;
  private JComboBox comboBoxCodigoCorrequisito;
  private JButton registrarCorrequisitoButton;
  private JButton registrarRequisitoButton;
  private JButton cerrarButton;

  /** Constructor */
  public RequisitoCorrequisito() {
    setContentPane(RequisitoCorrequisito);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(600,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("Icon/logo.png")).getImage());

    cerrarButton.addActionListener(new ActionListener() {
      /**
       * Cierra el programa.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    registrarRequisitoButton.addActionListener(new ActionListener() {
      /**
       * Registra un requisito.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registro nuevoRegistro = new Registro();
        nuevoRegistro.setVisible(true);
      }
    });

    registrarCorrequisitoButton.addActionListener(new ActionListener() {
      /**
       * Registra un correquisito.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registro nuevoRegistro = new Registro();
        nuevoRegistro.setVisible(true);
      }
    });
  }
}
