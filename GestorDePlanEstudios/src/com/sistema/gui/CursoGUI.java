package com.sistema.gui;

import com.sistema.controladores.Controlador;
import com.sistema.excepciones.CursoAlreadyExistsException;
import com.sistema.excepciones.EscuelaDoesntExistException;
import com.sistema.logicadenegocios.Curso;
import com.sistema.logicadenegocios.Escuela;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Francisco Javier Ovares Rojas
 * @version 1.0
 */
public class CursoGUI extends JFrame{
  // Componentes.
  private JPanel Curso;
  private JButton registrarButton;
  private JButton limpiarCamposButton;
  private JComboBox comboBoxEscuelas;
  private JTextField textFieldNombre;
  private JTextField textFieldCodigo;
  private JComboBox comboBoxCreditos;
  private JComboBox comboBoxHorasLectivas;

  /** Constructor */
  public CursoGUI() {
    setContentPane(Curso);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(450,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    comboBoxEscuelas.setModel(new DefaultComboBoxModel(Controlador.ESCUELAS.toArray(new Escuela[0])));

    registrarButton.addActionListener(new ActionListener() {
      /**
       * Registra un nuevo curso y vuelve al menu de registros.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        // Falta codigo de registrar.
        setVisible(false);
        String idEscuela = comboBoxEscuelas.getSelectedItem().toString();
        String nombreCurso = textFieldNombre.getText();
        String codigoCurso = textFieldCodigo.getText();

        com.sistema.logicadenegocios.Curso curso = new Curso(idEscuela,nombreCurso,codigoCurso,comboBoxCreditos.getItemCount(),comboBoxHorasLectivas.getItemCount());
        try {
          Controlador.registrarCursoEnEscuela(curso,idEscuela);
          Controlador.CURSOS.add(curso);

        } catch (CursoAlreadyExistsException ex) {
          ex.printStackTrace();
        } catch (EscuelaDoesntExistException ex) {
          ex.printStackTrace();
        }

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
