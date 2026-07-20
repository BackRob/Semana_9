package model;

import Exceptions.DatosDuplicados;
import Exceptions.DuracionInvalida;
import iu.TipoVentana;
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

    public Tour(String nombre, double duracion, String tipoTour, String ubicacion){
        if (duracion <= 0) {
            throw new DuracionInvalida("La Duracion debe ser mayor a 0");
        }

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
        boolean encontrado=false;
        for (Tour tour:reserva.getTours()){
            if (this==tour){
                encontrado=true;
            }
        }
        if (encontrado==false){
        reserva.getTours().add(this);
        }else{
            throw new DatosDuplicados("Tour Duplicado");
        }
    }
    @Override
    public boolean esTipo(TipoVentana tipoVentana){return tipoVentana==tipoVentana.TOURS;}

    @Override
    public String getIdentificador() {
        return getNombre();
    }

    @Override
    public String toString(){
        return "[Tour] | " +
                "Nombre: "+this.nombre+
                " | Duracion: "+this.duracion+
                " |Tipo de Tour: "+this.tipoTour+
                " | Ubicacion: "+this.ubicacion+"\n";
    }
}
