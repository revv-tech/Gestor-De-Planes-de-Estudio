package com.sistema.gui;

import com.sistema.controladores.Controlador;
import com.sistema.logicadenegocios.Curso;
import com.sistema.logicadenegocios.PlanDeEstudio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Francisco Javier Ovares Rojas
 * @version 1.0
 */
public class ConsultarCurso extends JFrame{
  // Componentes.
  private JPanel ConsultaCurso;
  private JButton consultarButton;
  private JButton limpiarCamposButton;
  private JTextField textFieldCodigo;
  private JButton volverButton;
  private JList listPlanesDeEstudio;
  private JComboBox comboBox1;

  public ConsultarCurso() {
    setContentPane(ConsultaCurso);
    setTitle("Sistema Gestor de Planes de Estudio");
    setSize(500,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("Icon/logo.png"))).getImage());
    comboBox1.setModel(new DefaultComboBoxModel(Controlador.CURSOS.toArray()));

    volverButton.addActionListener(new ActionListener() {
      /**
       * Vuelve al menu de consultas.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        Consultas nuevaConsulta = new Consultas();
        nuevaConsulta.setVisible(true);
      }
    });

    consultarButton.addActionListener(new ActionListener() {
      /**
       * Realiza la consulta del curso en los diferentes planes de estudio.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        Curso curso = (Curso) comboBox1.getSelectedItem();
        ArrayList<PlanDeEstudio> planesConCurso = Controlador.getPlanesConCurso(curso.getCodigo());
        for (PlanDeEstudio planDeEstudio : planesConCurso) {
          listModel.addElement("Escuela Propietaria: " + planDeEstudio.getEscuelaPropietaria() +"  Código de Plan: " + planDeEstudio.toString());
        }
        listPlanesDeEstudio.setModel(listModel);
      }
    });

    limpiarCamposButton.addActionListener(new ActionListener() {
      /**
       * Limpia los datos en pantalla.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        textFieldCodigo.setText(null);
        listPlanesDeEstudio.removeAll();
      }
    });
  }
}
