package util;

import Exceptions.DatosDuplicados;
import Exceptions.NoExisteCoincidencia;
import iu.TipoVentana;
import model.Cliente;
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
        cargar();
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
        StringBuilder sb = new StringBuilder("----Listado----\n");
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

    //Metodo para buscar
    public String buscarGestor(String identificador,TipoVentana tipoVentana){
        for(IRegistrable registrableAux:datos){
            if (registrableAux.esTipo(tipoVentana)&& identificador.equalsIgnoreCase(registrableAux.getIdentificador())) {
                return registrableAux.toString();
            }
        }
        throw new NoExisteCoincidencia("No se encontro Coincidencia");
    }

    //metodo para cargar datos y probar
    private void cargar(){
        agregarAlGestor(new Cliente("Brian Vallejos","11111111-1","232312123"));
        agregarAlGestor(new Cliente("Brian castro","22222222-2","2323123"));
        agregarAlGestor(new Cliente("Brian johan","33333333-3","223123"));
    }


}
