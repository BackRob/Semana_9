package model;
import model.Persona;
public class Cliente extends Persona {

    private String numeroTarjeta;

    @Override
    public String toString() {
        return super.toString() +
                "Numero de Tarjeta: "+this.numeroTarjeta;
    }
}
