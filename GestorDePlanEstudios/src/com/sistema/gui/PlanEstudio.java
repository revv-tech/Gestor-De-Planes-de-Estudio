package com.sistema.gui;

import com.sistema.controladores.Controlador;
import com.sistema.excepciones.PlanDeEstudioAlreadyExistsException;
import com.sistema.logicadenegocios.Escuela;
import com.sistema.logicadenegocios.PlanDeEstudio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * @author Francisco Javier Ovares Rojas
 * @version 1.0
 */
public class PlanEstudio extends JFrame{
  // Componentes.
  private JPanel PlanEstudio;
  private JTextField textFieldCodigoCurso;
  private JComboBox comboBoxBloque;
  private JButton registrarCursoAlPlanButton;
  private JButton regresarButton;
  private JComboBox comboBoxEscuelas;
  private JTextField textFieldCodigoPlan;

    /** Constructor */
  public PlanEstudio() {
    setContentPane(PlanEstudio);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(600,500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());
    comboBoxEscuelas.setModel(new DefaultComboBoxModel(Controlador.ESCUELAS.toArray()));

    regresarButton.addActionListener(new ActionListener() {
      /**
       * Vuelve al menu de registros.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Registro nuevoRegistro = new Registro();
        nuevoRegistro.setVisible(true);
      }
    });

    registrarCursoAlPlanButton.addActionListener(new ActionListener() {
      /**
       * Registra un nuevo plan de estudios.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        Escuela escuela = (Escuela ) comboBoxEscuelas.getSelectedItem();
        PlanDeEstudio planDeEstudio = new PlanDeEstudio(escuela.getCodigo(), Integer.parseInt(textFieldCodigoPlan.getText().toString()));
        try {
          Controlador.agregarPlanDeEstudio(planDeEstudio);

        } catch (PlanDeEstudioAlreadyExistsException ex) {
          System.out.println(ex.getMessage());
        }
      }
    });
  }
}
