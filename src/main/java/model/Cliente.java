package model;
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


    @Override
    public String toString() {
        return "\n[Cliente]\n"+
                super.toString() +
                "Numero de Tarjeta: "+this.numeroTarjeta+"\n";
    }
}
