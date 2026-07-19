package model;

import util.GestorDatos;
import util.TipoDato;

public class Tour implements IRegistrable{
    private String nombre;
    private double duracion;
    private String tipoTour;
    private String ubicacion;

    //CONSTRUCTORES

    public Tour(){
        this("SINNOMBRE",0.0,"SINTIPOTOUR","SINUBICACION");
    }

    public Tour(String nombre, double duracion, String tipoTour, String ubicacion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.tipoTour = tipoTour;
        this.ubicacion = ubicacion;
    }

    //GETS Y SETS
    public String getNombre() {return nombre;}
    public double getDuracion() {return duracion;}
    public String getTipoTour() {return tipoTour;}
    public String getUbicacion() {return ubicacion;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setDuracion(double duracion) {this.duracion = duracion;}
    public void setTipoTour(String tipoTour) {this.tipoTour = tipoTour;}
    public void setUbicacion(String ubicacion) {this.ubicacion = ubicacion;}


    //poliformismo
    @Override
    public void registrarEnReserva(Reserva reserva){
        reserva.getTours().add(this);
    }
    @Override
    public void registrarEnGestor(GestorDatos gestorDatos){gestorDatos.getDatos().add(this);}
    @Override
    public boolean esTipo(TipoDato tipoDato){return tipoDato==TipoDato.TOUR;}

    @Override
    public String toString(){
        return "[Tour]\n" +
                "Nombre: "+this.nombre+
                "\nDuracion: "+this.duracion+
                "\nTipo de Tour: "+this.tipoTour+
                "\nUbicacion: "+this.ubicacion+"\n";
    }
}
