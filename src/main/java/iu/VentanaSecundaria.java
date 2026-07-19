package iu;

import Exceptions.DatosDuplicados;
import Exceptions.DuracionInvalida;
import Exceptions.NoExisteCoincidencia;
import model.Cliente;
import model.Guia;
import model.Tour;
import model.Vehiculo;
import util.GestorDatos;

import javax.swing.*;
import java.awt.*;

public class VentanaSecundaria extends JFrame {

    private JTextArea txtArea;
    private TipoVentana tipoVentana;
    private GestorDatos gestorDatos;
    private boolean modoBuscar = false;
    private JButton btnBuscar;

    public VentanaSecundaria(TipoVentana tipo,GestorDatos gestorDatos) {
         this.tipoVentana = tipo;
         this.gestorDatos=gestorDatos;

        setTitle(tipo.toString());
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        txtArea = new JTextArea();
        actualizarJTexArea();
        txtArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(txtArea);

        JPanel panelBotones = new JPanel();

        JButton btnAgregar = new JButton("Agregar");
        JButton btnMostrar = new JButton("Mostrar");
        btnBuscar = new JButton("Buscar");
        JButton btnVolver = new JButton("Volver");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnVolver);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        btnAgregar.addActionListener(e -> agregar());
        btnVolver.addActionListener(e -> dispose());
        btnBuscar.addActionListener(e -> buscar());

        setVisible(true);



    }

    public void actualizarJTexArea(){
        txtArea.setText(gestorDatos.mostrarPorTipo(tipoVentana));
    }

    public void agregar() throws DatosDuplicados {
        switch (tipoVentana){
            case GUIAS -> solicitarGuia();
            case CLIENTES -> solicitarCliente();
            case TOURS ->solicitarTour();
            case VEHICULOS ->solicitarVehiculo();
        }
    }

    public String pedirString(String mensaje){
        String dato;
        while (true) {
            dato = JOptionPane.showInputDialog(mensaje);
            if(dato!=null) {
                if (!dato.trim().isEmpty()) {
                    return dato;

                }else{
                    JOptionPane.showMessageDialog(this,
                    "El campo no puede estar vacío.");
                }
            }else{
                return null;//CANCELO
            }
        }
    }

    public Double pedirDouble(String mensaje){
        while (true){
            String dato = JOptionPane.showInputDialog(mensaje);
            if (dato == null){
                return null; // Usuario canceló
            }
            try {
                return Double.parseDouble(dato);
            } catch (NumberFormatException e){
                mostrarMensaje("Debe ingresar un número válido");
            }
        }
    }

    public Integer pedirInt(String mensaje){
        while (true){
            String dato = JOptionPane.showInputDialog(mensaje);
            if (dato == null){
                return null; // Usuario canceló
            }
            try {
                return Integer.parseInt(dato);
            } catch (NumberFormatException e){
                mostrarMensaje("Debe ingresar un número entero válido");
            }
        }
    }

    //pide String y valdia que sea rut
    public String pedirRut(){
        String rut;
        while(true) {
            rut = pedirString("Ingrese Rut Valido (xxxxxxxx-x)");
            if (rut == null) {
                return null;
            }
            if (rut.matches("\\d{7,8}-[0-9Kk]")) {
                return rut;
            } else {
                mostrarError("Ingrese rut con formato valido.");
            }
        }
    }

    public void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje);
    }


    //solicita datos para crear guia
    public void solicitarGuia(){
        String nombre = pedirString("Ingrese Nombre");
        if (nombre==null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        String rut = pedirRut();
        if (rut==null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        String empresa = pedirString("Ingrese Empresa");
        if(empresa==null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        String tipoGuia = pedirString("Ingrese el tipo de guia");
        if (tipoGuia==null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        try {
            gestorDatos.agregarAlGestor(new Guia(nombre,rut,empresa,tipoGuia));
            actualizarJTexArea();
            mostrarMensaje("Vehículo registrado correctamente");
        }catch (DatosDuplicados e){
            mostrarError("No se pudo registrar Guia, Guia ya existe");

        }
    }


    //solicita datos para crear cliente
    public void solicitarCliente(){
        String nombre = pedirString("Ingrese Nombre");
        if (nombre == null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        String rut = pedirRut();
        if (rut == null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        String numeroTarjeta = pedirString("Ingrese Numero de Tarjeta");
        if (numeroTarjeta == null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        try {

            gestorDatos.agregarAlGestor(
                    new Cliente(nombre, rut, numeroTarjeta)
            );
            actualizarJTexArea();
            mostrarMensaje("Cliente registrado correctamente");

        } catch (DatosDuplicados e){

            mostrarMensaje(
                    "No se pudo registrar el cliente, ya existe"
            );

        }


    }

    public void solicitarTour(){
        String nombre = pedirString("Ingrese Nombre del Tour");
        if (nombre == null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        double duracion = pedirDouble("Ingrese Duracion");

        String tipoTour = pedirString("Ingrese Tipo de Tour");
        if (tipoTour == null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        String ubicacion = pedirString("Ingrese Ubicacion");
        if (ubicacion == null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }
        try {

            gestorDatos.agregarAlGestor(
                    new Tour(nombre, duracion, tipoTour, ubicacion)
            );
            actualizarJTexArea();
            mostrarMensaje("Tour registrado correctamente");

        } catch (DuracionInvalida e){

            mostrarMensaje(e.getMessage());

        } catch (DatosDuplicados e){

            mostrarMensaje(
                    "No se pudo registrar el tour, ya existe"
            );
        }
    }

    public void solicitarVehiculo(){

        String patente = pedirString("Ingrese Patente");
        if (patente == null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        Integer año = pedirInt("Ingrese Año");
        if (año == null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        String marca = pedirString("Ingrese Marca");
        if (marca == null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        String modelo = pedirString("Ingrese Modelo");
        if (modelo == null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        Integer capacPasajeros =
                pedirInt("Ingrese Capacidad de Pasajeros");

        if (capacPasajeros == null){
            mostrarMensaje("Operacion Cancelada");
            return;
        }

        try {

            gestorDatos.agregarAlGestor(
                    new Vehiculo(
                            patente,
                            año,
                            marca,
                            modelo,
                            capacPasajeros
                    )
            );
            actualizarJTexArea();
            mostrarMensaje("Vehículo registrado correctamente");

        } catch (DatosDuplicados e){

            mostrarMensaje(
                    "No se pudo registrar el vehículo, ya existe"
            );
        }
    }


    //metodo para buscar y cambiar comportamiento del boton
    public void buscar(){
        if (!modoBuscar) {
            modoBuscar = true;
            txtArea.setText("Modo Busqueda activado\n");
            btnBuscar.setText("Limpiar");
            String string;
            if(tipoVentana==TipoVentana.CLIENTES||tipoVentana==TipoVentana.GUIAS) {
                string = pedirRut();
            }else if(tipoVentana==TipoVentana.TOURS){
                string = pedirString("Nombre:");
            } else{
                string = pedirString("Patente:");
            }
            if (string==null){
                btnBuscar.setText("Buscar");
                actualizarJTexArea();
                modoBuscar = false;
                return;
            }

            try {
                txtArea.append(gestorDatos.buscarGestor(string,tipoVentana));
            }catch (NoExisteCoincidencia e){
                mostrarError("No existe Coincidencia con el valor buscado");
                btnBuscar.setText("Buscar");
                actualizarJTexArea();
                modoBuscar = false;
                return;
            }

        } else {

            btnBuscar.setText("Buscar");
            actualizarJTexArea();
            modoBuscar = false;
        }
    }


}