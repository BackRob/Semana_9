package model;

public abstract class Persona {

    private String nombre;
    private String rut;

    @Override
    public String toString(){

        return "Nombre: "+ this.nombre +
                "\nRut: "+this.rut+"\n";

    };
}
