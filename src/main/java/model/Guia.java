package model;

import iu.TipoVentana;

public class Guia extends Persona{

    private String tipoGuia;
    private String empresa;

    //CONSTRUCTORES

    public Guia(){
        this("SINNOMBRE","SINRUT","SINEMPRESA","SINTIPOGUIA");
    }

    public Guia(String nombre, String rut, String empresa, String tipoGuia) {
        super(nombre, rut);
        this.empresa = empresa;
        this.tipoGuia = tipoGuia;
    }

    //GETS Y SETS
    public String getTipoGuia() {return tipoGuia;}
    public String getEmpresa() {return empresa;}
    public void setTipoGuia(String tipoGuia) {this.tipoGuia = tipoGuia;}
    public void setEmpresa(String empresa) {this.empresa = empresa;}


    //Metodos interfaz
    @Override
    public boolean esTipo(TipoVentana tipoVentana){ //para verificar el tipo de dato
        return tipoVentana == tipoVentana.GUIAS;
    }

    @Override
    public void registrarEnReserva(Reserva reserva){ //metodo para poliformismo
        reserva.getGuias().add(this);
    }

    @Override//identificador para comparar
    public String getIdentificador(){
        return getRut();
    }


    @Override
    public String toString() {
        return "[Guia]" +
                super.toString()+
                " | Tipo Guia: "+ this.tipoGuia+
                " | Empresa: "+ this.empresa+"\n";
    }
}
