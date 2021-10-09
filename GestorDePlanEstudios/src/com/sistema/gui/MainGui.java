package com.sistema.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui extends JFrame{

    private JPanel Window;
    private JButton registrosButton;
    private JButton salirButton;
    private JButton consultasButton;

    public MainGui() {
        setContentPane(Window);
        setTitle("Sistema Gestor de Planes de Estudio");
        setSize(450,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        consultasButton.addActionListener(new ActionListener() {
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
                registros nuevoRegistros = new registros();
                nuevoRegistros.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        MainGui guiPrincipal = new MainGui();
    }
}
