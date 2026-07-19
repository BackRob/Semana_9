package app;

import iu.TipoVentana;
import iu.VentanaPrincipal;
import model.*;
import util.GestorDatos;
import util.TipoDato;

import javax.swing.*;

public class main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}