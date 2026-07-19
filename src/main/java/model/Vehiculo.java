package model;

import iu.TipoVentana;
import util.GestorDatos;
import util.TipoDato;

public class Vehiculo implements IRegistrable {
    private String patente;
    private int año;
    private String marca;
    private String modelo;
    private int capacPasajeros;

    //CONSTRUCTORES

    public Vehiculo(){
        this("SINPATENTE",0,"SINMARCA","SINMODELO",0);
    }

    public Vehiculo(String patente, int año, String marca, String modelo, int capacPasajeros) {
        this.patente = patente;
        this.año = año;
        this.marca = marca;
        this.modelo = modelo;
        this.capacPasajeros = capacPasajeros;
    }


    //SETS Y GETS
    public String getPatente() {return patente;}
    public int getAño() {return año;}
    public String getMarca() {return marca;}
    public String getModelo() {return modelo;}
    public int getCapacPasajeros() {return capacPasajeros;}
    public void setPatente(String patente) {this.patente = patente;}
    public void setAño(int año) {this.año = año;}
    public void setMarca(String marca) {this.marca = marca;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    public void setCapacPasajeros(int capacPasajeros) {this.capacPasajeros = capacPasajeros;}




    //SOBREESCRITURA
    @Override
    public String toString(){
        return "[Vehiculo]\n" +
                "Patente: "+this.patente+
                "\nAño: "+this.año+
                "\nMarca: "+this.marca+
                "\nModelo: "+this.modelo+
                "\nCapacidad Pasajeros: "+this.capacPasajeros+"\n";
    }



    //Poliformismo
    @Override
    public boolean esTipo(TipoVentana tipoVentana){return tipoVentana == tipoVentana.VEHICULOS;}

    @Override
    public String getIdentificador() {
        return getPatente();
    }

    @Override
    public void registrarEnReserva(Reserva reserva){
        reserva.getVehiculos().add(this);
    } //Registra en reserva

}
