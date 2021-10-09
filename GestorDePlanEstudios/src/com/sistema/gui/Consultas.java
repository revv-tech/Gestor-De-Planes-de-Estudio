package com.sistema.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Consultas extends JFrame{
    private JButton volverButton;
    private JPanel consultas;

    public Consultas() {
        setContentPane(consultas);
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
