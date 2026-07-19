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

    //metodo para recorrer y mostrar
    public String mostrar(){
        StringBuilder sb = new StringBuilder();

        if(clientes!=null && !clientes.isEmpty()){
        sb.append("[RESERVA: \"").append(clientes.get(0).getNombre()).append("\"]\n");
        }else {
            sb.append("[Reserva: \"SINNOMBRE\"]\n");
        }

        int contadorT = 0;
        int contadorC = 0;
        int contadorV = 0;
        int contadorG = 0;
        sb.append("----Tours----\n");
        for(Tour tourAux : tours){
            contadorT++;
            sb.append(contadorT).append(".-").append(tourAux).append("\n");
        }
        sb.append("--------\n");
        sb.append("----Clientes----\n");
        for (Cliente clienteAux : clientes){
            contadorC++;
            sb.append(contadorC).append(".-").append(clienteAux).append("\n");
        }
        sb.append("--------\n");
        sb.append("----Vehiculos----\n");
        for (Vehiculo vehiculoAux : vehiculos){
            contadorV++;
            sb.append(contadorV).append(".-").append(vehiculoAux).append("\n");
        }
        sb.append("--------\n");
        sb.append("----Guias----\n");
        for (Guia guiaAux : guias){
            contadorG++;
            sb.append(contadorG).append(".-").append(guiaAux).append("\n");
        }
        sb.append("--------\n");
        return sb.toString();

    }





}
