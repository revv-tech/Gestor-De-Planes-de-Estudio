package com.sistema.gui;

import com.sistema.controladores.Controlador;
import com.sistema.excepciones.CursoAlreadyExistsException;
import com.sistema.excepciones.CursoDoesntExistException;
import com.sistema.excepciones.EscuelaDoesntExistException;
import com.sistema.logicadenegocios.Curso;
import com.sistema.logicadenegocios.Escuela;

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
    setSize(800,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("Icon/logo.png")).getImage());
    comboBoxEscuelas.setModel(new DefaultComboBoxModel(Controlador.ESCUELAS.toArray(new Escuela[0])));
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
          Curso requisito = (Curso) comboBoxCodigoRquisito.getSelectedItem();
          Curso cursoSelected = (Curso) comboBoxCodigoCurso.getSelectedItem();
          Escuela escuela = (Escuela) comboBoxEscuelas.getSelectedItem();

          Controlador.registrarRequisito(requisito, escuela.getCodigo(), cursoSelected.getCodigo());
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
          Curso coRequisito = (Curso) comboBoxCodigoCorrequisito.getSelectedItem();
          Curso cursoSelected = (Curso) comboBoxCodigoCurso.getSelectedItem();
          Escuela escuela = (Escuela) comboBoxEscuelas.getSelectedItem();
          Controlador.registrarCorequisito(coRequisito, escuela.getCodigo(), cursoSelected.getCodigo());
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

        Escuela escuela = (Escuela) comboBoxEscuelas.getSelectedItem();
        System.out.println(escuela.getCursos());
        ArrayList<Curso> cursosDisponibles;
        try {
          cursosDisponibles = Controlador.getEscuela(escuela.getCodigo()).getCursos();
          System.out.println( escuela.getCodigo());
          comboBoxCodigoCurso.setModel(new DefaultComboBoxModel(cursosDisponibles.toArray()));
        } catch (EscuelaDoesntExistException ex) {
          ex.printStackTrace();
        }


      }
    });
  }
}
