package util;

import model.IRegistrable;
import model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private List<IRegistrable>datos;
    private List<Reserva>reservas;

    //Constructor
    public GestorDatos(){
        datos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    //GETS Y SETS
    public List<IRegistrable> getDatos() {return datos;}
    public List<Reserva> getReservas() {return reservas;}
    public void setDatos(List<IRegistrable> datos) {this.datos = datos;}
    public void setReservas(List<Reserva> reservas) {this.reservas = reservas;}



    //Metodo para mostrarPorTipo (Devuelve String)
    public String mostrarPorTipo (TipoDato tipoDato){
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        if(datos!=null && !datos.isEmpty()){
            for(IRegistrable registrableAux:datos){
                if (registrableAux.esTipo(tipoDato)){
                    contador++;
                    sb.append(registrableAux);
                }

            }
        }else{
            //exception
        }
        return sb.toString();
    }

}
