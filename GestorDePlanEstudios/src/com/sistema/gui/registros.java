package com.sistema.gui;

import com.sistema.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registros extends JFrame {
    private JButton registrarEscuelaOÁreaButton;
    private JPanel WindowRegistrar;
    private JButton registrarPlanesDeEstudioButton;
    private JButton registrarCursosButton;
    private JButton asignarRequisitosYCorrequisitosButton;
    private JButton volverButton;

    public registros() {
        setContentPane(WindowRegistrar);
        setTitle("Sistema Gestor de Planes de Estudio");
        setSize(450,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainGui nuevaMainGui = new MainGui();
                nuevaMainGui.setVisible(true);
            }
        });
    }
}
