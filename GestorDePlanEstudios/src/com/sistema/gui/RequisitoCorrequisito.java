package com.sistema.gui;

import com.sistema.controladores.Controlador;
import com.sistema.excepciones.CursoAlreadyExistsException;
import com.sistema.excepciones.CursoDoesntExistException;
import com.sistema.excepciones.EscuelaDoesntExistException;
import com.sistema.logicadenegocios.Curso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
  private JButton btnRefreshCursos;

  /** Constructor */
  public RequisitoCorrequisito() {
    setContentPane(RequisitoCorrequisito);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(600,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("Icon/logo.png")).getImage());
    comboBoxEscuelas.setModel(new DefaultComboBoxModel(Controlador.ESCUELAS.toArray()));
    comboBoxCodigoRquisito.setModel(new DefaultComboBoxModel(Controlador.CURSOS.toArray()));
    comboBoxCodigoCorrequisito.setModel(new DefaultComboBoxModel(Controlador.CURSOS.toArray()));

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
        try {
          Curso cursoSelected = Controlador.getCurso(comboBoxCodigoRquisito.getSelectedItem().toString());
          Controlador.registrarRequisito(cursoSelected, comboBoxEscuelas.getSelectedItem().toString(), comboBoxCodigoCurso.getSelectedItem().toString());
        } catch (CursoDoesntExistException | CursoAlreadyExistsException | EscuelaDoesntExistException ex) {
          System.out.println(ex.getMessage());
        }

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
        try {
          Curso cursoSelected = Controlador.getCurso(comboBoxCodigoRquisito.getSelectedItem().toString());
          Controlador.registrarCorequisito(cursoSelected, comboBoxEscuelas.getSelectedItem().toString(), comboBoxCodigoCurso.getSelectedItem().toString());
        } catch (CursoDoesntExistException | CursoAlreadyExistsException | EscuelaDoesntExistException ex) {
          System.out.println(ex.getMessage());
        }

        setVisible(false);
        Registro nuevoRegistro = new Registro();
        nuevoRegistro.setVisible(true);
      }
    });
    btnRefreshCursos.addActionListener(new ActionListener() {
      /**
       * Invoked when an action occurs.
       *
       * @param e the event to be processed
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          ArrayList<Curso> cursosDisponibles = Controlador.getEscuela(comboBoxEscuelas.getSelectedItem().toString()).getCursos();
          comboBoxCodigoCurso.setModel(new DefaultComboBoxModel(cursosDisponibles.toArray()));
        } catch (EscuelaDoesntExistException ex) {
          System.out.println(ex.getMessage());
        }
      }
    });
  }
}
