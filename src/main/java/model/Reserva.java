package model;

import java.util.ArrayList;
import java.util.List;

public class Reserva{
    private List<Tour> tours;
    private List<Cliente> clientes;
    private List<Vehiculo> vehiculos;
    private List<Guia> guias;


    //CONSTRUCTORES
    public Reserva() {
        tours = new ArrayList<>();
        clientes = new ArrayList<>();
        vehiculos = new ArrayList<>();
        guias = new ArrayList<>();
    }


    //gets y set (vere si los uso, sino los borrare para proteger datos)
    public List<Tour> getTours() {return tours;}
    public List<Cliente> getClientes() {return clientes;}
    public List<Vehiculo> getVehiculos() {return vehiculos;}
    public List<Guia> getGuias() {return guias;}


    public void setTours(List<Tour> tours) {this.tours = tours;}
    public void setClientes(List<Cliente> clientes) {this.clientes = clientes;}
    public void setVehiculos(List<Vehiculo> vehiculos) {this.vehiculos = vehiculos;}
    public void setGuias(List<Guia> guias) {this.guias = guias;}





}
