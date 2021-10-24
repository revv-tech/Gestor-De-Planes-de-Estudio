package com.sistema.gui;

import com.sistema.controladores.Controlador;
import com.sistema.excepciones.EscuelaAlreadyExistsException;
import com.sistema.logicadenegocios.Escuela;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Francisco Javier Ovares Rojas
 * @version 1.0
 */
public class EscuelaAreaAcademica extends JFrame{
  // Componentes.
  private JPanel EscuelaArea;
  private JLabel jlTitulo;
  private JTextField tfNombre;
  private JTextField tfCodigo;
  private JButton registrarButton;
  private JButton limparButton;

  /** Constructor */
  public EscuelaAreaAcademica() {
    setContentPane(EscuelaArea);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    limparButton.addActionListener(new ActionListener() {
      /**
       * Limpia los datos ingresados en el panel.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        tfNombre.setText(null);
        tfCodigo.setText(null);
      }
    });

    registrarButton.addActionListener(new ActionListener() {
      /**
       * Registra una nueva escuela o area academica.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        String nombre = tfNombre.getText();
        String codigo = tfCodigo.getText();
        Escuela escuela = new Escuela(nombre,codigo);
        try {
          Controlador.agregarEscuela(escuela);
        } catch (EscuelaAlreadyExistsException ex) {
          ex.printStackTrace();
        }
        Registro nuevoRegistro = new Registro();
        nuevoRegistro.setVisible(true);
      }
    });
  }
}
