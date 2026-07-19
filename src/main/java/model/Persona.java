package model;

import iu.TipoVentana;
import util.GestorDatos;

public abstract class Persona implements IRegistrable {

    private String nombre;
    private String rut;

    //CONSTRUCTOR
    public Persona(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    //GETS Y SETS
    public String getNombre() {return nombre;}
    public String getRut() {return rut;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setRut(String rut) {this.rut = rut;}



    @Override
    public String toString(){

        return "\nNombre: "+ this.nombre +
                "\nRut: "+this.rut+"\n";

    };
    public abstract boolean esTipo(TipoVentana tipoVentana);
    public abstract void registrarEnReserva(Reserva reserva);
    public abstract String getIdentificador();

}


