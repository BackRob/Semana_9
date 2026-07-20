package model;

import Exceptions.DatosDuplicados;
import iu.TipoVentana;

public class Cliente extends Persona {

    private String numeroTarjeta;


    //CONSTRUCTORES
    public Cliente(){
        this("SINNOMBRE","SINRUT","SINNUMEROTARJETA");
    }

    public Cliente(String nombre, String rut, String numeroTarjeta) {
        super(nombre, rut);
        this.numeroTarjeta = numeroTarjeta;
    }

    //GETS Y SETS
    public String getNumeroTarjeta() {return numeroTarjeta;}
    public void setNumeroTarjeta(String numeroTarjeta) {this.numeroTarjeta = numeroTarjeta;}




    //poliformismo
    @Override
    public void registrarEnReserva(Reserva reserva){
        if (!reserva.getClientes().contains(this)) {
            reserva.getClientes().add(this);
        }else{
            throw new DatosDuplicados("Cliente Duplicado");
        }
    }

    @Override
    public boolean esTipo(TipoVentana tipoVentana){return tipoVentana == TipoVentana.CLIENTES;}

    @Override
    public String getIdentificador() {
        return getRut();
    }

    @Override
    public String toString() {
        return "[Cliente]"+
                super.toString() +
                "Numero de Tarjeta: "+this.numeroTarjeta+"\n";
    }
}
