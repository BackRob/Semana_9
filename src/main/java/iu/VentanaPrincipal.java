package iu;



import util.GestorDatos;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private VentanaSecundaria ventanaClientes;
    private VentanaSecundaria ventanaTours;
    private VentanaSecundaria ventanaVehiculos;
    private VentanaSecundaria ventanaGuias;
    private VentanaSecundaria ventanaReservas;
    private final GestorDatos gestorDatos;


    public VentanaPrincipal() {
        this.gestorDatos = new GestorDatos();
        setTitle("Sistema de Reservas");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));

        JButton btnClientes = new JButton("Clientes");
        JButton btnTours = new JButton("Tours");
        JButton btnVehiculos = new JButton("Vehículos");
        JButton btnGuias = new JButton("Guías");
        JButton btnReservas = new JButton("Reservas");

        panel.add(btnClientes);
        panel.add(btnTours);
        panel.add(btnVehiculos);
        panel.add(btnGuias);
        panel.add(btnReservas);

        add(panel);

        //botones con la condicion de solo abrir una ventana.
        btnClientes.addActionListener(e -> {

            if (ventanaClientes == null || !ventanaClientes.isDisplayable()) {

                ventanaClientes =
                        new VentanaSecundaria(TipoVentana.CLIENTES,gestorDatos);

                ventanaClientes.setVisible(true);

            } else {

                ventanaClientes.toFront();
                ventanaClientes.requestFocus();

            }
        });

        btnTours.addActionListener(e ->{
            if (ventanaTours == null || !ventanaTours.isDisplayable()) {
                ventanaTours =
                        new VentanaSecundaria(TipoVentana.TOURS,gestorDatos);
                ventanaTours.setVisible(true);
            } else {
                ventanaTours.toFront();
                ventanaTours.requestFocus();

            }
        });

        btnVehiculos.addActionListener(e ->{
            if (ventanaVehiculos == null || !ventanaVehiculos.isDisplayable()) {
                ventanaVehiculos =
                        new VentanaSecundaria(TipoVentana.VEHICULOS,gestorDatos);
                ventanaVehiculos.setVisible(true);
            } else {
                ventanaVehiculos.toFront();
                ventanaVehiculos.requestFocus();
            }
        });

        btnGuias.addActionListener(e ->{
            if (ventanaGuias == null || !ventanaGuias.isDisplayable()) {
                ventanaGuias =
                        new VentanaSecundaria(TipoVentana.GUIAS,gestorDatos);
                ventanaGuias.setVisible(true);
            } else {
                ventanaGuias.toFront();
                ventanaGuias.requestFocus();
            }
        });


        btnReservas.addActionListener(e ->{
            if (ventanaReservas == null || !ventanaReservas.isDisplayable()) {
                ventanaReservas =
                        new VentanaSecundaria(TipoVentana.RESERVAS,gestorDatos);
                ventanaReservas.setVisible(true);
            } else {
                ventanaReservas.toFront();
                ventanaReservas.requestFocus();
            }
        });
    }


}

