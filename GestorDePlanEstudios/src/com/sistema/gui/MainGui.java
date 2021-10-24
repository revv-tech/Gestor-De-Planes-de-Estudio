package com.sistema.gui;

import com.sistema.controladores.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Francisco Javier Ovares Rojas
 * @version 1.0
 */
public class MainGui extends JFrame{
  // Componentes.
  private JPanel Window;
  private JButton registrosButton;
  private JButton salirButton;
  private JButton consultasButton;
  private JButton modificacionesButton;


  /** Constructor */
  public MainGui() {
    setContentPane(Window);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("Icon/logo.png")).getImage());

    salirButton.addActionListener(new ActionListener() {
      /**
       * Cierra el programa.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
    });

    consultasButton.addActionListener(new ActionListener() {
      /**
       * Abre la ventana de consultas.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Consultas nuevaConsulta = new Consultas();
        nuevaConsulta.setVisible(true);
      }
    });

    registrosButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registro nuevoRegistro = new Registro();
        nuevoRegistro.setVisible(true);
      }
    });

    modificacionesButton.addActionListener(new ActionListener() {
      /**
       * Abre la ventana para modificar informacion del sistema.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        ModificarInformacion nuevoModificacion = new ModificarInformacion();
        nuevoModificacion.setVisible(true);
      }
    });
  }

  public static void main(String[] args) {
    MainGui guiPrincipal = new MainGui();
  }
}