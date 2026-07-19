package model;

public class Vehiculo {
    private String patente;
    private int año;
    private String marca;
    private String modelo;
    private int capacPasajeros;

    @Override
    public String toString(){
        return "\n[Vehiculo]\n" +
                "Patente: "+this.patente+
                "\nAño: "+this.año+
                "\nMarca: "+this.marca+
                "\nModelo: "+this.modelo+
                "\nCapacidad Pasajeros: "+this.capacPasajeros+"\n";
    }

}
