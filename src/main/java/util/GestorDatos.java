package util;

import Exceptions.DatosDuplicados;
import Exceptions.NoExisteCoincidencia;
import Exceptions.RecursoNoDisponible;
import iu.TipoVentana;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private List<IRegistrable>datos;
    private List<Reserva>reservas;

    //Constructor
    public GestorDatos(){
        datos = new ArrayList<>();
        reservas = new ArrayList<>();
        cargar();
    }

    //GETS Y SETS
    public List<IRegistrable> getDatos() {return datos;}
    public List<Reserva> getReservas() {return reservas;}
    public void setDatos(List<IRegistrable> datos) {this.datos = datos;}
    public void setReservas(List<Reserva> reservas) {this.reservas = reservas;}




    //Metodo para agregar
    public void agregarAlGestor(IRegistrable registrable)throws DatosDuplicados {

        for (IRegistrable aux : datos) {
            if (registrable.getIdentificador()
                    .equalsIgnoreCase(aux.getIdentificador())) {

                throw new DatosDuplicados(
                        "Ya existe un registro con ese identificador");
            }
        }

        datos.add(registrable);
    }

    //Metodo para mostrarPorTipo (Devuelve String)
    public String mostrarPorTipo(TipoVentana tipoVentana){
        StringBuilder sb = new StringBuilder("----Listado----\n");
        if(tipoVentana == TipoVentana.RESERVAS){
            if(reservas.isEmpty()){
                return "Lista Vacia";
            }
            int id = 0;
            for(Reserva reserva : reservas){
                sb.append("\n\nID: ")
                        .append(id++)
                        .append(" | ")
                        .append(reserva.mostrar())
                        .append("\n");
            }
            return sb.toString();
        }
        int contador = 0;
        if(!datos.isEmpty()){
            for(IRegistrable registrableAux : datos){
                contador++;
                if(registrableAux.esTipo(tipoVentana)){

                    sb.append("ID: ")
                            .append(contador - 1)
                            .append(" | ")
                            .append(registrableAux);
                }
            }
        }else{
            return "Lista Vacia";
        }
        return sb.toString();
    }

    //Metodo para buscar
    public String buscarGestor(String identificador,TipoVentana tipoVentana){
        for(IRegistrable registrableAux:datos){
            if (registrableAux.esTipo(tipoVentana)&& identificador.equalsIgnoreCase(registrableAux.getIdentificador())) {
                return registrableAux.toString();
            }
        }
        throw new NoExisteCoincidencia("No se encontro Coincidencia");
    }

    //metodo para cargar datos y probar
    private void cargar(){
        agregarAlGestor(new Cliente("Brian Vallejos","11111111-1","232312123"));
        agregarAlGestor(new Cliente("Brian castro","22222222-2","2323123"));
        agregarAlGestor(new Cliente("Brian johan","33333333-3","223123"));
        agregarAlGestor(new Vehiculo("ERTY43",2020,"NISSAN","TIDA",4));//Descontando conductor
        agregarAlGestor(new Vehiculo("ERTY42",2020,"Yamaha","R6",1));
        agregarAlGestor(new Guia("Cristian Lizana","55555555-3","Llanquigue Tour","Escalada"));
        agregarAlGestor(new Guia("Cristian Pablaza","55555555-4","Llanquigue Tour","Turistico"));
        agregarAlGestor(new Guia("Cristian Quezada","55555555-5","Llanquigue Tour","Turistico"));
        agregarAlGestor(new Tour("Volcan Osorno", 6.5, "Montaña", "Puerto Varas"));
        agregarAlGestor(new Tour("Saltos del Petrohue", 3.0, "Naturaleza", "Ensenada"));
        agregarAlGestor(new Tour("Lago Todos los Santos", 4.5, "Navegacion", "Puerto Varas"));
        agregarAlGestor(new Tour("Trekking Alerce Andino", 7.0, "Aventura", "Puerto Montt"));
        agregarAlGestor(new Tour("Circuito Frutillar", 2.5, "Cultural", "Frutillar"));
        agregarAlGestor(new Tour("Termas de Puyehue", 8.0, "Relax", "Osorno"));
        agregarAlGestor(new Tour("Isla Tenglo", 2.0, "Historico", "Puerto Montt"));
        agregarAlGestor(new Tour("Parque Nacional Vicente Perez Rosales", 5.5, "Ecoturismo", "Puerto Varas"));
        agregarAlGestor(new Tour("Kayak Rio Maullin", 4.0, "Aventura", "Maullin"));
        agregarAlGestor(new Tour("Ruta Patrimonial de Chiloe", 10.0, "Cultural", "Castro"));

        Reserva r1 = crearReserva("2026-08-10");
        agregarAReserva(TipoVentana.CLIENTES, 0, r1);
        agregarAReserva(TipoVentana.GUIAS, 5, r1);
        agregarAReserva(TipoVentana.TOURS, 8, r1);

        Reserva r2 = crearReserva("2026-08-10");
        agregarAReserva(TipoVentana.CLIENTES, 1, r2);
        agregarAReserva(TipoVentana.GUIAS, 6, r2);
        agregarAReserva(TipoVentana.VEHICULOS, 3, r2);
        agregarAReserva(TipoVentana.TOURS, 9, r2);

        Reserva r3 = crearReserva("2026-08-11");
        agregarAReserva(TipoVentana.CLIENTES, 2, r3);
        agregarAReserva(TipoVentana.GUIAS, 7, r3);
        agregarAReserva(TipoVentana.VEHICULOS, 4, r3);
        agregarAReserva(TipoVentana.TOURS, 10, r3);
        agregarAReserva(TipoVentana.TOURS, 11, r3);

    }



    //metodo para mostrar datos con disponibilidad
    public String obtenerGuiasDisponibles(String fecha) {
        StringBuilder disponibles = new StringBuilder();
        int contador=0;
        int idDatos=-1;
        for (IRegistrable dato : datos) {
            idDatos++;
            if (dato instanceof Guia guia) {
                boolean ocupado = false;
                for (Reserva reserva : reservas) {
                    if (reserva.getFecha().equals(fecha)
                            && reserva.getGuias().contains(guia)) {
                        ocupado = true;
                        break;
                    }
                }
                if (!ocupado) {
                    contador++;
                    disponibles.append("iD: ").append(idDatos).append("|");
                    disponibles.append(guia.getNombre()).append(" - ").append(guia.getRut()).append("\n");
                }
            }
        }
        if (contador==0){
            throw new RecursoNoDisponible("Guias no Disponibles para la fecha seleccionada");
        }

        return disponibles.toString();
    }

    public String obtenerClientesDisponibles(String fecha) {
        StringBuilder disponibles = new StringBuilder();
        int contador=0;
        int idDatos =-1;
        for (IRegistrable dato : datos) {
            idDatos++;
            if (dato instanceof Cliente cliente) {
                boolean ocupado = false;
                for (Reserva reserva : reservas) {
                    for (Cliente c : reserva.getClientes()) {
                        if(reserva.getFecha().equals(fecha)
                            && reserva.getClientes().contains(cliente)){
                            ocupado = true;
                            break;
                        }
                    }

                }
                if (!ocupado) {
                    contador++;
                    disponibles.append("iD: ").append(idDatos).append("|");
                    disponibles.append(cliente.getNombre()).append("-").append(cliente.getRut()).append("\n");
                }
            }
        }

        if (contador==0){
            throw new RecursoNoDisponible("Clientes no Disponibles para la fecha seleccionada");
        }
        return disponibles.toString();
    }




    public String obtenerVehiculosDisponibles(String fecha){
        int contador = 0;
        int idDatos=-1;
        StringBuilder disponibles = new StringBuilder();
        for(IRegistrable dato : datos){
            idDatos++;
            if(dato instanceof Vehiculo vehiculo){
                boolean ocupado = false;
                for(Reserva reserva : reservas){
                    if(reserva.getFecha().equals(fecha)
                            && reserva.getVehiculos().contains(vehiculo)){
                        ocupado = true;
                        break;
                    }
                }
                if(!ocupado){
                    disponibles.append("iD: ").append(idDatos).append("|");
                            disponibles.append(vehiculo.getPatente()).append("-Capacidad: ").append(vehiculo.getCapacPasajeros()).append("\n");
                    contador++;
                }
            }
        }
        if (contador==0){
            throw new RecursoNoDisponible("Vehiculos No Disponibles para la fecha seleccionada");
        }
        return disponibles.toString();
    }

    public void agregarAReserva(TipoVentana tipoVentana,Integer id,Reserva reserva){

        if (id < 0 || id >= datos.size()) {
            throw new NoExisteCoincidencia(
                    "No existe coincidencia con el ID ingresado");
        }
        if(datos.get(id).esTipo(tipoVentana)){
             datos.get(id).registrarEnReserva(reserva);
        }else{
            throw new NoExisteCoincidencia("No Existe coincidencia con el ID Ingresado");
        }
    }
    public boolean verificarCapacidad(Reserva reserva) {
        int capacidad = 0;
        for (Vehiculo vehiculo : reserva.getVehiculos()) {
            capacidad = vehiculo.getCapacPasajeros() + capacidad;
        }
        return reserva.getClientes().size() < capacidad;
    }

    public Reserva crearReserva(String fecha){
        Reserva reserva;
        reservas.add(reserva = new Reserva(fecha));
        return reserva;
    }
    public boolean verificarGuias(Reserva reserva){
        int guiasNecesarios;
        if(reserva.getVehiculos().isEmpty()){
            guiasNecesarios = 1;
        }else{
            guiasNecesarios = reserva.getVehiculos().size();
        }
        return reserva.getGuias().size() >= guiasNecesarios;
    }

    public int cuantosGuiasFaltan(Reserva reserva){
        int guiasNecesarios;
        if(reserva.getVehiculos().isEmpty()){
            guiasNecesarios = 1;
        }else{
            guiasNecesarios = reserva.getVehiculos().size();
        }
        return guiasNecesarios - reserva.getGuias().size();
    }
    public boolean verificarTours(Reserva reserva){
        return !reserva.getTours().isEmpty();
    }

    public String obtenerToursDisponibles(Reserva reserva){

        StringBuilder sb = new StringBuilder();
        int contador = 0;
        int idDatos = -1;
        for(IRegistrable dato : datos){
            idDatos++;
            if(dato instanceof Tour tour){
                if(!reserva.getTours().contains(tour)){
                    contador++;
                    sb.append("ID: ")
                            .append(idDatos)
                            .append("|")
                            .append(tour.getNombre())
                            .append(" - ")
                            .append(tour.getUbicacion())
                            .append("\n");
                }
            }
        }
        if(contador == 0){
            throw new RecursoNoDisponible(
                    "No quedan tours disponibles para agregar");
        }
        return sb.toString();
    }
}
