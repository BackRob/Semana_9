package model;
public class Cliente extends Persona {

    private String numeroTarjeta;

    @Override
    public String toString() {
        return "\n[Cliente]\n"+super.toString() +
                "Numero de Tarjeta: "+this.numeroTarjeta;
    }
}
