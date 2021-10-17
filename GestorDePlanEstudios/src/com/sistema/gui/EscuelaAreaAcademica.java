package com.sistema.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscuelaAreaAcademica extends JFrame{
  private JPanel EscuelaArea;
  private JLabel jlTitulo;
  private JTextField tfNombre;
  private JTextField tfCodigo;
  private JButton registrarButton;
  private JButton limparButton;

  public EscuelaAreaAcademica() {
    setContentPane(EscuelaArea);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    limparButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        tfNombre.setText(null);
        tfCodigo.setText(null);
      }
    });

    registrarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registro nuevoRegistro = new Registro();
        nuevoRegistro.setVisible(true);
      }
    });
  }
}
