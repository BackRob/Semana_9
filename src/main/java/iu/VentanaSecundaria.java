package iu;

import javax.swing.*;
import java.awt.*;

public class VentanaSecundaria extends JFrame {

    private JTextArea txtArea;
    private TipoVentana tipo;

    public VentanaSecundaria(TipoVentana tipo) {
         this.tipo = tipo;

        setTitle(tipo.toString());
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        txtArea = new JTextArea();
        txtArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(txtArea);

        JPanel panelBotones = new JPanel();

        JButton btnAgregar = new JButton("Agregar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnVolver = new JButton("Volver");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnVolver);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnVolver.addActionListener(e -> dispose());

        setVisible(true);
    }
}