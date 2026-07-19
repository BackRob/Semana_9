package util;

import Exceptions.DatosDuplicados;
import iu.TipoVentana;
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



    //Metodo para agregar
    public void agregarAlGestor(IRegistrable registrable)throws DatosDuplicados {

        for (IRegistrable aux : datos) {
            if (registrable.getIdentificador()
                    .equalsIgnoreCase(aux.getIdentificador())) {

                throw new DatosDuplicados(
                        "Ya existe un registro con ese identificador");
            }
        }

        datos.add(registrable);
    }

    //Metodo para mostrarPorTipo (Devuelve String)
    public String mostrarPorTipo (TipoVentana tipoVentana){
        StringBuilder sb = new StringBuilder();
        int contador = 0;
        if(!datos.isEmpty()){
            for(IRegistrable registrableAux:datos){
                contador++;
                if (registrableAux.esTipo(tipoVentana)){
                    sb.append("ID: ").append(contador-1).append(" | ").append(registrableAux);
                }
            }
        }else{
            return "Lista Vacia";
        }
        return sb.toString();
    }

    //Metodo para Agregar dependiento el tipo de ventana



}
