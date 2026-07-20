package model;

import iu.TipoVentana;
import util.GestorDatos;

public interface IRegistrable {
    String toString();
    void registrarEnReserva(Reserva reserva);
    boolean esTipo(TipoVentana tipo);
    String getIdentificador();

}
